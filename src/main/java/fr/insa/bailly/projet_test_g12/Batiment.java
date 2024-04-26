/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList;

/**
 *
 * @author Elève
 */
public class Batiment {
   String idBatiment ;
    ArrayList<Niveau> listeNiveau = new ArrayList<>();
    //get et set
    
    public double surface() {
        double s=0 ;
        for (int i=0; i<=listeNiveau.size();i++) {
            s=s+this.listeNiveau.get(i).surface() ;
        }
        return s ;
}
    
    //méthodes
    //afficher()
//sauvegarder()
//lireBatiment()
//devisBatiment()
//dessiner()
}
