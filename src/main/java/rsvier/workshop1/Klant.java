/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;
 

   


public class Klant  {

    
    //PRIVATE
    
private int klanten_id, telefoonnummer,FK_accounts_id,FK_adressen_klant,FK_adressen_type, heeft_tussenvoegsel;
        //Bezorghuisnummer, Factuurhuisnummer, idMedewerker;
private String Land, voornaam,tussenvoegsel, achternaam;
        //BezorgPostcode,FactuurPostcode,BezorgHuisnummerToevoeging, FactuurHuisnummerToevoeging;



public void setALL( String vnaam, int heeft, String tv, String anaam, int tel,int FKAI, int FKAK, int FKAT){
        //int BHnr, String BHnrT, String BPc, String FBPc, int FHnr, String FHnrT, String L){

this.voornaam = vnaam;
this.heeft_tussenvoegsel= heeft;
this.tussenvoegsel = tv;
this.achternaam = anaam;
this.telefoonnummer = tel;
this.FK_accounts_id = FKAI;
this.FK_adressen_klant = FKAK;
this.FK_adressen_type = FKAT;
//this.Bezorghuisnummer = BHnr;
//this.BezorgHuisnummerToevoeging = BHnrT;
//this.BezorgPostcode = BPc;
//this.FactuurPostcode = FBPc;
//this.Factuurhuisnummer = FHnr;
//this.FactuurHuisnummerToevoeging = FHnrT;
//this.Land = L;
System.out.println(klanten_id + voornaam + tussenvoegsel + achternaam + telefoonnummer + FK_accounts_id + " " + FK_adressen_klant + " "+ FK_adressen_type);
        //Bezorghuisnummer + BezorgHuisnummerToevoeging + BezorgPostcode + FactuurPostcode + Factuurhuisnummer +FactuurHuisnummerToevoeging + Land);
}


public void getAll (){

System.out.println(klanten_id + voornaam + tussenvoegsel + achternaam + telefoonnummer + FK_accounts_id + " " + FK_adressen_klant + " "+ FK_adressen_type);

}



    public int getKlantenID() {
        return klanten_id;
    }

    public void setKlantenID(int klantID) {
        this.klanten_id = klantID;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

   /**
    public String getBezorgPostcode() {
        return BezorgPostcode;
    }

    public void setBezorgPostcode(String postcode) {
        this.BezorgPostcode = postcode;
    }
    
    public String getFactuurPostcode() {
        return FactuurPostcode;
    }

    public void setFactuurPostcode(String factuurcode) {
        this.FactuurPostcode = factuurcode;
    }
    
    public String getBezorgHuisnummertoevoeging() {
        return BezorgHuisnummerToevoeging;
    }

    public void setBezorgHuisnummertoevoeging(String BHtoevoeging) {
        this.BezorgHuisnummerToevoeging = BHtoevoeging;
    }
    
    public String getFactuurHuisnummertoevoeging() {
        return FactuurHuisnummerToevoeging;
    }

    public void setFactuurHuisnummertoevoeging(String FHtoevoeging) {
        this.FactuurHuisnummerToevoeging = FHtoevoeging;
    }

*/
    
    public int getTelefoonnummer() {
        return telefoonnummer;
    }

    public void setTelefoonnummer(int telefoonnummer) {
        this.telefoonnummer = telefoonnummer;
    }
    
    public int getFKaccountsID() {
        return FK_accounts_id;
    }

    public void setFKaccountsID(int FKAI) {
        this.FK_accounts_id = FKAI;
    }
    
     public int getFKadressenKlant() {
        return FK_adressen_klant;
    }

    public void setFKadressenKlant(int FKAK) {
        this.FK_adressen_klant = FKAK;
    }
    
    public int getFKadressenType() {
        return FK_adressen_type;
    }

    public void setFKadressenType(int FKAT) {
        this.FK_adressen_type = FKAT;
    }
    
    /**
    public int getFactuurhuisnummer() {
        return Factuurhuisnummer;
    }

    public void setFactuurhuisnummer(int factuurhuisnummer) {
        this.Factuurhuisnummer = factuurhuisnummer;
    }
  
     public String getLand() {
        return Land;
    }

    public void setLand(String land) {
        this.Land = land;
    }
    
    public int getMedewerkerID() {
        return idMedewerker;
    }

    public void setMedewerkerID(int medewerkerint) {
        this.idMedewerker = medewerkerint;
    }
    
    */
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        
        return "Klant{" + "klantID=" + klanten_id + ", voornaam=" + voornaam + 
                ", achternaam=" + achternaam + ", tussenvoegsel=" + tussenvoegsel + ", telefoonnummer=" + telefoonnummer + '}';
    }
    
    
    
    
    //einde clas Klant
    
    
    
    
}
    
    
    
    
    
    
    
    
    
    
    
    

