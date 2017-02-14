/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 *
 * @author Frank
 */
public class AccountSQL implements AccountDAO {

    private static final Logger LOGGER = LogManager.getLogger(AccountMenu.class);
    
     private Connection accountconnectie;
    
    public AccountSQL(Connection connectie) {
        this.accountconnectie = connectie;
    }
    
    //aangepast 

    @Override
    public Account findAccountByID(int id) {
       
    LOGGER.debug("Account zoeken. Zoekterm: accountId {}", id);   
        
       String query = "SELECT * FROM accounts WHERE accounts_id = '" + id + "'";
        Account account = new Account();
        try (
        		PreparedStatement stmt = accountconnectie.prepareStatement(query);
        		ResultSet resultset = stmt.executeQuery();){
        
            ///geef alle data naar java toe met de gevonden voornaam.
            if (resultset.next()) {
                
                
                
                account.setAccountId(resultset.getInt("accounts_id"));
                account.setType(resultset.getInt("accounts_type"));
                account.setWachtwoord(resultset.getString("wachtwoord"));
                
                
                
        
             }//einde if
        } //einde try
        catch (SQLException ex2) {
            LOGGER.error("Het volgende ging mis bij zoeken account op accountId: {}", ex2.getMessage());
        }
        if (account.getAccountId() == 0) {
            LOGGER.error("Er is geen matchend accountId gevonden.");
        }
        LOGGER.debug("Zoekresultaat account op accountId: {}", account.toString());
        return account;    
    } 

    @Override
    public Account createAccount(int type, String wachtwoord) {
        
        Account account = new Account();
        
      LOGGER.debug("Aanmaken account met type {} en wachtwoord.", type);
        
      String query = "INSERT INTO accounts (accounts_type, wachtwoord) VALUES (?, ? ) ";
       
      String query2 = "SELECT * FROM accounts WHERE accounts_type = ' "+ type +  "' AND wachtwoord = '"+ wachtwoord + " ' ";
      
      
        try (PreparedStatement stmt = accountconnectie.prepareStatement(query);
             PreparedStatement stmt2 = accountconnectie.prepareStatement(query2)){	
            
            stmt.setInt(1, type);
            stmt.setString(2, wachtwoord);
            
           // ResultSet resultset =
         
        stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
        
        while (rs.next()){
            
      System.out.println(rs.getInt("accounts_id"));
                account.setAccountId(rs.getInt("accounts_id"));
                account.setType(rs.getInt("accounts_type"));
                account.setWachtwoord(rs.getString("wachtwoord"));
        }
        LOGGER.info("Account gegevens zijn succesvol aangemaakt.");
         
        }
        catch (SQLException ex) {
            LOGGER.debug("Het volgende ging mis bij het aanmaken van een account: {}", ex.getMessage());
        }
        finally {
            //rs.close(); // moet ResultSet buiten try block geinitialiseerd worden?
        }
        LOGGER.debug("Resultaat aanmaken account: {}", account.toString());
         
        return account;
        }
         

    @Override
    public boolean deleteAccount(int id) {
       
         
       // String query = "DELETE FROM klant_has_adres (=NAAM TUSSEN TABLE! ) WHERE Klant_klant_id (NAAM=FK ALS DIE ER IS) = " + klant.getKlantID(); 
       LOGGER.debug("Account met id {} verwijderen", id);
        String query = "DELETE FROM accounts WHERE accounts_id = " + id;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = accountconnectie.prepareStatement(query)
        	)
                {
        	
        
            stmt2.executeUpdate();
          
            
            System.out.println("Account gegevens zijn succesvol verwijderd");
            LOGGER.info("Account gegevens zijn succesvol verwijderd");
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging verkeerd bij het verwijderen van de account: {}", ex.getMessage());
              return false;  
        } 
        
        return true;
        
        
        
    }

    @Override
    public boolean updateAccountType(int id, int type) {
        
        LOGGER.debug("Account met id {} wijzigen naar type {}", id, type)        ;
            String regel = " UPDATE accounts SET accounts_type = ? WHERE accounts_id = ? " ;
          
                    
                    
       try (PreparedStatement stmt = accountconnectie.prepareStatement(regel)){
       stmt.setInt(1, type);
       stmt.setInt(2, id);       
               
          
       stmt.executeUpdate();
       
       
         
        System.out.println("Account type is succesvol veranderd");
        LOGGER.info("Account type is succesvol veranderd");
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging mis bij het aanpassen van het accounttype: {}", ex.getMessage());
              return false;  
        } 
        
        return true;
        
    }
    
     @Override
    public boolean updateAccountWachtwoord(int id, String wachtwoord) {
        
       LOGGER.debug("Wachtwoord van account {} wijzigen.", id) ;
        
        
       try (PreparedStatement stmt = accountconnectie.prepareStatement(
       "UPDATE   accounts "+
       "SET wachtwoord = ? " +
       "WHERE accounts_id = ?   ")){
        stmt.setString(1, wachtwoord);
        stmt.setInt(2, id);
        
         stmt.executeUpdate();
         
        System.out.println("Account wachtwoord is succesvol veranderd");
        LOGGER.info("Account wachtwoord is succesvol veranderd");
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging mis bij het aanpassen van het wachtwoord: {}", ex.getMessage());
              return false;  
        } 
        
        return true;
        
    }
    
    
    
    
    

    @Override
        public boolean loginCheckAccount(int accountId, String wachtwoord) {
            
            boolean correct;
            
            String query = "SELECT * FROM accounts WHERE accounts_id = ? AND wachtwoord = ?";
            
            LOGGER.debug("Controleer wachtwoord en id van accountId: {}", accountId);
            
    try (PreparedStatement stmt = accountconnectie.prepareStatement(query)){
        stmt.setInt(1, accountId);
        stmt.setString(2, wachtwoord);
        ResultSet rs = stmt.executeQuery();
        
        
        
        if(rs.next()){correct=true;} 
        else { correct = false;        
        }
        LOGGER.info("Het inloggen is gelukt.");
            } catch (SQLException ex) { 
                correct = false;
                LOGGER.error("Het volgende ging mis bij het controleren van het wachtwoord: {}", ex.getMessage());
                  }
    return correct;
}
    
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
        
        
        
        
        
        
    
    
    
    
    
    
    
    

    
    
    
    
    
    

