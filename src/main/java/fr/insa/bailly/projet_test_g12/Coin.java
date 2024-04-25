/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author ElèveTEST
 */

public class Coin {
    // Déclaration des attributs de la classe coin
    int idCoin ;
    double cx ;
    double cy ;
    
    //déclaration du constructeur
    Coin(int id, double x, double y) {
        this.idCoin=id ;
        this.cx=x ;
        this.cy=y ;
    }
    
    public double getcx () {
        return cx ;
    }
    
    public double getcy () {
        return cx ;
    }
    void afficher(){
            System.out.println("Identifiant :"+this.idCoin+" Abscisse :"+this.cx+" Ordonnée :"+this.cy);
    }
}
//faire toString