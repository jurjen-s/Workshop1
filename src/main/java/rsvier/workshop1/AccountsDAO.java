/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;

/**
 *
 * @author Frank
 */
public interface AccountsDAO {
    
    //deze 3 worden in menu gebruikt
    void findAccountByID(int id);
    void CreateAccount(String type, String wachtwoord);
    void DeleteAccount(int id);
    void UpdateAccountType(int id, String type);
    
    
    // deze alleen in log in menu.
    void AccountLoginCheck(int id, String wachtwoord);
    
      
}
