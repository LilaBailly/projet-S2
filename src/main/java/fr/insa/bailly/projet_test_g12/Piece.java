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
    private String idPiece ;
    private String idsol ;
    private String idplafond ;
    private ArrayList<Mur> listeMurs ;
    private String usage ;
    private Sol sol;
    private Plafond plafond;
    private static int compteur = 0;
    public Piece() {
        this.listeMurs = new ArrayList<>();
    }
    public Piece( String usage, String idsol,String idplafond, ArrayList<Mur> listeMurs){
        this.idPiece = "Pi" + (++compteur);
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
                if (revetement.getpourMur()) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfaceMur = mur.CalculerSurfaceMur();
                    resultat.addToSurfaceTotale(surfaceMur);
                    resultat.addToPrixTotal(surfaceMur * revetement.getprixunitaire());
                }
            }
        }

        // Calculer les surfaces et coûts pour le sol
        if (sol != null) {
            for (Revetement revetement : sol.getlisteRevSol()) {
                if (revetement.pourSol) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfaceSol = sol.CalculerSurfaceSol();
                    resultat.addToSurfaceTotale(surfaceSol);
                    resultat.addToPrixTotal(surfaceSol * revetement.getprixunitaire());
                }
            }
        }

        // Calculer les surfaces et coûts pour le plafond
        if (plafond != null) {
            for (Revetement revetement : plafond.getlisteRevetementPlafond()) {
                if (revetement.pourPlafond) {
                    ResultatRevetement resultat = resultats.computeIfAbsent(revetement, k -> new ResultatRevetement(k));
                    double surfacePlafond = plafond.CalculerSurfacePlafond();
                    resultat.addToSurfaceTotale(surfacePlafond);
                    resultat.addToPrixTotal(surfacePlafond * revetement.getprixunitaire());
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
    
    public String getidPiece(){
        return idPiece ;
    }
    public void setidPiece(String idPiece) {
        this.idPiece = idPiece ;
    }
    public String getidSol(){
        return idsol ;
    }
    public void setidSol(String id) {
        this.idsol = id ;
    }
    public String getidPlafond(){
        return idplafond ;
    }
    public void setidPlafond(String id) {
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
    //surface d'une pièce égale surface au sol

    void afficherPiece(){
        System.out.println(this.toString() + " ");
    }
    @Override 
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(idPiece).append(" ; ")
          .append(usage).append(" ; ")
          .append(sol.getidSol()).append(" ; ")
          .append(plafond.getidPlafond()).append(" ; ");

        // Ajouter les identifiants des revêtements
        for (Mur mur : listeMurs) {
            sb.append(mur.getidMur()).append(" ; ");
        }

        return sb.toString();
    }

}