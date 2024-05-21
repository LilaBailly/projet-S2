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
    
    public Piece() {
        this.listeMurs = new ArrayList<>();
    }
    public Piece(int idPiece, String usage, Sol sol,Plafond plafond, ArrayList<Mur> listeMurs){
        this.idPiece=idPiece;
        this.usage=usage;
        this.sol=sol;
        this.plafond=plafond;
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
    
    public int getidPiece(){
        return idPiece ;
    }
    public void setidPiece(int idPiece) {
        this.idPiece = idPiece ;
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
    public void setplafond(Plafond plafond) {
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
            System.out.println(" Piece [ idPiece : "+this.idPiece+" , usage : "+this.usage+" , sol : "+this.sol+" , plafond : "+this.plafond+" , ListeMurs : "+listeMurs+" ]");
    }
    @Override 
    public String toString(){
        return " Piece [ idPiece : "+idPiece+" , usage : "+usage+" , sol : "+sol+" , plafond : "+plafond+" , ListeMurs : "+listeMurs+" ]";
    }

}