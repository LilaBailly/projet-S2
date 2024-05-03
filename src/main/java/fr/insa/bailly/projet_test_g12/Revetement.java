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
private ArrayList<Revetement> listeRevetement = LectureRevetement();
private ArrayList<Revetement> listeRevetementMur = listeRevetementMur();
private ArrayList<Revetement> listeRevetementSol = listeRevetementSol();
private ArrayList<Revetement> listeRevetementPlafond = listeRevetementPlafond ();

//déclaration du constructeur
Revetement(String ligne) {
        String[] decoupe = ligne.split(";") ;
        this.idRevetement = Integer.parseInt(decoupe[0]) ; //conversion du String en int
        this.designation = decoupe[1] ;
        if (Integer.parseInt(decoupe[2])==1){
           this.pourMur = true ; 
        }
        else {
            this.pourMur = false ;
        }
        if (Integer.parseInt(decoupe[3])==1){
           this.pourSol = true ; 
        }
        else {
            this.pourSol = false ;
        }
        if (Integer.parseInt(decoupe[4])==1){
           this.pourPlafond = true ; 
        }
        else {
            this.pourPlafond = false ;
        }
        this.prixUnitaire = Double.parseDouble(decoupe[5]) ; //conversion du String en double
    }

//méthode pour lire le catalogue et creer une liste contenant tous les revetements
public static ArrayList LectureRevetement() {
    //lire le doc, découper une ligne, avec cette ligne mettre dans revêtement
    ArrayList<Revetement> listeRev = new ArrayList<>();
    try {
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
        BufferedReader reader = new BufferedReader(new FileReader("catalogue revetement.txt"));
        while (reader.ready()) {
            String ligne =reader.readLine() ;
            Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
            listeRev.add(Rev); //ajout du revetement à la liste
        }
    } 
    catch(FileNotFoundException err){
        System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
    }
    catch (IOException e){
        System.out.println(" Erreur :\n "+e);
    }
return listeRev ;
}

//méthode pour choisir un revetement
public static ArrayList<Revetement> choixRevetement (int nbrrev, ArrayList<Revetement> listechoix) {
//afficher les revetements possibles
ArrayList<Revetement> listerev = new ArrayList<>() ;
if (nbrrev!=0){
    for (int i=0;i<listechoix.size();i++){
        System.out.println("Choisissez le revêtement "+i+"en indiquant son indentifiant.");
        Revetement rev = RechercheRev(Lire.S()) ;// faire la procédure recherche
        listerev.add(rev) ;
    }        
}
else{
    listerev=null ;
}
return listerev ;
}

// permet la création d'une liste contenant seulement les revetements pour mur
public ArrayList<Revetement> listeRevetementMur () {
    ArrayList<Revetement> listeRevMur = new ArrayList<>() ;
    for (int i=0; i<listeRevetement.size(); i++) {
        Revetement Rev = listeRevetement.get(i) ;
        if (Rev.getpourSol()==true){
              listeRevMur.add(Rev) ;
        }
    }
return listeRevMur ;
}
// permet la création d'une liste contenant seulement les revetements pour sol
public ArrayList<Revetement> listeRevetementSol () {
    ArrayList<Revetement> listeRevSol = new ArrayList<>() ;
    for (int i=0; i<listeRevetement.size(); i++) {
        Revetement Rev = listeRevetement.get(i) ;
        if (Rev.getpourSol()==true){
              listeRevSol.add(Rev) ;
        }
    }
return listeRevSol ;
}
// permet la création d'une liste contenant seulement les revetements pour plafond
public ArrayList<Revetement> listeRevetementPlafond () {
    ArrayList<Revetement> listeRevPlafond = new ArrayList<>() ;
    for (int i=0; i<listeRevetement.size(); i++) {
        Revetement Rev = listeRevetement.get(i) ;
        if (Rev.getpourSol()==true){
              listeRevPlafond.add(Rev) ;
        }
    }
return listeRevPlafond ;
}

//get pour utiliser les attributs
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
    public static ArrayList<Revetement> getlisteRevetementMur (){
        return listeRevetementMur ;
    }
    public static ArrayList<Revetement> getlisteRevetementSol (){
        return listeRevetementSol ;
    }
    public static ArrayList<Revetement> getlisteRevetementPlafond (){
        return listeRevetementPlafond ;
    }
}
