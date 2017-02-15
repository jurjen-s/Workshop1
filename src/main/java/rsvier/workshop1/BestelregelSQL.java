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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jurjen
 */
public class BestelregelSQL implements BestelregelDAO {

    private static final Logger LOGGER = LogManager.getLogger(AdresSQL.class);
    
    private Connection bestelregelconnectie;
    
    public BestelregelSQL() {
        SQLConnection sqlConnectie = new SQLConnection();
        this.bestelregelconnectie = sqlConnectie.getSQLConnection();
    }
    
    public BestelregelSQL(Connection connectie) {
        this.bestelregelconnectie = connectie;
    }
    
    @Override
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        LOGGER.debug("Toevoegen bestelregel: {}", bestelregel.toString());
        String query = "INSERT INTO bestelregels (FK_bestelregels_bestellingen_id, FK_bestelregels_producten_id, hoeveelheid) VALUES (?, ?, ?";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestelregel.getBestellingId());
            stmt.setInt(2, bestelregel.getProductId());
            stmt.setInt(3, bestelregel.getHoeveelheid());
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij toevoegen: {}", ex.getMessage());            
            return false;
        }
    }  

    @Override
    public Bestelregel findBestelregelById(int bestelregelId) {
        LOGGER.debug("Zoeken bestelregel op id: {}", bestelregelId);
        String query = "SELECT * FROM bestelregels WHERE bestelregels_id = ?";
        Bestelregel bestelregel = new Bestelregel();
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestelregelId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            bestelregel = new Bestelregel.BestelregelBuilder()
                                                     .bestelregelId(rs.getInt("bestelregels_id"))
                                                     .bestellingId(rs.getInt("FK_bestelregels_bestellingen_id"))
                                                     .productId(rs.getInt("FK_bestelregels_producten_id"))
                                                     .hoeveelheid(rs.getInt("hoeveelheid"))
                                                     .build();
            }
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij zoeken: {}", ex.getMessage());            
        }
        LOGGER.debug("Output zoeken: {}", bestelregel.toString());
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByBestellingId(int bestellingId) {
        LOGGER.debug("Zoeken bestelregel op bestellingId: {}", bestellingId);
        String query = "SELECT * FROM bestelregels WHERE FK_bestelregels_bestellingen_id = ?";
        Bestelregel bestelregel = new Bestelregel();
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            bestelregel = new Bestelregel.BestelregelBuilder()
                                                     .bestelregelId(rs.getInt("bestelregels_id"))
                                                     .bestellingId(rs.getInt("FK_bestelregels_bestellingen_id"))
                                                     .productId(rs.getInt("FK_bestelregels_producten_id"))
                                                     .hoeveelheid(rs.getInt("hoeveelheid"))
                                                     .build();
            }
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij zoeken: {}", ex.getMessage());            
        }
        LOGGER.debug("Output zoeken op bestellingId: {}", bestelregel.toString());
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByProductId(int productId) {
        LOGGER.debug("Zoeken bestelregel op productId: {}", productId);
        String query = "SELECT * FROM bestelregels WHERE FK_bestelregels_producten_id = ?";
        Bestelregel bestelregel = new Bestelregel();
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            bestelregel = new Bestelregel.BestelregelBuilder()
                                                     .bestelregelId(rs.getInt("bestelregels_id"))
                                                     .bestellingId(rs.getInt("FK_bestelregels_bestellingen_id"))
                                                     .productId(rs.getInt("FK_bestelregels_producten_id"))
                                                     .hoeveelheid(rs.getInt("hoeveelheid"))
                                                     .build();
            }
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij zoeken: {}", ex.getMessage());            
        }
        LOGGER.debug("Output zoeken op productId: {}", bestelregel.toString());
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByHoeveelheid(int hoeveelheid) {
        LOGGER.debug("Zoeken bestelregel op hoeveelheid: {}", hoeveelheid);
        String query = "SELECT * FROM bestelregels WHERE hoeveelheid = ?";
        Bestelregel bestelregel = new Bestelregel();
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, hoeveelheid);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            bestelregel = new Bestelregel.BestelregelBuilder()
                                                     .bestelregelId(rs.getInt("bestelregels_id"))
                                                     .bestellingId(rs.getInt("FK_bestelregels_bestellingen_id"))
                                                     .productId(rs.getInt("FK_bestelregels_producten_id"))
                                                     .hoeveelheid(rs.getInt("hoeveelheid"))
                                                     .build();
            }
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij zoeken: {}", ex.getMessage());            
        }
        LOGGER.debug("Output zoeken op hoeveelheid: {}", bestelregel.toString());
        return bestelregel;
    }

    @Override
    public boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId) {
        LOGGER.debug("Update bestellingId van bestelregel: {}", bestelregelId);
        String query = "UPDATE bestelregels SET FK_bestelregels_bestellingen_id = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij updaten: {}", ex.getMessage());            
            return false;
        }
    }

    @Override
    public boolean updateBestelregelProductId(int bestelregelId, int productId) {
        LOGGER.debug("Update productId van bestelregel: {}", bestelregelId);
        String query = "UPDATE bestelregels SET FK_bestelregels_producten_id = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, productId);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij updaten: {}", ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid) {
        LOGGER.debug("Update hoeveelheid van bestelregel: {}", bestelregelId);
        String query = "UPDATE bestelregels SET hoeveelheid = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, hoeveelheid);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij updaten: {}", ex.getMessage());
            return false;
        }
    }
    
    @Override
    public boolean deleteBestelregel(int bestelregelId) {
        LOGGER.debug("Verwijder bestelregel: {}", bestelregelId);
        String query = "DELETE FROM bestelregel WHERE bestelregels_id = ?";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestelregelId);
            stmt.executeUpdate();
            stmt.close();        
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij verwijderen: {}", ex.getMessage());
            return false;
        }
    }
}
