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

    public static void main(String[] args) throws IOException {
        String code="";
        Coin c;
        int id, idCoinD = 0, idCoinF = 0, n=0, idMur, idPorte, idFenetre, idTremis, idPiece, idAppartement, idNiveau, idImmeuble;
        int nbrFenetre, nbrPorte, nbrRevetement;
        double a, o, x, y;
        Coin coinDebut = null, coinFin = null;
        //Déclaraion de la ArrayList
        ArrayList<Coin>ListeCoins;
        // Initialisation de la liste
        ListeCoins = new ArrayList<>();
        //ArrayList<Porte>ListePortes;
        //ListePortes = new ArrayList<>();
        //ArrayList<Fenetre>ListeFenetres;
        //ListeFenetres = new ArrayList<>();
        //ArrayList<Tremis>ListeTremis;
        //ListeTremis = new ArrayList<>();
        ArrayList<Mur>ListeMurs;
        ListeMurs = new ArrayList<>();
        ArrayList<Piece>ListePieces;
        ListePieces = new ArrayList<>();
        ArrayList<Appartement>ListeAppartements;
        ListeAppartements = new ArrayList<>();
        ArrayList<Niveau>ListeNiveaux;
        ListeNiveaux = new ArrayList<>();
        //ArrayList<Immeuble>ListeImmeubles;
        //ListeImmeuble = new ArrayList<>();
        try {
            // Création d'un fileWriter pour écrire dans un fichier
            FileWriter fileWriter = new FileWriter("Liste_Batiment.txt", false);
                
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
        try {
        //création d'un buffered reader qui utilise un filereader pour lire le fichier
            BufferedReader reader = new BufferedReader(new FileReader("Liste_Batiment.txt"));
            while (reader.ready()) {
                String ligne =reader.readLine();
                //méthode appelée pour identification du type
                String[] tab = ligne.split(" ");
                if (tab[0]=="Coin"){
                    n=1;
                }
                if (tab[0]=="Porte"){
                    n=2;
                }
                if (tab[0]=="Fenetre"){// fenetre avec ou sans accent ?? a définir
                    n=3;
                }
                if (tab[0]=="Tremis"){
                    n=4;
                }
                if (tab[0]=="Mur"){
                    n=5;
                }
                if (tab[0]=="Piece"){
                    n=6;
                }
                if (tab[0]=="Appartement"){
                    n=7;
                }
                if (tab[0]=="Niveau"){
                    n=8;
                }
                if (tab[0]=="Immeuble"){
                    n=9;
                }
                //switch selon le type
                switch (n){
                    case 1 :
                        id=Integer.parseInt(tab[4]);
                        a=Double.parseDouble(tab[8]);
                        o=Double.parseDouble(tab[12]);
                        Coin cointxt= new Coin(id,a,o) ; //Création d'un nouveau revetement
                        ListeCoins.add(cointxt); //ajout du revetement à la liste
                        break;
                    case 2 :// porte
                        idPorte=Integer.parseInt(tab[4]);
                        break;
                    case 3 ://si pas fenetre standard rajouter longueur et largeur dans parenthese dans ouverture)
                        idFenetre=Integer.parseInt(tab[4]);
                        break;
                    case 4 :// tremis
                        idTremis=Integer.parseInt(tab[4]);
                        break;
                    case 5 :// mur
                        idMur=Integer.parseInt(tab[4]);
                        coinDebut=Coin.parseCoin(tab[8]);
                        coinFin=Coin.parseCoin(tab[23]); //Valeur dans tab[] a verifier 
                        nbrPorte=Integer.parseInt(tab[40]);//Valeur dans tab[] a verifier 
                        nbrFenetre=Integer.parseInt(tab[44]);//Valeur dans tab[] a verifier 
                        nbrRevetement=Integer.parseInt(tab[48]);//Valeur dans tab[] a verifier 
                        Mur murtxt = new Mur(idMur,coinDebut,coinFin,nbrPorte,nbrFenetre,nbrRevetement);
                        ListeMurs.add(murtxt);
                        break;
                    case 6 ://piece
                        
                        break;
                    case 7 ://appartement
                        
                        break;
                    case 8 ://niveau
                        
                        break;
                    case 9 ://immeuble
                        
                        break;
                }
                //dans le cas où c'est un coin :
                
            }
        } 
        catch(FileNotFoundException err){
            System.out.println( "Erreur :le fichier n’existe pas!\n "+err);
        }
        // Créationde coins
        int reponse;
        System.out.println("Création d'un coin : 1 = OUI et 0 = NON");
        reponse=Lire.i();
        while (reponse!=0&&reponse!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            reponse=Lire.i();
        }
        // Boucle de saisie et d'ajout de Coins dans la liste
        while(reponse!=0){
            System.out.println("Identifiant: ");
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
        int idRech=Lire.i();
        for (int i=0;i<ListeCoins.size();i++){
            if (ListeCoins.get(i).getidCoin()==idRech)
                ListeCoins.get(i).afficher();
        }
        System.out.println("Création d'un mur : 1 = OUI et 0 = NON");
        reponse=Lire.i();
        while (reponse!=0&&reponse!=1){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
            reponse=Lire.i();
        }
        while (reponse!=0){
            System.out.println("Identifiant: ");
            idMur=Lire.i();
            System.out.println("Le coin de début existe-t-il déjà ? (1 = OUI et 0 = NON)");
            int exiCoinDeb=Lire.i();
            while (exiCoinDeb!=0&&exiCoinDeb!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                exiCoinDeb=Lire.i();
            }
            if(exiCoinDeb==1){
                System.out.println("Identifiant: ");
                idRech=Lire.i();
                for (int i=0;i<ListeCoins.size();i++){
                    if (ListeCoins.get(i).getidCoin()==idRech)
                        idCoinD=ListeCoins.get(i).getidCoin();
                        x=ListeCoins.get(i).getcx();
                        y=ListeCoins.get(i).getcy();
                        coinDebut=new Coin(idCoinD,x,y);
                }
                
            }
            else{
                System.out.println("Identifiant: ");
                idCoinD=Lire.i();
                System.out.println("Abcisse: ");
                x=Lire.d();
                System.out.println("Ordonnée: ");
                y=Lire.d();
                coinDebut=new Coin(idCoinD,x,y);
                ListeCoins.add(coinDebut);
                code=code+coinDebut.toString()+" , \n";
            }
            System.out.println("Le coin de fin existe-t-il déjà ? (1 = OUI et 0 = NON)");
            int exiCoinFin=Lire.i();
            while (exiCoinFin!=0&&exiCoinFin!=1){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct : 1 = OUI et 0 = NON");
                exiCoinFin=Lire.i();
            }
            if(exiCoinFin==1){
                System.out.println("Identifiant: ");
                idRech=Lire.i();
                for (int i=0;i<ListeCoins.size();i++){
                    if (ListeCoins.get(i).getidCoin()==idRech)
                        idCoinF=ListeCoins.get(i).getidCoin();
                        x=ListeCoins.get(i).getcx();
                        y=ListeCoins.get(i).getcy();
                        coinDebut=new Coin(idCoinF,x,y);
                }
                
            }
            else{
                System.out.println("Identifiant: ");
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
                        
        }
        
        System.out.println("Quel élément voulez vous créer ? (0:rien) (1:coin) (2:porte) (3:fenetre) (4:tremis) (5:mur) (6:piece) (7:appartement) (8:niveau) (9:immeuble)");
        int rep=Lire.i();
        while (rep!=0&&rep!=1&&rep!=2&&rep!=3&&rep!=4&&rep!=5&&rep!=6&&rep!=7&&rep!=8&&rep!=9){
            System.out.println("Valeur incorrect; veuillez donner une valeur correct");
            rep=Lire.i();
        }
        while(rep!=0){ // pas sure de ce qu'il faut mettre dans les parenthèse du while
            switch (rep){
                case 0 :
                    break;
                case 1 :
                    System.out.println("Identifiant: ");
                    id=Lire.i();
                    System.out.println("Abcisse: ");
                    a=Lire.d();
                    System.out.println("Ordonnée: ");
                    o=Lire.d();
                    c=new Coin(id,a,o);
                    ListeCoins.add(c);
                    code=code+c.toString()+" ,\n";
                    break;
                case 2 :
                    // porte
                    break;
                case 3 :
                    //si pas fenetre standard rajouter longueur et largeur dans parenthese dans ouverture)
                    break;
                case 4 :
                    // tremis
                    break;
                case 5 :
                    // mur
                    break;
                case 6 :
                    //piece
                    break;
                case 7 :
                    //appartement
                    break;
                case 8 :
                    //niveau
                    break;
                case 9 :
                    //immeuble
                    break;
            }
            System.out.println("Quel élément voulez vous créer ? (0:rien) (1:coin) (2:porte) (3:fenetre) (4:tremis) (5:mur) (6:piece) (7:appartement) (8:niveau) (9:immeuble)");
            rep=Lire.i();
            while (rep!=0&&rep!=1&&rep!=2&&rep!=3&&rep!=4&&rep!=5&&rep!=6&&rep!=7&&rep!=8&&rep!=9){
                System.out.println("Valeur incorrect; veuillez donner une valeur correct");
                rep=Lire.i();
            }
        }
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
        
        //Création d'un Mur
        int idMur, porte, fenetre, repet, iddebut, idfin ;
        Coin debut, fin ;
        ArrayList<Mur>ListeMurs ;
        ListeMurs = new ArrayList<>() ;
        
        System.out.println("Combien de murs à creer ?");
        repet=Lire.i();
        for(int i =1; i<=repet;){
        System.out.println("Donner un identifiant d'un mur") ;
        idMur=Lire.i() ;
        System.out.println("Donner le coin de début du mur "+idMur) ;
        iddebut=Lire.i() ;//faire méthode pour retrouver le coin
        System.out.println("Donner le coin de fin du mur "+idMur) ;
        idfin=Lire.i() ;//faire methode pour trouver le coin
        System.out.println("Donner le nombre de portes du mur "+idMur) ;
        porte=Lire.i() ;
        System.out.println("Donner le nombre de fenetres du mur "+idMur) ;
        fenetre=Lire.i() ;
        // Appel du constructeur pour creer l'instance de Mur
        Mur m = new Mur(idMur,debut,fin, porte, fenetre) ;
        m.afficher();
        ListeMurs.add(m);
        i=i+1;
        } 
        //Création d'un Sol
        
        //Création d'un Plafond
        
        // Création d'un coin 
        int idCoin, n, m;
        double abscisse, ordonnee ;
        ArrayList<Coin>ListeCoins;
        ListeCoins = new ArrayList<>();
        System.out.println("Combien de coin ?");
        n=Lire.i();
        for(int i =1; i<=n;){
        System.out.println("Donner un identifiant d'un coin") ;
        idCoin=Lire.i() ;
        System.out.println("Donner l'abscisse du coin "+idCoin) ;
        abscisse=Lire.d() ;
        System.out.println("Donner l'ordonnee du coin "+idCoin) ;
        ordonnee=Lire.d() ;
        // Appel du constructeur pour creer l'instance de Coin
        Coin c ;
        c= new Coin(idCoin,abscisse,ordonnee) ;
        c.afficher();
        ListeCoins.add(c);
        i=i+1;
        }
         // Renvoie d'une liste de coin
         m=ListeCoins.size();
        System.out.println("nombre élément dans la liste de coin "+m);
        for(Coin elem: ListeCoins)
       {
       	 System.out.println (elem);
       }
        
        
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
    }
} 