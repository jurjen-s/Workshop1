/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;
   

import java.util.List;

// hier mist misschien nog wat imports.
/**
 *
 * @author Frank
 */
public interface KlantInterface {
  


//de list heet Klant.

    public List<Klant> klantlijst();
    
    
    //finders
    public Klant findKlant(Klant bestaandeKlant);
    //public List<Klant> findKlant(Adres klantAdres);
    public Klant findBijID(int idKlant);
    public Klant findBijNaam(String voornaam,String tussenvoegsel, String achternaam);
    public Klant findBijVoornaam(String voornaam);
    public Klant findBijLastName(String achternaam);
    
    
    
    public void create(Klant klant);
    public void update(Klant klant);
    public void delete(Klant klant);
}
    
   
    
    

