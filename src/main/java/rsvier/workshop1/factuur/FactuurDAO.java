/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.factuur;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jurjen
 */
public interface FactuurDAO {
    
    boolean maakFactuur(Factuur factuur);
    // Factuur bekijkFactuur(int factuurId); overbodig, hetzelfde als findFactuurById
    boolean betaalFactuur(int factuurId);
    boolean deleteFactuur(int factuurId);
    
    Factuur findFactuurById(int factuurId);
    Factuur findFactuurByBestellingId(int bestellingId);
    List findFactuurByKlantId(int klantId);
    List findFactuurByAdresId(int adresId);
    List findFactuurByTotaalprijs(BigDecimal prijs);
    List findFactuurByStatus(int status);
    
}
