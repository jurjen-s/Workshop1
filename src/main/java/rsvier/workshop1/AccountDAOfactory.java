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
    
   
    
    
    
     public static AccountSQL getAccountDAO(){
        String type = ConfigDB.getDbType();
        //geeft de string "MySQL" of "Firebird" uit de XML bestand.
        
        if (type.equals("MySQL")) {
           
           //  AccountSQL mysql = new AccountMySQLSQL();
             
           //  return mysql;
             //return new AccountMySQLSQL;  
            return new AccountSQL();    
        } else if (type.equals("Firebird")) {
                return new AccountFireBirdSQL();
        }
        System.out.println("geen SQL config gegeven: type Firebird of MySQL of overige");
        return new AccountSQL();
        
    }
    
    
    
    
    
    
    
    
}
