/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author jurjen
 */

/*

public class ProductenMenu implements Menu {

    @Override
    public void showMenu() {
        System.out.println("========================");
        System.out.println("Wat wilt u doen?");
        System.out.println("------------------------");
        System.out.println("1: Producten doorzoeken.");
        System.out.println("2: Producten toevoegen.");
        System.out.println("3: Producten aanpassen.");
        System.out.println("4: Producten verwijderen.");
        System.out.println("5: Terug naar hoofdmenu.");
        System.out.println("------------------------");
        System.out.println("Geef uw keuze (1-5): ");
        System.out.println("========================");
        int keuze = TextIO.getlnInt();
        switch (keuze) {
            case 1:     zoekenMenu();
                        break;
            case 2:     toevoegenMenu();
                        break;
            case 3:     aanpassenMenu();
                        break;
            case 4:     verwijderenMenu();
                        break;
            case 5:     // terug naar hoofdMenu;
                        break;
            default:    System.out.println("Ongeldige invoer.");
                        showMenu();
        }
    } // einde showMenu(hoofdmenu)
    
public void zoekenMenu() {
    System.out.println("=========================");
    System.out.println("Doorzoek op productID");
    System.out.println("-------------------------");
    System.out.println("Geef het productID op: ");
    int productID = Integer.parseInt(System.console().readLine());
    
    
    
    try (Connection DoorzoekProductID = rsvier.meebezig.ConnectionManager.SQLConnection()) {
        //Connection conn = openConnection();
        PreparedStatement stmt = DoorzoekProductID.prepareStatement(
            "SELECT * " +
            " FROM producten " +
            " WHERE producten_id = ?");
        stmt.setInt(1, productID);
        ResultSet rs = stmt.executeQuery();
        // Laat alle producten met het opgegeven productID zien
        while (rs.next()) {
            System.out.println(rs.getString(1)); // productID
            System.out.println(rs.getString(2)); // omschrijving
            System.out.println(rs.getString(3)); // soort
            System.out.println(rs.getString(4)); // prijs
            System.out.println(rs.getString(5)); // voorraad
        }
        conn.close();
        stmt.close();
    } catch (SQLException ex) {
            ex.getMessage();
    }
    
} // einde zoekenMenu
public void toevoegenMenu() {
    
} // einde toevoegenMenu
public void aanpassenMenu() {
    
} // einde aanpassenMenu
public void verwijderenMenu() {
    
} // einde verwijderenMenu

} // einde ProductenMenu(class)



*/