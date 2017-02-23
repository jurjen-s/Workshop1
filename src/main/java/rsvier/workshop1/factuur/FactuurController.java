/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.factuur;

import java.math.BigDecimal;
import java.sql.Connection;
import java.util.List;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author jurjen
 */
public class FactuurController {
    
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private FactuurDAO factuurDAO = new FactuurSQL(sqlConnectie);
    
    public boolean maakFactuur(Factuur factuur) {
        return factuurDAO.maakFactuur(factuur);
    }
    
    /*public Factuur bekijkFactuur(int factuurId) {
        
    }*/
    
    public boolean betaalFactuur(int factuurId) {
        return factuurDAO.betaalFactuur(factuurId);
    }
    
    public boolean deleteFactuur(int factuurId) {
        return factuurDAO.deleteFactuur(factuurId);
    }
    
    public Factuur findFactuurById(int factuurId) {
        return factuurDAO.findFactuurById(factuurId);
    }
    
    public Factuur findFactuurByBestellingId(int bestellingId) {
        return factuurDAO.findFactuurByBestellingId(bestellingId);
    }
    
    public List findFactuurByKlantId(int klantId) {
        return factuurDAO.findFactuurByKlantId(klantId);
    }
    
    public List findFactuurByAdresId(int adresId) {
        return factuurDAO.findFactuurByAdresId(adresId);
    }
    
    public List findFactuurByTotaalprijs(BigDecimal prijs) {
        return factuurDAO.findFactuurByTotaalprijs(prijs);
    }
    
    public List findFactuurByStatus(int status) {
        return factuurDAO.findFactuurByStatus(status);
    }
    
}
