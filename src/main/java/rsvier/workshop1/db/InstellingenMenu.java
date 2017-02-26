/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.db;

import rsvier.workshop1.Menu;
import static rsvier.workshop1.db.DbConfigurator.getDbConfigurator;
import rsvier.workshop1.util.TextIO;

/**
 *
 * @author jurjen
 */
public class InstellingenMenu {
    
    private DbConfigurator dbConfigurator = getDbConfigurator();
    
    public void instellingenmenu() {
        System.out.println("Welkom in het instellingen menu.");
        System.out.println("Wat wilt u doen?");
        System.out.println("1: Database instellingen bekijken of aanpassen.");
        System.out.println("2: Connectie instellingen bekijken of aanpassen.");
        System.out.println("0: Terug naar het hoofdmenu.");
        System.out.println("Geef uw keuze: ");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
            case 1: databasemenu(); break;
            case 2: connectiemenu(); break;
            default: System.out.println("Verkeerde invoer."); instellingenmenu();
        }
    }

    private void databasemenu() {
        System.out.println("Welkom in het database menu.");
        System.out.println("De instellingen van de huidige database zijn: ");
        System.out.println("Type: " + dbConfigurator.getDbType());
        System.out.println("Host: " + dbConfigurator.getDbHost());
        System.out.println("Username: " + dbConfigurator.getDbUsername());
        System.out.println("Password: " + dbConfigurator.getDbUserpass());
        System.out.println("Wat wilt u doen?");
        System.out.println("1: Type database aanpassen.");
        //System.out.println("2: Host database aanpassen.");
        //System.out.println("3: Username database aanpassen.");
        //System.out.println("4: Password database aanpassen.");
        System.out.println("0: Terug naar instellingen menu.");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 0: instellingenmenu(); break;
            case 1: editDbType(); break;
            case 2: editDbHost(); break;
            case 3: editDbUser(); break;
            case 4: editDbPass(); break;
            default: System.out.println("Verkeerde invoer."); databasemenu();
        }
    }  

    private void editDbType() {
        System.out.println("Welk type database wilt u gebruiken?");
        String dbType = TextIO.getln();
        if (dbConfigurator.setDatabase(dbType)) {
            System.out.println("Database type is succesvol aangepast.");
            databasemenu();
        } else {
            System.out.println("Database type kon niet worden aangepast.");
            databasemenu();
        }        
    }

    private void editDbHost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editDbUser() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void editDbPass() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void connectiemenu() {
        System.out.println("Welkom in het connectie menu.");
        System.out.println("Momenteel wordt gebruik gemaakt van een " + dbConfigurator.getConnType() + " connectie.");
        System.out.println("Wat wilt u doen?");
        System.out.println("1: Type connectie aanpassen.");
        System.out.println("0: Terug naar instellingen menu.");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 0: instellingenmenu(); break;
            case 1: editConnType(); break;
            default: System.out.println("Verkeerde invoer."); connectiemenu();
        }
    }

    private void editConnType() {
        System.out.println("Welk type connectie wilt u gebruiken?");
        String connType = TextIO.getln();        
        if (dbConfigurator.setConnection(connType)) {
            System.out.println("Connectie type is succesvol aangepast.");
            connectiemenu();
        } else {
            System.out.println("Connectie type kon niet worden aangepast.");
            connectiemenu();
        }   
    }
}
