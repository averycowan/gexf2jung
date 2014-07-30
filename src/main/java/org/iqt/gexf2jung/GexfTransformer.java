/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iqt.gexf2jung;

import java.awt.Color;
import java.awt.Paint;
import org.apache.commons.collections15.Transformer;

/**
 *
 * @author Avery Cowan
 */
public class GexfTransformer implements Transformer<Node, Paint> {

    public Paint transform(Node n) {
        if (n.getColor() == null) {
            return Color.RED;
        } else {
            return n.getColor();
        }
    }
    
}
