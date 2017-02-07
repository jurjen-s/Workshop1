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
    
    public Bestelregel(int productId, int hoeveelheid) {
        this.productId = productId;
        this.hoeveelheid = hoeveelheid;
    }
    
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        BestelregelDAO bestelregelDAO = new BestelregelSQL();
        bestelregelDAO.toevoegenBestelregel(bestelregel);
        return true;
    }
    
}
