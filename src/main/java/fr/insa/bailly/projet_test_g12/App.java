package fr.insa.bailly.projet_test_g12;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.geometry.Pos;

public class App extends Application {

    private MenuBar menuBar;
    private Stage primaryStage;
    private Button bNiveau;
    private Button bPiece;
    private double startX, startY;
    private Canvas canvas;
    private Text infoText;
    int t_canva = 650; //taille du canva
    double rt = t_canva/50; //ratio pour calculer taille elements
    Boolean booNiveau = false;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {
        this.primaryStage = stage;

        menuBar = new MenuBar();
        Menu menuFichier = new Menu("Fichier");
        MenuItem menuItemNouveau = new MenuItem("Nouveau");
        MenuItem menuItemOuvrir = new MenuItem("Ouvrir");
        MenuItem menuItemQ = new MenuItem("Quitter");
        SeparatorMenuItem separator = new SeparatorMenuItem();

        // Ajout des items dans un menu
        menuFichier.getItems().add(menuItemNouveau);
        menuFichier.getItems().add(separator);
        menuFichier.getItems().add(menuItemOuvrir);
        menuFichier.getItems().add(separator);
        menuFichier.getItems().add(menuItemQ);

        // Mise écoute un Item de menu
        menuItemNouveau.setOnAction(e -> {
            nouveau();
        });
        menuItemOuvrir.setOnAction(e -> {
            System.out.println("Ouvrir");
        });
        menuItemQ.setOnAction(e -> {
            Platform.exit();
        });

        menuBar.getMenus().add(menuFichier);

        BorderPane root = new BorderPane();
        root.setTop(menuBar);

        Scene scRealStart = new Scene(root, 1080, 720);

        primaryStage.setTitle("Application Bâtiment");
        primaryStage.setScene(scRealStart);
        primaryStage.show();
    }

    private HBox RetourMenu() {
        Button bRetour = new Button("Retour");
        bRetour.setFont(new Font("Eras Bold ITC", 15));
        bRetour.setOnAction((t) -> {
            nouveau();
        });

        // Creating an HBox and aligning the button to the right
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.BOTTOM_LEFT);
        hbox.getChildren().add(bRetour);
        hbox.setPadding(new javafx.geometry.Insets(10)); // Add some padding

        return hbox;
    }


    public void nouveau() {
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setCenter(createSelectionContent());

        Scene scNouveau = new Scene(root, 1080, 720);
        primaryStage.setScene(scNouveau);
    }

    public VBox createSelectionContent() {
        Button bMaison = new Button("Maison");
        bMaison.setFont(new Font("Eras Bold ITC", 50));
        bMaison.setOnAction((t) -> {
            mainMaison();
        });

        Button bImmeuble = new Button("Immeuble");
        bImmeuble.setFont(new Font("Eras Bold ITC", 50));
        bImmeuble.setOnAction((t) -> {
            mainImmeuble();
        });

        // Création d'un HBox pour contenir les boutons
        HBox boutons = new HBox();
        VBox question = new VBox();
        // Ajouter un espacement entre les boutons (facultatif)
        boutons.setSpacing(50);
        question.setSpacing(80);

        Text typeBat = new Text();
        typeBat.setText("Quel type de bâtiment ?");
        typeBat.setFont(new Font("Eras Bold ITC", 40));

        // Ajout des boutons à l'HBox
        boutons.getChildren().addAll(bMaison, bImmeuble);
        question.setAlignment(Pos.CENTER);
        boutons.setAlignment(Pos.CENTER);

        question.getChildren().addAll(typeBat, boutons);

        return question;
    }

    public void mainMaison() {
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setBottom(RetourMenu());
        root.setCenter(createMainContent());

        Scene mainScene = new Scene(root, 1080, 720);
        primaryStage.setScene(mainScene);
    }

    public void mainImmeuble() {
        BorderPane root = new BorderPane();
        root.setTop(menuBar);
        root.setBottom(RetourMenu());
        root.setCenter(createMainContent());

        Scene mainScene = new Scene(root, 1080, 720);
        primaryStage.setScene(mainScene);
    }

    public HBox createMainContent() {
        //Bouton creation niveau
        this.bNiveau = new Button("Créer un niveau");
        bNiveau.setFont(new Font("Eras Bold ITC", 30));
        bNiveau.setOnAction((t) -> {
            booNiveau = true;
            // Ajouter les événements de la souris pour dessiner le rectangle
                canvas.setOnMousePressed(this::onMousePressed);
                canvas.setOnMouseDragged(this::onMouseDragged);
                canvas.setOnMouseReleased(this::onMouseReleased);
        });
        
        //Bouton creation piece
        this.bPiece = new Button("Créer une pièce");
        bPiece.setFont(new Font("Eras Bold ITC", 30));
        bPiece.setOnAction((t) -> {
            boutonRectangle(t);
        });
        this.bPiece.setDisable(true);
        

        //Zone de dessin
        canvas = new Canvas(t_canva, t_canva);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.LIGHTGREY); // Définir la couleur de remplissage
        gc.fillRect(0, 0, t_canva, t_canva);
        infoText = new Text();
        infoText.setFont(new Font("Eras Bold ITC", 15));
        infoText.setFill(Color.BLACK);

        //Ensemble de boutons
        VBox BoutonsCreation = new VBox();
        BoutonsCreation.getChildren().addAll(bNiveau, bPiece, infoText);
        BoutonsCreation.setSpacing(10);
        
        HBox mainPane = new HBox();
        mainPane.getChildren().addAll(canvas, BoutonsCreation);
        mainPane.setSpacing(20);

        return mainPane;
    }

    private void onMousePressed(MouseEvent event) {
        startX = event.getX();
        startY = event.getY();
        
        Point pStart = new Point(startX, startY, Color.BLACK);
    }

    private void onMouseDragged(MouseEvent event) {
            double endX = event.getX();
            double endY = event.getY();
            
            Point pEnd = new Point(endX, endY, Color.BLACK);

            GraphicsContext gc = canvas.getGraphicsContext2D();
            gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            gc.setFill(Color.LIGHTGRAY);
            gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

            double width = Math.abs(endX - startX);
            double height = Math.abs(endY - startY);
            double topX = Math.min(startX, endX);
            double topY = Math.min(startY, endY);

            gc.setStroke(Color.BLACK);
            gc.strokeRect(topX, topY, width, height);
            

            // Affichage des dimensions et de la surface
            double area = (width/rt) * (height/rt);
            infoText.setText(String.format("Largeur: %.2fm; Hauteur: %.2fm; Surface: %.2fm2", width/rt, height/rt, area));
            
    }

    private void onMouseReleased(MouseEvent event) {
        double endX = event.getX();
        double endY = event.getY();

        double width = Math.abs(endX - startX);
        double height = Math.abs(endY - startY);
        double topX = Math.min(startX, endX);
        double topY = Math.min(startY, endY);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setFill(Color.LIGHTGRAY); // Re-remplir le fond du canvas
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setStroke(Color.BLACK);
        gc.strokeRect(topX, topY, width, height);

        // Affichage des dimensions et de la surface
        double area = (width/rt) * (height/rt);
        infoText.setText(String.format("Largeur: %.2fm; Hauteur: %.2fm; Surface: %.2fm2", width/rt, height/rt, area));
        
        //Debloquage des boutons
        this.bPiece.setDisable(false);
        
        booNiveau = false;
    }

    void boutonRectangle(ActionEvent t) {
        // Action pour le bouton Rectangle (à définir)
    }
    
    public Button getbNiveau() {
        return bNiveau;
    }
    
    public Button getbPiece() {
        return bPiece;
    }
}
