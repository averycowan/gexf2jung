/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iqt.gexf2jung;

import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javafx.geometry.Point3D;
/**
 *
 * @author Avery Cowan
 */
public class Node {
    public final String id;
    private String label = "";
    private final HashMap<String, Attribute> attvalues = new HashMap<String, Attribute>();
    private Color color;
    private Point3D position;
    private float size = 1;
    private String shape;
    private final List<Date[]> spells = new ArrayList<Date[]>();
    
    public Node(String i){
        id = i;
    }
    
    public String setLabel(String str){
        String s = label;
        label = str;
        return s;
    }
    
    public String getLabel(){
        return label;
    }
    
    public String getID(){
        return id;
    }
    
    public HashMap<String, Attribute> getAttValues(){
        return attvalues;
    }
    
    public void addAtt(String i, Attribute a){
        attvalues.put(i, a);
    }
    
    
    public Color setColor(Color c){
        Color temp = color;
        color = c;
        return temp;
    }
    
    public Color getColor(){
        return color;
    }
    
    public Point3D setPosition(Point3D p){
        Point3D temp = position;
        position = p;
        return temp;
    }
    
    public Point3D getPosition(){
        return position;
    }
    
    public float setSize(float s){
        float temp = size;
        size = s;
        return temp;
    }
    
    public float getSize(){
        return size;
    }
    
    public String setShape(String s){
        String temp = shape;
        shape = s;
        return temp;
    }
    
    public String getShape(){
        return shape;
    }
    
    public List<Date[]> getSpells(){
        return spells;
    }
    
    public String toString(){
        return getClass().getSimpleName()+"[id:"+id+", label:"+label+", attributes:"+attvalues.toString()+"]";
    }
}