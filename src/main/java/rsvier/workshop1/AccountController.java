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
public class AccountController {
    
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    
    
    private AccountDAO accountDAO = new AccountSQL(sqlConnectie);
    
   // private AccountMenu accountmenu = new AccountMenu();
    
    
    
    
    //
    Account findAccountByID(int id){
      
        Account accountNaarMenu = new Account();
        
        accountNaarMenu = accountDAO.findAccountByID(id);
        
        return accountNaarMenu;
        
    }
    
    
    
    
    
    
    
    
    
    Account createAccount(int type, String wachtwoord){
        
       Account accountinfo = new Account();
        
        accountinfo = accountDAO.createAccount(type, wachtwoord);
        
        return accountinfo;
        
    }
    
    
    
    
    boolean deleteAccount(int id){
        
        boolean accountNaarMenu2 ;
        
        accountNaarMenu2 = accountDAO.deleteAccount(id);
        
        return accountNaarMenu2;
        
        
    }
    
    
    
    
    
    
    
    
    boolean updateAccountType(int id, int type){
        
        boolean accountNaarMenu3;
        
        accountNaarMenu3 = accountDAO.updateAccountType(id, type);
        
        return accountNaarMenu3;
        
    }
    
    
    
    
    
    
    
    
    
    
    boolean updateAccountWachtwoord(int id, String wachtwoord){
    
    boolean accountNaarMenu3;
        
        accountNaarMenu3 = accountDAO.updateAccountWachtwoord(id, wachtwoord);
        
        return accountNaarMenu3;
    }
    
   
    
    
    boolean loginCheckAccount(int id, String wachtwoord){
    
    boolean accountNaarMenu4;
        
        accountNaarMenu4 = accountDAO.loginCheckAccount(id, wachtwoord);
        
        
        
        return accountNaarMenu4;
    }
    
    
    
    
    
    
    
}
