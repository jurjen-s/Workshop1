/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

/**
 *
 * @author jurjen
 */
public class InlogMenu {
    
    public void inloggen() {
    System.out.println("U wilt inloggen.");
    System.out.println("Optie 1: Inloggen.");
    System.out.println("Optie 2: Account aanmaken");
    System.out.println("Optie 0: Stoppen.");
    int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 1: inlogMenu();
                    break;
            case 2: aanmaakMenu();
                    break;
            case 0: System.exit();        
        }
    }
    
    public void inlogMenu() {
        System.out.println("Vul uw id in: ");
        int accountId = TextIO.getlnInt();
        System.out.println("Vul uw wachtwoord in: ");
        String wachtwoord = TextIO.getln();
        /*
        if (controleerLogin(accountId, wachtwoord) {
            hoofdmenu();
        } else {
            inloggen();
        }
        */
        if (true) {
            hoofdmenu();
        } else {
            inloggen();
        }
    }
    
    public void aanmaakMenu() {
        System.out.println("Vul uw account typ in: ");
        int accountType = TextIO.getlnInt();
        System.out.println("Vul uw wachtwoord in: ");
        String wachtwoord = TextIO.getln();
        // roep functie aan die account aanmaakt in db, verkrijg ID
        // print id, type en wachtwoord en keer dan terug naar inloggen
        inloggen();
    }    
    
    public void hoofdmenu() {
        System.out.println("Hoera!");
    }
        
    
}
