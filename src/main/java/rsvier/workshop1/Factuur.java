/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;

/**
 *
 * @author jurjen
 */
public class Factuur {
    private int factuurId;
    private int bestellingId;
    private int adresId;
    private int klantId;
    private BigDecimal totaalprijs;
    private boolean status;
    
    public void setFactuurId(int factuurId) {
        this.factuurId = factuurId;
    }
    public void setBestellingId(int bestellingId) {
        this.bestellingId = bestellingId;
    }
    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }
    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }
    public void setTotaalprijs(BigDecimal totaalprijs) {
        this.totaalprijs = totaalprijs;
    }
    public void setStatus(boolean status) {
        this.status = status;
    }
    public int getFactuurId() {
        return factuurId;
    }
    public int getBestellingId() {
        return bestellingId;
    }
    public int getAdresId() {
        return adresId;
    }
    public int getKlantId() {
        return klantId;
    }
    public BigDecimal getTotaalprijs() {
        return totaalprijs;
    }
    public boolean getStatus() {
        return status;
    }
    
    @Override
    public String toString() {
        String factuur = factuurId + "\t\t" +
                         bestellingId + "\t\t" +
                         adresId + "\t\t" +
                         klantId + "\t\t" +
                         totaalprijs + "\t\t" +
                         status;
        return factuur;
    }
    
    public Factuur() {
        
    }
    private Factuur(FactuurBuilder builder) {
        factuurId = builder.factuurId;
        bestellingId = builder.bestellingId;
        adresId = builder.adresId;
        klantId = builder.klantId;
        totaalprijs = builder.totaalprijs;
        status = builder.status;
    }
    
    public static class FactuurBuilder {
        
        private int factuurId;
        private int bestellingId;
        private int adresId;
        private int klantId;
        private BigDecimal totaalprijs;
        private boolean status;
    
        public FactuurBuilder factuurId(int factuurId) {
            this.factuurId = factuurId;
            return this;
        }
        public FactuurBuilder bestellingId(int bestellingId) {
            this.bestellingId = bestellingId;
            return this;
        }
        public FactuurBuilder adresId(int adresId) {
            this.adresId = adresId;
            return this;
        }
        public FactuurBuilder klantId(int klantId) {
            this.klantId = klantId;
            return this;
        }
        public FactuurBuilder totaalprijs(BigDecimal totaalprijs) {
            this.totaalprijs = totaalprijs;
            return this;
        }
        public FactuurBuilder status(boolean status) {
            this.status = status;
            return this;
        }
        public Factuur build() {
            return new Factuur(this);
        }
    }
}
