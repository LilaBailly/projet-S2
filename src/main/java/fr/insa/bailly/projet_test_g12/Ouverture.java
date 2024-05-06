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
    Ouverture(int id, double x, double y) {
        this.idOuverture=id ;
        this.dimx=x ;
        this.dimy=y ;
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
    void afficher(){
            System.out.println("Identifiant :"+this.idOuverture+" Dimension en x :"+this.dimx+" Dimension en y :"+this.dimy);
    }
    public Ouverture typeOuverture (String type, int id) { //si pas standard, mettre autes para entrée
        type = type.toLowerCase() ;
        if (type=="porte") {
            Ouverture ouv = new Ouverture(id,83,204) ;// peut demander les dimentions à l'utilisateur
            return ouv ;
        }
    }
}
//faire classes filles fenetre porte et tremis, (juste standard, pour dessin ajouter où)