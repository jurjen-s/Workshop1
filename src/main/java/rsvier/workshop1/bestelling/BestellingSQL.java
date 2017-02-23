/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.bestelling;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Frank
 */
public abstract class BestellingSQL {
    
    
    abstract Bestelling findBestellingById(int bestellingId); // returns Bestelling object als zoekresultaat
    abstract List findBestellingByKlantId(int klantId); // returns List<Bestelling> met zoekresultaten
    abstract List findBestellingByAdresId(int adresId); // returns List<Bestelling> met zoekresultaten
    abstract List findBestellingByAantalArtikelen(int aantal); // returns List<Bestelling> met zoekresultaten
    abstract List findBestellingByTotaalprijs(BigDecimal prijs); // returns List<Bestelling> met zoekresultaten
    // 2: Om bestellingen toe te voegen:
    abstract Bestelling toevoegenBestelling(Bestelling opgegevenBestelling); //returns Bestelling object met de ingevoerde waardes
    
    // 3: Om bestellingen aan te passen:
    abstract boolean updateBestellingKlantId(int bestellingId, int klantId); // returns succes of mislukt (+ laat vernieuwde bestelling zien?)
    abstract boolean updateBestellingAdresId(int bestellingId, int adresId); // returns succes of mislukt
    abstract boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen); // returns succes of mislukt
    abstract boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs); // returns succes of mislukt
    // 4: Om bestellingen te verwijderen:
    abstract boolean deleteBestelling(int bestellingId); // returns succes of mislukt
    // 5: Om een bestelling te bekijken:
    abstract void bekijkBestelling(int bestellingId); // print een lijst met de inhoud van de bestelling
    
    
    
    
    
    
    
    
    
    
    
}
