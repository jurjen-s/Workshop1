/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package rsvier.workshop1.account;

import java.sql.Connection;
import rsvier.workshop1.db.Connector;
import rsvier.workshop1.db.DbConfigurator;
import rsvier.workshop1.db.SQLConnection;

/**
*
* @author Frank
*/


public class AccountDAOfactory {
    private Connector connector = new Connector();
    private Connection connectie = connector.getConnection();
    private DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
    
    public AccountDAO getAccountDAO() {
        String type = dbConfigurator.getDbType();
        if (type.equals("MYSQL")) {
            return new AccountMySQL(connectie);
        } else if (type.equals("FIREBIRD")) {
            return new AccountFirebirdSQL(connectie);
        }
        return null;        
    }
}   

