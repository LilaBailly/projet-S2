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
    private double surfaceFenetre;
    private double surfacePorte;
    private double surfaceTremis;
    //déclaration du constructeur
    Ouverture (String type, int id) { //si pas standard, mettre autres para entrée
        type = type.toLowerCase() ;
        this.idOuverture=id ;
        if (null != type) switch (type) {
            case "porte" -> {
                this.dimx = 0.83 ;
                this.dimy = 2.04 ;// peut demander les dimentions à l'utilisateur
                this.surfacePorte = this.dimx*this.dimy;
            }
            case "fenetre" -> {
                this.dimx = 0.8 ;
                this.dimy = 0.95 ;
                this.surfaceFenetre = this.dimx*this.dimy;
            }
            case "tremis" -> {
                this.dimx = 0.9 ;
                this.dimy = 1.9 ;
                this.surfaceTremis = this.dimx*this.dimy;
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
        return dimy ;
    }
    public void setdimy (double dimy) {
        this.dimy = dimy ;
    }
    public double getsurfaceFenetre(){
        return surfaceFenetre;
    }
    public void setsurfaceFenetre(double surfaceFenetre){
        this.surfaceFenetre = surfaceFenetre;
    }
    public double getsurfacePorte(){
        return surfacePorte;
    }
    public void setsurfacePorte(double surfacePorte){
        this.surfacePorte = surfacePorte;
    }
    public double getsurfaceTremis(){
        return surfaceTremis;
    }
    public void setsurfaceTremis(double surfaceTremis){
        this.surfaceTremis = surfaceTremis;
    }
    //méthode pour calculer la surface d'une ouverture
    public double surface(){
        return dimx*dimy ;
    }
    void afficherPorte(){
            System.out.println("Porte [ Identifiant : "+this.idOuverture+" , Dimension en x : 0.83 , Dimension en y : 2.04 ]");
    }
    void afficherFenetre(){
            System.out.println("Fenetre [ Identifiant : "+this.idOuverture+" , Dimension en x : 0.8 , Dimension en y : 0.95 ]");
    }
    void afficherTremis(){
            System.out.println("Tremis [ Identifiant : "+this.idOuverture+" , Dimension en x : 0.9 , Dimension en y : 1.9 ]");
    }
    @Override 
    public String toString(){
        return "Ouverture [ Identifiant : "+idOuverture+" , Dimension en x : "+dimx+" , Dimension en y :"+dimy+" ]";
    }
}