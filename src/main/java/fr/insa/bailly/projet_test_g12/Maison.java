/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;

/**
 *
 * @author becqu
 */
public class Maison extends Batiment {
    
    private int idBatiment ;
    private ArrayList<Niveau> listeNiveauxMaison;

    public Maison (int idBatiment, ArrayList<Niveau> listeNiveaux) {
        this.idBatiment = idBatiment ;
        this.listeNiveauxMaison = listeNiveaux ;
    }
    
    public int getidMaison(){
        return idBatiment ;
    }
    public void setidMaison(int idBatiment) {
        this.idBatiment = idBatiment ;
    }
    
    public ArrayList<Niveau> getListeNiveaux(){
        return listeNiveauxMaison;
    }
    
    public void setlisteNiveaux(ArrayList<Niveau> listeNiveaux){
        this.listeNiveauxMaison = listeNiveaux;
    }
    /*
    public double surface(){
        double s=0;
        for (int i=0; i<this.listeNiveaux.size(); i++){
            s=s+this.listeNiveaux.get(i).surface();
        }
        return s;
    }*/
    public void afficherMaison(){
            System.out.println("Maison [ idMaison : "+this.getidBatiment()+" , listeNiveaux : "+this.listeNiveauxMaison+" ]");
    }
    
    @Override
    public String toString(){
        return "Maison [ idMaison : "+getidBatiment()+" , listeNiveaux : "+listeNiveauxMaison+" ]";
    }
    
}
