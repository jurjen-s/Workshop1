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
    private int bestellingId; //verwijst naar bestellingen_id
    private int klantId; // verwijst naar FK_bestellingen_klanten_id
    private int adresId; // verwijst naar FK_bestlelingen_adressen_id
    private int aantalArtikelen; // verwijst naar aantal_artikelen
    private BigDecimal totaalprijs; // verwijst naar totaalprijs
    
    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }
    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }
    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }
    public void setAantalArtikelen(int aantalArtikelen) {
        this.aantalArtikelen = aantalArtikelen;
    }
    public void setTotaalprijs(BigDecimal totaalprijs) {
        this.totaalprijs = totaalprijs;
    }
    public int getBestellingId() {
        return bestellingId;
    }
    public int getKlantId() {
        return klantId;
    }
    public int getAdresId() {
        return adresId;
    }
    public int getAantalArtikelen() {
        return aantalArtikelen;
    }
    public BigDecimal getTotaalprijs() {
        return totaalprijs;
    }
    
    
    
    @Override
    public String toString() {
        String bestelling = "Bestelling " + bestellingId +
                            ", behorende bij klant " + klantId +
                            " en adres " + adresId +
                            ", heeft " + aantalArtikelen + " artikelen" +
                            " met een totaalprijs van " + totaalprijs + "Euro.";
        return bestelling;                           
    }
    
    public Bestelling() {
        
    }
    
    private Bestelling(Bestelling.BestellingBuilder builder) {
            bestellingId = builder.bestellingId;
            klantId = builder.klantId;
            adresId = builder.adresId;            
            aantalArtikelen = builder.aantalArtikelen;
            totaalprijs = builder.totaalprijs;
        } 
    
    public static class BestellingBuilder {
        private int bestellingId; //verwijst naar bestellingen_id
        private int klantId; // verwijst naar FK_bestellingen_klanten_id
        private int adresId; // verwijst naar FK_bestlelingen_adressen_id
        private int aantalArtikelen; // verwijst naar aantal_artikelen
        private BigDecimal totaalprijs; // verwijst naar totaalprijs
        
        public BestellingBuilder(int bestellingId) {
            this.bestellingId = bestellingId;
        }
        public BestellingBuilder klantId(int klantId) {
            this.klantId = klantId;
            return this;
        }
        public BestellingBuilder adresId(int adresId) {
            this.adresId = adresId;
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
