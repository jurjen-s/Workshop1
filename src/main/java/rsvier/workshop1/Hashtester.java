/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import org.mindrot.jbcrypt.BCrypt;

import java.lang.Object;

/**
 *
 * 
 * @author Frank
 */


public class Hashtester{
        

public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException  {
   
    
    // doel is om een wachtwoord de hashen naar een string met salt, sha1 etc mag niet gebruikt worden omdat het te snel is.
    
    
    String inputwachtwoord ="maakhiermaarwatvann";
    
    String generatedSecuredPasswordHash = genereertSterkeWachtwoordHash(inputwachtwoord);
        System.out.println(generatedSecuredPasswordHash);
        
        
        
        
        
        
        
        
        // twwede keuze dit wordt niet de hash wss.
        
        System.out.println("hier onder is Bcrypt voorbeeld:");
                
                String test_passwd = "abcdefghijklmnopqrstuvwxyz";
		String test_hash = "$2a$06$.rCVZVOThsIa97pEDOxvGuRRgzG64bvtJ0938xuqzv18d3ZpQhstC";

		System.out.println("Testing BCrypt Password hashing and verification");
		System.out.println("Test password: " + test_passwd);
		System.out.println("Test stored hash: " + test_hash);
		System.out.println("Hashing test password...");
		System.out.println();

		String computed_hash = hashPassword(test_passwd);
		System.out.println("Test computed hash: " + computed_hash);
		System.out.println();
		System.out.println("Verifying that hash and stored hash both match for the test password...");
		System.out.println();

		String compare_test = checkPassword(test_passwd, test_hash)
			? "Passwords Match" : "Passwords do not match";
		String compare_computed = checkPassword(test_passwd, computed_hash)
			? "Passwords Match" : "Passwords do not match";

		System.out.println("Verify against stored hash:   " + compare_test);
		System.out.println("Verify against computed hash: " + compare_computed);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }

    private static String genereertSterkeWachtwoordHash(String inputwachtwoordstring) throws NoSuchAlgorithmException, InvalidKeySpecException
    {
        //return een String (een sterke hash)  met deze input.
        
        
        //iterations is later nodig.
        int iterations = 1000;
        
        //maakt een char array van het orginele inputwacht.
        char[] chars = inputwachtwoordstring.toCharArray();
        
        //maakt salt door middel van getSalt();
        
        byte[] salt = getSalt();
         
        
        /*
        PBEKeySpec(char[] password, byte[] salt, int iterationCount, int keyLength)
Constructor that takes 
        a password, salt, iteration count, and to-be-derived key length for
        
        generating PBEKey of variable-key-size PBE ciphers.
        
        
        
        
        */
        
        PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
        
        //spec is een PBEKey !
       
        /*
        getInstance(String algorithm) 
          Returns a SecureRandom object that implements the specified Random Number Generator (RNG) algorithm.
        
        */
        
        
        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        
        
        //spec is een PBEKey!
        
        // https://docs.oracle.com/javase/7/docs/api/javax/crypto/SecretKeyFactory.html
        //over generateSecret.
        
        byte[] hash = skf.generateSecret(spec).getEncoded();
        
        
        //gooi nu de 'iterations : salt (in hex) : hash (in hex) terug'.
        
        return iterations + ":" + toHex(salt) + ":" + toHex(hash);
    }
     
    //einde genereertsterkehash.
    
    
    
    
    
    
    
    
    
    
    //get Salt functie:
        
    private static byte[] getSalt() throws NoSuchAlgorithmException
    {
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        sr.nextBytes(salt);
        return salt;
    }
     
    
    
    //maakt van een byte[] array een hex string.
    
    private static String toHex(byte[] array) throws NoSuchAlgorithmException
    {
        BigInteger bi = new BigInteger(1, array);
        String hex = bi.toString(16);
        int paddingLength = (array.length * 2) - hex.length();
        if(paddingLength > 0)
        {
            return String.format("%0"  +paddingLength + "d", 0) + hex;
        }else{
            return hex;
        }
    }
     
    
    
    ///////////////////////////////////////////////////////////////////////////
    
    
    // TWEEDE HASH
    
    
    
    

    
    // tweede keuze BCRYPT:
    
    private static int workload = 12;

	/**
	 * This method can be used to generate a string representing an account password
	 * suitable for storing in a database. It will be an OpenBSD-style crypt(3) formatted
	 * hash string of length=60
	 * The bcrypt workload is specified in the above static variable, a value from 10 to 31.
	 * A workload of 12 is a very reasonable safe default as of 2013.
	 * This automatically handles secure 128-bit salt generation and storage within the hash.
	 * @param password_plaintext The account's plaintext password as provided during account creation,
	 *			     or when changing an account's password.
	 * @return String - a string of length 60 that is the bcrypt hashed password in crypt(3) format.
	 */
	public static String hashPassword(String password_plaintext) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password_plaintext, salt);

		return(hashed_password);
	}
	/**
	 * This method can be used to verify a computed hash from a plaintext (e.g. during a login
	 * request) with that of a stored hash from a database. The password hash from the database
	 * must be passed as the second variable.
	 * @param password_plaintext The account's plaintext password, as provided during a login request
	 * @param stored_hash The account's stored password hash, retrieved from the authorization database
	 * @return boolean - true if the password matches the password of the stored hash, false otherwise
	 */
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if(null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return(password_verified);
	}

	/**
	  * A simple test case for the main method, verify that a pre-generated test hash verifies successfully
	  * for the password it represents, and also generate a new hash and ensure that the new hash verifies
	  * just the same.
	  */
	
	
        
        
        
        
        
        
        ////////////////////////////////////////////////////////////////////////////////////////

        
        
        
        
        
        
        
        
        
	}
    
    
    
    
    
    
    

    

