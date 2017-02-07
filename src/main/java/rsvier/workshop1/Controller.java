/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author jurjen
 */

// behandelt de interactie tussen het model (data + methodes) en de view (UI, console)
/*
de controller heeft dan toegang tot het model via de DAO's
controller krijgt bijv via actionlistener in view binnen: ik wil een product updaten
controller geeft dat door aan de juiste DAO en geeft resultaat terug aan view voor display
*/
public class Controller {
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    private BestellingDAO bestellingDAO = new BestellingSQL(sqlConnectie);
    private ProductDAO productDAO = new ProductSQL(sqlConnectie);
    private Klantinterface klantDAO = new KlantDAOinterfaceImpl();
    private Menu menu = new Menu();
    
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
    
    // Voorbeeld / test functie
    findKlantById(klantId)
    
    public void findProductByID(int productId) {
        if (existsProductId(productId)) {
            Product zoekresultaat = productDAO.findProductByID(productId);
            Menu.print(zoekresultaat.toString());
        } else {
            Menu.print("Er is geen product met het opgegeven productId gevonden.");
        }
    }
    public void findProductBySoort(String soort) {
        List<Product> zoekresultaat = productDAO.findProductBySoort(soort);
        Menu.print(zoekresultaat);
    }
    
    
    // Error handling nodig voor
        // adressen_klanten_id
        // bestellingen_klanten_id
        // facturen_klanten_id
            // verwijst naar klantId, dus kijken of dat bestaat
        public boolean existsKlantId(int klantId) {
            try (PreparedStatement stmt = sqlConnectie.prepareStatement(
                    "SELECT klanten_id" +
                    "FROM klanten" +
                    "WHERE klanten_id = ?")) {
                stmt.setInt(1, klantId);
            } catch (SQLException ex) {
                //System.out.println("Er is geen klant met het opgegeven klantID gevonden.");
                return false;
            }
            return true;
        }
        // bestellingen_adressen_id
        // facturen_adressen_id
        // klanten_adressen_id
            // verwijst naar adresId, dus kijken of dat bestaat
        public boolean existsAdresId(int adresId) {
            try (PreparedStatement stmt = sqlConnectie.prepareStatement(
                    "SELECT adressen_id" +
                    "FROM klanten" +
                    "WHERE adressen_id = ?")) {
                stmt.setInt(1, adresId);
            } catch (SQLException ex) {
                //System.out.println("Er is geen adres met het opgegeven adresId gevonden.");
                return false;
            }
            return true;
        }
        // bestellingregels_bestellingen_id
        // facturen_bestellingen_id
            // verwijst naar bestellingId, dus kijken of dat bestaat
        public boolean existsBestellingId(int bestellingId) {
            try (PreparedStatement stmt = sqlConnectie.prepareStatement(
                    "SELECT bestellingen_id" +
                    "FROM klanten" +
                    "WHERE bestellingen_id = ?")) {
                stmt.setInt(1, bestellingId);
            } catch (SQLException ex) {
                //System.out.println("Er is geen bestelling met het opgegeven bestellingId gevonden.");
                return false;
            }
            return true;
        }
        // bestellingregels_producten_id
            // verwijst naar productenId, dus kijken of dat bestaat
        public boolean existsProductId(int productId) {
            try (PreparedStatement stmt = sqlConnectie.prepareStatement(
                    "SELECT producten_id" +
                    "FROM klanten" +
                    "WHERE producten_id = ?")) {
                stmt.setInt(1, productId);
            } catch (SQLException ex) {
                //System.out.println("Er is geen product met het opgegeven productId gevonden.");
                return false;
            }
            return true;
        }
        // klanten_accounts_id
        // medewerkers_accounts_id
            // verwijst naar accountId, dus kijken of dat bestaat
        public boolean existsAccountId(int accountId) {
            try (PreparedStatement stmt = sqlConnectie.prepareStatement(
                    "SELECT accounts_id" +
                    "FROM klanten" +
                    "WHERE accounts_id = ?")) {
                stmt.setInt(1, accountId);
            } catch (SQLException ex) {
                //System.out.println("Er is geen account met het opgegeven accountId gevonden.");
                return false;
            }
            return true;
        }

