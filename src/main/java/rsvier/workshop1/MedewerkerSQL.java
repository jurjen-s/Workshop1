/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Frank
 */
public class MedewerkerSQL implements MedewerkerDAO{
    
    
     private Connection medewerkerconnectie;
    
    public MedewerkerSQL(Connection connectie) {
        this.medewerkerconnectie = connectie;
    }

    @Override
    public boolean deleteMedewerker(int id) {
        
        // String query = "DELETE FROM klant_has_adres (=NAAM TUSSEN TABLE! ) WHERE Klant_klant_id (NAAM=FK ALS DIE ER IS) = " + klant.getKlantID(); 
       
        String query = "DELETE FROM medewerkers WHERE medewerkers_id = " + id;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt = medewerkerconnectie.prepareStatement(query)
        	)
                {
        	
        
            stmt.executeUpdate();
          
            
            System.out.println("Account gegevens zijn succesvol verwijderd");
        }
        catch (SQLException foutmedewerkerdelete){
         System.out.println(foutmedewerkerdelete.getMessage());
              return false;  
        } 
        
        return true;
    }

    @Override
    public Medewerker findMedewerkerByID(int id) {
        String query = "SELECT * FROM medewerkers WHERE medewerkers_id = '" + id + "'";
        Medewerker medewerker = new Medewerker();
        try (
        		PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                medewerker.setMedewerkerID(resultset.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(resultset.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(resultset.getString("email"));
                medewerker.setMedewerkerVoornaam(resultset.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(resultset.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(resultset.getString("achternaam"));
        
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
       	System.out.println(ex2.getMessage());
        }
        
        return medewerker;    
    }

    @Override
    public Medewerker createMedewerker(int medewerkerAccountID, String email, String voornaam, String tussenvoegsel, String achternaam) {
        
         
        Medewerker medewerker = new Medewerker();
        
        
      String query = "INSERT INTO medewerkers (FK_medewerkers_accounts_id, email , voornaam,tussenvoegsel,achternaam) VALUES ( ? , ? , ? , ? , ? ) ";
       
      String query2 = "SELECT * FROM medewerkers WHERE FK_medewerkers_accounts_id = '"+ medewerkerAccountID + " ' HAVING voornaam = '"+ voornaam+ "' ";
      
      
        try (PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
             PreparedStatement stmt2 = medewerkerconnectie.prepareStatement(query2)){	
            
            
            stmt.setInt(1,medewerkerAccountID);
            stmt.setString(2,email);
            stmt.setString(3,voornaam);
            stmt.setString(4,tussenvoegsel);
            stmt.setString(5,achternaam);
            
           // ResultSet resultset =
         
         int operatie = stmt.executeUpdate();
        
        
         ResultSet rs = stmt2.executeQuery();
        
        while (rs.next()){
            
      //System.out.println(rs.getInt("medewerkers_id")); System.out.print("is uw medewerkers id");
                System.out.println("medewerker id is :");
                System.out.println(rs.getString(1));System.out.print(" ");
                System.out.print(rs.getString(2));System.out.print(" ");
                  System.out.print(rs.getString(3));System.out.print(" ");
                    System.out.print(rs.getString(4));System.out.print(" ");
                    System.out.print(rs.getString(5));System.out.print(" ");
                    System.out.print(rs.getString(6));System.out.print(" ");
                  
                  System.out.println(" ");
                  
                medewerker.setMedewerkerID(rs.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(rs.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(rs.getString("email"));
                medewerker.setMedewerkerVoornaam(rs.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(rs.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(rs.getString("achternaam"));
        }
        
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
                }
            
         
        return medewerker;
    }

    @Override
    public Medewerker findMedewerkerByVoornaam(String voornaam) {
        String query = "SELECT * FROM medewerkers WHERE voornaam = '" + voornaam + "'";
        Medewerker medewerker = new Medewerker();
        try (
        		PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                medewerker.setMedewerkerID(resultset.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(resultset.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(resultset.getString("email"));
                medewerker.setMedewerkerVoornaam(resultset.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(resultset.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(resultset.getString("achternaam"));
        
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
       	System.out.println(ex2.getMessage());
        }
        
        return medewerker;    
    }

    @Override
    public Medewerker updateMedewerker(int medewerkerID, int medewerkerAccountID, String email, String voornaam, String tussenvoegsel, String achternaam) {
         
        Medewerker medewerker = new Medewerker();
        
        
      String query = "UPDATE medewerkers SET medewerkers_id = ? ,FK_medewerkers_accounts_id = ?, email = ? , voornaam = ?,tussenvoegsel = ?,achternaam = ? WHERE medewerkers_id = ? ";
       
      String query2 = "SELECT * FROM medewerkers WHERE medewerkers_id = ' "+ medewerkerID +  "' AND FK_medewerkers_accounts_id = '"+ medewerkerAccountID + " ' ";
      
      
        try (PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
             PreparedStatement stmt2 = medewerkerconnectie.prepareStatement(query2)){	
            
            stmt.setInt(1, medewerkerID);
            stmt.setInt(2, medewerkerAccountID);
            stmt.setString(3, email);
            stmt.setString(4,voornaam);
            stmt.setString(5,tussenvoegsel);
            stmt.setString(6,achternaam);
            stmt.setInt(7,medewerkerID);
            
           // ResultSet resultset =
         
         stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
        
        while (rs.next()){
            
      System.out.println(rs.getInt("medewerkers_id"));
                
                
                medewerker.setMedewerkerID(rs.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(rs.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(rs.getString("email"));
                medewerker.setMedewerkerVoornaam(rs.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(rs.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(rs.getString("achternaam"));
        }
        
         
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
                }
            
         
        return medewerker;
    }
/*
    @Override
    public Medewerker findMedewerkerByVoornaam(String voornaam) {
        String query = "SELECT * FROM medewerkers WHERE voornaam = '" + voornaam + "'";
        Medewerker medewerker = new Medewerker();
        try (
        		PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                medewerker.setMedewerkerID(resultset.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(resultset.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(resultset.getString("email"));
                medewerker.setMedewerkerVoornaam(resultset.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(resultset.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(resultset.getString("achternaam"));
        
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
       	System.out.println(ex2.getMessage());
        }
        
        return medewerker;    
    }
*/
    @Override
    public Medewerker findMedewerkerByAchternaam(String achternaam) {
         String query = "SELECT * FROM medewerkers WHERE achternaam = '" + achternaam + "'";
        Medewerker medewerker = new Medewerker();
        try (
        		PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                medewerker.setMedewerkerID(resultset.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(resultset.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(resultset.getString("email"));
                medewerker.setMedewerkerVoornaam(resultset.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(resultset.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(resultset.getString("achternaam"));
        
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
       	System.out.println(ex2.getMessage());
        }
        
        return medewerker;    
    }


    @Override
    public Medewerker findMedewerkerByEmail(String email) {
         String query = "SELECT * FROM medewerkers WHERE email = '" + email + "'";
        Medewerker medewerker = new Medewerker();
        try (
        		PreparedStatement stmt = medewerkerconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                medewerker.setMedewerkerID(resultset.getInt("medewerkers_id"));
                medewerker.setMedewerkerAccountID(resultset.getInt("FK_medewerkers_accounts_id"));
                medewerker.setMedewerkerEmail(resultset.getString("email"));
                medewerker.setMedewerkerVoornaam(resultset.getString("voornaam"));
                medewerker.setMedewerkerTussenvoegsel(resultset.getString("tussenvoegsel"));
                medewerker.setMedewerkerAchternaam(resultset.getString("achternaam"));
        
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
       	System.out.println(ex2.getMessage());
        }
        
        return medewerker;    
    }
    
    
    
    
    
    
}
