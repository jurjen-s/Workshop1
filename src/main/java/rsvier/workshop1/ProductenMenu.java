/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author jurjen
 */

public class ProductenMenu {

    private ProductController productController = new ProductController();
    
    public void  productmenu(){
   
        System.out.println("Welkom in het productmenu ");
        System.out.println("Wat wilt u doen?");
        System.out.println("=========================");
        System.out.println("Doorzoek producten");
        System.out.println("-------------------------");
        System.out.println("1: Doorzoek op PRODUCT ID");
        System.out.println("2: Doorzoek op SOORT."); 
        System.out.println("3: Doorzoek op PRIJS.");
        System.out.println("4: Doorzoek op VOORRAAD.");
        System.out.println("5: Toevoegen PRODUCT.");
        System.out.println("6: Verander PRODUCT omschrijving met behulp van product id.");
        System.out.println("7: Verander SOORT product met behulp van product id.");
        System.out.println("8: Verander PRIJS product met behulp van product id.");
        System.out.println("9: Verander VOORRAAD product met behulp van product id.");
        System.out.println("10: VERWIJDER product met behulp van product id.");
        System.out.println("0: Terug naar hoofdmenu.");
        System.out.println("=========================");
        System.out.println("Geef uw keuze : ");

        int keuze = TextIO.getlnInt();

        switch (keuze){
                case 1: System.out.println(" 1 Doorzoek op productID"); productmenuDoPi(); break;
                case 2: System.out.println(" 2 Doorzoek op SOORT"); productmenuDoS(); break;
                case 3: System.out.println(" 3 Doorzoek op PRIJS"); productmenuDoP();    break;
                case 4: System.out.println(" 4 Doorzoek op VOORRAAD");  productmenuDoV(); break;
                case 5: System.out.println(" 5 Toevoegen Product ");  productmenuTP(); break;
                case 6: System.out.println(" 6 Verander Product Omschrijving met behulp van product id"); productmenuVPO(); break;
                case 7: System.out.println(" 7 Verander Soort product met behulp van product id"); productmenuVPS(); break;
                case 8: System.out.println(" 8 Verander Prijs product met behulp van product id"); productmenuVPP() ;break;
                case 9: System.out.println(" 9 Verander Voorraad product met behulp van product id");productmenu() ; break;
                case 10: System.out.println(" 10 Verwijder product met behulp van product id"); productmenu() ; break;
                case 0: Menu menu = new Menu(); menu.hoofdmenu(); break;
                default: System.out.println("Verkeerde invoer."); productmenu();
        }
    }
    
    public  void productmenuDoPi(){

        System.out.println("U gaat een product zoeken op ID.");
        System.out.println("Vul ID in en druk op enter.");
        int productId = TextIO.getlnInt();
        (productController.findProductById(productId)).toString();
        productmenu();
        
    }
    
    public  void productmenuDoS(){

        System.out.println("U gaat een product zoeken op Soort.");
        System.out.println("Vul Soort als tekst in en druk op enter.");
        String soort = TextIO.getln();
        List<Product> zoekresultaat = productController.findProductBySoort(soort);
        for (Product product:zoekresultaat) {
            product.toString();
        }
        productmenu();
        
    }
    
    public  void productmenuDoP(){

        System.out.println("U gaat een product zoeken op Prijs.");
        System.out.println("Vul prijs in en druk op enter.");
        BigDecimal prijs = new BigDecimal(TextIO.getln());
        List<Product> zoekresultaat = productController.findProductByPrijs(prijs);
        for (Product product:zoekresultaat) {
            product.toString();
        }
        productmenu();
        
    }
    
    public  void productmenuDoV(){

        System.out.println("U gaat een product zoeken op Voorraad.");
        System.out.println("Vul het voorraad in en druk op enter.");
        int voorraad = TextIO.getlnInt();
        List<Product> zoekresultaat = productController.findProductByVoorraad(voorraad);
        for (Product product:zoekresultaat) {
            product.toString();
        }
        productmenu();
    }
    public  void productmenuTP(){

        System.out.println("U gaat een product TOEVOEGEN.");
        System.out.println("Vul de omschrijving in en druk op enter.");
        String omschrijving = TextIO.getln();
        System.out.println("Vul het soort in en druk op enter");
        String soort = TextIO.getln();
        System.out.println("Vult de prijs van dit product in en druk op enter");
        BigDecimal prijs = new BigDecimal(TextIO.getln());
        System.out.println("Vul het aantal in de voorraad en druk op enter");
        int voorraad = TextIO.getlnInt();
        Product product = new Product.ProductBuilder()
                                     .soort(soort)
                                     .omschrijving(omschrijving)
                                     .prijs(prijs)
                                     .voorraad(voorraad)
                                     .build();
        if (productController.toevoegenProduct(product) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();

    }
    public  void productmenuVPO(){

        System.out.println("U gaat een product omschrijving veranderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        System.out.println("Vul hierna de omschrijving in en druk enter.");
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
        System.out.println("Vul hierna het soort in en druk enter.");
        String soort = TextIO.getln();
        if (productController.updateProductSoort(productId,soort) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();
        
    }
    
    public  void productmenuVPP(){

        System.out.println("U gaat een product prijs veranderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        System.out.println("Vul hierna de nieuwe prijs in en druk enter.");
        BigDecimal prijs = new BigDecimal(TextIO.getln());
        if (productController.updateProductPrijs(productId,prijs) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
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
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();
    }
    public  void productmenuDELETE(){

        System.out.println("U gaat een product verwijderen.");
        System.out.println("Vul het product id en dan enter.");
        int productId = TextIO.getlnInt();
        if (productController.deleteProduct(productId) == true) {
            System.out.println("Het toevoegen is gelukt.");
        } else {
            System.out.println("Het toevoegen is mislukt.");
        }
        productmenu();
    }
}