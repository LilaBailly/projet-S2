/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList;

/**
 *
 * @author Elève
 */
public class Plafond {
    private int idPlafond ;
    private ArrayList<Coin> listeCoin ;
    private ArrayList<Revetement> listeRevPlafond ;
    private int nbrtremis ; 
    private Piece piece;
    
    public Plafond(){
        this.listeCoin = piece.getrecupererCoinsMurs();
        this.listeRevPlafond = new ArrayList<>();
    }
    //Déclaration du constructeur
    public Plafond (int idPlafond, ArrayList<Coin> listeCoin, ArrayList<Revetement> listeRevetement, int nbrtremis){
        this.idPlafond = idPlafond;
        this.listeCoin = listeCoin ;
        this.listeRevPlafond = listeRevetement ;
        this.nbrtremis = nbrtremis ;
    } 
    public double CalculerSurfacePlafond() {
        double surface = 0 ;
        if (listeCoin.size() < 4) {
            System.out.println("Nombre insuffisant de coins pour calculer la surface.");
            //return surface;
        }
        if (listeCoin.size() > 4) {
            System.out.println("Nombre trop important de coins pour calculer la surface.");
            //return surface;
        }
        Coin coin1 = this.listeCoin.get(0) ;
        Coin coin2 = listeCoin.get(1);
        double x1 = coin1.getcx() ;
        double y1 = coin1.getcy() ;
        double x2 = coin2.getcx() ;
        double y2 = coin2.getcy() ;
        int i = 0 ;
        Ouverture tremis = new Ouverture("tremis") ;
        if (i<4){
            while ((x2== x1 || y2== y1)&&(i<4)) {
                coin2 = this.listeCoin.get(i) ;
                i+=1 ;
                
            } 
            double longueur = Math.abs(coin2.getcx() - coin1.getcx());
            double largeur = Math.abs(coin2.getcy() - coin1.getcy());
            surface = longueur * largeur;
            surface = surface-nbrtremis*tremis.getsurfaceTremis() ;
            System.out.println(surface);
        }
        else {
            System.out.println("Aucun coin de la liste ne permet de calculer la surface, revoir leur coordonnées") ;
            System.out.println("Veillez recommencer et ne pas tenir compte de la surface nulle renovoyée") ;
        }
        return surface ;
    }
    public double coutPlafond(){
        double cout = 0 ;
        double s = CalculerSurfacePlafond() ;
        for (int i=0; i<listeRevPlafond.size(); i++){
             cout = cout + s*listeRevPlafond.get(i).getPrixUnitaire() ;   
        }
        return cout ;
    }
    
    public ArrayList<ResultatRevetement> calculerResultatsRevetements() {
        ArrayList<ResultatRevetement> resultats = new ArrayList<>();
        ArrayList<Revetement> revetementsDuPlafond = getlisteRevetementPlafond();
        for (Revetement revetement : revetementsDuPlafond) {
            ResultatRevetement resultatRevetement = new ResultatRevetement(revetement);
            double surfaceRev = CalculerSurfacePlafond();
            resultatRevetement.addToSurfaceTotale(surfaceRev);
            double prixRev = revetement.getPrixUnitaire();
            resultatRevetement.addToPrixTotal(prixRev);
            resultats.add(resultatRevetement);
        }

        return resultats;
    }
    
    //get et set pour donner et utiliser les attributs
    public int getidPlafond(){
        return idPlafond ;
    }
    public void setidPlafond(int idPlafond) {
        this.idPlafond = idPlafond ;
    }
    public ArrayList<Coin> getlisteCoin(){
        return listeCoin ;
    }
    public void setlisteCoin(ArrayList<Coin> listeCoin) {
        this.listeCoin = listeCoin ;
    }
    public ArrayList<Revetement> getlisteRevetementPlafond(){
        return listeRevPlafond ;
    }
    public void setlisteRevetement(ArrayList<Revetement> liste_rev_plafond) {
        this.listeRevPlafond = liste_rev_plafond ;
    }
    public int getNbrTremisP() {
        return nbrtremis;
    }

    public void setNbrTremisP(int nbrtremis) {
        this.nbrtremis = nbrtremis;
    }
    void afficherPlafond(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Pl;")
          .append(idPlafond).append(";");
        for (Coin coin : listeCoin) {
            sb.append(coin.getidCoin()).append(";");
        }
        // Ajouter les identifiants des revêtements
        for (Revetement rev : listeRevPlafond) {
            sb.append(rev.getIdRevetement()).append(";");
        }
        sb.append(nbrtremis).append(";");
        return sb.toString();
    }
}
