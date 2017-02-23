/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import rsvier.workshop1.db.Connector;
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
    
    private Connector connector = new Connector();
    private Connection connectie = connector.getConnection();
    
    // Foreign key checks
    public boolean existsKlantId(int klantId) {
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