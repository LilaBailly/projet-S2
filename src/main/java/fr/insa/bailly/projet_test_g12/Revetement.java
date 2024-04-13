/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Elève
 */
public class Revetement {
    
int idRevetement;
String designation;
boolean pourMur;
boolean pourSol;
boolean pourPlafond;
double prixUnitaire;
ArrayList<Revetement> listeRevetement;
listeRevetement = new ArrayList<>();
    
    //lire le doc, découper une ligne, avec cette ligne mettre dans revêtement
    try {
        // Création d'un fileReader pour lire le fichier
        FileReader fileReader = new FileReader("D:/catalogue revetement.txt");  // Création d'un fileReader pour lire le fichier
        // Création d'un bufferedReader qui utilise le fileReader
  	BufferedReader reader = new BufferedReader(fileReader);

            String ligne = reader.readLine();
            while (ligne != null) {
  		ligne.split("\n"); // découpe la ligne
                Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
                listeRevetement.add(Rev); //ajout du revetement à la liste                        
            }
    
        }
    catch (IOException e) {
        e.printStackTrace();
    }

}
