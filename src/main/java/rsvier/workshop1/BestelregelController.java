/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;

/**
 *
 * @author jurjen
 */
public class BestelregelController {
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private BestelregelDAO bestelregelDAO = new BestelregelSQL(sqlConnectie);
    
    public Bestelregel findBestelregelById(int bestelregelId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(bestelregelId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByBestellingId(int bestellingId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(bestellingId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByProductId(int productId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(productId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByHoeveelheid(int hoeveelheid) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(hoeveelheid);
        return bestelregel;
    }
    public boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId) {
        return bestelregelDAO.updateBestelregelBestellingId(bestelregelId, bestellingId);
    }
    public boolean updateBestelregelProductId(int bestelregelId, int productId) {
        return bestelregelDAO.updateBestelregelBestellingId(bestelregelId, productId);
    }
    public boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid) {
        return bestelregelDAO.updateBestelregelBestellingId(bestelregelId, hoeveelheid);
    }
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        return bestelregelDAO.toevoegenBestelregel(bestelregel);
    }
    public boolean deleteBestelregel(int bestelregelId) {
        return bestelregelDAO.deleteBestelregel(bestelregelId);
    }
}