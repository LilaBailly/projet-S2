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
    
    private int idBatiment ;
    private ArrayList<Niveau> listeNiveaux;
    
    public Immeuble(){
        
    }
    public Immeuble (int idImmeuble, ArrayList<Niveau> listeNiveaux) {
        this.idBatiment = idImmeuble;
        this.listeNiveaux = listeNiveaux ;
    }
    
    public int getidImmeuble(){
        return idBatiment ;
    }
    public void setidImmeuble(int idBatiment) {
        this.idBatiment = idBatiment ;
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
    public void afficherImmeuble(){
        System.out.println(this.toString() + " ");
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("I;")
          .append(idBatiment).append(";");
        for (Niveau niveau : listeNiveaux) {
            sb.append(niveau.getidNiveau()).append(";");
        }
        
        return sb.toString();
    }
    
}
