/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList;
/**
 *
 * @author Elève
 */
public class Main {

    public static void main(String[] args) {
        //Création d'un Bâtiment
        
        //Création d'un Niveau
        
        //Création d'un Appartement
        
        //Création d'une Pièce
        
        //Création d'un Mur
        
        //Création d'un Sol
        
        //Création d'un Plafond
        
        // Création d'un coin
        int idCoin;
        double abscisse, ordonnee ;
        System.out.println("Donner un identifiant d'un coin") ;
        idCoin=Lire.i() ;
        System.out.println("Donner l'abscisse du coin "+idCoin) ;
        abscisse=Lire.d() ;
        System.out.println("Donner l'ordonnee du coin "+idCoin) ;
        ordonnee=Lire.d() ;
        // Appel du constructeur pour creer l'instance de Coin
        Coin c ;
        c= new Coin(idCoin,abscisse,ordonnee) ;
        c.afficher();
         // Création d'une liste de coin
        ArrayList<Coin>ListeCoins;
        ListeCoins = new ArrayList<>();
        ListeCoins.add(c);
        //Création d'une Ouverture
        int idOuverture;
        double dimX, dimY ;
        System.out.println("Identifiant de l'Ouverture : ");
        idOuverture = Lire.i();
        System.out.println("Dimension en x de l'Ouverture " + idOuverture + " : ");
        dimX = Lire.d();
        System.out.println("Dimension en y de l'Ouverture " + idOuverture + " : ");
        dimY = Lire.d();
        // Appel du constructeur pour créer une instance d'Ouverture
        Ouverture o;
        o = new Ouverture(idOuverture, dimX, dimY);
        o.afficher();
        
        //Création d'un Revêtement
        
    }
}
