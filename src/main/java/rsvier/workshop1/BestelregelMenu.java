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
    
    private BestelregelController bestelregelController = new BestelregelController();
    
    public  void bestelregelmenu(){
    
        System.out.println("Welkom in het bestelregelmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("opties productregel");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek productregel met id.");
        System.out.println("2: Doorzoek productregel met bestelling id.");
        System.out.println("3: Doorzoek productregel met producten id ."); 
        System.out.println("4: Doorzoek productregel met hoeveelheid.");
        System.out.println("5: Toevoegen productregel.");
        System.out.println("6: Verander bestelling id mbv productregel id.");
        System.out.println("7: Verander producten id mbv productregel id.");
        System.out.println("8: Verander hoeveelheid mbv productregel id");
        System.out.println("9: VERWIJDER productregel met id.");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");
        
        int keuze = TextIO.getlnInt();

        switch (keuze) {
                case 1: System.out.println("1: Doorzoek productregel met id."); bestelregelmenuZoID(); break;
                case 2: System.out.println("2: Doorzoek productregel met bestelling id."); bestelregelmenuZoBid(); break;
                case 3: System.out.println("3: Doorzoek productregel met producten id ."); bestelregelmenuZoPid(); break;
                case 4: System.out.println("4: Doorzoek productregel met hoeveelheid."); bestelregelmenuZoH(); break;
                case 5: System.out.println("5: Toevoegen productregel."); bestelregelmenuT(); break;
                case 6: System.out.println("6: Verander bestelling id mbv productregel id."); bestelregelmenuVBid(); break;
                case 7: System.out.println("7: Verander producten id mbv productregel id."); bestelregelmenuVPid(); break;
                case 8: System.out.println("8: Verander hoeveelheid mbv productregel id"); bestelregelmenuVH(); break;
                case 9: System.out.println("9: VERWIJDER productregel met id."); bestelregelmenuDELETE(); break;
                case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
                default: System.out.println("Verkeerde invoer."); bestelregelmenu();
        }
    }

    public  void bestelregelmenuZoID(){
        System.out.println("U gaat een bestelregel zoeken op bestelregel ID.");
        System.out.println("Vul ID in en druk op enter.");
        int bestelregelId = TextIO.getlnInt();
        (bestelregelController.findBestelregelById(bestelregelId)).toString();
        bestelregelmenu();    
    }
    
    public  void bestelregelmenuZoBid(){
        System.out.println("U gaat een bestelregel zoeken op bestelling ID.");
        System.out.println("Vul ID in en druk op enter.");
        int bestellingId = TextIO.getlnInt();
        (bestelregelController.findBestelregelByBestellingId(bestellingId)).toString();
        bestelregelmenu();
    }

    public  void bestelregelmenuZoPid(){
        System.out.println("U gaat een bestelregel zoeken op product ID.");
        System.out.println("Vul ID in en druk op enter.");
        int productId = TextIO.getlnInt();
        (bestelregelController.findBestelregelByProductId(productId)).toString();
        bestelregelmenu(); 
    }

    public  void bestelregelmenuZoH(){
        System.out.println("U gaat een bestelregel zoeken op hoeveelheid.");
        System.out.println("Vul ID in en druk op enter.");
        int hoeveelheid = TextIO.getlnInt();
        (bestelregelController.findBestelregelByHoeveelheid(hoeveelheid)).toString();
        bestelregelmenu();  
    }

    public  void bestelregelmenuT(){

        System.out.println("U gaat een bestelregel toevoegen.");
        System.out.println("Vul de bestelling id  in en druk op enter.");
        int bestellingId = TextIO.getlnInt();
        System.out.println("Vul het producten id en druk op enter");
        int productId = TextIO.getlnInt();
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

    public  void bestelregelmenuVBid(){
        System.out.println("U gaat het bestelling id van bestelregel id veranderen.");
        System.out.println("Vul bestelregel id in druk enter.");
        int bestelregelId = TextIO.getlnInt();
        System.out.println("Vul bestelling id in druk enter.");
        int bestellingId = TextIO.getlnInt();
        if (bestelregelController.updateBestelregelBestellingId(bestelregelId,bestellingId) == true) {
            System.out.println("Het updaten is gelukt.");
        } else {
            System.out.println("Het updaten is mislukt.");
        }
        bestelregelmenu(); 
    }
    
    public  void bestelregelmenuVPid(){
       System.out.println("U gaat het product id van bestelregel id veranderen.");
       System.out.println("Vul bestelregel id in druk enter.");
       int bestelregelId = TextIO.getlnInt();
       System.out.println("Vul product id in druk enter.");
       int productId = TextIO.getlnInt();
       if (bestelregelController.updateBestelregelProductId(bestelregelId,productId) == true) {
           System.out.println("Het updaten is gelukt.");
       } else {
           System.out.println("Het updaten is mislukt.");
       }
       bestelregelmenu();   
    }

    public  void bestelregelmenuVH(){
        System.out.println("U gaat de hoeveelheid van bestelregel id veranderen.");
        System.out.println("Vul bestelregel id in druk enter.");
        int bestelregelId = TextIO.getlnInt();
        System.out.println("Vul de hoeveelheid in druk enter.");
        int hoeveelheid = TextIO.getlnInt();
        if (bestelregelController.updateBestelregelHoeveelheid(bestelregelId,hoeveelheid) == true) {
           System.out.println("Het updaten is gelukt.");
        } else {
           System.out.println("Het updaten is mislukt.");
        }
        bestelregelmenu(); 
    }
    
    public  void bestelregelmenuDELETE() {
        System.out.println("U gaat een productregel verwijderen");
        System.out.println("Vul productregel id in druk enter, druk 0 als u het niet wilt.");
        int productregelId = TextIO.getlnInt();
        if (productregelId == 0) {
            Menu menu = new Menu();
            menu.hoofdmenu();
        }
        if (bestelregelController.deleteBestelregel(productregelId) == true) {
           System.out.println("Het verwijderen is gelukt.");
        } else {
           System.out.println("Het verwijderen is mislukt.");
        }
        bestelregelmenu();
    }
}
