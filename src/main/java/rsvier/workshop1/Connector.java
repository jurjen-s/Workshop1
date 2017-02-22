/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author jurjen
 */
public class Connector {
    
    private String settings = "target/classes/settings.xml";
    private String dbType;
    private String dbHost;
    private String dbDriver;
    private String dbUsername;
    private String dbUserpass;
    private String connType;
    private final Logger LOGGER = LogManager.getLogger(Connector.class);
    private XPathFactory xPathfactory = XPathFactory.newInstance();
    private XPath xpath = xPathfactory.newXPath();
    private static Connector connector;
    
    private Connector() {        
    }
    
    public static Connector getConnector() {
        if (connector == null) {
            connector = new Connector();
        }
        return connector;
    }
    
    public String getDbType() {
        if (dbType == null) {
            getConnector();
        }
        return dbType;
    }
    
    public String getDbHost() {
        if (dbHost == null) {
            getConnector();
        }
        return dbHost;
    }
        
    public String getDbDriver() {
        if (dbDriver == null) {
            getConnector();
        }
        return dbDriver;
    }

    public String getDbUsername() {
        if (dbUsername == null) {
            getConnector();
        }
        return dbUsername;
    }
    
    public String getDbUserpass() {
        if (dbUserpass == null) {
            getConnector();
        }
        return dbUserpass;
    }
    
    public String getConnType() {
        if (connType == null) {
            getConnector();
        }
        return connType;
    }
    
    public boolean setDatabase(String type) {
        Document doc = parse();
        return setDatabase(doc, type);
    }
    
    public boolean setDatabase(Document doc, String type) {
        String expression;
        if (type.equals("")) {
            expression = "//database/default[text()='true']/..";
        } else {
            expression ="//database/type[text()='"+type.toUpperCase()+"']/..";
        }
        try {
            XPath xpath = XPathFactory.newInstance().newXPath(); 
            XPathExpression expr = xpath.compile(expression);
            NodeList settings = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            Element resultNode = (Element) settings.item(0);            
            if(!resultNode.hasChildNodes())
                System.out.println("Geen databases ingesteld in settings.xml.");
            // Get information from nodelist.
            dbType = resultNode.getElementsByTagName("type").item(0).getTextContent();
            dbHost = resultNode.getElementsByTagName("host").item(0).getTextContent();
            dbUsername = resultNode.getElementsByTagName("username").item(0).getTextContent();
            dbUserpass = resultNode.getElementsByTagName("userpass").item(0).getTextContent();
            dbDriver = resultNode.getElementsByTagName("driver").item(0).getTextContent();
            System.out.println("Test print: " +dbType+" "+dbHost+" "+dbUsername+" "+dbUserpass+" "+dbDriver);
            return true;
        } catch (XPathExpressionException ex) {
            System.out.println("Er ging iets mis bij het lezen van de instellingen: " + ex.getMessage());
            return false;
        }
    }
    
    public boolean setConnection(String type) {
        Document doc = parse();
        return setConnection(doc, type);
    }
    
    public boolean setConnection(Document doc, String type) {
        String expression;
        if (type.equals("")) {
            expression = "//connection/default[text()='true']/..";
        } else {
            expression ="//connection/type[text()='"+type.toUpperCase()+"']/..";
        }
        try {
            XPath xpath = XPathFactory.newInstance().newXPath(); 
            XPathExpression expr = xpath.compile(expression);
            NodeList settings = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
            Element resultNode = (Element) settings.item(0);      
            if(!resultNode.hasChildNodes())
                System.out.println("Geen connecties ingesteld in settings.xml.");
            // Get information from nodelist.
            connType = resultNode.getElementsByTagName("type").item(0).getTextContent();
            System.out.println("Test print: " +connType);
            return true;
        } catch (XPathExpressionException ex) {
            System.out.println("Er ging iets mis bij het lezen van de instellingen: " + ex.getMessage());
            return false;
        }
    }
    
    private Document parse() {
        try {
            File xmlSettings = new File(settings);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xmlSettings);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            LOGGER.error("Kon de instellingen niet opvragen. {}", ex.getMessage());
        }
        return null;
    }
}
