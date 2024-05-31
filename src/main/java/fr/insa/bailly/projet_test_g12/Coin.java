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

    
    // Déclaration des attributs de la classe coin
    private int idCoin ;
    private double cx ;
    private double cy ;
    

    // Constructeur par défaut
    public Coin() {
    }
    //déclaration du constructeur
    public Coin(int id,double x, double y) {
        this.idCoin = id;
        this.cx = x;
        this.cy = y;
    }
    //get et set pour donner et utiliser les attributs
    public int getidCoin () {
        return idCoin ;
    }
    public void setidCoin(int idCoin) {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("C;")
          .append(idCoin).append(";")
          .append(cx).append(";")
          .append(cy).append(";");

        return sb.toString();
    }
}
