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
public final class AttDef {
    public final String id;
    public final String title;
    public final String type;
    
    public AttDef(String i, String l, String t){
        id = i;
        title = l;
        type = t;
    }
    
    public String toString(){
        return getClass().getSimpleName() + "[id:"+id+", title:"+title+", type:"+type+"]";
    }
}
