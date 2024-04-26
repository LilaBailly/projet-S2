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
        String id ;
        ArrayList<Niveau> listeNiveau ;
        
        System.out.println("Donnez le nom du batiment") ;
        id=Lire.S() ;
        //initialiser listeNiveau en allant chercher la liste ou en la créant ?
        Batiment b=new Batiment(id,listeNiveau) ;
        //Création d'un Niveau
        
        //Création d'un Appartement
        
        //Création d'une Pièce
        
        //Création d'un Mur
        int idMur, porte, fenetre, repet, iddebut, idfin ;
        Coin debut, fin ;
        ArrayList<Mur>ListeMurs ;
        ListeMurs = new ArrayList<>() ;
        
        System.out.println("Combien de murs à creer ?");
        repet=Lire.i();
        for(int i =1; i<=repet;){
        System.out.println("Donner un identifiant d'un mur") ;
        idMur=Lire.i() ;
        System.out.println("Donner le coin de début du mur "+idMur) ;
        iddebut=Lire.i() ;//faire méthode pour retrouver le coin
        System.out.println("Donner le coin de fin du mur "+idMur) ;
        idfin=Lire.i() ;//faire methode pour trouver le coin
        System.out.println("Donner le nombre de portes du mur "+idMur) ;
        porte=Lire.i() ;
        System.out.println("Donner le nombre de fenetres du mur "+idMur) ;
        fenetre=Lire.i() ;
        // Appel du constructeur pour creer l'instance de Mur
        Mur m = new Mur(idMur,debut,fin, porte, fenetre) ;
        m.afficher();
        ListeMurs.add(m);
        i=i+1;
        } 
        //Création d'un Sol
        
        //Création d'un Plafond
        
        // Création d'un coin 
        int idCoin, n, m;
        double abscisse, ordonnee ;
        ArrayList<Coin>ListeCoins;
        ListeCoins = new ArrayList<>();
        System.out.println("Combien de coin ?");
        n=Lire.i();
        for(int i =1; i<=n;){
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
        ListeCoins.add(c);
        i=i+1;
        }
         // Renvoie d'une liste de coin
         m=ListeCoins.size();
        System.out.println("nombre élément dans la liste de coin "+m);
        for(Coin elem: ListeCoins)
       {
       	 System.out.println (elem);
       }
        
        
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
          Revetement.LectureRevetement();
    }
} 