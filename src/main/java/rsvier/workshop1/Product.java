/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import rsvier.workshop1.Bestelregel;

/**
 *
 * @author jurjen
 */
public class Product {
    
    private int productId;
    private String omschrijving;
    private String soort;
    private BigDecimal prijs;
    private int voorraad;
    
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }
    public void setSoort(String soort) {
        this.soort = soort;
    }
    public void setPrijs(BigDecimal prijs) {
        this.prijs = prijs;
    }
    public void setVoorraad(int voorraad) {
        this.voorraad = voorraad;
    }
    
    public int getProductId() {
        return productId;
    }
    public String getOmschrijving() {
        return omschrijving;
    }
    public String getSoort() {
        return soort;
    }
    public BigDecimal getPrijs() {
        return prijs;
    }
    public int getVoorraad() {
        return voorraad;
    }
    
    @Override
    public String toString() {
        String product = " Product Id is : " + productId + " omschrijving is : " + omschrijving + " soort is : "  + soort + " prijs is : " +  prijs + " voorraad aantal is : "  + voorraad + ".";
        return product;
    }
    
    public Product() {        
    
    }
    
    public boolean bestelProduct(int bestellingId, int productId, int hoeveelheid) {
        Bestelregel bestelregel = new Bestelregel(productId, hoeveelheid);
        bestelregel.setBestellingId(bestellingId);
        // Voeg de bestelregel toe aan de database
        bestelregel.toevoegenBestelregel(bestelregel);
        return true;
    }
    
    public static class ProductBuilder {
        private int productId;
        private String omschrijving;
        private String soort;
        private BigDecimal prijs;
        private int voorraad;
        
        public ProductBuilder() {
            
        }
        
        public ProductBuilder productId(int productId) {
            this.productId = productId;
            return this;
        }
        
        public ProductBuilder omschrijving(String omschrijving) {
            this.omschrijving = omschrijving;
            return this;
        }
        public ProductBuilder soort(String soort) {
            this.soort = soort;
            return this;
        }
        public ProductBuilder prijs(BigDecimal prijs) {
            this.prijs = prijs;
            return this;
        }
        public ProductBuilder voorraad(int voorraad) {
            this.voorraad = voorraad;
            return this;
        }
        public Product build() {
            return new Product(this);
        }
    }

        private Product(ProductBuilder builder) {
            productId = builder.productId;
            omschrijving = builder.omschrijving;
            soort = builder.soort;            
            prijs = builder.prijs;
            voorraad = builder.voorraad;
        } 
}
