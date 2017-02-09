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
 * @author jurjen
 */
public class BestelregelSQL implements BestelregelDAO {

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
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(
            "INSERT INTO bestelregels" +
            "(FK_bestelregels_bestellingen_id," +
            "FK_bestelregels_producten_id, hoeveelheid)" +
            "VALUES (?, ?, ?")) {
            stmt.setInt(1, bestelregel.getBestellingId());
            stmt.setInt(2, bestelregel.getProductId());
            stmt.setInt(3, bestelregel.getHoeveelheid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van de bestelregel.");
            return false;
        }
        return true;
    }  

    @Override
    public Bestelregel findBestelregelById(int bestelregelId) {
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
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelregel op bestelregelId");
        }
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByBestellingId(int bestellingId) {
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
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelregel op bestellingId");
        }
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByProductId(int productId) {
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
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelregel op productId");
        }
        return bestelregel;
    }

    @Override
    public Bestelregel findBestelregelByHoeveelheid(int hoeveelheid) {
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
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelregel op hoeveelheid");
        }
        return bestelregel;
    }

    @Override
    public boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId) {
        String query = "UPDATE bestelregels SET FK_bestelregels_bestellingen_id = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het update van bestelregel op bestellingId.");
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBestelregelProductId(int bestelregelId, int productId) {
        String query = "UPDATE bestelregels SET FK_bestelregels_producten_id = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, productId);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het update van bestelregel op productId.");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid) {
        String query = "UPDATE bestelregels SET hoeveelheid = ? WHERE bestelregels_id = bestelregelId";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
            stmt.setInt(1, hoeveelheid);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het update van bestelregel op hoeveelheid.");
            return false;
        }
        return true;
    }
    
    @Override
    public boolean deleteBestelregel(int bestelregelId) {
        String query = "DELETE FROM bestelregel WHERE bestelregels_id = ?";
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(query)) {
        stmt.setInt(1, bestelregelId);
        stmt.executeUpdate();
        stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het verwijderen van de bestelregel.");
            return false;
        }        
        return true;
    }
}
