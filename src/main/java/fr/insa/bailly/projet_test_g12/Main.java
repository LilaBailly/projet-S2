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
import java.nio.file.*;
import java.util.Map;
/*
probleme lecture liste_batiment avec ligne vide
voir pour creer "lecture txt" pour lire le revetement et ajouter la liste de rev pour la creation mur
*/
public class Main {
    private ArrayList<Coin>ListeCoins= new ArrayList<>();
    private ArrayList<Coin>ListeCoinsP= new ArrayList<>();
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
    private ArrayList<Revetement>ListeRevMur = new ArrayList<>();
    private ArrayList<Revetement>ListeRevSol = new ArrayList<>();
    private ArrayList<Revetement>ListeRevPlafond = new ArrayList<>();
    private ArrayList<Double>PrixTotRev = new ArrayList<>();
    private ArrayList<Double>SurfaceTotRev = new ArrayList<>();
    private ArrayList<ResultatRevetement> resultats = new ArrayList<>();
    private ArrayList<Sol> ListeSols = new ArrayList<>();
    private ArrayList<Plafond> ListePlafonds = new ArrayList<>();
    public static final String FICHIER_LISTE_BATIMENT = "Liste_Batiment.txt";
    public static final String TEMP_FILE = "tempFile.txt";
    
    public Main() {
        this.revetement = new Revetement(); 
    }

    public static void main(String[] args) throws IOException {
        //création des instances des classes nécessaires
        Main main = new Main();
        ArrayList<Coin> ListeCoins = main.getListeCoins();
        ArrayList<Mur>ListeMurs = main.getListeMurs();
        ArrayList<Mur>ListeMursPiece = main.getListeMursPiece();
        ArrayList<Sol>ListeSols = main.getListeSols();
        ArrayList<Plafond>ListePlafonds = main.getListePlafonds();
        ArrayList<Piece>ListePieces = main.getListePieces();
        ArrayList<Piece>ListePieceAppart = new ArrayList<>();
        ArrayList<Piece>ListePieceNiveauM = new ArrayList<>();
        ArrayList<Appartement>ListeAppartements = main.getListeAppartements();
        ArrayList<Niveau>ListeNiveaux = main.getListeNiveaux();
        ArrayList<NiveauMaison>ListeNiveauMaison= main.getListeNiveauMaison();
        ArrayList<Immeuble>ListeImmeubles = main.getListeImmeubles();
        ArrayList<Maison>ListeMaisons = main.getListeMaisons();

        int choix, n = 0, nbrP, nbrF, nbrTS, nbrTP,idrev,idNivAppart;
        double Cx, Cy, hauteur;
        String usage, idCoin,  idMur, idCoinD, idCoinF,idMurP,idSol,idSolP, idPlafond,idPlafondP,idPiece,idAppart, idNiveau, idNiveauM ;
        Coin coinD = null, coinF = null,C1,C2,C3,C4;
        Mur murP;
        Piece pieceA;
        Sol SolP;
        Plafond plafondP;
        Appartement Appart;
        Revetement Rev = null;
        Batiment batiment = new Batiment();
        supprimerLignesVides("Liste_Batiment.txt");        
        chargerDonnees(FICHIER_LISTE_BATIMENT,main,ListeCoins,ListeMurs,ListeSols,ListePlafonds,ListePieces,ListeAppartements,ListeNiveaux,ListeNiveauMaison,ListeImmeubles,ListeMaisons);              
        // Afficher les listes
        afficherListes(ListeCoins, ListeMurs, ListeSols, ListePlafonds, ListePieces, ListeAppartements, ListeNiveaux, ListeImmeubles);

        afficherMenu();
        choix = Lire.i();
        while (choix < 1 || choix > 9) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte.");
            choix = Lire.i();
        }
        while (choix != 9) {
            main.traiterChoix(choix);
            
            System.out.println("Faites un autre choix : ");
            choix = Lire.i();
        }
        CalculerDevis.afficherDevis(new Batiment());
        System.out.println("Au revoir !");
        
    }
    /*
    
    Creation d'objet
    
    */
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
            double a,o;
            System.out.println("Abcisse: ");
            a=Lire.d();
            System.out.println("Ordonnée: ");
            o=Lire.d();
            Coin creacoin=new Coin(a,o);
            ListeCoins.add(creacoin);
            code=creacoin.toString()+" \n";
            return creationObjet(ListeCoins, creacoin, code);
        }
    
    public Resultat creationMur(){
        String code="", idRecherche;
        int exiCoinDeb,  exiCoinFin, nbrPorte, nbrFenetre, nbrRevetement ;
        Coin coinDebut = null; 
        Coin coinFin = null; 
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
            idRecherche=Lire.S();
            for (Coin c : ListeCoins) {
                if (c.getidCoin().equals(idRecherche)) {
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
            // Si le coin de début n'existe pas
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
            idRecherche=Lire.S();
            for (Coin c : ListeCoins) {
                if (c.getidCoin().equals(idRecherche)) {
                    coinFin = c;
                    
                    break;
                }
            }
            if (coinFin == null) {
                // Si le coin de début n'est pas trouvé, affiche un message d'erreur
                System.out.println("Le coin de fin recherché n'a pas été trouvé.");
            }
        } 
        // coin fin n'existe pas
        else{
            Resultat resCoin = creationCoin(); 
            code += resCoin.getCode();
            coinFin = (Coin) resCoin.getObjet();
        }// a modifier pour comparer les deux...
        if (coinDebut != null && coinFin != null) {
            coinFin.setcy(coinDebut.getcy());
        }
        System.out.println("Combien de porte y a-t-il ?");
        nbrPorte=Lire.i();
        System.out.println("Combien de fenêtre y a-t-il ?");
        nbrFenetre=Lire.i();
        System.out.println("Combien de revêtement y a-t-il ?");
        nbrRevetement=Lire.i();
        
        ListeRevMur = revetement.choixRevetementMur(nbrRevetement);
        Mur creamur = new Mur(coinDebut,coinFin,nbrPorte,nbrFenetre,ListeRevMur);
        ListeMurs.add(creamur);
        code+=creamur.toString()+" \n";
        return creationObjet(ListeMurs, creamur,code);
    }
   
    
    public Resultat creationPiece(){
        String code;
        int reponse ;
        String idRecherche ;
        int nbrRevSol, nbrRevPlafond, nbrTremisSol, nbrTremisPlafond;
        ArrayList<Mur> ListeMursPiece = new ArrayList<>();
        Mur mur;
        String usage;
        
        System.out.println("Usage de la pièce :");
        usage=Lire.S();
        
        System.out.println("Combien de revetement pour le sol ?");
        nbrRevSol=Lire.i();
        ListeRevSol = revetement.choixRevetementSol(nbrRevSol);
        System.out.println("Combien de tremis pour le sol ?");
        nbrTremisSol=Lire.i();
        
        
        System.out.println("Combien de revetement pour le plafond ?");
        nbrRevPlafond=Lire.i();
        ListeRevPlafond = revetement.choixRevetementPlafond(nbrRevPlafond);
        System.out.println("Combien de tremis pour le plafond ?");
        nbrTremisPlafond=Lire.i();
        
        for (int j=0; j<4; j++){
            System.out.println("Le mur n°"+(j+1)+" existe-t-il déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant du mur recherché: ");
                idRecherche=Lire.S();
                for (Mur m : ListeMurs) {
                    if (m.getidMur().equals(idRecherche)) {
                        mur = m;
                        ListeCoinsP.add(mur.getcoinDebut());
                        ListeCoinsP.add(mur.getcoinFin());
                        ListeMursPiece.add(mur);
                        break;
                    }
                
                    if (m == null) {
                        // Si le mur  n'est pas trouvé, affiche un message d'erreur 
                        System.out.println("Le mur recherché n'a pas été trouvé.");
                    }
                }
            } 
            //mur n'existe pas encore
            else{
                Resultat resMur = creationMur();
                Mur nouveauMur = (Mur) resMur.getObjet();
                ListeCoinsP.add(nouveauMur.getcoinDebut());
                ListeCoinsP.add(nouveauMur.getcoinFin());
                ListeMursPiece.add(nouveauMur);
                
            }
        }
        
        Sol Sol = new Sol(ListeCoinsP,ListeRevSol,nbrTremisSol);
        ListeSols.add(Sol);
        Sol.afficherSol();
        Plafond Plafond = new Plafond(ListeCoinsP,ListeRevPlafond,nbrTremisPlafond);
        ListePlafonds.add(Plafond);
        Plafond.afficherPlafond();
        Piece creapiece = new Piece(usage, Sol.getidSol(), Plafond.getidPlafond(), ListeMursPiece);
        ListePieces.add(creapiece);
        code=creapiece.toString()+" \n";
        return creationObjet(ListePieces, creapiece,code);
    }
    
    public Resultat creationAppartement(){
        String code, idRecherche ;
        int niveauApp, nbrPieces, reponse;
        Piece piece;
        
        System.out.println("Quel est le niveau de l'appartement ? ");
        niveauApp=Lire.i();
        System.out.println("Combien y a-t-il de pièces dans l'appartement ?");
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
                idRecherche=Lire.S();
                for (Piece p : ListePieces) {
                    if (p.getidPiece().equals(idRecherche)) {
                        piece = p;
                        ListePieces.add(piece);
                        break;
                    }
                
                    if (p == null) {
                        // Si le mur  n'est pas trouvé, affiche un message d'erreur 
                        System.out.println("La pièce recherchée n'a pas été trouvée.");
                    }
                }
            }
            else{
                Resultat resPiece = creationPiece();
                ListePieces.add((Piece) resPiece.getObjet());
                
            }
        }
        Appartement creaappart = new Appartement(niveauApp, ListePieces);
        code=creaappart.toString()+" \n";
        return creationObjet(ListeAppartements, creaappart,code);
    }
    public Resultat creationNiveauMaison(){
        String code, idRecherche ;
        int nbrPieces, reponse, Hniveau;
        Piece piece;
        
        System.out.println("Quel est la hauteur du niveau ? ");
        Hniveau=Lire.i();
        System.out.println("Combien y a-t-il de pièces dans l'appartement ?");
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
                idRecherche=Lire.S();
                for (Piece p : ListePieces) {
                    if (p.getidPiece().equals(idRecherche)) {
                        piece = p;
                        ListePieces.add(piece);
                        break;
                    }
                
                    if (p == null) {
                        // Si le mur  n'est pas trouvé, affiche un message d'erreur 
                        System.out.println("La pièce recherchée n'a pas été trouvée.");
                    }
                }
            }
            else{
                Resultat resPiece = creationPiece();
                ListePieces.add((Piece) resPiece.getObjet());
                
            }
        }
        NiveauMaison creaNiveauM = new NiveauMaison(Hniveau, ListePieces);
        code=creaNiveauM.toString()+" \n";
        return creationObjet(ListeNiveauMaison, creaNiveauM,code);
    }
    public Resultat creationNiveau(){
        String code,idRecherche ;
        int nbrApparts,reponse;
        double hauteur;
        Appartement appart;
        
        System.out.println("hauteur : ");
        hauteur=Lire.i();
        System.out.println("Combien y a-t-il d'appartements dans le niveau ?");
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
                idRecherche=Lire.S();
                for (Appartement a : ListeAppartements) {
                    if (a.getidAppartement().equals(idRecherche)) {
                        appart = a;
                        ListeAppartements.add(appart);
                        break;
                    }
                
                    if (a == null) {
                        // Si le mur  n'est pas trouvé, affiche un message d'erreur
                        System.out.println("L'appartement recherché n'a pas été trouvé.");
                    }
                }
            }
            else{
                Resultat resAppart = creationAppartement();
                ListeAppartements.add((Appartement) resAppart.getObjet());
                
            }
        }
        
        Niveau creaniveau = new Niveau(hauteur, ListeAppartements);
        code=creaniveau.toString()+" \n";
        return creationObjet(ListeNiveaux, creaniveau,code);
    
    }
    public Resultat creationBatiment(){
        Batiment creabat = new Batiment();
        String code, idBat = null,idRecherche ;
        int typeBatiment,nbrNiveaux,reponse ;
        Niveau niveau;
        System.out.println("Quel type de bâtiment souhaitez-vous créer ? (1 = Immeuble et 0 = Maison)");
        typeBatiment = Lire.i();
        while (typeBatiment != 0 && typeBatiment != 1) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte : 1 = Immeuble et 0 = Maison");
            typeBatiment = Lire.i();
        }
        
        if (typeBatiment == 1) {
            
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
                    idRecherche=Lire.S();
                    for (Niveau n : ListeNiveaux) {
                        if (n.getidNiveau().equals(idRecherche)) {
                            niveau = n;
                            ListeNiveaux.add(niveau);
                            break;
                        }

                        if (n == null) {
                            // Si le mur  n'est pas trouvé, affiche un message d'erreur 
                            System.out.println("Le niveau recherché n'a pas été trouvé.");
                        }
                    }
                }
                else{
                    Resultat resNiveau = creationNiveau();
                    ListeNiveaux.add((Niveau) resNiveau.getObjet());

                }
            }
            Immeuble immeuble = new Immeuble(ListeNiveaux);
            immeuble.setlisteNiveaux(ListeNiveaux);
            ListeImmeubles.add(immeuble);
            ListeBatiments.add(immeuble);
            creabat = immeuble;
        }
        else {
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
                    idRecherche = Lire.S();
                    NiveauMaison niveauM = null;
                    for (NiveauMaison nM : ListeNiveauMaison) {
                        if (nM.getidNiveauMaison().equals(idRecherche)) {
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
            Maison maison = new Maison( ListeNiveauMaison);
            ListeMaisons.add(maison);
            ListeBatiments.add(maison);
            creabat= maison;
        }    
            code=creabat.toString()+" \n";
        
        return creationObjet(ListeBatiments, creabat,code);
    }
    /*
    
     Fin Creation d'objet
    
    */
    /*
    
    get des différents objets
    
    */
   
    
    public ArrayList<Coin> getListeCoins() {
        return ListeCoins;
    }
    
    public ArrayList<Mur> getListeMurs() {
        return ListeMurs;
    }
    public ArrayList<Sol> getListeSols(){
        return ListeSols;
    }
    public ArrayList<Plafond> getListePlafonds(){
        return ListePlafonds;
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
    /*
    
    Fin get des différents objets
    
    */
    /*
    
    action utilisateur
    
    */
    
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

    
    public static void supprimerLignesVides(String nomFichier) {
        Path fichierOriginal = Paths.get(nomFichier);
        Path fichierTemporaire = Paths.get("fichier_temporaire.txt");
        try (BufferedReader lecteur = Files.newBufferedReader(fichierOriginal);
            BufferedWriter ecrivain = Files.newBufferedWriter(fichierTemporaire)) {

            String ligne;
            while ((ligne = lecteur.readLine()) != null) {
                // Vérifier si la ligne n'est pas vide ou composée uniquement d'espaces
                if (!ligne.trim().isEmpty()) {
                    ecrivain.write(ligne);
                    ecrivain.newLine(); // Ajouter un saut de ligne après chaque ligne non vide
                }
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("Le fichier n'existe pas.");
        } 
        catch (IOException e) {
            System.out.println("Une erreur s'est produite lors de la lecture ou de l'écriture du fichier.");
            e.printStackTrace();
        }

        try {
            Files.move(fichierTemporaire, fichierOriginal, StandardCopyOption.REPLACE_EXISTING);
        } 
        catch (IOException e) {
            System.out.println("Impossible de renommer le fichier temporaire.");
            e.printStackTrace();
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
    
    private static <T> void afficherListe(String messageVide, ArrayList<T> liste) {
        if (liste.isEmpty()) {
            System.out.println(messageVide);
        } else {
            for (T item : liste) {
                System.out.println(item.toString()); 
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
        System.out.println("6- Créer un niveau maison)");
        System.out.println("7- Créer un bâtiment (immeuble ou maison");
        System.out.println("8- Lire le fichier");
        System.out.println("9- Quitter");
        System.out.println("Faites votre choix : ");
    }   
     private void traiterChoix(int choix) {
        switch (choix) {
                case 1 -> ecrireFichier(creationCoin().getCode());
                case 2 -> ecrireFichier(creationMur().getCode());
                case 3 -> ecrireFichier(creationPiece().getCode());
                case 4 -> ecrireFichier(creationAppartement().getCode());
                case 5 -> ecrireFichier(creationNiveau().getCode());
                case 6 -> ecrireFichier(creationNiveauMaison().getCode());
                case 7 -> ecrireFichier(creationBatiment().getCode());
                case 8 -> lireFichier();
                default -> System.out.println("Choix invalide.");
            }
    }
        
    private static void afficherListes(ArrayList<Coin> ListeCoins, ArrayList<Mur> ListeMurs, ArrayList<Sol> ListeSols, ArrayList<Plafond> ListePlafonds, ArrayList<Piece> ListePieces, ArrayList<Appartement> ListeAppartements, ArrayList<Niveau> ListeNiveaux, ArrayList<Immeuble> ListeImmeubles) {
        afficherListe("La liste de coins est vide.", ListeCoins);
        afficherListe("La liste de murs est vide.", ListeMurs);
        afficherListe("La liste de sols est vide.", ListeSols);
        afficherListe("La liste de plafonds est vide.", ListePlafonds);
        afficherListe("La liste de pièces est vide.", ListePieces);
        afficherListe("La liste d'appartements est vide.", ListeAppartements);
        afficherListe("La liste de niveaux est vide.", ListeNiveaux);
        afficherListe("La liste d'immeubles est vide.", ListeImmeubles);
    }
    /*
    
    Fin action utilisateur
    
    */
    /*
    
    Traitement de l'information
    
    */
    private static void chargerDonnees(String nomFichier, Main main, ArrayList<Coin> ListeCoins, ArrayList<Mur> ListeMurs, ArrayList<Sol> ListeSols, ArrayList<Plafond> ListePlafonds, ArrayList<Piece> ListePieces, ArrayList<Appartement> ListeAppartements, ArrayList<Niveau> ListeNiveaux, ArrayList<NiveauMaison> ListeNiveauMaison, ArrayList<Immeuble> ListeImmeubles, ArrayList<Maison> ListeMaisons) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomFichier))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.trim().isEmpty()) { 
                    String[] tab = ligne.split(";");
                    switch (tab[0]) {
                        case "C":
                            traiterCoin(tab, ListeCoins);
                            break;
                        case "M":
                            traiterMur(tab, ListeCoins, ListeMurs, main);
                            break;
                        case "S":
                            traiterSol(tab, ListeSols, main);
                            break;
                        case "Pl":
                            traiterPlafond(tab, ListePlafonds, main);
                            break;
                        case "Pi":
                            traiterPiece(tab, ListePieces, ListeMurs, main);
                            break;
                        case "A":
                            traiterAppartement(tab, ListeAppartements, ListePieces);
                            break;
                        case "N":
                            traiterNiveau(tab, ListeNiveaux, ListeAppartements);
                            break;
                        case "NM":
                            traiterNiveauMaison(tab, ListeNiveauMaison, ListePieces);
                            break;
                        case "I":
                            traiterImmeuble(tab, ListeNiveaux, ListeImmeubles);
                            break;
                        case "Ma":
                            traiterMaison(tab, ListeNiveauMaison, ListeMaisons);
                            break;
                        default:
                            System.out.println("Ligne non reconnue: " + ligne);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Erreur : le fichier n’existe pas!\n " + e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<Coin> recupereCoin(String [] tab){
        Coin C1,C2,C3,C4;
        String idC1 = tab[1], idC2 = tab[2], idC3 = tab[3], idC4 = tab[4];
        for (Coin c : ListeCoins) {
            if (c.getidCoin().equals(idC1)) {
                C1= c;
                ListeCoinsP.add(C1);
                break;
            }
        }
        for (Coin c : ListeCoins) {
            if (c.getidCoin().equals(idC2)) {
                C2= c;
                ListeCoinsP.add(C2);
                break;
            }
        }
        for (Coin c : ListeCoins) {
            if (c.getidCoin().equals(idC3)) {
                C3= c;
                ListeCoinsP.add(C3);
                break;
            }
        }
        for (Coin c : ListeCoins) {
            if (c.getidCoin().equals(idC4)) {
                C4= c;
                ListeCoinsP.add(C4);
                break;
            }
        }
        return ListeCoinsP;
    }
    private static void traiterCoin(String[] tab, ArrayList<Coin> ListeCoins) {
        double Cx = Double.parseDouble(tab[1].trim());
        double Cy = Double.parseDouble(tab[2].trim());
        Coin coin = new Coin(Cx, Cy);
        ListeCoins.add(coin);
    }

    private static void traiterMur(String[] tab, ArrayList<Coin> ListeCoins, ArrayList<Mur> ListeMurs, Main main) {
        Coin coinD = trouverCoinParId(tab[1].trim(), ListeCoins);
        Coin coinF = trouverCoinParId(tab[2].trim(), ListeCoins);
        int nbrP = Integer.parseInt(tab[3]);
        int nbrF = Integer.parseInt(tab[4]);
        Revetement rev = new Revetement();
        ArrayList<Revetement> listeRevMur = new ArrayList<>();
        for (int r = 5; r < tab.length; r++) {
            String idrev = tab[r];
            Revetement revetement = trouverRevetementParId(idrev, rev.getlisteRevetementMur());
            if (revetement != null) {
                listeRevMur.add(revetement);
            }
        }
        Mur mur = new Mur(coinD, coinF, nbrP, nbrF, listeRevMur);
        ListeMurs.add(mur);
    }

    private static void traiterSol(String[] tab, ArrayList<Sol> ListeSols, Main main) {
        int nbrTS = Integer.parseInt(tab[tab.length - 1]);
        ArrayList<Revetement> listeRevSol = new ArrayList<>();
        Revetement rev = new Revetement();
        for (int r = 1; r < tab.length - 1; r++) {
            String idrev = tab[r];
            Revetement revetement = trouverRevetementParId(idrev, rev.getlisteRevetementSol());
            if (revetement != null) {
                listeRevSol.add(revetement);
            }
        }
        Sol sol = new Sol(main.recupereCoin(tab), listeRevSol, nbrTS);
        ListeSols.add(sol);
    }

    private static void traiterPlafond(String[] tab, ArrayList<Plafond> ListePlafonds, Main main) {
        int nbrTP = Integer.parseInt(tab[tab.length - 1]);
        ArrayList<Revetement> listeRevPlafond = new ArrayList<>();
        Revetement rev = new Revetement();
        for (int r = 1; r < tab.length - 1; r++) {
            String idrev = tab[r];
            Revetement revetement = trouverRevetementParId(idrev, rev.getlisteRevetementPlafond());
            if (revetement != null) {
                listeRevPlafond.add(revetement);
            }
        }
        Plafond plafond = new Plafond(main.recupereCoin(tab), listeRevPlafond, nbrTP);
        ListePlafonds.add(plafond);
    }

    private static void traiterPiece(String[] tab, ArrayList<Piece> ListePieces, ArrayList<Mur> ListeMurs, Main main) {
        String usage = tab[1];
        String idSolP = tab[2];
        String idPlafondP = tab[3];
        ArrayList<Mur> ListeMursPiece = new ArrayList<>();
        for (int j = 4; j < tab.length; j++) {
            String idMurP = tab[j];
            Mur mur = trouverMurParId(idMurP, ListeMurs);
            if (mur != null) {
                ListeMursPiece.add(mur);
            }
        }
        Piece piece = new Piece(usage, idSolP, idPlafondP, ListeMursPiece);
        ListePieces.add(piece);
    }

    private static void traiterAppartement(String[] tab, ArrayList<Appartement> ListeAppartements, ArrayList<Piece> ListePieces) {
        int idNivAppart = Integer.parseInt(tab[1]);
        ArrayList<Piece> ListePieceAppart = new ArrayList<>();
        for (int h = 2; h < tab.length; h++) {
            String idPiece = tab[h];
            Piece piece = trouverPieceParId(idPiece, ListePieces);
            if (piece != null) {
                ListePieceAppart.add(piece);
            }
        }
        Appartement appart = new Appartement(idNivAppart, ListePieceAppart);
        ListeAppartements.add(appart);
    }

    private static void traiterNiveau(String[] tab, ArrayList<Niveau> ListeNiveaux, ArrayList<Appartement> ListeAppartements) {
        double hauteur = Double.parseDouble(tab[1]);
        ArrayList<Appartement> ListeAppartementsNiveau = new ArrayList<>();
        for (int j = 2; j < tab.length; j++) {
            String idAppart = tab[j];
            Appartement appart = trouverAppartementParId(idAppart, ListeAppartements);
            if (appart != null) {
                ListeAppartementsNiveau.add(appart);
            }
        }
        Niveau niveau = new Niveau(hauteur, ListeAppartementsNiveau);
        ListeNiveaux.add(niveau);
    }

    private static void traiterNiveauMaison(String[] tab, ArrayList<NiveauMaison> ListeNiveauMaison, ArrayList<Piece> ListePieces) {
        double hauteur = Double.parseDouble(tab[1]);
        ArrayList<Piece> ListePieceNiveauM = new ArrayList<>();
        for (int j = 2; j < tab.length; j++) {
            String idPiece = tab[j];
            Piece piece = trouverPieceParId(idPiece, ListePieces);
            if (piece != null) {
                ListePieceNiveauM.add(piece);
            }
        }
        NiveauMaison niveauM = new NiveauMaison(hauteur, ListePieceNiveauM);
        ListeNiveauMaison.add(niveauM);
    }

    private static void traiterImmeuble(String[] tab, ArrayList<Niveau> ListeNiveaux, ArrayList<Immeuble> ListeImmeubles) {
        ArrayList<Niveau> ListeNiveauxImmeuble = new ArrayList<>();
        for (int j = 1; j < tab.length; j++) {
            String idNiveau = tab[j];
            Niveau niveau = trouverNiveauParId(idNiveau, ListeNiveaux);
            if (niveau != null) {
                ListeNiveauxImmeuble.add(niveau);
            }
        }
        Immeuble immeuble = new Immeuble(ListeNiveauxImmeuble);
        ListeImmeubles.add(immeuble);
    }

    private static void traiterMaison(String[] tab, ArrayList<NiveauMaison> ListeNiveauMaison, ArrayList<Maison> ListeMaisons) {
        ArrayList<NiveauMaison> ListeNiveauxMaison = new ArrayList<>();
        for (int j = 1; j < tab.length; j++) {
            String idNiveauM = tab[j];
            NiveauMaison niveauM = trouverNiveauMaisonParId(idNiveauM, ListeNiveauMaison);
            if (niveauM != null) {
                ListeNiveauMaison.add(niveauM);
            }
        }
        Maison maison = new Maison(ListeNiveauxMaison);
        ListeMaisons.add(maison);
    }
    /*
    
    Fin Traitement de l'information
    
    */
    /*
    
    Trouver par identifiant 
    
    */
    private static Coin trouverCoinParId(String id, ArrayList<Coin> liste) {
        for (Coin c : liste) {
            if (c.getidCoin().equals(id)) {
                return c;
            }
        }
        return null;
    }

    private static Mur trouverMurParId(String id, ArrayList<Mur> liste) {
        for (Mur m : liste) {
            if (m.getidMur().equals(id)) {
                return m;
            }
        }
        return null;
    }

    private static Piece trouverPieceParId(String id, ArrayList<Piece> liste) {
        for (Piece p : liste) {
            if (p.getidPiece().equals(id)) {
                return p;
            }
        }
        return null;
    }

    private static Appartement trouverAppartementParId(String id, ArrayList<Appartement> liste) {
        for (Appartement a : liste) {
            if (a.getidAppartement().equals(id)) {
                return a;
            }
        }
        return null;
    }

    private static Niveau trouverNiveauParId(String id, ArrayList<Niveau> liste) {
        for (Niveau n : liste) {
            if (n.getidNiveau().equals(id)) {
                return n;
            }
        }
        return null;
    }

    private static NiveauMaison trouverNiveauMaisonParId(String id, ArrayList<NiveauMaison> liste) {
        for (NiveauMaison nm : liste) {
            if (nm.getidNiveauMaison().equals(id)) {
                return nm;
            }
        }
        return null;
    }
    private static Maison trouverMaisonParId(String id, ArrayList<Maison> liste) {
        for (Maison m : liste) {
            if (m.getidMaison().equals(id)) {
                return m;
            }
        }
        return null;
    }
    private static Revetement trouverRevetementParId(String id, ArrayList<Revetement> liste) {
        for (Revetement r : liste) {
            if (r.getidRevetement() == id) {
                return r;
            }
        }
        return null;
    }
    /*
    
    Fin Trouver par identifiant 
    
    */
    
}
