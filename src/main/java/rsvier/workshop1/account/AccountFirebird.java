/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.account;

import java.sql.Connection;

/**
 *
 * @author Frank
 */
public class AccountFirebird implements AccountDAO {
    
    // Elke implementatie van de DAO krijgt een connectie mee in zijn constructor
    private Connection accountconnectie;
    public AccountFirebird(Connection connectie) {
        
        this.accountconnectie = connectie;
    }
    @Override
    public Account findAccountByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Account createAccount(int type, String wachtwoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteAccount(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAccountType(int id, int type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateAccountWachtwoord(int id, String wachtwoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loginCheckAccount(int id, String wachtwoord) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 // hier komt de firebird sql van account.   
}
