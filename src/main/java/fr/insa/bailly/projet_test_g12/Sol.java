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
private ArrayList<Revetement> liste_rev_sol ;

//déclaration du constructeur
Sol(int id, ArrayList<Coin> listeCoin, ArrayList<Revetement> listeRevetement) {
    this.idSol=id ;
    this.listeCoin = listeCoin ;
    this.liste_rev_sol = listeRevetement ;
    }
//méthode pour vérifier si le revetement est applicable sur un sol
public boolean add_revetement (Revetement rev) {
        if (rev.getpourSol()==true){
            this.liste_rev_sol.add(rev) ;
            return true;
        }
        else {
            System.out.println("Revetement ne peut être mis sur un sol, choisir un autre") ;
            return false ;
        }
    }

//méthode pour calculer la surface d'un sol pour une pièce rectangulaire
public double surface(){ //finir la méthode
    surface = 
    return surface
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
public ArrayList<Revetement> getlisteRevetement(){
    return liste_rev_sol ;
}
public void setlisteRevetement(ArrayList<Revetement> liste_rev_sol) {
    this.liste_rev_sol = liste_rev_sol ;
}
}
    
