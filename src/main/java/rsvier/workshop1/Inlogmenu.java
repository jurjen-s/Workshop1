/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;

/**
 *
 * @author Frank
 */
public class Inlogmenu {
    
 private AccountController accountController = new AccountController();  
    
    
  public void inlogMenu(){
      int cijfer;
      
      
      System.out.println("Log in");
      System.out.println("1: inloggen ");
      System.out.println("2: account aanmaken ");
      System.out.println("0: stoppen");
      
      cijfer = TextIO.getlnInt();
      
if (cijfer == 0){ System.out.println(" "); cijfer = 0;}
else if (cijfer <= 2 && cijfer >0){
    switch (cijfer){
        case 1: System.out.println("U gaat inloggen"); inlogControle();      break;
        case 2: System.out.println("U gaat een account aanmaken"); inlogAccountAanmaken(); break; 
     
        
      
    }
}
else{ System.out.println("foute cijfer waarde probeer opnieuw"); inlogMenu(); }

  
  }
      
      
   public void inlogControle(){
       
       
       System.out.println("vul account id in");
        int AcId = TextIO.getlnInt();
        
       System.out.println("vul wachtwoord in");
       
       String wachtwoord = TextIO.getln();
       
       
       
       
       
       if (accountController.loginCheckAccount(AcId, wachtwoord)){
       // if ok -> cijfer 1  -> menu, ,  else inlogmenu();
       
       
       //controle uitvoeren met database, als dat goed is , -> niks-> cijfer is 1 -> toestemming menu.
  
      // if (functie) inlogMenu();
      
        Menu menu = new Menu();
       menu.hoofdmenu();
       
       }
       else{ inlogMenu();}
           
       
       
       
   }
   
      
      public  void inlogAccountAanmaken(){
          
          System.out.println("u krijgt een automatische inlog id");
        
        
       System.out.println("vul u eigen wachtwoord in");
       
       String wachtwoord = TextIO.getln();
       
       System.out.println("vul u eigen type 1: klant , 2: medewerker  in");
          
       int type = TextIO.getlnInt();
       
        System.out.println("uw id is: ");
                
                
       accountController.createAccount(type, wachtwoord);
       
       
         
                  
                  
                  
          System.out.println("uw type is : "+ type );
         
          System.out.println("uw wachtwoord is : "+ wachtwoord);
          
        
         // data in sql opslaan en id terug weergeven!!
         
         //dan terug naar loginmenu ALTIJD
         
        
         inlogMenu();
          
      }
   

    
    
    
    
    
    
    
    
    
    
    
    
}
