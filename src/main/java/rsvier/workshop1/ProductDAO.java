/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jurjen
 */
public interface ProductDAO {
    
    // Functies:
    // 1: Om producten te zoeken:
    Product findProductById(int productId); // returns Product object als zoekresultaat
    List findProductBySoort(String soort); // returns List<Product> met zoekresultaten
    List findProductByPrijs(BigDecimal prijs); // returns List<Product> met zoekresultaten
    List findProductByVoorraad(int voorraad); // returns List<Product> met zoekresultaten
    // 2: Om producten toe te voegen:
    boolean toevoegenProduct(Product product); // returns succes of mislukt (of return: vernieuwd product?)
    // 3: Om producten aan te passen:
    boolean updateProductOmschrijving(int productId, String omschrijving); // returns succes of mislukt (of return: vernieuwd product?)
    boolean updateProductSoort(int productId, String soort); // returns succes of mislukt (of return: vernieuwd product?)
    boolean updateProductPrijs(int productId, BigDecimal prijs); // returns succes of mislukt (of return: vernieuwd product?)
    boolean updateProductVoorraad(int productId, int voorraad); // returns succes of mislukt (of return: vernieuwd product?)
    // 4: Om producten te verwijderen:
    boolean deleteProduct(int productId); // returns succes of mislukt (of return: vernieuwd product?)
    
}
