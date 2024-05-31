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
public class Point {
    
    public static double RAYON_IN_DRAW = 5;
    
    private double px;
    private double py;
    private Color color = Color.BLACK;
    
    public Point (double px, double py, Color color){
        this.px = px;
        this.py = py;
        this.color = color; 
    }
    
    // Attributs
    public double getPx() {
        return px;
    }
    
    public void setPx(double px) {
        this.px = px;
    }
    
    public double getPy() {
        return py;
    }
    
    public void setPy(double py) {
        this.py = py;
    }
    
    // Methode ToString pour les afficher correctement
    @Override
    public String toString() {
        return "(" + px + "," + py + ")";
    }

    public double maxX() {
        return this.px;
    }
    
    public double maxY() {
        return this.py;
    }
    
    public double minX() {
        return this.px;
    }
    
    public double minY() {
        return this.px;
    }

    public double distancePoint(Point p) {
        double dx = this.px - p.px;
        double dy = this.py - p.py;
        return Math.sqrt(dx*dx*dy*dy);
    }

    public void dessine(GraphicsContext context) {
        context.setFill(Color.BLACK);
        context.fillOval(this.px-RAYON_IN_DRAW, this.py-RAYON_IN_DRAW, 2*RAYON_IN_DRAW, 2*RAYON_IN_DRAW);
    }

}
