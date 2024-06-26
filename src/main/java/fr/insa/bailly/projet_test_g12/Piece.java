/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/lireturn s ;cense-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;
import java.util.ArrayList ;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author Elève
 */
public class Piece {
    private int idPiece ;
    private int idsol ;
    private int idplafond ;
    private ArrayList<Mur> listeMurs ;
    private String usage ;
    private Sol sol;
    private Plafond plafond;
    private ArrayList<Coin> listeCoin;
    
    public Piece() {
        this.listeMurs = new ArrayList<>();
    }
    public Piece(int idPiece, String usage, int idsol,int idplafond, ArrayList<Mur> listeMurs){
        this.idPiece = idPiece;
        this.usage=usage;
        this.idsol=idsol;
        this.idplafond=idplafond;
        this.listeMurs=listeMurs;
        
    }
    
    // Méthodes de calcul de la surface et du coût total des revêtements pour cette pièce
    public Map<Revetement, ResultatRevetement> calculerDevisParRevetement() {
        Map<Revetement, ResultatRevetement> resultats = new HashMap<>();

        // Calculer les surfaces et coûts pour les murs
        for (Mur mur : listeMurs) {
            for (Revetement revetement : mur.getlisteRevetementMur()) {
                if (revetement.getPourMur()) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfaceMur = mur.CalculerSurfaceMur();
                    resultat.addToSurfaceTotale(surfaceMur);
                    resultat.addToPrixTotal(surfaceMur * revetement.getPrixUnitaire());
                    System.out.println(resultat);
                }
            }
        }
       // ArrayList<Coin> listeCoin = recupererCoinsMurs();
        // Calculer les surfaces et coûts pour le sol
        if (sol != null) {
            sol = new Sol(idsol, listeCoin,sol.getlisteRevSol() , sol.getNbrTremis() );
            for (Revetement revetement : sol.getlisteRevSol()) {
                if (revetement.pourSol) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfaceSol = sol.CalculerSurfaceSol();
                    resultat.addToSurfaceTotale(surfaceSol);
                    resultat.addToPrixTotal(surfaceSol * revetement.getPrixUnitaire());
                    System.out.println(resultat);
                }
            }
        }

        // Calculer les surfaces et coûts pour le plafond
        if (plafond != null) {
            plafond = new Plafond(idplafond, listeCoin, plafond.getlisteRevetementPlafond(), plafond.getNbrTremisP());
            for (Revetement revetement : plafond.getlisteRevetementPlafond()) {
                if (revetement.pourPlafond) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfacePlafond = plafond.CalculerSurfacePlafond();
                    resultat.addToSurfaceTotale(surfacePlafond);
                    resultat.addToPrixTotal(surfacePlafond * revetement.getPrixUnitaire());
                    System.out.println(resultat);
                }
            }
        }

        return resultats;
    }

    public double CalculerCoutTotalParRevetement() {
        double coutTotal = 0;
        // Calcul du coût total par revêtement pour le sol
        coutTotal += sol.coutSol();
        // Calcul du coût total par revêtement pour le plafond
        coutTotal += plafond.coutPlafond();
        // Calcul du coût total par revêtement pour chaque mur
        for (Mur mur : listeMurs) {
            coutTotal += mur.coutMur();
        }
        return coutTotal;
    }
    public ArrayList<Coin> recupererCoinsMurs(ArrayList<Coin>listeCoin) {
        ArrayList<Coin> coinsMurs = new ArrayList<>();
         for (Coin coin : listeCoin) {
            // Vérification si le coin de début du mur est déjà dans la liste
            if (!coinsMurs.contains(coin)) {
                coinsMurs.add(coin);
            }
        }
        return coinsMurs;
    }
    public int getidPiece(){
        return idPiece ;
    }
    public void setidPiece(int idPiece) {
        this.idPiece = idPiece ;
    }
    public int getidSol(){
        return idsol ;
    }
    public void setidSol(int id) {
        this.idsol = id ;
    }
    public int getidPlafond(){
        return idplafond ;
    }
    public void setidPlafond(int id) {
        this.idplafond = id ;
    }
    public Sol getSol(){
        return sol ;
    }
    public void setSol(Sol sol) {
        this.sol = sol ;
    }
    public Plafond getPlafond(){
        return plafond ;
    }
    public void setPlafond(Plafond plafond) {
        this.plafond = plafond ;
    }
    public ArrayList<Mur> getlisteMurs(){
        return listeMurs ;
    }
    public void setlisteMurs(ArrayList<Mur> listeMurs) {
        this.listeMurs = listeMurs ;
    }
    public String getusage(){
        return usage ;
    }
    public void setusage(String usage) {
        this.usage = usage ;
    }
    public ArrayList<Coin> getrecupererCoinsMurs() {
        return listeCoin;
    }
    
    void afficherPiece(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Pi;")
          .append(idPiece).append(";")
          .append(usage).append(";")
          .append(this.idsol).append(";")
          .append(this.idplafond).append(";");

        // Ajouter les identifiants des revêtements
        for (Mur mur : listeMurs) {
            sb.append(mur.getidMur()).append(";");
        }

        return sb.toString();
    }

}