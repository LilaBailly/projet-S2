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
   public Batiment(){
    
    } 
   public Batiment(ArrayList<Niveau> listeNiveau){
       
   }
   public String getidBatiment(){
        return idBatiment ;
    }
    public void setidBatiment(String idBatiment) {
        this.idBatiment = idBatiment ;
    }
    public ArrayList<Niveau> getlisteNiveau(){
        return listeNiveau ;
    }
    public void setlisteNiveau(ArrayList<Niveau> listeNiveau) {
        this.listeNiveau = listeNiveau ;
    }
     public void afficher() {
        System.out.println("Batiment [idBatiment: " + idBatiment + ", listeNiveaux: " + listeNiveau + "]");
    }
}
