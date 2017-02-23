/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.account;

import java.sql.Connection;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author Frank
 */
public class AccountController {
    
    
    
    
    
    AccountDAOfactory factory = new AccountDAOfactory();
    
    
    
    
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    
    
    private AccountDAO accountDAO = new AccountMySQL(sqlConnectie);
    
   // private AccountMenu accountmenu = new AccountMenu();
    
    
    
    //
    Account findAccountByID(int id){
      
        Account accountNaarMenu = new Account();
        
        accountNaarMenu = (factory.getAccountDAO()).findAccountByID(id);
        
        return accountNaarMenu;
        
    }
    
    
    
    
    
    Account createAccount(int type, String wachtwoord){
        
       Account accountinfo = new Account();
        
        accountinfo = (factory.getAccountDAO()).createAccount(type, wachtwoord);
        
        return accountinfo;
        
    }
    
    
    boolean deleteAccount(int id){
        
        boolean accountNaarMenu2 ;
        
        accountNaarMenu2 = (factory.getAccountDAO()).deleteAccount(id);
        
        return accountNaarMenu2;
        
        
    }
    
    
    boolean updateAccountType(int id, int type){
        
        boolean accountNaarMenu3;
        
        accountNaarMenu3 = (factory.getAccountDAO()).updateAccountType(id, type);
        
        return accountNaarMenu3;
        
    }
    
    
    boolean updateAccountWachtwoord(int id, String wachtwoord){
    
    boolean accountNaarMenu3;
        
        accountNaarMenu3 = (factory.getAccountDAO()).updateAccountWachtwoord(id, wachtwoord);
        
        return accountNaarMenu3;
    }
    
    
    boolean loginCheckAccount(int id, String wachtwoord){
    
    boolean accountNaarMenu4;
        
        accountNaarMenu4 = (factory.getAccountDAO()).loginCheckAccount(id, wachtwoord);
        
        
        
        return accountNaarMenu4;
    }
    
    
    
}
