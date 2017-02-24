/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.account;

import java.util.Scanner;
import rsvier.workshop1.Controller;
import rsvier.workshop1.Menu;
import rsvier.workshop1.util.TextIO;


/**
 *
 * @author Frank
 */
public class AccountMenu {
    
    
    private AccountController accountController = new AccountController();  
    
       private Controller controller = new Controller();
    
   public void accountsmenu(){
    
System.out.println("==================================");
System.out.println("Welkom in het accountmenu ");


System.out.println("Wat wilt u doen?");
System.out.println(" 1: Account zoeken op accountId.");
System.out.println(" 2: Nieuwe account aanmaken.");  
System.out.println(" 3: Type account veranderen.");
System.out.println(" 4: Wachtwoord account veranderen.");
System.out.println(" 5: Account verwijderen.");
System.out.println(" 0: Terug naar het hoofdmenu.");
System.out.println("==================================");     
       
System.out.print("Geef uw keuze: ");
    
       
    Scanner inputmedewerker = new Scanner(System.in); 
    
    int waarde = inputmedewerker.nextInt();
    if (waarde == 0){Menu m = new Menu(); m.hoofdmenu();}
else if(waarde <= 5 && waarde >0){
    
            switch (waarde){
                
                case 1: System.out.println("--------------------------"); accountsmenuZoId(); break;
                case 2: System.out.println("2: Nieuwe account aanmaken.");  accountsmenuAT(); break;
                case 3: System.out.println("3: Type account veranderen."); accountsmenuAAt(); break;
                case 4: System.out.println("4: Wachtwoord account veranderen."); accountsmenuAAw(); break;
                case 5: System.out.println("5: Account verwijderen."); accountsmenuDELETE(); break;
   
                            }

}
    else{ System.out.println("Ongeldige invoer, probeer opnieuw.");
    
    
    accountsmenu();
}

}


public void accountsmenuZoId() {
         System.out.println("U gaat een account zoeken op Id.");
    
    
    
    
   int Acid = -1;
        do {
            System.out.print("Voer het accountId in (voer 0 in om te annuleren): ");
            if (Acid == 0) {
            accountsmenu();
            }
            Acid = TextIO.getlnInt();
        } while (!controller.existsAccountId(Acid));
   
   
   
   
   
   Account accountResultaat = new Account();
   
   //Controller roept DAO factory aan!
   
     accountResultaat = accountController.findAccountByID(Acid);
    
    
    /*
    AccountDAOfactory factory = new AccountDAOfactory();
    
    accountResultaat = (factory.getAccountDAO()).findAccountByID(Acid);
    
  */
    
   
   
   // accountResultaat = .findAccountByID(Acid);
     
   
     
   //accountResultaat.setWachtwoord("");
   //accountResultaat.getALL(accountResultaat);
   System.out.println(accountResultaat.toStringWachtwoordloos());
   
   accountsmenu();
    
    }
public void accountsmenuAT() {
          System.out.println("U gaat een account toevoegen.");
    
    
    System.out.print("Wat voor account wilt u aanmaken? \n1: Klant account.\n2: Medewerker account.");
          
       int type = TextIO.getlnInt();  
        
       System.out.print("Wachtwoord: ");
       
       String wachtwoord = TextIO.getln();
   
   System.out.println("Uw account is: " + accountController.createAccount(type,wachtwoord).toStringWachtwoordloos());
   
   

  
  
  
     
    
  
  
  
   accountsmenu();
  
    }
  
  
  
  

public  void accountsmenuAAt() {
        
          System.out.println("U gaat een account type aanpassen.");
    
    int Acid = -1;
        do {
            System.out.println("Vul het Account Id in en druk op enter. Vul 0 in om te annuleren.");
            if (Acid == 0) {
            accountsmenu();
            }
            Acid = TextIO.getlnInt();
        } while (!controller.existsAccountId(Acid));
          
    
    
    
    int type = -1;
    while(type != 2 && type != 1){
        System.out.println("Vul een de nieuwe type in (1: klant 2: medewerker) druk enter.");
        type = TextIO.getlnInt();
    }
    
    
    
    
     
    System.out.println("veranderen is gelukt : " + accountController.updateAccountType(Acid, type));
   
   //Controller.accountstypeaanpassen(type);
     
   
    accountsmenu();
    }
public  void accountsmenuAAw() {
        
          System.out.println("U gaat een account wachtwoord aanpassen.");
    
       System.out.println("vul een id in en druk enter");
          
        int Aid = TextIO.getlnInt();  
    
    System.out.println("Vul een wachtwoord in en druk enter.");
    String wachtwoord = TextIO.getln();
    
    
     System.out.println("veranderen wachtwoord is gelukt : " + accountController.updateAccountWachtwoord(Aid, wachtwoord));
   
   
   //Controller.accountstypeaanpassenwachtwoord(wachtwoord);
     
    
    accountsmenu();
    }









public  void accountsmenuDELETE() {
         System.out.println("U gaat een account verwijderen");
    
    
    System.out.println("Vul accountid in druk enter, druk 0 als u het niet wilt.");
    
     int delA = TextIO.getlnInt();
     if(delA == 0){Menu d = new Menu(); d.hoofdmenu();}
    //System.out.println("Vul het totaal prijs in  en dan enter.");
    
    
  //Controller.accountverwijderen(delA);
   System.out.println("verwijderen is gelukt : " + accountController.deleteAccount(delA));
    
    //int TP = TextIO.getlnInt();
   // String pOmschrijving = TextIO.getln();
   
    
    accountsmenu();
    }
 
}
