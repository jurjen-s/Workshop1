/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.factuur;

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
 * @author jurjen
 */
public class FactuurMySQL implements FactuurDAO {

   private static final Logger LOGGER = LogManager.getLogger(FactuurMySQL.class);
   
   private Connection factuurconnectie;
   
   public FactuurMySQL(Connection connectie) {
        this.factuurconnectie = connectie;
   }
    
    @Override
    public boolean maakFactuur(Factuur factuur) {
        LOGGER.debug("Factuur maken met factuur: {}", factuur.toString());
        LOGGER.debug("2: Factuur maken met factuur: {}", factuur);
        // Eerst totaalprijs ophalen uit de gekoppelde bestelling
        // Moet OOK gekoppeld klantId ophalen ipv vragen aan cmd!
        BigDecimal totaalprijs = new BigDecimal(-1);
        int klantId = -1;
        String query = "SELECT totaalprijs, FK_bestellingen_klanten_id FROM bestellingen WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuur.getBestellingId());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                totaalprijs = rs.getBigDecimal("totaalprijs");
                klantId = rs.getInt("FK_bestellingen_klanten_id");
            }
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging mis bij het ophalen van de totaalprijs: " + ex.getMessage());
            return false;
        }
        String query2 = "INSERT INTO facturen (FK_facturen_bestellingen_id, FK_facturen_adressen_id, FK_facturen_klanten_id, totaalprijs) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt2 = factuurconnectie.prepareStatement(query2)) {
            stmt2.setInt(1, factuur.getBestellingId());
            stmt2.setInt(2, factuur.getAdresId());
            stmt2.setInt(3, klantId);
            stmt2.setBigDecimal(4, totaalprijs);
            stmt2.executeUpdate();
            LOGGER.debug("output maakFactuur: true");
            LOGGER.info(factuur);
            return true;
        }   catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het aanmaken van een factuur{}", ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean betaalFactuur(int factuurId) {
        LOGGER.debug("factuurId in betaalFactuur is {}",factuurId);
        String query = "UPDATE facturen SET status = 1 WHERE facturen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuurId);
            stmt.executeUpdate();
        }   catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis bij betaalFactuur: {}", ex.getMessage());
            return false;
        }        
        LOGGER.debug("output bekijkFactuur is true");
        return true;
    }

    @Override
    public Factuur findFactuurById(int factuurId) {
        LOGGER.debug("De input van findFactuurById is {}", factuurId);
        Factuur zoekresultaat = new Factuur();
        String query = "SELECT * FROM facturen WHERE facturen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuurId);
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
            LOGGER.error("Er gaat iets mis met findFactuurById: {}", ex.getMessage());
        }
        LOGGER.debug("output findFactuurById :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public Factuur findFactuurByBestellingId(int bestellingId) {
        LOGGER.debug("De input van findFactuurByBestellingId {}", bestellingId);
        Factuur zoekresultaat = new Factuur();
        String query = "SELECT * FROM facturen WHERE FK_facturen_bestellingen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByBestellingId{}", ex.getMessage());
        }
        
        LOGGER.debug("output findFactuurByBestellingId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByKlantId(int klantId) {
        LOGGER.debug("De input van findFactuurByKlant is {}", klantId);
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE FK_facturen_klanten_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, klantId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByKlant {}", ex.getMessage());
        }        
        LOGGER.debug("output findFactuurByKlantId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByAdresId(int adresId) {
        LOGGER.debug("De input van findFactuurByAdres is {}", adresId);
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE FK_facturen_adressen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, adresId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByAdress {}", ex.getMessage());
        }
        LOGGER.debug("output findFactuurByAdresId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByTotaalprijs(BigDecimal prijs) {
        LOGGER.debug("De input van findFactuurByTotaalprijs is {}", prijs);
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE totaalprijs = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setBigDecimal(1, prijs);
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
            LOGGER.error("Er gaat iets fout met findFactuurByTotaalPrijs {}", ex.getMessage());
        }
        LOGGER.debug("output findFactuurByTotaalprijs :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByStatus(int zoekstatus) {
        LOGGER.debug("De input van findFactuurByStatus is {}", zoekstatus);
        List<Factuur> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM facturen WHERE status = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, zoekstatus);
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
            LOGGER.error("Er gaat iets fout met findFactuurByStatus {}", ex.getMessage());
        }        
        LOGGER.debug("output findFactuurByStatus :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public boolean deleteFactuur(int factuurId) {
        LOGGER.debug("De input van deleteFactuur is {}", factuurId);
        String query = "DELETE FROM facturen WHERE facturen_id = ?";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuurId);
            stmt.executeUpdate();
            LOGGER.debug("output deleteFactuur is true");
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            LOGGER.error("Er gaat iets fout met deleteFactuur {}", ex.getMessage());
            return false;
        }        
    }
    
}
