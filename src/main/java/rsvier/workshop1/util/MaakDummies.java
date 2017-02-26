/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.util;

import rsvier.workshop1.db.Connector;
import rsvier.workshop1.bestelling.Bestelling;
import rsvier.workshop1.bestelling.BestellingDAO;
import rsvier.workshop1.bestelling.BestellingMySQL;
import rsvier.workshop1.adres.AdresMySQL;
import rsvier.workshop1.adres.Adres;
import rsvier.workshop1.adres.AdresDAO;
import rsvier.workshop1.account.AccountDAO;
import rsvier.workshop1.account.AccountMySQL;
import java.math.BigDecimal;
import java.sql.Connection;
import rsvier.workshop1.bestelregel.Bestelregel;
import rsvier.workshop1.bestelregel.BestelregelDAO;
import rsvier.workshop1.bestelregel.BestelregelMySQL;
import rsvier.workshop1.klant.KlantDAO;
import rsvier.workshop1.klant.KlantMySQL;
import rsvier.workshop1.medewerker.MedewerkerDAO;
import rsvier.workshop1.medewerker.MedewerkerMySQL;
import rsvier.workshop1.product.Product;
import rsvier.workshop1.product.ProductDAO;
import rsvier.workshop1.product.ProductMySQL;

/**
 *
 * @author jurjen
 */
public class MaakDummies {
    
    Connection dummyconnectie = new Connector().getConnection();
    
    public void dummyAccount() {
        AccountDAO accountDAO = new AccountMySQL(dummyconnectie);
        int accountType = 1;
        String wachtwoord = "123";
        accountDAO.createAccount(accountType, wachtwoord);
        accountType = 1;
        wachtwoord = "123";
        accountDAO.createAccount(accountType, wachtwoord);
        accountType = 2;
        wachtwoord = "123";
        accountDAO.createAccount(accountType, wachtwoord);
        /*
        accountDAO.findAccountByID(1);
        accountDAO.loginCheckAccount(accountType, wachtwoord);
        accountDAO.updateAccountType(1, accountType);
        accountDAO.updateAccountWachtwoord(1, wachtwoord);
        accountDAO.deleteAccount(1);
        */
    }
    
    public void dummyKlant() {
        KlantDAO klantDAO = new KlantMySQL(dummyconnectie);
        int accountId = 1;
        String voornaam = "Henk";
        int heeftTussenvoegsel = 1;
        String tussenvoegsel = "de";
        String achternaam = "Groot";
        String telefoonnummer = "030-1234567";
        klantDAO.createKlant(accountId, voornaam, heeftTussenvoegsel, tussenvoegsel, achternaam, telefoonnummer);
        accountId = 2;
        voornaam = "Henk";
        heeftTussenvoegsel = 0;
        achternaam = "Bos";
        telefoonnummer = "030-7654321";
        klantDAO.createKlant(accountId, voornaam, heeftTussenvoegsel, tussenvoegsel, achternaam, telefoonnummer);
    }
    
    public void dummyAdres() {
        AdresDAO adresDAO = new AdresMySQL(dummyconnectie);
        int adresType = 1;
        int klantId = 1;
        String straatnaam = "Woonlaan";
        int huisnummer = 10;
        boolean huisnrToevoeging = false;
        String postcode = "1234 AA";
        String land = "Nederland";
        Adres adres = new Adres.AdresBuilder()
                               .adresId(1)
                               .adresType(adresType)
                               .heeftHuisnrToevoeging(huisnrToevoeging)
                               .huisnummer(huisnummer)
                               .klantId(klantId)
                               .postcode(postcode)
                               .straatnaam(straatnaam)
                               .land(land)
                               .build();
        adresDAO.toevoegenAdres(adres);
        adresType = 2;
        klantId = 1;
        straatnaam = "Bezorglaan";
        huisnummer = 20;
        huisnrToevoeging = true;
        String nrToevoeging = "a";
        postcode = "5678 BB";
        land = "Belgie";
        adres = new Adres.AdresBuilder()
                               .adresId(1)
                               .adresType(adresType)
                               .heeftHuisnrToevoeging(huisnrToevoeging)
                               .huisnrToevoeging(nrToevoeging)
                               .huisnummer(huisnummer)
                               .klantId(klantId)
                               .postcode(postcode)
                               .straatnaam(straatnaam)
                               .land(land)
                               .build();
        adresDAO.toevoegenAdres(adres);
        /*
        adresDAO.findAdresById(1);
        adresDAO.findAdresByKlantId(klantId);
        adresDAO.findAdresByLand("Nederland");
        adresDAO.findAdresByPostcode(postcode);
        adresDAO.findAdresByType(adresType);
        adresDAO.updateAdresHeeftHuisnrToevoeging(1, 1);
        adresDAO.updateAdresHuisnrToevoeging(1, "a");
        adresDAO.updateAdresHuisnummer(1, 2);
        adresDAO.updateAdresLand(1, "Nederland");
        adresDAO.updateAdresPostcode(1, "4321 BB");
        adresDAO.updateAdresStraatnaam(1, "Testlaan");
        adresType = 2;
        adresDAO.updateAdresType(1, adresType);
        */
    }
    
    public void dummyMedewerker() {
        int accountId = 3;
        String email = "medewerker@kaas.com";
        String voornaam = "Stefan";
        String tussenvoegsel = "van";
        String achternaam = "Otteren";
        MedewerkerDAO medewerkerDAO = new MedewerkerMySQL(dummyconnectie);
        medewerkerDAO.createMedewerker(accountId, email, voornaam, tussenvoegsel, achternaam);
    }
    
    public void dummyBestelling() {
        BestellingDAO bestellingDAO = new BestellingMySQL(dummyconnectie);
        int bestellingId = 1;
        int klantId = 1;
        int adresId = 1;
        int aantalArtikelen = 3;
        BigDecimal totaalprijs = new BigDecimal(12.50);
        Bestelling opgegevenBestelling = new Bestelling.BestellingBuilder()
                                                       .aantalArtikelen(aantalArtikelen)
                                                       .adresId(adresId)
                                                       .bestellingId(bestellingId)
                                                       .klantId(klantId)
                                                       .totaalprijs(totaalprijs)
                                                       .build();
        bestellingDAO.toevoegenBestelling(opgegevenBestelling);
        /*
        bestellingDAO.findBestellingByAantalArtikelen(aantalArtikelen);
        bestellingDAO.findBestellingByAdresId(adresId);
        bestellingDAO.findBestellingById(bestellingId);
        bestellingDAO.findBestellingByKlantId(klantId);
        bestellingDAO.findBestellingByTotaalprijs(totaalprijs);
        aantalArtikelen = 1;
        bestellingDAO.updateBestellingAantalArtikelen(bestellingId, aantalArtikelen);
        adresId = 2;
        bestellingDAO.updateBestellingAdresId(bestellingId, adresId);
        klantId = 2;
        bestellingDAO.updateBestellingKlantId(bestellingId, klantId);
        totaalprijs = new BigDecimal(1);
        bestellingDAO.updateBestellingTotaalprijs(bestellingId, totaalprijs);
        bestellingDAO.bekijkBestelling(bestellingId);
        bestellingDAO.deleteBestelling(bestellingId);
        */
    }

    public void dummyProduct() {
        String omschrijving = "";
        String soort = "brie";
        BigDecimal prijs = new BigDecimal(2.50);
        int voorraad = 20;
        ProductDAO productDAO = new ProductMySQL(dummyconnectie);
        Product product = new Product.ProductBuilder()
                                     .omschrijving(omschrijving)
                                     .prijs(prijs)
                                     .soort(soort)
                                     .voorraad(voorraad)
                                     .build();
        productDAO.toevoegenProduct(product);
        omschrijving = "";
        soort = "camembert";
        prijs = new BigDecimal(3.00);
        voorraad = 50;
        product = new Product.ProductBuilder()
                                     .omschrijving(omschrijving)
                                     .prijs(prijs)
                                     .soort(soort)
                                     .voorraad(voorraad)
                                     .build();
        productDAO.toevoegenProduct(product);
    }

    public void dummyBestelregel() {
        Bestelregel bestelregel = new Bestelregel.BestelregelBuilder()
                                                 .bestellingId(1)
                                                 .hoeveelheid(3)
                                                 .productId(1)
                                                 .build();                  
        BestelregelDAO bestelregelDAO = new BestelregelMySQL(dummyconnectie);
        bestelregelDAO.toevoegenBestelregel(bestelregel);
        bestelregel = new Bestelregel.BestelregelBuilder()
                                                 .bestellingId(1)
                                                 .hoeveelheid(5)
                                                 .productId(2)
                                                 .build();                  
        bestelregelDAO.toevoegenBestelregel(bestelregel);
    }

    public void dummyFactuur() {
        
    }
}
