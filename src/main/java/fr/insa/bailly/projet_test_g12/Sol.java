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
private int nbrtremis ;
private int nbrrev ;
private ArrayList<Revetement> listeRevetement ;

//déclaration du constructeur
Sol(int id, ArrayList<Coin> listeCoin,int nbrtremis, int nbrrev) {
    this.idSol=id ;
    this.listeCoin = listeCoin ;
    this.nbrtremis = nbrtremis ;
    this.nbrrev = nbrrev ;
    this.listeRevetement = Revetement.choixRevetementSol (nbrrev) ;
}

//méthode pour calculer la surface d'un sol
/*public double surface () {
    double surface = 
    //surface = surface-nbrtremis*getprixtremis() ;
    return surface ;
}
//méthode pour calculer le cout d'un sol
public double cout(){
    double cout = 0 ;
    double s = surface() ;
    for (int i=0; i<listeRevetement.size(); i++){
         cout = cout + s*listeRevetement.get(i).getprixunitaire() ;   
    }
return cout ;
    }*/

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
    return listeRevetement ;
}
}