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
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author jurjen
 */
public class FactuurSQL implements FactuurDAO {

   private static final Logger LOGGER = LogManager.getLogger(FactuurSQL.class);
    
    
    
    
    
    private Connection factuurconnectie;
    
    public FactuurSQL(Connection connectie) {
        this.factuurconnectie = connectie;
    }
    
    @Override
    public boolean maakFactuur(Factuur factuur) {
        
        LOGGER.debug("Factuur maken met factuur:{}", factuur.toString()); 
        String query = "INSERT INTO facturen (FK_facturen_bestellingen_id, FK_facturen_adressen_id, FK_facturen_klanten_id, totaalprijs, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.setInt(1, factuur.getBestellingId());
            stmt.setInt(2, factuur.getAdresId());
            stmt.setInt(3, factuur.getKlantId());
            stmt.setBigDecimal(4, factuur.getTotaalprijs());
            stmt.setBoolean(5, factuur.getStatus());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met het aanmaken van een factuur{}", ex.getMessage());
            
            return false;
        }
        LOGGER.debug("output maakFactuur: true");
        return true;
    }

    // Dit is volgens mij hetzelfde als findFactuurById
    public Factuur bekijkFactuur(int factuurId) {
        LOGGER.debug("factuurID in bekijkFactuur is {}", factuurId);
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
            
             LOGGER.error("Er gaat iets mis met het bekijken van een factuur{}", ex.getMessage());
        }
         LOGGER.debug("output bekijkFactuur :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public boolean betaalFactuur(int factuurId) {
        LOGGER.debug("factuurId in betaalFactuur is {}",factuurId);
        String query = "UPDATE facturen SET status = 1 WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.error("Er gaat iets mis met bekijkFactuur {}", ex.getMessage());
            
         
            return false;
        }
        LOGGER.debug("output bekijkFactuur is true");
        return true;
    }

    @Override
    public Factuur findFactuurById(int factuurId) {
        LOGGER.debug("De input van findFactuurById is {}", factuurId);
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
            LOGGER.error("Er gaat iets mis met findFactuurById {}", ex.getMessage());
           
        }
        LOGGER.debug("output findFactuurById :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public Factuur findFactuurByBestellingId(int bestellingId) {
        LOGGER.debug("De input van findFactuurByBestellingId {}", bestellingId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByBestellingId{}", ex.getMessage());
         
        }
        LOGGER.debug("output findFactuurByBestellingId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByKlantId(int klantId) {
        LOGGER.debug("De input van findFactuurByKlant is {}", klantId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByKlant {}", ex.getMessage());
            
            
        }
        LOGGER.debug("output findFactuurByKlantId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByAdresId(int adresId) {
        LOGGER.debug("De input van findFactuurByAdres is {}", adresId);
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
            LOGGER.error("Er gaat iets fout met findFactuurByAdress {}", ex.getMessage());
            
            
        }
        LOGGER.debug("output findFactuurByAdresId :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByTotaalprijs(BigDecimal prijs) {
        LOGGER.debug("De input van findFactuurByTotaalprijs is {}", prijs);
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
           LOGGER.error("Er gaat iets fout met findFactuurByTotaalPrijs {}", ex.getMessage());
           
            
        }
        LOGGER.debug("output findFactuurByTotaalprijs :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public List findFactuurByStatus(int zoekStatus) {
        LOGGER.debug("De input van findFactuurByStatus is {}", zoekStatus);
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
            LOGGER.error("Er gaat iets fout met findFactuurByStatus {}", ex.getMessage());
           
            
        }
        LOGGER.debug("output findFactuurByStatus :" +  zoekresultaat.toString());
        return zoekresultaat;
    }

    @Override
    public boolean deleteFactuur(int factuurId) {
        LOGGER.debug("De input van deleteFacturr is {}", factuurId);
        String query = "DELETE FROM facturen WHERE facturen_id = factuurId";
        try (PreparedStatement stmt = factuurconnectie.prepareStatement(query)) {
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           LOGGER.error("Er gaat iets fout met deleteFactuur {}", ex.getMessage());
            return false;
        }
        LOGGER.debug("output deleteFactuur is true");
        return true;
    }
    
}
