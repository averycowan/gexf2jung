/*
 * Copyright 2014 In-Q-Tel/Lab41.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.iqt.gexf2jung;

import edu.uci.ics.jung.graph.util.EdgeType;
import java.awt.Color;
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
    private Color color;
    private EdgeType et;
    private float thickness = 1.0f;

    /**
     * Default constructor for <code>Edge</code>
     * @param i an ID
     * @param e an edge type
     */
    public Edge(String i, EdgeType e) {
        id = i;
        et = e;
    }

    /**
     * @return the former label.
     */
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

    /**
     * @return a HaphMap of the attribute values saved by id
     */
    public HashMap<String, Attribute> getAttValues() {
        return attvalues;
    }

    /**
     * Adds an attribute value to the <code>HashMap</code>.
     * @param i the ID of the attribute
     * @param a the attribute object.
     */
    public void addAtt(String i, Attribute a) {
        attvalues.put(i, a);
    }
    
    /**
     * @return the former label.
     */
    public String setStroke(String s){
        String temp = stroke;
        stroke = s;
        return temp;
    }
    
    public String getStroke(){
        return stroke;
    }

    /**
     * @return the former weight.
     */
    public float setWeight(float w){
        float temp = weight;
        weight = w;
        return temp;
    }
    
    public float getWeight(){
        return weight;
    }
    
    /**
     * @return the former thickness.
     */
    public float setThickness(float t){
        float temp = thickness;
        thickness = t;
        return temp;
    }
    
    public float getThickness(){
        return thickness;
    }
    
    /**
     * @return the former color.
     */
    public Color setColor(Color c){
        Color temp = color;
        color = c;
        return temp;
    }
    
    public Color getColor(){
        return color;
    }
    
    @Override
    public String toString() {
        return getClass().getSimpleName()+"[id:"+id+", label:"+label+", attributes:"+attvalues.toString()+"]";
    }
    
    /**
     * Converts a String into an <code>EdgeType</code>.
     * @param s contains an edge type.
     * @return The converted <code>EdgeType</code>
     * @throws InvalidDataValueException if s is not "directed" or "undirected".
     */
    public static EdgeType edgeType(String s) throws InvalidDataValueException {
        if (s.equalsIgnoreCase("DIRECTED"))
            return EdgeType.DIRECTED;
        else if (s.equalsIgnoreCase("UNDIRECTED"))
            return EdgeType.UNDIRECTED;
        else
            throw new InvalidDataValueException("Edge type must be directed or undirected. Value \""+s+"\" is not allowed.");
    }
}
