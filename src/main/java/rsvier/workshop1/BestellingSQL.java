/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

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
        // @@Controleren of bestellingId bestaat in de db
        Bestelling zoekresultaat = new Bestelling();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
            "SELECT * " +
            "FROM bestellingen" +
            "WHERE bestellingen_id = ?")) {
            stmt.setInt(1, bestellingId);
            ResultSet rs = stmt.executeQuery();
            int klantId = rs.getInt("FK_bestellingen_klanten_id");
            // @@Controleren of klantId bestaat in bestellingen aangezien het een FK is
            int adresId = rs.getInt("FK_bestellingen_adressen_id");
            // @@Controleren of adresId bestaat in bestellingen aangezien het een FK is
            int aantalArtikelen = rs.getInt("aantal_artikelen");
            BigDecimal totaalprijs = rs.getBigDecimal("totaalprijs");
            // Er kan maar 1 resultaat zijn
            while (rs.next()) {
                zoekresultaat = new Bestelling.BestellingBuilder(bestellingId)
                                                         .klantId(klantId)
                                                         .adresId(adresId)
                                                         .aantalArtikelen(aantalArtikelen)
                                                         .totaalprijs(totaalprijs)
                                                         .build();
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            System.out.println("Er ging iets mis bij het zoeken van een bestelling op bestellingId.");
        }
        return zoekresultaat;
    } // einde zoekBestelling(int bestellingId)
    
    @Override
    public List findBestellingByKlant(int klantId) {
        // @@Controleren of klantId bestaat in database
        List<Bestelling> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
            "SELECT * " +
            "FROM bestellingen " +
            "WHERE FK_bestellingen_klanten_id = ?")) {
            stmt.setInt(1, klantId);
            ResultSet rs = stmt.executeQuery();
            int bestellingId = rs.getInt("bestellingen_id");
            int adresId = rs.getInt("FK_bestellingen_adressen_id");
            int aantalArtikelen = rs.getInt("aantal_artikelen");
            BigDecimal totaalprijs = rs.getBigDecimal("totaalprijs");
            // Laat alle bestellingen met het opgegeven klantId zien
            while (rs.next()) {
            Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(bestellingId)
                                               .klantId(klantId)
                                               .adresId(adresId)
                                               .aantalArtikelen(aantalArtikelen)
                                               .totaalprijs(totaalprijs)
                                               .build();
            zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken van een bestelling op klantId.");
            ex.getMessage();
        }
        return zoekresultaat;
    } // einde findBestellingByKlant(int klantId)
   
    @Override
    public List findBestellingByAdresId(int adresId) {
        List<Bestelling> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "SELECT * " +
                "FROM bestellingen" +
                "WHERE FK_bestellingen_adressen_id = ?")) {
            stmt.setInt(1, adresId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
            Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(rs.getInt("bestellingen_id"))
                                                          .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                          .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                          .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                          .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                          .build();
            zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelling op adresId.");
        }
        return zoekresultaat;
    } // einde zoekBestellingByAdres()
    
    @Override
    public List findBestellingByAantalArtikelen(int aantalArtikelen) {
        List<Bestelling> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "SELECT * " +
                "FROM bestellingen" +
                "WHERE aantal_artikelen = ?")) {
            stmt.setInt(1, aantalArtikelen);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(rs.getInt("bestellingen_id"))
                                                              .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                              .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                              .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                              .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                              .build();
                zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelling op aantal artikelen.");        
        }                        
        return zoekresultaat;
    } // einde findBestellingByAantalArtikelen()
    
    @Override
    public List findBestellingByTotaalprijs(BigDecimal totaalprijs) {
        List<Bestelling> zoekresultaat = new ArrayList<>();
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "SELECT * " +
                "FROM bestellingen" +
                "WHERE totaalprijs = ?")) {
            stmt.setBigDecimal(1, totaalprijs);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(rs.getInt("bestellingen_id"))
                                                              .klantId(rs.getInt("FK_bestellingen_klanten_id"))
                                                              .adresId(rs.getInt("FK_bestellingen_adressen_id"))
                                                              .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                              .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                              .build();
                zoekresultaat.add(gevondenBestelling);
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het zoeken van een bestelling op totaalprijs.");        
        }                        
        return zoekresultaat;
    } // einde findBestellingByTotaalprijs(BigDecimal totaalprijs)

    @Override
    public boolean toevoegenBestelling(Bestelling opgegevenBestelling) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "INSERT INTO bestellingen (FK_bestellingen_klanten_id, FK_bestellingen_adres_id, aantal_artikelen, totaalprijs)" +
                "VALUES ?, ?, ?, ?")) {
            stmt.setInt(1, opgegevenBestelling.getKlantId());
            stmt.setInt(2, opgegevenBestelling.getAdresId());
            stmt.setInt(3, opgegevenBestelling.getAantalArtikelen());
            stmt.setBigDecimal(4, opgegevenBestelling.getTotaalprijs());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het toevoegen van de bestelling.");
            return false;
        }
        return true;
    } // einde toevoegenBestelling(Bestelling opgegevenBestelling)
    
    @Override
    public boolean updateBestellingKlantId(int bestellingId, int klantId) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "UPDATE bestellingen" +
                "SET FK_bestellingen_klanten_id = ?" +
                "WHERE bestellingen_id = ?")) {
        stmt.setInt(1, klantId);
        stmt.setInt(2, bestellingId);
        stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het aanpassen van het klantId van de bestelling.");
            return false;
        }
        return true;
    } // einde updateBestellingKlantId(int bestellingId, int klantId)
    
    @Override
    public boolean updateBestellingAdresId(int bestellingId, int adresId) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "UPDATE bestellingen" +
                "SET FK_bestellingen_adressen_id = ?" +
                "WHERE bestellingen_id = ?")) {
        stmt.setInt(1, adresId);
        stmt.setInt(2, bestellingId);
        stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het aanpassen van het adresId van de bestelling.");
            return false;
        }
        return true;
    } // einde updateBestellingAdresId(int bestellingId, int adresId)

    @Override
    public boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "UPDATE bestellingen" +
                "SET aantal_artikelen = ?" +
                "WHERE bestellingen_id = ?")) {
        stmt.setInt(1, aantalArtikelen);
        stmt.setInt(2, bestellingId);
        stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het aanpassen van het aantal artikelen van de bestelling.");
            return false;
        }
        return true;
    } // einde updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen)

    @Override
    public boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "UPDATE bestellingen" +
                "SET totaalprijs = ?" +
                "WHERE bestellingen_id = ?")) {
        stmt.setBigDecimal(1, totaalprijs);
        stmt.setInt(2, bestellingId);
        stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het aanpassen van de totaalprijs van de bestelling.");
            return false;
        }
        return true;
    } // einde updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs)

    @Override
    public boolean verwijderenBestelling(int bestellingId) {
        try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                    "DELETE FROM bestellingen" +
                    "WHERE bestellingen_id = ?")) {
        stmt.setInt(1, bestellingId);
        stmt.executeUpdate();
        stmt.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis met het verwijderen van de bestelling.");
            return false;
        }        
        return true;
    } // einde verwijderenBestelling(int bestellingId)
    
    @Override
    public void bekijkBestelling(int bestellingId) {
        List<Product> zoekresultaat = new ArrayList<>();
        Map<Product, Integer> test = new HashMap<Product, Integer>();
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
                    zoekresultaat.add(besteldProduct);
                    String hoeveelheid = "" + rs.getInt("hoeveelheid");
                    aantal.add("" + rs.getInt("hoeveelheid"));
                    // Testen of het lukt met 1 return, een hashmap
                        for (int i = 0; i < zoekresultaat.size(); i++) {
                            test.put(besteldProduct, rs.getInt("hoeveelheid"));
                        }
                }
                System.out.println("Bestelling " + bestellingId + " bestaat uit " + aantalArtikelen + " artikelen met een totaalprijs van " + totaalprijs + ".");
                System.out.println("De bestelling bestaat uit de volgende producten: ");
                for (int i = 0; i < zoekresultaat.size() - 1; i++) {
                    System.out.println("Product: " + zoekresultaat.get(i) + "/t/t" + "Aantal: " + aantal.get(i));
                }
                // Testen of het lukt met 1 return, een hashmap
                // return test; (om te printen in view)
                // hier printen (om te testen)
                System.out.println(Arrays.asList(test));
                
                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Er ging iets mis bij het bekijken van de bestelling.");
            
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