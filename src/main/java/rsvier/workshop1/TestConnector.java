/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

public class TestConnector {
    public static void main(String[] args) {
        Connector connector = Connector.getConnector();
        
        //Test database instellingen opvragen
        System.out.println("Met database type:");
        connector.setDatabase("firebird");
        System.out.println("Zonder database type:");
        connector.setDatabase("");        
        //Test connectie instellingen opvragen
        System.out.println("Met connectie type:");
        connector.setConnection("jdbc");
        System.out.println("Zonder connectie type:");
        connector.setConnection("")    ;
    }
}
