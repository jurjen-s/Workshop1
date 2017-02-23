/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package rsvier.workshop1;
import rsvier.workshop1.util.TextIO;
import rsvier.workshop1.product.ProductMenu;
import rsvier.workshop1.product.Product;
import rsvier.workshop1.medewerker.MedewerkerMenu;
import rsvier.workshop1.klant.KlantMenu;
import rsvier.workshop1.factuur.FactuurMenu;
import rsvier.workshop1.bestelregel.BestelregelMenu;
import rsvier.workshop1.bestelling.BestellingMenu;
import rsvier.workshop1.adres.AdresMenu;
import rsvier.workshop1.account.AccountMenu;
import java.util.Scanner;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import rsvier.workshop1.db.InstellingenMenu;


/**
 *
 * @author Frank
 */
public class Menu  {
   
    
   
    
    
    
    

    
    public void hoofdmenu(){

     Scanner input = new Scanner(System.in);   
   
int cijfer = 100;     
System.out.println("Welkom in het hoofdmenu van Kaas Manager 2017");
System.out.println("Wat wilt u doen?");
System.out.println("=========================");
        System.out.println(" 1 Producten menu");  
        System.out.println(" 2 Klanten menu  "); 
        System.out.println(" 3 Adres gegevens menu  "); 
        System.out.println(" 4 Bestelling menu  ");  
        System.out.println(" 5 Medewerkers menu"); 
        System.out.println(" 6 Accounts gegevens menu ");    
        System.out.println(" 7 Factuur gegevens menu ");  
        System.out.println(" 8 Bestelregel menu ");
        System.out.println(" 9 Instellingen menu ");
        System.out.println(" 0: Stoppen");
        System.out.println("=========================");
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");



cijfer = input.nextInt();
if (cijfer == 0){ System.out.println("Einde"); System.exit(0); }
else if (cijfer <= 9 && cijfer >0){
    switch (cijfer){
        case 1: System.out.println(" 1 Producten menu ");  ProductMenu productmenu = new ProductMenu(); productmenu.productmenu(); break;
        case 2: System.out.println(" 2 Klanten menu "); KlantMenu klantmenu = new KlantMenu(); klantmenu.klantenmenu();   break;
        case 3: System.out.println(" 3 Adres gegevens menu ");  AdresMenu adresmenu = new AdresMenu(); adresmenu.adressenmenu(); break;
        case 4: System.out.println(" 4 Bestelling menu ");  BestellingMenu bestellingmenu = new BestellingMenu(); bestellingmenu.bestellingenmenu(); break;
        case 5: System.out.println(" 5 Medewerkers maken menu ");  MedewerkerMenu medewerkersmenu = new MedewerkerMenu(); medewerkersmenu.medewerkersmenu(); break;
        case 6: System.out.println(" 6 Accounts gegevens menu  ");  AccountMenu am = new AccountMenu(); am.accountsmenu(); break;
        case 7: System.out.println(" 7 Factuur gegevens menu ");   FactuurMenu factuurmenu = new FactuurMenu(); factuurmenu.facturenmenu(); break;
        case 8: System.out.println(" 8 Bestelling regel menu "); BestelregelMenu bestelregelmenu = new BestelregelMenu(); bestelregelmenu.bestelregelmenu(); break;
        case 9: System.out.println(" 9 Instellingen menu"); InstellingenMenu instellingenmenu = new InstellingenMenu(); instellingenmenu.instellingenmenu(); break;
     
    }
}

else{ System.out.println("foute cijfer waarde probeer opnieuw"); hoofdmenu(); }

    

}

    
   // alles hier onder wordt NIET gebruikt. 

public void  klantenmenu(){
   
  
System.out.println("Welkom in het klantenmenu ");
System.out.println("Wat wilt u doen?");

System.out.println(" 1: klant gegevens zoeken op klant id");
System.out.println(" 2: klant gegevens zoeken op klant voornaam");     
System.out.println(" 3: klant gegevens zoeken op klant achternaam");  
System.out.println(" 4: klant gegevens zoeken met volledige naam");
System.out.println(" 5: klant gegevens aanpassen");
System.out.println(" 6: klant gegevens zien");
System.out.println(" 7 Maak een klant");
System.out.println(" 8: klant verwijderen");
System.out.println(" 0: terug naar hoofdmenu");
        
       
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputklant = new Scanner(System.in); 
    
    int waarde = inputklant.nextInt();
if (waarde == 0){ hoofdmenu();}
else if(waarde <= 8 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1 Klant zoeken op klant id"); klantenmenuZoKid(); break;
                case 2: System.out.println(" 2 Klant zoeken op klant voornaam"); klantenmenuZoVN();    break;
                case 3: System.out.println(" 3 klant zoeken op klant achternaam");  klantenmenuZoAN(); break;
                case 4: System.out.println(" 4 klant zoeken op volledige naam");  klantenmenuZoN(); break;
                case 5: System.out.println(" 5 klant gegevens aanpassen");  klantenmenuV(); break;
                case 6: System.out.println(" 6 Laat klant zien");  klantenmenuShow(); break;
                case 7: System.out.println(" 7 Maak een klant"); klantenmenuT(); break;
                case 8: System.out.println(" 8 klant verwijderen");  klantenmenuDELETE(); break;
               
      
                             }
                        }
   
                     
else{ System.out.println("verkeerde waarde");
klantenmenu();

    }


}
public void klantenmenuZoKid(){
    
    System.out.println("U gaat een klant zoeken.");
    System.out.println("Vul ID in en druk op enter.");
    
    int productId = TextIO.getlnInt();
    
//Controller.findKlantById(productId);

System.out.println("de controller klasse is nog niet af.");
    klantenmenu();
}
public void klantenmenuZoVN(){
     System.out.println("U gaat een klant zoeken op voornaam.");
    System.out.println("Vul de voornaam in en druk op enter.");
    
    String VN = TextIO.getln();
    
//Controller.findBijVoornaam(VN);

System.out.println("de controller klasse is nog niet af.");
    klantenmenu();
}
public  void klantenmenuZoAN(){
     System.out.println("U gaat een klant zoeken op achternaam.");
    System.out.println("Vul de achternaam in en druk op enter.");
    
    String AN = TextIO.getln();
    
//Controller.findBijLasteName(AN);

System.out.println("de controller klasse is nog niet af.");
    klantenmenu();
}
public  void klantenmenuZoN(){
 System.out.println("U gaat een klant zoeken op naam.");
    System.out.println("Vul de voornaam in en druk op enter.");
    
    String VN = TextIO.getln();
    
    System.out.println("Vul de tussenvoegsel in en druk op enter.");
    
    String T = TextIO.getln();
    
    System.out.println("Vul de achternaam in en druk op enter.");
    
    String AN = TextIO.getln();
    
//Controller.findBijNaam(VN,T,AN);

System.out.println("de controller klasse is nog niet af.");
    klantenmenu();
}
public void klantenmenuV(){
    System.out.println("deze klantenDAO is nog niet goed");
    klantenmenu();
}
public void klantenmenuShow(){
     System.out.println("deze klantenDAO is nog niet goed");
    klantenmenu();
}
public  void klantenmenuT(){
    System.out.println(" Maak een klant, nog een slechte DAO");
    klantenmenu();
}
public void klantenmenuDELETE(){
    System.out.println("U gaat een klant verwijderen. (0 is annuleren)");
    
   
    
    System.out.println("Vul de klant id in en druk op enter.");
    
    int Kid = TextIO.getlnInt();
    
    if(Kid==0){klantenmenu();}
    else{
        //Controller.deleteklant(Kid);
        System.out.println("controller bestaat nog niet");
        klantenmenu();
    }
      
   
    
}



public void  productmenu(){
   
  
System.out.println("Welkom in het productmenu ");
System.out.println("Wat wilt u doen?");

         System.out.println("=========================");
         System.out.println("Doorzoek producten");
         System.out.println("-------------------------");
         System.out.println("1: Doorzoek op PRODUCT ID");
         System.out.println("2: Doorzoek op SOORT."); 
         System.out.println("3: Doorzoek op PRIJS.");
         System.out.println("4: Doorzoek op VOORRAAD.");
         System.out.println("5: Toevoegen PRODUCT.");
         System.out.println("6: Verander PRODUCT omschrijving met behulp van product id.");
         System.out.println("7: Verander SOORT product met behulp van product id.");
         System.out.println("8: Verander PRIJS product met behulp van product id.");
         System.out.println("9: Verander VOORRAAD product met behulp van product id.");
         System.out.println("10: VERWIJDER product met behulp van product id.");
         System.out.println("0: Terug naar hoofdmenu.");
         System.out.println("=========================");
         System.out.println("Geef uw keuze : ");
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputklant = new Scanner(System.in); 
    
    int w = inputklant.nextInt();
if (w == 0){ hoofdmenu();}
else if(w <= 10 && w >0 ){
    
            switch (w){
                case 1: System.out.println(" 1 Doorzoek op productID"); productmenuDoPi(); break;
                case 2: System.out.println(" 2 Doorzoek op SOORT"); productmenuDoS(); break;
                case 3: System.out.println(" 3 Doorzoek op PRIJS"); productmenuDoP();    break;
                case 4: System.out.println(" 4 Doorzoek op VOORRAAD");  productmenuDoV(); break;
                case 5: System.out.println(" 5 Toevoegen Product ");  productmenuTP(); break;
                case 6: System.out.println(" 6 Verander Product Omschrijving met behulp van product id"); productmenuVPO(); break;
                case 7: System.out.println(" 7 Verander Soort product met behulp van product id"); productmenuVPS(); break;
                case 8: System.out.println(" 8 Verander Prijs product met behulp van product id"); productmenuVPP() ;break;
                case 9: System.out.println(" 9 Verander Voorraad product met behulp van product id");productmenu() ; break;
                case 10: System.out.println(" 10 Verwijder product met behulp van product id"); productmenu() ; break;
                             }
                        }
   
                     
else{ System.out.println("verkeerde cijfer waarde");
klantenmenu();

    }

}


public  void productmenuDoPi(){
    
    System.out.println("U gaat een product zoeken op ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int productId = TextIO.getlnInt();
//Controller.findProductById(productId);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuDoS(){
    
    System.out.println("U gaat een product zoeken op Soort.");
    System.out.println("Vul Soort als tekst in en druk op enter.");
    
    String Soort = TextIO.getln();
//Controller.findProductBySoort(Soort);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuDoP(){
    
    System.out.println("U gaat een product zoeken op Prijs.");
    System.out.println("Vul prijs in en druk op enter.");
    
    BigDecimal pPrijs = new BigDecimal(TextIO.getln());
//Controller.findProductByPrijs(pPrijs);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuDoV(){
    
    System.out.println("U gaat een product zoeken op Voorraad.");
    System.out.println("Vul het voorraad in en druk op enter.");
    
    int pVoorraad = TextIO.getlnInt();
//Controller.findProductByVoorraad(pVoorraad);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuTP(){
    
    System.out.println("U gaat een product TOEVOEGEN.");
    
    System.out.println("Vul de omschrijving in en druk op enter.");
      String Tomschrijving = TextIO.getln();
    System.out.println("Vul het soort in en druk op enter");
      String Tsoort = TextIO.getln();
    System.out.println("Vult de prijs van dit product in en druk op enter");
      BigDecimal Tprijs = new BigDecimal(TextIO.getln());
    System.out.println("Vul het aantal in de voorraad en druk op enter");
      int Tvoorraad = TextIO.getlnInt();
   
   //maak product 
   
  Product nProduct = new Product.ProductBuilder().soort(Tsoort).omschrijving(Tomschrijving).prijs(Tprijs).voorraad(Tvoorraad).build();
  
  
   
//Controller.toevoegenProduct(Product nProduct);
System.out.println(nProduct.toString());
System.out.println("de controller klasse is nog niet af.");

productmenu();
    
}
public  void productmenuVPO(){
    
    System.out.println("U gaat een product omschrijving veranderen.");
    System.out.println("Vul het product id en dan enter.");
    System.out.println("Vul hierna de omschrijving in en druk enter.");
    
    
    int pID = TextIO.getlnInt();
    String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateProductOmschrijving(pID,pOmschrijving);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuVPS(){
    
    System.out.println("U gaat een product soort veranderen.");
    System.out.println("Vul het product id en dan enter.");
    System.out.println("Vul hierna het soort in en druk enter.");
    
    
    int pID = TextIO.getlnInt();
    String pSoort = TextIO.getln();
    
    
    
//Controller.updateProductSoort(pID,pSoort);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuVPP(){
    
    System.out.println("U gaat een product prijs veranderen.");
    System.out.println("Vul het product id en dan enter.");
    System.out.println("Vul hierna de nieuwe prijs in en druk enter.");
    
    
    int pID = TextIO.getlnInt();
    BigDecimal pPrijs = new BigDecimal(TextIO.getln());
    
    
    
//Controller.updateProductPrijs(pID,pPrijs);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuVPV(){
    
    System.out.println("U gaat een product voorraad veranderen.");
    System.out.println("Vul het product id en dan enter.");
    System.out.println("Vul hierna de nieuwe voorraad in en druk enter.");
    
    
    int pID = TextIO.getlnInt();
    int pVoorraad = TextIO.getlnInt();
    
    
    
//Controller.updateProductVoorraad(pID,pVoorraad);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}
public  void productmenuDELETE(){
    
    System.out.println("U gaat een product verwijderen.");
    System.out.println("Vul het product id en dan enter.");
   
    
    
    int pID = TextIO.getlnInt();
    
    
    
    
//Controller.verwijderenProduct(pID);

System.out.println("de controller klasse is nog niet af.");
    productmenu();
}





public  void  adressenmenu(){
   
  
System.out.println("Welkom in het adressenmenu ");
System.out.println("Wat wilt u doen?");

         System.out.println("=========================");
         System.out.println("Doorzoek adressen");
         System.out.println("-------------------------");
         System.out.println("1: Doorzoek op adressID."); 
         System.out.println("2: Doorzoek op postcode.");
         System.out.println("3: Doorzoek op straatnaam.");
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
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputadress = new Scanner(System.in); 
    
    int c = inputadress.nextInt();
if (c == 0){ hoofdmenu();}
else if(c <= 13 && c >0 ){
    
            switch (c){
                
               
                case 1:    System.out.println("1: Doorzoek op adressID."); adressenmenuDoAid(); break;
                case 2: System.out.println("2: Doorzoek op postcode.");adressenmenuDoPc(); break;
                case 3:  System.out.println("3: Doorzoek op straatnaam.");adressenmenuDoS(); break;
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
   
                     
else{ System.out.println("verkeerde cijfer waarde");
adressenmenu();

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
public  void adressenmenuDoS(){
    
    System.out.println("U gaat een adres zoeken op straatnaam.");
    System.out.println("Vul de straatnaam in en druk op enter.");
    
    String adresStraat = TextIO.getln();
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






public  void bestellingenmenu(){

System.out.println("Welkom in het bestellingenmenu ");
System.out.println("Wat wilt u doen?");

         System.out.println("=========================");
         System.out.println("Doorzoek producten");
         System.out.println("-------------------------");
         System.out.println("1: Doorzoek bestelling met id.");
         System.out.println("2: Doorzoek bestelling met klant id.");
         System.out.println("3: Doorzoek bestelling met adress ."); 
         System.out.println("4: Doorzoek bestelling met aantal artikelen.");
         System.out.println("5: Doorzoek bestelling met totaal prijs.");
         System.out.println("6: Toevoegen bestelling.");
         System.out.println("7: Verander bestelling klant id.");
         System.out.println("8: Verander bestelling adress id.");
         System.out.println("9: Verander bestelling aantal artikelen");
         System.out.println("10: Verander bestelling totaal prijs.");
         System.out.println("11: VERWIJDER bestelling met id.");
         System.out.println("0: Terug naar hoofdmenu.");
         System.out.println("=========================");
         System.out.println("Geef uw keuze : ");
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputklant = new Scanner(System.in); 
    
    int wa = inputklant.nextInt();
if (wa == 0){ hoofdmenu();}
else if(wa <= 11 && wa >0 ){
    
            switch (wa){
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
                             }
                        }
   
                     
else{ System.out.println("verkeerde cijfer waarde");
klantenmenu();

    }
}

public  void bestellingenmenuDbi(){
    
     System.out.println("U gaat een bestelling zoeken op bestelling ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int bestellingId = TextIO.getlnInt();
//Controller.findBestellingById(bestellingId);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}
public  void bestellingenmenuDbk(){
     System.out.println("U gaat een bestelling zoeken mbv klant ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int klantId = TextIO.getlnInt();
//Controller.findBestellingByKlant(klantId);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    

}
public  void bestellingenmenuDbA(){
    
     System.out.println("U gaat een bestelling zoeken op Adress id.");
    System.out.println("Vul ID in en druk op enter.");
    
    int adressId = TextIO.getlnInt();
//Controller.findBestellingByAdress(adressId);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
}
public  void bestellingenmenuDbAA(){
    
     System.out.println("U gaat een bestelling zoeken op Aantal Artikelen.");
    System.out.println("Vul het aantal in en druk op enter.");
    
    int aantal = TextIO.getlnInt();
//Controller.findBestellingByAantalArtikelen(aantal);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
}
public  void bestellingenmenuDoTP(){
    
     System.out.println("U gaat een bestelling zoeken op Totaal prijs.");
    System.out.println("Vul het totaal in en druk op enter.");
    
     BigDecimal pPrijs = new BigDecimal(TextIO.getln());
//Controller.findBestellingTotaalprijs(pPrijs);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
}

public  void bestellingenmenuTB(){
    
     System.out.println("U gaat een bestelling toevoegen.");
   System.out.println("Vul de klant id  in en druk op enter.");
      int klantid = TextIO.getlnInt();
    System.out.println("Vul het adres id en druk op enter");
      int adresid = TextIO.getlnInt();
    System.out.println("Vult aantal artikelen in en druk op enter");
     int AA = TextIO.getlnInt();
    System.out.println("Vul het aantal in de voorraad en druk op enter");
       BigDecimal Totprijs = new BigDecimal(TextIO.getln());
   
   //maak product 
   
 // Bestelling nbestelling = new Bestelling.BestellingBuilder().klantid(klantid).adresid(adresid).Aantalartikelen(AA).Totprijs(Totprijs).build();
  
  
   
//Controller.toevoegenBestelling(Bestelling nbestelling);


//System.out.println(nbestelling.toString());
System.out.println("de controller klasse is nog niet af.");


    bestellingenmenu();
    
    
}

public  void bestellingenmenuVki(){
    
     
    System.out.println("U gaat een bestelling klant id veranderen.");
    
    
     System.out.println("Vul bestellingid in druk enter.");
    
     int Bid = TextIO.getlnInt();
    
    
    
    
    System.out.println("Vul het klant id en dan enter.");
   // System.out.println("Vul hierna de omschrijving in en druk enter.");
    
    
    int KiD = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingKlantID(Bid,Kid);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}
public  void bestellingenmenuVAi(){
    
     
    System.out.println("U gaat een bestelling Adres id veranderen.");
    
     System.out.println("Vul bestellingid in druk enter.");
    
     int Bid = TextIO.getlnInt();
    
    
    System.out.println("Vul het Adres id en dan enter.");
   // System.out.println("Vul hierna de omschrijving in en druk enter.");
    
    
    int AiD = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingAdresID(Bid,AiD);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}
public  void bestellingenmenuVAA(){
    
     
    System.out.println("U gaat het aantal artikelen in een bestelling veranderen.");
    
    
    System.out.println("Vul bestellingid in druk enter.");
    
     int Bid = TextIO.getlnInt();
    System.out.println("Vul het aantalartikelen in  en dan enter.");
    
    
  
    
    
    int AA = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingAantalartikelen(Bid,AiD);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}
public  void bestellingenmenuVTP(){
    
     
    System.out.println("U gaat het totaal prijs in een bestelling veranderen.");
    
    
    System.out.println("Vul bestellingid in druk enter.");
    
     int Bid = TextIO.getlnInt();
    System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  
    
    
    int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}
public  void bestellingenmenuDELETE(){
    
     
    System.out.println("U gaat een bestelling verwijderen");
    
    
    System.out.println("Vul bestellingid in druk enter.");
    
     int Bid = TextIO.getlnInt();
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  
    
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.DELETEBestellingTotaalprijs(Bid);

System.out.println("de controller klasse is nog niet af.");
    bestellingenmenu();
    
    
    
}

/**  info om bestellingmenu te maken:
1: Om bestellingen te zoeken:
    Bestelling findBestellingById(int bestellingId); // returns Bestelling object als zoekresultaat
    List findBestellingByKlant(int klantId); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAdres(Adres opgegevenAdres); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAantalArtikelen(int aantal); // returns List<Bestelling> met zoekresultaten
    List findBestellingByTotaalprijs(BigDecimal prijs); // returns List<Bestelling> met zoekresultaten
    // 2: Om bestellingen toe te voegen:
    boolean toevoegenBestelling(Bestelling opgegevenBestelling); //returns succes of mislukt
    // 3: Om bestellingen aan te passen:
    boolean updateBestellingKlantId(int bestellingId, int klantId); // returns succes of mislukt (+ laat vernieuwde bestelling zien?)
    boolean updateBestellingAdresId(int bestellingId, int adresId); // returns succes of mislukt
    boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen); // returns succes of mislukt
    boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs); // returns succes of mislukt
    // 4: Om bestellingen te verwijderen:
    boolean verwijderenBestelling(int bestellingId); // returns succes of mislukt

/**  info om bestellingmenu te maken:
1: Om bestellingen te zoeken:
    Bestelling findBestellingById(int bestellingId); // returns Bestelling object als zoekresultaat
    List findBestellingByKlant(int klantId); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAdres(Adres opgegevenAdres); // returns List<Bestelling> met zoekresultaten
    List findBestellingByAantalArtikelen(int aantal); // returns List<Bestelling> met zoekresultaten
    List findBestellingByTotaalprijs(BigDecimal prijs); // returns List<Bestelling> met zoekresultaten
    // 2: Om bestellingen toe te voegen:
    boolean toevoegenBestelling(Bestelling opgegevenBestelling); //returns succes of mislukt
    // 3: Om bestellingen aan te passen:
    boolean updateBestellingKlantId(int bestellingId, int klantId); // returns succes of mislukt (+ laat vernieuwde bestelling zien?)
    boolean updateBestellingAdresId(int bestellingId, int adresId); // returns succes of mislukt
    boolean updateBestellingAantalArtikelen(int bestellingId, int aantalArtikelen); // returns succes of mislukt
    boolean updateBestellingTotaalprijs(int bestellingId, BigDecimal totaalprijs); // returns succes of mislukt
    // 4: Om bestellingen te verwijderen:
    boolean verwijderenBestelling(int bestellingId); // returns succes of mislukt

*/







public  void  medewerkersmenu(){
   
  
System.out.println("Welkom in het medewerkersmenu ");
System.out.println("Wat wilt u doen?");
System.out.println(" 1: medewerkergegevens zoeken op id");
System.out.println(" 2: medewerkergegevens zoeken op gegevens");  
System.out.println(" 3: medewerkergegevens maken");
System.out.println(" 4: medewerkers gegevens aanpassen op id");
System.out.println(" 5: medewerker verwijderen");
System.out.println(" 0: terug naar hoofdmenu");
        
       
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
       
    Scanner inputmedewerker = new Scanner(System.in); 
    
    int waarde = inputmedewerker.nextInt();
    if (waarde == 0){ hoofdmenu();}
else if(waarde <= 5 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1: medewerkergegevens zoeken op id"); medewerkersmenu(); break;
                case 2: System.out.println(" 2: medewerkergegevens zoeken op gegevens"); medewerkersmenuZ(); break;  
                case 3: System.out.println(" 3: medewerkergegevens maken"); mederwerkersmenuMT();
                case 4: System.out.println(" 4: medewerkers gegevens aanpassen op id");medewerkersmenuMAoId();
                case 5: System.out.println(" 5: medewerker verwijderen"); medewerkersmenuDELETE();
                
                
               
      
                             }
                        }
   
                     
else{ System.out.println("verkeerde waarde");
medewerkersmenu();

    }
}

public  void medewerkersmenuZ(){
    
    System.out.println("Welkom in het medewerkers zoekmenu ");
System.out.println("Wat wilt u doen?");
System.out.println(" 1: medewerkergegevens zoeken op voornaam");
System.out.println(" 2: medewerkergegevens zoeken op achternaam");  
System.out.println(" 3: medewerkergegevens zoeken op email");
System.out.println(" 0: terug naar mederwerkersmenu");
    

Scanner inputmedewerkerZ = new Scanner(System.in); 
    
    int waarde = inputmedewerkerZ.nextInt();
    if (waarde == 0){ hoofdmenu();}
else if(waarde <= 3 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1: medewerkergegevens zoeken op voornaam"); medewerkersmenuMZoV(); break;
                case 2: System.out.println(" 2: medewerkergegevens zoeken op achternaam"); medewerkersmenuMZoA(); break;  
                case 3: System.out.println(" 3: medewerkergegevens zoeken op email"); medewerkersmenuMZoE(); break;
                
                
                case 7: System.out.println(" 7 klant verwijderen");  klantenmenu(); break;
               
      
                             }
                        }
   
                     
else{ System.out.println("verkeerde waarde");
medewerkersmenu();

    }


}
public  void mederwerkersmenuMT() {
      //maak een medewerker aan
      
      System.out.println("U wilt een medewerker toevoegen");
      
      
      
      
      
      
      System.out.println("controller laag bestaat nog niet");
      medewerkersmenu();
    }
public  void medewerkersmenuMAoId() {
        System.out.println("U gaat een medewerkers aanpassen op ID.");
    
    
    System.out.println("Vul een ID in druk enter.");
    
     int Mid = TextIO.getlnInt();   //DEZE MID moet in elke CONTROLLER als INPUT verwerkt worden!
     
     System.out.println("Wilt u de voornaam veranderen 0: nee 1 : ja");
     
     int Vraag = TextIO.getlnInt();
     
     if(Vraag == 1){ System.out.println("Vul een voornaam in en druk enter"); String vnm = TextIO.getln(); //roep hier een dao aan via controller; 
     System.out.println("Controller bestaat nog niet"); 
     }
     
   System.out.println("Wilt u de achternaam veranderen 0: nee 1 : ja");
     
     int vraag2 = TextIO.getlnInt();
     
     if(vraag2 == 1){ System.out.println("Vul een achternaam in en druk enter"); String anm = TextIO.getln(); //roep hier een dao aan via controller; 
     System.out.println("Controller bestaat nog niet");
     }
     
     System.out.println("Wilt u de emailadres veranderen 0: nee 1 : ja");
     
     int vraag3 = TextIO.getlnInt();
     
     if(vraag3 == 1){ System.out.println("Vul een achternaam in en druk enter"); String email = TextIO.getln(); //roep hier een dao aan via controller; 
     System.out.println("Controller bestaat nog niet"); 
     }
     
    
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);


    medewerkersmenu();
    }
public  void medewerkersmenuDELETE() {
         System.out.println("U gaat een medewerker verwijderen");
    
    
    System.out.println("Vul mederwerkerid in druk enter.");
    
     int delmed = TextIO.getlnInt();
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  
    
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    System.out.println("de controller klasse is nog niet af.");
    
    medewerkersmenu();
    
    
//Controller.DELETEBestellingTotaalprijs(Bid);
    }
public  void medewerkersmenuMZoV() {
       System.out.println("U gaat een medewerkers zoeken op voornaam.");
    
    
    System.out.println("Vul een voornaam in druk enter.");
    
     //int Bid = TextIO.getlnInt();
     String voornm = TextIO.getln();
     
   // System.out.println("Vul  Y in  en dan enter.");
    
    
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);

System.out.println("de controller klasse is nog niet af.");
    medewerkersmenu();
    }
public  void medewerkersmenuMZoA() {
         System.out.println("U gaat een medewerkers zoeken op achternaam.");
    
    
    System.out.println("Vul een achternaam in druk enter.");
    
     //int Bid = TextIO.getlnInt();
     String achternm = TextIO.getln();
     
   // System.out.println("Vul  Y in  en dan enter.");
    
    
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);

System.out.println("de controller klasse is nog niet af.");
    medewerkersmenu();
    }
public  void medewerkersmenuMZoE() {
          System.out.println("U gaat een medewerkers zoeken op email.");
    
    
    System.out.println("Vul een email in druk enter.");
    
     //int Bid = TextIO.getlnInt();
     String voornm = TextIO.getln();
     
   // System.out.println("Vul  Y in  en dan enter.");
    
    
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);

System.out.println("de controller klasse is nog niet af.");
    medewerkersmenu();
    }


    
    
    
    
    
    
    
    

public  void accountsmenu(){
    
System.out.println("Welkom in het accountsmenu ");
System.out.println("=========================");

System.out.println("Wat wilt u doen?");
System.out.println(" 1: accountgegevens zoeken op id");
System.out.println(" 2: account aanmaken");  
System.out.println(" 3: account type aanpassen ");
System.out.println(" 4: account wachtwoord aanpassen");
System.out.println(" 5: account verwijderen");
System.out.println(" 0: terug naar hoofdmenu");
   System.out.println("=========================");     
       
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
       
    Scanner inputmedewerker = new Scanner(System.in); 
    
    int waarde = inputmedewerker.nextInt();
    if (waarde == 0){ hoofdmenu();}
else if(waarde <= 5 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1: accountgegevens zoeken op id"); accountsmenuZoId(); break;
                case 2: System.out.println(" 2: account aanmaken");  accountsmenuAT(); break;
                case 3: System.out.println(" 3: account type aanpassen "); accountsmenuAAt(); break;
                case 4: System.out.println(" 4: account wachtwoord aanpassen "); accountsmenuAAw(); break;
                case 5: System.out.println(" 5: account verwijderen"); accountsmenuDELETE(); break;
   
                            }

}
    else{ System.out.println("verkeerde waarde terug naar accountsmenu");
      accountsmenu();
}

}


public  void accountsmenuZoId() {
         System.out.println("U gaat een account zoeken op ID.");
    
    
    System.out.println("Vul een id in druk enter.");
    
     //int Bid = TextIO.getlnInt();
   int Acid = TextIO.getlnInt();
     
    System.out.println("controller bestaat nog niet.");
    accountsmenu();
    
    }
public  void accountsmenuAT() {
          System.out.println("U gaat een account toevoegen.");
    
    
    System.out.println("Vul een type in druk enter.");
    int type = TextIO.getlnInt();
    
    
     //int Bid = TextIO.getlnInt();
     
      System.out.println("Vul een wachtwoord (max 45chars) in druk enter.");
   String Aw8 = TextIO.getln();
   
   
   //Controller.accountstoevoegen(type,Aw8);
     
    System.out.println("controller bestaat nog niet.");
    accountsmenu();
    }
public  void accountsmenuAAt() {
        
          System.out.println("U gaat een account type aanpassen.");
    
    
    System.out.println("Vul een type in druk enter.");
    int type = TextIO.getlnInt();
    
    
     
   
   
   //Controller.accountstypeaanpassen(type);
     
    System.out.println("controller bestaat nog niet.");
    accountsmenu();
    }
public  void accountsmenuAAw() {
        
          System.out.println("U gaat een account wachtwoord aanpassen.");
    
    
    System.out.println("Vul een wachtwoord in druk enter.");
    String wachtwoord = TextIO.getln();
    
    
     
   
   
   //Controller.accountstypeaanpassenwachtwoord(wachtwoord);
     
    System.out.println("controller bestaat nog niet.");
    accountsmenu();
    }









public  void accountsmenuDELETE() {
         System.out.println("U gaat een account verwijderen");
    
    
    System.out.println("Vul accountid in druk enter, druk 0 als u het niet wilt.");
    
     int delA = TextIO.getlnInt();
     if(delA == 0){hoofdmenu();}
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  //Controller.accountverwijderen(delA);
    
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    System.out.println("de controller klasse is nog niet af.");
    
    accountsmenu();
    }

    
    
    
    
    
    
    

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
         System.out.println("5: Doorzoek bestelling met totaal prijs.");
         System.out.println("6: Toevoegen factuur.");
         System.out.println("7: Verander status factuur op id.");
         System.out.println("8: Verander factuur adress id.");
         System.out.println("9: Verander factuur klant id");
         System.out.println("10: Verander totaal prijs mbv factuur id.");
         System.out.println("11: VERWIJDER factuur met id.");
         System.out.println("0: Terug naar hoofdmenu.");
         System.out.println("=========================");
         System.out.println("Geef uw keuze : ");
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputfactuur = new Scanner(System.in); 
    
    int wa = inputfactuur.nextInt();
if (wa == 0){ hoofdmenu();}
else if(wa <= 11 && wa >0 ){
    
            switch (wa){
                case 1:  System.out.println("1: Doorzoek facturen met id."); facturenmenuZoId(); break; 
                case 2:  System.out.println("2: Doorzoek facturen met klant id."); facturenmenuZoKid(); break;
                case 3:  System.out.println("3: Doorzoek facturen met adress id ."); facturenmenuZoAid(); break;
                case 4:  System.out.println("4: Doorzoek facturen met bestelling id.");facturenmenuZoBid(); break;
                case 5:  System.out.println("5: Doorzoek bestelling met totaal prijs."); facturenmenuZoTP(); break;
                case 6:  System.out.println("6: Toevoegen factuur."); facturenmenuFT(); break;              
                case 7:  System.out.println("7: Verander status factuur op id."); facturenmenuVS(); break;
                case 8:  System.out.println("8: Verander factuur adress id.");facturenmenuVaId(); break;
                case 9:  System.out.println("9: Verander factuur klant id"); facturenmenuVkId(); break;
                case 10: System.out.println("10: Verander totaal prijs mbv factuur id."); facturenmenuVtp(); break;
                case 11: System.out.println("11: VERWIJDER factuur met id."); facturenmenuDELETE(); break;
                             }
                        }
   
                     
else{ System.out.println("verkeerde cijfer waarde");
facturenmenu();

    }

                     

    
    
    
}

    public  void facturenmenuDELETE() {
        System.out.println("U gaat een factuur verwijderen");
    
    
    System.out.println("Vul factuurid in druk enter, druk 0 als u het niet wilt.");
    
     int delF = TextIO.getlnInt();
     if(delF == 0){hoofdmenu();}
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  //Controller.factuurverwijderen(delF);
    
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    System.out.println("de controller klasse is nog niet af.");
    
    facturenmenu();
    }
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
    public  void facturenmenuVS() {
          System.out.println("U gaat de status van factuur id veranderen.");
    
    
         
          System.out.println("Vul factuurid in druk enter.");
     
    int fiD = TextIO.getlnInt();
    
    System.out.println("Vul klant id in druk enter.");
    
     String status = TextIO.getln();
    
     
    
    
    
    
    
    
    
//Controller.updatefacturenstatus(Fid,status);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    
    }
    public  void facturenmenuFT() {
          System.out.println("U gaat een factuur toevoegen.");
          
   System.out.println("Vul de klant id  in en druk op enter.");
      int klantid = TextIO.getlnInt();
    System.out.println("Vul het bestelling id en druk op enter");
      int Bid = TextIO.getlnInt();
    System.out.println("Vult adress id in en druk op enter");
     int Aid = TextIO.getlnInt();
    System.out.println("Vul het totaal prijs in de voorraad en druk op enter");
       BigDecimal FTotprijs = new BigDecimal(TextIO.getln());
     System.out.println("Vul de status in en druk op enter");
       String status = TextIO.getln();
       
   
   //maak product 
   
 // Bestelling nbestelling = new Bestelling.BestellingBuilder().klantid(klantid).adresid(adresid).Aantalartikelen(AA).Totprijs(Totprijs).build();
  
  
   
//Controller.toevoegenBestelling(Bestelling nbestelling);


//System.out.println(nbestelling.toString());
System.out.println("de controller klasse is nog niet af.");


    facturenmenu();
    }
    public  void facturenmenuZoTP() {
         System.out.println("U gaat een factuur zoeken mbv totaal prijs");
    System.out.println("Vul totaal prijs in en druk op enter.");
    
     BigDecimal totaalprijs = new BigDecimal(TextIO.getln());
     
     
//Controller.findfacturenByKlant(totaalprijs);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }
    public  void facturenmenuZoBid() {
           System.out.println("U gaat een factuur zoeken mbv bestelling id");
    System.out.println("Vul een bestelling id (int) in en druk op enter.");
    
     int bid = TextIO.getlnInt();
     
     
     
     
//Controller.findfacturenBybestellingID(bid);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }
    public  void facturenmenuZoAid() {
          System.out.println("U gaat een factuur zoeken mbv adress id");
    System.out.println("Vul adress id (int) in en druk op enter.");
    
     int Aid = TextIO.getlnInt();
     
     
//Controller.findfacturenByAdressid(tAid);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }
    public  void facturenmenuZoKid() {
          System.out.println("U gaat een factuur zoeken mbv klanten id");
    System.out.println("Vul klant id (int) in en druk op enter.");
    
     int Kid = TextIO.getlnInt();
     
     
//Controller.findfacturenByklantenid(Kid);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
        
        
        
    }
    public  void facturenmenuZoId() {
         System.out.println("U gaat een factuur zoeken mbv  id");
    System.out.println("Vul factuur id (int) in en druk op enter.");
    
     int Fid = TextIO.getlnInt();
     
     
//Controller.findfacturenById(Fid);

System.out.println("de controller klasse is nog niet af.");
    facturenmenu();
    }

    


public void print(String string){
    
    System.out.println(string);
}
     
public void print(List list){
      
      System.out.println(Arrays.toString(list.toArray()));
        }



public  void bestellingregelmenu(){
    
   
  System.out.println("Welkom in het productregelmenu ");
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
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
    Scanner inputfactuur = new Scanner(System.in); 
    
    int wa = inputfactuur.nextInt();
if (wa == 0){ hoofdmenu();}
else if(wa <= 10 && wa >0 ){
    
            switch (wa){
                case 1: System.out.println("1: Doorzoek productregel met id."); bestellingregelmenuZoID(); break;
                case 2: System.out.println("2: Doorzoek productregel met bestelling id."); bestellingregelmenuZoBid(); break;
                case 3: System.out.println("3: Doorzoek productregel met producten id ."); bestellingregelmenuZoPid(); break;
                case 4: System.out.println("4: Doorzoek productregel met hoeveelheid."); bestellingregelmenuZoH(); break;
                case 5: System.out.println("5: Toevoegen productregel."); bestellingregelmenuT(); break;
                case 6: System.out.println("6: Verander bestelling id mbv productregel id."); bestellingregelmenuVBid(); break;
                case 7: System.out.println("7: Verander producten id mbv productregel id."); bestellingregelmenuVPid(); break;
                case 8: System.out.println("8: Verander hoeveelheid mbv productregel id"); bestellingregelmenuVH(); break;
                case 9: System.out.println("9: VERWIJDER productregel met id."); bestellingregelmenuDELETE(); break;
   
            }}

else{ System.out.println("verkeerde cijfer waarde");
bestellingregelmenu();

    }

}


public  void bestellingregelmenuZoID(){
 System.out.println("U gaat een bestellingregel zoeken op bestellingregel ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int bestellingRId = TextIO.getlnInt();
//Controller.findBestellingregelById(bestellingRId);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu();    
}
public  void bestellingregelmenuZoBid(){
     System.out.println("U gaat een bestellingregel zoeken op bestelling ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int bestellingId = TextIO.getlnInt();
//Controller.findBestellingregelById(bestellingId);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu();
}
public  void bestellingregelmenuZoPid(){
    System.out.println("U gaat een bestellingregel zoeken op product ID.");
    System.out.println("Vul ID in en druk op enter.");
    
    int PId = TextIO.getlnInt();
//Controller.findBestellingregelById(PId);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu(); 
}
public  void bestellingregelmenuZoH(){
   System.out.println("U gaat een bestellingregel zoeken op hoeveelheid.");
    System.out.println("Vul ID in en druk op enter.");
    
    int H = TextIO.getlnInt();
//Controller.findBestellingregelByHoeveelheid(H);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu();  
}
public  void bestellingregelmenuT(){
   
      System.out.println("U gaat een bestellingregel toevoegen.");
          
   System.out.println("Vul de bestelling id  in en druk op enter.");
      int Bid = TextIO.getlnInt();
    System.out.println("Vul het producten id en druk op enter");
      int Pid = TextIO.getlnInt();
    System.out.println("Vult de hoeveelheid van dit product in en druk op enter");
     int H = TextIO.getlnInt();
    
       
   
   //maak bestellingregel
   
 // Bestelling nbestelling = new Bestelling.BestellingBuilder().klantid(klantid).adresid(adresid).Aantalartikelen(AA).Totprijs(Totprijs).build();
  
  
   
//Controller.toevoegenBestellingregel(Bid,Pid,H);



System.out.println("de controller klasse is nog niet af.");


    bestellingregelmenu();
    
    
}
public  void bestellingregelmenuVBid(){
    System.out.println("U gaat het bestelling id van bestellingregel id veranderen.");
    
    
         
          System.out.println("Vul bestellingregel id in druk enter.");
     
    int BRiD = TextIO.getlnInt();
    
    System.out.println("Vul bestelling id in druk enter.");
    
     int Bid = TextIO.getlnInt();
    
    
    
//Controller.updatebestellingregelbybestellingid(BRid,Bid);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu(); 
}
public  void bestellingregelmenuVPid(){
   System.out.println("U gaat het product id van bestellingregel id veranderen.");
    
    
         
          System.out.println("Vul bestellingregel id in druk enter.");
     
    int BRiD = TextIO.getlnInt();
    
    System.out.println("Vul product id in druk enter.");
    
     int Pid = TextIO.getlnInt();
    
    
    
//Controller.updatebestellingregelbyProductid(BRid,Pid);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu();   
}
public  void bestellingregelmenuVH(){
     System.out.println("U gaat de hoeveelheid van bestellingregel id veranderen.");
    
    
         
          System.out.println("Vul bestellingregel id in druk enter.");
     
    int BRiD = TextIO.getlnInt();
    
    System.out.println("Vul de hoeveelheid in druk enter.");
    
     int H = TextIO.getlnInt();
    
    
    
//Controller.updatebestellingregelbyHoeveelheid(BRid,H);

System.out.println("de controller klasse is nog niet af.");
    bestellingregelmenu(); 
}
public  void bestellingregelmenuDELETE() {
        System.out.println("U gaat een productregel verwijderen");
    
    
    System.out.println("Vul productregel id in druk enter, druk 0 als u het niet wilt.");
    
     int delPR = TextIO.getlnInt();
     if(delPR == 0){hoofdmenu();}
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  //Controller.productregelverwijderen(delPR);
    
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    System.out.println("de controller klasse is nog niet af.");
    
   bestellingregelmenu();
    }





}
