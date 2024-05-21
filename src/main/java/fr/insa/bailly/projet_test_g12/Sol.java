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
public class Sol {
    private int idSol ;
    private ArrayList<Coin> listeCoin ;
    private ArrayList<Ouverture> listeOuverture ;
    private int nbrtremis ;
    private int nbrrev ;
    private ArrayList<Revetement> listeRevSol ;
    private Piece piece;
    
    
    public Sol(){

    }

    //déclaration du constructeur
    public Sol(int id, ArrayList<Coin> listeCoin,int nbrtremis, ArrayList<Revetement> listeRevetement ) {
        this.idSol=id ;
        this.listeCoin = listeCoin ;
        this.nbrtremis = nbrtremis ;
        this.listeRevSol = listeRevetement ;
    }

    //méthode pour calculer la surface d'un sol
    public double CalculerSurfaceSol() {
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
    //méthode pour calculer le cout d'un sol
    public double coutSol(){
        double cout = 0 ;
        double s = CalculerSurfaceSol() ;
        for (int i=0; i<listeRevSol.size(); i++){
             cout = cout + s*listeRevSol.get(i).getprixunitaire() ;   
        }
        return cout ;
    }

    //get et set pour donner et utiliser les attributs
    public int getidSol(){
        return idSol ;
    }
    public void setidSol(int idSol) {
        this.idSol = idSol ;
    }
    public ArrayList<Coin> getlisteCoin(){
        return listeCoin ;
    }
    public void setlisteCoin(ArrayList<Coin> listeCoin) {
        this.listeCoin = listeCoin ;
    }
    public ArrayList<Revetement> getlisteRevetementSol(){
        return listeRevSol ;
    }
    
    // Getter et Setter pour nbrtremis
    public int getNbrTremis() {
        return nbrtremis;
    }

    public void setNbrTremis(int nbrtremis) {
        this.nbrtremis = nbrtremis;
    }
    public ArrayList<Revetement> getlisteRevSol() {
        return listeRevSol;
    }
    void afficherSol(){
            System.out.println(" Sol [ idSol : "+this.idSol+" , ListeCoins : "+this.listeCoin+" , ListeRevetements : "+this.listeRevSol+" ]");
    }
    @Override 
    public String toString(){
        return " Sol [ idSol : "+idSol+" , ListeCoins : "+listeCoin+" , ListeRevetements : "+listeRevSol+" ]";
    }

}