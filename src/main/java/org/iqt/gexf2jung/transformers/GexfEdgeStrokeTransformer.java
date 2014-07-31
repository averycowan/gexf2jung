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
