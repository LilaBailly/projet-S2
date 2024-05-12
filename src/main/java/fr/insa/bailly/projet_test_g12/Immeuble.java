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
public class Immeuble extends Batiment {
 //   listeNiveau
    
    private int idBatiment ;
    private ArrayList<Niveau> listeNiveaux;

    public Immeuble (int idBatiment, ArrayList<Niveau> listeNiveaux) {
        this.idBatiment = idBatiment ;
        this.listeNiveaux = listeNiveaux ;
    }
    
    public ArrayList<Niveau> getListeNiveaux(){
        return listeNiveaux;
    }
    
    public void setlisteNiveaux(ArrayList<Niveau> listeNiveaux){
        this.listeNiveaux = listeNiveaux;
    }
    /*
    public double surface(){
        double s=0;
        for (int i=0; i<this.listeNiveaux.size(); i++){
            s=s+this.listeNiveaux.get(i).surface();
        }
        return s;
    }*/
    
    @Override
    public String toString(){
        return "Immeuble [ idImmeuble : "+getidBatiment()+" , listeNiveaux : "+listeNiveaux+" ]";
    }
    
}
