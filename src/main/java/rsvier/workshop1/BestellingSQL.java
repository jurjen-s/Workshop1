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
import java.util.List;

/**
 *
 * @author jurjen
 * @@ staat voor commentaar dat geen code-functie beschrijft
 * @@adrestype voor bestellingen = 2;
 */
public class BestellingSQL implements BestellingDAO {    
    
    /* velden die overeenkomen met velden in de database tabel Bestellingen
    private int bestellingID;
    private int klantID;
    private int accountID;
    private String voornaam;
    private String tussenvoegsel;
    private String achternaam;
    private int telefoonnummer;
    private int adresID;
    private String straatnaam;
    private int huisnummer;
    private String huisnummerToevoeging;
    private String postcode;
    private String land;
    private int aantalArtikelen;
    private BigDecimal totaalPrijs;
    */
    
    private Connection bestellingenconnectie;
    
    public BestellingSQL(Connection connectie) {
        this.bestellingenconnectie = connectie;
        System.out.println("============================");
        System.out.println("Wat wilt u doen?");
        System.out.println("----------------------------");
        System.out.println("1: Bestellingen doorzoeken.");
        System.out.println("2: Bestellingen toevoegen.");
        System.out.println("3: Bestellingen aanpassen.");
        System.out.println("4: Bestellingen verwijderen.");
        System.out.println("5: Terug naar hoofdmenu.");
        System.out.println("----------------------------");
        System.out.println("Geef uw keuze (1-5): ");
        System.out.println("============================");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 1:     zoekenBestelling();
                        break;
            case 2:     toevoegenBestelling();
                        break;
            case 3:     aanpassenBestelling();
                        break;
            case 4:     verwijderenBestelling();
            
            case 5:     // hoofdMenu.showMenu();
            
            default:    System.out.println("Ongeldige invoer.");
                        new BestellingSQL(bestellingenconnectie);
        }
        
    }
    
    @Override
    public void zoekenBestelling() {
        // Laat keuze-menu zien
        // Registreer keuze en geef verzoek door aan database
        // Laat zoekresultaat zien
        System.out.println("============================");
        System.out.println("Hoe wilt u bestellingen zoeken?");
        System.out.println("----------------------------");
        System.out.println("| 1: Doorzoek op bestellingID.|"); 
        System.out.println("| 2: Doorzoek op klantID.    |");
        System.out.println("| 3: Doorzoek op adres.    |");
        System.out.println("| 4: Doorzoek op aantal artikelen. |");
        System.out.println("| 5: Doorzoek op totaalprijs.");
        System.out.println("| 6: Terug naar hoofdmenu. |");
        System.out.println("----------------------------");
        System.out.println("|   Geef uw keuze (1-5):   |");
        System.out.println("============================");
        int keuze = TextIO.getlnInt();
        // Laat volgende menu zien afhankelijk van keuze
        switch (keuze) {
            case 1: 
                    System.out.println("=========================");
                    System.out.println("Doorzoek op bestellingID");
                    System.out.println("-------------------------");
                    System.out.println("Geef het bestellingID op: ");  
                    int bestellingID = TextIO.getlnInt(); // @@controleren input dmv error-handling
                    try {
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT * " +
                            " FROM bestellingen" +
                            " WHERE bestellingen_id = ?");
                        stmt.setInt(1, bestellingID);
                        ResultSet rs = stmt.executeQuery();
                        int klantID = rs.getInt("FK_bestellingen_klanten_id");
                        int aantalArtikelen = rs.getInt("aantal_artikelen");
                        BigDecimal totaalPrijs = rs.getBigDecimal("totaalprijs");
                        // Laat alle velden met het opgegeven bestellingID zien
                        while (rs.next()) {
                            System.out.println("Bestelling " + bestellingID +
                                               "van klant " + klantID +
                                               "bevat " + aantalArtikelen + " artikelen" +
                                               "met een totaalprijs van " + totaalPrijs + " euro.");
                        }
                    } catch (SQLException ex) {
                        System.out.println(ex);
                        System.out.println("Er ging iets mis bij het zoeken op bestellingID. Zijn alle velden ingevuld?");
                    }
                    // Laat het geregistreerde besteladres zien, als dat er is
                    // @@Naar aparte functie schrijven? Hoort dit uberhaupt op deze plek?
                    try {
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT straatnaam, huisnummer, " +
                                "(SELECT huisnummer_toevoeging FROM adressen WHERE heeft_huisnr_toevoeging = 1)" +
                            "postcode, land" +
                            "FROM adressen" +
                            "WHERE adressen_id = ? AND adressen_type = '2'");
                        stmt.setInt(1, klantID);
                        ResultSet rs = stmt.executeQuery();
                        voornaam = rs.getString("voornaam");
                        tussenvoegsel = "";
                        if (!rs.getString("tussenvoegsel").equalsIgnoreCase("null")) {
                            tussenvoegsel = rs.getString("tussenvoegsel");
                        }
                        achternaam = rs.getString("achternaam");
                        straatnaam = rs.getString("straatnaam");
                        huisnummer = rs.getInt("huisnummer");
                        huisnummerToevoeging = "";
                        if (!rs.getString("huisnummer_toevoeging").equalsIgnoreCase("null")) {
                            huisnummerToevoeging = rs.getString("huisnummer_toevoeging");
                        }
                        postcode = rs.getString("postcode");
                        land = rs.getString("land");
                        // Laat het bijbehorende adres van de klant zien. Vraag of het klopt of dat er wat aangepast moet worden.
                        System.out.println("Het gevonden bezorgadres bij klant" + voornaam + " " + achternaam + " is "
                                + straatnaam + " " + huisnummer + "-" + huisnummerToevoeging +
                                 " " + postcode + "\t" + land);
                        System.out.println("Kloppen deze gegevens?\n" +
                                            "Ja/Nee.");
                        // Ja >> ga verder (eigenlijk niet nodig, want is al einde van try block)
                        // Nee >> vraag of adres aangepast moet worden
                    } catch (SQLException ex) {
                        System.out.println(ex.toString());
                        System.out.println("Het bezorgadres van klant " + voornaam + "  " + achternaam + " kan niet worden gevonden.");
                        System.out.println("Wilt u een nieuw adres aanmaken?\n" +
                                            "Ja/Nee.");
                        // Ja >> roep functie aan om niew adres aan te maken
                        // Nee >> print dat bestelling niet aangemaakt kan worden en keer terug naar menu toevoegenBestelling
                    }
                    // @@Waarschijnlijk overbodige code, maar hier bewaard als backup
                    /*System.out.println("De bestelling wordt verzonden naar:\n" +
                                        straatnaam + " " + huisnummer + "-" + huisnummer_toevoeging + "\n" +
                                        postcode + "\t" + land);
                        }
                        // productenconnectie.close();      // wel of niet nodig?
                    } catch (SQLException ex) {
                            System.out.println("Het zoeken op bestellingID ging mis.");
                            ex.getMessage();
                    }
                    // Print de zoekresultaten
                    if (zoekresultaat.isEmpty()) {
                        System.out.println("Geen zoekresultaten.");
                    }
                    for (Product product : zoekresultaat) {
                        System.out.println(product);
                    }*/
                    break; // einde case 1
            case 2:
                    System.out.println("=========================");
                    System.out.println("Doorzoek op klantID");
                    System.out.println("-------------------------");
                    System.out.println("Geef het klantID op: ");
                    klantID = TextIO.getInt();
                    try {
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT * " +
                            " FROM bestellingen " +
                            " WHERE FK_bestellingen_klanten_id = ?");
                        stmt.setInt(1, klantID);
                        ResultSet rs = stmt.executeQuery();
                        bestellingID = rs.getInt("bestellingen_id");
                        aantalArtikelen = rs.getInt("aantal_artikelen");
                        totaalPrijs = rs.getBigDecimal("totaalprijs");
                        // Laat alle bestellingen met het opgegeven klantID zien
                        while (rs.next()) { //@@Poging om rijen neer te zetten
                            int i = 1;
                            System.out.print(i + ":");
                            System.out.print("\tBestellingID: " + bestellingID);
                            System.out.print("\tAantal artikelen: " + aantalArtikelen);
                            System.out.print("\tTotaalprijs: " + totaalPrijs);
                        }
                        stmt.close();
                    } catch (SQLException ex) {
                            System.out.println("Het zoeken op klantID ging mis.");
                            ex.getMessage();
                    }
                    break; // einde case 2
            case 3:
                    System.out.println("=========================");
                    System.out.println("Doorzoek op adres");
                    System.out.println("-------------------------");
                    System.out.println("Geef het adres op. " +
                                       "Laat het veld leeg wanneer niet van toepassing): ");
                    System.out.println("Straatnaam: ");
                    straatnaam = TextIO.getln();
                    System.out.println("Huisnummer: ");
                    huisnummer = TextIO.getInt();
                    System.out.println("Toevoeging huisnummer: ");
                    huisnummerToevoeging = TextIO.getln();
                    System.out.println("Postcode: ");
                    postcode = TextIO.getln();
                    // @@Land lijkt me overbodig
                    //System.out.println("Land: ");
                    //land = TextIO.getln();
                    try { // @@besef nu pas dat er overal join statements gebruikt kunnen worden waar gezocht wordt met FK's
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT adressen_id " +
                            "FROM adressen " +
                            "WHERE straatnaam = ? AND huisnummer = ? AND huisnummer_toevoeging = ? AND postcode = ?");
                        stmt.setString(1, straatnaam);
                        stmt.setInt(2, huisnummer);
                        if (huisnummerToevoeging != null && !huisnummerToevoeging.toString().trim().equals("")) {
                            stmt.setString(3, huisnummerToevoeging);
                        }
                        stmt.setString(4, postcode);
                        ResultSet rs = stmt.executeQuery();
                        // Laat alle producten met de opgegeven prijs zien
                        while (rs.next()) {
                            klantID = rs.getInt("FK_adressen_klanten_id");
                        }
                        stmt.close();
                    } catch (SQLException ex) {
                            System.out.println("Het opgegeven adres is niet gevonden.");
                            ex.getMessage();
                    }
                    // Hier ga je er van uit dat er een geldig klantID teruggekomen is
                    // Met dat klantID op zoek naar corresponderende bestellingen
                    try {
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT * " +
                            "FROM bestellingen" +
                            "WHERE FK_bestellingen_klanten_id = ?");
                        stmt.setInt(1, klantID);
                        ResultSet rs = stmt.executeQuery();
                        bestellingID = rs.getInt("bestellingen_id");
                        klantID = rs.getInt("FK_bestellingen_klanten_id");
                        adresID = rs.getInt("FK_bestellingen_adressen_id");
                        aantalArtikelen = rs.getInt("aantal_artikelen");
                        totaalPrijs = rs.getBigDecimal("totaalprijs");
                        // Print de zoekresultaten
                        System.out.println("De volgende bestellingen zijn gevonden voor het opgegeven adres: ");
                        while (rs.next()) {
                            System.out.println("BestellingID:\t" + bestellingID + "\tKlantID:\t" + klantID + 
                                               "\tAdresID:\t" + adresID + "\tAantal artikelen:\t" + aantalArtikelen +
                                               "\tTotaalprijs:\t" + totaalPrijs + ".");
                        }
                    } catch (SQLException ex) {
                        System.out.println("Er ging iets mis bij het zoeken van een bestelling.");
                        System.out.println(ex.toString());
                    }
                    break; // einde case 3
            case 4: //
                    System.out.println("=========================");
                    System.out.println("Doorzoek bestellingen op aantal artikelen");
                    System.out.println("-------------------------");
                    System.out.println("Geef het aantal artikelen op: ");
                    aantalArtikelen = TextIO.getlnInt();
                    try {
                        PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                            "SELECT * " +
                            "FROM bestellingen" +
                            "WHERE aantal_artikelen = ?");
                        stmt.setInt(1, aantalArtikelen);
                        ResultSet rs = stmt.executeQuery();
                        // Laat alle producten met de opgegeven voorraad zien
                        while (rs.next()) {
                            System.out.println(rs.getInt("bestellingen_id") + "\t" + rs.getInt("FK_bestellingen_klanten_id") + 
                                    "\t" + rs.getInt("FK_bestellingen_adressen_id") + "\t" + rs.getBigDecimal("totaalprijs"));
                        }
                    } catch (SQLException ex) {
                        System.out.println("Het zoeken op aantal artikelen ging mis.");
                        System.out.println(ex.getMessage());
                    }                        
                    break; // einde case 4
            case 5:
                    //hoofdMenu.showMenu();
                    System.out.println("Hier komt een verwijzing naar het hoofdmenu.");
                    break;
            default:
                    System.out.println("Ongeldige invoer.");
                    zoekenBestelling();
                    break;
            } // einde switch
    } // einde zoekenBestelling()
    

    @Override
    public void toevoegenBestelling() {
        // Menu om bestellingen toe te voegen
        // Controleert of alle foreign keys in bestellingen verwijzen naar een waarde ipv null
            // Vraagt om waardes toe te voegen als ze ontbreken
        System.out.println("=========================================");
        System.out.println("Voeg nieuwe bestelling toe.");
        System.out.println("-----------------------------------------");
        System.out.println("Wat is de naam van de bijbehorende klant?");
        System.out.println("Voornaam: ");
        voornaam = TextIO.getln();
        System.out.println("Achternaam: ");
        achternaam = TextIO.getln();
        System.out.println("-----------------------------------------.");
        // Zoek of klantID al bestaat in klanten tabel. Zo niet, prompt dan om toevoegen nieuwe klant.
        try {
            PreparedStatement stmt = bestellingenconnectie.prepareStatement(
               "SELECT klanten_id" +
               "FROM klanten" +
               "WHERE voornaam = ? and achternaam = ?");
            stmt.setString(1, voornaam);
            stmt.setString(2, achternaam);
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            klantID = rs.getInt("klanten_id");
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("De klant " + voornaam + "  " + achternaam + " kan niet worden gevonden.");
            System.out.println("Wilt u een nieuwe klant aanmaken?\n" +
                                "Ja/Nee.");
            // Ja >> roep functie aan om nieuwe klant aan te maken
                // functie returnt klantID = net aangemaakte klant_id
            // Nee >> terug naar toevoegen bestelling menu
        }
        // Zoek of klant met <voornaam> en <achternaam> een adres heeft voor bestellingen
        try {
            PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "SELECT straatnaam, huisnummer, " +
                    "(SELECT huisnummer_toevoeging FROM adressen WHERE heeft_huisnr_toevoeging = 1)" +
                "postcode, land" +
                "FROM adressen" +
                "WHERE adressen_type = 2");
            ResultSet rs = stmt.executeQuery();
            stmt.close();
            straatnaam = rs.getString("straatnaam");
            huisnummer = rs.getInt("huisnummer");
            huisnummerToevoeging = "";
            if (!rs.getString("huisnummer_toevoeging").equalsIgnoreCase("null")) {
                huisnummerToevoeging = rs.getString("huisnummer_toevoeging");
            }
            postcode = rs.getString("postcode");
            land = rs.getString("land");
            // Laat het bijbehorende adres van de klant zien. Vraag of het klopt of dat er wat aangepast moet worden.
            System.out.println("Het gevonden adres bij klant" + voornaam + " " + achternaam + " is "
                    + straatnaam + " " + huisnummer + "-" + huisnummerToevoeging +
                     " " + postcode + "\t" + land);
            System.out.println("Kloppen deze gegevens?\n" +
                                "Ja/Nee.");
            // Ja >> ga verder (eigenlijk niet nodig, want is al einde van try block)
            // Nee >> vraag of adres aangepast moet worden
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            System.out.println("Het bezorgadres van klant " + voornaam + "  " + achternaam + " kan niet worden gevonden.");
            System.out.println("Wilt u een nieuw adres aanmaken?\n" +
                                "Ja/Nee.");
            // Ja >> roep functie aan om niew adres aan te maken
            // Nee >> print dat bestelling niet aangemaakt kan worden en keer terug naar menu toevoegenBestelling
        }    
        try {
            PreparedStatement stmt = bestellingenconnectie.prepareStatement(
            "INSERT INTO bestellingen (FK_klanten_id, FK_adressen_id, aantal_artikelen, totaalprijs) " +
            "VALUES (?, ?, ?, ?)");
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        // vraag of haal op om hoeveel artikelen het gaat
        // vraag of haal op wat de totaalprijs is
        System.out.println("Dit zijn de gegevens van de bestelling.");
        // Print Klant (voornaam + achternaam) heeft bestelling (bestelling_id) met aantal_artikelen en totaalprijs
    } // einde toevoegenBestelling()

    @Override
    public void aanpassenBestelling() { // deze moet nog aangepast worden
        System.out.println("==========================");
        System.out.println("Pas bestellingen aan.");
        System.out.println("--------------------------");
        // volgorde van kolommen: bestellingen_id FK_bestellingen_klanten_id, FK_bestellingen_adressen_id aantal_artikelen, totaalprijs
        System.out.println("Wat is het bestellingID van de aan te passen bestelling?");
        bestellingID = TextIO.getInt();
        System.out.println("Welke eigenschap wilt u aanpassen?\n" +
                           "1: KlantID \n 2: AdresID \n 3: Aantal artikelen \n 4: Totaalprijs");
        int keuze = TextIO.getInt();
        String kolomnaam = "";
        switch (keuze) {
            case 1: kolomnaam = "FK_bestellingen_klanten_id";
                    break;
            case 2: kolomnaam = "FK_bestellingen_adressen_id";
                    break;
            case 3: kolomnaam = "aantal_artikelen";
                    break;
            case 4: kolomnaam = "totaalprijs";
                    break;                
        }
        // Haal huidige waarde van de genoemde eigenschap op
        String huidigeWaarde = "";
        try {
            PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "SELECT ?" +
                "FROM bestellingen" +
                "WHERE bestellingen_id = ?");
            stmt.setString(1, kolomnaam);
            stmt.setInt(2, bestellingID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                huidigeWaarde = rs.getString(kolomnaam);
            }
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis bij het zoeken naar de aan te passen bestelling.");
            ex.getMessage();
        }
        // Vraag wat nieuwe waarde wordt
        System.out.println("De huidige waarde van " + bestellingID + " is " + huidigeWaarde + ".\n" +
                           "Wat wordt de nieuwe waarde?");
        String nieuweWaarde = TextIO.getln();
            try {
                PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                        "UPDATE bestellingen" +
                        "SET ? = ?" +
                        "WHERE bestellingen_id = ?");
                        stmt.setString(1, kolomnaam);
                        stmt.setString(2, nieuweWaarde);
                stmt.setInt(3, bestellingID);
                stmt.executeUpdate();
                stmt.close();
            } catch (SQLException ex) {
                System.out.println("Er ging iets mis bij het aanpassen van het product.");
                ex.getMessage();
            }
    } // einde showAanpassenMenu
    

    @Override
    public void verwijderenBestelling() {// deze moet nog aangepast worden
        System.out.println("==========================");
        System.out.println("Verwijder bestellingen.");
        System.out.println("--------------------------");
        System.out.println("Wat is het bestellingID van de te verwijderen bestelling?");
        bestellingID = TextIO.getInt();
        try {
            PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                "DELETE FROM bestellingen" +
                "WHERE bestellingen_id = ?");
            stmt.setInt(1, bestellingID);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException ex) {
            System.out.println("Er ging iets mis met het zoeken naar de te verwijderen bestelling.");
            ex.getMessage();
        }        
    } // einde vrwijderenBestelling()

/**
* Zoekt in de tabel bestellingen naar het opgegeven bestellingID en laat de corresponderende data zien.
* 
* @param    zoekterm    Een integer die vergeleken moet worden met bestellingen_id in de bestellingen tabel
* @return               Een bestelling object dat overeenkomt met de bestelling gevonden in de database
*/    
public Bestelling findBestellingById(int zoekterm) { // zoeken op bestellingID kan maar 1 match geven, dus void
    int bestellingID = zoekterm;
    // @@Controleren of bestellingID bestaat in de db
    Bestelling zoekresultaat;
    try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
        "SELECT * " +
        "FROM bestellingen" +
        "WHERE bestellingen_id = ?")) {
        stmt.setInt(1, bestellingID);
        ResultSet rs = stmt.executeQuery();
        int klantID = rs.getInt("FK_bestellingen_klanten_id");
        // @@Controleren of klantID bestaat in bestellingen aangezien het een FK is
        int aantalArtikelen = rs.getInt("aantal_artikelen");
        BigDecimal totaalPrijs = rs.getBigDecimal("totaalprijs");
        // Er kan maar 1 resultaat zijn
        while (rs.next()) {
            zoekresultaat = new Bestelling.BestellingBuilder(bestellingID)
                                                     .klantID(klantID)
                                                     .adresID(adresID)
                                                     .aantalArtikelen(aantalArtikelen)
                                                     .totaalprijs(totaalPrijs)
                                                     .build();
        }
        rs.close();
    } catch (SQLException ex) {
        System.out.println(ex);
        System.out.println("Er ging iets mis bij het zoeken op bestellingID.");
    }
    return zoekresultaat;
} // einde zoekBestelling(int bestellingID)

public List findBestellingByKlant(int zoekterm) {
    int klantID = zoekterm;
    // @@Controleren of klantID bestaat in database
    List<Bestelling> zoekresultaat = new ArrayList<>();
    try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
        "SELECT * " +
        "FROM bestellingen " +
        "WHERE FK_bestellingen_klanten_id = ?")) {
        stmt.setInt(1, klantID);
        ResultSet rs = stmt.executeQuery();
        int bestellingID = rs.getInt("bestellingen_id");
        int adresID = rs.getInt("FK_bestellingen_adressen_id");
        int aantalArtikelen = rs.getInt("aantal_artikelen");
        BigDecimal totaalPrijs = rs.getBigDecimal("totaalprijs");
        // Laat alle bestellingen met het opgegeven klantID zien
        while (rs.next()) { //@@Poging om rijen neer te zetten
        /*
        int i = 1;
        System.out.print(i + ":");
        System.out.print("\tBestellingID: " + bestellingID);
        System.out.print("\tAantal artikelen: " + aantalArtikelen);
        System.out.print("\tTotaalprijs: " + totaalPrijs);
        */
        Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(bestellingID)
                                           .klantID(klantID)
                                           .adresID(adresID)
                                           .aantalArtikelen(aantalArtikelen)
                                           .totaalprijs(totaalPrijs)
                                           .build();
        zoekresultaat.add(gevondenBestelling);
        }
        rs.close();
    } catch (SQLException ex) {
        System.out.println("Het zoeken van een bestelling op klantID ging mis.");
        ex.getMessage();
    }
    /*
    Om te printen:
    for (Bestelling bestelling : zoekresultaat) {
        System.out.println(bestelling);
    }
    */
    return zoekresultaat;
} // einde findBestellingByKlant

public List findBestellingByAdres(Adres opgegevenAdres) {
    
    // @@ Krijg adresgegevens van view via controller (in de vorm van Adres object?)
    /*
    Dit moet naar de view

    System.out.println("=========================");
    System.out.println("Doorzoek op adres");
    System.out.println("-------------------------");
    System.out.println("Geef het adres op. " +
                       "Laat het veld leeg wanneer niet van toepassing): ");
    System.out.println("Straatnaam: ");
    straatnaam = TextIO.getln();
    System.out.println("Huisnummer: ");
    huisnummer = TextIO.getInt();
    System.out.println("Toevoeging huisnummer: ");
    huisnummerToevoeging = TextIO.getln();
    System.out.println("Postcode: ");
    postcode = TextIO.getln();
    //  @@Land lijkt me overbodig
    System.out.println("Land: ");
    land = TextIO.getln();

    */
    List<Bestelling> zoekresultaat = new ArrayList<>();
    // @@ besef nu pas dat er overal join statements gebruikt kunnen worden waar gezocht wordt met FK's
    // @@ Misschien handig om de user te vragen of hij wilt zoeken op straatnaam etc of op adresID
    // @@ Misschien een mogelijkheid om de user te vragen of hij de tabel met adressen wil zien voor het invoeren van ID?
    String straatnaam = opgegevenAdres.getStraatnaam();
    int huisnummer = opgegevenAdres.getHuisnummer();
    String huisnummerToevoeging = "";
    if (opgegevenAdres.getHuisnummerToevoeging != null && !opgegevenAdres.getHuisnummerToevoeging.trim().equals("")) {
        huisnummerToevoeging = opgegevenAdres.getHuisnummerToevoeging();
    }
    String postcode = opgegevenAdres.getPostcode();
    int adresID;
                    // Misschien moet dit naar aparte functie? findBestellingByAdresID en findBestellingByAdres?
                    try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
                        "SELECT adressen_id " +
                        "FROM adressen " +
                        "WHERE straatnaam = ? AND huisnummer = ? AND huisnummer_toevoeging = ? AND postcode = ?")) {
                        stmt.setString(1, straatnaam);
                        stmt.setInt(2, huisnummer);
                        if (huisnummerToevoeging != null && huisnummerToevoeging.trim().equals("")) {
                            stmt.setString(3, huisnummerToevoeging);
                        }
                        stmt.setString(4, postcode);
                        ResultSet rs = stmt.executeQuery();
                        // Laat alle producten met de opgegeven prijs zien
                        while (rs.next()) {
                            adresID = rs.getInt("adressen_id");
                        }
                    rs.close();
                    } catch (SQLException ex) {
                        System.out.println(ex);
                        System.out.println("Het opgegeven adres is niet gevonden.");
                    }


    // Hier ga je er van uit dat er een geldig klantID teruggekomen is
    // Met dat klantID op zoek naar corresponderende bestellingen
    try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
            "SELECT * " +
            "FROM bestellingen" +
            "WHERE FK_bestellingen_adressen_id = ?")) {
        stmt.setInt(1, adresID);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
        Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(rs.getInt("bestellingen_id"))
                                                      .klantID(rs.getInt("FK_bestellingen_klanten_id"))
                                                      .adresID(rs.getInt("FK_bestellingen_adressen_id"))
                                                      .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                      .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                      .build();
        zoekresultaat.add(gevondenBestelling);
        }
        rs.close();
        /*
        // Vervangen methode, aangezien er meerdere bestellingen per adres gevonden kunnen worden
        bestellingID = rs.getInt("bestellingen_id");
        klantID = rs.getInt("FK_bestellingen_klanten_id");
        adresID = rs.getInt("FK_bestellingen_adressen_id");
        aantalArtikelen = rs.getInt("aantal_artikelen");
        totaalPrijs = rs.getBigDecimal("totaalprijs");
        // Print de zoekresultaten
        System.out.println("De volgende bestellingen zijn gevonden voor het opgegeven adres: ");
        while (rs.next()) {
            System.out.println("BestellingID:\t" + bestellingID + "\tKlantID:\t" + klantID + 
                               "\tAdresID:\t" + adresID + "\tAantal artikelen:\t" + aantalArtikelen +
                               "\tTotaalprijs:\t" + totaalPrijs + ".");
        } */
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        System.out.println("Er ging iets mis bij het zoeken van een bestelling.");
    }
    return zoekresultaat;
} // einde zoekBestellingByAdres()

public List findBestellingByAantalArtikelen(int aantal) {
    int aantalArtikelen = aantal;
    List<Bestelling> zoekresultaat = new ArrayList<>();
    try (PreparedStatement stmt = bestellingenconnectie.prepareStatement(
            "SELECT * " +
            "FROM bestellingen" +
            "WHERE aantal_artikelen = ?")) {
        stmt.setInt(1, aantalArtikelen);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Bestelling gevondenBestelling = new Bestelling.BestellingBuilder(rs.getInt("bestellingen_id"))
                                                          .klantID(rs.getInt("FK_bestellingen_klanten_id"))
                                                          .adresID(rs.getInt("FK_bestellingen_adressen_id"))
                                                          .aantalArtikelen(rs.getInt("aantal_artikelen"))
                                                          .totaalprijs(rs.getBigDecimal("totaalprijs"))
                                                          .build();
            zoekresultaat.add(gevondenBestelling);
        }
        rs.close();
        /*
        while (rs.next()) {
            System.out.println(rs.getInt("bestellingen_id") + "\t" + rs.getInt("FK_bestellingen_klanten_id") + 
                    "\t" + rs.getInt("FK_bestellingen_adressen_id") + "\t" + rs.getBigDecimal("totaalprijs"));
        }
        */
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
        System.out.println("Het zoeken op aantal artikelen ging mis.");        
    }                        
    return zoekresultaat;
} // einde findBestellingByAantalArtikelen()

} // einde BestellingSQL
