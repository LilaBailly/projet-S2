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
    private String idAppartement ;
    private int idNiveauAppartement ;
    private Niveau niveauAppartement ;
    private ArrayList<Piece> listePiece ;
    private static int compteur = 0;
    //Constucteur
    public Appartement (int niveauApp, ArrayList<Piece> listePiece) {
        this.idAppartement = "A" + (++compteur);
        this.idNiveauAppartement = niveauApp ;
        this.listePiece = listePiece ;
    }

    public Appartement(){

    }
    //get et set pour donner et utiliser les attributs
    public String getidAppartement(){
        return idAppartement ;
    }
    public void setidAppartement(String idAppartement){
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
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(idAppartement).append(" ; ");
        sb.append(idNiveauAppartement).append(" ; ");
        for (Piece piece : listePiece) {
            sb.append(piece.getidPiece()).append(" ; ");
        }
        
        return sb.toString();
    }

  
}
