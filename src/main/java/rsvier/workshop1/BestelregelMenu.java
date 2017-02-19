/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

/**
 *
 * @author jurjen
 */
public class BestelregelMenu {
    
    private Controller controller = new Controller();
    private BestelregelController bestelregelController = new BestelregelController();
    
    public  void bestelregelmenu(){
        System.out.println("Welkom in het bestelregelmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek bestelregel met id.");
        System.out.println("2: Doorzoek bestelregel met bestelling id.");
        System.out.println("3: Doorzoek bestelregel met producten id ."); 
        System.out.println("4: Doorzoek bestelregel met hoeveelheid.");
        System.out.println("5: Toevoegen bestelregel.");
        System.out.println("6: Verander bestelling id mbv bestelregel id.");
        System.out.println("7: Verander producten id mbv bestelregel id.");
        System.out.println("8: Verander hoeveelheid mbv bestelregel id");
        System.out.println("9: VERWIJDER bestelregel met id.");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
                case 1: System.out.println("1: Doorzoek bestelregel met id."); bestelregelmenuZoID(); break;
                case 2: System.out.println("2: Doorzoek bestelregel met bestelling id."); bestelregelmenuZoBid(); break;
                case 3: System.out.println("3: Doorzoek bestelregel met producten id ."); bestelregelmenuZoPid(); break;
                case 4: System.out.println("4: Doorzoek bestelregel met hoeveelheid."); bestelregelmenuZoH(); break;
                case 5: System.out.println("5: Toevoegen bestelregel."); bestelregelmenuT(); break;
                case 6: System.out.println("6: Verander bestelling id mbv bestelregel id."); bestelregelmenuVBid(); break;
                case 7: System.out.println("7: Verander producten id mbv bestelregel id."); bestelregelmenuVPid(); break;
                case 8: System.out.println("8: Verander hoeveelheid mbv bestelregel id"); bestelregelmenuVH(); break;
                case 9: System.out.println("9: VERWIJDER bestelregel met id."); bestelregelmenuDELETE(); break;
                case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
                default: System.out.println("Verkeerde invoer."); bestelregelmenu();
        }
    }

    public void bestelregelmenuZoID(){
        System.out.println("U gaat een bestelregel zoeken op bestelregelId.");
        System.out.println("Vul het bestelregelId in en druk op enter.");
        int bestelregelId = TextIO.getlnInt();
        Bestelregel zoekresultaat = bestelregelController.findBestelregelById(bestelregelId);
        if (zoekresultaat.getBestelregelId() == 0) {
            System.out.println("Er is geen bestelregel met het opgegeven bestelregelId gevonden.");
        } else {
            System.out.println(zoekresultaat);
        }
        bestelregelmenu();    
    }
    
    public void bestelregelmenuZoBid(){
        System.out.println("U gaat een bestelregel zoeken op bestellingId.");
        System.out.println("Vul het bestellingId in en druk op enter.");
        int bestellingId = TextIO.getlnInt();
        Bestelregel zoekresultaat = bestelregelController.findBestelregelByBestellingId(bestellingId);
        if (zoekresultaat.getBestellingId() == 0) {
            System.out.println("Er is geen bestelregel met het opgegeven bestellingId gevonden.");
        } else {
            System.out.println(zoekresultaat);
        }
        bestelregelmenu();
    }

    public void bestelregelmenuZoPid(){
        System.out.println("U gaat een bestelregel zoeken op productId.");
        System.out.println("Vul het productId in en druk op enter.");
        int productId = TextIO.getlnInt();
        Bestelregel zoekresultaat = bestelregelController.findBestelregelByProductId(productId);
        if (zoekresultaat.getProductId() == 0) {
            System.out.println("Er is geen bestelregel met het opgegeven productId gevonden.");
        } else {
            System.out.println(zoekresultaat);
        }
        bestelregelmenu(); 
    }

    public void bestelregelmenuZoH(){
        System.out.println("U gaat een bestelregel zoeken op hoeveelheid.");
        System.out.println("Vul de hoeveelheid in en druk op enter.");
        int hoeveelheid = TextIO.getlnInt();
        Bestelregel zoekresultaat = bestelregelController.findBestelregelByHoeveelheid(hoeveelheid);
        if (zoekresultaat.getBestelregelId() == 0) {
            System.out.println("Er is geen bestelregel met de opgegeven hoeveelheid gevonden.");
        } else {
            System.out.println(zoekresultaat);
        }
        bestelregelmenu();  
    }

    public void bestelregelmenuT(){
        System.out.println("U gaat een bestelregel toevoegen.");
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul het bestellingId in waar u de bestelregel aan wilt toevoegen en druk op enter. \nVul 0 in om te annuleren.");
            bestellingId = TextIO.getlnInt();
            if (bestellingId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestellingId(bestellingId));
        //Controleren op FK constraints
        int productId = -1;
        do {
            System.out.println("Vul het productId in en druk op enter.");
            productId = TextIO.getlnInt();
        } while (!controller.existsProductId(productId));   
        System.out.println("Vul de hoeveelheid van dit product in en druk op enter");
        int hoeveelheid = TextIO.getlnInt();
        Bestelregel bestelregel = new Bestelregel.BestelregelBuilder()
                                                 .bestellingId(bestellingId)
                                                 .productId(productId)
                                                 .hoeveelheid(hoeveelheid)
                                                 .build();
        bestelregelController.toevoegenBestelregel(bestelregel);
        bestelregelmenu();
    }

    public void bestelregelmenuVBid(){
        System.out.println("U gaat het bestellingId van een bestelregel veranderen.");
        //Controleren op FK constraints
        int bestelregelId = -1;
        do {
            System.out.println("Vul het bestelregelId in en druk op enter. Vul 0 in om te annuleren.");
            bestelregelId = TextIO.getlnInt();
            if (bestelregelId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestelregelId(bestelregelId));   
        //Controleren op FK constraints
        int bestellingId = -1;
        do {
            System.out.println("Vul het bestellingId in en druk op enter. Vul 0 in om te annuleren.");
            bestellingId = TextIO.getlnInt();
            if (bestellingId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestellingId(bestellingId));
        if (bestelregelController.updateBestelregelBestellingId(bestelregelId,bestellingId) == true) {
            System.out.println("Het updaten is gelukt.");
        } else {
            System.out.println("Het updaten is mislukt.");
        }
        bestelregelmenu(); 
    }
    
    public void bestelregelmenuVPid(){
        System.out.println("U gaat het productId van een bestelregel veranderen.");
        //Controleren op FK constraints
        int bestelregelId = -1;
        do {
            System.out.println("Vul het bestelregelId in en druk op enter. Vul 0 in om te annuleren.");
            bestelregelId = TextIO.getlnInt();
            if (bestelregelId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestelregelId(bestelregelId));   
       //Controleren op FK constraints
        int productId = -1;
        do {
            System.out.println("Vul het productId in en druk op enter. Vul 0 in om te annuleren.");
            productId = TextIO.getlnInt();
            if (productId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsProductId(productId));   
       if (bestelregelController.updateBestelregelProductId(bestelregelId,productId) == true) {
           System.out.println("Het updaten is gelukt.");
       } else {
           System.out.println("Het updaten is mislukt.");
       }
       bestelregelmenu();   
    }

    public void bestelregelmenuVH(){
        System.out.println("U gaat de producthoeveelheid van een bestelregel veranderen.");
        //Controleren op FK constraints
        int bestelregelId = -1;
        do {
            System.out.println("Vul het bestelregelId in en druk op enter. Vul 0 in om te annuleren.");
            bestelregelId = TextIO.getlnInt();
            if (bestelregelId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestelregelId(bestelregelId));   
        System.out.println("Vul de producthoeveelheid in druk enter.");
        int hoeveelheid = TextIO.getlnInt();
        if (bestelregelController.updateBestelregelHoeveelheid(bestelregelId,hoeveelheid) == true) {
           System.out.println("Het updaten is gelukt.");
        } else {
           System.out.println("Het updaten is mislukt.");
        }
        bestelregelmenu(); 
    }
    
    public void bestelregelmenuDELETE() {
        System.out.println("U gaat een bestelregel verwijderen.");
        //Controleren op FK constraints
        int bestelregelId = -1;
        do {
            System.out.println("Vul het bestelregelId in en druk op enter. Vul 0 in als u wilt annuleren.");
            bestelregelId = TextIO.getlnInt();
            if (bestelregelId == 0) {
                bestelregelmenu();
            }
        } while (!controller.existsBestelregelId(bestelregelId));   
        if (bestelregelController.deleteBestelregel(bestelregelId) == true) {
           System.out.println("Het verwijderen is gelukt.");
        } else {
           System.out.println("Het verwijderen is mislukt.");
        }
        bestelregelmenu();
    }
}
