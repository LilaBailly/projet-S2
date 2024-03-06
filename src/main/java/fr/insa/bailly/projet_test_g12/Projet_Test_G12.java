/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author Elève
 */
public class Projet_Test_G12 {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        // Exemple de calcul
        int n ;
        System.out.println("donner un entier n.");
        n=Lire.i() ;
        for (int i=0; i<=n; i++) {
            if (i%2==1) System.out.println(i) ; 
        }
        
        // Création d'un coin
        int id;
        double abscisse, ordonnee ;
        System.out.println("Donner un identifiant") ;
        id=Lire.i() ;
        System.out.println("Donner une abscisse") ;
        abscisse=Lire.d() ;
        System.out.println("Donner une ordonnee") ;
        ordonnee=Lire.d() ;
        // Appel du constructeur pour creer l'instance de Coin
        Coin c ;
        c= new Coin(id,abscisse,ordonnee) ;
        c.afficher();
            
    }
}
