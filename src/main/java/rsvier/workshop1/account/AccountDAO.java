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

public interface AccountDAO {
    
    //deze 3 worden in menu gebruikt
    Account findAccountByID(int id);
    Account createAccount(int type, String wachtwoord);
    boolean deleteAccount(int id);
    boolean updateAccountType(int id, int type);
    boolean updateAccountWachtwoord(int id, String wachtwoord);
    
    // deze alleen in log in menu.
    boolean loginCheckAccount(int id, String wachtwoord);
    
      
}
