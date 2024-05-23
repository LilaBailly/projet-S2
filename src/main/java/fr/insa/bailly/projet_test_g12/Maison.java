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
    
    private String idBatiment ;
    private ArrayList<NiveauMaison> listeNiveauxMaison;

    public Maison (String idBatiment, ArrayList<NiveauMaison> listeNiveaux) {
        this.idBatiment = idBatiment ;
        this.listeNiveauxMaison = listeNiveaux ;
    }
    
    public String getidMaison(){
        return idBatiment ;
    }
    public void setidMaison(String idBatiment) {
        this.idBatiment = idBatiment ;
    }
    
    public ArrayList<NiveauMaison> getListeNiveaux(){
        return listeNiveauxMaison;
    }
    
    public void setlisteNiveaux(ArrayList<NiveauMaison> listeNiveaux){
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
        System.out.println(this.toString() + " ");
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idBatiment).append(" ; ");
        for (NiveauMaison niveauM : listeNiveauxMaison) {
            sb.append(niveauM.getidNiveauMaison()).append(" ; ");
        }
        
        return sb.toString();
    }
    
}
