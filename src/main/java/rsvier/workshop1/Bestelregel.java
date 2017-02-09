/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

/**
 *
 * @author jurjen
 */
public class Bestelregel {
    private int bestelregelId;
    private int bestellingId;
    private int productId;
    private int hoeveelheid;
    
    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setHoeveelheid(int hoeveelheid) {
        this.hoeveelheid = hoeveelheid;
    }
    
    public int getBestelregelId() {
        return bestelregelId;
    }
    public int getBestellingId() {
        return bestellingId;
    }
    public int getProductId() {
        return productId;
    }
    public int getHoeveelheid() {
        return hoeveelheid;
    }
    
    @Override
    public String toString() {
        String bestelregel = bestelregelId + "\t\t" +
                             bestellingId + "\t\t" +
                             productId + "\t\t" +
                             hoeveelheid + ".";
        return bestelregel;
    }
    public Bestelregel() {
        
    }
    public Bestelregel(int productId, int hoeveelheid) {
        this.productId = productId;
        this.hoeveelheid = hoeveelheid;
    }
    
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        BestelregelDAO bestelregelDAO = new BestelregelSQL();
        bestelregelDAO.toevoegenBestelregel(bestelregel);
        return true;
    }
    
    public static class BestelregelBuilder {
        private int bestelregelId;
        private int bestellingId;
        private int productId;
        private int hoeveelheid;
        
        public BestelregelBuilder() {
            
        }
        public BestelregelBuilder bestelregelId(int bestelregelId) {
            this.bestelregelId = bestelregelId;
            return this;
        }
        public BestelregelBuilder bestellingId(int bestellingId) {
            this.bestellingId = bestellingId;
            return this;
        }
        public BestelregelBuilder productId(int productId) {
            this.productId = productId;
            return this;
        }
        public BestelregelBuilder hoeveelheid(int hoeveelheid) {
            this.hoeveelheid = hoeveelheid;
            return this;
        }
        public Bestelregel build() {
            return new Bestelregel(this);
        }
       
    }
    
    private Bestelregel(BestelregelBuilder builder) {
        bestelregelId = builder.bestelregelId;
        bestellingId = builder.bestellingId;
        productId = builder.productId;
        hoeveelheid = builder.hoeveelheid;
    }
}
