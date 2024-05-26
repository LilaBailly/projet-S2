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
            String id;
            double a,o;
            System.out.println("Identifiant du coin: ");
            id=Lire.S();
            for (int i=0;i<ListeCoins.size();i++){
                if ("id".equals(ListeCoins.get(i).getidCoin())){
                    System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le coin :");
                    id=Lire.S();
                }
            }
            System.out.println("Abcisse: ");
            a=Lire.d();
            System.out.println("Ordonnée: ");
            o=Lire.d();
            Coin creacoin=new Coin(id,a,o);
            ListeCoins.add(creacoin);
            code=creacoin.toString()+" \n";
            return creationObjet(ListeCoins, creacoin, code);
        }
    
    public Resultat creationMur(){
        String code="", idRecherche, idMur ;
        int exiCoinDeb,  exiCoinFin, nbrPorte, nbrFenetre, nbrRevetement ;
        Coin coinDebut = null; 
        Coin coinFin = null; 
        System.out.println("Identifiant du mur: ");
        idMur=Lire.S();
        ArrayList<Revetement>ListeRev = new ArrayList<>();
        // Vérifie si l'identifiant du mur existe déjà
        for (int i=0;i<ListeMurs.size();i++){
            if (ListeMurs.get(i).getidMur().equals(idMur)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le mur :");
                idMur=Lire.S();
            } else {
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
        Mur creamur = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,ListeRevMur);
        ListeMurs.add(creamur);
        code+=creamur.toString()+" \n";
        return creationObjet(ListeMurs, creamur,code);
    }
   
    
    public Resultat creationPiece(){
        String code;
        int reponse ;
        String idSol, idPiece, idPlafond, idRecherche ;
        int nbrRevSol, nbrRevPlafond, nbrTremisSol, nbrTremisPlafond;
        ArrayList<Mur> ListeMursPiece = new ArrayList<>();
        Mur mur;
        String usage;
        System.out.println("Identifiant pièce : ");
        idPiece=Lire.S();
        for (int i=0;i<ListePieces.size();i++){
            if (ListePieces.get(i).getidPiece().equals(idPiece)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour la pièce :");
                idPiece=Lire.S();
            }
        }
        System.out.println("Usage de la pièce :");
        usage=Lire.S();
        System.out.println("identifiant Sol : ");
        idSol = Lire.S();
        System.out.println(idSol);
        for (int i=0;i<ListeSols.size();i++){
            if (idSol.equals(ListeSols.get(i).getidSol())){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le sol :");
                idSol=Lire.S();
            }
        }
        System.out.println("Combien de revetement pour le sol ?");
        nbrRevSol=Lire.i();
        ListeRevSol = revetement.choixRevetementSol(nbrRevSol);
        System.out.println("Combien de tremis pour le sol ?");
        nbrTremisSol=Lire.i();
        
        System.out.println("identifiant plafond : ");
        idPlafond = Lire.S();
        System.out.println(idPlafond);
        for (int i=0;i<ListePlafonds.size();i++){
            if (ListePlafonds.get(i).getidPlafond().equals(idPlafond)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le sol :");
                idPlafond=Lire.S();
            }
        }
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
        
        Sol Sol = new Sol(idSol,ListeCoinsP,ListeRevSol,nbrTremisSol);
        ListeSols.add(Sol);
        Sol.afficherSol();
        Plafond Plafond = new Plafond(idPlafond,ListeCoinsP,ListeRevPlafond,nbrTremisPlafond);
        ListePlafonds.add(Plafond);
        Plafond.afficherPlafond();
        Piece creapiece = new Piece(idPiece, usage, idSol, idPlafond, ListeMursPiece);
        ListePieces.add(creapiece);
        code=creapiece.toString()+" \n";
        return creationObjet(ListePieces, creapiece,code);
    }
    
    public Resultat creationAppartement(){
        String code, idAppartement,idRecherche ;
        int niveauApp, nbrPieces, reponse;
        Piece piece;
        System.out.println("Identifiant appartement : ");
        idAppartement=Lire.S();
        for (int i=0;i<ListeAppartements.size();i++){
            if (ListeAppartements.get(i).getidAppartement().equals(idAppartement)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour l'appartement :");
                idAppartement=Lire.S();
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
        Appartement creaappart = new Appartement(idAppartement,niveauApp, ListePieces);
        code=creaappart.toString()+" \n";
        return creationObjet(ListeAppartements, creaappart,code);
    }
    public Resultat creationNiveauMaison(){
        String code, idNiveauM,idRecherche ;
        int nbrPieces, reponse, Hniveau;
        Piece piece;
        System.out.println("Identifiant appartement : ");
        idNiveauM=Lire.S();
        for (int i=0;i<ListeNiveauMaison.size();i++){
            if (ListeNiveauMaison.get(i).getidNiveauMaison().equals(idNiveauM)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le niveau :");
                idNiveauM=Lire.S();
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
        NiveauMaison creaNiveauM = new NiveauMaison(idNiveauM,Hniveau, ListePieces);
        code=creaNiveauM.toString()+" \n";
        return creationObjet(ListeNiveauMaison, creaNiveauM,code);
    }
    public Resultat creationNiveau(){
        String idNiveau, code,idRecherche ;
        int nbrApparts,reponse;
        double hauteur;
        Appartement appart;
        
        System.out.println("Identifiant appartement : ");
        idNiveau=Lire.S();
        for (int i=0;i<ListeNiveaux.size();i++){
            if (ListeNiveaux.get(i).getidNiveau().equals(idNiveau)){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le niveau :");
                idNiveau=Lire.S() ;
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
        
        Niveau creaniveau = new Niveau(idNiveau,hauteur, ListeAppartements);
        code=creaniveau.toString()+" \n";
        return creationObjet(ListeNiveaux, creaniveau,code);
    
    }
    public Resultat creationBatiment(){
        Batiment creabat = new Batiment();
        String code, idBat = null,idBatiment,idRecherche ;
        int typeBatiment,nbrNiveaux,reponse ;
        Niveau niveau;
        System.out.println("Quel type de bâtiment souhaitez-vous créer ? (1 = Immeuble et 0 = Maison)");
        typeBatiment = Lire.i();
        while (typeBatiment != 0 && typeBatiment != 1) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte : 1 = Immeuble et 0 = Maison");
            typeBatiment = Lire.i();
        }
        
        if (typeBatiment == 1) {
            System.out.println("Identifiant du bâtiment : ");
            idBatiment = Lire.S();
            for (int i = 0; i < ListeBatiments.size(); i++) {
                if (ListeImmeubles.get(i).getidImmeuble().equals(idBatiment)) {
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
            Immeuble immeuble = new Immeuble(idBatiment,ListeNiveaux);
            immeuble.setlisteNiveaux(ListeNiveaux);
            ListeImmeubles.add(immeuble);
            ListeBatiments.add(immeuble);
            creabat = immeuble;
        }
        else {
            System.out.println("Identifiant du bâtiment : ");
            idBatiment = Lire.S();
            for (int i = 0; i < ListeBatiments.size(); i++) {
                if (ListeImmeubles.get(i).getidImmeuble().equals(idBatiment)) {
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
            Maison maison = new Maison(idBatiment, ListeNiveauMaison);
            ListeMaisons.add(maison);
            ListeBatiments.add(maison);
            creabat= maison;
        }    
            code=creabat.toString()+" \n";
        
        return creationObjet(ListeBatiments, creabat,code);
    }
    
   // get des différents objets
    
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
    // action utilisateur
    public void ecrireFichier(String texte) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("Liste_Batiment.txt", false);
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
        System.out.println("6- Créer un niveau maison");
        System.out.println("7- Créer un bâtiment (immeuble ou maison");
        System.out.println("8- Lire le fichier");
        System.out.println("9- Supprimer une ligne du fichier");
        System.out.println("10- Quitter");
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
                case 9 -> supprimerLigne("Liste_Batiment.txt");
                default -> System.out.println("Choix invalide.");
            }
    }
    public ArrayList<Coin> recupereCoin(String [] tab){
        Coin C1,C2,C3,C4;
        String idC1,idC2,idC3,idC4;
        idC1=tab[1];
        idC2=tab[2];
        idC3=tab[3];
        idC4=tab[4];
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
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                if (!ligne.trim().isEmpty()) { // Vérifier si la ligne n'est pas vide
                    String[] tab = ligne.split(";");
                    int i = tab.length;
                    /*System.out.println(i);
                    for (int u=0; u<i;u++){
                        System.out.println(tab[u]);
                    }*/
                    System.out.println(ligne);
                    if (tab.length==3){
                        n=1;
                        break;
                    }
                    if (tab.length==3){
                        n=2;
                        break;
                    } 
                    if (tab.length==5){
                        n=3;
                        break;
                    } 
                    switch (n) {
                        case 1 :
                            idCoin = tab[0];
                            Cx = Double.parseDouble(tab[1]);
                            Cy = Double.parseDouble(tab[2]);
                            Coin coin = new Coin(idCoin,Cx,Cy);
                            ListeCoins.add(coin);
                            //break;
                        case 2:
                            idMur = tab[0];
                            idCoinD = tab[1];
                            for (Coin c : ListeCoins) {
                                if (c.getidCoin().equals(idCoinD)) {
                                    coinD= c;
                                    break;
                                }
                            }
                            idCoinF = tab[2];
                            for (Coin c : ListeCoins) {
                                if (c.getidCoin().equals(idCoinF)) {
                                    coinF= c;
                                    break;
                                }
                            }
                            nbrP = Integer.parseInt(tab[3]);
                            nbrF = Integer.parseInt(tab[4]);
                            
                            for (int r=5;r<i;r++){
                                idrev=Integer.parseInt(tab[r]);
                                for (Revetement R : Rev.getlisteRevetementMur()){
                                    if(R.getidRevetement().equals(idrev)){
                                       Rev = R;
                                       main.ListeRevMur.add(Rev);
                                   }
                               } 
                            }
                            Mur mur = new Mur(idMur,coinD,coinF,nbrP,nbrF,main.ListeRevMur);
                            ListeMurs.add(mur);
                        case 3 :
                            idSol= tab[0];
                            nbrTS = Integer.parseInt(tab[i]);
                            for (int r=1;r<i-1;r++){
                                idrev=Integer.parseInt(tab[r]);
                                for (Revetement R : Rev.getlisteRevetementSol()){
                                    if(R.getidRevetement().equals(idrev)){
                                       Rev = R;
                                       main.ListeRevSol.add(Rev);
                                   }
                               } 
                            }
                            Sol sol = new Sol(idSol,main.recupereCoin(tab),main.ListeRevSol,nbrTS);
                            ListeSols.add(sol);
                        case 4 :
                            idPlafond = tab[0];
                            nbrTP = Integer.parseInt(tab[i]);
                            for (int r=1;r<i-1;r++){
                                idrev=Integer.parseInt(tab[r]);
                                for (Revetement R : Rev.getlisteRevetementPlafond()){
                                    if(R.getidRevetement().equals(idrev)){
                                       Rev = R;
                                       main.ListeRevPlafond.add(Rev);
                                   }
                               } 
                            }
                            Plafond plafond = new Plafond(idPlafond,main.recupereCoin(tab),main.ListeRevPlafond,nbrTP);
                            ListePlafonds.add(plafond);
                        case 5 :
                            idPiece = tab[0];
                            usage = tab[1];
                            idSolP = tab[2];
                            idPlafondP = tab[3];
                            for (int j =4; j<i; j++){
                                for (Mur m : ListeMurs){
                                    idMurP = tab[j];
                                    if (m.getidMur().equals(idMurP)) {
                                        murP= m;
                                        ListeMursPiece.add(m);
                                        break;
                                    }
                                }
                            }
                            
                            Piece piece = new Piece(idPiece,usage,idSolP, idPlafondP,ListeMursPiece);
                            ListePieces.add(piece);
                        case 6 :
                            idAppart = tab[0];
                            idNivAppart = Integer.parseInt(tab[1]);
                            int h =2;
                            while(h<i){
                                for (Piece p : ListePieces){
                                    idPiece = tab[h];
                                    if (p.getidPiece().equals(idPiece)) {
                                        pieceA= p;
                                        ListePieceAppart.add(pieceA);
                                        break;
                                    }
                                }
                            }
                            Appartement appart =new Appartement(idAppart,idNivAppart,ListePieceAppart);
                            ListeAppartements.add(appart);
                        case 7 :
                            idNiveau = tab[0];
                            hauteur=Integer.parseInt(tab[1]);
                            for (int j =2; j<i; j++){
                                for (Appartement a : ListeAppartements){
                                    idAppart = tab[j];
                                    if (a.getidAppartement().equals(idAppart)) {
                                        Appart= a;
                                        ListeAppartements.add(a);
                                        break;
                                    }
                                }
                            }
                            Niveau niveau = new Niveau(idNiveau, hauteur, ListeAppartements);
                            ListeNiveaux.add(niveau);
                        case 8 :
                            idNiveauM = tab[0];
                            hauteur=Integer.parseInt(tab[1]);
                            for (int j =2; j<i; j++){
                                for (Piece p : ListePieces){
                                    idPiece = tab[j];
                                    if (p.getidPiece().equals(idPiece)) {
                                        pieceA= p;
                                        ListePieceNiveauM.add(pieceA);
                                        break;
                                    }
                                }
                            }
                            NiveauMaison niveauM = new NiveauMaison(idNiveauM, hauteur, ListePieceNiveauM);
                            ListeNiveauMaison.add(niveauM);
                       // default -> System.out.println("Ligne non reconnue: " + ligne);
                    }
                }
            }
            reader.close();
        } catch (FileNotFoundException err) {
            System.out.println("Erreur : le fichier n’existe pas!\n " + err);
        }
        // Afficher les listes
        afficherListe("La liste de coins est vide.", ListeCoins);
        afficherListe("La liste de murs est vide.", ListeMurs);
        afficherListe("La liste de sols est vide.", ListeSols);
        afficherListe("La liste de plafonds est vide.", ListePlafonds);
        afficherListe("La liste de pièces est vide.", ListePieces);
        afficherListe("La liste d'appartements est vide.", ListeAppartements);
        afficherListe("La liste de niveaux est vide.", ListeNiveaux);
        afficherListe("La liste d'immeubles est vide.", ListeImmeubles);

        afficherMenu();
        choix = Lire.i();
        while (choix < 1 || choix > 10) {
            System.out.println("Valeur incorrecte; veuillez donner une valeur correcte.");
            choix = Lire.i();
        }
        while (choix != 10) {
            main.traiterChoix(choix);
            
            System.out.println("Faites un autre choix : ");
            choix = Lire.i();
        }
        CalculerDevis.afficherDevis(batiment);
        System.out.println("Au revoir !");
        
    }
}

 
    /*
   
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
    }*/