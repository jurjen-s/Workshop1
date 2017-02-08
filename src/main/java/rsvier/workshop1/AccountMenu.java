/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.util.Scanner;


/**
 *
 * @author Frank
 */
public class AccountMenu {
    
    
    private AccountController accountController = new AccountController();  
    
    
    
   public void accountsmenu(){
    
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
    if (waarde == 0){Menu m = new Menu(); m.hoofdmenu();}
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


public void accountsmenuZoId() {
         System.out.println("U gaat een account zoeken op ID.");
    
    
    System.out.println("Vul een id in druk enter.");
    
     //int Bid = TextIO.getlnInt();
   int Acid = TextIO.getlnInt();
    
   Account accountResultaat = new Account();
   
     accountResultaat = accountController.findAccountByID(Acid);
   
   accountResultaat.getALL(accountResultaat);
   
   accountsmenu();
    
    }
public void accountsmenuAT() {
          System.out.println("U gaat een account toevoegen.");
    
    
    System.out.println("Vul een type in druk enter.");
    int type = TextIO.getlnInt();
    
    
     //int Bid = TextIO.getlnInt();
     
      System.out.println("Vul een wachtwoord (max 45chars) in druk enter.");
   String Aw8 = TextIO.getln();
   
   System.out.println( accountController.createAccount(type,Aw8).toString());
   
   

  
  
  
     
    
  
  
  
   accountsmenu();
  
    }
  
  
  
  

public  void accountsmenuAAt() {
        
          System.out.println("U gaat een account type aanpassen.");
    
    System.out.println("Vul de id van de account in die u wilt veranderen") ;

    int id = TextIO.getlnInt();
          
    
    System.out.println("Vul een type in druk enter.");
    
    int type = TextIO.getlnInt();
    
    
     
    System.out.println("veranderen is gelukt : " + accountController.updateAccountType(id, type));
   
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
     
    System.out.println("controller bestaat nog niet.");
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
    System.out.println("de controller klasse is nog niet af.");
    
    accountsmenu();
    }
 
}
