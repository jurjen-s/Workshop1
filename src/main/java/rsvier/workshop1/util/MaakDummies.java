/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.util;

import rsvier.workshop1.db.SQLConnection;
import rsvier.workshop1.bestelling.Bestelling;
import rsvier.workshop1.bestelling.BestellingDAO;
import rsvier.workshop1.bestelling.BestellingSQL;
import rsvier.workshop1.adres.AdresSQL;
import rsvier.workshop1.adres.Adres;
import rsvier.workshop1.adres.AdresDAO;
import rsvier.workshop1.account.AccountDAO;
import rsvier.workshop1.account.AccountMySQL;
import java.math.BigDecimal;
import java.sql.Connection;

/**
 *
 * @author jurjen
 */
public class MaakDummies {
    
    Connection dummyconnectie = new SQLConnection().getSQLConnection();
    
    public void dummyAccount() {
        AccountDAO accountDAO = new AccountMySQL(dummyconnectie);
        int accountType = 1;
        String wachtwoord = "nohashnosalt";
        accountDAO.createAccount(accountType, wachtwoord);
        accountDAO.findAccountByID(1);
        accountDAO.loginCheckAccount(accountType, wachtwoord);
        accountDAO.updateAccountType(1, accountType);
        accountDAO.updateAccountWachtwoord(1, wachtwoord);
        accountDAO.deleteAccount(1);
    }
    public void dummyAdres() {
        AdresDAO adresDAO = new AdresSQL(dummyconnectie);
        int adresType = 1;
        int klantId = 1;
        String straatnaam = "Teststraat";
        int huisnummer = 1;
        boolean huisnrToevoeging = false;
        String postcode = "1234 AA";
        Adres adres = new Adres.AdresBuilder()
                               .adresId(1)
                               .adresType(adresType)
                               .heeftHuisnrToevoeging(huisnrToevoeging)
                               .huisnummer(huisnummer)
                               .klantId(klantId)
                               .postcode(postcode)
                               .straatnaam(straatnaam)
                               .build();
        adresDAO.toevoegenAdres(adres);
        adresDAO.findAdresById(1);
        adresDAO.findAdresByKlantId(klantId);
        adresDAO.findAdresByLand("Nederland");
        adresDAO.findAdresByPostcode(postcode);
        adresDAO.findAdresByType(adresType);
        adresDAO.updateAdresHeeftHuisnrToevoeging(1, 1);
        adresDAO.updateAdresHuisnrToevoeging(1, "a");
        adresDAO.updateAdresHuisnummer(1, 2);
        adresDAO.updateAdresLand(1, "Belgie");
        adresDAO.updateAdresPostcode(1, "4321 BB");
        adresDAO.updateAdresStraatnaam(1, "Testlaan");
        adresType = 2;
        adresDAO.updateAdresType(1, adresType);
    }
    public void dummyBestelling() {
        BestellingDAO bestellingDAO = new BestellingSQL(dummyconnectie);
        int bestellingId = 1;
        int klantId = 1;
        int adresId = 1;
        int aantalArtikelen = 0;
        BigDecimal totaalprijs = new BigDecimal(0);
        Bestelling opgegevenBestelling = new Bestelling.BestellingBuilder()
                                                       .aantalArtikelen(aantalArtikelen)
                                                       .adresId(adresId)
                                                       .bestellingId(bestellingId)
                                                       .klantId(klantId)
                                                       .totaalprijs(totaalprijs)
                                                       .build();
        bestellingDAO.toevoegenBestelling(opgegevenBestelling);
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
    }
}
