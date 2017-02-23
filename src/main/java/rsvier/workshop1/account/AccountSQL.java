/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.account;

/**
 *
 * @author Frank
 */
public abstract class AccountSQL {
    // de koepel tussen FireBird en MySQl en eventueel anderen.
    
 
    
    
    
    abstract Account findAccountByID(int id);
    
    abstract Account createAccount(int type, String wachtwoord);
    abstract boolean deleteAccount(int id);
    abstract boolean updateAccountType(int id, int type);
    abstract boolean updateAccountWachtwoord(int id, String wachtwoord);
    
    // deze alleen in log in menu.
    abstract boolean loginCheckAccount(int id, String wachtwoord);
    
    
}
