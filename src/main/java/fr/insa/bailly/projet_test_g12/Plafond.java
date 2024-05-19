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
public class Plafond {
    private int idPlafond ;
    private ArrayList<Coin> listeCoin ;
    private ArrayList<Revetement> listeRevPlafond ;
    private int nbrtremis ; //ajouter nbr tremis
    private Piece piece;
    private ArrayList<Ouverture> listeOuverture ;
    
    public Plafond(){

    }
    //Déclaration du constructeur
    public Plafond (int id, ArrayList<Coin> listeCoin, ArrayList<Revetement> listeRevetement){
        this.idPlafond = id ;
        this.listeCoin = listeCoin ;
        this.listeRevPlafond = listeRevetement ;
    } 
    public double CalculerSurfacePlafond() {
        listeCoin.add(piece.getlisteMurs().getFirst().getcoinDebut());
        Coin coin1 = listeCoin.get(1);
        Coin coin2 = listeCoin.get(2);
        Ouverture tremis = listeOuverture.get(1);
        double longueur = Math.abs(coin2.getcx() - coin1.getcx());
        double largeur = Math.abs(coin2.getcy() - coin1.getcy());
        double surface = longueur * largeur;
        surface = surface-nbrtremis*tremis.getsurfaceTremis() ;
        return surface ;
        
    }
    public double cout(){
        double cout = 0 ;
        double s = CalculerSurfacePlafond() ;
        for (int i=0; i<listeRevPlafond.size(); i++){
             cout = cout + s*listeRevPlafond.get(i).getprixunitaire() ;   
        }
        return cout ;
    }
    //get et set pour donner et utiliser les attributs
    public int getidPlafond(){
        return idPlafond ;
    }
    public void setidPlafond(int idPlafond) {
        this.idPlafond = idPlafond ;
    }
    public ArrayList<Coin> getlisteCoin(){
        return listeCoin ;
    }
    public void setlisteCoin(ArrayList<Coin> listeCoin) {
        this.listeCoin = listeCoin ;
    }
    public ArrayList<Revetement> getlisteRevetementPlafond(){
        return listeRevPlafond ;
    }
    public void setlisteRevetement(ArrayList<Revetement> liste_rev_plafond) {
        this.listeRevPlafond = liste_rev_plafond ;
    }
    //toString()
    //surface()
    //montantRevetement()
}
