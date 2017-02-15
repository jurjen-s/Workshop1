/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.util.List;

/**
 *
 * @author jurjen
 */
public class AdresMenu {
    
    private AdresController adresController = new AdresController();
    private Validator validator = new Validator();
    
    public  void  adressenmenu(){
   
        System.out.println("Welkom in het adressenmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("Doorzoek adressen");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek op adresID."); 
        System.out.println("2: Doorzoek op postcode.");
        System.out.println("3: Doorzoek op adrestype.");
        System.out.println("4: Doorzoek op klantIDadress.");
        System.out.println("5: Doorzoek op land");
        System.out.println("6: Adres toevoegen");
        System.out.println("7: verander type");
        System.out.println("8: verander straat");
        System.out.println("9: verander huisnummer");
        System.out.println("10: verander huisnummertoevoeging");
        System.out.println("11: verander postcode");
        System.out.println("12: verander land");
        System.out.println("13: Adres verwijderen");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");

        int keuze = TextIO.getlnInt();

        switch (keuze) {
                case 1:    System.out.println("1: Doorzoek op adresID."); adressenmenuDoAid(); break;
                case 2: System.out.println("2: Doorzoek op postcode.");adressenmenuDoPc(); break;
                case 3:  System.out.println("3: Doorzoek op adrestype.");adressenmenuDoT(); break;
                case 4: System.out.println("4: Doorzoek op klantIDadress.");adressenmenuDoK(); break;
                case 5: System.out.println("5: Doorzoek op land");adressenmenuDoL(); break;
                case 6: System.out.println("6: Adres toevoegen");adressenmenuTA(); break;
                case 7 :System.out.println("7: verander type");adressenmenuVT(); break;
                case 8: System.out.println("8: verander straat");adressenmenuVS(); break;
                case 9:  System.out.println("9: verander huisnummer");adressenmenuVHnr(); break;
                case 10: System.out.println("10: verander huisnummertoevoeging");adressenmenuVHnrT(); break;
                case 11: System.out.println("11: verander postcode");adressenmenuVPC(); break;
                case 12: System.out.println("12: verander land");adressenmenuVL(); break;
                case 13:System.out.println("13: Adres verwijderen");adressenmenu(); break;
                case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
                default: System.out.println("Verkeerde invoer."); adressenmenu();
        }
    }                    
 
    public  void adressenmenuDoAid(){
        System.out.println("U gaat een adres zoeken op ID.");
        System.out.println("Vul ID in en druk op enter.");
        int adresId = TextIO.getlnInt();
        System.out.println(adresController.findAdresById(adresId).toString());
        adressenmenu();
    }
    
    public  void adressenmenuDoPc(){
        System.out.println("U gaat een adres zoeken op postcode.");
        String postcode = "";
        do {
            System.out.println("Wat is de postcode? Geef in het formaat \'1234 AZ\'.");
            postcode = TextIO.getln();
            if (validator.validatePostcode(postcode)) {
                break;
            }  
        } while (true);
        List<Adres> zoekresultaat = adresController.findAdresByPostcode(postcode);
        for (Adres adres:zoekresultaat) {
            adres.toString();
        }
        adressenmenu();
    }
    
    public  void adressenmenuDoT(){
        System.out.println("U gaat een adres zoeken op type.");
        System.out.println("Vul het type in en druk op enter.");
        int type = TextIO.getlnInt();
        List<Adres> zoekresultaat = adresController.findAdresByType(type);
            for (Adres adres:zoekresultaat) {
                adres.toString();
            }
        adressenmenu();
    }
    
    public  void adressenmenuDoK(){
        System.out.println("U gaat een adres zoeken op klantid.");
        System.out.println("Vul de adress klant id in en druk op enter.");
        int klantId = TextIO.getlnInt();
        List<Adres> zoekresultaat = adresController.findAdresByKlantId(klantId);
                for (Adres adres:zoekresultaat) {
                    adres.toString();
                }
            adressenmenu();
        adressenmenu();
    }
    
    public  void adressenmenuDoL(){
        System.out.println("U gaat een adres zoeken op Land.");
        System.out.println("Vul het Land in en druk op enter.");
        String land = TextIO.getln();
        List<Adres> zoekresultaat = adresController.findAdresByLand(land);
                for (Adres adres:zoekresultaat) {
                    adres.toString();
                }
            adressenmenu();
        adressenmenu();
    }
    public  void adressenmenuTA(){
        System.out.println("U gaat een adres toevoegen.");
        System.out.println("Vul het adres type toe");
        int adresType = TextIO.getlnInt();
        System.out.println("Vul het AdressklantenID toe");
        int klantId = TextIO.getlnInt();
        System.out.println("Vul het straatnaam toe");
        String straatnaam = TextIO.getln();
        System.out.println("Vul het huisnummer toe");
        String huisnummer = TextIO.getln();
        System.out.println("Heeft het een huisnummertoevoeging? 1 = ja, 0 = nee");
        boolean heeftHuisnrToevoeging = TextIO.getlnBoolean();
        String huisnrToevoeging = "";
        if (heeftHuisnrToevoeging) {
            System.out.println("Vul het huisnummer toevoeging toe");
            huisnrToevoeging = TextIO.getln();
        }
        String postcode = "";        
        do {
            System.out.println("Vul de postcode in. Geef in het formaat \'1234 AZ\'.");
            postcode = TextIO.getln();
            if (validator.validatePostcode(postcode)) {
                break;
            }  
        } while (true);
        System.out.println("Vul het Land in en druk op enter.");
        String land = TextIO.getln();
        // Maak adres met de opgegeven waardes
        Adres adres = new Adres.AdresBuilder()
                               .adresType(adresType)
                               .klantId(klantId)
                               .straatnaam(straatnaam)
                               .huisnummer(klantId)
                               .heeftHuisnrToevoeging(heeftHuisnrToevoeging)
                               .huisnrToevoeging(huisnrToevoeging)
                               .postcode(postcode)
                               .land(land)
                               .build();
        System.out.println(adresController.toevoegenAdres(adres).toString());
        adressenmenu();
    }

    public  void adressenmenuVT(){
        System.out.println("U gaat een adres type veranderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        System.out.println("vul de nieuwe type (0 of 1) in en druk op enter");
        int adresType = TextIO.getlnInt();
        if (adresController.updateAdresType(adresId,adresType) == true) {
            System.out.println("Het updaten is gelukt.");
        } else {
            System.out.println("het updaten is mislukt.");
        }
        adressenmenu();
    }
    
    public  void adressenmenuVS(){
    System.out.println("U gaat een adres straatnaam veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");
    int adresId = TextIO.getlnInt();
    System.out.println("vul de nieuwe straatnaam (string) in en druk op enter");
    String straatnaam = TextIO.getln();
    if (adresController.updateAdresStraatnaam(adresId,straatnaam) == true) {
            System.out.println("Het updaten is gelukt.");
        } else {
            System.out.println("het updaten is mislukt.");
        }
    adressenmenu();
    }

    public  void adressenmenuVHnr(){
        System.out.println("U gaat een adres huisnummer veranderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        System.out.println("vul het nieuwe huisnummer in en druk op enter");
        int huisnummer = TextIO.getlnInt();
        if (adresController.updateAdresHuisnummer(adresId,huisnummer) == true) {
                System.out.println("Het updaten is gelukt.");
            } else {
                System.out.println("het updaten is mislukt.");
            }
        adressenmenu();
    }
    
    public  void adressenmenuVHnrT(){
        System.out.println("U gaat een adres huisnummer toevoeging veranderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        System.out.println("vul de nieuwe toevoeging in en druk op enter");
        String huisnummerToevoeging = TextIO.getln();
        if (adresController.updateAdresHuisnrToevoeging(adresId,huisnummerToevoeging) == true) {
                System.out.println("Het updaten is gelukt.");
            } else {
                System.out.println("het updaten is mislukt.");
            }
        adressenmenu();
    }
    
    public  void adressenmenuVPC(){
        System.out.println("U gaat een adres postcode veranderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        String postcode = "";
        do {
            System.out.println("Vul de postcode in. Geef in het formaat \'1234 AZ\'.");
            postcode = TextIO.getln();
            if (validator.validatePostcode(postcode)) {
                break;
            }  
        } while (true);
        if (adresController.updateAdresPostcode(adresId, postcode) == true) {
                System.out.println("Het updaten is gelukt.");
            } else {
                System.out.println("het updaten is mislukt.");
            }
        adressenmenu();
    }
    
    public  void adressenmenuVL(){
        System.out.println("U gaat een adres Land veranderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        System.out.println("vul de nieuwe Land (string) in en druk op enter");
        String land = TextIO.getln();
        if (adresController.updateAdresLand(adresId,land) == true) {
                System.out.println("Het updaten is gelukt.");
            } else {
                System.out.println("het updaten is mislukt.");
            }
        adressenmenu();
    }
    
    public  void adressenmenuDELETE(){
        System.out.println("U gaat een adres verwijderen.");
        System.out.println("Vul het adres id in en druk op enter.");
        int adresId = TextIO.getlnInt();
        if (adresController.deleteAdres(adresId) == true) {
            System.out.println("Het updaten is gelukt.");
        } else {
            System.out.println("het updaten is mislukt.");
        }
        adressenmenu();
    }
}
