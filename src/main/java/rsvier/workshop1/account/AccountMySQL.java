/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1.account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mindrot.jbcrypt.BCrypt;
/**
 *
 * @author Frank
 */
public class AccountMySQL extends AccountSQL implements AccountDAO {
    
    private static final Logger LOGGER = LogManager.getLogger(AccountMenu.class);
    
    private Connection accountconnectie;
    public AccountMySQL(Connection connectie) {
        
        this.accountconnectie = connectie;
    }

   
    
    @Override
    public Account findAccountByID(int id) {
       
    LOGGER.debug("Account zoeken. Zoekterm: accountId {}", id);   
        
     
     
     
         
     
       String query = "SELECT * FROM accounts WHERE accounts_id = ?";
        Account account = new Account();
        try (
          PreparedStatement stmt = accountconnectie.prepareStatement(query)) {
          stmt.setInt(1, id)  ;
          ResultSet resultset = stmt.executeQuery();
        
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
        
         LOGGER.debug("In inputs waren wachtwoord: {} , en type {} ", wachtwoord, type);
        
        Account account = new Account();
        int workload = giveWorkload();
        
        
       // public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
                
                
                 LOGGER.debug("In inputs waren workload: {} , en salt {} ", workload, salt);
                
                String hashed_password = BCrypt.hashpw(wachtwoord, salt);
		
		LOGGER.debug("In outputs waren hashed_password: {} ", hashed_password);
        
        
        
        
        
        
        
      LOGGER.debug("Aanmaken account met type {} en wachtwoord{} en salt {}.", type, wachtwoord , salt);
        
      String query = "INSERT INTO accounts (accounts_type, wachtwoord) VALUES (?, ?  ) ";
       
      String query2 = "SELECT * FROM accounts WHERE accounts_type = ? AND wachtwoord = ?";
      
      
        try (PreparedStatement stmt = accountconnectie.prepareStatement(query);
             PreparedStatement stmt2 = accountconnectie.prepareStatement(query2)){	
            
            stmt.setInt(1, type);
            stmt.setString(2, hashed_password);
           
            stmt2.setInt(1, type);
            stmt2.setString(2, hashed_password);
            
           // ResultSet resultset =
         
        stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
        
        while (rs.next()){
            
      
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
        String query = "DELETE FROM accounts WHERE accounts_id = ?";        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = accountconnectie.prepareStatement(query)) {
            stmt2.setInt(1, id);
        	
        
            stmt2.executeUpdate();
            LOGGER.info("Account gegevens zijn succesvol verwijderd");
            return true;
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging verkeerd bij het verwijderen van de account: {}", ex.getMessage());
              return false;  
        } 
        
        
        
        
        
    }

    @Override
    public boolean updateAccountType(int id, int type) {
        
        LOGGER.debug("Account met id {} wijzigen naar type {}", id, type)        ;
            String regel = " UPDATE accounts SET accounts_type = ? WHERE accounts_id = ? " ;
          
                    
                    
       try (PreparedStatement stmt = accountconnectie.prepareStatement(regel))  {
       stmt.setInt(1, type);
       stmt.setInt(2, id);       
               
          
       stmt.executeUpdate();
       
       
         
        
        LOGGER.info("Account type is succesvol veranderd");
        return true;
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging mis bij het aanpassen van het accounttype: {}", ex.getMessage());
              return false;  
        } 
        
        
        
    }
    
     @Override
    public boolean updateAccountWachtwoord(int id, String wachtwoord) {
        
       LOGGER.debug("Wachtwoord van account {} wijzigen.", id) ;
        
       int workload = giveWorkload();
       
       String salt = BCrypt.gensalt(workload);
                
                
                 LOGGER.debug("In inputs waren workload: {} , en salt {} ", workload, salt);
                
                String wachtwoordh = BCrypt.hashpw(wachtwoord, salt);
		
		LOGGER.debug("In outputs waren hashed_password: {} ", wachtwoordh);
       
       
       
       
       
       
        
       try (PreparedStatement stmt = accountconnectie.prepareStatement(
       "UPDATE   accounts "+
       "SET wachtwoord = ? " +
       "WHERE accounts_id = ?   ")){
        stmt.setString(1, wachtwoordh);
        stmt.setInt(2, id);
        
         stmt.executeUpdate();
         
        LOGGER.info("Account wachtwoord is succesvol veranderd");
        return true;
        }
        catch (SQLException ex){
         LOGGER.error("Het volgende ging mis bij het aanpassen van het wachtwoord: {}", ex.getMessage());
              return false;  
        } 
        
        
        
    }
    
    @Override
    public boolean loginCheckAccount(int accountId, String wachtwoord) {
        
        
        
        String queryh = "SELECT * FROM accounts WHERE accounts_id = ?";
        
        LOGGER.debug("Haal hashedwachtwoord terug via id van accountId: {}", accountId);
       
        
        try (PreparedStatement stmt0 = accountconnectie.prepareStatement(queryh)){
             boolean test = false;
            stmt0.setInt(1, accountId);
            ResultSet rs1 = stmt0.executeQuery();
            if (rs1.next()){
                
                String hashedwachtwoord = rs1.getString("wachtwoord");
                
                //Dit is een boolean goed is true, fout is false.
                test = checkPassword( wachtwoord,hashedwachtwoord);
                
            }
            return test;
        }         
            catch(SQLException ex0){
                LOGGER.error("Het volgende ging mis bij het controleren van het zout: {}", ex0.getMessage());
                return false;
             }
        
    }
    
        
        /*
        oude code
        
        String query = "SELECT * FROM accounts WHERE accounts_id = ? AND wachtwoord = ?";
        LOGGER.debug("Controleer wachtwoord en id van accountId: {}", accountId);
        try (PreparedStatement stmt = accountconnectie.prepareStatement(query)) {
        stmt.setInt(1, accountId);
        stmt.setString(2, wachtwoord);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            LOGGER.info("Het inloggen is gelukt.");
            return true;
        } else { 
            return false;        
        }
        } catch (SQLException ex) { 
        LOGGER.error("Het volgende ging mis bij het controleren van het wachtwoord: {}", ex.getMessage());
        return false;
        }
*/
    

    
    
    public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}
    
    
    
    
    public static int giveWorkload(){
        int workloadnumber = 13;
        return workloadnumber;
    }
    
    
    
    
}
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
        
        
        
        
        
        
    
    
    
    
    
    
    
    

    
    
    
    
    
    

