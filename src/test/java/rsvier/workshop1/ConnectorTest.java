/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import rsvier.workshop1.db.Connector;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 *
 * @author jurjen
 */
public class ConnectorTest {
    
    public ConnectorTest() {
    }

    /**
     * Test of setDatabase method, of class Connector.
     */
    @Test
    public void testSetDatabase() {
        System.out.println("setDatabase");
        try {
            File settingsXML = new File("/src/main/resources/settings.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document settings = builder.parse(settingsXML);
            String databaseType = "";
            Connector.setDatabase(settings, databaseType);
            settings.getDocumentElement().normalize();
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println("Kon de instellingen niet opvragen: " + ex.getMessage());
        }        
    }

    /**
     * Test of setConnection method, of class Connector.
     */
    @Test
    public void testSetConnection() {
        System.out.println("setConnection");
        Document settings = null;
        String connection = "";
        Connector instance = new Connector();
        instance.setConnection(settings, connection);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
