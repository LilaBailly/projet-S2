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
        ArrayList<Revetement> liste_rev_mur = new ArrayList<>() ;
        ArrayList<Revetement> liste_rev_sol = new ArrayList<>() ;
        ArrayList<Revetement> liste_rev_plafond = new ArrayList<>();
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
        BufferedReader reader = new BufferedReader(new FileReader("catalogue revetement.txt"));
        while (reader.ready()) {
            String ligne =reader.readLine() ;
            Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
            //ajout du revetement à la/aux listes auquel il appartient
            if (Rev.getpourMur()==true){
                liste_rev_mur.add(Rev) ;
            }
            if (Rev.getpourSol()==true){
                liste_rev_sol.add(Rev) ;
            }
            if (Rev.getpourPlafond()==true){
                liste_rev_plafond.add(Rev) ;
            }
            
        System.out.println (liste_rev_plafond.size()) ;
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
        this.idRevetement = Integer.parseInt(decoupe[0]) ; //conversion du String en int
        this.designation = decoupe[1] ;
        this.pourMur = Boolean.parseBoolean(decoupe[2]) ; //conversion du String en Boolean
        this.pourSol = Boolean.parseBoolean(decoupe[3]) ; //conversion du String en Boolean
        this.pourPlafond = Boolean.parseBoolean(decoupe[4]) ; //conversion du String en Boolean
        this.prixUnitaire = Double.parseDouble(decoupe[5]) ; //conversion du String en double
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
