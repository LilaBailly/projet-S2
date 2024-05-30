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
    private String idNiveau ;
    private double hauteursousPlafond ; //int hauteur à voir
    private ArrayList<Appartement> listeAppart ;
    private ArrayList<Piece> listePiece ;
    private static int compteur = 0;
    public Niveau(){
        
    }
    public Niveau ( double hauteurplafond, ArrayList<Appartement> listeAppart) {
        this.idNiveau = "N " + (++compteur);
        this.hauteursousPlafond = hauteurplafond ;
        this.listeAppart = listeAppart ;
    }
    //get et set pour donner et utiliser les attributs
    public String getidNiveau(){
        return idNiveau ;
    }
    public void setidNiveau(String idNiveau){
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
    /*public double surface() {
        double s=0 ;
            for (int i=0; i<=listeAppart.size();i++) {
                s=s+this.listeAppart.get(i).surface() ;//changer la méthodde pour avoir une diff entre les appart et les couloirs
            }
            return s ;
    }*/
    //afficher
    void afficherNiveau(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idNiveau).append(" ; ");
        sb.append(hauteursousPlafond).append(" ; ");
        for (Appartement appart : listeAppart) {
            sb.append(appart.getidAppartement()).append(" ; ");
        }
        
        return sb.toString();
    }
    
}
