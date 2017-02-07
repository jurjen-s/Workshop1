/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;


import java.util.List;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author Frank
 */
public class KlantDAOinterfaceImpl implements KlantInterface {
    
    //specifieke connectie open laten.
    private Connection connectie;
    
    
     // public List<Klant> klantlijst = new ArrayList<>();
    
    
    
    
     public KlantDAOinterfaceImpl(Connection connectie) {
        this.connectie = connectie;
    }
    
     
     

    @Override
    public List<Klant> klantlijst() {
        
        //Maakt een klanten lijst
        List<Klant> klanten = new ArrayList<>();
        Klant klant;
        String query = "SELECT * FROM klanten";
        try (
        		PreparedStatement stmt = connectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        	

            while(resultset.next()) {
                //stop klant object in klanten List
                klant = new Klant();
                
                klant.setKlantenID(resultset.getInt("klanten_id"));
                klant.setVoornaam(resultset.getString("voornaam"));
                klant.setAchternaam(resultset.getString("achternaam"));
                klant.setTussenvoegsel(resultset.getString("tussenvoegsel"));
                klant.setTelefoonnummer(resultset.getInt("telefoonnummer"));
                klant.setFKaccountsID (resultset.getInt("FK_accounts_id"));
                klant.setFKadressenKlant (resultset.getInt("FK_adressen_klant"));
                klant.setFKadressenType (resultset.getInt("FK_adressen_type"));
                
                
                
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
                klant.setFKaccountsID(resultset.getInt("FK_adressen_id"));
                klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klant.setFKadressenType(resultset.getInt("FK_adressen_type"));
                
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
        } catch (SQLException ex) {
        	
        }
        
        return klant;
       
    }

    @Override
    public Klant findBijNaam(String voornaam, String tussenvoegsel, String achternaam) {
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
                klant.setFKaccountsID(resultset.getInt("FK_adressen_id"));
                klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klant.setFKadressenType(resultset.getInt("FK_adressen_type"));
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
                 { System.out.println("findBijNaam deed het niet goed");
               	
                 }
        
        return klant;
    }

    @Override
    public Klant findBijVoornaam(String voornaam) {
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
                klant.setFKaccountsID(resultset.getInt("FK_adressen_id"));
                klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klant.setFKadressenType(resultset.getInt("FK_adressen_type"));
                
                
                
                
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
                klant.setFKaccountsID(resultset.getInt("FK_adressen_id"));
                klant.setFKadressenKlant(resultset.getInt("FK_adressen_klant"));
                klant.setFKadressenType(resultset.getInt("FK_adressen_type"));
                
                
                
            }//einde if
        } //einde try
        catch (SQLException exfoutbijachternaam) {
       	
        }
        
        return klant;        
        
        
       
    }

    @Override
    //public void create(Klant klant) {
        public void create(Klant klant) {
        
        
        String query = "INSERT into klanten(voornaam, achternaam, tussenvoegsel, telefoonnummer , FK_accounts_id  ,  FK_adressen_type , klanten_id )"+
                " VALUES (?, ? ,?, ? , ? , ? , ?  )";
        
       // ResultSet resultSet;
try( PreparedStatement stmt = connectie.prepareStatement(query)){
    
//, Statement.RETURN_GENERATED_KEYS)
     
            stmt.setString(1,klant.getVoornaam());
            stmt.setString(2, klant.getTussenvoegsel());
            stmt.setString(3, klant.getAchternaam());
            stmt.setInt(4, klant.getTelefoonnummer());
            stmt.setInt(5, klant.getFKaccountsID());
           // stmt.setInt(6, klant.getFKadressenKlant());
            stmt.setInt(6, klant.getFKadressenType());
            stmt.setInt(7, klant.getKlantenID());
            
            
            
            /**
            stmt.setInt(5, klant.getBezorghuisnummer());
            stmt.setString(6, klant.getBezorgHuisnummertoevoeging());
            stmt.setString(7, klant.getBezorgPostcode());
            stmt.setString(8, klant.getFactuurPostcode());
            stmt.setInt(9, klant.getFactuurhuisnummer());
            stmt.setString(10, klant.getFactuurHuisnummertoevoeging());
            stmt.setString(11, klant.getLand());
            stmt.setInt(12, klant.getMedewerkerID()); 
            */
            
            stmt.executeUpdate();
            stmt.close();
            
            
            //Geeft door database gegenereerde id aan klant
           // resultSet = stmt.getGeneratedKeys();
            
           // if (resultSet.isBeforeFirst()) {
            //    resultSet.next();
            //    klant.setKlantID(resultSet.getInt(1));
         //   }            
           //klant is gemaakt           
        } catch (SQLException excreate) {
        	  System.out.println("Er ging iets mis bij het createn van het klant object.");
         System.out.println(excreate.getMessage());
        }      
    }
        
 
        
        
        
        
        
        
        
    

    @Override
    public void update(Klant klant) {
         String query = "UPDATE klant SET idklant = ?, voornaam = ?, tussenvoegsel = ?, achternaam = ?, telefoonnummer = ?, FK_accounts_id = ?, FK_adressen_klant = ?, FK_adressen_type = ?   WHERE klanten_id = ?";
        try (
            PreparedStatement stmt = connectie.prepareStatement(query);){

            stmt.setInt(1, klant.getKlantenID());
            stmt.setString(2,klant.getVoornaam());
            stmt.setString(3, klant.getTussenvoegsel());
            stmt.setString(4, klant.getAchternaam());
            stmt.setInt(5, klant.getTelefoonnummer());
            stmt.setInt(6, klant.getFKaccountsID());
            stmt.setInt(7, klant.getFKadressenKlant());
            stmt.setInt(8, klant.getFKadressenType());
            stmt.setInt(9, klant.getKlantenID());
            /**
             stmt.setInt(1, klant.getKlantID());
            stmt.setString(2,klant.getVoornaam());
            stmt.setString(3, klant.getTussenvoegsel());
            stmt.setString(4, klant.getAchternaam());
            stmt.setInt(5, klant.getTelefoonnummer());
            stmt.setInt(6, klant.getBezorghuisnummer());
            stmt.setString(7, klant.getBezorgHuisnummertoevoeging());
            stmt.setString(8, klant.getBezorgPostcode());
            stmt.setString(9, klant.getFactuurPostcode());
            stmt.setInt(10, klant.getFactuurhuisnummer());
            stmt.setString(11, klant.getFactuurHuisnummertoevoeging());
            stmt.setString(12, klant.getLand());
            stmt.setInt(13, klant.getMedewerkerID()); 
            stmt.setInt(14, klant.getKlantID());
            stmt.executeUpdate();
              */        
        } catch (SQLException exupdate) {
        	
        }     
    }

    @Override
    public void delete(Klant klant) {
       // String query = "DELETE FROM klant_has_adres (=NAAM TUSSEN TABLE! ) WHERE Klant_klant_id (NAAM=FK ALS DIE ER IS) = " + klant.getKlantID(); 
        String query2 = "DELETE FROM klanten WHERE klanten_id = " + klant.getKlantenID();        
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
        	
                
        }   
    }
    
}
