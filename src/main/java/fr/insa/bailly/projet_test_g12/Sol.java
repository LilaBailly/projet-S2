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
    private String idSol ;
    private ArrayList<Coin> listeCoin ;
    private int nbrtremis ;
    private int nbrrev ;
    private ArrayList<Revetement> listeRevSol ;
    private Piece piece;
    private static int compteur = 0;
    
    public Sol(){

    }

    //déclaration du constructeur
    public Sol(ArrayList<Coin> listeCoin,ArrayList<Revetement> listeRevetement, int nbrtremis ) {
        this.idSol = "S" + (++compteur);
        this.listeCoin = listeCoin ;
        this.nbrtremis = nbrtremis ;
        this.listeRevSol = listeRevetement ;
    }

    //méthode pour calculer la surface d'un sol
    public double CalculerSurfaceSol() {
        double surface = 0 ;
        Coin coin1 = this.listeCoin.getFirst() ;
        Coin coin2 = listeCoin.get(2);
        double x1 = coin1.getcx() ;
        double y1 = coin1.getcy() ;
        double x2 = coin1.getcx() ;
        double y2 = coin1.getcy() ;
        int i = 2 ;
        Ouverture tremis = new Ouverture("tremis") ;
        if (i<=4){
            while (x2== x1 || y2== y1) {
                i+=1 ;
                coin2 = this.listeCoin.get(i) ;
            } 
            double longueur = Math.abs(coin2.getcx() - coin1.getcx());
            double largeur = Math.abs(coin2.getcy() - coin1.getcy());
            surface = longueur * largeur;
            surface = surface-nbrtremis*tremis.getsurfaceTremis() ;
        }
        else {
            System.out.println("Auncun coin de la liste ne permet de calculer la surface, revoir leur coordonnées") ;
            System.out.println("Veillez recommencer et ne pas tenir compte de la surface nulle renovoyée") ;
        }
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
    public String getidSol(){
        return idSol ;
    }
    public void setidSol(String idSol) {
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
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idSol).append(" ; ");
        for (Coin coin : listeCoin) {
            sb.append(coin.getidCoin()).append(" ; ");
        }
        // Ajouter les identifiants des revêtements
        for (Revetement rev : listeRevSol) {
            sb.append(rev.getidRevetement()).append(" ; ");
        }
        sb.append(nbrtremis).append(" ; ");
        return sb.toString();
    }

}