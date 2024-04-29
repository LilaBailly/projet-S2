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
   private String idBatiment ;
   private ArrayList<Niveau> listeNiveau = new ArrayList<>();
//get et set pour donner et utiliser les attributs
public String getidBatiment(){
    return idBatiment ;
}
public void setidBatiment(String idBatiment) {
    this.idBatiment = idBatiment ;
}
public ArrayList<Niveau> getlisteNiveau(){
    return listeNiveau ;
}
public void setidPiece(ArrayList<Niveau> listeNiveau) {
    this.listeNiveau = listeNiveau ;
}
//procedure pour calculer la surface du batiment 
  /* public double surface() {
        double s=0 ;
        for (int i=0; i<=listeNiveau.size();i++) {
            s=s+this.listeNiveau.get(i).surface() ;
        }
        return s ;
}*/
    
    //méthodes
    //afficher()
//sauvegarder()
//lireBatiment()
//devisBatiment()
//dessiner()
}
