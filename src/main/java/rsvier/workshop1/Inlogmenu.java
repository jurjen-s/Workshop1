/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;

/**
 *
 * @author Frank
 */
public class Inlogmenu {
    
  public static int inlogMenu(){
      int cijfer;
      
      
      System.out.println("Log in");
      System.out.println("1: inloggen ");
      System.out.println("2: account aanmaken ");
      System.out.println("0: stoppen");
      
      cijfer = TextIO.getlnInt();
      
if (cijfer == 0){ System.out.println("Einde"); cijfer = 0;}
else if (cijfer <= 2 && cijfer >0){
    switch (cijfer){
        case 1: System.out.println("U gaat inloggen");inlogControle(); cijfer = 1;   break;
        case 2: System.out.println("U gaat een account aanmaken"); inlogAccountAanmaken(); cijfer = 2; break;
     
    }
}
else{ System.out.println("foute cijfer waarde probeer opnieuw"); inlogMenu(); }

return cijfer;
  }
      
      
   public static void inlogControle(){
       
       System.out.println("vul account id in");
        int AcId = TextIO.getlnInt();
        
       System.out.println("vul wachtwoord in");
       
       String wachtwoord = TextIO.getln();
       
       
       // controle uitvoeren met database, als dat goed is , -> niks-> cijfer is 1 -> toestemming menu.
  
       
       
       
       
       
       
       
       
       
       
       // ALS dat fout is terug, dus inlogMenu();
       
       
       //Inlogmenu.inlogMenu();
       
       
   }   
      
      public static void inlogAccountAanmaken(){
          
          System.out.println("u krijgt een automatische inlog id");
        
        
       System.out.println("vul u eigen wachtwoord in");
       
       String wachtwoord = TextIO.getln();
          
       
       
       
         System.out.println("uw id is :" + "SQL code ontbreekt nog");
         System.out.println("uw wachtwoord is : "+ wachtwoord);
          
         // data in sql opslaan en id terug weergeven!!
         
         //dan terug naar loginmenu ALTIJD
         
         Inlogmenu.inlogMenu();
         
          
      }
   

    
    
    
    
    
    
    
    
    
    
    
    
}
