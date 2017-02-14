/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 *
 * @author Frank
 */
public class StartProgram {
    
   
      
        
  
    
    
    public static void main(String[] args){
        
         Logger logger = LogManager.getLogger(StartProgram.class);
        
        logger.info("Programma runt ");
        
        logger.error("logger moet opslaan!");
        
        
        
    
        System.out.println("Eerst inloggen");
        
        Inlogmenu inlogmenu= new Inlogmenu();
        
       inlogmenu.inlogMenu();
       
       
        System.out.println("Eind programma");
      
    
    }
    
        
}
    
    

