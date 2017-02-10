/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.util.List;

/**
 *
 * @author jurjen
 */
public interface AdresDAO {
    
    Adres findAdresById(int adresId);
    List findAdresByType(int adresType);
    List findAdresByKlantId(int klantId);
    List findAdresByPostcode(String postcode);
    List findAdresByLand(String land);
    
    Adres toevoegenAdres(Adres adres);
    
    boolean updateAdresType(int adresType);
    boolean updateAdresStraatnaam(String straatnaam);
    boolean updateAdresHuisnummer(int huisnummer);
    boolean updateAdresHeeftHuisnrToevoeging(int heeftHuisnrToevoeging);
    boolean updateAdresHuisnrToevoeging(String huisnrToevoeging);
    boolean updateAdresPostcode(String postcode);
    boolean updateAdresLand(String land);
    
}
