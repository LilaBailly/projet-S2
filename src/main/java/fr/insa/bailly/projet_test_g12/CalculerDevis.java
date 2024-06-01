/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author ElèveTEST
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CalculerDevis {

    public static ArrayList<ResultatRevetement> calculerDevis(Batiment batiment) {
        ArrayList<ResultatRevetement> resultats = new ArrayList<>();

        if (batiment instanceof Immeuble) {
            Immeuble immeuble = (Immeuble) batiment;
            for (Niveau niveau : immeuble.getListeNiveaux()) {
                for (Appartement appartement : niveau.getlisteAppart()) {
                    for (Piece piece : appartement.getlistePieces()) {
                        calculerDevisPiece(piece, resultats);
                    }
                }
            }
        } else if (batiment instanceof Maison) {
            Maison maison = (Maison) batiment;
            for (NiveauMaison niveauMaison : maison.getListeNiveaux()) {
                for (Piece piece : niveauMaison.getlistePiece()) {
                    calculerDevisPiece(piece, resultats);
                }
            }
        }

        return resultats;
    }

    private static void calculerDevisPiece(Piece piece, ArrayList<ResultatRevetement> resultats) {
        for (Mur mur : piece.getlisteMurs()) {
            for (Revetement revetement : mur.getlisteRevetementMur()) {
                if (revetement.getPourMur()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfaceMur = mur.CalculerSurfaceMur();
                    resultat.addToSurfaceTotale(surfaceMur);
                    resultat.addToPrixTotal(surfaceMur * revetement.getPrixUnitaire());
                }
            }
        }

        if (piece.getSol() != null) {
            for (Revetement revetement : piece.getSol().getlisteRevSol()) {
                if (revetement.getPourSol()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfaceSol = piece.getSol().CalculerSurfaceSol();
                    resultat.addToSurfaceTotale(surfaceSol);
                    resultat.addToPrixTotal(surfaceSol * revetement.getPrixUnitaire());
                }
            }
        }

        if (piece.getPlafond() != null) {
            for (Revetement revetement : piece.getPlafond().getlisteRevetementPlafond()) {
                if (revetement.getPourPlafond()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfacePlafond = piece.getPlafond().CalculerSurfacePlafond();
                    resultat.addToSurfaceTotale(surfacePlafond);
                    resultat.addToPrixTotal(surfacePlafond * revetement.getPrixUnitaire());
                }
            }
        }
    }

    private static ResultatRevetement trouverOuCreerResultat(ArrayList<ResultatRevetement> resultats, Revetement revetement) {
        for (ResultatRevetement resultat : resultats) {
            if (resultat.getRevetement().equals(revetement)) {
                return resultat;
            }
        }
        ResultatRevetement nouveauResultat = new ResultatRevetement(revetement);
        resultats.add(nouveauResultat);
        return nouveauResultat;
    }

    public static void afficherDevis(Batiment batiment) {
        ArrayList<ResultatRevetement> resultats = calculerDevis(batiment);

        System.out.println("Devis par revêtement :");
        for (ResultatRevetement resultat : resultats) {
            System.out.println(resultat.getRevetement().getDesignation() + " : " + resultat.getSurfaceTotale() + " m², " +
                    resultat.getPrixTotal() + " euros");
        }

        double devisTotal = resultats.stream().mapToDouble(ResultatRevetement::getPrixTotal).sum();
        System.out.println("Devis total : " + devisTotal + " euros");
        
        // Enregistrer le devis dans un fichier texte
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("devis.txt"))) {
            writer.write("Devis par revêtement :\n");
            for (ResultatRevetement resultat : resultats) {
                writer.write("Identifiant: " + resultat.getRevetement().getIdRevetement() + " - " +
                             resultat.getRevetement().getDesignation() + " : " + 
                             resultat.getSurfaceTotale() + " m², " + 
                             resultat.getPrixTotal() + " euros (Prix unitaire : " + 
                             resultat.getRevetement().getPrixUnitaire() + " euros/m²)\n");
            }
            writer.write("\nDevis total : " + devisTotal + " euros\n");
            System.out.println("Le devis a été enregistré dans le fichier devis.txt.");
        } catch (IOException e) {
            System.err.println("Erreur lors de l'écriture du devis dans le fichier : " + e.getMessage());
        }
    
    
    }
}
