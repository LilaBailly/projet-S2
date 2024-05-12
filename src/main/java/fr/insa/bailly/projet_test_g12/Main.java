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
            System.out.println("Coin créé");
            code=code+creacoin.toString()+" , \n";
            return creationObjet(ListeCoins, creacoin, code);
        }

    public Resultat creationMur(){
        String code;
        int idMur, exiCoinDeb, idRecherche, idCoinD, exiCoinFin,idCoinF,  nbrPorte, nbrFenetre, nbrRevetement ;
        double x,y;
        Coin coinDebut = null; 
        Coin coinFin = null;
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
            for (int i=0;i<ListeCoins.size();i++){
                if (ListeCoins.get(i).getidCoin()==idRecherche){
                    idCoinF=ListeCoins.get(i).getidCoin();
                    x=ListeCoins.get(i).getcx();
                    y=ListeCoins.get(i).getcy();
                    coinFin = new Coin(idCoinF,x,y);
                }
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
        System.out.println("Mur créé");
        code=creamur.toString()+" , \n";
        return creationObjet(ListeMurs, creamur,code);
    }
    
    public Resultat creationPiece(){
        String code;
        Coin coinDebut, coinFin;
        int reponse;
        int  idRecherche, idMur, idPiece;
        int nbFenetre, nbPorte, nbRevetement, nbrMur, sol, plafond;
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
            System.out.println("Le mur n°"+j+1+" existe-t-il déjà ? (1 = OUI et 0 = NON)");
            reponse=Lire.i();
            while (reponse!=0&&reponse!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                reponse=Lire.i();
            }
            if(reponse==1){
                System.out.println("Identifiant du mur recherché: ");
                idRecherche=Lire.i();
                for (int i=0;i<ListeMurs.size();i++){
                    if (ListeMurs.get(i).getidMur()==idRecherche){
                        idMur=ListeMurs.get(j).getidMur();
                        coinDebut=ListeMurs.get(j).getcoinDebut();
                        coinFin=ListeMurs.get(j).getcoinFin();
                        nbPorte=ListeMurs.get(j).getnbrPorte();
                        nbFenetre=ListeMurs.get(j).getnbrFenetre();
                        nbRevetement=ListeMurs.get(j).getnbrRev();
                        Mur mur = new Mur(idMur,coinDebut,coinFin,nbPorte,nbFenetre,nbRevetement);
                        ListeMursPiece.add(mur);
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
        System.out.println("Piece créée");
        code=creapiece.toString()+" , \n";
        return creationObjet(ListePieces, creapiece,code);
    }
    
    
    
    
    public void creerElement(int choix) {
    switch (choix) {
        case 1 -> creationCoin();
        case 2 -> {//creationPorte();
            }
        case 3 -> {//creationFenetre();
            }
        case 4 -> {//creationTremis();
            }
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
        /*ClasseCoin classeCoin = mainInstance.new ClasseCoin();
        ClasseMur classeMur = mainInstance.new ClasseMur();
        ClassePiece classePiece = mainInstance.new ClassePiece();
        // Appel des méthodes à travers les instances créées
        Resultat resultatCoin = classeCoin.creationCoin();
        Resultat resultatMur = classeMur.creationMur();
        Resultat resultatPiece = classePiece.creationPiece();
        */String code="";
        String Porte="", Fenetre="" , Tremis="";
        int id, idCoinD , idCoinF , n=0, idMur, idPorte, idFenetre, idTremis, idPiece, idAppartement, idNiveau, idImmeuble;
        int nbrFenetre, nbrPorte,nbrRevetement;
        double a, o, x, y, ab, or;
        String usage="";
        Coin coinDebut = null, coinFin = null, coinD, coinF;
        //Déclaraion des ArrayList
        ArrayList<Coin>ListeCoins;
        // Initialisation des listes
        ListeCoins = new ArrayList<>();
        ArrayList<Ouverture>ListePortes;
        ListePortes = new ArrayList<>();
        ArrayList<Ouverture>ListeFenetres;
        ListeFenetres = new ArrayList<>();
        ArrayList<Ouverture>ListeTremis;
        ListeTremis = new ArrayList<>();
        ArrayList<Mur>ListeMurs;
        ListeMurs = new ArrayList<>();
        ArrayList<Mur>ListeMursPiece;
        ListeMursPiece = new ArrayList<>();
        ArrayList<Piece>ListePieces;
        ListePieces = new ArrayList<>();
        ArrayList<Appartement>ListeAppartements;
        ListeAppartements = new ArrayList<>();
        ArrayList<Niveau>ListeNiveaux;
        ListeNiveaux = new ArrayList<>();
        //ArrayList<Immeuble>ListeImmeubles;
        //ListeImmeuble = new ArrayList<>();
        
        try {
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            while (reader.ready()) {
                String ligne =reader.readLine();
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
                    }
                    case 2 ->{ // porte
                        idPorte=Integer.parseInt(tab[4]);
                        Ouverture portetxt = new Ouverture(Porte,idPorte);
                        ListePortes.add(portetxt);
                    }

                    case 3 -> {//si pas fenetre standard rajouter longueur et largeur dans parenthese dans ouverture)
                        idFenetre=Integer.parseInt(tab[4]);
                        Ouverture fenetretxt = new Ouverture(Fenetre,idFenetre);
                        ListeFenetres.add(fenetretxt);
                    }
                    case 4 -> {// tremis
                        if(tab.length>=5){
                            idTremis=Integer.parseInt(tab[4]);
                            Ouverture tremistxt = new Ouverture(Tremis,idTremis);
                            ListeTremis.add(tremistxt);
                        }
                        else {
                            System.out.println("La ligne lue n'a pas assez d'éléments pour accéder à l'index 4.");
                        }
                        
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
                        Mur murtxt = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement);
                        ListeMurs.add(murtxt);
                    }
                    case 6 -> {//piece
                        idPiece=Integer.parseInt(tab[4]);
                        //Piece piecetxt = new Piece(idPiece, usage, sol, plafond, ListeMursPiece);
                        //ListePieces.add(piecetxt);
                    }
                    case 7 -> {//appartement
                        idAppartement=Integer.parseInt(tab[4]);
                        // Appartement appartementtxt = new Appartement();
                        //ListeAppartements.add(appartementtxt);
                    }
                    case 8 -> {//niveau
                        idNiveau=Integer.parseInt(tab[4]);
                        //Niveau niveautxt = new Niveau();
                        //ListeNiveaux.add(niveautxt);
                    }
                    case 9 -> {//immeuble
                        idImmeuble=Integer.parseInt(tab[4]);
                        //Immeuble immeubletxt = new Immeuble();
                        //ListeImmeubles.add(immeubletxt);
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
            for (int k = 0; k < ListeCoins.size(); k++) {
                ListeCoins.get(k).afficher();
            }
        }

        // Pour la liste de portes
        if (ListePortes.isEmpty()) {
            System.out.println("La liste de portes est vide.");
        } else {
            for (int k = 0; k < ListePortes.size(); k++) {
                ListePortes.get(k).afficherPorte();
            }
        }

        // Pour la liste de fenêtres
        if (ListeFenetres.isEmpty()) {
            System.out.println("La liste de fenêtres est vide.");
        } else {
            for (int k = 0; k < ListeFenetres.size(); k++) {
                ListeFenetres.get(k).afficherFenetre();
            }
        }

        // Pour la liste de tremis
        if (ListeTremis.isEmpty()) {
            System.out.println("La liste de tremis est vide.");
        } else {
            for (int k = 0; k < ListeTremis.size(); k++) {
                ListeTremis.get(k).afficherTremis();
            }
        }

        // Pour la liste de murs
        if (ListeMurs.isEmpty()) {
            System.out.println("La liste de murs est vide.");
        } else {
            for (int l = 0; l < ListeMurs.size(); l++) {
                ListeMurs.get(l).afficher();
            }
        }

        // Pour la liste de pièces
        if (ListePieces.isEmpty()) {
            System.out.println("La liste de pièces est vide.");
        } else {
            for (int l = 0; l < ListePieces.size(); l++) {
                ListePieces.get(l).afficher();
            }
        }
        
        // Pour la liste de appartement
        if (ListeAppartements.isEmpty()) {
            System.out.println("La liste d'appartement est vide.");
        } else {
            for (int l = 0; l < ListeAppartements.size(); l++) {
                ListeAppartements.get(l).afficher();
            }
        }
        // Pour la liste de niveaux
        if (ListeNiveaux.isEmpty()) {
            System.out.println("La liste de niveaux est vide.");
        } else {
            for (int l = 0; l < ListeNiveaux.size(); l++) {
                ListeNiveaux.get(l).afficher();
            }
        }/*
        // Pour la liste d'immeubles
        if (ListeImmeubles.isEmpty()) {
            System.out.println("La liste d'immeubles est vide.");
        } else {
            for (int l = 0; l < ListeImmeubles.size(); l++) {
                ListeImmeubles.get(l).afficher();
            }
        }*/
        
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
        
        System.out.println("Quel élément voulez vous créer ? (0:rien) (1:coin) (2:porte) (3:fenetre) (4:tremis) (5:mur) (6:piece) (7:appartement) (8:niveau) (9:immeuble)");
        int choix=Lire.i();
        while (choix!=0&&choix!=1&&choix!=2&&choix!=3&&choix!=4&&choix!=5&&choix!=6&&choix!=7&&choix!=8&&choix!=9){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct");
            choix=Lire.i();
        }
        do {
            System.out.println("Quel élément voulez-vous créer ? (0: rien) (1: coin) (2: porte) (3: fenetre) (4: tremis) (5: mur) (6: piece) (7: appartement) (8: niveau) (9: immeuble)");
            choix = Lire.i();
            mainInstance.creerElement(choix);
        } while (choix != 0);
        
        
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
    