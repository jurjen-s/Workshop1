/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jurjen
 */
public class BestelregelSQL implements BestelregelDAO {

    private Connection bestelregelconnectie;
    
    public BestelregelSQL() {
        SQLConnection sqlConnectie = new SQLConnection();
        this.bestelregelconnectie = sqlConnectie.getSQLConnection();
    }
    
    public BestelregelSQL(Connection connectie) {
        this.bestelregelconnectie = connectie;
    }
    
    @Override
    public boolean toevoegenBestelregel(Bestelregel bestelregel) {
        try (PreparedStatement stmt = bestelregelconnectie.prepareStatement(
            "INSERT INTO bestellingregels" +
            "(FK_bestellingregels_bestellingen_id," +
            "FK_bestellingregels_producten_id, hoeveelheid)" +
            "VALUES (?, ?, ?")) {
            stmt.setInt(1, bestelregel.getBestellingId());
            stmt.setInt(2, bestelregel.getProductId());
            stmt.setInt(3, bestelregel.getHoeveelheid());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            System.out.print(ex.getMessage());
            System.out.println("Er ging iets mis bij het updaten van de bestelregel.");
            return false;
        }
        return true;
    }  
}
