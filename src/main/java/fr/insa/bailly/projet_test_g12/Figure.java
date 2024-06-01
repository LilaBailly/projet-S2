/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author apoll
 */
public abstract class Figure {
    
    public static Color COULEUR_SELECTION = Color.RED;
    
    /**
     * null si aucun groupe
     */
    private Groupe groupe;
    
    public Groupe getGroupe() {
        return groupe;
    }
    
    void setGroupe(Groupe groupe) {
        this.groupe = groupe;
    }
    
    public abstract double maxX();
    public abstract double maxY(); 
    public abstract double minX();
    public abstract double minY();
    
    public abstract double distancePoint(Point p);
    
    public abstract void dessine(GraphicsContext context);
    
    public abstract void dessineSelection(GraphicsContext context);
}
