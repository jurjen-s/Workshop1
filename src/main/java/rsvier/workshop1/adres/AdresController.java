/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.adres;

import java.sql.Connection;
import java.util.List;
import rsvier.workshop1.db.SQLConnection;

/**
 *
 * @author jurjen
 */
public class AdresController {
    
    
    AdresDAOfactory factory = new AdresDAOfactory();
    
    
    
    
    private Connection sqlConnectie = new SQLConnection().getSQLConnection();
    private AdresDAO adresDAO = new AdresMySQL(sqlConnectie);
    
    
    
    Adres findAdresById(int adresId) {
        return (factory.getAdresDAO()).findAdresById(adresId);
    }
    
    List findAdresByType(int adresType) {
        return (factory.getAdresDAO()).findAdresByType(adresType);
    }
    List findAdresByKlantId(int klantId) {
        return (factory.getAdresDAO()).findAdresByKlantId(klantId);
    }
    List findAdresByPostcode(String postcode) {
        return (factory.getAdresDAO()).findAdresByPostcode(postcode);
    }
    List findAdresByLand(String land) {
        return (factory.getAdresDAO()).findAdresByLand(land);
    }
    
    Adres toevoegenAdres(Adres adres) {
        return (factory.getAdresDAO()).toevoegenAdres(adres);
    }
    boolean deleteAdres(int AdresId) {
        return (factory.getAdresDAO()).deleteAdres(AdresId);
    }
    
    boolean updateAdresType(int adresId, int adresType) {
        return (factory.getAdresDAO()).updateAdresType(adresId, adresType);
    }
    boolean updateAdresStraatnaam(int adresId, String straatnaam) {
        return (factory.getAdresDAO()).updateAdresStraatnaam(adresId, straatnaam);
    }
    boolean updateAdresHuisnummer(int adresId, int huisnummer) {
        return (factory.getAdresDAO()).updateAdresHuisnummer(adresId, huisnummer);
    }
    boolean updateAdresHeeftHuisnrToevoeging(int adresId, int heeftHuisnrToevoeging) {
        return (factory.getAdresDAO()).updateAdresHeeftHuisnrToevoeging(adresId, heeftHuisnrToevoeging);
    }
    boolean updateAdresHuisnrToevoeging(int adresId, String huisnrToevoeging) {
        return (factory.getAdresDAO()).updateAdresHuisnrToevoeging(adresId, huisnrToevoeging);
    }
    boolean updateAdresPostcode(int adresId, String postcode) {
        return (factory.getAdresDAO()).updateAdresPostcode(adresId, postcode);
    }
    boolean updateAdresLand(int adresId, String land) {
        return (factory.getAdresDAO()).updateAdresLand(adresId, land);
    }
}
