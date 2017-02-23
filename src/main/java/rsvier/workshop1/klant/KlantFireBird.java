/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.klant;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author Frank
 */
public class KlantFireBird implements KlantDAO {

    private Connection connectie;
    
    public KlantFireBird(Connection connectie) {
        this.connectie = connectie;
    }
    
    
    
    
    @Override
    public List klantlijst() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findBijID(int idKlant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findBijNaam(String voornaam, String tussenvoegsel, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findBijVoornaam(String voornaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List findBijLastName(String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klant createKlant(int accountidvanklant, String VN, int Heefttussenvoegsel, String TV, String AN, String telefoonnr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Klant updateKlant(int accountidvanklant, String VN, int Heefttussenvoegsel, String TV, String AN, String Telefoonnr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteKlant(int klantid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
