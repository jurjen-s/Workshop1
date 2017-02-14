/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jurjen
 */
public class ProductSQL implements ProductDAO {
    
     private static final Logger LOGGER = LogManager.getLogger(MedewerkerSQL.class);
    // Functies:
    // 1: Om producten te zoeken:
    //      1.1: findProductByID(int productId); - returns Product object als zoekresultaat
    //      1.2: findProductBySoort(String soort); - returns List<Product> met zoekresultaten
    //      1.3: findProductByPrijs(BigDecimal Prijs); - returns List<Product> met zoekresultaten
    //      1.4: findProductByVoorraad(int voorraad); - returns List<Product> met zoekresultaten
    // 2: Om producten toe te voegen:
    //      // De functie bij 2.1 heeft een in de view aangemaakt Product Object nodig
    //      2.1: toevoegenProduct(Product product) - returns succes of mislukt (of return: vernieuwd product?)
    // 3: Om producten aan te passen:
    //      // De functies hieronder hebben een productId (of Product Object? nog niet geimplementeerd) nodig
    //      3.1: updateProductOmschrijving(int productId, String omschrijving); - returns succes of mislukt (of return: vernieuwd product?)
    //      3.2: updateProductSoort(int productId, String soort); - returns succes of mislukt (of return: vernieuwd product?)
    //      3.3: updateProductPrijs(int productId, BigDecimal prijs); - returns succes of mislukt (of return: vernieuwd product?)
    //      3.4: updateProductVoorraad(int productId, int voorraad); - returns succes of mislukt (of return: vernieuwd product?)
    // 4: Om producten te verwijderen:
    //      // De functie hieronder heeft een productId (of Product Object? nog niet geimplementeerd) nodig
    //      4.1: verwijderenProduct(int productId); - returns succes of mislukt (of return: vernieuwd product?)
    
    private Connection productenconnectie;
    
    public ProductSQL(Connection connectie) {
        this.productenconnectie = connectie;
    }
    
    @Override
    public Product findProductById(int productId) {
        LOGGER.debug("Input  in findProductById is {}",productId);
        Product zoekresultaat = new Product();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE producten_id = ?")) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met het opgegeven productId zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder()
                                                    .productId(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
               zoekresultaat = gevondenProduct;
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het zoeken van een product op productID{}", ex.getMessage());
            
        }
         LOGGER.debug("output findProductById :" +  zoekresultaat.toString());
        return zoekresultaat;
    } // einde findProductByID(int productId)
    
    @Override
    public List findProductBySoort(String soort) {
         LOGGER.debug("Input  in findProductBySoort is {}",soort);
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                " FROM producten " +
                " WHERE soort = ?")) {
            stmt.setString(1, soort);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven soort zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder()
                                                    .productId(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het zoeken van een product op soort{}", ex.getMessage());
                
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
         LOGGER.debug("output findProductBySoort is :" +  zoekresultaat.toString());
        return zoekresultaat;
    } // einde findProductBySoort(String soort)
    
    @Override
    public List findProductByPrijs(BigDecimal prijs) {
         LOGGER.debug("Input  in findProductByPrijs is {}",prijs);
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE prijs = ?")) {
            stmt.setBigDecimal(1, prijs);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven prijs zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder()
                                                    .productId(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het zoeken van een product op prijs{}", ex.getMessage());
            
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        LOGGER.debug("output findProductByPrijs is :" +  zoekresultaat.toString());
        return zoekresultaat;
    } // einde findProductByPrijs(BigDecimal Prijs)
    
    @Override
    public List findProductByVoorraad(int voorraad) {
         LOGGER.debug("Input  in findProductByVoorraad is {}",voorraad);
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE voorraad = ?")) {
            stmt.setInt(1, voorraad);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven voorraad zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder()
                                                    .productId(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het zoeken van een product op voorraad{}", ex.getMessage());
           
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        LOGGER.debug("output findProductByVoorraad is :" +  zoekresultaat.toString());
        return zoekresultaat;
    } // einde findProductByVoorraad(int voorraad)
    
    @Override
    public boolean toevoegenProduct(Product product) {
         LOGGER.debug("Input  in toevoegenProduct is {}",product.toString());
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "INSERT into producten (omschrijving, soort, prijs, voorraad) "+
                "VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, product.getOmschrijving());
            stmt.setString(2, product.getSoort());
            stmt.setBigDecimal(3, product.getPrijs());
            stmt.setInt(4, product.getVoorraad());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het toevoegen van het product {}", ex.getMessage());
           
            return false;
        }
        LOGGER.debug("output toevoegenProduct is  true");
        return true;
    } // einde toevoegenProduct(Product product)
    
    @Override
    public boolean updateProductOmschrijving(int productId, String omschrijving) {
         LOGGER.debug("Input  in updateProductOmschrijving is {}{}",productId ,omschrijving);
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET omschrijving = ?" +
                "WHERE producten_id = productId")) {
            stmt.setString(1, omschrijving);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het updaten van de productomschrijving {}", ex.getMessage());
           
            return false;
        }
        LOGGER.debug("output updateProductOmschrijving is true");
        return true;
    } // einde updateProductOmschrijving(int productId, String omschrijving)
    
    @Override
    public boolean updateProductSoort(int productId, String soort) {
         LOGGER.debug("Input  in updateProductBySoort is {}{}",productId,soort);
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET soort = ?" +
                "WHERE producten_id = productId")) {
            stmt.setString(1, soort);
            stmt.executeUpdate();
        } catch (SQLException ex) {
              LOGGER.error("Er gaat iets mis met het updaten van de productsoort {}", ex.getMessage());
           
            return false;
        }
        LOGGER.debug("output findProductBySoort is true");
        return true;
    } // einde updateProductSoort(int productId, String soort)
    
    @Override
    public boolean updateProductPrijs(int productId, BigDecimal prijs)  {
         LOGGER.debug("Input  in updateProductPrijs is {}{}",productId,prijs);
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET prijs = ?" +
                "WHERE producten_id = productId")) {
            stmt.setBigDecimal(1, prijs);
            stmt.executeUpdate();
        } catch (SQLException ex) {
              LOGGER.error("Er gaat iets mis met het updaten van de productprijs {}", ex.getMessage());
            
            return false;
        }
        LOGGER.debug("output findProductPrijs is true ");
        return true;
    } // einde updateProductPrijs(int productId, BigDecimal prijs)
    
    @Override
    public boolean updateProductVoorraad(int productId, int voorraad) {
         LOGGER.debug("Input  in updateProductVoorraad is {}{}",productId,voorraad);
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET voorraad = ?" +
                "WHERE producten_id = productId")) {
            stmt.setInt(1, voorraad);
            stmt.executeUpdate();
        } catch (SQLException ex) {
              LOGGER.error("Er gaat iets mis met het updaten van de productovoorraad {}", ex.getMessage());
            
            return false;
        }
        LOGGER.debug("output updateProductVoorraad is true");
        return true;
    } // einde updateProductVoorraad(int productId, int voorraad)
    
    @Override
    public boolean deleteProduct(int productId) {
         LOGGER.debug("Input  in deleteProduct is {}",productId);
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "DELETE FROM producten" +
                "WHERE productId = ?")) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
              LOGGER.error("Er gaat iets mis met het verwijderen van het product {}", ex.getMessage());
           
            return false;
        }  
        LOGGER.debug("output deleteProdcut is true");
    return true;
    } // einde verwijderenProduct(int productId)

} // einde ProductSQL