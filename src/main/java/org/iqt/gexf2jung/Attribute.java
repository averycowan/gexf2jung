/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.iqt.gexf2jung;

/**
 *
 * @author Avery Cowan
 */
public class Attribute {
    private String id;
    private String value;
    private String title;
    Attribute(String i, String v, String t){
        super();
        id = i;
        value = v;
        title = t;
    }
    
    public String getID(){
        return id;
    }
    
    public String getValue(){
        return value;
    }
    
    public String setValue(String v){
        String temp = value;
        value = v;
        return temp;
    }
    
    public Object getTitle(){
        return title;
    }
    public String setTitle(String t){
        String temp = title;
        title = t;
        return temp;
    }
    
    public String toString(){
        return getClass().getSimpleName() + "[id:"+id+", title:"+title+", value:"+value.toString()+"]";
    }
}
