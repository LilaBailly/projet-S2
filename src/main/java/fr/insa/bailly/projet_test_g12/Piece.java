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
private int sol ;
private int plafond ;
private ArrayList<Mur> listeMurs ;
private String usage ;
//get et set pour donner et utiliser les attributs
public Piece(){
    
}
public Piece(int idPiece, String usage, int sol,int plafond, ArrayList<Mur> listeMurs){
    this.idPiece=idPiece;
    this.usage=usage;
    this.sol=sol;
    this.plafond=plafond;
    this.listeMurs=listeMurs;
}
public int getidPiece(){
    return idPiece ;
}
public void setidPiece(int idPiece) {
    this.idPiece = idPiece ;
}
public int getsol(){
    return sol ;
}
public void setsol(int sol) {
    this.sol = sol ;
}
public int getplafond(){
    return plafond ;
}
public void setplafond(int plafond) {
    this.plafond = plafond ;
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
            System.out.println("idPiece [ idPiece : "+this.idPiece+" , usage : "+this.usage+" , sol : "+this.sol+" , plafond : "+this.plafond+" , ListeMurs : "+listeMurs+" ]");
    }
    @Override 
    public String toString(){
        return "idPiece [ idPiece : "+idPiece+" , usage : "+usage+" , sol : "+sol+" , plafond : "+plafond+" , ListeMurs : "+listeMurs+" ]";
    }

}