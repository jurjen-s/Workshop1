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
public class AdresMenu {
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

                    {
                
               
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
                             }
                        }
 


    public  void adressenmenuDoAid(){

    System.out.println("U gaat een adres zoeken op ID.");
    System.out.println("Vul ID in en druk op enter.");

    int adresId = TextIO.getlnInt();
    //Controller.findAdresById(adresId);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuDoPc(){

    System.out.println("U gaat een adres zoeken op postcode.");
    System.out.println("Vul het postcode ###### (1111AA) in en druk op enter.");

    String adresPC = TextIO.getln();
    //Controller.findAdresByPostcode(adresPC);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuDoT(){

    System.out.println("U gaat een adres zoeken op type.");
    System.out.println("Vul het type in en druk op enter.");

    int type = TextIO.getlnInt();
    //Controller.findAdresByStraat(adresStraat);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuDoK(){

    System.out.println("U gaat een adres zoeken op klantid.");
    System.out.println("Vul de adress klant id in en druk op enter.");

    int AKid = TextIO.getlnInt();
    //Controller.findAdresByAdresKlantid(Akid);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuDoL(){

    System.out.println("U gaat een adres zoeken op Land.");
    System.out.println("Vul het Land in en druk op enter.");

    String land = TextIO.getln();
    //Controller.findAdresByLand(land);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuTA(){

    System.out.println("U gaat een adres toevoegen.");
    System.out.println("Vul het adres type toe");

    int AT = TextIO.getlnInt();

    System.out.println("Vul het AdressklantenID toe");

    int AKid = TextIO.getlnInt();

    System.out.println("Vul het straatnaam toe");

    String Astraat = TextIO.getln();

    System.out.println("Vul het huisnummer toe");

    String AHuisnr = TextIO.getln();

    System.out.println("Heeft het een huisnummertoevoeging? 1 = ja, 0 = nee");

    int AstraatHT = TextIO.getlnInt();


    System.out.println("Vul het huisnummer toevoeging toe, niks is enter");

    String AstraatT = TextIO.getln();

    System.out.println("Vul de postcode in en druk op enter.");

    String PC = TextIO.getln();


    System.out.println("Vul het Land in en druk op enter.");

    String land = TextIO.getln();



    //Controller..

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }

    public  void adressenmenuVT(){

    System.out.println("U gaat een adres typen veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe type (0 of 1) in en druk op enter");

    int AT = TextIO.getlnInt();

    //Controller.UpdateAdresByType(Aid,AT);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuVS(){

    System.out.println("U gaat een adres straatnaam veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe straatnaam (string) in en druk op enter");

    String AS = TextIO.getln();

    //Controller.UpdateAdresByStraat(Aid,AS);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }

    public  void adressenmenuVHnr(){

    System.out.println("U gaat een adres huisnummer veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe straatnaam (string) in en druk op enter");

    int AHnr = TextIO.getlnInt();

    //Controller.UpdateAdresByStraat(Aid,AS);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuVHnrT(){

    System.out.println("U gaat een adres straatnaam veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe straatnaam (string) in en druk op enter");

    String AHnrT = TextIO.getln();
    // int AHnrT = TextIO.getlnInt();


    //Controller.UpdateAdresByStraat(Aid,AHnrT);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuVPC(){

    System.out.println("U gaat een adres postcode veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe postcode (string) in en druk op enter");

    //String PC = TextIO.getln();
    //int AHnrT = TextIO.getlnInt();


    //Controller.UpdateAdresByStraat(Aid,PC);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuVL(){

    System.out.println("U gaat een adres Land veranderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    System.out.println("vul de nieuwe Land (string) in en druk op enter");

    String Land = TextIO.getln();
    //int AHnrT = TextIO.getlnInt();


    //Controller.UpdateAdresByLand(Aid,Land);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
    public  void adressenmenuDELETE(){

    System.out.println("U gaat een adres verwijderen.");
    System.out.println("Vul het adres id in en druk op enter.");

    int Aid = TextIO.getlnInt();

    //System.out.println("vul de nieuwe Land (string) in en druk op enter");

    //String Land = TextIO.getln();
    //int AHnrT = TextIO.getlnInt();


    //Controller.DELETEAdres(Aid);

    System.out.println("de controller klasse is nog niet af.");
    adressenmenu();
    }
}
