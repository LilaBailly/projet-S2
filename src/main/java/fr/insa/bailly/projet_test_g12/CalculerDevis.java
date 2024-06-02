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
        double devisTotal = 0.0;
        ArrayList<ResultatRevetement> resultats = new ArrayList<>();

        System.out.println("Coût par revêtement :");
        for (ResultatRevetement resultat : resultats) {
            double coutTotalRev = resultat.getSurfaceTotale() * resultat.getRevetement().getPrixUnitaire();
            System.out.println(coutTotalRev);
            resultat.setPrixTotal(coutTotalRev); // Mettre à jour le prix total du revêtement dans le résultat
            System.out.println(resultat.getRevetement().getDesignation() + " : " + coutTotalRev + " euros");
            devisTotal += coutTotalRev;
            System.out.println(devisTotal);
        }

        System.out.println("Devis total : " + devisTotal + " euros");
        return resultats;
    }


    public static void afficherDevis(Batiment batiment) {
        ArrayList<ResultatRevetement> resultats = calculerDevis(batiment);

        System.out.println("Devis par revêtement :");
        for (ResultatRevetement resultat : resultats) {
            System.out.println("Identifiant: " + resultat.getRevetement().getIdRevetement()+ " - " +
                               resultat.getRevetement().getDesignation() + " : " + 
                               resultat.getSurfaceTotale() + " m², " + 
                               resultat.getPrixTotal() + " euros (Prix unitaire : " + 
                               resultat.getRevetement().getPrixUnitaire() + " euros/m²)");
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
