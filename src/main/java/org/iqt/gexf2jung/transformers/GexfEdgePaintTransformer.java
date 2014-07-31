/*
 * Copyright 2014 acowan.
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

import java.awt.Color;
import java.awt.Paint;
import org.apache.commons.collections15.Transformer;
import org.iqt.gexf2jung.Edge;

/**
 * This Transformer returns <code>Edge.getColor()</code>. If that is null it return <code>java.awt.Color.BLACK</code>.
 * @author Avery Cowan
 */
public class GexfEdgePaintTransformer implements Transformer<Edge, Paint> {

    @Override
    public Paint transform(Edge e) {
        if (e.getColor() == null) {
            return Color.BLACK;
        } else {
            return e.getColor();
        }
    }
    
}