/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.util.List;


public class Account {
    
    
    private int accountId, type;
    
    private String wachtwoord ;
    
    
    public int getAccountId() {
        return accountId;
    }
    
    public int getType(){
        return type;
    }
    public String getWachtwoord(){
        return wachtwoord;
    }
    
     public void setWachtwoord(String w8w) {
        wachtwoord = w8w;
     }
     
     public void setType (int type){
         this.type = type;
     }
     
    public void setAccountId (int aid){
        accountId = aid;
    }
    
    public void setAccountALL( int aid , String w8w , int type ){
        accountId= aid;
        wachtwoord = w8w;
        this.type = type;
        
    }
    
    public void getALL (Account account ){
        
        System.out.println("id: " + this.accountId +" type : " + this.type + " wachtwoord: " + this.wachtwoord);
        
    }
    
    @Override 
    public String toString() {
        String account ="id: " + this.accountId +" type : " + this.type + " wachtwoord: " + this.wachtwoord;
        return account;
    }
    
    
}

