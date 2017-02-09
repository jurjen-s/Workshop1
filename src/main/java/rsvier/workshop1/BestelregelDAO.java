/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rsvier.workshop1;

/**
 *
 * @author jurjen
 */
public interface BestelregelDAO {
    boolean toevoegenBestelregel(Bestelregel bestelregel);
    Bestelregel findBestelregelById(int bestelregelId);
    Bestelregel findBestelregelByBestellingId(int bestellingId);
    Bestelregel findBestelregelByProductId(int productId);
    Bestelregel findBestelregelByHoeveelheid(int hoeveelheid);
    boolean updateBestelregelBestellingId(int bestelregelId, int bestellingId);
    boolean updateBestelregelProductId(int bestelregelId, int productId);
    boolean updateBestelregelHoeveelheid(int bestelregelId, int hoeveelheid);
    boolean deleteBestelregel(int bestelregelId);
}
