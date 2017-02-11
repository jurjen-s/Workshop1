/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Frank
 */

 

import java.util.List;

/**
 *
 * @author jurjen
 */
public class AdresSQL implements AdresDAO {

    
     private Connection adresconnectie;
    
    public AdresSQL(Connection connectie) {
        this.adresconnectie = connectie;
    }
    
    
    
    
    
    
    
    
    
    @Override
    public Adres findAdresById(int adresId) {
        String query = "SELECT * FROM adressen WHERE adressen_id = '" + adresId + "'";
        
        Adres adres = new Adres();
        //adresconnectie kan fout zijn!
        try (
        		PreparedStatement stmt = adresconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                adres.setAdresId(resultset.getInt("adressen_id"));
                adres.setAdresType(resultset.getInt("adressen_type"));
                adres.setKlantId(resultset.getInt("FK_adressen_klanten_id"));
                adres.setStraatnaam(resultset.getString("straatnaam"));
                adres.setHuisnummer(resultset.getInt("huisnummer"));
                adres.setHuisnrToevoeging(resultset.getString("huisnummer_toevoeging"));
                adres.setPostcode(resultset.getString("postcode"));
                adres.setLand(resultset.getString("land"));
                
                
             }//einde if
        } //einde try
        catch (SQLException ex) {
       	System.out.println(ex.getMessage());
        }
        
        return adres;    
    }

    @Override
    public List findAdresByType(int adresType) {
        // @@Controleren of klantId bestaat in database
        List<Adres> zoekresultaat = new ArrayList<>();
        //adresconnectie kan fout zijn!
        try (PreparedStatement stmt = adresconnectie.prepareStatement(
            "SELECT * " +
            "FROM adressen " +
            "WHERE adressen_type = ?")) {
            stmt.setInt(1, adresType);
            ResultSet resultset = stmt.executeQuery();
            int     nul = resultset.getInt("adressen_id");
            int     een = resultset.getInt("adressen_type");
            int     twee = resultset.getInt("FK_adressen_klanten_id");
            String  drie = resultset.getString("straatnaam");
            int     vier =  resultset.getInt("huisnummer");
            boolean     vijf = (resultset.getBoolean("heeft_huisnummer_toevoeging"));
            String x = resultset.getString("huisnummer_toevoeging");
            String  zes = resultset.getString("postcode");
            String  zeven =resultset.getString("land");
            
            // Laat alle bestellingen met het opgegeven klantId zien
            while (resultset.next()) {
            Adres gevondenAdres = new Adres.AdresBuilder()
        .adresId(nul)
        .adresType(een)
        .klantId(twee)
        .straatnaam(drie)
        .huisnummer(vier)
        .heeftHuisnrToevoeging(vijf)
        .huisnrToevoeging(x)
        .postcode(zes)
        .land(zeven)
        .build();
            zoekresultaat.add(gevondenAdres);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken van een adres op type.");
            ex.getMessage();
        }
        return zoekresultaat;
    }

    @Override
    public List findAdresByKlantId(int klantId) {
        // @@Controleren of klantId bestaat in database
        List<Adres> zoekresultaat = new ArrayList<>();
        //adresconnectie kan fout zijn!
        try (PreparedStatement stmt = adresconnectie.prepareStatement(
            "SELECT * " +
            "FROM adressen " +
            "WHERE FK_adressen_klanten_id = ?")) {
            stmt.setInt(1, klantId);
            ResultSet resultset = stmt.executeQuery();
            int     nul = (resultset.getInt("adressen_id"));
            int     een = (resultset.getInt("adressen_type"));
            int     twee = (resultset.getInt("FK_adressen_klanten_id"));
            String  drie = (resultset.getString("straatnaam"));
            int     vier = (resultset.getInt("huisnummer"));
            boolean     vijf = (resultset.getBoolean("heeft_huisnummer_toevoeging"));
            String x = (resultset.getString("huisnummer_toevoeging"));
            String  zes = (resultset.getString("postcode"));
            String  zeven =(resultset.getString("land"));
            
            // Laat alle bestellingen met het opgegeven klantId zien
            while (resultset.next()) {
            Adres gevondenAdres = new Adres.AdresBuilder()
        .adresId(nul)
        .adresType(een)
        .klantId(twee)
        .straatnaam(drie)
        .huisnummer(vier)
        .heeftHuisnrToevoeging(vijf)
        .huisnrToevoeging(x)
        .postcode(zes)
        .land(zeven)
        .build();
            zoekresultaat.add(gevondenAdres);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken van een adres op klant id.");
            ex.getMessage();
        }
        return zoekresultaat;
    }

    @Override
    public List findAdresByPostcode(String postcode) {
      
        // @@Controleren of klantId bestaat in database
        List<Adres> zoekresultaat = new ArrayList<>();
        //adresconnectie kan fout zijn!
        try (PreparedStatement stmt = adresconnectie.prepareStatement(
            "SELECT * " +
            "FROM adressen " +
            "WHERE postcode = ?")) {
            stmt.setString(1, postcode);
            ResultSet resultset = stmt.executeQuery();
            int     nul = (resultset.getInt("adressen_id"));
            int     een = (resultset.getInt("adressen_type"));
            int     twee = (resultset.getInt("FK_adressen_klanten_id"));
            String  drie = (resultset.getString("straatnaam"));
            int     vier = (resultset.getInt("huisnummer"));
            boolean     vijf = (resultset.getBoolean("heeft_huisnummer_toevoeging"));
            String x = (resultset.getString("huisnummer_toevoeging"));
            String  zes = (resultset.getString("postcode"));
            String  zeven =(resultset.getString("land"));
            
            // Laat alle bestellingen met het opgegeven klantId zien
            while (resultset.next()) {
            Adres gevondenAdres = new Adres.AdresBuilder()
        .adresId(nul)
        .adresType(een)
        .klantId(twee)
        .straatnaam(drie)
        .huisnummer(vier)
        .heeftHuisnrToevoeging(vijf)
        .huisnrToevoeging(x)
        .postcode(zes)
        .land(zeven)
        .build();
            zoekresultaat.add(gevondenAdres);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken van een adres op postcode.");
            ex.getMessage();
        }
        return zoekresultaat;
    }

    @Override
    public List findAdresByLand(String land) {
       
        // @@Controleren of klantId bestaat in database
        List<Adres> zoekresultaat = new ArrayList<>();
        //adresconnectie kan fout zijn!
        try (PreparedStatement stmt = adresconnectie.prepareStatement(
            "SELECT * " +
            "FROM adressen " +
            "WHERE land = ?")) {
            stmt.setString(1, land);
            ResultSet resultset = stmt.executeQuery();
            int     nul = (resultset.getInt("adressen_id"));
            int     een = (resultset.getInt("adressen_type"));
            int     twee = (resultset.getInt("FK_adressen_klanten_id"));
            String  drie = (resultset.getString("straatnaam"));
            int     vier = (resultset.getInt("huisnummer"));
            boolean     vijf = (resultset.getBoolean("heeft_huisnummer_toevoeging"));
            String x = (resultset.getString("huisnummer_toevoeging"));
            String  zes = (resultset.getString("postcode"));
            String  zeven =(resultset.getString("land"));
            
            // Laat alle bestellingen met het opgegeven klantId zien
            while (resultset.next()) {
            Adres gevondenAdres = new Adres.AdresBuilder()
        .adresId(nul)
        .adresType(een)
        .klantId(twee)
        .straatnaam(drie)
        .huisnummer(vier)
        .heeftHuisnrToevoeging(vijf)
        .huisnrToevoeging(x)
        .postcode(zes)
        .land(zeven)
        .build();
            zoekresultaat.add(gevondenAdres);
            }
            resultset.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken van een adres mbv land.");
            ex.getMessage();
        }
        return zoekresultaat;
    }

    @Override
    public Adres toevoegenAdres(Adres adres) {
      

    
     try (PreparedStatement stmt = adresconnectie.prepareStatement(
                "INSERT INTO adressen (adressen_type,FK_adressen_klanten_id,straatnaam,huisnummer,heeft_huisnummer_toevoeging,huisnummer_toevoeging_postcode_land)" +
                "VALUES ?, ?, ?, ?, ? , ? , ? ,? ")) {
            ResultSet resultset = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            int AdresId = resultset.getInt(1);
            
           stmt.setInt(1,   adres.getAdresType());
           stmt.setInt(2,   adres.getKlantId());
           stmt.setString(3,   adres.getStraatnaam());
           stmt.setInt(4,   adres.getHuisnummer());
           stmt.setString(5,   adres.getHuisnrToevoeging());
           stmt.setString(6,   adres.getPostcode());
           stmt.setString(7,   adres.getLand());
          
         
            
            stmt.executeUpdate();
            adres.setAdresId(AdresId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het toevoegen van de bestelling.");
        }
        return adres;
    
    }
    
    //om up te daten moet je toch ook nog een input hebben?
    
    
    
    @Override
    public boolean updateAdresType(int adresId, int adresType) {
        String query = "UPDATE adressen SET adressen_type = adresType WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresStraatnaam(int adresId, String straatnaam) {
        String query = "UPDATE adressen SET straatnaam = straatnaam WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresHuisnummer(int adresId, int huisnummer) {
        String query = "UPDATE adressen SET huisnummer = huisnummer WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging) {
        String query = "UPDATE adressen SET heeft_huisnr_toevoeging = heeftHuisnrToevoeging WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging) {
        String query = "UPDATE adressen SET huisnummer_toevoeging = huisnrToevoeging WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresPostcode(int adresId, String postcode) {
        String query = "UPDATE adressen SET postcode = postcode WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateAdresLand(int adresId, String land) {
        String query = "UPDATE adressen SET land = land WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van het adres.");
            return false;
        }
        return true;
    }
   
    
    @Override
    public boolean deleteAdres(int AdresID){
        
          String query = "DELETE FROM accounts WHERE accounts_id = " + AdresID;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = adresconnectie.prepareStatement(query)
        	)
                {
        	
        
            stmt2.executeUpdate();
          
            
            System.out.println("Adres gegevens zijn succesvol verwijderd");
        }
        catch (SQLException foutaccountdelete){
         System.out.println(foutaccountdelete.getMessage());
              return false;  
        } 
        
        return true;
        
        
        
        
    }
    
    
    
    
   
}