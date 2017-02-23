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
         
        
        
        String type = DbConfigurator.getDbConfigurator().getDbType();
        System.out.println(type);
        
        //geeft de string "MySQL" of "Firebird" uit de XML bestand.
        
        
        
        label:
        while(true){
        if (type.equalsIgnoreCase("MYSQL")) {
           System.out.println("MySQL is de database");
             AdresDAO mysql = new AdresMySQL(connectie);
             
             return mysql;
             //return new AccountMySQLSQL;  
          //  return new AccountSQL();    
        } else if (type.equalsIgnoreCase("Firebird")) {
            System.out.println("Firebird is de database");
                return new AdresFireBird();
        }
        else{ //Zoekt een default
        System.out.println("geen SQL config gegeven: type Firebird of MySQL of overige");
        System.out.println("We nemen de default db met MySQL");
          type =  "";
          
        DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
        
        
        dbConfigurator.setDatabase(type);
        
        type = dbConfigurator.getDbType();
        
        }
        }
     }
}
        
        
         
       
        

