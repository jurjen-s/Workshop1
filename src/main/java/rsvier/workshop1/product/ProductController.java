/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.product;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author jurjen
 */
public class ProductController {
    
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private ProductDAO productDAO = new ProductSQL(sqlConnectie);
    
    public Product findProductById(int productId) {
        Product product = productDAO.findProductById(productId);
        return product;
    }
    public List findProductBySoort(String soort) {
        List<Product> zoekresultaat = productDAO.findProductBySoort(soort);
        return zoekresultaat;
    }
    public List findProductByPrijs(BigDecimal prijs) {
        List<Product> zoekresultaat = productDAO.findProductByPrijs(prijs);
        return zoekresultaat;
    }
    public List findProductByVoorraad(int voorraad) {
        List<Product> zoekresultaat = productDAO.findProductByVoorraad(voorraad);
        return zoekresultaat;
    }
    
    public boolean toevoegenProduct(Product product) {
        return productDAO.toevoegenProduct(product);
    }
    
    public boolean updateProductOmschrijving(int productId, String omschrijving) {
        return productDAO.updateProductOmschrijving(productId, omschrijving);
    }
    public boolean updateProductSoort(int productId, String soort) {
        return productDAO.updateProductSoort(productId, soort);
    }
    public boolean updateProductPrijs(int productId, BigDecimal prijs) {
        return productDAO.updateProductPrijs(productId, prijs);
    }
    public boolean updateProductVoorraad(int productId, int voorraad) {
        return productDAO.updateProductVoorraad(productId, voorraad);
    }
    
    public boolean deleteProduct(int productId) {
        return productDAO.deleteProduct(productId);
    }
    
    
    
}
