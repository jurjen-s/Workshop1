/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.medewerker;

/**
 *
 * @author Frank
 */
public interface MedewerkerDAO {
    
    
    
    boolean deleteMedewerker(int id);
    
    Medewerker findMedewerkerByID(int id);
    Medewerker createMedewerker(int medewerkerAccountID , String email, String voornaam, String tussenvoegsel, String achternaam);
    Medewerker updateMedewerker(int medewerkerID, int medewerkerAccountID , String email, String voornaam, String tussenvoegsel, String achternaam);
    Medewerker findMedewerkerByVoornaam(String voornaam);
    Medewerker findMedewerkerByAchternaam(String achternaam);
    Medewerker findMedewerkerByEmail(String email);
    
    
}
