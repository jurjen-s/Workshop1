/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

//import java.util.Scanner;


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
    
    int klantId = TextIO.getlnInt();
    
    Klant klantresult = new Klant();
   
     klantresult = klantController.findBijID(klantId);
   
   //AF
    
    klantresult.getAll(klantresult);
    
    



    klantenmenu();
}
public void klantenmenuZoVN(){
     System.out.println("U gaat een klant zoeken op voornaam.");
    System.out.println("Vul de voornaam in en druk op enter.");
    
    String VN = TextIO.getln();
    

    Klant klantresult = new Klant();
   
     klantresult = klantController.findBijVoornaam(VN);
   
   //AF
    
    klantresult.getAll(klantresult);
    
    
    


    klantenmenu();
}
public  void klantenmenuZoAN(){
     System.out.println("U gaat een klant zoeken op achternaam.");
    System.out.println("Vul de achternaam in en druk op enter.");
    
    String AN = TextIO.getln();
    
 Klant klantresult1 = new Klant();
   
     klantresult1 = klantController.findBijLastName(AN);
   
   //AF
    
    klantresult1.getAll(klantresult1);


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
    
    
    Klant klantresult2 = new Klant();
   
     klantresult2 = klantController.findBijNaam(VN,T,AN);
   
   //AF
    
    klantresult2.getAll(klantresult2);
    
    



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
    
   
    klantController.updateKlant(accountidvanklant,  VN, Heefttussenvoegsel, TV, AN, Telefoonnr).toString();
    
    klantenmenu();
}
public void klantenmenuShow(){
     System.out.println("deze klantenDAO is nog niet goed");
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
