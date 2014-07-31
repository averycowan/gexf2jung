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
    
    /**
     * @return the former label.
     */
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
    
    /**
     * @return a HaphMap of the attribute values saved by id
     */
    public HashMap<String, Attribute> getAttValues(){
        return attvalues;
    }
    
    /**
     * Adds an attribute value to the <code>HashMap</code>.
     * @param i the ID of the attribute
     * @param a the attribute object.
     */
    public void addAtt(String i, Attribute a){
        attvalues.put(i, a);
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
    
    /**
     * @return the former position.
     */
    public Point3D setPosition(Point3D p){
        Point3D temp = position;
        position = p;
        return temp;
    }
    
    public Point3D getPosition(){
        return position;
    }
    
    /**
     * @return the former size.
     */
    public float setSize(float s){
        float temp = size;
        size = s;
        return temp;
    }
    
    public float getSize(){
        return size;
    }
    
    /**
     * @return the former shape.
     */
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
    
    @Override
    public String toString(){
        return getClass().getSimpleName()+"[id:"+id+", label:"+label+", attributes:"+attvalues.toString()+"]";
    }
}