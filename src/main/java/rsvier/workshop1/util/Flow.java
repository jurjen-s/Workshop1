/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.util;

import rsvier.workshop1.klant.KlantMenu;
import rsvier.workshop1.adres.AdresMenu;

/**
 *
 * @author jurjen
 */
public class Flow {
    
void Flow() {

// Wat moet de app doen?
//(InDB = aanmaken in database)
//(Java = aanmaken in Java als object van class)
//1: Producten
    //1.1: Product bestellen
        //Lege BestellingInDb 
            //geeft bestellingId voor bestelregelId
        //Overzicht geven van producten, soort, prijs
        //Prompt: Te bestellen productID opgegeven
        //Gewenst aantal van dat product opgegeven 
            //controleren of er genoeg voorraad is
        //Lege JavaBestelregel 
        //JavaBestelregel aanvullen met bestellingId, productId en hoeveelheid
        //Prompt: nog een product bestellen?
            //Ja > terug naar stap 2: overzicht producten geven
            //Nee > laat overzicht bestelling zien
        //Controleer of bestelling gekoppeld is aan adres
            //Ja > laat adres zien en vraag of dit het adres is waar bezorgd moet worden
            //Nee > controleer of er wel een adres is met opgegeven klantId
                //Ja > vraag of dit adres gebruikt kan worden voor bezorging
                //Nee > vraag om adres aan te maken
                    //Waar wilt u de bestelling laten bezorgen?
            //Wilt u de factuur naar hetzelfde adres sturen?
        //Maak factuur aan        
    //1.2: Product zoeken
        //Opties voor zoeken
    //1.3: Productgegevens wijzigen
        //Opties voor updaten
    //1.4: Product verwijderen
//2: Klanten
    KlantMenu klantmenu = new KlantMenu();
    //Prompt: wat wilt u doen? 1: aanmaken, 2: zoeken, 3: wijzigen, 4: verwijderen
    //2.1: Klant aanmaken
        //Heeft klant al account?
            //Ja > verkrijg accountId, dan naar klant aanmaken
            //Nee > Account aanmaken, dan naar klant aanmaken
                // Geeft accountId terug
        //Klant aanmaken
        klantmenu.klantenmenuT();
            //JavaKlant > Gegevens klant invullen
                //JavaAdres > Gegevens adres invullen
                AdresMenu adresmenu = new AdresMenu();
                adresmenu.adressenmenuTA(); //voegt adres ook al toe aan Db
                //AdresInDb
            //KlantInDb
    //2.2: Klant zoeken
        //Opties voor zoeken
    //2.3: Klantgegevens wijzigen
        //Opties voor updaten account, updaten klant, updaten adres
    //2.4: Klant verwijderen
//3: Bestellingen
    //3.1: Bestelling zoeken
        //Opties voor zoeken
    //3.2: Bestelling wijzigen
        //Optie om product uit bestelling te halen
    //3.3: Bestelling annuleren (= verwijderen)
}
/* Checks:
Vul klantId in: 6
> Check of klantId bestaat
False > createKlant
True > check of adresId bestaat
False > createAdres
True > vul adresId in: 2
*/
        
}