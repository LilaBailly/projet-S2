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
            String code="";
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
            code=code+creacoin.toString()+" , \n";
            return creationObjet(ListeCoins, creacoin, code);
        }
    
    public Resultat creationMur(){
        String code;
        int idMur, exiCoinDeb, idRecherche, idCoinD, exiCoinFin,idCoinF,  nbrPorte, nbrFenetre, nbrRevetement ;
        double x,y;
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
            creationCoin();
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
            creationCoin();
        }
        System.out.println("Combien de porte y a-t-il ?");
        nbrPorte=Lire.i();
        System.out.println("Combien de fenêtre y a-t-il ?");
        nbrFenetre=Lire.i();
        System.out.println("Combien de revêtement y a-t-il ?");
        nbrRevetement=Lire.i();
        Mur creamur = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement);
        ListeMurs.add(creamur);
        code=creamur.toString()+" , \n";
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
                creationMur();
                
            }
        }
        Piece creapiece = new Piece(idPiece, usage, sol, plafond, ListeMursPiece);
        ListePieces.add(creapiece);
        code=creapiece.toString()+" , \n";
        return creationObjet(ListePieces, creapiece,code);
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

    
    public void creerElement(int choix) {
    switch (choix) {
        case 1 -> creationCoin();
        case 2 -> creationPorte();
        case 3 -> creationFenetre();
        case 4 -> creationTremis();
        case 5 -> creationMur();
        case 6 -> creationPiece();
        case 7 -> {//creationAppartement();
            }
        case 8 -> {//creationNiveau();
            }
        case 9 -> {//creationImmeuble();
            }
        default -> System.out.println("Choix invalide.");
    }
        
        
        
        
        
        
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
        int nbrFenetre, nbrPorte,nbrRevetement;
        double a, o, x, y, ab, or;
        String usage="";
        Coin coinD, coinF;
        
        
        try {
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            while (reader.ready()) {
                String ligne =reader.readLine();
                //System.out.println("Ligne lue : " + ligne); 
                //méthode appelée pour identification du type
                String[] tab = ligne.split(" ");
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
                //switch selon le type
                switch (n){
                    case 1 -> {//coin
                        id=Integer.parseInt(tab[4]);
                        a=Double.parseDouble(tab[8]);
                        o=Double.parseDouble(tab[12]);
                        Coin cointxt= new Coin(id,a,o) ;
                        ListeCoins.add(cointxt);
                        break;
                    }
                    case 2 ->{ // porte
                        idPorte=Integer.parseInt(tab[4]);
                        Ouverture portetxt = new Ouverture(Porte,idPorte);
                        ListePortes.add(portetxt);
                        break;
                    }

                    case 3 -> {//si pas fenetre standard rajouter longueur et largeur dans parenthese dans ouverture)
                        idFenetre=Integer.parseInt(tab[4]);
                        Ouverture fenetretxt = new Ouverture(Fenetre,idFenetre);
                        ListeFenetres.add(fenetretxt);
                        break;
                    }
                    case 4 -> {// tremis
                        idTremis = Integer.parseInt(tab[4]);
                        Ouverture tremistxt = new Ouverture(Tremis, idTremis);
                        ListeTremis.add(tremistxt);   
                        break;
                        
                    }
                    case 5 -> {// mur
                        idMur=Integer.parseInt(tab[4]);
                        idCoinD=Integer.parseInt(tab[12]);
                        ab=Double.parseDouble(tab[16]);
                        or=Double.parseDouble(tab[20]);
                        coinD = new Coin(idCoinD,ab,or);
                        idCoinF=Integer.parseInt(tab[29]);
                        ab=Double.parseDouble(tab[33]);
                        or=Double.parseDouble(tab[37]);
                        coinF = new Coin(idCoinF,ab,or);
                        nbrPorte=Integer.parseInt(tab[42]);//Valeur dans tab[] a verifier
                        nbrFenetre=Integer.parseInt(tab[46]);//Valeur dans tab[] a verifier
                        nbrRevetement=Integer.parseInt(tab[50]);//Valeur dans tab[] a verifier 
                        Mur murtxt = new Mur(idMur,coinD,coinF,nbrPorte,nbrFenetre,nbrRevetement);
                        ListeMurs.add(murtxt);
                        break;
                    }
                    case 6 -> {//piece
                        idPiece=Integer.parseInt(tab[4]);
                        //Piece piecetxt = new Piece(idPiece, usage, sol, plafond, ListeMursPiece);
                        //ListePieces.add(piecetxt);
                        //break;
                    }
                    case 7 -> {//appartement
                        idAppartement=Integer.parseInt(tab[4]);
                        // Appartement appartementtxt = new Appartement();
                        //ListeAppartements.add(appartementtxt);
                        //break;
                    }
                    case 8 -> {//niveau
                        idNiveau=Integer.parseInt(tab[4]);
                        //Niveau niveautxt = new Niveau();
                        //ListeNiveaux.add(niveautxt);
                        //break;
                    }
                    case 9 -> {//immeuble
                        idImmeuble=Integer.parseInt(tab[4]);
                        //Immeuble immeubletxt = new Immeuble();
                        //ListeImmeubles.add(immeubletxt);
                        //break;
                    }
                    default -> {
                        // Gestion par défaut si le type n'est pas reconnu
                        System.out.println("Le fichier est vide.");
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
        
        
        
        System.out.println("Quel élément voulez vous créer ? (0:rien) (1:coin) (2:porte) (3:fenetre) (4:tremis) (5:mur) (6:piece) (7:appartement) (8:niveau) (9:immeuble)");
        int choix=Lire.i();
        while (choix!=0&&choix!=1&&choix!=2&&choix!=3&&choix!=4&&choix!=5&&choix!=6&&choix!=7&&choix!=8&&choix!=9){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct");
            choix=Lire.i();
        }
        do {
            System.out.println("Quel élément voulez-vous créer ? (0: rien) (1: coin) (2: porte) (3: fenetre) (4: tremis) (5: mur) (6: piece) (7: appartement) (8: niveau) (9: immeuble)");
            choix = Lire.i();
            if (choix != 0) {
                mainInstance.creerElement(choix);
            }
        } while (choix != 0);
        System.out.println("Contenu à écrire dans le fichier : " + code);
        try {
            // Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter("Liste_Batiment.txt", true);
                
            // Création d'un bufferedWriter qui utilise le fileWriter
            BufferedWriter writer = new BufferedWriter(fileWriter);

            // ajout d'un texte à notre fichier
            writer.write(code);
            writer.newLine();
            
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
    