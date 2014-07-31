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
 * An AttDef is an Object that represents an attribute definition. It has an ID, a title and a type for the value. The type is ignored as all values are store in Strings.
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
