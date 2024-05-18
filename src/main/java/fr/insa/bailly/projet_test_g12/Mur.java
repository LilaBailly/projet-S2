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
    private Ouverture ouverture;
    
    public Mur(){
        
    }
    
    //déclaration du constructeur
    public Mur(int id, Coin debut, Coin fin, int porte, int fenetre, int nbrRev, ArrayList<Revetement> listeRevetement) {
        this.idMur = id;
        this.coinDebut = debut;
        this.coinFin = fin;
        this.nbrPorte = porte;
        this.nbrFenetre = fenetre;
        this.nbrRev = nbrRev;
        Revetement revetement = new Revetement(); // Create an instance of Revetement
        this.listeRevetement = revetement.choixRevetementMur(nbrRev); // Call instance method
        this.hauteur = 2.5; // Default height value, can be changed later
    }
    
    public Mur(int id, Coin debut, Coin fin, int porte, int fenetre, int nbrRev) {
        this.idMur = id;
        this.coinDebut = debut;
        this.coinFin = fin;
        this.nbrPorte = porte;
        this.nbrFenetre = fenetre;
        this.nbrRev = nbrRev;
        Revetement revetement = new Revetement(); // Create an instance of Revetement
        this.listeRevetement = revetement.choixRevetementMur(nbrRev); // Call instance method
        this.hauteur = 2.5; // Default height value, can be changed later
        this.ouverture = new Ouverture();
    }
    
    public double Longueur(){
        return Math.sqrt(Math.pow(this.coinFin.getcx() - this.coinDebut.getcx(),2)
                +Math.pow(this.coinFin.getcy() - this.coinDebut.getcy(),2)) ;//faire get coordonnée
    }
    //Calcul de la surface du mur
    public double surface (){
        surface=this.Longueur()*this.hauteur ;
        return surface ;
    }
    //méthode pour calculer le coût d'un mur
    public double cout(){
        double cout = 0 ;
        double s = surface()-nbrPorte*ouverture.getsurfacePorte()-nbrFenetre*ouverture.getsurfaceFenetre() ;
        for (Revetement revetement : listeRevetement){
            cout += s * revetement.getprixunitaire();  
        }
       
    return cout ;
    }
    
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
    public int getnbrRev(){
    return nbrRev;
    }
    public void setnbrRev(int nbrRev){
    this.nbrRev = nbrRev ;
    }
    public double gethauteur(){
    return hauteur ;
    }
    public void sethauteur(double hauteur) {
    this.hauteur = hauteur ; //à changer, mettre hauteur du niveau, provisoire pour une pièce
    } 
    void afficherMur(){
            System.out.println(" Mur [ idMur : "+this.idMur+" , coinDebut : "+getcoinDebut()+" , coinFin : "+getcoinFin()+" , nbrPortes : "+this.nbrPorte+" , nbrFenetre : "+this.nbrFenetre+" , nbrRevetement : "+this.nbrRev+" ]");
    }
    @Override 
    public String toString(){
        return " Mur [ idMur : "+idMur+" , coinDebut : "+getcoinDebut()+" , coinFin : "+getcoinFin()+" , nbrPortes : "+nbrPorte+" , nbrFenetre : "+nbrFenetre+" , nbrRevetement : "+nbrRev+" ]";
    }
    
}
