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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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

    private static final Logger LOGGER = LogManager.getLogger(AdresSQL.class);
    
    private Connection adresconnectie;
    
    public AdresSQL(Connection connectie) {
        this.adresconnectie = connectie;
    }
    
    @Override
    public Adres findAdresById(int adresId) {
        LOGGER.debug("Zoek adres op id {}", adresId);
        String query = "SELECT * FROM adressen WHERE adressen_id = '" + adresId + "'";
        
        Adres adres = new Adres();
        //adresconnectie kan fout zijn!
        try (
        		PreparedStatement stmt = adresconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met het opgegeven adresId.
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
            LOGGER.info("Het zoeken op adresId is gelukt.");
        } //einde try
        catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op adresId: {}", ex.getMessage());
        }
        LOGGER.debug("Zoekresultaat zoeken op adresId: {}", adres);
        return adres;    
    }

    @Override
    public List findAdresByType(int adresType) {
        // @@Controleren of klantId bestaat in database
        LOGGER.debug("Zoeken adres op type: {}", adresType);
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
            LOGGER.info("Het zoeken op adrestype is gelukt.");
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken van adres op type: {}", ex.getMessage());
        }
        LOGGER.debug("Zoekresultaat zoeken adres op type: {}", zoekresultaat);
        return zoekresultaat;
    }

    @Override
    public List findAdresByKlantId(int klantId) {
        // @@Controleren of klantId bestaat in database
        LOGGER.debug("Zoeken adres op klantId: {}", klantId);
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
            LOGGER.info("Het zoeken op klantId is gelukt.");
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken van adres op klantId: {}", ex.getMessage());
        }
        LOGGER.debug("Zoekresultaat adres op klantId: {}", zoekresultaat);
        return zoekresultaat;
    }

    @Override
    public List findAdresByPostcode(String postcode) {
        // @@Controleren of klantId bestaat in database
        LOGGER.debug("Zoeken adres op postcode: {}", postcode);
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
            LOGGER.info("Zoeken op postcode is gelukt.");
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken van adres op postcode: {}", ex.getMessage());
        }
        LOGGER.debug("Zoekresultaat zoeken adres op postcode: {}", zoekresultaat);
        return zoekresultaat;
    }

    @Override
    public List findAdresByLand(String land) {
        // @@Controleren of klantId bestaat in database
        LOGGER.debug("Zoeken adres op land: {}", land);
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
            LOGGER.error("Het volgende ging verkeerd bij het zoeken van adres op land: {}", ex.getMessage());
        }
        LOGGER.debug("Output zoeken adres op land: {}", zoekresultaat);
        return zoekresultaat;
    }

    @Override
    public Adres toevoegenAdres(Adres adres) {
        LOGGER.debug("Toevoegen adres: {}", adres.toString());
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
           LOGGER.error("Het volgende ging verkeerd bij het toevoegen van adres: {}", ex.getMessage());
       }
       LOGGER.debug("Output toevoegen adres: {}", adres);
       return adres;
    
    }
    
    //om up te daten moet je toch ook nog een input hebben?
    
    
    
    @Override
    public boolean updateAdresType(int adresId, int adresType) {
        LOGGER.debug("Wijzigen adrestype van adresId: {}", adresId);
        String query = "UPDATE adressen SET adressen_type = adresType WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen adrestype: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresStraatnaam(int adresId, String straatnaam) {
        LOGGER.debug("Wijzigen straatnaam van adresId: {}", adresId);
        String query = "UPDATE adressen SET straatnaam = straatnaam WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen straatnaam: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresHuisnummer(int adresId, int huisnummer) {
        LOGGER.debug("Wijzigen huisnummer van adresId: {}", adresId);
        String query = "UPDATE adressen SET huisnummer = huisnummer WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen huisnummer: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging) {
        LOGGER.debug("Wijzigen heeftHuisnrToevoeging van adresId: {}", adresId);
        String query = "UPDATE adressen SET heeft_huisnr_toevoeging = heeftHuisnrToevoeging WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen heefthuisnrToevoeging: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging) {
        LOGGER.debug("Wijzigen huisnrToevoeging van adresId: {}", adresId);
        String query = "UPDATE adressen SET huisnummer_toevoeging = huisnrToevoeging WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen huisnrToevoeging: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresPostcode(int adresId, String postcode) {
        LOGGER.debug("Wijzigen postcode van adresId: {}", adresId);
        String query = "UPDATE adressen SET postcode = postcode WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen postcode: {}", true);
        return true;
    }

    @Override
    public boolean updateAdresLand(int adresId, String land) {
        LOGGER.debug("Wijzigen land van adresId: {}", adresId);
        String query = "UPDATE adressen SET land = land WHERE adressen_id = adresId";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het updaten van adres: {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("Output wijzigen land: {}", true);
        return true;
    }
   
    
    @Override
    public boolean deleteAdres(int adresId){
        LOGGER.debug("Verwijderen adresId: {}", adresId);
          String query = "DELETE FROM accounts WHERE accounts_id = " + adresId;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = adresconnectie.prepareStatement(query)
        	)
                {
        	
        
            stmt2.executeUpdate();
          
            
            System.out.println("Adres gegevens zijn succesvol verwijderd");
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging verkeerd bij het verwijderen van adres: {}", ex.getMessage());
              return false;  
        } 
        LOGGER.debug("Output verwijderen adresId: {}", true);
        return true;
        
        
        
        
    }
    
    
    
    
   
}