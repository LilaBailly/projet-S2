/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.insa.bailly.projet_test_g12;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 *
 * @author apoll
 */
public class Groupe extends Figure {
    
    private List<Figure> contient;
    
    public Groupe() {
        this.contient = new ArrayList<Figure>();
    }
    
    public void add(Figure f){
        if(f.getGroupe() != this){
            if(f.getGroupe() != null) {
                throw new Error("figure deja dans un autre groupe");
            }
            this.contient.add(f);
            f.setGroupe(this);
        }
    }
    
    public void remove(Figure f) {
        if (f.getGroupe() != this) {
            throw new Error("la figure n'est pas dans le groupe");
        }
        this.contient.remove(f);
        f.setGroupe(null);
    }
    
    public void removeAll(List<Figure> lf) {
        for (Figure f : lf) {
            this.remove(f);
        }
    }
    
    public void clear() {
        List<Figure> toRemove = new ArrayList<>(this.contient);
        this.removeAll(toRemove);
    }
    
    public int size() {
        return this.contient.size();
    }
    
    /**
     * retourne la figure contenue dans le groupe la plus proche du point et au
     * maximum à distMax du point; retourne null si aucune figure n'est à une
     * distance plus faible que distMax;
     */
    public Figure plusProche(Point p, double distMax) {
        if (this.contient.isEmpty()) {
            return null;
        } else {
            Figure fmin = this.contient.get(0);
            double min = fmin.distancePoint(p);
            for (int i = 1; i < this.contient.size(); i ++) {
                Figure fcur = this.contient.get(i);
                double cur = fcur.distancePoint(p);
                if (cur < min) {
                    min = cur;
                    fmin = fcur;
                }
            }
            if (min <= distMax) {
                return fmin;
            } else {
                return null;
            }
        }
        
    }

    @Override
    public double maxX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).maxX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).maxX();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
        
    }
    
    @Override
    public double maxY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double max = this.contient.get(0).maxY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).maxY();
                if (cur > max) {
                    max = cur;
                }
            }
            return max;
        }
        
    }
    
    @Override
    public double minX() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minX();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minX();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
        
    }
    
    @Override
    public double minY() {
        if (this.contient.isEmpty()) {
            return 0;
        } else {
            double min = this.contient.get(0).minY();
            for (int i = 1; i < this.contient.size(); i++) {
                double cur = this.contient.get(i).minY();
                if (cur < min) {
                    min = cur;
                }
            }
            return min;
        }
        
    }

    @Override
    public double distancePoint(Point p) {
        if (this.contient.isEmpty()) {
            return new Point(0,0,Color.BLACK).distancePoint(p);
        } else {
            double dist = this.contient.get(0).distancePoint(p);
            for (int i = 1; i < this.contient.size(); i ++) {
                double cur = this.contient.get(i).distancePoint(p);
                if (cur < dist) {
                    dist = cur;
                }
            }
            return dist;
        }
    }
    
    @Override
    public void dessine(GraphicsContext context) {
        for(Figure f : this.contient) {
            f.dessine(context);
        }
       }

    @Override
    public void dessineSelection(GraphicsContext context) {
        for(Figure f : this.contient) {
            f.dessine(context);
        }
    }

    public Groupe sousGroupe(List<Figure> selection) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
