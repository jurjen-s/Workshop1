/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import static rsvier.workshop1.db.DbConfigurator.getDbConfigurator;

/**
 *
 * @author jurjen
 */
public class Connector {
    
    private DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
    private Logger LOGGER = LogManager.getLogger(Connector.class);
    
    public Connection getConnection() {
        if (dbConfigurator.getDbType().equals("MYSQL")) {
            return getMySQLConnection();
        } else {
            return getFirebirdConnection();
        }
    }

    private Connection getMySQLConnection() {
        try {
            Class.forName(dbConfigurator.getDbDriver());
        } catch (ClassNotFoundException ex) {
            LOGGER.error("Driver niet gevonden." + ex.getMessage());
        }
        try {
            String host = dbConfigurator.getDbHost();
            String user = dbConfigurator.getDbUsername();
            String pass = dbConfigurator.getDbUserpass();
            return DriverManager.getConnection(host, user, pass);
        } catch (SQLException ex) {
            LOGGER.error("Geen verbinding gekregen." + ex.getMessage());
            return null;
        }
    }

    private Connection getFirebirdConnection() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
