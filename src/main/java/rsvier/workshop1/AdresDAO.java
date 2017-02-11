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
    boolean deleteAdres(int AdresID);
    
    boolean updateAdresType(int adresId, int adresType);
    boolean updateAdresStraatnaam(int adresId, String straatnaam);
    boolean updateAdresHuisnummer(int adresId, int huisnummer);
    boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging);
    boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging);
    boolean updateAdresPostcode(int adresId, String postcode);
    boolean updateAdresLand(int adresId, String land);
    
}
