/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//listeRevetement = new ArrayList<>();
    
public static void LectureRevetement(String nomfichier) {
    //lire le doc, découper une ligne, avec cette ligne mettre dans revêtement
    try {
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
        BufferedReader reader = new BufferedReader(new FileReader("catalogue revetement.txt"));
            String ligne = reader.readLine(); 
            while (ligne != null) {
                ligne.split("\n"); // découpe la ligne
                /*Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
                listeRevetement.add(Rev); //ajout du revetement à la liste  */
                System.out.println(ligne); //pour tester
        
            }
    } 
    

    catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
    }
    catch (IOException e){
        System.out.println(" Erreur :\n "+e);
    }
}
}
