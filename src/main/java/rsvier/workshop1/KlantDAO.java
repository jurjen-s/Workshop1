/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;
   

import java.sql.SQLException;
import java.util.List;

// hier mist misschien nog wat imports.
/**
 *
 * @author Frank
 */
public interface KlantDAO {
  


//de list heet Klant.

    public List klantlijst();
    
    
    //finders
    
    
    public List findBijID(int idKlant);
    public List findBijNaam(String voornaam,String tussenvoegsel, String achternaam);
    public List findBijVoornaam(String voornaam);
    public List findBijLastName(String achternaam);
    
    public Klant createKlant( int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, int telefoonnr);
    
    public Klant updateKlant(int accountidvanklant, String VN, int Heefttussenvoegsel,String TV , String AN, int Telefoonnr);
    
    public boolean deleteKlant(int klantid);
}
    
   
    
    

