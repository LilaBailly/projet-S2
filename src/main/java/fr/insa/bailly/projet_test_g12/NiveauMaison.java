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
public class NiveauMaison {
    private int idNiveauMaison ;
    private double hauteursousPlafond ; //int hauteur à voir
    private ArrayList<Piece> listePiece ;
    
    public NiveauMaison(){
        
    }
    public NiveauMaison (int id, double hauteurplafond, ArrayList<Piece> listePiece){
        this.idNiveauMaison = id ;
        this.hauteursousPlafond = hauteurplafond ;
        this.listePiece = listePiece ;
    }
    
    //get et set pour donner et utiliser les attributs
    public int getidNiveauMaison(){
        return idNiveauMaison ;
    }
    public void setidNiveauMaison(int idNiveau){
        this.idNiveauMaison = idNiveau ;
    }
    public double gethauteursousPlafond(){
        return hauteursousPlafond ;
    }
    public void setidNiveauMaison(double hauteursousPlafond){
        this.hauteursousPlafond = hauteursousPlafond ;
    }
    public ArrayList<Piece> getlistePiece(){
        return listePiece ;
    }
    public void setlistePiece(ArrayList<Piece> listePiece){
        this.listePiece = listePiece ;
    }
    /*public double surface() {
        double s=0 ;
            for (int i=0; i<=listeAppart.size();i++) {
                s=s+this.listeAppart.get(i).surface() ;//changer la méthodde pour avoir une diff entre les appart et les couloirs
            }
            return s ;
    }*/
    //afficher
    void afficherNiveauMaison(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idNiveauMaison).append(" ; ");
        for (Piece piece : listePiece) {
            sb.append(piece.getidPiece()).append(" ; ");
        }
        
        return sb.toString();
    }
    
}
