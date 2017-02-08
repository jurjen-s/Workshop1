/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package opdracht6test;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author Frank
 */
public class AccountSQL implements AccountDAO {

    
     private Connection accountconnectie;
    
    public AccountSQL(Connection connectie) {
        this.accountconnectie = connectie;
    }
    
    
    
    //aangepast 

    @Override
    public Account findAccountByID(int id) {
       
       
        
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
       	System.out.println(ex2.getMessage());
        }
        
        return account;    
    } 

    @Override
    public Account createAccount(int type, String wachtwoord) {
        
        Account account = new Account();
        
        
        
      String query = "INSERT INTO accounts (accounts_type, wachtwoord) VALUES (?, ? ) ";
       
      String query2 = "SELECT * FROM accounts WHERE accounts_type = ' "+ type +  "' AND wachtwoord = '"+ wachtwoord + " ' ";
      
      
        try (PreparedStatement stmt = accountconnectie.prepareStatement(query);
             PreparedStatement stmt2 = accountconnectie.prepareStatement(query2)){	
            
            stmt.setInt(1, type);
            stmt.setString(2, wachtwoord);
            
           // ResultSet resultset =
         
        int operatie = stmt.executeUpdate();
        
        ResultSet rs = stmt2.executeQuery();
          
        
        while (rs.next()){
            
      System.out.println(rs.getInt("accounts_id"));
                account.setAccountId(rs.getInt("accounts_id"));
                account.setType(rs.getInt("accounts_type"));
                account.setWachtwoord(rs.getString("wachtwoord"));
        }
        
         
        }
        catch(SQLException ex){
        System.out.println(ex.getMessage());
                }
            
         
        return account;
        }
         

    @Override
    public boolean deleteAccount(int id) {
       
         
       // String query = "DELETE FROM klant_has_adres (=NAAM TUSSEN TABLE! ) WHERE Klant_klant_id (NAAM=FK ALS DIE ER IS) = " + klant.getKlantID(); 
       
        String query = "DELETE FROM accounts WHERE accounts_id = " + id;        
        try (
                //PreparedStatement stmt  = connectie.prepareStatement(query);
        	PreparedStatement stmt2 = accountconnectie.prepareStatement(query)
        	)
                {
        	
        
            stmt2.executeUpdate();
          
            
            System.out.println("Account gegevens zijn succesvol verwijderd");
        }
        catch (SQLException foutaccountdelete){
         System.out.println(foutaccountdelete.getMessage());
              return false;  
        } 
        
        return true;
        
        
        
    }

    @Override
    public boolean updateAccountType(int id, int type) {
        
                
            String regel = " UPDATE accounts SET accounts_type = ? WHERE accounts_id = ? " ;
          
                    
                    
       try (PreparedStatement stmt = accountconnectie.prepareStatement(regel)){
       stmt.setInt(1, type);
       stmt.setInt(2, id);       
               
          
       stmt.executeUpdate();
       
       
         
        System.out.println("Account type is succesvol veranderd");
        }
        catch (SQLException foutaccounttype){
         System.out.println(foutaccounttype.getMessage());
              return false;  
        } 
        
        return true;
        
    }
    
     @Override
    public boolean updateAccountWachtwoord(int id, String wachtwoord) {
        
        
        
        
       try (PreparedStatement stmt = accountconnectie.prepareStatement(
       "UPDATE   accounts "+
       "SET wachtwoord = ? " +
       "WHERE accounts_id = ?   ")){
        stmt.setString(1, wachtwoord);
        stmt.setInt(2, id);
        
         stmt.executeUpdate();
         
        System.out.println("Account wachtwoord is succesvol veranderd");
        }
        catch (SQLException foutaccountwachtwoord){
         System.out.println(foutaccountwachtwoord.getMessage());
              return false;  
        } 
        
        return true;
        
    }
    
    
    
    
    

    @Override
        public boolean loginCheckAccount(int accountId, String wachtwoord) {
            
            boolean correct;
            
            String query = "SELECT * FROM accounts WHERE accounts_id = ? AND wachtwoord = ?";
            
            
            
    try (PreparedStatement stmt = accountconnectie.prepareStatement(query)){
        stmt.setInt(1, accountId);
        stmt.setString(2, wachtwoord);
        ResultSet rs = stmt.executeQuery();
        
        
        if(rs.next()){correct=true;} 
        else { correct = false;        
        }
            } catch (SQLException ex) { 
                correct = false;
                System.out.println(ex.getMessage());
                System.out.println("Er ging iets mis bij het zoeken naar de account.");
                  }
    return correct;
}
    
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    
        
        
        
        
        
        
    
    
    
    
    
    
    
    

    
    
    
    
    
    

