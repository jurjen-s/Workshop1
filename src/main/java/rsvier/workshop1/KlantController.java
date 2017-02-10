/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;
import java.sql.Connection;
import java.util.List;
/**
 *
 * @author Frank
 */
public class KlantController {
    
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    
    
    private KlantDAO klantDAO = new KlantSQL(sqlConnectie);
    
    
    
    
    /*
     public List<Klant> klantlijst();
    
    
    //finders
    public Klant findKlant(Klant bestaandeKlant);
   
    */
    public Klant findBijID(int idKlant){
        
        Klant klantNaarMenu = new Klant();
        
        klantNaarMenu = klantDAO.findBijID(idKlant);
        
        return klantNaarMenu;
        
        
    }
    
    
    
    
    
    public Klant findBijNaam(String voornaam,String tussenvoegsel, String achternaam){
        
         Klant klantNaarMenu2 = new Klant();
        
        klantNaarMenu2 = klantDAO.findBijNaam(voornaam, tussenvoegsel, achternaam);
        
        return klantNaarMenu2;
        
        
        
        
    }
   
    public Klant findBijVoornaam(String voornaam){
        
        Klant klantNaarMenu3 = new Klant();
        
        klantNaarMenu3 = klantDAO.findBijVoornaam(voornaam);
        
        return klantNaarMenu3;
        
    }
    
    
   public Klant findBijLastName(String achternaam){
    
     Klant klantNaarMenu4 = new Klant();
        
        klantNaarMenu4 = klantDAO.findBijLastName(achternaam);
        
        return klantNaarMenu4;
    
    
}
    
    
  
    public Klant createKlant( int accountidvanklant, String VN, int Heefttussenvoegsel, String TV, String AN, int Telefoonnr){
    
    Klant klantinfo = new Klant();
        
        klantinfo = klantDAO.createKlant(accountidvanklant,  VN, Heefttussenvoegsel, TV, AN, Telefoonnr);
        
        return klantinfo;
        
               
    }
        
        
        
        
        
        
        
    public Klant updateKlant(int accountidvanklant, String VN, int Heefttussenvoegsel, String TV , String AN, int Telefoonnr){
        
        Klant klantNaarMenu4 = new Klant();
        
        klantNaarMenu4 = klantDAO.updateKlant(accountidvanklant,VN,Heefttussenvoegsel, TV ,AN,Telefoonnr);
        
        return klantNaarMenu4;
        
    }
    
    
    public boolean deleteKlant(int kid){
        
         boolean klantNaarMenuX ;
        
        klantNaarMenuX = klantDAO.deleteKlant(kid);
        
        return klantNaarMenuX;
        
        
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
