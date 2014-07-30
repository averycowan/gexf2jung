/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iqt.gexf2jung.transformers;

import org.apache.commons.collections15.Transformer;
import org.iqt.gexf2jung.Edge;

/**
 *
 * @author Avery Cowan
 */
public class GexfEdgeLabelTransformer implements Transformer<Edge, String> {
    
    public String transform(Edge e) {
        return e.getLabel();
    }
}