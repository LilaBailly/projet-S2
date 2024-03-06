/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

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
    double hauteurssplafond ;
    double surface ;
    
    //déclaration du constructeur
    Mur(int id, Coin debut, Coin fin) {
        this.idMur=id ;
        this.coinDebut=debut ;
        this.coinFin=fin ;
    }
    
    void afficher(){
            System.out.println("Identifiant :"+this.idMur+" Coin de début :"+this.coinDebut+"Coin de fin :"+this.coinFin+"Nombre de fenetre :"+this.nbrFenetre+" Nombre de porte"+this.nbrPorte+" Surface :");
    }
    
    double surface(Coin debut, Coin fin, double hauteur) {
        double surface ;
        this.coinDebut=debut ;
        this.coinFin=fin ;
        this.hauteurssplafond=hauteur ;
        //on calcule la distance entre les deux points, en assurant le cas où les hauteurs sont différentes.
        getter.cx
        
        return surface
    }
