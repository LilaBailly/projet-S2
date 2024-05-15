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
    //les listes de revetements
    private ArrayList<Revetement> listeRevetement;
    private ArrayList<Revetement> listeRevetementMur;
    private ArrayList<Revetement> listeRevetementSol;
    private ArrayList<Revetement> listeRevetementPlafond;
    
    public Revetement(){
        this.pourSol = false;
        this.pourPlafond = false;
    }

    //déclaration du constructeur
    public Revetement(String ligne) {
        String[] decoupe = ligne.split(";") ;
        
       this.idRevetement = Integer.parseInt(decoupe[0]) ; //conversion du String en int
        this.designation = decoupe[1];
        this.pourMur = Integer.parseInt(decoupe[2]) == 1;
        this.pourSol = Integer.parseInt(decoupe[3]) == 1;
        this.pourPlafond = Integer.parseInt(decoupe[4]) == 1;
        this.prixUnitaire = Double.parseDouble(decoupe[5]);
        if (Integer.parseInt(decoupe[2])==1){
            this.prixUnitaire = Double.parseDouble(decoupe[5]) ; //conversion du String en double
        }
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
    public ArrayList<Revetement> choixRevetementSol (int nbrRev) {
        ArrayList<Revetement> listeRevSolChoix = new ArrayList<>();
        if (nbrRev!=0){
            afficherRevetements(listeRevetementSol);
            for (int i=0;i<nbrRev;i++){
                System.out.println("Choisissez le revêtement "+i+" pour votre sol en indiquant son indentifiant.");
                int idRevSol = Lire.i() ;
                Revetement revChoisi = trouverRevetementParId(listeRevetementSol, idRevSol);
                if (revChoisi != null) {
                    listeRevSolChoix.add(revChoisi);
                } else {
                    System.out.println("Identifiant incorrect, veuillez choisir un identifiant de la liste.");
                    i--; // Répéter la sélection pour ce tour
                }
                 
            }      
        }
       
        return listeRevSolChoix ;
    }
    
    public ArrayList<Revetement> choixRevetementMur (int nbrRev) {
        ArrayList<Revetement> listeRevMurChoix = new ArrayList<>();
        if (nbrRev != 0) {
            afficherRevetements(listeRevetementMur);
            for (int i = 0; i < nbrRev; i++) {
                System.out.println("Choisissez le revêtement " + i + " pour votre mur en indiquant son identifiant.");
                int idRevMur = Lire.i();
                Revetement revChoisi = trouverRevetementParId(listeRevetementMur, idRevMur);
                if (revChoisi != null) {
                    listeRevMurChoix.add(revChoisi);
                } else {
                    System.out.println("Identifiant incorrect, veuillez choisir un identifiant de la liste.");
                    i--; // Répéter la sélection pour ce tour
                }
            }
        }
        return listeRevMurChoix;
    }
    
    
    
    public ArrayList<Revetement> choixRevetementPlafond (int nbrRev) {
        ArrayList<Revetement> listeRevPlafondChoix = new ArrayList<>();
        if (nbrRev != 0) {
            afficherRevetements(listeRevetementPlafond);
            for (int i = 0; i < nbrRev; i++) {
                System.out.println("Choisissez le revêtement " + i + " pour votre plafond en indiquant son identifiant.");
                int idRevPlafond = Lire.i();
                Revetement revChoisi = trouverRevetementParId(listeRevetementPlafond, idRevPlafond);
                if (revChoisi != null) {
                    listeRevPlafondChoix.add(revChoisi);
                } else {
                    System.out.println("Identifiant incorrect, veuillez choisir un identifiant de la liste.");
                    i--; // Répéter la sélection pour ce tour
                }
            }
        }
        return listeRevPlafondChoix;
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
    // Méthode pour afficher les revêtements
    private void afficherRevetements(ArrayList<Revetement> listeRevetements) {
        for (Revetement rev : listeRevetements) {
            System.out.println(rev.Afficher());
        }
    }

    // Méthode pour trouver un revêtement par son ID
    private Revetement trouverRevetementParId(ArrayList<Revetement> listeRevetements, int idRevetement) {
        for (Revetement rev : listeRevetements) {
            if (rev.getidRevetement() == idRevetement) {
                return rev;
            }
        }
        return null;
    }
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
