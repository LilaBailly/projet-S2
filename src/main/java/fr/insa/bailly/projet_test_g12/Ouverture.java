/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author Elève
 */
public class Ouverture { //est ce qu'on fait une extention de classe avec fenetre,tremis et porte ?
    // Déclaration des attributs de la classe coin
    private int idOuverture ;
    private double dimx ;
    private double dimy ;
    
    //déclaration du constructeur
    Ouverture (String type, int id) { //si pas standard, mettre autres para entrée
        type = type.toLowerCase() ;
        this.idOuverture=id ;
        if (null != type) switch (type) {
            case "porte" -> {
                this.dimx = 0.83 ;
                this.dimy = 2.04 ;// peut demander les dimentions à l'utilisateur
            }
            case "fenetre" -> {
                this.dimx = 0.8 ;
                this.dimy = 0.95 ;
            }
            case "tremis" -> {
                this.dimx = 0.9 ;
                this.dimy = 1.9 ;
            }
            default -> {
            }
        }
    }
    //get et set pour donner et utiliser les attributs
    public int getidOuverture(){
        return idOuverture ;
    }
    public void setidOuverture (int idOuverture) {
        this.idOuverture = idOuverture ;
    }
    public double getdimx(){
        return dimx ;
    }
    public void setdimx (double dimx) {
        this.dimx = dimx ;
    }
    public double getdimy(){
        return dimx ;
    }
    public void setdimy (double dimy) {
        this.dimy = dimy ;
    }
    
    //méthode pour calculer la surface d'une ouverture
    public double surface(){
        return dimx*dimy ;
    }
    void afficherPorte(){
            System.out.println("Porte [ Identifiant : "+this.idOuverture+" , Dimension en x : "+this.dimx+" , Dimension en y :"+this.dimy+" ]");
    }
    void afficherFenetre(){
            System.out.println("Fenetre [ Identifiant : "+this.idOuverture+" , Dimension en x : "+this.dimx+" , Dimension en y :"+this.dimy+" ]");
    }
    void afficherTremis(){
            System.out.println("Tremis [ Identifiant : "+this.idOuverture+" , Dimension en x : "+this.dimx+" , Dimension en y :"+this.dimy+" ]");
    }
    @Override 
    public String toString(){
        return "Ouverture [ Identifiant : "+idOuverture+" , Dimension en x : "+dimx+" , Dimension en y :"+dimy+" ]";
    }
}