/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.math.BigDecimal;

/**
 *
 * @author jurjen
 */
public class Bestelling {
    private int bestellingID; //verwijst naar bestellingen_id
    private int klantID; // verwijst naar FK_bestellingen_klanten_id
    private int adresID; // verwijst naar FK_bestlelingen_adressen_id
    private int aantalArtikelen; // verwijst naar aantal_artikelen
    private BigDecimal totaalprijs; // verwijst naar totaalprijs
    
    @Override
    public String toString() {
        String bestelling = "Bestelling " + bestellingID +
                            ", behorende bij klant " + klantID +
                            " en adres " + adresID +
                            ", heeft " + aantalArtikelen + " artikelen" +
                            " met een totaalprijs van " + totaalprijs + "Euro.";
        return bestelling;                           
    }
    
    private Bestelling(Bestelling.BestellingBuilder builder) {
            bestellingID = builder.bestellingID;
            klantID = builder.klantID;
            adresID = builder.adresID;            
            aantalArtikelen = builder.aantalArtikelen;
            totaalprijs = builder.totaalprijs;
        } 
    
    public static class BestellingBuilder {
        private int bestellingID; //verwijst naar bestellingen_id
        private int klantID; // verwijst naar FK_bestellingen_klanten_id
        private int adresID; // verwijst naar FK_bestlelingen_adressen_id
        private int aantalArtikelen; // verwijst naar aantal_artikelen
        private BigDecimal totaalprijs; // verwijst naar totaalprijs
        
        public BestellingBuilder(int bestellingID) {
            this.bestellingID = bestellingID;
        }
        public BestellingBuilder klantID(int klantID) {
            this.klantID = klantID;
            return this;
        }
        public BestellingBuilder adresID(int adresID) {
            this.adresID = adresID;
            return this;
        }
        public BestellingBuilder aantalArtikelen(int aantalArtikelen) {
            this.aantalArtikelen = aantalArtikelen;
            return this;
        }
        public BestellingBuilder totaalprijs(BigDecimal totaalprijs) {
            this.totaalprijs = totaalprijs;
            return this;
        }
        public Bestelling build() {
            return new Bestelling(this);
        }
        
    }
}
