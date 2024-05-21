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
public class Appartement {
    private int idAppartement ;
    private int idNiveauAppartement ;
    private Niveau niveauAppartement ;
    private ArrayList<Piece> listePiece ;

    //Constucteur
    public Appartement (int id, int niveauApp, ArrayList<Piece> listePiece) {
        this.idAppartement = id ;
        this.idNiveauAppartement = niveauApp ;
        this.listePiece = listePiece ;
    }

    public Appartement(){

    }
    //get et set pour donner et utiliser les attributs
    public int getidAppartement(){
        return idAppartement ;
    }
    public void setidAppartement(int idAppartement){
        this.idAppartement = idAppartement ;
    }
    public int getidNiveauAppartement(){
        return idNiveauAppartement ;
    }
    public void setidNiveauAppartement(int idNiveauAppartement){
        this.idNiveauAppartement = idNiveauAppartement ;
    }
    public Niveau getniveauAppartement(){
        return niveauAppartement ;
    }
    public void setniveauAppartement(Niveau niveauAppartement){
        this.niveauAppartement = niveauAppartement ;
    }
    
    public ArrayList<Piece> getlistePieces(){
        return listePiece ;
    }
    public void setListePieces(ArrayList<Piece> listePiece) {
        this.listePiece = listePiece ;
    }
/*public double surface() {
    double s=0 ;
    for (int i=0; i<=listePiece.size(); i++) {
        s=s+this.listePiece.get(i).surface() ;
    }
    return s ;
}*/
    public void afficherAppartement(){
            System.out.println("Appartement [ idAppartement : "+this.idAppartement+" , idNiveauAppartement : "+this.idNiveauAppartement+" , listePiece : "+this.listePiece+" ]");
    }
    @Override 
    public String toString(){
        return "Appartement [ idAppartement : "+idAppartement+" , idNiveauAppartement : "+idNiveauAppartement+" , listePiece : "+listePiece+" ]";
    }

//afficher()
//montantRevement()

  
}
