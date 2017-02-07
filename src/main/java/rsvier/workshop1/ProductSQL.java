/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author jurjen
 */
public class ProductSQL implements ProductDAO {
    
    public void snelkoppelingNaarFuncties() { // deze functie negeren, is puur om makkelijker te navigeren in IDE
        
    }
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
    
    public List findProductByID(int productId) {
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE producten_id = ?")) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met het opgegeven productId zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Het zoeken op productId ging mis.");
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        return zoekresultaat;
    } // einde findProductByID(int productId)
    
    public List findProductBySoort(String soort) {
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                " FROM producten " +
                " WHERE soort = ?")) {
            stmt.setString(1, soort);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven soort zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Het zoeken op soort ging mis.");
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        return zoekresultaat;
    } // einde findProductBySoort(String soort)
    
    public List findProductByPrijs(BigDecimal prijs) {
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE prijs = ?")) {
            stmt.setBigDecimal(1, prijs);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven prijs zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Het zoeken op prijs ging mis.");
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        return zoekresultaat;
    } // einde findProductByPrijs(BigDecimal Prijs)
    
    public List findProductByVoorraad(int voorraad) {
        List<Product> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "SELECT * " +
                "FROM producten " +
                "WHERE voorraad = ?")) {
            stmt.setInt(1, voorraad);
            ResultSet rs = stmt.executeQuery();
            // Laat alle producten met de opgegeven voorraad zien
            while (rs.next()) {
                Product gevondenProduct = new Product.ProductBuilder(rs.getInt("producten_id"))
                                                    .omschrijving(rs.getString("omschrijving"))
                                                    .soort(rs.getString("soort"))
                                                    .prijs(rs.getBigDecimal("prijs"))
                                                    .voorraad(rs.getInt("voorraad"))
                                                    .build();
                zoekresultaat.add(gevondenProduct);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Het zoeken op voorraad ging mis.");
        }
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } 
        return zoekresultaat;
    } // einde findProductByVoorraad(int voorraad)
    
    public boolean toevoegenProduct(Product product) {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "INSERT into producten (omschrijving, soort, prijs, voorraad) "+
                "VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, product.getOmschrijving());
            stmt.setString(2, product.getSoort());
            stmt.setBigDecimal(3, product.getPrijs());
            stmt.setInt(4, product.getVoorraad());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het toevoegen van het product.");
            return false;
        }
        return true;
    } // einde toevoegenProduct(Product product)

    public boolean updateProductOmschrijving(int productId, String omschrijving) {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET omschrijving = ?" +
                "WHERE producten_id = productId")) {
            stmt.setString(1, omschrijving);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets fout met het updaten van de productomschrijving.");
            return false;
        }
        return true;
    } // einde updateProductOmschrijving(int productId, String omschrijving)

    public boolean updateProductSoort(int productId, String soort) {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET soort = ?" +
                "WHERE producten_id = productId")) {
            stmt.setString(1, soort);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets fout met het updaten van de productsoort.");
            return false;
        }
        return true;
    } // einde updateProductSoort(int productId, String soort)
    public boolean updateProductPrijs(int productId, BigDecimal prijs)  {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET prijs = ?" +
                "WHERE producten_id = productId")) {
            stmt.setBigDecimal(1, prijs);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets fout met het updaten van de productprijs.");
            return false;
        }
        return true;
    } // einde updateProductPrijs(int productId, BigDecimal prijs)
    public boolean updateProductVoorraad(int productId, int voorraad) {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "UPDATE producten" +
                "SET voorraad = ?" +
                "WHERE producten_id = productId")) {
            stmt.setInt(1, voorraad);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets fout met het updaten van de productvoorraad.");
            return false;
        }
        return true;
    } // einde updateProductVoorraad(int productId, int voorraad)

    public boolean verwijderenProduct(int productId) {
        try (PreparedStatement stmt = productenconnectie.prepareStatement(
                "DELETE FROM producten" +
                "WHERE productId = ?")) {
            stmt.setInt(1, productId);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met verwijderen van het product.");
            return false;
        }        
    return true;
    } // einde verwijderenProduct(int productId)

} // einde ProductSQL
