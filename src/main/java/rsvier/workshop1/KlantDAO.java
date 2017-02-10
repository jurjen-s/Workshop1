/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;
   

import java.util.List;

// hier mist misschien nog wat imports.
/**
 *
 * @author Frank
 */
public interface KlantDAO {
  


//de list heet Klant.

    public List<Klant> klantlijst();
    
    
    //finders
    public Klant findKlant(Klant bestaandeKlant);
    
    public Klant findBijID(int idKlant);
    public Klant findBijNaam(String voornaam,String tussenvoegsel, String achternaam);
    public Klant findBijVoornaam(String voornaam);
    public Klant findBijLastName(String achternaam);
    
    public Klant createKlant( int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, int telefoonnr);
    
    public Klant updateKlant(int accountidvanklant, String VN, int Heefttussenvoegsel,String TV , String AN, int Telefoonnr);
    
    public boolean deleteKlant(int klantid);
}
    
   
    
    

