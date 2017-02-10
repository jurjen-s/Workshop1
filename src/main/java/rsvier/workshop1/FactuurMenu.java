/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author jurjen
 */
public class FactuurMenu {
    
    private FactuurController factuurController = new FactuurController();
    
    public  void facturenmenu(){

        System.out.println("Welkom in het facturenmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("opties facturen");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek facturen met id.");
        System.out.println("2: Doorzoek facturen met klant id.");
        System.out.println("3: Doorzoek facturen met adress id ."); 
        System.out.println("4: Doorzoek facturen met bestelling id.");
        System.out.println("5: Doorzoek facturen met totaal prijs.");
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
            case 7:  System.out.println("6: Toevoegen factuur."); facturenmenuFT(); break;              
            case 8:  System.out.println("7: Zet status factuur op betaald."); facturenmenuVS(); break;
            case 9: System.out.println("8: VERWIJDER factuur met id."); facturenmenuDELETE(); break;
            case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
            default: System.out.println("Verkeerde invoer."); facturenmenu();
        }
    }

    public void facturenmenuZoS() {
        System.out.println("U wilt facturen op status doorzoeken.");
        System.out.println("Op welke status (0: onbetaald, 1: betaald) wilt u zoeken?");
        int status = TextIO.getlnInt();
        List<Factuur> zoekresultaat = factuurController.findFactuurByStatus(status);
        for (Factuur factuur:zoekresultaat) {
            factuur.toString();
        }
    }
    
    public  void facturenmenuDELETE() {
        System.out.println("U gaat een factuur verwijderen");
        System.out.println("Vul factuurid in druk enter, druk 0 als u het niet wilt.");
        int factuurId = TextIO.getlnInt();
        if (factuurId == 0) {
            Menu menu = new Menu();
            menu.hoofdmenu();
        }
        if (factuurController.deleteFactuur(factuurId) == true) {
            System.out.println("Het verwijderen is gelukt.");
        } else {
            System.out.println("Het verwijderen is mislukt.");
        }
        facturenmenu();
    }
    
    /*
    
    Dit is komen te vervallen dan, aangezien we niet willen dat facturen te wijzigen zijn.
    
    public  void facturenmenuVtp() {

    System.out.println("U gaat het totaale prijs van factuur id veranderen.");


    System.out.println("Vul factuurid in druk enter.");

    int Fid = TextIO.getlnInt();




    System.out.println("Vul het totale prijs in  en dan enter.");
    // System.out.println("Vul hierna de omschrijving in en druk enter.");


    int KiD = TextIO.getlnInt();

    BigDecimal fTotaalprijs = new BigDecimal(TextIO.getln());
    // String pOmschrijving = TextIO.getln();



    //Controller.updatefacturentotaalprijs(Fid,fTotaalprijs);

    System.out.println("de controller klasse is nog niet af.");
    facturenmenu();




    }
    public  void facturenmenuVkId() {
    System.out.println("U gaat het klant id van factuur id veranderen.");



    System.out.println("Vul factuurid in druk enter.");

    int fiD = TextIO.getlnInt();

    System.out.println("Vul klant id in druk enter.");

    int Kid = TextIO.getlnInt();



    //Controller.updatefacturenklantid(Fid,Kid);

    System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }
    public  void facturenmenuVaId() {
    System.out.println("U gaat het adres id van factuur id veranderen.");



    System.out.println("Vul factuurid in druk enter.");

    int fiD = TextIO.getlnInt();

    System.out.println("Vul Adres id in druk enter.");

    int Aid = TextIO.getlnInt();








    //Controller.updatefacturenadressid(Fid,Aid);

    System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }

*/
    
    public  void facturenmenuVS() {
        System.out.println("Welke factuur wilt u de status betaald geven?.");
        System.out.println("Geef het factuurID en druk op enter.");
        int factuurId = TextIO.getlnInt();
        if (factuurController.betaalFactuur(factuurId) == true) {
            System.out.println("Het veranderen van de status is gelukt.");
        } else {
            System.out.println("Het veranderen van de status is mislukt.");
        }
        facturenmenu();
    }

    
    public  void facturenmenuFT() {
        System.out.println("U gaat een factuur toevoegen.");
        System.out.println("Vul de klant id  in en druk op enter.");
        int klantId = TextIO.getlnInt();
        System.out.println("Vul het bestelling id en druk op enter");
        int bestellingId = TextIO.getlnInt();
        System.out.println("Vul adres id in en druk op enter");
        int adresId = TextIO.getlnInt();
        System.out.println("Vul het totaal prijs in de voorraad en druk op enter");
        BigDecimal totaalprijs = new BigDecimal(TextIO.getln());
        System.out.println("Vul de status (0: open, 1: betaald) in en druk op enter");
        int statusInt = TextIO.getlnInt();
        boolean status = false;
        if (statusInt == 0) {
            status = false;
        } else if (statusInt == 1) {
            status = true;
        }
        Factuur factuur = new Factuur.FactuurBuilder()
                                     .klantId(klantId)
                                     .bestellingId(bestellingId)
                                     .adresId(adresId)
                                     .status(status)
                                     .build();
        if (factuurController.maakFactuur(factuur) == true) {
            System.out.println("Het aanmaken van de factuur is gelukt.");
        } else {
            System.out.println("Het aanmaken van de factuur is mislukt.");
        }
        facturenmenu();
    }
    
    public  void facturenmenuZoTP() {
        System.out.println("U gaat een factuur zoeken mbv totaal prijs");
        System.out.println("Vul totaal prijs in en druk op enter.");
        BigDecimal totaalprijs = new BigDecimal(TextIO.getln());
        List<Factuur> zoekresultaat = factuurController.findFactuurByTotaalprijs(totaalprijs);
        for (Factuur factuur:zoekresultaat) {
            factuur.toString();
        }
        facturenmenu();
    }
    
    public  void facturenmenuZoBid() {
        System.out.println("U gaat een factuur zoeken mbv bestelling id");
        System.out.println("Vul een bestelling id (int) in en druk op enter.");
        int bestellingId = TextIO.getlnInt();
        (factuurController.findFactuurByBestellingId(bestellingId)).toString();
        facturenmenu();
    }
    
    public  void facturenmenuZoAid() {
        System.out.println("U gaat een factuur zoeken mbv adress id");
        System.out.println("Vul adress id (int) in en druk op enter.");
        int adresId = TextIO.getlnInt();
        (factuurController.findFactuurByAdresId(adresId)).toString();
        facturenmenu();
    }
    
    public  void facturenmenuZoKid() {
        System.out.println("U gaat een factuur zoeken mbv klanten id");
        System.out.println("Vul klant id (int) in en druk op enter.");
        int klantId = TextIO.getlnInt();
        (factuurController.findFactuurByKlantId(klantId)).toString();
        facturenmenu();
    }
    
    public  void facturenmenuZoId() {
        System.out.println("U gaat een factuur zoeken mbv  id");
        System.out.println("Vul factuur id (int) in en druk op enter.");
        int factuurId = TextIO.getlnInt();
        (factuurController.findFactuurById(factuurId)).toString();
        facturenmenu();
    }
    
}
