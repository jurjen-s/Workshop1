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
    
    
    //logger maken
    private static final Logger LOGGER = LogManager.getLogger(MedewerkerSQL.class);
    
    //connectie maken
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
        String query = "SELECT * FROM producten WHERE soort = ? ";
        try (PreparedStatement stmt = productenconnectie.prepareStatement(query)) {
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
            }//einde while
            
        rs.close();
        }//einde try
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het zoeken van een product op soort{}", ex.getMessage());
                
                }//einde catch
        
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
            }//einde while
            
        rs.close();
        }//einde try
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het zoeken van een product op prijs{}", ex.getMessage());
            
                }//einde catch
        
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
            }//einde while
        rs.close();
        }//einde try
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het zoeken van een product op voorraad{}", ex.getMessage());
           
                }//einde catch
        
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
            LOGGER.debug("output toevoegenProduct is  true");
            return true;
        }//einde try
        
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het toevoegen van het product {}", ex.getMessage());
           
                return false;
                }//einde catch
        
        
    } // einde toevoegenProduct(Product product)
    
    @Override
    public boolean updateProductOmschrijving(int productId, String omschrijving) {
         LOGGER.debug("Input  in  product id is : {} en updateProductOmschrijving is : {} ",productId ,omschrijving);
         String query = " UPDATE producten SET omschrijving = ? WHERE producten_id = ? ";
        try (PreparedStatement stmt = productenconnectie.prepareStatement( query)) {
            stmt.setString(1, omschrijving);
            stmt.setInt(2,productId);
            stmt.executeUpdate();
            LOGGER.debug("output updateProductOmschrijving is true");
            return true;
        }//einde try
        
            catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het updaten van de productomschrijving {}", ex.getMessage());
           
            return false;
            }//einde catch
        
    } // einde updateProductOmschrijving(int productId, String omschrijving)
    
    @Override
    public boolean updateProductSoort(int productId, String soort) {
         LOGGER.debug("Input  in updateProductBySoort is id : {} en soort is : {}",productId,soort);
         String query = "UPDATE producten SET soort = ? WHERE producten_id = ?";
        try (PreparedStatement stmt = productenconnectie.prepareStatement(query)) {
            stmt.setString(1, soort);
            stmt.setInt(2,productId);
            stmt.executeUpdate();
            LOGGER.debug("output findProductBySoort is true");
            return true;
        }//einde try
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het updaten van de productsoort {}", ex.getMessage());
           
                return false;
                }//einde catch
        
    } // einde updateProductSoort(int productId, String soort)
    
    @Override
    public boolean updateProductPrijs(int productId, BigDecimal prijs)  {
    LOGGER.debug("Input  in updateProductPrijs is id :  {} en prijs : {}",productId,prijs);
    String query = "UPDATE producten SET prijs = ? WHERE producten_id = ?";
        try (PreparedStatement stmt = productenconnectie.prepareStatement(query)) {
            stmt.setBigDecimal(1, prijs);
            stmt.setInt(2,productId);
            stmt.executeUpdate();
            LOGGER.debug("output findProductPrijs is true ");
            return true;
            }
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het updaten van de productprijs {}", ex.getMessage());
            
                return false;
                }//einde catch
        
    } // einde updateProductPrijs(int productId, BigDecimal prijs)
    
    @Override
    public boolean updateProductVoorraad(int productId, int voorraad) {
         LOGGER.debug("Input  in updateProductVoorraad is {}{}",productId,voorraad);
         String query = "UPDATE producten SET voorraad = ? WHERE producten_id = ?";
        try (PreparedStatement stmt = productenconnectie.prepareStatement(query)) {
            stmt.setInt(1, voorraad);
            stmt.setInt(2, productId);
            stmt.executeUpdate();
            LOGGER.debug("output updateProductVoorraad is true");
            return true;
        }//einde try
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het updaten van de productovoorraad {}", ex.getMessage());
            
                return false;
                }//einde catch
        
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
            LOGGER.debug("output deleteProdcut is true");
            return true;
        }
                catch (SQLException ex) {
                LOGGER.error("Er gaat iets mis met het verwijderen van het product {}", ex.getMessage());
           
                return false;
                }  //einde catch
        
    } // einde verwijderenProduct(int productId)

    
} // einde ProductSQL