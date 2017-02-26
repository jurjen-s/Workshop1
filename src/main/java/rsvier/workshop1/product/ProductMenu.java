/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.product;

import java.math.BigDecimal;
import java.util.List;
import rsvier.workshop1.Controller;
import rsvier.workshop1.Menu;
import rsvier.workshop1.util.TextIO;
import rsvier.workshop1.bestelling.BestellingController;
import rsvier.workshop1.bestelling.Bestelling;
import rsvier.workshop1.bestelregel.BestelregelController;
import rsvier.workshop1.bestelregel.Bestelregel;

/**
 *
 * @author jurjen
 */

public class ProductMenu {

    private ProductController productController = new ProductController();
    private Controller controller = new Controller();
    
    public void  productmenu(){
   
        System.out.println("===============================");
        System.out.println("Welkom in het productmenu ");
        System.out.println("Wat wilt u doen?");
        
        System.out.println(" 1: Zoek product op productId.");
        System.out.println(" 2: Zoek product op soort."); 
        System.out.println(" 3: Zoek product op prijs.");
        System.out.println(" 4: Zoek product op voorraad.");
        System.out.println(" 5: Nieuw product toevoegen.");
        //System.out.println(" 6: Verander PRODUCT omschrijving met behulp van product id.");
        System.out.println(" 6: Soort product veranderen.");
        System.out.println(" 7: Prijs product veranderen.");
        System.out.println(" 8: Voorraad product veranderen.");
        System.out.println(" 9: Product verwijderen.");
        System.out.println("10: Product bestellen.");
        System.out.println(" 0: Terug naar het hoofdmenu.");
        System.out.println("===============================");
        System.out.print("Geef uw keuze: ");

        int keuze = TextIO.getlnInt();

        switch (keuze){
                case 1: System.out.println(" 1 Doorzoek op productID"); productmenuDoPi(); break;
                case 2: System.out.println(" 2 Doorzoek op SOORT"); productmenuDoS(); break;
                case 3: System.out.println(" 3 Doorzoek op PRIJS"); productmenuDoP();    break;
                case 4: System.out.println(" 4 Doorzoek op VOORRAAD");  productmenuDoV(); break;
                case 5: System.out.println("----------------------------");  productmenuTP(); break;
                //case 6: System.out.println(" 6 Verander Product Omschrijving met behulp van product id"); productmenuVPO(); break;
                case 6: System.out.println(" 7 Verander Soort product met behulp van product id"); productmenuVPS(); break;
                case 7: System.out.println("----------------------------"); productmenuVPP() ;break;
                case 8: System.out.println(" 9 Verander Voorraad product met behulp van product id");productmenuVPV() ; break;
                case 9: System.out.println(" 10 Verwijder product met behulp van product id"); productmenuDELETE() ; break;
                case 10: System.out.println("----------------------------"); productmenuBestel(); break;
                case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
                default: System.out.println("Verkeerde invoer."); productmenu();
        }
    }
    
    public  void productmenuDoPi(){

        System.out.println("U gaat een product zoeken op ID.");
        System.out.println("Vul ID in en druk op enter.");
        int productId = TextIO.getlnInt();
        System.out.println(productController.findProductById(productId).toString());
        //Product gevondenProduct = productController.findProductById(productId);
        //gevondenProduct.toString();
        productmenu();
        
    }
    
    public  void productmenuDoS(){

        System.out.println("U gaat een product zoeken op Soort.");
        System.out.println("Vul Soort als tekst in en druk op enter.");
        String soort = TextIO.getln();
        List<Product> zoekresultaat = productController.findProductBySoort(soort);
        for (Product product:zoekresultaat) {
           System.out.println( product.toString());
        }
        productmenu();
        
    }
    
    public  void productmenuDoP(){

        System.out.println("U gaat een product zoeken op Prijs.");
        System.out.println("Vul prijs in en druk op enter.");
        BigDecimal prijs = new BigDecimal(TextIO.getln());
        List<Product> zoekresultaat = productController.findProductByPrijs(prijs);
        for (Product product:zoekresultaat) {
           System.out.println( product.toString());
        }
        productmenu();
        
    }
    
    public  void productmenuDoV(){

        System.out.println("U gaat een product zoeken op Voorraad.");
        System.out.println("Vul het voorraad in en druk op enter.");
        int voorraad = TextIO.getlnInt();
        List<Product> zoekresultaat = productController.findProductByVoorraad(voorraad);
        for (Product product:zoekresultaat) {
            System.out.println(product.toString());
        }
        productmenu();
    }
    public  void productmenuTP(){

        System.out.println("U gaat een product toevoegen.");
        //System.out.println("Vul de omschrijving in en druk op enter.");
        String omschrijving = "";
        System.out.print("Voer de productsoort in: ");
        String soort = TextIO.getln();
        System.out.print("Voer de productprijs in: ");
        BigDecimal prijs = new BigDecimal(TextIO.getln());
        System.out.print("Voer de productvoorraad in: ");
        int voorraad = TextIO.getlnInt();
        Product product = new Product.ProductBuilder()
                                     .soort(soort)
                                     .omschrijving(omschrijving)
                                     .prijs(prijs)
                                     .voorraad(voorraad)
                                     .build();
        if (productController.toevoegenProduct(product) == true) {
            System.out.println("Het toevoegen is gelukt.");
            System.out.println("Dit zijn de gegevens van het aangemaakte product: ");
            System.out.println(product.toString());
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        
        productmenu();

    }
    public  void productmenuVPO(){

        System.out.println("U gaat een product omschrijving veranderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        System.out.println("Vul hierna de nieuwe omschrijving in en druk enter.");
        String omschrijving = TextIO.getln();
        if (productController.updateProductOmschrijving(productId,omschrijving) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();
        
    }
    
    public  void productmenuVPS(){

        System.out.println("U gaat een product soort veranderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        System.out.println("Vul hierna het nieuwe soort in en druk enter.");
        String soort = TextIO.getln();
        if (productController.updateProductSoort(productId,soort) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();
        
    }
    
    public  void productmenuVPP() {

        System.out.println("U gaat een productprijs veranderen.");
        //Controleren op FK constraints
        int productId = -1;
        do {
            System.out.print("Voer het productId in: ");
            productId = TextIO.getlnInt();
        } while (!controller.existsProductId(productId));   
        System.out.print("Voer de nieuwe prijs in: ");
        BigDecimal prijs = new BigDecimal(0);
        try {
            prijs = new BigDecimal(TextIO.getln());
        } catch (NumberFormatException ex) {
            System.out.println("Ongeldige invoer, probeer opnieuw.");
            System.out.println("-----------------------");
            productmenuVPP();
        }
        if (productController.updateProductPrijs(productId,prijs) == true) {
            System.out.println("Het aanpassen is gelukt.");
        } else {
            System.out.println("Het aanpassen is mislukt.");
        }
        productmenu();
    }
    public  void productmenuVPV(){

        System.out.println("U gaat een product voorraad veranderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        System.out.println("Vul hierna de nieuwe voorraad in en druk enter.");
        int voorraad = TextIO.getlnInt();
        if (productController.updateProductVoorraad(productId,voorraad) == true) {
            System.out.println("Het aanpassen is gelukt.");
        } else {
            System.out.println("Het aanpassen is mislukt.");
        }
        productmenu();
    }
    public  void productmenuDELETE(){

        System.out.println("U gaat een product verwijderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        if (productController.deleteProduct(productId) == true) {
            System.out.println("Het verwijderen is gelukt.");
        } else {
            System.out.println("Het verwijderen is mislukt.");
        }
        productmenu();
    }

    private void productmenuBestel() {
        System.out.println("U wilt een product bestellen.");
        //Controleren op FK constraints
        int klantId = -1;
        do {
            System.out.print("Voor welke klant wilt u het product bestellen?\n Geef het klantId of 0 om te annuleren: ");
            klantId = TextIO.getlnInt();
            if (klantId == 0) {
                productmenu();
            }
        } while (!controller.existsKlantId(klantId));
        //Controleren op FK constraints
        int adresId = -1;
        do {
            System.out.print("Naar welk adres wordt de bestelling verstuurd?\n Geef het adresId of 0 om te annuleren: ");
            adresId = TextIO.getlnInt();
            if (adresId == 0) {
                productmenu();
            }
        } while (!controller.existsAdresId(adresId));
        // Maak dummy bestelling om bestellingId te krijgen
        Bestelling dummyBestelling = new Bestelling();
        dummyBestelling.setKlantId(klantId);
        dummyBestelling.setAdresId(adresId);
        BestellingController bControl = new BestellingController();
        Bestelling bestelling = bControl.toevoegenBestelling(dummyBestelling);
        int bestellingId = 0;
        boolean doorgaan = true;
        while (doorgaan) {
            //Controleren op FK constraints
            int productId = -1;
            do {
                System.out.print("Welk product wilt u bestellen?\n Geef het productId of 0 om te annuleren: ");
                productId = TextIO.getlnInt();
                if (productId == 0) {
                    productmenu();
                }
            } while (!controller.existsProductId(productId));        
            System.out.print("Hoeveel stuks wilt u hiervan bestellen? ");
            int hoeveelheid = TextIO.getlnInt();       
            // Maak bestelregel met opgegeven product, hoeveelheid en verkregen bestellingId
            Bestelregel legeBestelregel = new Bestelregel();
            bestellingId = dummyBestelling.getBestellingId();            
            legeBestelregel.setBestellingId(bestellingId);
            legeBestelregel.setProductId(productId);
            legeBestelregel.setHoeveelheid(hoeveelheid);
            // Voeg bestelregel toe in db
            BestelregelController brControl = new BestelregelController();
            if (brControl.toevoegenBestelregel(legeBestelregel)) {
                bControl.updateBestelling(bestellingId);                    
                System.out.print("Het bestellen is gelukt. Wilt u nog een product aan de bestelling toevoegen? (1=ja, 0=nee) ");
                int antwoord = TextIO.getlnInt();
                if (antwoord == 1) {
                    doorgaan = true;
                } else if (antwoord == 0) {
                    doorgaan = false;
                }
                
            } else {
                System.out.println("Het bestellen is mislukt.");
                doorgaan = false;
                productmenu();
            }
        }
        System.out.println("De bestelling is aangemaakt met het ID: " + bestelling.getBestellingId());
        bControl.bekijkBestelling(bestellingId);
        productmenu();
    }
}