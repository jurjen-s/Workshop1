/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author jurjen
 */
public class SQLConnection {
    
    private static final Logger LOGGER = LogManager.getLogger(SQLConnection.class);
    
    public static Connection getSQLConnection() {       
    // nieuwe connectie aanmaken met try-with-resources: 
    // try (Connection x = database.access.ConnectionManager.SQLConnection()) 
    // waarbij x aangeeft om welke connectie het gaat
            Connection sqlconnectie = null;
            // Define host and username/password
            String host = "jdbc:mysql://localhost:3306/mydb";
            String userName = "admin";
            String userPass = "admin";
            // Try to load the driver
            try {                
                Class.forName("com.mysql.cj.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
		LOGGER.error("MySQL Driver niet gevonden.");
		ex.printStackTrace();
                }
            }
            // Try to establish connection
            try {
                sqlconnectie = DriverManager.getConnection(host, userName, userPass);
            } catch (SQLException ex) {
                LOGGER.error("Geen verbinding met de MySQL database verkregen.");
                ex.getMessage();
            }
            LOGGER.info("Verbonden met de MySQL database.");
        return sqlconnectie;
        }
}