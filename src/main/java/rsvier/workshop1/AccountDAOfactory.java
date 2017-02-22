/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;

/**
 *
 * @author Frank
 */


public class AccountDAOfactory {
    //Hier komt de DAO factory voor de keuze firebird of mysql.
    
   SQLConnection connectie= new SQLConnection();
   Connection sqlconnectie = connectie.getSQLConnection();
   
    
    
    
     public AccountSQL getAccountDAO(){
         
         //TESTSTRING!:
         //String type = "MySQL";
         
         
         //DIT MOET NIET VERWIJDERD WORDEN
        
         
         
         
        
        String type = Connector.getConnector().getDbType();
        System.out.println(type);
        
        //geeft de string "MySQL" of "Firebird" uit de XML bestand.
        
        
        
        label:
        while(true){
        if (type.equalsIgnoreCase("MYSQL")) {
           System.out.println("MySQL is de database");
             AccountSQL mysql = new AccountMySQL(sqlconnectie);
             
             return mysql;
             //return new AccountMySQLSQL;  
          //  return new AccountSQL();    
        } else if (type.equalsIgnoreCase("Firebird")) {
            System.out.println("Firebird is de database");
                return new AccountFireBirdSQL();
        }
        else{ //Zoekt een default
        System.out.println("geen SQL config gegeven: type Firebird of MySQL of overige");
        System.out.println("We nemen de default db met MySQL");
          type =  "";
          
        Connector connector = Connector.getConnector();
        
        
        connector.setDatabase(type);
        
        type = connector.getDbType();
        
       
        }
        
         
       
        }
        
        
       
          
     
    
    
    
}
}
