/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author jurjen
 */
public class BestellingMenu {
    
    private Controller controller = new Controller();
    private BestellingController bestellingController = new BestellingController();
    
    public  void bestellingenmenu(){

        System.out.println("Welkom in het bestellingenmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("Doorzoek bestellingen");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek bestelling op bestellingId.");
        System.out.println("2: Doorzoek bestelling op klantId.");
        System.out.println("3: Doorzoek bestelling op adres."); 
        System.out.println("4: Doorzoek bestelling op aantal artikelen.");
        System.out.println("5: Doorzoek bestelling op totaalprijs.");
        System.out.println("6: Toevoegen bestelling.");
        System.out.println("7: Verander bestelling: klantId.");
        System.out.println("8: Verander bestelling: adresId.");
        System.out.println("9: Verander bestelling: aantal artikelen");
        System.out.println("10: Verander bestelling: totaalprijs.");
        System.out.println("11: Verwijder bestelling.");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");

        int keuze = TextIO.getlnInt();

        switch (keuze) {
            case 1: System.out.println(" 1 Doorzoek op bestellingID"); bestellingenmenuDbi(); break;
            case 2: System.out.println(" 2 Doorzoek op klantID"); bestellingenmenuDbk(); break;
            case 3: System.out.println(" 3 Doorzoek op adress"); bestellingenmenuDbA(); break;
            case 4: System.out.println(" 4 Doorzoek op aantal artikelen"); bestellingenmenuDbAA();    break;
            case 5: System.out.println(" 5 Doorzoek op totaalprijs");  bestellingenmenuDoTP(); break;
            case 6: System.out.println(" 6 Toevoegen bestelling ");  bestellingenmenuTB(); break;
            case 7: System.out.println(" 7 Verander  bestelling klant id"); bestellingenmenuVki(); break;
            case 8: System.out.println(" 8 Verander bestelling adress id"); bestellingenmenuVAi(); break;
            case 9: System.out.println(" 9 Verander bestelling aantal artikelen"); bestellingenmenuVAA(); break;
            case 10: System.out.println(" 10 Verander bestelling totaal prijs");bestellingenmenuVTP(); break;
            case 11: System.out.println(" 11 Verwijder bestelling dmv id"); bestellingenmenuDELETE(); break;
            case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
            default: System.out.println("Verkeerde invoer."); bestellingenmenu();
        }
    }

    public void bestellingenmenuDbi(){
        System.out.println("U gaat een bestelling zoeken op bestelling ID.");
        System.out.println("Vul bestellingID in en druk op enter.");
        int bestellingId = TextIO.getlnInt();
        Bestelling bestelling = bestellingController.findBestellingById(bestellingId);
        if (bestelling.getBestellingId() == 0) {
            System.out.println("Geen zoekresultaten.");
        } else {
            System.out.println(bestelling);
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuDbk(){
        System.out.println("U gaat een bestelling zoeken mbv klant ID.");
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.println("Vul klantID in en druk op enter.");
            klantId = TextIO.getlnInt();
        } while (!controller.existsKlantId(klantId));
        List<Bestelling> zoekresultaat = bestellingController.findBestellingByKlant(klantId);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Bestelling bestelling : zoekresultaat) {
            System.out.println(bestelling);
            }
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuDbA(){
        System.out.println("U gaat een bestelling zoeken op Adres id.");
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.println("Vul adresId in en druk op enter.");
            adresId = TextIO.getlnInt();
        } while (!controller.existsAdresId(adresId));
        List<Bestelling> zoekresultaat = bestellingController.findBestellingByAdres(adresId);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Bestelling bestelling:zoekresultaat) {
            System.out.println(bestelling);
            }
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuDbAA(){
        System.out.println("U gaat een bestelling zoeken op Aantal artikelen.");
        System.out.println("Vul het aantal in en druk op enter.");
        int aantal = TextIO.getlnInt();
        List<Bestelling> zoekresultaat = bestellingController.findBestellingByAantalArtikelen(aantal);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Bestelling bestelling:zoekresultaat) {
            System.out.println(bestelling);
            }
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuDoTP(){
        System.out.println("U gaat een bestelling zoeken op Totaal prijs.");
        System.out.println("Vul het totaal in en druk op enter.");
        BigDecimal pPrijs = new BigDecimal(TextIO.getln());
        List<Bestelling> zoekresultaat = bestellingController.findBestellingTotaalprijs(pPrijs);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Bestelling bestelling:zoekresultaat) {
            System.out.println(bestelling);
            }
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuTB() {
        System.out.println("U gaat een bestelling toevoegen.");
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.println("Vul klantId in en druk op enter.");
            klantId = TextIO.getlnInt();
        } while (!controller.existsKlantId(klantId));
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.println("Vul adresId in en druk op enter.");
            adresId = TextIO.getlnInt();
        } while (!controller.existsAdresId(adresId));
        System.out.println("Vul aantal artikelen in en druk op enter");
        int aantalArtikelen = TextIO.getlnInt();
        System.out.println("Vul totaalprijs in en druk op enter");
        BigDecimal totaalprijs = new BigDecimal(TextIO.getln());
        Bestelling bestelling = new Bestelling.BestellingBuilder()
                                              .klantId(klantId)
                                              .adresId(adresId)
                                              .aantalArtikelen(aantalArtikelen)
                                              .totaalprijs(totaalprijs)
                                              .build();
        System.out.println("Input: " + bestelling.toString());
        Bestelling zoekresultaat = bestellingController.toevoegenBestelling(bestelling);
        if (zoekresultaat.getBestellingId() != 0) {
            System.out.println("Het toevoegen van de bestelling is gelukt.");
        } else {
            System.out.println("Het toevoegen van de bestelling is mislukt.");
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuVki(){
        System.out.println("U gaat een bestelling klant id veranderen.");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul bestellingId in en druk op enter.");
            bestellingId = TextIO.getlnInt();
        } while (!controller.existsBestellingId(bestellingId));
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.println("Vul het nieuwe klantId in en druk op enter.");
            klantId = TextIO.getlnInt();
        } while (!controller.existsKlantId(klantId));   
        if (bestellingController.updateBestellingKlantID(bestellingId, klantId) == true) {
            System.out.println("Het veranderen van de bestelling is gelukt.");
        } else {
            System.out.println("Het veranderen van de bestelling is mislukt.");
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuVAi(){
        System.out.println("U gaat een bestelling Adres id veranderen.");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul bestellingId in en druk op enter.");
            bestellingId = TextIO.getlnInt();
        } while (!controller.existsBestellingId(bestellingId));
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.println("Vul het nieuwe adresId in en druk op enter.");
            adresId = TextIO.getlnInt();
        } while (!controller.existsAdresId(adresId));
        if (bestellingController.updateBestellingAdresID(bestellingId, adresId) == true) {
            System.out.println("Het veranderen van de bestelling is gelukt.");
        } else {
            System.out.println("Het veranderen van de bestelling is mislukt.");
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuVAA(){
        System.out.println("U gaat het aantal artikelen in een bestelling veranderen.");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul bestellingId in en druk op enter.");
            bestellingId = TextIO.getlnInt();
        } while (!controller.existsBestellingId(bestellingId));
        System.out.println("Vul het nieuwe aantal artikelen in en dan enter.");
        int aantalArtikelen = TextIO.getlnInt();
        if (bestellingController.updateBestellingAantalArtikelen(bestellingId, aantalArtikelen) == true) {
            System.out.println("Het veranderen van de bestelling is gelukt.");
        } else {
            System.out.println("Het veranderen van de bestelling is mislukt.");
        }
        bestellingenmenu();   
    }

    public  void bestellingenmenuVTP(){
        System.out.println("U gaat de totaalprijs in een bestelling veranderen.");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul bestellingId in en druk op enter.");
            bestellingId = TextIO.getlnInt();
        } while (!controller.existsBestellingId(bestellingId));
        System.out.println("Vul de nieuwe totaalprijs in en dan enter.");
        BigDecimal totaalprijs = new BigDecimal(TextIO.getlnInt());
        if (bestellingController.updateBestellingTotaalprijs(bestellingId, totaalprijs) == true) {
            System.out.println("Het veranderen van de bestelling is gelukt.");
        } else {
            System.out.println("Het veranderen van de bestelling is mislukt.");
        }
        bestellingenmenu();
    }

    public  void bestellingenmenuDELETE(){
        System.out.println("U gaat een bestelling verwijderen");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul bestellingId in en druk op enter.");
            bestellingId = TextIO.getlnInt();
        } while (!controller.existsBestellingId(bestellingId));
        if (bestellingController.deleteBestelling(bestellingId) == true) {
            System.out.println("Het verwijderen van de bestelling is gelukt.");
        } else {
            System.out.println("Het verwijderen van de bestelling is mislukt.");
        }
        bestellingenmenu();
    }
}
