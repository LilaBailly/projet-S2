/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author Elève
 */
public class Ouverture {
    // Déclaration des attributs de la classe coin
    int idOuverture ;
    double dimx ;
    double dimy ;
    
    //déclaration du constructeur
    Ouverture(int id, double x, double y) {
        this.idOuverture=id ;
        this.dimx=x ;
        this.dimy=y ;
    }
    
    void afficher(){
            System.out.println("Identifiant :"+this.idOuverture+" Dimension en x :"+this.cx+" Dimension en y :"+this.cy);
    }
}
