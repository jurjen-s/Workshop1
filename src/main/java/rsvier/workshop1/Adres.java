/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

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
    
}
