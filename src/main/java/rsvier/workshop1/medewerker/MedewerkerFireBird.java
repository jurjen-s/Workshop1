/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.medewerker;

import java.sql.Connection;

/**
 *
 * @author Frank
 */
public class MedewerkerFireBird implements MedewerkerDAO{

    
   private Connection connectie;
   
    public MedewerkerFireBird(Connection connectie) {
        
        this.connectie = connectie; 
    
    }
    
    
    @Override
    public boolean deleteMedewerker(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker findMedewerkerByID(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker createMedewerker(int medewerkerAccountID, String email, String voornaam, String tussenvoegsel, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker updateMedewerker(int medewerkerID, int medewerkerAccountID, String email, String voornaam, String tussenvoegsel, String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker findMedewerkerByVoornaam(String voornaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker findMedewerkerByAchternaam(String achternaam) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Medewerker findMedewerkerByEmail(String email) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
