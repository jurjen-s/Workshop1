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
 * @author jurjen
 */
public interface BestellingDAO {
    
    // Functies:
    // 1: Om bestellingen te zoeken:
    Bestelling findBestellingById(int bestellingId); // returns Bestelling object als zoekresultaat
    List findBestellingByKlantId(int klantId); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAdresId(int adresId); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAantalArtikelen(int aantal); // returns List<Bestelling> met zoekresultaten
    List findBestellingByTotaalprijs(BigDecimal prijs); // returns List<Bestelling> met zoekresultaten
    // 2: Om bestellingen toe te voegen:
    Bestelling toevoegenBestelling(Bestelling opgegevenBestelling); //returns Bestelling object met de ingevoerde waardes
    //@@ Is bovenstaande nog wel nodig? of zal ik het veranderen naar plaatsBestelling?
    // 3: Om bestellingen aan te passen:
    boolean updateBestellingKlantId(int bestellingId, int klantId); // returns succes of mislukt (+ laat vernieuwde bestelling zien?)
    boolean updateBestellingAdresId(int bestellingId, int adresId); // returns succes of mislukt
    boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen); // returns succes of mislukt
    boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs); // returns succes of mislukt
    // 4: Om bestellingen te verwijderen:
    boolean deleteBestelling(int bestellingId); // returns succes of mislukt
    // 5: Om een bestelling te bekijken:
    void bekijkBestelling(int bestellingId); // print een lijst met de inhoud van de bestelling
    
}
