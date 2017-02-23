/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.medewerker;

/**
 *
 * @author Frank
 */
public class Medewerker {
    
    private int medewerker_id,medewerker_account_id;
    private String email,voornaam,tussenvoegsel,achternaam;
    
   public void setMedewerkerID(int mid){
        
        this.medewerker_id = mid;
        
    }
    
   public int getMedewerkerID(){
       return medewerker_id;
   }
   
   public void setMedewerkerAccountID(int aid){
        
        this.medewerker_account_id = aid;
        
    }
    
   public int getMedewerkerAccountID(){
       return medewerker_account_id;
   }
   
    public void setMedewerkerEmail(String email){
        
        this.email = email;
        
    }
    
   public String getMedewerkerEmail(){
       return email;
   } 
    public void setMedewerkerVoornaam(String voornaam){
        
        this.voornaam = voornaam;
        
    }
    
   public String getMedewerkerVoornaam(){
       return voornaam;
   }
   
    public void setMedewerkerAchternaam(String achternaam){
        
        this.achternaam = achternaam;
        
    }
    
   public String getMedewerkerAchternaam(){
       return achternaam;
   }
    
    public void setMedewerkerTussenvoegsel(String tussenvoegsel){
        
        this.tussenvoegsel = tussenvoegsel;
        
    }
    
   public String getMedewerkerTussenvoegsel(){
       return tussenvoegsel;
   }
   
   
   
   public void getView(Medewerker medewerker){
       System.out.println(" medewerker id : " + this.medewerker_id + " account id: " +this.medewerker_account_id+ " emai: "+this.email+" naam : " +this.voornaam  + " "+this.tussenvoegsel+" "+this.achternaam);
   }
   
    public String getView2(){
       String view = medewerker_id + "\t\t" +
                         medewerker_account_id + "\t\t" +
                         email + "\t\t" +
                         voornaam + "\t\t" +
                         tussenvoegsel + "\t\t" +
                         achternaam ;
               return view;                  
    }
    
}
