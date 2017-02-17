/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

//import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author Frank
 */


public class KlantMenu {
    
    
    //om de controller te kunnen aanroepen.
    private KlantController klantController = new KlantController();
    
    
    
    public void  klantenmenu(){
   
  
System.out.println("Welkom in het klantenmenu ");
System.out.println("Wat wilt u doen?");

System.out.println(" 1: klant gegevens zoeken op klant id");
System.out.println(" 2: klant gegevens zoeken op klant voornaam");     
System.out.println(" 3: klant gegevens zoeken op klant achternaam");  
System.out.println(" 4: klant gegevens zoeken met volledige naam");
System.out.println(" 5: klant gegevens aanpassen");
System.out.println(" 6: klant gegevens zien");
System.out.println(" 7: Maak een klant");
System.out.println(" 8: klant verwijderen");
System.out.println(" 0: terug naar hoofdmenu");
        
       
System.out.println("Vul het cijfer in wat u wilt doen");
System.out.println("en druk dan op enter.");
    
        
   // Scanner inputklant = new Scanner(System.in); < text io is superieur.
    
    int waarde = TextIO.getlnInt();
    
if (waarde == 0){ Menu hm = new Menu(); hm.hoofdmenu();}
else if(waarde <= 8 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1 Klant zoeken op klant id"); klantenmenuZoKid(); break;
                case 2: System.out.println(" 2 Klant zoeken op klant voornaam"); klantenmenuZoVN();    break;
                case 3: System.out.println(" 3 klant zoeken op klant achternaam");  klantenmenuZoAN(); break;
                case 4: System.out.println(" 4 klant zoeken op volledige naam");  klantenmenuZoN(); break;
                case 5: System.out.println(" 5 klant gegevens aanpassen");  klantenmenuV(); break;
                case 6: System.out.println(" 6 Laat alle klanten zien");  klantenmenuShow(); break;
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
    System.out.println("Vul klant id in en druk op enter.");
    
    int klantId = TextIO.getlnInt();
    
    List<Klant> zoekresultaat = new ArrayList<Klant>();
   
      zoekresultaat = klantController.findBijID(klantId);
        for (Klant foreachklant : zoekresultaat) {
            foreachklant.getAll(foreachklant);
        }
    
    
    klantenmenu();
}
public void klantenmenuZoVN(){
     System.out.println("U gaat een klant zoeken op voornaam.");
    System.out.println("Vul de voornaam in en druk op enter.");
    
    String VN = TextIO.getln();
    
 List<Klant> zoekresultaat = new ArrayList<Klant>();
   
      zoekresultaat = klantController.findBijVoornaam(VN);
        for (Klant foreachklant : zoekresultaat) {
            foreachklant.getAll(foreachklant);
        }
    
    

    klantenmenu();
}
public  void klantenmenuZoAN(){
     System.out.println("U gaat een klant zoeken op achternaam.");
    System.out.println("Vul de achternaam in en druk op enter.");
    
    String AN = TextIO.getln();
    
  List<Klant> zoekresultaat = new ArrayList<Klant>();
   
      zoekresultaat = klantController.findBijLastName(AN);
        for (Klant foreachklant : zoekresultaat) {
            foreachklant.getAll(foreachklant);
        }


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
    
    
     List<Klant> zoekresultaat = new ArrayList<Klant>();
   
      zoekresultaat = klantController.findBijNaam(VN, AN, AN);
        for (Klant foreachklant : zoekresultaat) {
            foreachklant.getAll(foreachklant);
        }
    
    

    klantenmenu();
}
public void klantenmenuV(){
    
    
    System.out.println("U gaat een Klant toevoegen.");
    
    
    System.out.println("Vul de Account id van de klant in.");
    int accountidvanklant = TextIO.getlnInt();
    
   
     //int Bid = TextIO.getlnInt();
     
      System.out.println("Vul de voornaam in en druk enter.");
   String VN = TextIO.getln();
   
   
   System.out.println("Vul '0' in en enter in als er GEEN tussenvoegsel , druk '1' in als het EEN tussenvoegsel heeft en druk enter  ");
   int Heefttussenvoegsel = TextIO.getlnInt();
   
   
   
        System.out.println("Vul de tussenvoegels in en druk enter .");
                              String TV = TextIO.getln();
           
   System.out.println("Vul de achternaam in en druk enter.");
   String AN = TextIO.getln(); 
        
   System.out.println("Vul de telefoonnummer in en druk enter.");
   int Telefoonnr = TextIO.getlnInt(); 
    
   
    System.out.println(klantController.updateKlant(accountidvanklant,  VN, Heefttussenvoegsel, TV, AN, Telefoonnr).toString());
    
    klantenmenu();
}
public void klantenmenuShow(){
     
    List<Klant> zoekresultaat = new ArrayList<Klant>();
   
      zoekresultaat = klantController.ShowAllKlant();
        for (Klant foreachklant : zoekresultaat) {
            foreachklant.getAll(foreachklant);
        }
    
    
    
    klantenmenu();
}
public  void klantenmenuT(){
    
    
     System.out.println("U gaat een Klant toevoegen.");
    
    
    System.out.println("Vul de Account id van de klant in.");
    int accountidvanklant = TextIO.getlnInt();
    
    
     //int Bid = TextIO.getlnInt();
     
      System.out.println("Vul de voornaam in en druk enter.");
   String VN = TextIO.getln();
   
   System.out.println("Vul '0' in en enter in als er GEEN tussenvoegsel , druk '1' in als het EEN tussenvoegsel heeft en druk enter  ");
   int Heefttussenvoegsel = TextIO.getlnInt();
   
  
   
    
       
   
   
        System.out.println("Vul de tussenvoegels in en druk enter .");
                              String TV = TextIO.getln();
                      
        
        
        
   System.out.println("Vul de achternaam in en druk enter.");
   String AN = TextIO.getln(); 
        
   System.out.println("Vul de telefoonnummer in en druk enter.");
   int Telefoonnr = TextIO.getlnInt(); 
   
   
    
   //controller & check.
   Klant createKlantInfo = new Klant();
   createKlantInfo = klantController.createKlant(accountidvanklant,VN,Heefttussenvoegsel, TV ,AN,Telefoonnr);
   createKlantInfo.getAll(createKlantInfo);
    
    
    
    //terug naar menu.
    klantenmenu();
}
public void klantenmenuDELETE(){
    System.out.println("U gaat een klant verwijderen. (0 is annuleren)");
    
   
    
    System.out.println("Vul de klant id in en druk op enter.");
    System.out.println("Vul 0 in als u wilt stoppen.");
    
    int Kid = TextIO.getlnInt();
    
    if(Kid==0){klantenmenu();}
    else{
        //Controller.deleteklant(Kid);
        
        
        System.out.println("verwijderen is gelukt : " + klantController.deleteKlant(Kid));
        
        
       klantenmenu();
    }
      
   
    
}
    
    
    
    
    
    
    
    
    
    
    
    
    
}
