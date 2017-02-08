/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.kaasbaas.Meebezig.Jurjen;

import java.util.HashMap;

/**
 *
 * @author jurjen
 */
public interface FactuurDAO {
    boolean maakFactuur();
    HashMap bekijkFactuur();
    boolean betaalFactuur();
}
