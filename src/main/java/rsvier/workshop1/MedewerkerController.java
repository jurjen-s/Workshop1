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

public class MedewerkerController {
    
    
    private SQLConnection connectie = new SQLConnection();
    private Connection sqlConnectie = connectie.getSQLConnection();
    
    
    private MedewerkerDAO medewerkerDAO = new MedewerkerSQL(sqlConnectie);
    
    

    
    
    
    
    boolean MedewerkerDELETE(int id){
        
        boolean medewerkerNaarMenu ;
        
        medewerkerNaarMenu = medewerkerDAO.deleteMedewerker(id);
        
        return medewerkerNaarMenu;
        
        
    }

    Medewerker MedewerkerVindBijID(int id){
    
    Medewerker med = new Medewerker();
      
    
    med = medewerkerDAO.findMedewerkerByID(id);
    
    
    return med;
    
  
}

    Medewerker MedewerkerVindBijVoornaam(String voornaam){
        
        Medewerker med1 = new Medewerker();
        
        med1 = medewerkerDAO.findMedewerkerByVoornaam(voornaam);
        
        return med1;
    }
    
    Medewerker MedewerkerVindBijAchternaam(String achternaam){
       Medewerker me = new Medewerker();
        
        me = medewerkerDAO.findMedewerkerByAchternaam(achternaam);
        
        return me; 
        
    }
    
    Medewerker MedewerkerVindBijEmail(String email){
        
        Medewerker med2 = new Medewerker();
        
        med2 = medewerkerDAO.findMedewerkerByEmail(email);
        
        return med2;
        
    }
    
   Medewerker CreateMedewerker( int AccountID , String email, String voornaam, String tussenvoegsel, String achternaam){
       
       Medewerker mademed = new Medewerker();
       
       mademed = medewerkerDAO.createMedewerker(AccountID, email, voornaam, tussenvoegsel, achternaam);
       
       return mademed;
       
   }
    
   Medewerker UpdateMedewerker ( int MedeID , int AccountID , String email, String voornaam, String tussenvoegsel, String achternaam){
       Medewerker upmed = new Medewerker();
       
      upmed = medewerkerDAO.updateMedewerker(MedeID, AccountID, email, voornaam, tussenvoegsel, achternaam);
       
       return upmed;
   }
    


}

