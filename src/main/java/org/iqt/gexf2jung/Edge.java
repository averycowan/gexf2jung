/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iqt.gexf2jung;

import edu.uci.ics.jung.graph.util.EdgeType;
import java.util.HashMap;
import org.iqt.gexf2jung.exception.InvalidDataValueException;

/**
 *
 * @author Avery Cowan
 */
public class Edge {

    public final String id;
    private String label = "";
    private HashMap<String, Attribute> attvalues = new HashMap<String, Attribute>();
    private String stroke = "solid";
    private float weight = 1.0f;

    public Edge(String i) {
        id = i;
    }

    public String setLabel(String str) {
        String s = label;
        label = str;
        return s;
    }

    public String getLabel() {
        return label;
    }

    public String getID() {
        return id;
    }

    public HashMap<String, Attribute> getAttValues() {
        return attvalues;
    }

    public void addAtt(String i, Attribute a) {
        attvalues.put(i, a);
    }
    
    public String setStroke(String s){
        String temp = stroke;
        stroke = s;
        return temp;
    }
    
    public String getStroke(){
        return stroke;
    }

    public float setWeight(float w){
        float temp = weight;
        weight = w;
        return temp;
    }
    
    public float getWeight(){
        return weight;
    }
    
    public String toString() {
        return getClass().getSimpleName()+"[id:"+id+", label:"+label+", attributes:"+attvalues.toString()+"]";
    }
    
    public static EdgeType edgeType(String s) throws InvalidDataValueException {
        if (s.equals("MUTUAL")) {
            throw new InvalidDataValueException("defaultedgetype: \"mutual\" is not allowed");
        } else if (s.equals("DIRECTED")) {
            return EdgeType.DIRECTED;
        } else {
            return EdgeType.UNDIRECTED;
        }
    }
}
