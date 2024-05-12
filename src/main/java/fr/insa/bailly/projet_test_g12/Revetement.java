/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.io.* ;
import java.lang.Object ;
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
    private ArrayList<Revetement> listeRevetement;
    private ArrayList<Revetement> listeRevetementMur;
    private ArrayList<Revetement> listeRevetementSol;
    private ArrayList<Revetement> listeRevetementPlafond;
    //déclaration du constructeur
    public Revetement(String ligne) {
        String[] decoupe = ligne.split(";") ;
        //Revetement nouveauRevetementMur = new Revetement(ligne);
        //Revetement nouveauRevetementSol = new Revetement(ligne);
        //Revetement nouveauRevetementPlafond = new Revetement(ligne);
        this.listeRevetement = LectureRevetement();
        this.listeRevetementMur = listeRevetementMur();
        this.listeRevetementSol = listeRevetementSol();
        this.listeRevetementPlafond = listeRevetementPlafond();
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
    public static ArrayList<Revetement> LectureRevetement() {
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
            reader.close();
        } 
        catch(FileNotFoundException err){
            System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
        }
        catch (IOException e){
            System.out.println(" Erreur :\n "+e);
        }
        return listeRev ;
    }

    //méthode pour choisir un revetement, à finir
    public ArrayList<Revetement> choixRevetementSol (int nbrrev) {
        ArrayList<Revetement> listerevSol = new ArrayList<>() ;
        if (nbrrev!=0){
            for (int j=0 ; j<listeRevetementSol.size() ; j++) {
                listeRevetementSol.get(j).Afficher(); //afficher la liste des possibilités
            }
            for (int i=0;i<nbrrev;i++){
                System.out.println("Choisissez le revêtement "+i+" pour votre sol en indiquant son indentifiant.");
                int idRevSol = Lire.i() ;
                for (int y=0;y<listeRevetementSol.size() ; y++){
                    if (idRevSol!=listeRevetementSol.get(y).getidRevetement()){
                        System.out.println("identifiant incorrect, veuillez choisir un identifiant de la liste :");
                        idRevSol = Lire.i() ;
                    }
                }
                //ici, rechercher dans la liste le revetement et le renvoyer
                for (int u=0;u<listeRevetementSol.size();u++){
                    if (listeRevetementSol.get(u).getidRevetement()==idRevSol){
                        System.out.println(listeRevetementSol.get(u));
                        listerevSol.add(listeRevetementSol.get(u)) ;
                    }
                }  
            }      
        }
        else{
            listerevSol=null ;
        }
        return listerevSol ;
    }
    public ArrayList<Revetement> choixRevetementMur (int nbrrev) {
        ArrayList<Revetement> listerevMur = new ArrayList<>() ;
        if (nbrrev!=0){
            for (int j=0 ; j<listeRevetementMur.size() ; j++) {
                listeRevetementMur.get(j).Afficher(); //afficher la liste des possibilités
            }
            for (int i=0;i<nbrrev;i++){
                System.out.println("Choisissez le revêtement "+i+" pour votre mur en indiquant son indentifiant.");
                int idRevMur = Lire.i() ;
                for (int y=0;y<listeRevetementMur.size() ; y++){
                    if (idRevMur!=listeRevetementMur.get(y).getidRevetement()){
                        System.out.println("identifiant incorrect, veuillez choisir un identifiant de la liste :");
                        idRevMur = Lire.i() ;
                    }
                }
                //ici, rechercher dans la liste le revetement et le renvoyer
                for (int u=0;u<listeRevetementMur.size();u++){
                    if (listeRevetementMur.get(u).getidRevetement()==idRevMur){
                        System.out.println(listeRevetementMur.get(u));
                        listerevMur.add(listeRevetementMur.get(u)) ;
                    }
                }  
            }        
        }
        else{
            listerevMur=null ;
        }
        return listerevMur ;
    }

    public ArrayList<Revetement> choixRevetementPlafond (int nbrrev) {
        ArrayList<Revetement> listerevPlafond = new ArrayList<>() ;
        if (nbrrev!=0){
            for (int j=0 ; j<listeRevetementPlafond.size() ; j++) {
                listeRevetementPlafond.get(j).Afficher(); //afficher la liste des possibilités
            }
            for (int i=0;i<nbrrev;i++){
                System.out.println("Choisissez le revêtement "+i+" pour votre Plafond en indiquant son indentifiant.");
                int idRevPlafond = Lire.i() ;
                for (int y=0;y<listeRevetementPlafond.size() ; y++){
                    if (idRevPlafond!=listeRevetementPlafond.get(y).getidRevetement()){
                        System.out.println("identifiant incorrect, veuillez choisir un identifiant de la liste :");
                        idRevPlafond = Lire.i() ;
                    }
                }
                //ici, rechercher dans la liste le revetement et le renvoyer
                for (int u=0;u<listeRevetementPlafond.size();u++){
                    if (listeRevetementPlafond.get(u).getidRevetement()==idRevPlafond){
                        System.out.println(listeRevetementPlafond.get(u));
                        listerevPlafond.add(listeRevetementPlafond.get(u)) ;
                    }
                }  
            }        
        }
        else{
            listerevPlafond=null ;
        }
        return listerevPlafond ;
    }
/*
    // permet la création d'une liste contenant seulement les revetements pour mur
    public ArrayList<Revetement> listeRevetementMur () {
        ArrayList<Revetement> listeRevMur = new ArrayList<>() ;
        for (int i=0; i<listeRevetement.size(); i++) {
            Revetement Rev = listeRevetement.get(i) ;
            if (Rev.getpourMur()==true){
                  listeRevMur.add(Rev) ;
            }
        }
    return listeRevMur ;
    }*/
    
    public ArrayList<Revetement> listeRevetementMur() {
        ArrayList<Revetement> listeRevMur = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getpourMur()) {
                listeRevMur.add(rev);
            }
        }
        return listeRevMur;
    }

    public ArrayList<Revetement> listeRevetementSol () {
        ArrayList<Revetement> listeRevSol = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getpourSol()) {
                listeRevSol.add(rev);
            }
        }
        return listeRevSol;
    }

    
    public ArrayList<Revetement> listeRevetementPlafond() {
        ArrayList<Revetement> listeRevPlafond = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getpourPlafond()) {
                listeRevPlafond.add(rev);
            }
        }
        return listeRevPlafond;
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
    
    public String Afficher(){
        return "Revetement [ idRevetement : "+idRevetement+" , désignation : "+designation+" , prix unitaire : "+prixUnitaire+" ]";
    }
}
