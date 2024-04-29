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
    private int idMur ;
    private Coin coinDebut ;
    private Coin coinFin ;
    private int nbrPorte ;
    private int nbrFenetre ;
    private double hauteur ;
    private double surface ;
    private int nbrRev ;
    private ArrayList<Revetement> listeRevetement ;
    
    public Mur(){
        
    }
    //déclaration du constructeur
    public Mur(int id, Coin debut, Coin fin, int porte, int fenetre, int nbrRev) {
        this.idMur = id ;
        this.coinDebut = debut ;
        this.coinFin = fin ;
        this.nbrPorte = porte ;
        this.nbrFenetre = fenetre ;
        this.nbrRev = nbrRev ;
        for (int i=0; i<liste_rev_mur.size();i++){
            
        }
        //this.listerev = //méthode choix du revetement
    }
    //ajouter les revetements au constructeur et faire al méthode d'ajout
    public double Longueur(){
        return Math.sqrt(Math.pow(this.coinFin.getcx() - this.coinDebut.getcx(),2)
                +Math.pow(this.coinFin.getcy() - this.coinDebut.getcy(),2)) ;//faire get coordonnée
    }
    //Calcul de la surface du mur
    public double surface (double hauteur){
        surface=this.Longueur()*hauteur ;
        return surface ;
    }
    //procédure pour vérifier si le revetement convient ou non au mur
    
    void afficher(){
            System.out.println("Identifiant :"+this.idMur+" Coin de début :"+this.coinDebut+"Coin de fin :"+this.coinFin+"Nombre de fenetre :"+this.nbrFenetre+" Nombre de porte"+this.nbrPorte+" Surface :");
    } 
    //méthode pour calculer le coût d'un mur
    /*public double cout(Mur mur){
        double cout = 0 ;
        double s = surface(mur.hauteur) ;
        for ( int i=0; i<mur.listerev.size(); i++){
         cout = cout + s*listerev[i].Revetement.getprixunitaire() ;   
        }
        return cout ;
    }*/
    
        //get et set pour donner et utiliser les attributs
    public int getidMur(){
    return idMur ;
    }
    public void setidMur(int idMur) {
    this.idMur = idMur ;
    }
    public Coin getcoinDebut(){
    return coinDebut ;
    }
    public void setcoinDebut(Coin coinDebut) {
    this.coinDebut = coinDebut ;
    }
    public Coin getcoinFin(){
    return coinFin ;
    }
    public void setcoinFin(Coin coinFin) {
    this.coinFin = coinFin ;
    }
    public int getnbrPorte(){
    return nbrPorte ;
    }
    public void setnbrPorte(int nbrPorte) {
    this.nbrPorte = nbrPorte ;
    }
    public int getnbrFenetre(){
    return nbrFenetre ;
    }
    public void setnbrFenetre(int nbrFenetre){
    this.nbrFenetre = nbrFenetre ;
    }
    public double gethauteur(){
    return hauteur ;
    }
    public void sethauteur(double hauteur) {
    this.hauteur = hauteur ;
    }
    /*void afficher(){
            System.out.println("Identifiant :"+this.idMur+" Coin de début :"+this.coinDebut+"Coin de fin :"+this.coinFin+"Nombre de fenetre :"+this.nbrFenetre+" Nombre de porte"+this.nbrPorte+" Surface :");
    } 
    ??procedure pour calculer le prix au fur et à mesure ??*/
   
    
    @Override 
    public String toString(){
        return "Mur [idMur : "+idMur+", coinDebut : "+coinDebut+", coinFin : "+coinFin+", nbrPortes : "+nbrPorte+", nbrFenetre : "+nbrFenetre+"ListeRevetements : ]";
    }
    
}
