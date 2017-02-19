/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author jurjen
 */
public class Validator {
      
    public boolean validateEmail(String email) {
        boolean validEmail;
        EmailValidator validator = EmailValidator.getInstance();
        if (validator.isValid(email)) {
            validEmail = true;
        } else {
            validEmail = false;
        }
        return validEmail;
    }
    
    public boolean validatePostcode(String postcode) {
        String matchpattern = "^[0-9]{4}\\x20[A-Z]{2}";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(matchpattern);
        java.util.regex.Matcher m = p.matcher(postcode);
        if (m.matches()) {
            return true;
        } else {
            System.out.println("Postcode is niet in het juiste formaat ingevoerd.");
            return false;
        }
    }
    
    public boolean validateTelefoonnummer( String telefoonnummer){
       String regexStr = "^[0-9\\-]*$" ;
       
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regexStr);
        java.util.regex.Matcher m = p.matcher(telefoonnummer);
        if (m.matches()){
            return true;
        }else{
             System.out.println("telefoonnummer is niet in het juiste formaat ingevoerd.");
             return false;
        }
       
    }
    
    
}
