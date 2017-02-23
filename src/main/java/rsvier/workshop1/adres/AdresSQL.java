/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

import java.util.List;

/**
 *
 * @author Frank
 */
public abstract class AdresSQL {
    
    
    abstract Adres findAdresById(int adresId);
    abstract List findAdresByType(int adresType);
    abstract List findAdresByKlantId(int klantId);
    abstract List findAdresByPostcode(String postcode);
    abstract List findAdresByLand(String land);
    
    abstract Adres toevoegenAdres(Adres adres);
    abstract boolean deleteAdres(int AdresID);
    
    abstract boolean updateAdresType(int adresId, int adresType);
    abstract boolean updateAdresStraatnaam(int adresId, String straatnaam);
    abstract boolean updateAdresHuisnummer(int adresId, int huisnummer);
    abstract boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging);
    abstract boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging);
    abstract boolean updateAdresPostcode(int adresId, String postcode);
    abstract boolean updateAdresLand(int adresId, String land);
    
    
    
    
}
