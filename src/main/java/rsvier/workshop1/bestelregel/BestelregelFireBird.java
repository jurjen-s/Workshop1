/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.bestelregel;

import java.sql.Connection;

/**
 *
 * @author Frank
 */
public class BestelregelFireBird implements BestelregelDAO {
    
     private Connection connectie;
    
    public BestelregelFireBird(Connection connectie) {
        this.connectie = connectie;
    }
    
    

    @Override
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestelregel findBestelregelById(int bestelregelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestelregel findBestelregelByBestellingId(int bestellingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestelregel findBestelregelByProductId(int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestelregel findBestelregelByHoeveelheid(int hoeveelheid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBestelregelProductId(int bestelregelId, int productId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBestelregel(int bestelregelId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
