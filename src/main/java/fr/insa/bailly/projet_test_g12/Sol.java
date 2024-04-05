/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author Elève
 */
public class Sol {


//idSol : int
//listeCoins : List
//listeRevetements:List

//afficher()
//toString()
//surface()
//montantRevetement()
    // Déclaration des attributs de la classe Sol
    int idSol ;
    Coin coinDebut ;
    Coin coinFin ;
    Coin coinLargeur;
    //déclaration du constructeur
    Sol(int id, Coin debut, Coin fin, Coin Largeur) {
        this.idSol=id ;
        this.coinDebut=debut ;
        this.coinFin=fin ;
        this.coinLargeur=Largeur;
    }
}
    
