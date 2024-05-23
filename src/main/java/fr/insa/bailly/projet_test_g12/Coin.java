/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author ElèveTEST
 */

public class Coin {

    public Coin(){
        
    }
    
    // Déclaration des attributs de la classe coin
    private String idCoin ;
    private double cx ;
    private double cy ;
    
    //déclaration du constructeur
    Coin(String id, double x, double y) {
        this.idCoin=id ;
        this.cx=x ;
        this.cy=y ;
    }
    //get et set pour donner et utiliser les attributs
    public String getidCoin () {
        return idCoin ;
    }
    public void setidCoin(String idCoin) {
    this.idCoin = idCoin ;
    }
    public double getcx () {
        return cx ;
    }
    public void setcx(double cx) {
    this.cx = cx ;
    }
    public double getcy () {
        return cy ;
    }
    public void setcy(double cy) {
    this.cy = cy ;
    }
    //méthode pour afficher le coin
    void afficherCoin(){
            System.out.println(this.idCoin+" ; "+this.cx+" ; "+this.cy);
    }
    @Override 
    public String toString(){
        return idCoin+" ; "+cx+" ; "+cy;
    }
}
