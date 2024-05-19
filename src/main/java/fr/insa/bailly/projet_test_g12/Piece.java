/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/lireturn s ;cense-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList ;
/**
 *
 * @author Elève
 */
public class Piece {
    private int idPiece ;
    private int idsol ;
    private int idplafond ;
    private ArrayList<Mur> listeMurs ;
    private String usage ;
    private Sol sol;
    private Plafond plafond;
    public Piece(){

    }
    public Piece(int idPiece, String usage, int idsol,int idplafond, ArrayList<Mur> listeMurs){
        this.idPiece=idPiece;
        this.usage=usage;
        this.idsol=idsol;
        this.idplafond=idplafond;
        this.listeMurs=listeMurs;
 
    }
    
    public double CalculerSurfacePiece() {
        double surface = 0;
        // Calcul de la surface du sol
        surface += sol.CalculerSurfaceSol();
        // Calcul de la surface du plafond
        surface += plafond.CalculerSurfacePlafond();
        // Calcul de la surface de chaque mur et addition à la surface totale
        for (Mur mur : listeMurs) {
            surface += mur.CalculerSurfaceMur();
        }
        return surface;
    }
    public double CalculerCoutTotalParRevetement() {
        double coutTotal = 0;
        // Calcul du coût total par revêtement pour le sol
        coutTotal += sol.cout();
        // Calcul du coût total par revêtement pour le plafond
        coutTotal += plafond.cout();
        // Calcul du coût total par revêtement pour chaque mur
        for (Mur mur : listeMurs) {
            coutTotal += mur.cout();
        }
        return coutTotal;
    }
    
    public int getidPiece(){
        return idPiece ;
    }
    public void setidPiece(int idPiece) {
        this.idPiece = idPiece ;
    }
    public Sol getSol(){
        return sol ;
    }
    public void setidSol(int sol) {
        this.idsol = sol ;
    }
    public Plafond getPlafond(){
        return plafond ;
    }
    public void setidplafond(int plafond) {
        this.idplafond = plafond ;
    }
    public ArrayList<Mur> getlisteMurs(){
        return listeMurs ;
    }
    public void setlisteMurs(ArrayList<Mur> listeMurs) {
        this.listeMurs = listeMurs ;
    }
    public String getusage(){
        return usage ;
    }
    public void setusage(String usage) {
        this.usage = usage ;
    }
    //surface d'une pièce égale surface au sol

    void afficherPiece(){
            System.out.println(" Piece [ idPiece : "+this.idPiece+" , usage : "+this.usage+" , sol : "+this.sol+" , plafond : "+this.plafond+" , ListeMurs : "+listeMurs+" ]");
    }
    @Override 
    public String toString(){
        return " Piece [ idPiece : "+idPiece+" , usage : "+usage+" , sol : "+sol+" , plafond : "+plafond+" , ListeMurs : "+listeMurs+" ]";
    }

}