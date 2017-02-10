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
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author jurjen
 */
public class FactuurSQL implements FactuurDAO {

    private Connection factuurconnectie;
    
    public FactuurSQL(Connection connectie) {
        this.factuurconnectie = connectie;
    }
    
    @Override
    public boolean maakFactuur(Factuur factuur) {
        String query = "INSERT INTO facturen (FK_facturen_bestellingen_id, FK_facturen_adressen_id, FK_facturen_klanten_id, totaalprijs, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuur.getBestellingId());
            stmt.setInt(2, factuur.getAdresId());
            stmt.setInt(3, factuur.getKlantId());
            stmt.setBigDecimal(4, factuur.getTotaalprijs());
            stmt.setBoolean(5, factuur.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het aanmaken van een factuur.");
            return false;
        }
        return true;
    }

    // Dit is volgens mij hetzelfde als findFactuurById
    public Factuur bekijkFactuur(int factuurId) {
        Factuur zoekresultaat = new Factuur();
        String query = "SELECT * FROM facturen WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                zoekresultaat = new Factuur.FactuurBuilder()
                                           .factuurId(factuurId)
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het bekijken van een factuur.");
        }
        return zoekresultaat;
    }

    @Override
    public boolean betaalFactuur(int factuurId) {
        String query = "UPDATE facturen SET status = 1 WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het betalen van een factuur.");
            return false;
        }
        return true;
    }

    @Override
    public Factuur findFactuurById(int factuurId) {
        Factuur zoekresultaat = new Factuur();
        String query = "SELECT * FROM facturen WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                zoekresultaat = new Factuur.FactuurBuilder()
                                           .factuurId(factuurId)
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op ID.");
        }
        return zoekresultaat;
    }

    @Override
    public Factuur findFactuurByBestellingId(int bestellingId) {
        Factuur zoekresultaat = new Factuur();
        String query = "SELECT * FROM facturen WHERE FK_facturen_bestellingen_id = bestellingId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                zoekresultaat = new Factuur.FactuurBuilder()
                                           .factuurId(rs.getInt("facturen_id"))
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op ID.");
        }
        return zoekresultaat;
    }

    @Override
    public List findFactuurByKlantId(int klantId) {
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE FK_facturen_klanten_id = klantId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Factuur gevondenFactuur = new Factuur.FactuurBuilder()
                                           .factuurId(rs.getInt("facturen_id"))
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
                zoekresultaat.add(gevondenFactuur);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op klantId.");
            
        }
        return zoekresultaat;
    }

    @Override
    public List findFactuurByAdresId(int adresId) {
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE FK_facturen_adressen_id = adresId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Factuur gevondenFactuur = new Factuur.FactuurBuilder()
                                           .factuurId(rs.getInt("facturen_id"))
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
                zoekresultaat.add(gevondenFactuur);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op adresId.");
            
        }
        return zoekresultaat;
    }

    @Override
    public List findFactuurByTotaalprijs(BigDecimal prijs) {
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE totaalprijs = prijs";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Factuur gevondenFactuur = new Factuur.FactuurBuilder()
                                           .factuurId(rs.getInt("facturen_id"))
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
                zoekresultaat.add(gevondenFactuur);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op prijs.");
            
        }
        return zoekresultaat;
    }

    @Override
    public List findFactuurByStatus(int zoekStatus) {
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE status = zoekStatus";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Factuur gevondenFactuur = new Factuur.FactuurBuilder()
                                           .factuurId(rs.getInt("facturen_id"))
                                           .bestellingId(rs.getInt("FK_facturen_bestellingen_id"))
                                           .adresId(rs.getInt("FK_facturen_adressen_id"))
                                           .klantId(rs.getInt("FK_facturen_klanten_id"))
                                           .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                           .status(rs.getBoolean("status"))
                                           .build();
                zoekresultaat.add(gevondenFactuur);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een factuur op status.");
            
        }
        return zoekresultaat;
    }

    @Override
    public boolean deleteFactuur(int factuurId) {
        String query = "DELETE FROM facturen WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het verwijderen van een factuur.");
            return false;
        }
        return true;
    }
    
}
