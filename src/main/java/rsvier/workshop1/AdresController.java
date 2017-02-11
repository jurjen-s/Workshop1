/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author jurjen
 */
public class AdresController {
    
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private AdresDAO adresDAO = new AdresSQL(sqlConnectie);
    
    Adres findAdresById(int adresId) {
        return adresDAO.findAdresById(adresId);
    }
    List findAdresByType(int adresType) {
        return adresDAO.findAdresByType(adresType);
    }
    List findAdresByKlantId(int klantId) {
        return adresDAO.findAdresByKlantId(klantId);
    }
    List findAdresByPostcode(String postcode) {
        return adresDAO.findAdresByPostcode(postcode);
    }
    List findAdresByLand(String land) {
        return adresDAO.findAdresByLand(land);
    }
    
    Adres toevoegenAdres(Adres adres) {
        return adresDAO.toevoegenAdres(adres);
    }
    boolean deleteAdres(int AdresId) {
        return adresDAO.deleteAdres(AdresId);
    }
    
    boolean updateAdresType(int adresId, int adresType) {
        return adresDAO.updateAdresType(adresId, adresType);
    }
    boolean updateAdresStraatnaam(int adresId, String straatnaam) {
        return adresDAO.updateAdresStraatnaam(adresId, straatnaam);
    }
    boolean updateAdresHuisnummer(int adresId, int huisnummer) {
        return adresDAO.updateAdresHuisnummer(adresId, huisnummer);
    }
    boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging) {
        return adresDAO.updateAdresHeeftHuisnrToevoeging(adresId, heeftHuisnrToevoeging);
    }
    boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging) {
        return adresDAO.updateAdresHuisnrToevoeging(adresId, huisnrToevoeging);
    }
    boolean updateAdresPostcode(int adresId, String postcode) {
        return adresDAO.updateAdresPostcode(adresId, postcode);
    }
    boolean updateAdresLand(int adresId, String land) {
        return adresDAO.updateAdresLand(adresId, land);
    }
}
