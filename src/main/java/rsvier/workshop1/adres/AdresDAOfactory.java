/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

import java.sql.Connection;
import rsvier.workshop1.account.AccountFirebird;
import rsvier.workshop1.account.AccountMySQL;
import rsvier.workshop1.adres.AdresDAO;
import rsvier.workshop1.db.Connector;
import rsvier.workshop1.db.DbConfigurator;
import rsvier.workshop1.db.Connector;

/**
 *
 * @author Frank
 */
public class AdresDAOfactory {
      //Hier komt de DAO factory voor de keuze firebird of mysql.
    
    // DAOfactory vraagt Connector om een connectie te geven (Connector doet dat op basis van databasetype)
    // Factory kijkt naar ingesteld databasetype en geeft de juiste implementatie van de DAO terug
    // Factory geeft wel supertype (de DAO) van die implemenatie terug
    private Connector connector = new Connector();
    private Connection connectie = connector.getConnection();
    private DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
    
    
    
    
    
    
     public AdresDAO getAdresDAO(){
         
        
        String type = dbConfigurator.getDbType();
        if (type.equalsIgnoreCase("MYSQL")) {
            return new AdresMySQL(connectie);
        } else if (type.equalsIgnoreCase("FIREBIRD")) {
            return new AdresFireBird(connectie);
        }
        return null;        
    }   
}  
        
        
        
        
        
         
       
        

