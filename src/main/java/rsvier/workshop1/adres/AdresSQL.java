/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
        LOGGER.debug("Input  in findAdresById is {}",adresId);
        String query = "SELECT * FROM adressen WHERE adressen_id = '" + adresId + "'";
        Adres adres = new Adres();
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query);
            ResultSet resultset = stmt.executeQuery())    {
            if (resultset.next()) {
                adres.setAdresId(resultset.getInt("adressen_id"));
                adres.setAdresType(resultset.getInt("adressen_type"));
                adres.setKlantId(resultset.getInt("FK_adressen_klanten_id"));
                adres.setStraatnaam(resultset.getString("straatnaam"));
                adres.setHuisnummer(resultset.getInt("huisnummer"));
                if (resultset.getInt("heeft_huisnr_toevoeging") == 1) {
                    adres.setHuisnrToevoeging(resultset.getString("huisnummer_toevoeging"));
                } else {
                    adres.setHuisnrToevoeging("");
                }
                adres.setPostcode(resultset.getString("postcode"));
                adres.setLand(resultset.getString("land"));
            }
        }
        catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het zoeken van een adres op AdresID: {}", ex.getMessage());
        }
        LOGGER.debug("output findAdresByID :" +  adres.toString());
        return adres;    
    }

    @Override
    public List findAdresByType(int adresType) {
        LOGGER.debug("Input  in findAdresByType is {}",adresType);
        List<Adres> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM adressen WHERE adressen_type = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setInt(1, adresType);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                int     nul = resultset.getInt("adressen_id");
                int     een = resultset.getInt("adressen_type");
                int     twee = resultset.getInt("FK_adressen_klanten_id");
                String  drie = resultset.getString("straatnaam");
                int     vier =  resultset.getInt("huisnummer");
                boolean     vijf = (resultset.getBoolean("heeft_huisnr_toevoeging"));
                String x = resultset.getString("huisnummer_toevoeging");
                String  zes = resultset.getString("postcode");
                String  zeven =resultset.getString("land");
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
            LOGGER.error("Er gaat iets mis met het zoeken van een adres op type {}", ex.getMessage());
        }
        LOGGER.debug("output findAdresByID :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findAdresByKlantId(int klantId) {
         LOGGER.debug("Input  in findAdresByKlant is {}",klantId);
        List<Adres> zoekresultaat = new ArrayList<>();
        String query = "SELECT * from adressen WHERE FK_adressen_klanten_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setInt(1, klantId);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                int     nul = (resultset.getInt("adressen_id"));
                int     een = (resultset.getInt("adressen_type"));
                int     twee = (resultset.getInt("FK_adressen_klanten_id"));
                String  drie = (resultset.getString("straatnaam"));
                int     vier = (resultset.getInt("huisnummer"));
                boolean     vijf = (resultset.getBoolean("heeft_huisnr_toevoeging"));
                String x = (resultset.getString("huisnummer_toevoeging"));
                String  zes = (resultset.getString("postcode"));
                String  zeven =(resultset.getString("land"));
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
            LOGGER.error("Er gaat iets mis met het zoeken van een adres op klantID{}", ex.getMessage());
           
        }
        LOGGER.debug("output findAdresByKlantID :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findAdresByPostcode(String postcode) {
        LOGGER.debug("Input  in findAdresByPostcode is {}",postcode);
        List<Adres> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM adressen WHERE postcode = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setString(1, postcode);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                int nul = resultset.getInt("adressen_id");
                int     een = resultset.getInt("adressen_type");
                int     twee = resultset.getInt("FK_adressen_klanten_id");
                String  drie = resultset.getString("straatnaam");
                int     vier = resultset.getInt("huisnummer");
                boolean     vijf = resultset.getBoolean("heeft_huisnr_toevoeging");
                String x = resultset.getString("huisnummer_toevoeging");
                String  zes = resultset.getString("postcode");
                String  zeven =resultset.getString("land");
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
            LOGGER.error("Er gaat iets mis met het zoeken van een adres op postcode{}", ex.getMessage());
          
        }
        LOGGER.debug("output findAdresByPostcode :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findAdresByLand(String land) {
        LOGGER.debug("Input  in findAdresByLand is {}",land);
        List<Adres> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM adressen WHERE land = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setString(1, land);
            ResultSet resultset = stmt.executeQuery();
            while (resultset.next()) {
                int     nul = (resultset.getInt("adressen_id"));
                int     een = (resultset.getInt("adressen_type"));
                int     twee = (resultset.getInt("FK_adressen_klanten_id"));
                String  drie = (resultset.getString("straatnaam"));
                int     vier = (resultset.getInt("huisnummer"));
                boolean     vijf = (resultset.getBoolean("heeft_huisnr_toevoeging"));
                String x = (resultset.getString("huisnummer_toevoeging"));
                String  zes = (resultset.getString("postcode"));
                String  zeven =(resultset.getString("land"));
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
            LOGGER.error("Er gaat iets mis met het zoeken van een adres op land {}", ex.getMessage());
        }
        LOGGER.debug("output findAdresByLand :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public Adres toevoegenAdres(Adres adres) {
        LOGGER.debug("Input  in toevoegenAdres is {}",adres.toString());
        String query = "INSERT INTO adressen (adressen_type,FK_adressen_klanten_id,straatnaam,huisnummer,heeft_huisnr_toevoeging,huisnummer_toevoeging,postcode,land) VALUES (?, ?, ?, ?, ? , ? , ? ,? )";
        int autoGeneratedKeys = 0;
        try ( PreparedStatement stmt = adresconnectie.prepareStatement( query ,Statement.RETURN_GENERATED_KEYS ) ) {
            stmt.setInt(1,adres.getAdresType());
            stmt.setInt(2,adres.getKlantId());
            stmt.setString(3,adres.getStraatnaam());
            stmt.setInt(4,adres.getHuisnummer());
            stmt.setBoolean(5,adres.getHeeftHuisnrToevoeging());
            stmt.setString(6,adres.getHuisnrToevoeging());
            stmt.setString(7,adres.getPostcode());
            stmt.setString(8,adres.getLand());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            rs.next();
            int key = rs.getInt(1);
            LOGGER.info("Nieuw adres aangemaakt met ID:" + key);
            adres.setAdresId(key);
        }   catch (SQLException ex) {
            System.out.println(ex.getMessage());
            LOGGER.error("Er gaat iets mis met het toevoegen van een adres {}", ex.getMessage());
        }
        LOGGER.debug("output toevoegenAdres :" +  adres.toString());
        return adres;
    }
    
    @Override
    public boolean updateAdresType(int adresId, int adresType) {
        LOGGER.debug("Input  in updateAdresType is {} {}", adresId,adresType);
        String query = "UPDATE adressen SET adressen_type = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
           stmt.setInt(1, adresType);
           stmt.setInt(2, adresId);
           stmt.executeUpdate();
           return true;
        } catch (SQLException ex) {
           LOGGER.error("Er gaat iets mis met het aanpassen van een adres op Type{}", ex.getMessage());
           return false;
        }
    }

    @Override
    public boolean updateAdresStraatnaam(int adresId, String straatnaam) {
        LOGGER.debug("Input  in updateAdresStraatnaam is {} {}",adresId,straatnaam);
        String query = "UPDATE adressen SET straatnaam = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setString(1, straatnaam);
            stmt.setInt(2, adresId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het aanpassen van een adres op Straatnaam{}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAdresHuisnummer(int adresId, int huisnummer) {
        LOGGER.debug("Input  in updateAdresHuisnummer is {}{}",adresId,huisnummer);
        String query = "UPDATE adressen SET huisnummer = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setInt(1, huisnummer);
            stmt.setInt(2, adresId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het aanpassen van een adres op Huisnummer{}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging) {
        LOGGER.debug("Input  in updateAdresHeeftHuisnrToevoeging is {}{}",adresId,heeftHuisnrToevoeging);
        String query = "UPDATE adressen SET heeft_huisnr_toevoeging = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setInt(1, heeftHuisnrToevoeging);
            stmt.setInt(2, adresId);
            stmt.executeUpdate();
           return true;
        } catch (SQLException ex) {
           LOGGER.error("Er gaat iets mis met het aanpassen van een adres op heeftHuisnummerToevoeging {}", ex.getMessage());
           return false;
        }
    }

    @Override
    public boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging) {
         LOGGER.debug("Input  in updateAdresHuisnrToevoeging is {}{}",adresId,huisnrToevoeging);
        String query = "UPDATE adressen SET huisnummer_toevoeging = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setString(1, huisnrToevoeging);
            stmt.setInt(2, adresId);
            stmt.executeUpdate();
            return true;
        }   catch (SQLException ex) {
             LOGGER.error("Er gaat iets mis met het aanpassen van een adres op huisnummerToevoeging {}", ex.getMessage());
             return false;
        }
    }

    @Override
    public boolean updateAdresPostcode(int adresId, String postcode) {
        LOGGER.debug("Input  in updateAdresPostcode is {} {}",adresId,postcode);
        String query = "UPDATE adressen SET postcode = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
           stmt.setString(1, postcode);
           stmt.setInt(2, adresId);
           stmt.executeUpdate();
           return true;
        } catch (SQLException ex) {
           LOGGER.error("Er gaat iets mis met het aanpassen van een adres op postcode: {}", ex.getMessage());
           return false;
        }
    }

    @Override
    public boolean updateAdresLand(int adresId, String land) {
        LOGGER.debug("Input  in updateAdresLand is {]{}",adresId,land);
        String query = "UPDATE adressen SET land = ? WHERE adressen_id = ?";
        try (PreparedStatement stmt = adresconnectie.prepareStatement(query)) {
            stmt.setString(1, land);
            stmt.setInt(2, adresId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het aanpassen van een adres op land{}", ex.getMessage());
            return false;
        }
    }
   
    
    @Override
    public boolean deleteAdres(int AdresID){
        LOGGER.debug("Input  in deleteAdres is {}",AdresID);
        String query = "DELETE FROM accounts WHERE accounts_id = " + AdresID;        
        try (PreparedStatement stmt2 = adresconnectie.prepareStatement(query))  {
            stmt2.executeUpdate();
            return true;
        }   catch (SQLException ex){
            LOGGER.error("Er gaat iets mis met het verwijderen van een adres{}", ex.getMessage());
            return false;  
        } 
    }
}