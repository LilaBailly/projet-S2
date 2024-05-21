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

    
public class CalculerDevis {
    
    public static ArrayList<ResultatRevetement> calculerDevis(Batiment batiment) {
        ArrayList<ResultatRevetement> resultats = new ArrayList<>();

        for (Niveau niveau : batiment.getlisteNiveau()) {
            if (niveau instanceof NiveauMaison) {
                // Si le niveau est une maison, traiter les pièces directement
                for (Piece piece : NiveauMaison.getlistePiece()) {
                    calculerDevisPiece(piece, resultats);
                }
            } else {
                // Si le niveau est un appartement, traiter les appartements
                for (Appartement appartement : niveau.getlisteAppart()) {
                    for (Piece piece : appartement.getlistePieces()) {
                        calculerDevisPiece(piece, resultats);
                    }
                }
            }
        }

        return resultats;
    }

    private static void calculerDevisPiece(Piece piece, ArrayList<ResultatRevetement> resultats) {
        for (Mur mur : piece.getlisteMurs()) {
            for (Revetement revetement : mur.getlisteRevetementMur()) {
                if (revetement.getpourMur()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfaceMur = mur.CalculerSurfaceMur();
                    resultat.addToSurfaceTotale(surfaceMur);
                    resultat.addToPrixTotal(surfaceMur * revetement.getprixunitaire());
                }
            }
        }

        if (piece.getSol() != null) {
            for (Revetement revetement : piece.getSol().getlisteRevSol()) {
                if (revetement.getpourSol()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfaceSol = piece.getSol().CalculerSurfaceSol();
                    resultat.addToSurfaceTotale(surfaceSol);
                    resultat.addToPrixTotal(surfaceSol * revetement.getprixunitaire());
                }
            }
        }

        if (piece.getPlafond() != null) {
            for (Revetement revetement : piece.getPlafond().getlisteRevetementPlafond()) {
                if (revetement.getpourPlafond()) {
                    ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                    double surfacePlafond = piece.getPlafond().CalculerSurfacePlafond();
                    resultat.addToSurfaceTotale(surfacePlafond);
                    resultat.addToPrixTotal(surfacePlafond * revetement.getprixunitaire());
                }
            }
        }
    }

    

    public static ArrayList<ResultatRevetement> calculerDevis(Batiment batiment) {
        ArrayList<ResultatRevetement> resultats = new ArrayList<>();
        
        for (Niveau niveau : batiment.getlisteNiveau()) {
            for (Appartement appartement : niveau.getlisteAppart()) {
                for (Piece piece : appartement.getlistePieces()) {
                    // Calculer les surfaces et prix pour les murs
                    for (Mur mur : piece.getlisteMurs()) {
                        for (Revetement revetement : mur.getlisteRevetementMur()) {
                            if (revetement.getpourMur()) {
                                ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                                double surfaceMur = mur.CalculerSurfaceMur();
                                resultat.addToSurfaceTotale(surfaceMur);
                                resultat.addToPrixTotal(surfaceMur * revetement.getprixunitaire());
                            }
                        }
                    }

                    // Calculer les surfaces et prix pour le sol
                    if (piece.getSol() != null) {
                        for (Revetement revetement : piece.getSol().getlisteRevSol()) {
                            if (revetement.getpourSol()) {
                                ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                                double surfaceSol = piece.getSol().CalculerSurfaceSol();
                                resultat.addToSurfaceTotale(surfaceSol);
                                resultat.addToPrixTotal(surfaceSol * revetement.getprixunitaire());
                            }
                        }
                    }

                    // Calculer les surfaces et prix pour le plafond
                    if (piece.getPlafond() != null) {
                        for (Revetement revetement : piece.getPlafond().getlisteRevetementPlafond()) {
                            if (revetement.getpourPlafond()) {
                                ResultatRevetement resultat = trouverOuCreerResultat(resultats, revetement);
                                double surfacePlafond = piece.getPlafond().CalculerSurfacePlafond();
                                resultat.addToSurfaceTotale(surfacePlafond);
                                resultat.addToPrixTotal(surfacePlafond * revetement.getprixunitaire());
                            }
                        }
                    }
                }
            }
        }

        return resultats;
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
            System.out.println(resultat.getRevetement().getdesignation() + " : " + resultat.getSurfaceTotale() + " m², " +
                    resultat.getPrixTotal() + " euros");
        }

        double devisTotal = resultats.stream().mapToDouble(ResultatRevetement::getPrixTotal).sum();
        System.out.println("Devis total : " + devisTotal + " euros");
    }
}

