/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author Elève
 */
package fr.insa.bailly.projet_test_g12;
import java.util.*;
import java.io.*;

public class Main {
    private ArrayList<Coin>ListeCoins= new ArrayList<>();
    private ArrayList<Mur>ListeMurs= new ArrayList<>();
    private ArrayList<Mur>ListeMursPiece= new ArrayList<>();
    private ArrayList<Ouverture>ListePortes = new ArrayList<>();
    private ArrayList<Ouverture>ListeFenetres = new ArrayList<>();
    private ArrayList<Ouverture>ListeTremis = new ArrayList<>();
    private ArrayList<Piece>ListePieces= new ArrayList<>();
    private ArrayList<Appartement>ListeAppartements= new ArrayList<>();
    private ArrayList<Niveau>ListeNiveaux= new ArrayList<>();
    private ArrayList<NiveauMaison>ListeNiveauMaison= new ArrayList<>();
    private ArrayList<Immeuble>ListeImmeubles= new ArrayList<>();
    private ArrayList<Maison>ListeMaisons= new ArrayList<>();
    private ArrayList<Batiment>ListeBatiments= new ArrayList<>();
    private Revetement revetement;  
    private ArrayList<Revetement>ListeRev = new ArrayList<>();
    
    public Main() {
        this.revetement = new Revetement(); 
    }

    
    public class Resultat {
        private Object objet;
        private String code;

        public Resultat(Object objet, String code) {
            this.objet = objet;
            this.code = code;
        }

        public Object getObjet() {
            return objet;
        }

        public String getCode() {
            return code;
        }
    }

    public <T> Resultat creationObjet(ArrayList<T> liste, T objet, String code) {
        liste.add(objet);
        System.out.println(objet + " créé");
        return new Resultat(objet, code);
    }


        public Resultat creationCoin(){
            String code;
            int id;
            double a,o;
            System.out.println("Identifiant du coin: ");
            id=Lire.i();
            for (int i=0;i<ListeCoins.size();i++){
                if (ListeCoins.get(i).getidCoin()==id){
                    System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le coin :");
                    id=Lire.i();
                }
            }
            System.out.println("Abcisse: ");
            a=Lire.d();
            System.out.println("Ordonnée: ");
            o=Lire.d();
            Coin creacoin=new Coin(id,a,o);
            ListeCoins.add(creacoin);
            code=creacoin.toString();
            return creationObjet(ListeCoins, creacoin, code);
        }
    
    public Resultat creationMur(){
        String code="";
        int idMur, exiCoinDeb, idRecherche, idCoinD, exiCoinFin,idCoinF,  nbrPorte, nbrFenetre, nbrRevetement ;
        Coin coinDebut = null; //a modifier car problème plus tard dans un if
        Coin coinFin = null; //a modifier car problème plus tard dans un if
        System.out.println("Identifiant du mur: ");
        idMur=Lire.i();
        // Vérifie si l'identifiant du mur existe déjà
        for (int i=0;i<ListeMurs.size();i++){
            if (ListeMurs.get(i).getidMur()==idMur){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le mur :");
                idMur=Lire.i();
            }
        }
        // choix pour un coin de début déjà existant ou non
        System.out.println("Le coin de début existe-t-il déjà ? (1 = OUI et 0 = NON)");
        exiCoinDeb=Lire.i();
        while (exiCoinDeb!=0&&exiCoinDeb!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            exiCoinDeb=Lire.i();
        }
        //coin début existe déjà
        if(exiCoinDeb==1){
            System.out.println("Identifiant du coin de début recherché: ");
            idRecherche=Lire.i();
             for (Coin c : ListeCoins) {
                if (c.getidCoin() == idRecherche) {
                    coinDebut = c;
                    
                    break;
                }
            }
            if (coinDebut == null) {
                // Si le coin de début n'est pas trouvé, affiche un message d'erreur 
                System.out.println("Le coin de début recherché n'a pas été trouvé.");
            }
        } 
        else {
            // Si le coin de début n'existe pas, créez-le
            Resultat resCoin = creationCoin();
            code += resCoin.getCode();
            coinDebut = (Coin) resCoin.getObjet();
        }
        
        // choix coin fin existant ou non
        System.out.println("Le coin de fin existe-t-il déjà ? (1 = OUI et 0 = NON)");
        exiCoinFin=Lire.i();
        while (exiCoinFin!=0&&exiCoinFin!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            exiCoinFin=Lire.i();
        }
        // coin fin existe
        if(exiCoinFin==1){
            System.out.println("Identifiant du coin de fin recherché: ");
            idRecherche=Lire.i();
            for (Coin c : ListeCoins) {
                if (c.getidCoin() == idRecherche) {
                    coinFin = c;
                    
                    break;
                }
            }
            if (coinFin == null) {
                // Si le coin de début n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                System.out.println("Le coin de fin recherché n'a pas été trouvé.");
            }
        } 
        // coin fin n'existe pas
        else{
            Resultat resCoin = creationCoin(); // Création du coin
            code += resCoin.getCode(); // Ajout du code du coin à la variable code
            coinFin = (Coin) resCoin.getObjet();
        }
        System.out.println("Combien de porte y a-t-il ?");
        nbrPorte=Lire.i();
        System.out.println("Combien de fenêtre y a-t-il ?");
        nbrFenetre=Lire.i();
        System.out.println("Combien de revêtement y a-t-il ?");
        nbrRevetement=Lire.i();
        //ca marche pas
        ListeRev = revetement.choixRevetementMur(nbrRevetement);
        Mur creamur = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement/*,ListeRev*/);
        ListeMurs.add(creamur);
        code+=creamur.toString();
        return creationObjet(ListeMurs, creamur,code);
    }
    
    
    public Resultat creationPiece(){
        String code;
        int reponse;
        int  idRecherche, idPiece;
        int  nbrMur, sol, plafond;
        Mur mur;
        String usage;
        System.out.println("Identifiant pièce : ");
        idPiece=Lire.i();
        for (int i=0;i<ListePieces.size();i++){
            if (ListePieces.get(i).getidPiece()==idPiece){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour la pièce :");
                idPiece=Lire.i();
            }
        }
        System.out.println("Usage de la pièce :");
        usage=Lire.S();
        System.out.println("Sol : ");
        sol=Lire.i();
        System.out.println("Plafond : ");
        plafond=Lire.i();
        //
        System.out.println("Combien y a-t-il de mur dans la pièce "+idPiece+" ?");
        nbrMur=Lire.i();
        while(nbrMur>4){
            System.out.println("La pièce comporte trop de murs, veuillez donner un chiffre inférieur ou égale à 4 : ");
            nbrMur=Lire.i();
        }
        for (int j=0; j<nbrMur; j++){
            System.out.println("Le mur n°"+(j+1)+" existe-t-il déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant du mur recherché: ");
                idRecherche=Lire.i();
                for (Mur m : ListeMurs) {
                    if (m.getidMur() == idRecherche) {
                        mur = m;
                        ListeMursPiece.add(mur);
                        break;
                    }
                
                    if (m == null) {
                        // Si le mur  n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                        System.out.println("Le mur recherché n'a pas été trouvé.");
                    }
                }
            } 
            //mur n'existe pas encore
            else{
                Resultat resMur = creationMur();
                ListeMursPiece.add((Mur) resMur.getObjet());
                
            }
        }
        Piece creapiece = new Piece(idPiece, usage, sol, plafond, ListeMursPiece);
        ListePieces.add(creapiece);
        code=creapiece.toString();
        return creationObjet(ListePieces, creapiece,code);
    }
    
    public Resultat creationAppartement(){
        String code;
        int idAppartement,idRecherche, niveauApp, nbrPieces, reponse;
        Piece piece;
        System.out.println("Identifiant appartement : ");
        idAppartement=Lire.i();
        for (int i=0;i<ListeAppartements.size();i++){
            if (ListeAppartements.get(i).getidAppartement()==idAppartement){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour l'appartement :");
                idAppartement=Lire.i();
            }
        }
        System.out.println("Quel est le niveau de l'appartement ? ");
        niveauApp=Lire.i();
        System.out.println("Combien y a-t-il de pièces dans l'appartement "+idAppartement+" ?");
        nbrPieces=Lire.i();
        for (int j=0; j<nbrPieces; j++){
            System.out.println("La pièce n°"+(j+1)+" existe-t-elle déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant de la pièce recherchée: ");
                idRecherche=Lire.i();
                for (Piece p : ListePieces) {
                    if (p.getidPiece() == idRecherche) {
                        piece = p;
                        ListePieces.add(piece);
                        break;
                    }
                
                    if (p == null) {
                        // Si le mur  n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                        System.out.println("La pièce recherchée n'a pas été trouvée.");
                    }
                }
            }
            else{
                Resultat resPiece = creationPiece();
                ListePieces.add((Piece) resPiece.getObjet());
                
            }
        }
        Appartement creaappart = new Appartement(idAppartement,niveauApp, ListePieces);
        code=creaappart.toString();
        return creationObjet(ListeAppartements, creaappart,code);
    }
    public Resultat creationNiveauMaison(){
        String code;
        int idNiveauM,idRecherche, nbrPieces, reponse, Hniveau;
        Piece piece;
        System.out.println("Identifiant appartement : ");
        idNiveauM=Lire.i();
        for (int i=0;i<ListeNiveauMaison.size();i++){
            if (ListeNiveauMaison.get(i).getidNiveauMaison()==idNiveauM){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le niveau :");
                idNiveauM=Lire.i();
            }
        }
        System.out.println("Quel est la hauteur du niveau ? ");
        Hniveau=Lire.i();
        System.out.println("Combien y a-t-il de pièces dans l'appartement "+idNiveauM+" ?");
        nbrPieces=Lire.i();
        for (int j=0; j<nbrPieces; j++){
            System.out.println("La pièce n°"+(j+1)+" existe-t-elle déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant de la pièce recherchée: ");
                idRecherche=Lire.i();
                for (Piece p : ListePieces) {
                    if (p.getidPiece() == idRecherche) {
                        piece = p;
                        ListePieces.add(piece);
                        break;
                    }
                
                    if (p == null) {
                        // Si le mur  n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                        System.out.println("La pièce recherchée n'a pas été trouvée.");
                    }
                }
            }
            else{
                Resultat resPiece = creationPiece();
                ListePieces.add((Piece) resPiece.getObjet());
                
            }
        }
        NiveauMaison creaNiveauM = new NiveauMaison(idNiveauM,Hniveau, ListePieces);
        code=creaNiveauM.toString();
        return creationObjet(ListeNiveauMaison, creaNiveauM,code);
    }
    public Resultat creationNiveau(){
        String code;
        int idNiveau, nbrApparts,reponse,idRecherche;
        double hauteur;
        Appartement appart;
        
        System.out.println("Identifiant appartement : ");
        idNiveau=Lire.i();
        for (int i=0;i<ListeNiveaux.size();i++){
            if (ListeNiveaux.get(i).getidNiveau()==idNiveau){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le niveau :");
                idNiveau=Lire.i();
            }
        }
        System.out.println("hauteur : ");
        hauteur=Lire.i();
        System.out.println("Combien y a-t-il d'appartements dans le niveau "+idNiveau+" ?");
        nbrApparts=Lire.i();
        for (int j=0; j<nbrApparts; j++){
            System.out.println("L'apaprtement n°"+(j+1)+" existe-t-il déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant de l'appartement recherché: ");
                idRecherche=Lire.i();
                for (Appartement a : ListeAppartements) {
                    if (a.getidAppartement() == idRecherche) {
                        appart = a;
                        ListeAppartements.add(appart);
                        break;
                    }
                
                    if (a == null) {
                        // Si le mur  n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                        System.out.println("L'appartement recherché n'a pas été trouvé.");
                    }
                }
            }
            else{
                Resultat resAppart = creationAppartement();
                ListeAppartements.add((Appartement) resAppart.getObjet());
                
            }
        }
        
        Niveau creaniveau = new Niveau(idNiveau,hauteur, ListeAppartements);
        code=creaniveau.toString();
        return creationObjet(ListeNiveaux, creaniveau,code);
    }
    
    public Resultat creationBatiment(){
        Batiment creabat = new Batiment();
        String code, idBat = null;
        int typeBatiment,idBatiment, idImmeuble=1, idMaison,nbrNiveaux,reponse,idRecherche;
        Niveau niveau;
        System.out.println("Quel type de bâtiment souhaitez-vous créer ? (1 = Immeuble et 0 = Maison)");
        typeBatiment = Lire.i();
        while (typeBatiment != 0 && typeBatiment != 1) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte : 1 = Immeuble et 0 = Maison");
            typeBatiment = Lire.i();
        }
        
        if (typeBatiment == 1) {
            System.out.println("Identifiant du bâtiment : ");
            idBatiment = Lire.i();
            for (int i = 0; i < ListeBatiments.size(); i++) {
                if (ListeImmeubles.get(i).getidImmeuble() == idBatiment) {
                    System.out.println("L'identifiant existe déjà, donnez un nouvel identifiant pour le bâtiment :");
                    idBat = Lire.S();
                }
            }
            System.out.println("Combien y a-t-il de niveaux dans l'immeuble : "+idBat+" ?");
            nbrNiveaux=Lire.i();
            for (int j=0; j<nbrNiveaux; j++){
                System.out.println("Le niveau n°"+(j+1)+" existe-t-il déjà ? (1 = OUI et 0 = NON)");
                reponse=Lire.i();
                while (reponse!=0&&reponse!=1){
                    System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                    reponse=Lire.i();
                }
                if(reponse==1){
                    System.out.println("Identifiant du niveau recherché: ");
                    idRecherche=Lire.i();
                    for (Niveau n : ListeNiveaux) {
                        if (n.getidNiveau() == idRecherche) {
                            niveau = n;
                            ListeNiveaux.add(niveau);
                            break;
                        }

                        if (n == null) {
                            // Si le mur  n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
                            System.out.println("Le niveau recherché n'a pas été trouvé.");
                        }
                    }
                }
                else{
                    Resultat resNiveau = creationNiveau();
                    ListeNiveaux.add((Niveau) resNiveau.getObjet());

                }
            }
            Immeuble immeuble = new Immeuble(idBatiment,ListeNiveaux);
            immeuble.setlisteNiveaux(ListeNiveaux);
            ListeImmeubles.add(immeuble);
            ListeBatiments.add(immeuble);
            creabat = immeuble;
        }
        else {
            System.out.println("Identifiant du bâtiment : ");
            idBatiment = Lire.i();
            for (int i = 0; i < ListeBatiments.size(); i++) {
                if (ListeImmeubles.get(i).getidImmeuble() == idBatiment) {
                    System.out.println("L'identifiant existe déjà, donnez un nouvel identifiant pour le bâtiment :");
                    idBat = Lire.S();
                }
            }
            System.out.println("Combien de niveaux comporte la maison ?");
            int nbNiveauM = Lire.i();
            for (int i = 0; i < nbNiveauM; i++) {
                System.out.println("Le niveau n°" + (i + 1) + " existe-t-il déjà ? (1 = OUI et 0 = NON)");
                int reponseM = Lire.i();
                while (reponseM != 0 && reponseM != 1) {
                    System.out.println("Valeur incorrecte; veuillez donner une valeur correcte : 1 = OUI et 0 = NON");
                    reponseM = Lire.i();
                }
                if (reponseM == 1) {
                    System.out.println("Identifiant du niveau recherché :");
                    idRecherche = Lire.i();
                    NiveauMaison niveauM = null;
                    for (NiveauMaison nM : ListeNiveauMaison) {
                        if (nM.getidNiveauMaison()== idRecherche) {
                            niveauM = nM;
                            ListeNiveauMaison.add(niveauM);
                            break;
                        }
                    }
                    if (niveauM == null) {
                        System.out.println("Le niveau recherché n'a pas été trouvé.");
                    }
                } else {
                    Resultat resNiveauM = creationNiveauMaison();
                    ListeNiveauMaison.add((NiveauMaison) resNiveauM.getObjet());
                }
            }
            Maison maison = new Maison(idBatiment, ListeNiveauMaison);
            ListeMaisons.add(maison);
            ListeBatiments.add(maison);
            creabat= maison;
        }    
            code=creabat.toString();
        
        return creationObjet(ListeBatiments, creabat,code);
    }
   
    public ArrayList<Coin> getListeCoins() {
        return ListeCoins;
    }
    
    public ArrayList<Mur> getListeMurs() {
        return ListeMurs;
    }
    public ArrayList<Mur> getListeMursPiece() {
        return ListeMursPiece;
    }

    public ArrayList<Piece> getListePieces() {
        return ListePieces;
    }

    public ArrayList<Appartement> getListeAppartements() {
        return ListeAppartements;
    }

    public ArrayList<Niveau> getListeNiveaux() {
        return ListeNiveaux;
    }
    public ArrayList<NiveauMaison> getListeNiveauMaison() {
        return ListeNiveauMaison;
    }

    public ArrayList<Immeuble> getListeImmeubles() {
        return ListeImmeubles;
    }
    public ArrayList<Maison> getListeMaisons() {
        return ListeMaisons;
    }
    public ArrayList<Batiment> getListeBatiments() {
        return ListeBatiments;
    }
    
    public void ecrireFichier(String texte) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("Liste_Batiment.txt", true);
            bw = new BufferedWriter(fw);
            bw.write(texte);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void supprimerLigne(String nomFichier) {
        File FichierOrigine = new File(nomFichier);
        File FichierTemporaire = new File("tempFile.txt");
        BufferedReader reader = null;
        BufferedWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(FichierOrigine));
            writer = new BufferedWriter(new FileWriter(FichierTemporaire));
            String lineToRemove = "null , ";
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                if (!currentLine.equals(lineToRemove)) {
                    writer.write(currentLine + System.getProperty("line.separator"));
                }
            }
        } 
        catch (IOException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                if (writer != null) {
                    writer.close();
                }
                if (reader != null) {
                    reader.close();
                }
                if (FichierOrigine.delete()) {
                    if (!FichierTemporaire.renameTo(FichierOrigine)) {
                        System.out.println("Renaming the temp file failed.");
                    }
                } 
                else {
                    System.out.println("Failed to delete the original file.");
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void supprimerLignesVides(String nomFichier) {
        try {
            File fichierOriginal = new File(nomFichier);
            File fichierTemporaire = new File("fichier_temporaire.txt");

            BufferedReader lecteur = new BufferedReader(new FileReader(fichierOriginal));
            BufferedWriter ecrivain = new BufferedWriter(new FileWriter(fichierTemporaire));

            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                // Vérifier si la ligne n'est pas vide ou composée uniquement d'espaces
                if (!ligne.trim().isEmpty()) {
                    ecrivain.write(ligne);
                    ecrivain.newLine(); // Ajouter un saut de ligne après chaque ligne non vide
                }
            }

            // Fermer les flux de lecture et d'écriture
            lecteur.close();
            ecrivain.close();

            // Renommer le fichier temporaire en utilisant le nom du fichier original
            if (!fichierTemporaire.renameTo(fichierOriginal)) {
                System.out.println("Impossible de renommer le fichier temporaire.");
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        } 
        catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture ou de l'écriture du fichier.");
        }
    }
    
    public void lireFichier() {
        try (BufferedReader br = new BufferedReader(new FileReader("Liste_Batiment.txt"))) {
            String ligne;
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne);
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas encore.");
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Coin parseCoinData(String[] tab, int IndexDebut) {
        int id = Integer.parseInt(tab[IndexDebut]);
        //System.out.println(tab[IndexDebut]);
        double a = Double.parseDouble(tab[IndexDebut+4]);
        //System.out.println(tab[IndexDebut+4]);
        double o = Double.parseDouble(tab[IndexDebut+8]);
        //System.out.println(tab[IndexDebut+8]);
        return new Coin(id, a, o);
    }
    private void parseCoin(String[] tab){
        if (tab.length >= 13) {
            Coin coin = parseCoinData(tab,4);
            ListeCoins.add(coin);
        }
    }/*
    private Revetement parseRevData(String[] tab, int IndexDebut) {
        int idRev = Integer.parseInt(tab[IndexDebut]);
        System.out.println(tab[IndexDebut]);
        String designation= tab[IndexDebut+4];
        System.out.println(tab[IndexDebut+4]);
        double prix = Double.parseDouble(tab[IndexDebut+8]);
        System.out.println(tab[IndexDebut+8]);
        return new Revetement();
    }*/
    private Mur parseMurData(String[] tab, int IndexDebut) {
        int idMur = Integer.parseInt(tab[IndexDebut]);
        //System.out.println(tab[IndexDebut]);
        Coin coinDebut = parseCoinData(tab, IndexDebut+8);
        //System.out.println(tab[IndexDebut+8]);
        Coin coinFin = parseCoinData(tab, IndexDebut+25);
        //System.out.println(tab[IndexDebut+25]);
        int nbrPorte = Integer.parseInt(tab[IndexDebut+38]);
        //System.out.println(tab[IndexDebut+38]);
        int nbrFenetre = Integer.parseInt(tab[IndexDebut+42]);
        //System.out.println(tab[IndexDebut+42]);
        int nbrRevetement = Integer.parseInt(tab[IndexDebut+46]);
        //System.out.println(tab[IndexDebut+46]);
        ArrayList<Revetement> listeRev = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] RevData = new String[53];
            System.arraycopy(tab, i, RevData, 0, Math.min(53, tab.length - i));
            /*Revetement rev = parseRevetementData(RevData,4);
            if (rev != null) {
                RevData.add(rev);
            }*/
        }
        return new Mur(idMur, coinDebut, coinFin, nbrPorte, nbrFenetre, nbrRevetement,ListeRev);
        
    }
    private void parseMur(String[] tab){
        if (tab.length >= 13) {
            Mur mur = parseMurData(tab, 4);
            ListeMurs.add(mur);
        }
    }
    
    private Piece parsePieceData(String[] tab,int IndexDebut){
        int idPiece = Integer.parseInt(tab[IndexDebut]);
        System.out.println(IndexDebut);
        String usage = tab[IndexDebut+4];
        System.out.println(IndexDebut+4);
        int sol = Integer.parseInt(tab[IndexDebut+8]);
        System.out.println(IndexDebut+8);
        int plafond = Integer.parseInt(tab[IndexDebut+12]);
        System.out.println(IndexDebut+12);
        ArrayList<Mur> murs = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] murData = new String[53];
            System.arraycopy(tab, i, murData, 0, Math.min(53, tab.length - i));
            Mur mur = parseMurData(murData,4);
            if (mur != null) {
                murs.add(mur);
            }
        }
        return new Piece(idPiece, usage, sol, plafond, murs);        
        
    }
    public void parsePiece(String[] tab){
        if (tab.length>=51){//changer taille
            Piece piece = parsePieceData(tab, 4);
            ListePieces.add(piece);
        }
    }
    public Appartement parseAppartementData(String[] tab, int IndexDebut){
        int idAppart = Integer.parseInt(tab[IndexDebut]);
        int NiveauAppart =Integer.parseInt(tab[IndexDebut+4]);
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] pieceData = new String[53];
            System.arraycopy(tab, i, pieceData, 0, Math.min(53, tab.length - i));
            Piece piece = parsePieceData(pieceData,4);
            if (piece != null) {
                pieces.add(piece);
            }
        }
        return new Appartement(idAppart,NiveauAppart,pieces);
    }
    public void parseAppartement(String [] tab){
        if (tab.length>=51){//changer taille
            Appartement appart = parseAppartementData(tab, 4);
            ListeAppartements.add(appart);
        }
    }
    public Niveau parseNiveauData(String[] tab, int IndexDebut){
        int idNiveau = Integer.parseInt(tab[IndexDebut]);
        double hauteur =Double.parseDouble(tab[IndexDebut+4]);
        ArrayList<Appartement> apparts = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] pieceData = new String[53];
            System.arraycopy(tab, i, pieceData, 0, Math.min(53, tab.length - i));
            Appartement appart = parseAppartementData(pieceData,4);
            if (appart != null) {
                apparts.add(appart);
            }
        }
        return new Niveau(idNiveau,hauteur,apparts);
    }
    public void parseNiveau(String [] tab){
        if (tab.length>=51){//changer taille
            Niveau niveau = parseNiveauData(tab, 4);
            ListeNiveaux.add(niveau);
        }
    }
    public NiveauMaison parseNiveauMaisonData(String[] tab, int IndexDebut){
        int idNiveau = Integer.parseInt(tab[IndexDebut]);
        double hauteur =Double.parseDouble(tab[IndexDebut+4]);
        ArrayList<Piece> pieces = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] pieceData = new String[53];
            System.arraycopy(tab, i, pieceData, 0, Math.min(53, tab.length - i));
            Piece piece = parsePieceData(pieceData,4);
            if (piece != null) {
                pieces.add(piece);
            }
        }
        return new NiveauMaison(idNiveau,hauteur,pieces);
    }
    public void parseNiveauMaison(String [] tab){
        if (tab.length>=51){//changer taille
            NiveauMaison niveauM = parseNiveauMaisonData(tab, 4);
            ListeNiveauMaison.add(niveauM);
        }
    }
    public Immeuble parseImmeubleData(String[] tab, int IndexDebut){
        int idImmeuble = Integer.parseInt(tab[IndexDebut]);
        ArrayList<Niveau> niveaux = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] pieceData = new String[53];
            System.arraycopy(tab, i, pieceData, 0, Math.min(53, tab.length - i));
            Niveau niveau = parseNiveauData(pieceData,4);
            if (niveau != null) {
                niveaux.add(niveau);
            }
        }
        return new Immeuble(idImmeuble,niveaux);
    }
    public void parseImmeuble(String [] tab){
        if (tab.length>=51){//changer taille
            Immeuble immeuble = parseImmeubleData(tab, 4);
            ListeImmeubles.add(immeuble);
        }
    }
    public Maison parseMaisonData(String[] tab, int IndexDebut){
        int idMaison = Integer.parseInt(tab[IndexDebut]);
        ArrayList<NiveauMaison> niveauxM = new ArrayList<>();
        for (int i = 21; i < tab.length; i += 53) {
            String[] pieceData = new String[53];
            System.arraycopy(tab, i, pieceData, 0, Math.min(53, tab.length - i));
            NiveauMaison niveauM = parseNiveauMaisonData(pieceData,4);
            if (niveauxM != null) {
                niveauxM.add(niveauM);
            }
        }
        return new Maison(idMaison,niveauxM);
    }
    public void parseMaison(String [] tab){
        if (tab.length>=51){
            Maison maison = parseMaisonData(tab, 4);
            ListeMaisons.add(maison);
        }
    }
    private static <T> void afficherListe(String messageVide, ArrayList<T> liste) {
        if (liste.isEmpty()) {
            System.out.println(messageVide);
        } else {
            for (T item : liste) {
                System.out.println(item.toString()); // Suppose que chaque classe a une méthode toString
            }
        }
    }
    private static void afficherMenu() {
        System.out.println("***** MENU *****");
        System.out.println("1- Créer un coin");
        System.out.println("2- Créer un mur");
        System.out.println("3- Créer une pièce");
        System.out.println("4- Créer un appartement");
        System.out.println("5- Créer un niveau");
        System.out.println("6- Créer un bâtiment (immeuble ou maison");
        System.out.println("7- Lire le fichier");
        System.out.println("8- Supprimer une ligne du fichier");
        System.out.println("9- Quitter");
        System.out.println("Faites votre choix : ");
    }
    
    public static void main(String[] args) throws IOException {
        //création des instances des classes nécessaires
        Main main = new Main();
        ArrayList<Coin> ListeCoins = main.getListeCoins();
        ArrayList<Mur>ListeMurs = main.getListeMurs();
        ArrayList<Mur>ListeMursPiece = main.getListeMursPiece();
        ArrayList<Piece>ListePieces = main.getListePieces();
        ArrayList<Appartement>ListeAppartements = main.getListeAppartements();
        ArrayList<Niveau>ListeNiveaux = main.getListeNiveaux();
        ArrayList<Immeuble>ListeImmeubles = main.getListeImmeubles();
        String code="";
        int choix;
        supprimerLignesVides("Liste_Batiment.txt");        
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                String[] tab = ligne.split(" ");
                System.out.println(ligne);
                switch (tab[0]) {
                    case "Coin" -> main.parseCoin(tab);
                    case "Mur" -> main.parseMur(tab);//erreur de virgule ?? dans le code a trouver
                    case "Piece" -> main.parsePiece(tab);
                    case "Appartement" -> main.parseAppartement(tab);
                    case "Niveau" -> main.parseNiveau(tab);
                    case "NiveauMaison" -> main.parseNiveauMaison(tab);
                    case "Immeuble" -> main.parseImmeuble(tab);
                    case "Maison" -> main.parseMaison(tab);
                    default -> System.out.println("Le fichier est vide.");
                }
            }
            reader.close();
        } catch (FileNotFoundException err) {
            System.out.println("Erreur : le fichier n’existe pas!\n " + err);
        }
        // Afficher les listes
        afficherListe("La liste de coins est vide.", ListeCoins);
        afficherListe("La liste de murs est vide.", ListeMurs);
        afficherListe("La liste de pièces est vide.", ListePieces);
        afficherListe("La liste d'appartements est vide.", ListeAppartements);
        afficherListe("La liste de niveaux est vide.", ListeNiveaux);
        afficherListe("La liste d'immeubles est vide.", ListeImmeubles);

        afficherMenu();
        choix = Lire.i();
        while (choix < 1 || choix > 9) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte.");
            choix = Lire.i();
        }
        while (choix != 9) {
            switch (choix) {
                case 1 -> main.ecrireFichier(main.creationCoin().getCode());
                case 2 -> main.ecrireFichier(main.creationMur().getCode());
                case 3 -> main.ecrireFichier(main.creationPiece().getCode());
                case 4 -> main.ecrireFichier(main.creationAppartement().getCode());
                case 5 -> main.ecrireFichier(main.creationNiveau().getCode());
                case 6 -> main.ecrireFichier(main.creationBatiment().getCode());
                case 7 -> main.lireFichier();
                case 8 -> main.supprimerLigne("Liste_Batiment.txt");
                default -> System.out.println("Choix invalide.");
            }
            System.out.println("Faites un autre choix : ");
            choix = Lire.i();
        }
        System.out.println("Au revoir !");
        
    }
}