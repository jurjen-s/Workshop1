/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.bestelregel;

import java.sql.Connection;
import rsvier.workshop1.db.Connector;

/**
 *
 * @author jurjen
 */
public class BestelregelController {
    // Controller vraagt DAOfactory om een DAO waar Controller mee kan werken
    BestelregelDAOfactory factory = new BestelregelDAOfactory();
    BestelregelDAO bestelregelDAO = factory.getBestellingDAO();
    
    public Bestelregel findBestelregelById(int bestelregelId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(bestelregelId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByBestellingId(int bestellingId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByBestellingId(bestellingId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByProductId(int productId) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByProductId(productId);
        return bestelregel;
    }
    public Bestelregel findBestelregelByHoeveelheid(int hoeveelheid) {
        Bestelregel bestelregel = bestelregelDAO.findBestelregelByHoeveelheid(hoeveelheid);
        return bestelregel;
    }
    public boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId) {
        return bestelregelDAO.updateBestelregelBestellingId(bestelregelId, bestellingId);
    }
    public boolean updateBestelregelProductId(int bestelregelId, int productId) {
        return bestelregelDAO.updateBestelregelProductId(bestelregelId, productId);
    }
    public boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid) {
        return bestelregelDAO.updateBestelregelHoeveelheid(bestelregelId, hoeveelheid);
    }
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        return bestelregelDAO.toevoegenBestelregel(bestelregel);
    }
    public boolean deleteBestelregel(int bestelregelId) {
        return bestelregelDAO.deleteBestelregel(bestelregelId);
    }
}