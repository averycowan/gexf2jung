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

/**
 * An <code>Attribute</code> represents an attribute value. It is used in a <code>HashMap</code> by Nodes and Edges. It has an ID that points to an <code>AttDef</code>.
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
    
    @Override
    public String toString(){
        return getClass().getSimpleName() + "[id:"+id+", title:"+title+", value:"+value.toString()+"]";
    }
}
