/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.factuur;

import java.math.BigDecimal;
import java.util.List;
import rsvier.workshop1.Controller;
import rsvier.workshop1.Menu;
import rsvier.workshop1.util.TextIO;

/**
 *
 * @author jurjen
 */
public class FactuurMenu {
    
    private Controller controller = new Controller();
    private FactuurController factuurController = new FactuurController();
    
    public void facturenmenu(){
        System.out.println("Welkom in het facturenmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek facturen op factuur id.");
        System.out.println("2: Doorzoek facturen op klant id.");
        System.out.println("3: Doorzoek facturen op adress id ."); 
        System.out.println("4: Doorzoek facturen op bestelling id.");
        System.out.println("5: Doorzoek facturen op totaalprijs.");
        System.out.println("6: Doorzoek facturen op status.");
        System.out.println("7: Toevoegen factuur.");
        System.out.println("8: Zet status factuur op betaald.");
        System.out.println("9: Verwijder factuur met id.");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 1:  System.out.println("1: Doorzoek facturen met id."); facturenmenuZoId(); break; 
            case 2:  System.out.println("2: Doorzoek facturen met klant id."); facturenmenuZoKid(); break;
            case 3:  System.out.println("3: Doorzoek facturen met adress id ."); facturenmenuZoAid(); break;
            case 4:  System.out.println("4: Doorzoek facturen met bestelling id.");facturenmenuZoBid(); break;
            case 5:  System.out.println("5: Doorzoek facturen met totaal prijs."); facturenmenuZoTP(); break;
            case 6:  System.out.println("6: Doorzoek facturen op status."); facturenmenuZoS(); break;              
            case 7:  System.out.println("7: Toevoegen factuur."); facturenmenuFT(); break;              
            case 8:  System.out.println("8: Zet status factuur op betaald."); facturenmenuVS(); break;
            case 9:  System.out.println("9: VERWIJDER factuur met id."); facturenmenuDELETE(); break;
            case 0:  Menu menu = new Menu(); menu.hoofdmenu(); break;
            default: System.out.println("Verkeerde invoer."); facturenmenu();
        }
    }

    public void facturenmenuZoS() {
        System.out.println("U wilt facturen op status doorzoeken.");
        System.out.println("Op welke status (0: onbetaald, 1: betaald) wilt u zoeken?");
        int status = TextIO.getlnInt();
        List<Factuur> zoekresultaat = factuurController.findFactuurByStatus(status);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Factuur factuur : zoekresultaat) {
            System.out.println(factuur);
            }
        }
        facturenmenu();
    }
    
    public void facturenmenuDELETE() {
        System.out.println("U gaat een factuur verwijderen");
        int factuurId = -1;
        do {
            System.out.println("Vul het factuurId in en druk op enter. Vul 0 in om te annuleren.");
            if (factuurId == 0) {
            facturenmenu();
            }
            factuurId = TextIO.getlnInt();
        } while (!controller.existsFactuurId(factuurId));
        if (factuurController.deleteFactuur(factuurId) == true) {
            System.out.println("Het verwijderen is gelukt.");
        } else {
            System.out.println("Het verwijderen is mislukt.");
        }
        facturenmenu();
    }
    
    public void facturenmenuVS() {
        System.out.println("Welke factuur wilt u de status 'betaald' geven?");
        int factuurId = -1;
        do {
            System.out.println("Vul het factuurId in en druk op enter.");
            if (factuurId == 0) {
            facturenmenu();
            }
            factuurId = TextIO.getlnInt();
        } while (!controller.existsFactuurId(factuurId));
        if (factuurController.betaalFactuur(factuurId) == true) {
            System.out.println("Het veranderen van de status is gelukt.");
        } else {
            System.out.println("Het veranderen van de status is mislukt.");
        }
        facturenmenu();
    }

    
    public void facturenmenuFT() {
        System.out.println("U gaat een factuur toevoegen.");
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.println("Vul het klantId in en druk op enter. Vul 0 in als u wilt annuleren.");
            klantId = TextIO.getlnInt();
            if (klantId == 0) {
                facturenmenu();
            }
        } while (!controller.existsKlantId(klantId));
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul het bestellingId in en druk op enter. Vul 0 in als u wilt annuleren.");
            bestellingId = TextIO.getlnInt();
            if (bestellingId == 0) {
                facturenmenu();
            }
        } while (!controller.existsBestellingId(bestellingId));
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.println("Vul het adresId in en druk op enter. Vul 0 in als u wilt annuleren.");
            adresId = TextIO.getlnInt();
            if (adresId == 0) {
                facturenmenu();
            }
        } while (!controller.existsAdresId(adresId));
        Factuur factuur = new Factuur.FactuurBuilder()
                          .klantId(klantId)
                          .bestellingId(bestellingId)
                          .adresId(adresId)
                          //.status(status)
                          .build();
        if (factuurController.maakFactuur(factuur) == true) {
            System.out.println("Het toevoegen van de factuur is gelukt.");
        } else {
            System.out.println("Het toevoegen van de factuur is mislukt.");
        }
        facturenmenu();
    }
    
    public void facturenmenuZoTP() {
        System.out.println("U gaat een factuur zoeken op totaalprijs");
        System.out.println("Vul de totaalprijs in en druk op enter.");
        BigDecimal totaalprijs = new BigDecimal(TextIO.getln());
        List<Factuur> zoekresultaat = factuurController.findFactuurByTotaalprijs(totaalprijs);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Factuur factuur : zoekresultaat) {
            System.out.println(factuur);
            }
        }
        facturenmenu();
    }
    
    public void facturenmenuZoBid() {
        System.out.println("U gaat een factuur zoeken op bestelling id");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul het bestellingId in en druk op enter. Vul 0 in als u wilt annuleren.");
            bestellingId = TextIO.getlnInt();
            if (bestellingId == 0) {
                facturenmenu();
            }
        } while (!controller.existsBestellingId(bestellingId));
        Factuur zoekresultaat = factuurController.findFactuurByBestellingId(bestellingId);
        System.out.println(zoekresultaat);
        facturenmenu();
    }
    
    public  void facturenmenuZoAid() {
        System.out.println("U gaat een factuur zoeken op adres id");
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.println("Vul het adresId in en druk op enter. Vul 0 in als u wilt annuleren.");
            adresId = TextIO.getlnInt();
            if (adresId == 0) {
                facturenmenu();
            }
        } while (!controller.existsAdresId(adresId));
        List<Factuur> zoekresultaat = factuurController.findFactuurByAdresId(adresId);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Factuur factuur : zoekresultaat) {
            System.out.println(factuur);
            }
        }
        facturenmenu();
    }
    
    public  void facturenmenuZoKid() {
        System.out.println("U gaat een factuur zoeken op klant id");
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.println("Vul het nieuwe klantId in en druk op enter. Vul 0 in als u wilt annuleren.");
            klantId = TextIO.getlnInt();
            if (klantId == 0) {
                facturenmenu();
            }
        } while (!controller.existsKlantId(klantId));
        List<Factuur> zoekresultaat = factuurController.findFactuurByKlantId(klantId);
        if (zoekresultaat.isEmpty()) {
            System.out.println("Geen zoekresultaten.");
        } else {
            for (Factuur factuur : zoekresultaat) {
            System.out.println(factuur);
            }
        }
        facturenmenu();
    }
    
    public  void facturenmenuZoId() {
        System.out.println("U gaat een factuur zoeken op factuur id");
        System.out.println("Vul het factuur id in en druk op enter.");
        int factuurId = TextIO.getlnInt();
        Factuur zoekresultaat = factuurController.findFactuurById(factuurId);
        if (zoekresultaat.getFactuurId() == 0) {
            System.out.println("Geen zoekresultaten.");
        } else {
            System.out.println(zoekresultaat);            
        }
        facturenmenu();
    }
}
