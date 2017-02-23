/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import rsvier.workshop1.db.SQLConnection;
import rsvier.workshop1.product.ProductMySQL;
import rsvier.workshop1.product.ProductDAO;
import rsvier.workshop1.product.Product;
import rsvier.workshop1.medewerker.Medewerker;
import rsvier.workshop1.medewerker.MedewerkerDAO;
import rsvier.workshop1.medewerker.MedewerkerMySQL;
import rsvier.workshop1.klant.Klant;
import rsvier.workshop1.klant.KlantMySQL;
import rsvier.workshop1.klant.KlantDAO;
import rsvier.workshop1.factuur.Factuur;
import rsvier.workshop1.factuur.FactuurDAO;
import rsvier.workshop1.factuur.FactuurMySQL;
import rsvier.workshop1.bestelregel.BestelregelMySQL;
import rsvier.workshop1.bestelregel.Bestelregel;
import rsvier.workshop1.bestelregel.BestelregelDAO;
import rsvier.workshop1.bestelling.Bestelling;
import rsvier.workshop1.bestelling.BestellingDAO;
import rsvier.workshop1.bestelling.BestellingMySQL;
import rsvier.workshop1.adres.AdresMySQL;
import rsvier.workshop1.adres.Adres;
import rsvier.workshop1.adres.AdresDAO;
import rsvier.workshop1.account.AccountDAO;
import rsvier.workshop1.account.Account;
import rsvier.workshop1.account.AccountMySQL;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jurjen
 */

public class Controller {
    
    private String settings = "target/classes/settings.xml";
    
    // Foreign keys
    public boolean existsKlantId(int klantId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        KlantDAO klantDAO = new KlantMySQL(connectie);
        List<Klant> klantlijst = klantDAO.findBijID(klantId);
        if (klantlijst.isEmpty()) {
            System.out.println("Opgegeven klantId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existsAdresId(int adresId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        AdresDAO adresDAO = new AdresMySQL(connectie);
        Adres adres = adresDAO.findAdresById(adresId);
        if (adres.getAdresId() == 0) {
            System.out.println("Opgegeven adresId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existsProductId(int productId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        ProductDAO productDAO = new ProductMySQL(connectie);
        Product product = productDAO.findProductById(productId);
        if (product.getProductId() == 0) {
            System.out.println("Opgegeven productId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existsBestellingId(int bestellingId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        BestellingDAO bestellingDAO = new BestellingMySQL(connectie);
        Bestelling bestelling = bestellingDAO.findBestellingById(bestellingId);
        if (bestelling.getBestellingId() == 0) {
            System.out.println("Opgegeven bestellingId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    public boolean existsAccountId(int accountId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        AccountDAO accountDAO = new AccountMySQL(connectie);
        Account account = accountDAO.findAccountByID(accountId);
        if (account.getAccountId() == 0) {
            System.out.println("Opgegeven accountId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    // Overige checks
    public boolean existsFactuurId(int factuurId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        FactuurDAO factuurDAO = new FactuurMySQL(connectie);
        Factuur factuur = factuurDAO.findFactuurById(factuurId);
        System.out.println(factuur.getFactuurId());
        if (factuur.getFactuurId() == 0) {
            System.out.println("Opgegeven factuurId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }

    public boolean existsBestelregelId(int bestelregelId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        BestelregelDAO bestelregelDAO = new BestelregelMySQL(connectie);
        Bestelregel bestelregel = bestelregelDAO.findBestelregelById(bestelregelId);
        System.out.println(bestelregel.getBestelregelId());
        if (bestelregel.getBestelregelId() == 0) {
            System.out.println("Opgegeven bestelregelId niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
     public boolean existsMedewerkerId(int medewerkId) {
        SQLConnection sqlConnectie = new SQLConnection();
        Connection connectie = sqlConnectie.getSQLConnection();
        MedewerkerDAO medewerkerDAO = new MedewerkerMySQL(connectie);
        Medewerker m = medewerkerDAO.findMedewerkerByID(medewerkId);
        System.out.println(m.getMedewerkerAccountID());
        if (m.getMedewerkerAccountID() == 0) {
            System.out.println("Opgegeven medewerker Id niet gevonden.");
            return false;
        } else {
            return true;
        }
    }
    
    
    
    
}

// CLASS is op dit moment niet in gebruik
// Hieronder volgen voorbeelden van error handling die nog naar de juiste DAO's moeten
/*
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
*/











// behandelt de interactie tussen het model (data + methodes) en de view (UI, console)
/*
de controller heeft dan toegang tot het model via de DAO's
controller krijgt bijv via actionlistener in view binnen: ik wil een product updaten
controller geeft dat door aan de juiste DAO en geeft resultaat terug aan view voor display
*/
/*public class Controller {
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    private BestellingDAO bestellingDAO = new BestellingSQL(sqlConnectie);
    private ProductDAO productDAO = new ProductMySQL(sqlConnectie);
    private KlantInterface klantDAO = new KlantDAOinterfaceImpl(sqlConnectie);
    private Menu menu = new Menu();
 */   
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
    /*
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
    
    
    
} // einde Controller

*/