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
public final class Niveau {
    private int hauteur ; //fixer la hauteur ici
    private int idNiveau ;
    private double hauteursousPlafond ;
    private ArrayList<Appartement> listeAppart ;

public Niveau (int id, double hauteurplafond, ArrayList<Appartement> listeAppart) {
    this.idNiveau = id ;
    this.hauteursousPlafond = hauteurplafond ;
    this.listeAppart = listeAppart ;
}
   
public int getidNiveau(){
    return idNiveau ;
}

public double gethauteursousPlafond(){
    return hauteursousPlafond ;
}

public double surface() {
    double s=0 ;
        for (int i=0; i<=listeAppart.size();i++) {
            s=s+this.listeAppart.get(i).surface() ;
        }
        return s ;
}
//afficher
//montantRevement()
}
