/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import rsvier.workshop1.account.Inlogmenu;
import rsvier.workshop1.util.MaakDummies;


/**
 *
 * @author Frank
 */
public class StartProgram {
    
   
      
        
  
    
    
    public static void main(String[] args){
        
        // Initialiseer DB
        MaakDummies dummies = new MaakDummies();
        dummies.dummyAccount();
        dummies.dummyMedewerker();
        dummies.dummyKlant();
        dummies.dummyAdres();
        dummies.dummyBestelling();
        dummies.dummyProduct();
        dummies.dummyBestelregel();
        dummies.dummyFactuur();
        
        
        
    /*    
         Logger logger = LogManager.getLogger(StartProgram.class);
        
        logger.info("Programma runt ");
        
        logger.error("logger moet opslaan!");
        
        Validator validator = new Validator();
        boolean valid = validator.validateEmail("test@blabla.com");
        System.out.println(valid);
        
        do {
            System.out.println("Wat is uw postcode? Geef in het formaat \'1234 AZ\'.");
            String postcode = TextIO.getln();
            if (validator.validatePostcode(postcode)) {
                break;
            }  
        } while (true);
    */
        //System.out.println("Eerst inloggen");
        
        Inlogmenu inlogmenu= new Inlogmenu();
        
       inlogmenu.inlogMenu();
       
       
        System.out.println("Einde programma.");
      
    
    }
    
        
}
    
    

