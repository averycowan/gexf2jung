/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iqt.gexf2jung.transformers;

import java.awt.BasicStroke;
import java.awt.Stroke;
import org.apache.commons.collections15.Transformer;
import org.iqt.gexf2jung.Edge;

/**
 *
 * @author Avery Cowan
 */
public class GexfEdgeStrokeTransformer implements Transformer<Edge, Stroke> {

    public Stroke transform(Edge e) {
        float weight = e.getWeight();
        if (e.getStroke() == null || e.getStroke().equals("solid")) {
            return new BasicStroke(weight);
        }
        if (e.getStroke().equals("dotted")) {
            float[] dash = new float[2];
            dash[0] = 0.0f;
            dash[1] = weight * 5.0f;
            return new BasicStroke(weight, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 10.0f, dash, 0.0f);
        }
        if (e.getStroke().equals("dashed")) {
            float[] dash = new float[1];
            dash[0] = weight * 10.f;
            return new BasicStroke(weight, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f);
        }
        return new BasicStroke(1.0f);
    }
}
