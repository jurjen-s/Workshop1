/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.klant;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import rsvier.workshop1.db.SQLConnection;
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
    public List findBijID(int idKlant) {
        
        List<Klant> zoekresultaat = klantDAO.findBijID(idKlant);
        return zoekresultaat;
    }
    
    public List findBijNaam(String voornaam,String tussenvoegsel, String achternaam) {
        
        List<Klant> zoekresultaat = klantDAO.findBijNaam(voornaam, tussenvoegsel, achternaam);
        return zoekresultaat;
    }
   
    public List findBijVoornaam(String voornaam) {
        
        List<Klant> zoekresultaat = klantDAO.findBijVoornaam(voornaam);
        return zoekresultaat;
    }
    
    public List findBijLastName(String achternaam) {
        
        List<Klant> zoekresultaat = klantDAO.findBijLastName(achternaam);
        return zoekresultaat;
    }
    
    public Klant createKlant( int accountidvanklant, String VN, int Heefttussenvoegsel, String TV, String AN, String Telefoonnr) {
        Klant klantinfo = new Klant();
        klantinfo = klantDAO.createKlant(accountidvanklant,  VN, Heefttussenvoegsel, TV, AN, Telefoonnr);
        return klantinfo;
    }
        
    public Klant updateKlant(int accountidvanklant, String VN, int Heefttussenvoegsel, String TV , String AN, String Telefoonnr) {
        Klant klantNaarMenu4 = new Klant();
        klantNaarMenu4 = klantDAO.updateKlant(accountidvanklant,VN,Heefttussenvoegsel, TV ,AN,Telefoonnr);
        return klantNaarMenu4;
    }
    
    public boolean deleteKlant(int kid) {
        boolean klantNaarMenuX;
        klantNaarMenuX = klantDAO.deleteKlant(kid);
        return klantNaarMenuX;
    }
    
    public List ShowAllKlant(){
        
        List<Klant> results = klantDAO.klantlijst();
        return results;
        
    }
    
    
    
    
    
    
    
    
    
    
    
}
