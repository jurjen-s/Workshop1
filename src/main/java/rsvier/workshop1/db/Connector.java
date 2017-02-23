/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.zaxxer.hikari.HikariDataSource;

/**
 *
 * @author jurjen
 */
public class Connector {
    
    private DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
    String host = dbConfigurator.getDbHost();
    String user = dbConfigurator.getDbUsername();
    String pass = dbConfigurator.getDbUserpass();
    private Logger LOGGER = LogManager.getLogger(Connector.class);
    
    public Connection getConnection() {
        if (dbConfigurator.getConnType().equals("JDBC")) {
            return getJDBCConnection();
        } else if (dbConfigurator.getConnType().equals("HIKARICP")) {
            return getDataSource();
        } else {
            LOGGER.error("Geen connectie kunnen vinden.");
            return null;
        }
    }

    private Connection getJDBCConnection() {
        try { 
            Class.forName(dbConfigurator.getDbDriver());
        } catch (ClassNotFoundException e) {
            LOGGER.info("MySQL Driver niet gevonden. Probeer oudere versie.");
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                LOGGER.error("Geen MySQL Driver gevonden." + ex.getMessage());
                return null;
            }
        }
        try {
            return DriverManager.getConnection(host, user, pass);
        } catch (SQLException ex) {
            LOGGER.error("Geen JDBC verbinding." + ex.getMessage());
            return null;
        }
    }

    private Connection getDataSource() {
        try {
            HikariDataSource ds = new HikariDataSource();
            ds.setJdbcUrl(host);
            ds.setUsername(user);
            ds.setPassword(pass);
            return ds.getConnection();
        } catch (SQLException ex) {
            LOGGER.error("Geen Hikari verbinding." + ex.getMessage());
            return null;
        }
    }
}
