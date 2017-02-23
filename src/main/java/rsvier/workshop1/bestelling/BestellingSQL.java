/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.bestelling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import rsvier.workshop1.product.Product;

/**
 *
 * @author jurjen
 * @@ staat voor commentaar dat geen code-functie beschrijft
 * @@adrestype voor bestellingen = 2;
 */
public class BestellingSQL implements BestellingDAO {    
    
    
    // Functies:
    // 1: Om bestellingen te zoeken:
    //      1.1: findBestellingById(int bestellingId); - returns Bestelling object als zoekresultaat
    //      1.2: findBestellingByKlant(int klantId); - returns List<Bestelling> met zoekresultaten
    //      1.3: findBestellingByAdres(Adres opgegevenAdres); - returns List<Bestelling> met zoekresultaten
    //      1.4: findBestellingByAantalArtikelen(int aantal); - returns List<Bestelling> met zoekresultaten
    //      1.5: findBestellingByTotaalprijs(BigDecimal prijs); - returns List<Bestelling> met zoekresultaten
    // 2: Om bestellingen toe te voegen:
    //      // De functie bij 2.1 heeft een in de view aangemaakt Bestelling Object nodig
    //      2.1: toevoegenBestelling(Bestelling opgegevenBestelling); -returns succes of mislukt
    // 3: Om bestellingen aan te passen:
    //      // De functies hieronder hebben een bestellingId (of Bestelling Object? nog niet geimplementeerd) nodig
    //      3.1: updateBestellingKlantId(int klantId); - returns succes of mislukt (+ laat vernieuwde bestelling zien?)
    //      3.2: updateBestellingAdresId(int adresId); - returns succes of mislukt
    //      3.3: updateBestellingAantalArtikelen(int aantalArtikelen); - returns succes of mislukt
    //      3.4: updateBestellingTotaalprijs(BigDecimal totaalprijs); - returns succes of mislukt
    // 4: Om bestellingen te verwijderen:
    //      // De functie hieronder heeft een bestellingId (of Bestelling Object? nog niet geimplementeerd) nodig
    //      4.1: verwijderenBestelling(int bestellingId);
    private static final Logger LOGGER = LogManager.getLogger(BestellingSQL.class);
   
    private Connection bestellingenconnectie;
    
    public BestellingSQL(Connection connectie) {
        this.bestellingenconnectie = connectie;
    }
    
    /**
    * Zoekt in de tabel bestellingen naar het opgegeven bestellingId en laat de corresponderende data zien.
    * 
    * @param    bestellingId    Een integer die vergeleken moet worden met bestellingen_id in de bestellingen tabel
    * @return                   Een bestelling object dat overeenkomt met de bestelling gevonden in de database
    */    
    
    @Override
    public Bestelling findBestellingById(int bestellingId) {
        LOGGER.debug("Zoek bestelling op id {}", bestellingId);
        // @@Controleren of bestellingId bestaat in de db
        Bestelling zoekresultaat = new Bestelling();
        String query = "SELECT * FROM bestellingen WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
            ResultSet rs = stmt.executeQuery();
            // Er kan maar 1 resultaat zijn
            while (rs.next()) {
                int klantId = rs.getInt("FK_bestellingen_klanten_id");
                // @@Controleren of klantId bestaat in bestellingen aangezien het een FK is
                int adresId = rs.getInt("FK_bestellingen_adressen_id");
                // @@Controleren of adresId bestaat in bestellingen aangezien het een FK is
                int aantalArtikelen = rs.getInt("aantal_artikelen");
                BigDecimal totaalprijs = rs.getBigDecimal("totaalprijs");
                zoekresultaat = new Bestelling.BestellingBuilder()
                                                         .bestellingId(bestellingId)
                                                         .klantId(klantId)
                                                         .adresId(adresId)
                                                         .aantalArtikelen(aantalArtikelen)
                                                         .totaalprijs(totaalprijs)
                                                         .build();
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op bestellingId: {}", ex.getMessage());
        }
        LOGGER.debug("Output zoeken op bestellingId: " + zoekresultaat.toString());
        return zoekresultaat;
    } // einde zoekBestelling(int bestellingId)
    
    @Override
    public List findBestellingByKlantId(int klantId) {
        LOGGER.debug("Zoek bestelling op klantId {}", klantId);
        // @@Controleren of klantId bestaat in database
        List<Bestelling> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM bestellingen WHERE FK_bestellingen_klanten_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, klantId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            int bestellingId = rs.getInt("bestellingen_id");
            int adresId = rs.getInt("FK_bestellingen_adressen_id");
            int aantalArtikelen = rs.getInt("aantal_artikelen");
            BigDecimal totaalprijs = rs.getBigDecimal("totaalprijs");
            // Laat alle bestellingen met het opgegeven klantId zien
            Bestelling gevondenBestelling = new Bestelling.BestellingBuilder()
                                               .bestellingId(bestellingId)
                                               .klantId(klantId)
                                               .adresId(adresId)
                                               .aantalArtikelen(aantalArtikelen)
                                               .totaalprijs(totaalprijs)
                                               .build();
            zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op klantId: {}", ex.getMessage());
        }
        LOGGER.debug("Output zoeken op klantId: " + zoekresultaat.toString());
        return zoekresultaat;
    } // einde findBestellingByKlant(int klantId)
   
    @Override
    public List findBestellingByAdresId(int adresId) {
        LOGGER.debug("Zoek bestelling op adresId {}", adresId);
        List<Bestelling> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM bestellingen WHERE FK_bestellingen_adressen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, adresId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            Bestelling gevondenBestelling = new Bestelling.BestellingBuilder()
                                                          .bestellingId(rs.getInt("bestellingen_id"))
                                                          .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                          .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                          .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                          .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                          .build();
            zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op adresId: {}", ex.getMessage());
        }
        LOGGER.debug("Output zoeken op adresId: " + zoekresultaat.toString());
        return zoekresultaat;
    } // einde zoekBestellingByAdres()
    
    @Override
    public List findBestellingByAantalArtikelen(int aantalArtikelen) {
        LOGGER.debug("Zoek bestelling op aantalArtikelen {}", aantalArtikelen);
        List<Bestelling> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM bestellingen WHERE aantal_artikelen = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, aantalArtikelen);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bestelling gevondenBestelling = new Bestelling.BestellingBuilder()
                                                              .bestellingId(rs.getInt("bestellingen_id"))
                                                              .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                              .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                              .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                              .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                              .build();
                zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op aantalArtikelen: {}", ex.getMessage());
        }                    
        LOGGER.debug("Output zoeken op aantalArtikelen: " + zoekresultaat.toString());
        return zoekresultaat;
    } // einde findBestellingByAantalArtikelen()
    
    @Override
    public List findBestellingByTotaalprijs(BigDecimal totaalprijs) {
        LOGGER.debug("Zoek bestelling op totaalprijs {}", totaalprijs);
        List<Bestelling> zoekresultaat = new ArrayList<>();
        String query = "SELECT * FROM bestellingen WHERE totaalprijs = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setBigDecimal(1, totaalprijs);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bestelling gevondenBestelling = new Bestelling.BestellingBuilder()
                                                              .bestellingId(rs.getInt("bestellingen_id"))
                                                              .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                              .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                              .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                              .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                              .build();
                zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het zoeken op totaalprijs: {}", ex.getMessage());  
        }
        LOGGER.debug("Output zoeken op totaalprijs: " + zoekresultaat.toString());
        return zoekresultaat;
    } // einde findBestellingByTotaalprijs(BigDecimal totaalprijs)

    @Override
    public Bestelling toevoegenBestelling(Bestelling opgegevenBestelling) {
        LOGGER.debug("Toevoegen bestelling {}", opgegevenBestelling.toString());
        String query = "INSERT INTO bestellingen (FK_bestellingen_klanten_id, FK_bestellingen_adressen_id, aantal_artikelen, totaalprijs) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, opgegevenBestelling.getKlantId());
            stmt.setInt(2, opgegevenBestelling.getAdresId());
            stmt.setInt(3, opgegevenBestelling.getAantalArtikelen());
            stmt.setBigDecimal(4, opgegevenBestelling.getTotaalprijs());
            stmt.executeUpdate();
            ResultSet rs = stmt.executeQuery("select last_insert_id()");
            if (rs.next()) {
                int bestellingId = rs.getInt(1);
                opgegevenBestelling.setBestellingId(bestellingId);
            }
            rs.close();
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij het toevoegen: {}", ex.getMessage());  
        }
        LOGGER.debug("Output toevoegen: " + opgegevenBestelling.toString());
        return opgegevenBestelling;
    } // einde toevoegenBestelling(Bestelling opgegevenBestelling)
    
    @Override
    public boolean updateBestellingKlantId(int bestellingId, int klantId) {
        LOGGER.debug("Pas klantId van bestelling {} aan", bestellingId);
        String query = "UPDATE bestellingen SET FK_bestellingen_klanten_id = ? WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, klantId);
            stmt.setInt(2, bestellingId);
            stmt.executeUpdate();
            LOGGER.debug("Output toevoegen: {}", true);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij aanpassen: {}", ex.getMessage());  
            return false;
        }
    } // einde updateBestellingKlantId(int bestellingId, int klantId)
    
    @Override
    public boolean updateBestellingAdresId(int bestellingId, int adresId) {
        LOGGER.debug("Pas adresId van bestelling {} aan", bestellingId);
        String query = "UPDATE bestellingen SET FK_bestellingen_adressen_id = ? WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, adresId);
            stmt.setInt(2, bestellingId);
            stmt.executeUpdate();
            LOGGER.debug("Output toevoegen: {}", true);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij aanpassen: {}", ex.getMessage());  
            return false;
        }
    } // einde updateBestellingAdresId(int bestellingId, int adresId)

    @Override
    public boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen) {
        LOGGER.debug("Pas aantalArtikelen van bestelling {} aan", bestellingId);
        String query = "UPDATE bestellingen SET aantal_artikelen = ? WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, aantalArtikelen);
            stmt.setInt(2, bestellingId);
            stmt.executeUpdate();
            LOGGER.debug("Output toevoegen: {}", true);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij aanpassen: {}", ex.getMessage());  
            return false;
        }
    } // einde updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen)

    @Override
    public boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs) {
        LOGGER.debug("Pas totaalprijs van bestelling {} aan", bestellingId);
        String query = "UPDATE bestellingen SET totaalprijs = ? WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setBigDecimal(1, totaalprijs);
            stmt.setInt(2, bestellingId);
            stmt.executeUpdate();
            LOGGER.debug("Output toevoegen: {}", true);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij aanpassen: {}", ex.getMessage());  
            return false;
        }
    } // einde updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs)

    @Override
    public boolean deleteBestelling(int bestellingId) {
        LOGGER.debug("Verwijder bestelling {} ", bestellingId);
        String query = "DELETE FROM bestellingen WHERE bestellingen_id = ?";
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(query)) {
            stmt.setInt(1, bestellingId);
            stmt.executeUpdate();
            stmt.close();        
            LOGGER.debug("Verwijder bestelling {} ", bestellingId);
            return true;
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij verwijderen: {}", ex.getMessage());  
            return false;
        }
    } // einde verwijderenBestelling(int bestellingId)
    
    @Override
    public void bekijkBestelling(int bestellingId) {
        LOGGER.debug("Bekijk bestelling {} ", bestellingId);
        //List<Product> zoekresultaat = new ArrayList<>();
        Map<Product, Integer> test = new HashMap<>();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                // bestelling heeft klant, adres, product+hoeveelheid+prijs, totaal aantal artikelen en totaalprijs
                // aantal artikelen is gelijk aan het aantal matchende bestelregels
                // je wilt productSoort, hoeveelheid en totaalprijs per combinatie
                
                
                "SELECT producten.soort, producten.prijs, bestellingregels.hoeveelheid" +
                "FROM producten, bestellingregels" +
                "WHERE producten_id = FK_bestellingregels_producten_id")) {
                ResultSet rs = stmt.executeQuery();
                int aantalArtikelen = 0;
                BigDecimal totaalprijs = new BigDecimal(0);
                List<String> aantal = new ArrayList<>();
                while (rs.next()) {
                    aantalArtikelen++;
                    totaalprijs = totaalprijs.add(rs.getBigDecimal("prijs").multiply(new BigDecimal(rs.getInt("hoeveelheid"))));
                    Product besteldProduct = new Product();
                    besteldProduct.setSoort(rs.getString("soort"));
                    besteldProduct.setPrijs(rs.getBigDecimal("prijs"));
                    int hoeveelheid = rs.getInt("hoeveelheid");
                    // Testen of het lukt met 1 return, een hashmap
                        for (int i = 0; i < aantalArtikelen; i++) {
                            test.put(besteldProduct, hoeveelheid);
                        }
                }
                /*
                System.out.println("Bestelling " + bestellingId + " bestaat uit " + aantalArtikelen + " artikelen met een totaalprijs van " + totaalprijs + ".");
                System.out.println("De bestelling bestaat uit de volgende producten: "); // soort, prijs, hoeveelheid
                for (Product product: zoekresultaat) {
                    System.out.println("Product: " + product.getSoort() + "");
                }
                */
                // Testen of het lukt met 1 return, een hashmap
                // return test; (om te printen in view)
                // hier printen (om te testen)
                System.out.println(Arrays.asList(test));
                
                
        } catch (SQLException ex) {
            LOGGER.error("Het volgende ging verkeerd bij verwijderen: {}", ex.getMessage());            
        }
        
                
                
                /*
                // JOIN poging
                SELECT
                  producten.soort,
                  producten.prijs,
                  bestellingregels.hoeveelheid,
                  bestellingen.bestellingen_id,
                  bestellingen.FK_bestellingen_klanten_id                  
                FROM bestellingen
                  INNER JOIN bestellingregels
                    ON bestellingen_id = FK_bestellingregels_bestellingen_id
                  INNER JOIN producten
                    ON producten_id = FK_bestellingregels_producten_id
                */
                
                
                  
                        
                        
    
    } // einde bekijkBestelling(int bestellingId)

} // einde BestellingSQL