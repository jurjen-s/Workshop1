/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;

import java.util.List;


public class Account {
    
    
    private int accountId;
    
    private String wachtwoord, type;
    
    
    public int getAccountId() {
        return accountId;
    }
    
    public String getType(){
        return type;
    }
    public String getWachtwoord(){
        return wachtwoord;
    }
    
     public void setWachtwoord(String w8w) {
        wachtwoord = w8w;
     }
     
     public void setType (String type){
         this.type = type;
     }
     
    public void setAccountId (int aid){
        accountId = aid;
    }
    
    public void setAccountALL( int aid , String w8w , String type ){
        accountId= aid;
        wachtwoord = w8w;
        this.type = type;
        
    }
    
    
    
}

