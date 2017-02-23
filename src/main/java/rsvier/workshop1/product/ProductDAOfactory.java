/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.product;

import java.sql.Connection;
import rsvier.workshop1.db.Connector;
import rsvier.workshop1.db.DbConfigurator;

/**
 *
 * @author Frank
 */
public class ProductDAOfactory {
     // DAOfactory vraagt Connector om een connectie te geven (Connector doet dat op basis van databasetype)
    // Factory kijkt naar ingesteld databasetype en geeft de juiste implementatie van de DAO terug
    // Factory geeft wel supertype (de DAO) van die implemenatie terug
    private Connector connector = new Connector();
    private Connection connectie = connector.getConnection();
    private DbConfigurator dbConfigurator = DbConfigurator.getDbConfigurator();
    
    public ProductDAO getProductDAO() {
        String type = dbConfigurator.getDbType();
        if (type.equals("MYSQL")) {
            return new ProductMySQL(connectie);
        } else if (type.equals("FIREBIRD")) {
            return new ProductFireBird(connectie);
        }
        return null;        
    }
}
