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

//Série de get pour récuperer les valeurs protégées par "private"
public int getidAppartement(){
    return idAppartement ;
}

public int getidNiveauAppartement(){
    return idNiveauAppartement ;
}
public Niveau getniveauAppartement(){
    return niveauAppartement ;
}
//faire les set
//faire surface
    //afficher()
//toString()
//surface()
//montantRevement()
}
