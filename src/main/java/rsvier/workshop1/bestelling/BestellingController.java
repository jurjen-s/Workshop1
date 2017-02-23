/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.bestelling;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author jurjen
 */
public class BestellingController {
    
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private BestellingDAO bestellingDAO = new BestellingSQL(sqlConnectie);
    //private BestellingMenu bestellingMenu = new BestellingMenu();
    
    public Bestelling findBestellingById(int bestellingId) {
        Bestelling bestelling = bestellingDAO.findBestellingById(bestellingId);
        return bestelling;
    }
    
    public List findBestellingByKlant(int klantId) {
        List<Bestelling> zoekresultaat = bestellingDAO.findBestellingByKlantId(klantId);
        return zoekresultaat;
    }
    
    public List findBestellingByAdres(int adresId) {
        List<Bestelling> zoekresultaat = bestellingDAO.findBestellingByAdresId(adresId);
        return zoekresultaat;
    }
    
    public List findBestellingByAantalArtikelen(int aantalArtikelen) {
        List<Bestelling> zoekresultaat = bestellingDAO.findBestellingByAantalArtikelen(aantalArtikelen);
        return zoekresultaat;
    }
    
    public List findBestellingTotaalprijs(BigDecimal prijs) {
        List<Bestelling> zoekresultaat = bestellingDAO.findBestellingByTotaalprijs(prijs);
        return zoekresultaat;
    }
    
    public Bestelling toevoegenBestelling(Bestelling bestelling) {
        Bestelling zoekresultaat = bestellingDAO.toevoegenBestelling(bestelling);
        return zoekresultaat;
    }
    
    public boolean updateBestellingKlantID(int bestellingId, int klantId) {
        return bestellingDAO.updateBestellingKlantId(bestellingId, klantId);
    }
    
    public boolean updateBestellingAdresID(int bestellingId, int adresId) {
        return bestellingDAO.updateBestellingAdresId(bestellingId, adresId);
    }
    
    public boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen) {
        return bestellingDAO.updateBestellingAantalArtikelen(bestellingId, aantalArtikelen);
    }
    
    public boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs) {
        return bestellingDAO.updateBestellingTotaalprijs(bestellingId, totaalprijs);
    }
    
    public boolean deleteBestelling(int bestellingId) {
        return bestellingDAO.deleteBestelling(bestellingId);
    }
    
}
