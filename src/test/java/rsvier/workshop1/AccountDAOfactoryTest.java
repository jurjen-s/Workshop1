/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Frank
 */
public class AccountDAOfactoryTest {
    
    public AccountDAOfactoryTest() {
    }

    /**
     * Test of getAccountDAO method, of class AccountDAOfactory.
     */
    @Test
    public void testGetAccountDAO() {
        System.out.println("getAccountDAO");
        AccountSQL expResult = null;
        AccountSQL result = AccountDAOfactory.getAccountDAO();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}