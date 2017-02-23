/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.klant;


import java.util.List;

import java.sql.*;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Frank
 */
public class KlantMySQL implements KlantDAO {
    
    
     private static final Logger LOGGER = LogManager.getLogger(KlantMySQL.class);
    //specifieke connectie open laten.
     
     
    private Connection connectie;
    
    
    
     public KlantMySQL(Connection connectie) {
        this.connectie = connectie;
    }
    
     
     

    @Override
    public List klantlijst() {
        
        
        
        
        String query = "SELECT * FROM klanten";
        List<Klant> klantenl = new ArrayList<Klant>();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query)) {
        		ResultSet resultset = stmt.executeQuery();
        	
            
            
            while(resultset.next()) {
               
                //stop klant object in klanten List
                Klant klant = new Klant();
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getString("telefoonnummer"));
                klant.setFKaccountsID (resultset.getInt("FK_klanten_accounts_id"));
                
                klantenl.add(klant);
                
              
                
            } 
            return klantenl;
        } catch (SQLException ex) {
            LOGGER.debug("Het volgende ging mis bij het maken van een klantlijst: {}", ex.getMessage());
        }     
        //"Klanten gevonden");
        return klantenl;
    }
    
    
    
    
  

    @Override
    public List findBijID(int klantenid) {
        List<Klant> zoekresultaat = new ArrayList<>();
        LOGGER.debug("input bij findBijID is {}",klantenid);
         String query = "SELECT * FROM klanten WHERE klanten_id = ?";
        Klant klant = new Klant();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query)) {
                        stmt.setInt(1, klantenid);
        		ResultSet resultset = stmt.executeQuery();
        	
            ///maak java klant       
            while (resultset.next()) {                
                Klant klantnext = new Klant();
                klantnext.setKlantenID(resultset.getInt("klanten_id"));
                klantnext.setVoornaam(resultset.getString("voornaam"));
                klantnext.setAchternaam(resultset.getString("achternaam"));
                klantnext.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klantnext.setTelefoonnummer(resultset.getString("telefoonnummer"));
                klantnext.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
               // klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klantnext.setHeeftTusv(resultset.getInt("heeft_tussenvoegsel"));
                
                zoekresultaat.add(klantnext);
                /**
                klant.setBezorghuisnummer(resultset.getInt("Bezorghuisnummer"));
                klant.setBezorgHuisnummertoevoeging(resultset.getString("BezorghuisnummerToevoeging"));
                klant.setBezorgPostcode(resultset.getString("BezorgPostcode"));
                klant.setFactuurPostcode(resultset.getString("FactuurPostcode"));
                klant.setFactuurhuisnummer(resultset.getInt("FactuurHuisnummer"));
                klant.setFactuurHuisnummertoevoeging(resultset.getString("FactuurHuisnummerToevoeging"));
                klant.setLand(resultset.getString("Land"));
                klant.setMedewerkerID(resultset.getInt("Medewerker_idMedewerker"));;
                */
                
            } //while
            
         //einde try   
        } catch (SQLException ex) { System.out.println(ex.getMessage());
        	 LOGGER.error("Er gaat iets mis met het bekijken van een klanten op klantID: {}", ex.getMessage());
        }
        LOGGER.debug("output bij findBijID is "+ klant.getStringKlant());
        return zoekresultaat;
       
    }

    @Override
    public List findBijNaam(String voornaam, String tussenvoegsel, String achternaam) {
        List<Klant> zoekresultaat = new ArrayList<>();
       LOGGER.debug("input bij findBijNaam is {} {} {}",voornaam, tussenvoegsel,achternaam);
       Klant klant = new Klant();
       //Onderscheid maken tussen namen met en zonder tussenvoegsel
        if (tussenvoegsel.equals("")) {
           String query = "SELECT * FROM klanten WHERE voornaam = ? AND achternaam = ?";
           try (PreparedStatement stmt = connectie.prepareStatement(query)) {
           stmt.setString(1, voornaam);
           stmt.setString(2, achternaam);
           ResultSet rs = stmt.executeQuery();
           ///maak klant en set de gegevens er in    (je wilt er mee werken uiteindelijk)   
                while (rs.next()) {
                klant.setKlantenID(rs.getInt("klanten_id"));
                klant.setVoornaam(rs.getString("voornaam"));
                klant.setAchternaam(rs.getString("achternaam"));
                klant.setTussenvoegsel(rs.getString("tussenvoegsel"));
                klant.setTelefoonnummer(rs.getString("telefoonnummer"));
                klant.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
                klant.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                }
           } catch(SQLException ex)  {
                LOGGER.error("Er gaat iets mis met het bekijken van een klanten op naam : {}", ex.getMessage());
           }
        } else {
            String query = "SELECT * FROM klanten WHERE voornaam = ? AND achternaam = ? AND tussenvoegsel = ?";
            try (PreparedStatement stmt = connectie.prepareStatement(query)) {
                stmt.setString(1, voornaam);
                stmt.setString(2, achternaam);
                stmt.setString(3, tussenvoegsel);
                ResultSet rs = stmt.executeQuery();
                ///maak klant en set de gegevens er in    (je wilt er mee werken uiteindelijk)   
                while (rs.next()) {
                    Klant klantnext = new Klant();
                    klantnext.setKlantenID(rs.getInt("klanten_id"));
                    klantnext.setVoornaam(rs.getString("voornaam"));
                    klantnext.setAchternaam(rs.getString("achternaam"));
                    klantnext.setTussenvoegsel(rs.getString("tussenvoegsel"));
                    klantnext.setTelefoonnummer(rs.getString("telefoonnummer"));
                    klantnext.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
                    klantnext.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                    zoekresultaat.add(klantnext);
                    
                }
            } catch(SQLException ex)  {
                LOGGER.error("Er gaat iets mis met het bekijken van een klanten op naam : {}", ex.getMessage());
            }
        }
        LOGGER.debug("output bij findBijNaam is "+ klant.getStringKlant());
        return zoekresultaat;
    }

    @Override
    public List findBijVoornaam(String voornaam) {
        List<Klant> zoekresultaat = new ArrayList<>();
           LOGGER.debug("input bij findBijVoornaam is {}",voornaam);
       String query = "SELECT * FROM klanten WHERE voornaam = ?";
        Klant klant = new Klant();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query)) {
                        stmt.setString(1, voornaam);
            ResultSet resultset = stmt.executeQuery();
        
            ///geef alle data naar java toe met de gevonden voornaam.
            while (resultset.next()) {
                Klant klantnext = new Klant();
                klantnext.setKlantenID(resultset.getInt("klanten_id"));
                klantnext.setVoornaam(resultset.getString("voornaam"));
                klantnext.setAchternaam(resultset.getString("achternaam"));
                klantnext.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klantnext.setTelefoonnummer(resultset.getString("telefoonnummer"));
                klantnext.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
               zoekresultaat.add(klantnext);
                
                
                
                
                
                /**
                klant.setKlantID(resultset.getInt("idKlant"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setBezorghuisnummer(resultset.getInt("Bezorghuisnummer"));
                klant.setBezorgHuisnummertoevoeging(resultset.getString("BezorghuisnummerToevoeging"));
                klant.setBezorgPostcode(resultset.getString("BezorgPostcode"));
                klant.setFactuurPostcode(resultset.getString("FactuurPostcode"));
                klant.setFactuurhuisnummer(resultset.getInt("FactuurHuisnummer"));
                klant.setFactuurHuisnummertoevoeging(resultset.getString("FactuurHuisnummerToevoeging"));
                klant.setLand(resultset.getString("Land"));
                klant.setMedewerkerID(resultset.getInt("Medewerker_idMedewerker"));
                */
                
                
            }//einde if
        } //einde try
        catch (SQLException ex) {
       	LOGGER.error("Er gaat iets mis met het bekijken van een klanten op voornaam {}", ex.getMessage());
        }
        LOGGER.debug("output bij findBijVoornaam is "+ klant.getStringKlant());
        return zoekresultaat;        
    } 
    
    
    
    
    
    
    
    
    
    
    @Override
    public List findBijLastName(String achternaam) {
        List<Klant> zoekresultaat = new ArrayList<>();
        LOGGER.debug("input bij findBijLastName is {}",achternaam);
         String query = "SELECT * FROM klanten WHERE achternaam = ?";
        Klant klant = new Klant();
       try (
        		PreparedStatement stmt = connectie.prepareStatement(query)) {
        		stmt.setString(1, achternaam);
                        ResultSet resultset = stmt.executeQuery();
        
            ///geef alle data naar java toe met de gevonden achternaam.
            while (resultset.next()) {
                Klant klantnext = new Klant();
                
                klantnext.setKlantenID(resultset.getInt("klanten_id"));
                klantnext.setVoornaam(resultset.getString("voornaam"));
                klantnext.setAchternaam(resultset.getString("achternaam"));
                klantnext.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klantnext.setTelefoonnummer(resultset.getString("telefoonnummer"));
                
                klantnext.setHeeftTusv(resultset.getInt("heeft_tussenvoegsel"));
                klantnext.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
                
                zoekresultaat.add(klantnext);
                
            }//einde if
        } //einde try
        catch (SQLException ex) {
       	LOGGER.error("Er gaat iets mis met het bekijken van een klanten op achternaam {}", ex.getMessage());
        }
        LOGGER.debug("output bij findBijAchternaam is "+ klant.getStringKlant());
        return zoekresultaat;        
        
        
       
    }

    @Override
       public Klant createKlant( int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, String Telefoonnr) {
        LOGGER.debug("input bij create klant is {} {} {} {} {} {}",accountidvanklant,VN,Heefttussenvoegsel,TV,AN,Telefoonnr);
        Klant klant = new Klant();
            
            
         String query = "INSERT INTO klanten (FK_klanten_accounts_id,voornaam,heeft_tussenvoegsel,tussenvoegsel,achternaam,telefoonnummer) VALUES (? , ? , ? , ? , ? , ?  ) ";
       
        String query2 = "SELECT * FROM klanten WHERE FK_klanten_accounts_id = ? AND achternaam = ?";
      
      
        try (PreparedStatement stmt = connectie.prepareStatement(query);
             PreparedStatement stmt2 = connectie.prepareStatement(query2)){	
            
            stmt.setInt(1, accountidvanklant);
            stmt.setString(2, VN);
            stmt.setInt(3, Heefttussenvoegsel);
            stmt.setString(4, TV);
            stmt.setString(5, AN);
            stmt.setString(6,Telefoonnr);
            
            stmt2.setInt(1, accountidvanklant);
            stmt2.setString(2, AN);
            
                    
         stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
                while (rs.next()){
                    
                          
                klant.setKlantenID(rs.getInt("klanten_id")); 
                klant.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
                klant.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                klant.setVoornaam(rs.getString("voornaam"));
                klant.setTussenvoegsel(rs.getString("tussenvoegsel"));
                klant.setAchternaam(rs.getString("achternaam"));
                klant.setTelefoonnummer(rs.getString("telefoonnummer"));
        }
        
         
        }
        catch(SQLException ex){
        LOGGER.error("Er gaat iets mis met het maken van een klant {}", ex.getMessage());
                }
        
      LOGGER.debug("output bij create klant  is "+ klant.getStringKlant());
        return klant;
        
        }
        
        
        
    

    @Override
    public Klant updateKlant(int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, String Telefoonnr) {
        LOGGER.debug("input bij update klant is {} {} {} {} {} {}",accountidvanklant,VN,Heefttussenvoegsel,TV,AN,Telefoonnr);
        Klant klant = new Klant();
        
        
         String query = "UPDATE klanten SET FK_klanten_accounts_id = ?, voornaam = ?, tussenvoegsel = ?, achternaam = ?, telefoonnummer = ?,  heeft_tussenvoegsel = ? ";
         
         String query2 = "SELECT * FROM klanten WHERE FK_klanten_accounts_id = ?";
        
         try (PreparedStatement stmt = connectie.prepareStatement(query);
             PreparedStatement stmt2 = connectie.prepareStatement(query2)) {	

            stmt.setInt(1, accountidvanklant);
            stmt.setString(2,VN);
            stmt.setString(3, TV);
            stmt.setString(4, AN);
            stmt.setString(5, Telefoonnr);           
            stmt.setInt(6, Heefttussenvoegsel);
            stmt.executeUpdate();
            
            stmt2.setInt(1, accountidvanklant);
             ResultSet rs = stmt2.executeQuery();
          
                while (rs.next()){
                  System.out.println(rs.getInt("klanten_id"));
            
                klant.setKlantenID(rs.getInt("klanten_id"));
   
                klant.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
      
      
                klant.setVoornaam(rs.getString("voornaam"));
                klant.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                klant.setTussenvoegsel(rs.getString("tussenvoegsel"));
                klant.setAchternaam(rs.getString("achternaam"));
                klant.setTelefoonnummer(rs.getString("telefoonnummer"));
        }
        
         
        }
        catch(SQLException exV){
       LOGGER.error("Er gaat iets mis met het updaten van een klant {}", exV.getMessage());
                }
           	
        LOGGER.debug("output bij update klant is "+ klant.getStringKlant());
        return klant;
    }

    @Override
    public boolean deleteKlant(int klantid) {
        LOGGER.debug("input bij delete klant is {}",klantid);
        String query2 = "DELETE FROM klanten WHERE klanten_id = ?";        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = connectie.prepareStatement(query2))   {
        	
           // stmt.executeUpdate();
            //Klant verwijdert uit tussen tabel mocht die er zijn.
            stmt2.setInt(1, klantid);
            stmt2.executeUpdate();
            // Klant verwijderd, zie query
            
            System.out.println("Klant gegevens zijn succesvol verwijderd");
            return true;
        } catch (SQLException et) {
        	LOGGER.error("Er gaat iets mis met het verwijderen van een klant {}", et.getMessage());
            return true;    
        }    
    }

    
   

    
    
   
}