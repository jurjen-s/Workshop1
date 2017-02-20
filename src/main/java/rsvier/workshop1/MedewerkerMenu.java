/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

/**
 *
 * @author Frank
 */
public class MedewerkerMenu {
    
    
     private MedewerkerController medewerkerController = new MedewerkerController(); 
    
    
     private Validator validator = new Validator();
    
    private Controller controller = new Controller();
    
    
    
    
    
    
    
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
    
       int waarde = TextIO.getlnInt();
    
    
    
    if (waarde == 0){ Menu m = new Menu(); m.hoofdmenu();}
else if(waarde <= 5 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1: medewerkergegevens zoeken op id"); medewerkersmenuZoID(); break;
                case 2: System.out.println(" 2: medewerkergegevens zoeken op gegevens"); medewerkersmenuZ(); break;  
                case 3: System.out.println(" 3: medewerkergegevens maken"); mederwerkersmenuMT();break;
                case 4: System.out.println(" 4: medewerkers gegevens aanpassen op id");medewerkersmenuMAoId(); break;
                case 5: System.out.println(" 5: medewerker verwijderen"); medewerkersmenuDELETE(); break;
                
                
               
      
                             }
                        }
   
                     
else{ System.out.println("verkeerde waarde");
medewerkersmenu();

    }
}

   public void medewerkersmenuZoID(){
       
       int Midz = -1;
        do {
            System.out.println("Vul het medewerker Id in en druk op enter. Vul 0 in om te annuleren.");
            if (Midz == 0) {
            medewerkersmenu();
            }
            Midz = TextIO.getlnInt();
        } while (!controller.existsMedewerkerId(Midz));
       
       
       Medewerker mResultaat = new Medewerker();
   
     mResultaat = medewerkerController.MedewerkerVindBijID(Midz);
   
     if(mResultaat.getMedewerkerAccountID()==0){
         System.out.print("Er zijn geen medewerkers met deze id.");
     }
     else{
    mResultaat.getView(mResultaat);
     }
       
       
       
       
       
       
       medewerkersmenu();
       
   }
   
   
   
   
   
public  void medewerkersmenuZ(){
    
    System.out.println("Welkom in het medewerkers zoekmenu ");
System.out.println("Wat wilt u doen?");
System.out.println(" 1: medewerkergegevens zoeken op voornaam");
System.out.println(" 2: medewerkergegevens zoeken op achternaam");  
System.out.println(" 3: medewerkergegevens zoeken op email");
System.out.println(" 0: terug naar mederwerkersmenu");
    


    
    int waarde = TextIO.getlnInt();
    
    if (waarde == 0){ medewerkersmenu();}
else if(waarde <= 3 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println(" 1: medewerkergegevens zoeken op voornaam"); medewerkersmenuMZoV(); break;
                case 2: System.out.println(" 2: medewerkergegevens zoeken op achternaam"); medewerkersmenuMZoA(); break;  
                case 3: System.out.println(" 3: medewerkergegevens zoeken op email"); medewerkersmenuMZoE(); break;
                
                
                
               
      
                             }
                        }
   
                     
else{ System.out.println("verkeerde waarde");
medewerkersmenu();

    }


}
public  void mederwerkersmenuMT() {
      //maak een medewerker aan
      
      System.out.println("U wilt een medewerker toevoegen");
      
       System.out.println("U gaat een medewerkers aanpassen op ID.");
    
     
      System.out.println("Vul een  accountID in druk enter.");
      
      int Aid = TextIO.getlnInt();
     
     System.out.println("vul email adress in en druk enter");
     
     String mail = "";
     
     
        do {
            System.out.println("Vul de email in.");
            mail = TextIO.getln();
            if (validator.validateEmail(mail)) {
                break;
            }  
        } while (true);
            
        
     System.out.println("Vul een voornaam in en druk enter");
     
     String vnm = TextIO.getln(); 
      
     System.out.println("vul een tussenvoegsel in en druk enter (of alleen enter als er geen tussenvoegsel is)");
     
     String tussen = TextIO.getln();
     
      System.out.println("Vul een achternaam in en druk enter"); String achternaam = TextIO.getln(); //roep hier een dao aan via controller; 
 
     
    
  Medewerker mResultaatT = new Medewerker();
   
     mResultaatT = medewerkerController.CreateMedewerker(Aid, mail, vnm, tussen, achternaam);
     
    mResultaatT.getView(mResultaatT);
    

    medewerkersmenu();
      
      
      
    }
public  void medewerkersmenuMAoId() {
        System.out.println("U gaat een medewerkers aanpassen op ID.");
    
    
    int Mid = -1;
        do {
            System.out.println("Vul het medewerker Id in en druk op enter. Vul 0 in om te annuleren.");
            if (Mid == 0) {
            medewerkersmenu();
            }
            Mid = TextIO.getlnInt();
        } while (!controller.existsMedewerkerId(Mid));
     
     
      System.out.println("Vul een  accountID in druk enter.");
      
      int Aid = TextIO.getlnInt();
     
     System.out.println("vul email adress in en druk enter");
     
     String mail = "";
     
     
        do {
            System.out.println("Vul de email in.");
            mail = TextIO.getln();
            if (validator.validateEmail(mail)) {
                break;
            }  
        } while (true);
        
     System.out.println("Vul een voornaam in en druk enter");
     
     String vnm = TextIO.getln(); 
      
     System.out.println("vul een tussenvoegsel in en druk enter (of alleen enter als er geen tussenvoegsel is)");
     
     String tussen = TextIO.getln();
     
      System.out.println("Vul een achternaam in en druk enter"); String achternaam = TextIO.getln(); //roep hier een dao aan via controller; 
 
     
    
  Medewerker mResultaatup = new Medewerker();
   
     mResultaatup = medewerkerController.UpdateMedewerker(Mid, Aid, mail, vnm, tussen, achternaam);
     
    mResultaatup.getView(mResultaatup);
    

    medewerkersmenu();
    }
public  void medewerkersmenuDELETE() {
         System.out.println("U gaat een medewerker verwijderen");
    
    
    System.out.println("Vul mederwerkerid in druk enter.");
    
    
     int delmed = -1;
        do {
            System.out.println("Vul het medewerker Id in en druk op enter. Vul 0 in om te annuleren.");
            if (delmed == 0) {
            medewerkersmenu();
            }
            delmed = TextIO.getlnInt();
        } while (!controller.existsMedewerkerId(delmed));
    
    
    
    
    boolean med ;
   
     med = medewerkerController.MedewerkerDELETE(delmed);
   
  
  System.out.println("Verwijderen is goed gegaan: " + med)    ;
    
   
    
    medewerkersmenu();
    
    
//Controller.DELETEBestellingTotaalprijs(Bid);
    }
public  void medewerkersmenuMZoV() {
       System.out.println("U gaat een medewerkers zoeken op voornaam.");
    
    
    System.out.println("Vul een voornaam in druk enter.");
    
     //int Bid = TextIO.getlnInt();
     String voornm = TextIO.getln();
     
   // System.out.println("Vul  Y in  en dan enter.");
    
    Medewerker mResultaat1 = new Medewerker();
   
     mResultaat1 = medewerkerController.MedewerkerVindBijVoornaam(voornm);
   
    mResultaat1.getView(mResultaat1);
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);

    medewerkersmenu();
    }
public  void medewerkersmenuMZoA() {
         System.out.println("U gaat een medewerkers zoeken op achternaam.");
    
    
    System.out.println("Vul een achternaam in druk enter.");
    
     //int Bid = TextIO.getlnInt();
     String achternm = TextIO.getln();
     
   // System.out.println("Vul  Y in  en dan enter.");
    Medewerker mResultaat2 = new Medewerker();
   
     mResultaat2 = medewerkerController.MedewerkerVindBijAchternaam(achternm);
   
    mResultaat2.getView(mResultaat2);
    
  
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);


    medewerkersmenu();
    }
public  void medewerkersmenuMZoE() {
          System.out.println("U gaat een medewerkers zoeken op email.");
    
    
    System.out.println("Vul een email in druk enter.");
    
    String email = "";
     
     
        do {
            System.out.println("Vul de email in.");
            email = TextIO.getln();
            if (validator.validateEmail(email)) {
                break;
            }  
        } while (true);
     
   // System.out.println("Vul  Y in  en dan enter.");
    
    
  Medewerker mResultaat3 = new Medewerker();
   
     mResultaat3 = medewerkerController.MedewerkerVindBijEmail(email);
   
    mResultaat3.getView(mResultaat3);
    
    
   // int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
    
    
    
//Controller.updateBestellingTotaalprijs(Bid,TP);


    medewerkersmenu();
    }
   
   
   
}
