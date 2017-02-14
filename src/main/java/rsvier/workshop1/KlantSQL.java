/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;


import java.util.List;

import java.sql.*;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Frank
 */
public class KlantSQL implements KlantDAO {
    
    
     private static final Logger LOGGER = LogManager.getLogger(KlantSQL.class);
    //specifieke connectie open laten.
    private Connection connectie;
    
    
     // public List<Klant> klantlijst = new ArrayList<>();
    
    
    
    
     public KlantSQL(Connection connectie) {
        this.connectie = connectie;
    }
    
     
     
//onzin
    @Override
    public List<Klant> klantlijst() {
        
        //Maakt een klanten lijst
        List<Klant> klanten = new ArrayList<>();
        Klant klant;
        String query = "SELECT * FROM klanten";
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query)) {
        		ResultSet resultset = stmt.executeQuery();
        	

            while(resultset.next()) {
                //stop klant object in klanten List
                klant = new Klant();
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setFKaccountsID (resultset.getInt("FK_accounts_id"));
                
                
                
                /**
                klant.setBezorghuisnummer(resultset.getInt("Bezorghuisnummer"));
                klant.setBezorgHuisnummertoevoeging(resultset.getString("BezorghuisnummerToevoeging"));
                klant.setBezorgPostcode(resultset.getString("BezorgPostcode"));
                klant.setFactuurPostcode(resultset.getString("FactuurPostcode"));
                klant.setFactuurhuisnummer(resultset.getInt("FactuurHuisnummer"));
                klant.setFactuurHuisnummertoevoeging(resultset.getString("FactuurHuisnummerToevoeging"));
                klant.setLand(resultset.getString("Land"));
                klant.setMedewerkerID(resultset.getInt("Medewerker_idMedewerker"));
                */
                klanten.add(klant);
            } 
        } catch (SQLException exklantenlijst) {
        	//"gaat iets mis");
        }     
        //"Klanten gevonden");
        return klanten;
    }
    
    
    
    
    
    //onzin
    @Override
    public Klant findKlant(Klant bestaandeKlant) {
        int    klantID            = bestaandeKlant.getKlantenID();
        String klantVoornaam      = bestaandeKlant.getVoornaam();
        String klantAchternaam    = bestaandeKlant.getAchternaam();
        String klantTussenvoegsel = bestaandeKlant.getTussenvoegsel();
        
        if (klantID != 0) {
//id was niet null, klant zoeken op idKlant            
        	
        	return findBijID(klantID);
        	}        
        
        else if (klantVoornaam != null && klantVoornaam.length() >= 1 && klantAchternaam.length() >= 1) {
        	//klant zoeken op voor en tussenvoegsel en achternaam
        	return findBijNaam(klantVoornaam,klantTussenvoegsel, klantAchternaam);
        }
        
        else if (klantVoornaam != null && klantVoornaam.length() >= 1) {
        	//klant zoeken op voornaam en voornaam was groter dan 0");
        	return findBijVoornaam(klantVoornaam);
        	}
        
        else {
        	System.out.println("Niks gevonden");
        	return null;
        }
    } 

    @Override
    public Klant findBijID(int klantenid) {
        LOGGER.debug("input bij findBijID is {}",klantenid);
         String query = "SELECT * FROM klanten WHERE klanten_id = " + klantenid;
        Klant klant = new Klant();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        	
            ///maak java klant       
            if (resultset.next()) {                
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
               // klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klant.setHeeftTusv(resultset.getInt("heeft_tussenvoegsel"));
                
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
                
            } //eindeif
            
         //einde try   
        } catch (SQLException ex) { System.out.println(ex.getMessage());
        	
        }
        
        return klant;
       
    }

    @Override
    public Klant findBijNaam(String voornaam, String tussenvoegsel, String achternaam) {
           LOGGER.debug("input bij findBijNaam is {}{}{}",voornaam, tussenvoegsel,achternaam);
       String query = "SELECT * FROM klanten WHERE voornaam = '" + voornaam + "' AND achternaam = '" + achternaam + "' AND tussenvoegsel = '" + tussenvoegsel + "'       ";
        Klant klant = new Klant();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();)
        
        {
                  ///maak klant en set de gegevens er in    (je wilt er mee werken uiteindelijk)       
            if (resultset.next()) {
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
                klant.setHeeftTusv(resultset.getInt("heeft_tussenvoegsel"));
                
                /**
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
                 catch(SQLException foutfindbijnaam)  
                 { System.out.println(    foutfindbijnaam.getMessage()   );
               	
                 }
        
        return klant;
    }

    @Override
    public Klant findBijVoornaam(String voornaam) {
           LOGGER.debug("input bij findBijVoornaam is {}",voornaam);
       String query = "SELECT * FROM klanten WHERE voornaam = '" + voornaam + "'";
        Klant klant = new Klant();
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
               
                
                
                
                
                
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
        catch (SQLException exfoutbijvoornaam) {
       	System.out.println(exfoutbijvoornaam.getMessage());
        }
        
        return klant;        
    } 
    
    
    
    
    
    
    
    
    
    
    @Override
    public Klant findBijLastName(String achternaam) {
        
         String query = "SELECT * FROM klanten WHERE achternaam = '" + achternaam + "'";
        Klant klant = new Klant();
       try (
        		PreparedStatement stmt = connectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden achternaam.
            if (resultset.next()) {
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                
                klant.setHeeftTusv(resultset.getInt("heeft_tussenvoegsel"));
                klant.setFKaccountsID(resultset.getInt("FK_klanten_accounts_id"));
                
                
            }//einde if
        } //einde try
        catch (SQLException exfoutbijachternaam) {
       	System.out.println(exfoutbijachternaam.getMessage());
        }
        
        return klant;        
        
        
       
    }

    @Override
       public Klant createKlant( int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, int Telefoonnr) {
        
        Klant klant = new Klant();
            
            
         String query = "INSERT INTO klanten (FK_klanten_accounts_id,voornaam,heeft_tussenvoegsel,tussenvoegsel,achternaam,telefoonnummer) VALUES (? , ? , ? , ? , ? , ?  ) ";
       
        String query2 = "SELECT * FROM klanten WHERE FK_klanten_accounts_id = ' "+ accountidvanklant +" ' AND achternaam = '"+ AN +"' ";
      
      
        try (PreparedStatement stmt = connectie.prepareStatement(query);
             PreparedStatement stmt2 = connectie.prepareStatement(query2)){	
            
            stmt.setInt(1, accountidvanklant);
            stmt.setString(2, VN);
            stmt.setInt(3, Heefttussenvoegsel);
            stmt.setString(4, TV);
            stmt.setString(5, AN);
            stmt.setInt(6,Telefoonnr);
            
                    
         stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
                while (rs.next()){
                    
                          
                klant.setKlantenID(rs.getInt("klanten_id")); 
                klant.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
                klant.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                klant.setVoornaam(rs.getString("voornaam"));
                klant.setTussenvoegsel(rs.getString("tussenvoegsel"));
                klant.setAchternaam(rs.getString("achternaam"));
                klant.setTelefoonnummer(rs.getInt("telefoonnummer"));
        }
        
         
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
                }
        
      
        return klant;
        
        }
        
        
        
    

    @Override
    public Klant updateKlant(int accountidvanklant,  String VN, int Heefttussenvoegsel, String TV, String AN, int Telefoonnr) {
        
        Klant klant = new Klant();
        
        
         String query = "UPDATE klant SET FK_klanten_account_id = ?, voornaam = ?, tussenvoegsel = ?, achternaam = ?, telefoonnummer = ?,  heeft_tussenvoegsel = ? ";
         
         String query2 = "SELECT * FROM klanten WHERE FK_klanten_accounts_id = ' " + accountidvanklant +" ";
        
         try (PreparedStatement stmt = connectie.prepareStatement(query);
             PreparedStatement stmt2 = connectie.prepareStatement(query2)){	

            stmt.setInt(1, accountidvanklant);
            stmt.setString(2,VN);
            stmt.setString(3, TV);
            stmt.setString(4, AN);
            stmt.setInt(5, Telefoonnr);
           
            stmt.setInt(6, Heefttussenvoegsel);
           
            
            stmt.executeUpdate();
                 
             ResultSet rs = stmt2.executeQuery();
          
                while (rs.next()){
                  System.out.println(rs.getInt("klanten_id"));
            
                klant.setKlantenID(rs.getInt("klanten_id"));
   
                klant.setFKaccountsID(rs.getInt("FK_klanten_accounts_id"));
      
      
                klant.setVoornaam(rs.getString("voornaam"));
                klant.setHeeftTusv(rs.getInt("heeft_tussenvoegsel"));
                klant.setTussenvoegsel(rs.getString("tussenvoegsel"));
                klant.setAchternaam(rs.getString("achternaam"));
                klant.setTelefoonnummer(rs.getInt("telefoonnummer"));
        }
        
         
        }
        catch(SQLException exV){
        System.out.println(exV.getMessage());
                }
           	
        
        return klant;
    }

    @Override
    public boolean deleteKlant(int klantid) {
        
        String query2 = "DELETE FROM klanten WHERE klanten_id = " + klantid ;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = connectie.prepareStatement(query2);
        		){
        	
           // stmt.executeUpdate();
            //Klant verwijdert uit tussen tabel mocht die er zijn.
            stmt2.executeUpdate();
            // Klant verwijderd, zie query
            
            System.out.println("Klant gegevens zijn succesvol verwijderd");
        } catch (SQLException foutdelete) {
        	
            return true;    
        }    return true;
    }

    
    
   
}
