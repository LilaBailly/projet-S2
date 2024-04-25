/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList ;
/**
 *
 * @author Elève
 */
public class Mur {
    // Déclaration des attributs de la classe Mur
    int idMur ;
    Coin coinDebut ;
    Coin coinFin ;
    int nbrPorte ;
    int nbrFenetre ;
    double hauteur ;
    double surface ;
    ArrayList<Revetement> liste_rev_mur ;
   //faire les get, set, private, et cout
    
    //déclaration du constructeur
    Mur(int id, Coin debut, Coin fin, int porte, int fenetre) {
        this.idMur = id ;
        this.coinDebut = debut ;
        this.coinFin = fin ;
        this.nbrPorte = porte ;
        this.nbrFenetre = fenetre ;
    }
    
    public double Longueur(){
        return Math.sqrt(Math.pow(this.coinFin.getcx() - this.coinDebut.getcx(),2)
                +Math.pow(this.coinFin.getcy() - this.coinDebut.getcy(),2)) ;//faire get coordonnée
    }
    
    public double surface (double hauteur){
        return this.Longueur()*hauteur ;
    }
    
    public boolean add_revetement (Revetement rev) {
        if (rev.getpourMur==1){
            this.liste_rev_mur.add(rev) ;
            return true;
        }
        else {
            System.out.println("Revetement ne peut être mis sur un mur, choisir un autre") ;
            return false ;
        }
    }
    //??procedure pour calculer le prix au fur et à mesure ??
    void afficher(){
            System.out.println("Identifiant :"+this.idMur+" Coin de début :"+this.coinDebut+"Coin de fin :"+this.coinFin+"Nombre de fenetre :"+this.nbrFenetre+" Nombre de porte"+this.nbrPorte+" Surface :");
    }
}
