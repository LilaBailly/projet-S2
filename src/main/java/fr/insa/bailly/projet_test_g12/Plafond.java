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
    private String idPlafond ;
    private ArrayList<Coin> listeCoin ;
    private ArrayList<Revetement> listeRevPlafond ;
    private int nbrtremis ; //ajouter nbr tremis
    private Piece piece;
    
    public Plafond(){

    }
    //Déclaration du constructeur
    public Plafond (String id, ArrayList<Coin> listeCoin, ArrayList<Revetement> listeRevetement, int nbrtremis){
        this.idPlafond = id ;
        this.listeCoin = listeCoin ;
        this.listeRevPlafond = listeRevetement ;
        this.nbrtremis = nbrtremis ;
    } 
    public double CalculerSurfacePlafond() {
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
            System.out.println("Aucun coin de la liste ne permet de calculer la surface, revoir leur coordonnées") ;
            System.out.println("Veillez recommencer et ne pas tenir compte de la surface nulle renovoyée") ;
        }
        return surface ;
    }
    public double coutPlafond(){
        double cout = 0 ;
        double s = CalculerSurfacePlafond() ;
        for (int i=0; i<listeRevPlafond.size(); i++){
             cout = cout + s*listeRevPlafond.get(i).getprixunitaire() ;   
        }
        return cout ;
    }
    //get et set pour donner et utiliser les attributs
    public String getidPlafond(){
        return idPlafond ;
    }
    public void setidPlafond(String idPlafond) {
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
    void afficherPlafond(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idPlafond).append(" ; ");
        for (Coin coin : listeCoin) {
            sb.append(coin.getidCoin()).append(" ; ");
        }
        // Ajouter les identifiants des revêtements
        for (Revetement rev : listeRevPlafond) {
            sb.append(rev.getidRevetement()).append(" ; ");
        }
        sb.append(nbrtremis).append(" ; ");
        return sb.toString();
    }
}
