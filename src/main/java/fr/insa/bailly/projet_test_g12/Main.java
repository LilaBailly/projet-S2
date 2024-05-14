/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package fr.insa.bailly.projet_test_g12;
import java.util.*;
import java.io.*;
/**
 *
 * @author Elève
 */
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
    private ArrayList<Immeuble>ListeImmeubles= new ArrayList<>();
    private ArrayList<Batiment>ListeBatiments= new ArrayList<>();
    private String Porte = "", Fenetre = "", Tremis = "";
    
    // Classe Resultat interne à Main
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
            code=creacoin.toString()+" , \n";
            return creationObjet(ListeCoins, creacoin, code);
        }
    
    public Resultat creationMur(){
        String code="";
        int idMur, exiCoinDeb, idRecherche, idCoinD, exiCoinFin,idCoinF,  nbrPorte, nbrFenetre, nbrRevetement ;
        //double x,y;
        Coin coinDebut = null; //a modifier car problème plus tard dans un if
        Coin coinFin = null; //a modifier car problème plus tard dans un if
        System.out.println("Identifiant du mur: ");
        idMur=Lire.i();
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
                // Si le coin de début n'est pas trouvé, affichez un message d'erreur ou gérez-le autrement
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
        Mur creamur = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement);
        ListeMurs.add(creamur);
        code+=creamur.toString()+" , \n";
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
        code=creapiece.toString()+" , \n";
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
        code=creaappart.toString()+" , \n";
        return creationObjet(ListeAppartements, creaappart,code);
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
        code=creaniveau.toString()+" , \n";
        return creationObjet(ListeNiveaux, creaniveau,code);
    }
    
    public Resultat creationBatiment(){
        String code, idBat;
        int  idImmeuble=1, idMaison,nbrNiveaux,reponse,idRecherche;
        Niveau niveau;
        System.out.println("Identifiant batiment : (nom du batiment immeuble/maison)");
        idBat=Lire.S();
        if (idBat.toLowerCase()=="immeuble"){
            System.out.println("Identifiant de l'immeuble :");
            idImmeuble=Lire.i();

            for (int i=0;i<ListeNiveaux.size();i++){
                if (ListeImmeubles.get(i).getidImmeuble()==idImmeuble){
                    System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour le niveau :");
                    idImmeuble=Lire.i();
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
        }
            Batiment creabat = new Immeuble(idImmeuble, ListeNiveaux);
            code=creabat.toString()+" , \n";
        
        // meme chose pour maison
        
        return creationObjet(ListeBatiments, creabat,code);
    }
    
    public Resultat creationPorte(){
        String code, type="porte";
        int idPorte;
        System.out.println("Identifiant porte : ");
        idPorte=Lire.i();
        for (int i=0;i<ListePortes.size();i++){
            if (ListePortes.get(i).getidOuverture()==idPorte){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour la pièce :");
                idPorte=Lire.i();
            }
        }
        Ouverture creaporte = new Ouverture(type,idPorte);
        code=creaporte.toString()+" , \n";
        return creationObjet(ListePortes, creaporte,code);
    }
    public Resultat creationFenetre(){
        String code, type="fenetre";
        int idFenetre;
        System.out.println("Identifiant fenètre : ");
        idFenetre=Lire.i();
        for (int i=0;i<ListeFenetres.size();i++){
            if (ListeFenetres.get(i).getidOuverture()==idFenetre){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour la pièce :");
                idFenetre=Lire.i();
            }
        }
        Ouverture creafenetre = new Ouverture(type,idFenetre);
        code=creafenetre.toString()+" , \n";
        return creationObjet(ListeFenetres, creafenetre,code);
    }
    public Resultat creationTremis(){
        String code, type="tremis";
        int idTremis;
        System.out.println("Identifiant Tremis : ");
        idTremis=Lire.i();
        for (int i=0;i<ListeTremis.size();i++){
            if (ListeTremis.get(i).getidOuverture()==idTremis){
                System.out.println("L'identifiant existe déja, donnez un nouvel identifiant pour la pièce :");
                idTremis=Lire.i();
            }
        }
        Ouverture creatremis = new Ouverture(type,idTremis);
        code=creatremis.toString()+" , \n";
        return creationObjet(ListeTremis, creatremis,code);
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

    public ArrayList<Ouverture> getListePortes() {
        return ListePortes;
    }

    public ArrayList<Ouverture> getListeFenetres() {
        return ListeFenetres;
    }

    public ArrayList<Ouverture> getListeTremis() {
        return ListeTremis;
    }

    public ArrayList<Appartement> getListeAppartements() {
        return ListeAppartements;
    }

    public ArrayList<Niveau> getListeNiveaux() {
        return ListeNiveaux;
    }

    public ArrayList<Immeuble> getListeImmeubles() {
        return ListeImmeubles;
    }

    
    public String creerElement(int choix) {
        String code="";
    switch (choix) {
        case 1 -> {
            Resultat resultat = creationCoin();
            code = resultat.getCode();
            break;
        }
        case 2 ->{
            Resultat resultat = creationPorte();
            code = resultat.getCode();
            break;
        }
        case 3 -> {
            Resultat resultat = creationFenetre();
            code = resultat.getCode();
            break;
        }
        case 4 ->{
            Resultat resultat = creationTremis();
            code = resultat.getCode();
            break;
        }
        case 5 ->{
            Resultat resultat = creationMur();
            code = resultat.getCode();
            break;
        }
        case 6 -> {
            Resultat resultat = creationPiece();
            code = resultat.getCode();
            break;
        }
        case 7 -> {
            Resultat resultat = creationAppartement();
            code = resultat.getCode();
            break;
            }
        case 8 -> {
            Resultat resultat = creationNiveau();
            code = resultat.getCode();
            break;
            }
        case 9 -> {
            Resultat resultat = creationBatiment();
            code = resultat.getCode();
            break;
            }
        default -> System.out.println("Choix invalide.");
    }
     
    return code;    
        }
    /**
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        //création des instances des classes nécessaires
        Main mainInstance = new Main();
        ArrayList<Coin> ListeCoins = mainInstance.getListeCoins();
        ArrayList<Ouverture> ListePortes = mainInstance.getListePortes();
        ArrayList<Ouverture> ListeFenetres = mainInstance.getListeFenetres();
        ArrayList<Ouverture> ListeTremis = mainInstance.getListeTremis();
        ArrayList<Mur>ListeMurs = mainInstance.getListeMurs();
        ArrayList<Mur>ListeMursPiece = mainInstance.getListeMursPiece();
        ArrayList<Piece>ListePieces = mainInstance.getListePieces();
        ArrayList<Appartement>ListeAppartements = mainInstance.getListeAppartements();
        ArrayList<Niveau>ListeNiveaux = mainInstance.getListeNiveaux();
        ArrayList<Immeuble>ListeImmeubles = mainInstance.getListeImmeubles();
        String code="";
        String Porte="", Fenetre="" , Tremis="";
        int id, idCoinD , idCoinF , n=0, idMur, idPorte, idFenetre, idTremis, idPiece, idAppartement, idNiveau, idImmeuble;
        int nbrFenetre, nbrPorte,nbrRevetement, choix;
        double a, o, x, y, ab, or;
        //String usage="";
        Coin coinD, coinF;
        
        
        try {
            File tempFile = new File("temp.txt");
            //création d'un buffered reader qui utilise un filereader pour lire le fichier
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            // Créer une liste pour stocker les lignes non vides
            String nonEmptyLines = "", line;
            while ((line = reader.readLine()) != null) {
                // Vérifier si la ligne est vide
                if (!line.trim().isEmpty()) {
                    // Si la ligne n'est pas vide, l'ajouter à la liste
                    nonEmptyLines += line + "\n";
                }
            }
            reader.close();
            // Écrire les lignes non vides dans le fichier temporaire
            FileWriter fileWriter = new FileWriter(tempFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(nonEmptyLines);
            bufferedWriter.close();
            // Renommer le fichier temporaire en utilisant le nom du fichier d'origine
            File originalFile = new File("Liste_Batiment.txt");
            if (!tempFile.renameTo(originalFile)) {
                System.out.println("Impossible de renommer le fichier temporaire.");
            }
            reader = new BufferedReader(new FileReader(originalFile));
            while (reader.ready()) {
                String ligne = reader.readLine();
                //System.out.println("Ligne lue : " + ligne); 
                //méthode appelée pour identification du type
                
                
                if (ligne.startsWith("Coin")){
                    n=1;
                }
                if(ligne.startsWith("Porte")){
                    n=2;
                }
                if (ligne.startsWith("Fenetre")){// fenetre avec ou sans accent ?? a définir
                    n=3;
                }
                if (ligne.startsWith("Tremis")){
                    n=4;
                }
                if (ligne.startsWith("Mur")){
                    n=5;
                }
                if (ligne.startsWith("Piece")){
                    n=6;
                }
                if (ligne.startsWith("Appartement")){
                    n=7;
                }
                if (ligne.startsWith("Niveau")){
                    n=8;
                }
                if (ligne.startsWith("Immeuble")){
                    n=9;
                }
                String[] tab = ligne.split(" ");
                if (tab.length>0){
                    String type = tab[0];
                
                    //switch selon le type
                    switch (type){
                        case "Coin" -> {//coin
                            if (tab.length >= 13) {
                                id = Integer.parseInt(tab[4]);
                                a = Double.parseDouble(tab[8]);
                                o = Double.parseDouble(tab[12]);
                                Coin cointxt = new Coin(id, a, o);
                                ListeCoins.add(cointxt);
                            }
                            break;
                        }
                        case "Porte" ->{ // porte
                            if (tab.length >= 7) {
                                idPorte = Integer.parseInt(tab[4]);
                                Ouverture portetxt = new Ouverture(Porte, idPorte);
                                ListePortes.add(portetxt);
                            }
                            break;
                        }

                        case "Fenetre" -> {//si pas fenetre standard rajouter longueur et largeur dans parenthese dans ouverture)
                            if (tab.length >= 7) {
                                idFenetre = Integer.parseInt(tab[4]);
                                Ouverture fenetretxt = new Ouverture(Fenetre, idFenetre);
                                ListeFenetres.add(fenetretxt);
                            }
                            break;
                        }
                        case "Tremis" -> {// tremis
                           if (tab.length >= 7) {
                                idTremis = Integer.parseInt(tab[4]);
                                Ouverture tremistxt = new Ouverture(Tremis, idTremis);
                                ListeTremis.add(tremistxt);
                            }  
                            break;

                        }
                        case "Mur" -> {// mur
                            if (tab.length >= 51) {
                                idMur = Integer.parseInt(tab[4]);
                                idCoinD = Integer.parseInt(tab[12]);
                                ab = Double.parseDouble(tab[16]);
                                or = Double.parseDouble(tab[20]);
                                coinD = new Coin(idCoinD, ab, or);
                                idCoinF = Integer.parseInt(tab[29]);
                                ab = Double.parseDouble(tab[33]);
                                or = Double.parseDouble(tab[37]);
                                coinF = new Coin(idCoinF, ab, or);
                                nbrPorte = Integer.parseInt(tab[42]);
                                nbrFenetre = Integer.parseInt(tab[46]);
                                nbrRevetement = Integer.parseInt(tab[50]);
                                Mur murtxt = new Mur(idMur, coinD, coinF, nbrPorte, nbrFenetre, nbrRevetement);
                                ListeMurs.add(murtxt);
                            }
                            break;
                        }
                        case "Piece" -> {//piece
                            if (tab.length >= 51) {// plus que 51 index
                                idPiece = Integer.parseInt(tab[4]);
                                 //Piece piecetxt = new Piece(idPiece, usage, sol, plafond, ListeMursPiece);
                                //ListePieces.add(piecetxt);
                            }
                            break;
                        }
                        case "Appartement" -> {//appartement
                            if (tab.length >= 51) {// plus que 51 index
                                idAppartement = Integer.parseInt(tab[4]);
                                // Appartement appartementtxt = new Appartement();
                                //ListeAppartements.add(appartementtxt);
                            
                            }
                            break;
                        }
                        case "Niveau" -> {//niveau
                            if (tab.length >= 51) {// plus que 51 index
                            idNiveau = Integer.parseInt(tab[4]);
                            //Niveau niveautxt = new Niveau();
                            //ListeNiveaux.add(niveautxt);
                            
                            }
                            break;
                        }
                        case "Immeuble" -> {//immeuble
                            if (tab.length >= 51) {// plus que 51 index
                                idImmeuble = Integer.parseInt(tab[4]);
                                //Immeuble immeubletxt = new Immeuble();
                                //ListeImmeubles.add(immeubletxt);
                            }
                            break;
                        }
                        default -> {
                            // Gestion par défaut si le type n'est pas reconnu
                            System.out.println("Le fichier est vide.");
                        }
                    }
                }                               
                
            }
        } 
        catch(FileNotFoundException err){
            System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
        }
        // Pour la liste de coins
        if (ListeCoins.isEmpty()) {
            System.out.println("La liste de coins est vide.");
        } else {
            for (Coin coin : ListeCoins) {
                coin.afficherCoin();
            }
        }

        // Pour la liste de portes
        if (ListePortes.isEmpty()) {
            System.out.println("La liste de portes est vide.");
        } else {
            for (Ouverture porte : ListePortes) {
                porte.afficherPorte();
            }
        }

        // Pour la liste de fenêtres
        if (ListeFenetres.isEmpty()) {
            System.out.println("La liste de fenêtres est vide.");
        } else {
            for (Ouverture fenetre : ListeFenetres) {
                fenetre.afficherFenetre();
            }
        }

        // Pour la liste de tremis
        if (ListeTremis.isEmpty()) {
            System.out.println("La liste de tremis est vide.");
        } else {
            for (Ouverture tremis : ListeTremis) {
                tremis.afficherTremis();
            }
        }

        // Pour la liste de murs
        if (ListeMurs.isEmpty()) {
            System.out.println("La liste de murs est vide.");
        } else {
            for (Mur mur : ListeMurs) {
                mur.afficherMur();
            }
        }

        // Pour la liste de pièces
        if (ListePieces.isEmpty()) {
            System.out.println("La liste de pièces est vide.");
        } else {
            for (Piece piece : ListePieces) {
                piece.afficherPiece();
            }
        }
        
        // Pour la liste de appartement
        if (ListeAppartements.isEmpty()) {
            System.out.println("La liste d'appartement est vide.");
        } else {
            for (Appartement appartement : ListeAppartements) {
                appartement.afficherAppartement();
            }
        }
        // Pour la liste de niveaux
        if (ListeNiveaux.isEmpty()) {
            System.out.println("La liste de niveaux est vide.");
        } else {
            for (Niveau niveau : ListeNiveaux) {
                niveau.afficherNiveau();
            }
        }
        // Pour la liste d'immeubles
        if (ListeImmeubles.isEmpty()) {
            System.out.println("La liste d'immeubles est vide.");
        } else {
            for (Immeuble immeuble : ListeImmeubles) {
                immeuble.afficherImmeuble();
            }
        }
        
        
        
        
        do {
            System.out.println("Quel élément voulez-vous créer ? (0: rien) (1: coin) (2: porte) (3: fenetre) (4: tremis) (5: mur) (6: piece) (7: appartement) (8: niveau) (9: batiment)");
            choix = Lire.i();
            while (choix!=0&&choix!=1&&choix!=2&&choix!=3&&choix!=4&&choix!=5&&choix!=6&&choix!=7&&choix!=8&&choix!=9){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct");
                choix=Lire.i();
            }
            if (choix != 0) {
                String elementCode = mainInstance.creerElement(choix);
                code+=elementCode;
            }
        } while (choix != 0);
        
        System.out.println("Contenu à écrire dans le fichier : " + code);
        
        try {
            // Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter("Liste_Batiment.txt", true);
                
            // Création d'un bufferedWriter qui utilise le fileWriter
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // ajout d'un texte à notre fichier
            writer.newLine();
            writer.write(code);
            
            
            // Retour à la ligne
            
            writer.close();
		} 
        catch (IOException e) {
            e.printStackTrace();
	}
        
    }
}

        
        
        
        /*
        // Créationde coins
        
        System.out.println("Création d'un coin : 1 = OUI et 0 = NON");
        reponse=Lire.i();
        while (reponse!=0&&reponse!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            reponse=Lire.i();
        }
        // Boucle de saisie et d'ajout de Coins dans la liste
        while(reponse!=0){
            System.out.println("Identifiant du coin: ");
            id=Lire.i();
            System.out.println("Abcisse: ");
            a=Lire.d();
            System.out.println("Ordonnée: ");
            o=Lire.d();
            // Appel du constructeur pour créer une instance de coin
            c=new Coin(id,a,o);
            //System.out.println(c.toString());
            ListeCoins.add(c);
            code=code+c.toString()+" , \n";
            System.out.println("Création d'un coin : 1 = OUI et 0 = NON");
            reponse=Lire.i();
            if (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
        }// fin de la boucle While
        //Recherche d'un coin dans ListeCoins par son identifiant
        System.out.println("Identifiant du Coin Recherché: ");
        idRech=Lire.i();
        for (int i=0;i<ListeCoins.size();i++){
            if (ListeCoins.get(i).getidCoin()==idRech)
                ListeCoins.get(i).afficher();
        }
        //création mur
        System.out.println("Création d'un mur : 1 = OUI et 0 = NON");
        reponse=Lire.i();
        while (reponse!=0&&reponse!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            reponse=Lire.i();
        }
        while (reponse!=0){
            System.out.println("Identifiant du mur: ");
            idMur=Lire.i();
            // choix pour un coin de début déjà existant ou non
            System.out.println("Le coin de début existe-t-il déjà ? (1 = OUI et 0 = NON)");
            exiCoinDeb=Lire.i();
            while (exiCoinDeb!=0&&exiCoinDeb!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                exiCoinDeb=Lire.i();
            }
            // coin début existe déjà
            if(exiCoinDeb==1){
                System.out.println("Identifiant du coin de début recherché: ");
                idRecherche=Lire.i();
                for (int i=0;i<ListeCoins.size();i++){
                    if (ListeCoins.get(i).getidCoin()==idRecherche){
                        idCoinD=ListeCoins.get(i).getidCoin();
                        x=ListeCoins.get(i).getcx();
                        y=ListeCoins.get(i).getcy();
                        coinDebut=new Coin(idCoinD,x,y);
                    }
                }
                
            }
            // coin début n'existe pas
            else{
                System.out.println("Identifiant du coin de début: ");
                idCoinD=Lire.i();
                System.out.println("Abcisse: ");
                x=Lire.d();
                System.out.println("Ordonnée: ");
                y=Lire.d();
                coinDebut=new Coin(idCoinD,x,y);
                ListeCoins.add(coinDebut);
                code=code+coinDebut.toString()+" , \n";
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
                for (int i=0;i<ListeCoins.size();i++){
                    if (ListeCoins.get(i).getidCoin()==idRecherche){
                        idCoinF=ListeCoins.get(i).getidCoin();
                        x=ListeCoins.get(i).getcx();
                        y=ListeCoins.get(i).getcy();
                        coinFin=new Coin(idCoinF,x,y);
                    }
                }
                
            }
            // coin fin n'existe pas
            else{
                System.out.println("Identifiant du coin de fin: ");
                idCoinF=Lire.i();
                System.out.println("Abcisse: ");
                x=Lire.d();
                System.out.println("Ordonnée: ");
                y=Lire.d();
                coinFin=new Coin(idCoinF,x,y);
                ListeCoins.add(coinFin);
                code=code+coinFin.toString()+" , \n";
            }
            System.out.println("Combien de porte y a-t-il ?");
            nbrPorte=Lire.i();
            System.out.println("Combien de fenêtre y a-t-il ?");
            nbrFenetre=Lire.i();
            System.out.println("Combien de revêtement y a-t-il ?");
            nbrRevetement=Lire.i();
            Mur M = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement);
            ListeMurs.add(M);
            code=code+M.toString()+" , \n";
            System.out.println("Création d'un mur : 1 = OUI et 0 = NON");
            reponse=Lire.i();
            if (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
                        
        }*/
        //Création d'un Bâtiment
        /*String id ;
        ArrayList<Niveau> listeNiveau ;
        
        System.out.println("Donnez le nom du batiment") ;
        id=Lire.S() ;
        //initialiser listeNiveau en allant chercher la liste ou en la créant ?
        Batiment b=new Batiment(id,listeNiveau) ;
        //Création d'un Niveau
        
        //Création d'un Appartement
        
        //Création d'une Pièce
        System.out.println("Identifiant pièce : ");
        idPiece=Lire.i();
        System.out.println("Usage de la pièce :");
        usage=Lire.s();
        System.out.println("Sol : ");
        sol=Lire.i();
        System.out.println("Plafond : ");
        plafond=Lire.i();
        System.out.println("Combien y a-t-il de mur dans la pièce "+idPiece+" ?");
        nbrMur=Lire.i();
        for (i=1; i=nbrMur; i++){
            System.out.println("Quel est l'identifiant du mur n°"+i+"?");
            idMurRech=Lire.i();
            for (int i=0;i<ListeCoins.size();i++){
                if (ListeMurs.get(i).getidMur()==idMurRech)
                    ListeMursPiece.add(mur);
                }
            }
        }
        
        Piece p = new Piece(idPiece, usage, sol, plafond, ArrayList<Mur>ListeMursPiece);
        
        //Création d'un Sol
        
        //Création d'un Plafond
                    
        //Création d'une Ouverture
        int idOuverture;
        double dimX, dimY ;
        System.out.println("Identifiant de l'Ouverture : ");
        idOuverture = Lire.i();
        System.out.println("Dimension en x de l'Ouverture " + idOuverture + " : ");
        dimX = Lire.d();
        System.out.println("Dimension en y de l'Ouverture " + idOuverture + " : ");
        dimY = Lire.d();
        // Appel du constructeur pour créer une instance d'Ouverture
        Ouverture o;
        o = new Ouverture(idOuverture, dimX, dimY);
        o.afficher();*/
        
        //Création d'un Revêtement
         // Revetement.LectureRevetement();
    