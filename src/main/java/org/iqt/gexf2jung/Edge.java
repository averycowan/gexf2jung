/*
 * Copyright 2014 Avery Cowan.
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

    /**
     * 
     * @param i 
     */
    public Edge(String i) {
        id = i;
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
     * 
     * @return 
     */
    public HashMap<String, Attribute> getAttValues() {
        return attvalues;
    }

    
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
     * @return the former label.
     */
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
    
    /**
     * 
     * @param s
     * @return
     * @throws InvalidDataValueException 
     */
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
