/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.io.* ;
/**
 *
 * @author Elève
 */
public class Revetement {
    
    private int idRevetement ; 
    private String designation ;
    private boolean pourMur ;
    final boolean pourSol ;
    final boolean pourPlafond ;
    private double prixUnitaire ; 
    //les listes de revetements
    private static ArrayList<Revetement> listeRevetement= new ArrayList<>();
    private static ArrayList<Revetement> listeRevetementMur= new ArrayList<>();
    private static ArrayList<Revetement> listeRevetementSol= new ArrayList<>();
    private static ArrayList<Revetement> listeRevetementPlafond= new ArrayList<>();
    private ArrayList<Revetement> listeRevMurChoix= new ArrayList<>();
    private ArrayList<Revetement> listeRevSolChoix= new ArrayList<>();
    private ArrayList<Revetement> listeRevPlafondChoix= new ArrayList<>();
             
    
    
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
        //System.out.println("pourMur : " + pourMur);
        this.pourSol = Integer.parseInt(decoupe[3]) == 1;
        //System.out.println("pourMur : " + pourSol);
        this.pourPlafond = Integer.parseInt(decoupe[4]) == 1;
        //System.out.println("pourMur : " + pourPlafond);
        this.prixUnitaire = Double.parseDouble(decoupe[5]);
        /*if (Integer.parseInt(decoupe[2])==1){
            this.prixUnitaire = Double.parseDouble(decoupe[5]) ; //conversion du String en double
        }*/
    }

    //méthode pour lire le catalogue et creer une liste contenant tous les revetements
    public static ArrayList<Revetement> LectureRevetement() {
        //lire le doc, découper une ligne, avec cette ligne mettre dans revêtement
        listeRevetement = new ArrayList<>();
        listeRevetementMur = new ArrayList<>();
        listeRevetementSol = new ArrayList<>();
        listeRevetementPlafond = new ArrayList<>();
        try {
            //création d'un buffered reader qui utilise un filereader pour lire le fichier
            BufferedReader reader = new BufferedReader(new FileReader("catalogue revetement.txt"));
            while (reader.ready()) {
                String ligne =reader.readLine() ;
                Revetement Rev = new Revetement (ligne) ; //Création d'un nouveau revetement
                listeRevetement.add(Rev);
                if (Rev.getPourMur()) {
                    listeRevetementMur.add(Rev);
                }

                if (Rev.getPourSol()) {
                    listeRevetementSol.add(Rev);
                }

                if (Rev.getPourPlafond()) {
                    listeRevetementPlafond.add(Rev);
                }
            }
            reader.close();
        } 
        catch(FileNotFoundException err){
            System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
        }
        catch (IOException e){
            System.out.println(" Erreur :\n "+e);
        }
        return listeRevetement ;
    }

    //méthode pour choisir un revetement, à finir
    public ArrayList<Revetement> choixRevetementSol (int nbrRev) {
        LectureRevetement();
        
        if (nbrRev!=0){
            afficherRevetements(listeRevetementSol);
            for (int i=0;i<nbrRev;i++){
                System.out.println("Choisissez le revêtement "+(i+1)+" pour votre sol en indiquant son indentifiant.");
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
        LectureRevetement();
       
        if (nbrRev != 0) {
            afficherRevetements(listeRevetementMur);
            for (int i = 0; i < nbrRev; i++) {
                System.out.println("Choisissez le revêtement " + (i+1) + " pour votre mur en indiquant son identifiant.");
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
        LectureRevetement();
        
        if (nbrRev != 0) {
            afficherRevetements(listeRevetementPlafond);
            for (int i = 0; i < nbrRev; i++) {
                System.out.println("Choisissez le revêtement " + (i+1) + " pour votre plafond en indiquant son identifiant.");
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

    // Méthode pour afficher les revêtements
    private void afficherRevetements(ArrayList<Revetement> listeRevetements) {
        if (listeRevetements != null) {
            for (Revetement rev : listeRevetements) {
                System.out.println(rev.Afficher());
            }
        } else {
            System.out.println("La liste de revêtements est vide ou non initialisée.");
        }
    }

    // Méthode pour trouver un revêtement par son ID
    public static Revetement trouverRevetementParId(ArrayList<Revetement> listeRevetements, int idRevetement) {
        for (Revetement rev : listeRevetements) {
            if (idRevetement == rev.getIdRevetement()) {
                System.out.println(rev);
                return rev;
                
            }
        }
        return null;
    }
    public ArrayList<Revetement> listeRevetementMur() {
        ArrayList<Revetement> listeRevMur = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getPourMur()==true) {
                listeRevMur.add(rev);
            }
        }
        return listeRevMur;
    }

    public ArrayList<Revetement> listeRevetementSol () {
        ArrayList<Revetement> listeRevSol = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getPourSol()==true) {
                listeRevSol.add(rev);
            }
        }
        return listeRevSol;
    }

    
    public ArrayList<Revetement> listeRevetementPlafond() {
        ArrayList<Revetement> listeRevPlafond = new ArrayList<>();
        for (Revetement rev : listeRevetement) {
            if (rev.getPourPlafond()==true) {
                listeRevPlafond.add(rev);
            }
        }
        return listeRevPlafond;
    }
    
    // Méthode pour calculer le prix total pour un mur avec ce revêtement
    public double calculerPrixMur(Mur mur) {
        double surface = mur.CalculerSurfaceMur(); 
        return surface * prixUnitaire;
    }

    // Méthode pour calculer le prix total pour un sol avec ce revêtement
    public double calculerPrixSol(Sol sol) {
        double surface = sol.CalculerSurfaceSol();
        return surface * prixUnitaire;
    }

    // Méthode pour calculer le prix total pour un plafond avec ce revêtement
    public double calculerPrixPlafond(Plafond plafond) {
        double surface = plafond.CalculerSurfacePlafond();
        return surface * prixUnitaire;
    }
    
    //get pour utiliser les attributs
    public int getIdRevetement () {
        return this.idRevetement ;
    }
    public String getDesignation () {
        return this.designation ;
    }
    public double getPrixUnitaire () {
        return this.prixUnitaire ;
    }
    public boolean getPourMur () {
        return this.pourMur ;
    }
    public boolean getPourSol () {
        return this.pourSol ;
    }
    public boolean getPourPlafond () {
        return this.pourPlafond ;
    }
    public ArrayList<Revetement> getlisteRevetementMur() {
        return this.listeRevetementMur();
    }
    public ArrayList<Revetement> getlisteRevetementSol() {
        return this.listeRevetementSol();
    }
    public ArrayList<Revetement> getlisteRevetementPlafond() {
        return this.listeRevetementPlafond();
    }
    public String Afficher(){
        return " Revetement [ idRevetement : "+this.idRevetement+" , désignation : "+this.designation+" , prix unitaire : "+this.prixUnitaire+" ] ";
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(" ");
        // Ajouter les identifiants des revêtements
        /*for (Revetement rev : listeRevetement) {
            sb.append(rev.getIdRevetement()).append(" ; ");
        }*/

        return sb.toString();
    }
    
}
