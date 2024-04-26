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
    private int hauteur ; //fixer la hauteur ici, quelle diff avec hauteur sous plafond ?
    private int idNiveau ;
    private double hauteursousPlafond ;
    private ArrayList<Appartement> listeAppart ;

public Niveau (int id, double hauteurplafond, ArrayList<Appartement> listeAppart) {
    this.idNiveau = id ;
    this.hauteursousPlafond = hauteurplafond ;
    this.listeAppart = listeAppart ;
}
//get et set pour donner et utiliser les attributs
public int getidNiveau(){
    return idNiveau ;
}
public void setidNiveau(int idNiveau){
    this.idNiveau = idNiveau ;
}
public double gethauteursousPlafond(){
    return hauteursousPlafond ;
}
public void setidNiveau(double hauteursousPlafond){
    this.hauteursousPlafond = hauteursousPlafond ;
}
public ArrayList<Appartement> getlisteAppart(){
    return listeAppart ;
}
public void setlisteAppart(ArrayList<Appartement> listeAppart){
    this.listeAppart = listeAppart ;
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
