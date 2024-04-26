/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.io.* ;
//import java.util.logging.Level;
//import java.util.logging.Logger;
/**
 *
 * @author Elève
 */
public class Revetement {
    
private int idRevetement ; //chercher si final ou private
private String designation ;
private boolean pourMur ;
final boolean pourSol ;
final boolean pourPlafond ;
private double prixUnitaire ; 
    
public static void LectureRevetement() {
    //lire le doc, découper une ligne, avec cette ligne mettre dans revêtement
    try {
        ArrayList<Revetement> listeRevetement = new ArrayList<>();
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
        BufferedReader reader = new BufferedReader(new FileReader("catalogue revetement.txt"));//changer pour mettre nomfichier
            String ligne = reader.readLine(); 
            while (ligne != null) {
                ligne.split("\n"); // découpe la ligne
                Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
                listeRevetement.add(Rev); //ajout du revetement à la liste
                System.out.println(listeRevetement); //pour tester
        
            }
    } 
    

    catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
    }
    catch (IOException e){
        System.out.println(" Erreur :\n "+e);
    }
}

    //déclaration du constructeur
    Revetement(String ligne) {
        String[] decoupe = ligne.split(";") ;
        this.idRevetement = Integer.parseInt(decoupe[1]) ; //conversion du String en int
        this.designation = decoupe[2] ;
        this.pourMur = Boolean.parseBoolean(decoupe[3]) ; //conversion du String en Boolean
        this.pourSol = Boolean.parseBoolean(decoupe[4]) ; //conversion du String en Boolean
        this.pourPlafond = Boolean.parseBoolean(decoupe[5]) ; //conversion du String en Boolean
        this.prixUnitaire = Double.parseDouble(decoupe[6]) ; //conversion du String en double
    }
    //get et set pour donner et utiliser les attributs
    public int getidRevetement () {
        return this.idRevetement ;
    }
    public String getdesignation () {
        return this.designation ;
    }
    public double getprixunitaire () {
        return this.prixUnitaire ;
    }
    public boolean getpourMur () {
        return this.pourMur ;
    }
    public boolean getpourSol () {
        return this.pourSol ;
    }
    public boolean getpourPlafond () {
        return this.pourPlafond ;
    }
//faire une procédure pour rechercher un revetement
}
