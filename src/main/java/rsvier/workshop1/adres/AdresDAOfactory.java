/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

import java.sql.Connection;
import rsvier.workshop1.account.AccountFireBirdSQL;
import rsvier.workshop1.account.AccountMySQL;
import rsvier.workshop1.account.AccountSQL;
import rsvier.workshop1.db.DbConfigurator;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author Frank
 */
public class AdresDAOfactory {
      //Hier komt de DAO factory voor de keuze firebird of mysql.
    
   SQLConnection connectie= new SQLConnection();
   Connection sqlconnectie = connectie.getSQLConnection();
   
    
    
    
     public AdresSQL getAdresDAO(){
         
         //TESTSTRING!:
         //String type = "MySQL";
         
         
         //DIT MOET NIET VERWIJDERD WORDEN
        
         
         
         
        
        String type = DbConfigurator.getDbConfigurator().getDbType();
        System.out.println(type);
        
        //geeft de string "MySQL" of "Firebird" uit de XML bestand.
        
        
        
        label:
        while(true){
        if (type.equalsIgnoreCase("MYSQL")) {
           System.out.println("MySQL is de database");
             AdresSQL mysql = new AdresMySQL(sqlconnectie);
             
             return mysql;
             //return new AccountMySQLSQL;  
          //  return new AccountSQL();    
        } else if (type.equalsIgnoreCase("Firebird")) {
            System.out.println("Firebird is de database");
                return new AdresFireBirdSQL();
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
        
        
         
       
        

