/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author becqu
 */
import java.util.ArrayList;

class ResultatRevetement {
    private Revetement revetement;
    private double surfaceTotale;
    private double prixTotal;

    public ResultatRevetement(Revetement revetement) {
        this.revetement = revetement;
        this.surfaceTotale = 0.0;
        this.prixTotal = 0.0;
    }

    public Revetement getRevetement() {
        return revetement;
    }

    public double getSurfaceTotale() {
        return surfaceTotale;
    }

    public void addToSurfaceTotale(double surface) {
        this.surfaceTotale += surface;
    }

    public double getPrixTotal() {
        return prixTotal;
    }

    public void addToPrixTotal(double prix) {
        this.prixTotal += prix;
    }
}