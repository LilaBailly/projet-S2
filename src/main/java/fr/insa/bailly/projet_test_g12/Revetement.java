/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

/**
 *
 * @author Elève
 */
public class Revetement {
    
    
    
    
    // creer la fonction rechercher_Revetement_Designation
    	public static int rechercher_Revetement_Designation (String ligne, String typeRevetement){

            //à modifier pour adapter à la situation, pas chemin fichier je crois
            try {
  		  // Création d'un fileReader pour lire le fichier
  		  FileReader fileReader = new FileReader(cheminFichier);
  		 
  		  // Création d'un bufferedReader qui utilise le fileReader
  		  BufferedReader reader = new BufferedReader(fileReader);
  		 
  		  // une fonction à essayer pouvant générer une erreur
  		  ligne = reader.readLine();
  		  while (ligne != null) {
  			  // découpe la ligne
  			  ligne.split("\n");
  	  if (ligne.contains(typeRevetement) == true) {
  		    System.out.println();               //renvoie la ligne entière du document
        }
    
    // creer la fonction rechercher_Revetement_Identifiant
    
}
