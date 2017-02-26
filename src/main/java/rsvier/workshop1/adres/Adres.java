/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

/**
 *
 * @author jurjen
 */
public class Adres {
    private int adresId;
    private int adresType;
    private int klantId;
    private String straatnaam;
    private int huisnummer;
    private boolean heeftHuisnrToevoeging;
    private String huisnrToevoeging;
    private String postcode;
    private String land;
    
    public Adres() {
        
    }

    public void setAdresId(int adresId) {
        this.adresId = adresId;
    }
    public void setAdresType(int adresType) {
        this.adresType = adresType;
    }
    public void setKlantId(int klantId) {
        this.klantId = klantId;
    }
    public void setStraatnaam(String straatnaam) {
        this.straatnaam = straatnaam;
    }
    public void setHuisnummer(int huisnummer) {
        this.huisnummer = huisnummer;
    }
    public void setHeeftHuisnrToevoeging(boolean heeftHuisnrToevoeging) {
        this.heeftHuisnrToevoeging = heeftHuisnrToevoeging;
    }
    public void setHuisnrToevoeging(String huisnrToevoeging) {
        this.huisnrToevoeging = huisnrToevoeging;
    }
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
    public void setLand(String land) {
        this.land = land;
    }
    
    public int getAdresId() {
        return adresId;
    }
    public int getAdresType() {
        return adresType;
    }
    public int getKlantId() {
        return klantId;
    }
    public String getStraatnaam() {
        return straatnaam;
    }
    public int getHuisnummer() {
        return huisnummer;
    }
    public boolean getHeeftHuisnrToevoeging() {
        return heeftHuisnrToevoeging;
    }
    public String getHuisnrToevoeging() {
        return huisnrToevoeging;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getLand() {
        return land;
    }
    
    @Override
    public String toString() {
        String typeAdres = "";
        switch (adresType) {
            case 1: typeAdres = "woonadres";
            case 2: typeAdres = "bezorgadres";
            case 3: typeAdres = "factuuradres";
        }
        String deelAdres = "[AdresId " + adresId + ", " + typeAdres + " van klant " + klantId + "] : " + straatnaam + " " + huisnummer;
        String adres;
        if (heeftHuisnrToevoeging) {
            adres = deelAdres + huisnrToevoeging + ", " + postcode + ", " + land + ".\n";
        } else {
            adres = deelAdres + ", " + postcode + ", " + land + ".\n";
        }
        return adres;
    }
    
    private Adres(AdresBuilder builder) {
        adresId = builder.adresId;
        adresType = builder.adresType;
        klantId = builder.klantId;
        straatnaam = builder.straatnaam;
        huisnummer = builder.huisnummer;
        heeftHuisnrToevoeging = builder.heeftHuisnrToevoeging;
        huisnrToevoeging = builder.huisnrToevoeging;
        postcode = builder.postcode;
        land = builder.land;
    }
    
    public static class AdresBuilder {
        private int adresId;
        private int adresType;
        private int klantId;
        private String straatnaam;
        private int huisnummer;
        private boolean heeftHuisnrToevoeging;
        private String huisnrToevoeging;
        private String postcode;
        private String land;
        
        public AdresBuilder adresId(int adresId) {
            this.adresId = adresId;
            return this;
        }
        public AdresBuilder adresType(int adresType) {
            this.adresType = adresType;
            return this;
        }
        public AdresBuilder klantId(int klantId) {
            this.klantId = klantId;
            return this;
        }
        public AdresBuilder straatnaam(String straatnaam) {
            this.straatnaam = straatnaam;
            return this;
        }
        public AdresBuilder huisnummer(int huisnummer) {
            this.huisnummer = huisnummer;
            return this;
        }
        public AdresBuilder heeftHuisnrToevoeging(boolean heeftHuisnrToevoeging) {
            this.heeftHuisnrToevoeging = heeftHuisnrToevoeging;
            return this;
        }
        public AdresBuilder huisnrToevoeging(String huisnrToevoeging) {
            this.huisnrToevoeging = huisnrToevoeging;
            return this;
        }
        public AdresBuilder postcode(String postcode) {
            this.postcode = postcode;
            return this;
        }
        public AdresBuilder land(String land) {
            this.land = land;
            return this;
        }
        public Adres build() {
            return new Adres(this);
        }
    }
    
}
