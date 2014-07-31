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

package org.iqt.gexf2jung.transformers;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javafx.geometry.Point3D;
import org.apache.commons.collections15.Transformer;
import org.iqt.gexf2jung.Node;
import org.iqt.gexf2jung.exception.InvalidDataValueException;

/**
 *
 * @author Avery Cowan
 */
public class GexfNodeShapeTransformer implements Transformer<Node, Shape> {

    public Shape transform(Node n) {
        Shape shape = null;
        float size = n.getSize() * 20;
        Point3D position = new Point3D(-size / 2, -size / 2, 0);
        if (n.getPosition() != null) {
            position = n.getPosition();
        }
        if (n.getShape() == null || n.getShape().equals("disk")) {
            shape = new Ellipse2D.Float((float) position.getX(), (float) position.getY(), size, size);
        } else if (n.getShape().equals("square")) {
            shape = new Rectangle2D.Float((float) position.getX(), (float) position.getY(), size, size);
        } else if (n.getShape().equals("triangle")) {
            Polygon p = new Polygon();
            p.addPoint((int) (position.getX() + size / 2), (int) (position.getY()));
            p.addPoint((int) (position.getX()), (int) (position.getY() + size / 2 * Math.sqrt(3)));
            p.addPoint((int) (position.getX() + size), (int) (position.getY() + size / 2 * Math.sqrt(3)));
            shape = p;
        } else if (n.getShape().equals("diamond")) {
            Polygon p = new Polygon();
            p.addPoint((int) (position.getX() + size / 2), (int) (position.getY()));
            p.addPoint((int) (position.getX() + size), (int) (position.getY() + size / 2));
            p.addPoint((int) (position.getX() + size / 2), (int) (position.getY() + size));
            p.addPoint((int) (position.getX()), (int) (position.getY() + size / 2));
            shape = p;
        }
        else
            throw new InvalidDataValueException("Node type "+n.getShape()+" is not allowed. Must be disk, square, triangle or diamond.");
        return shape;
    }
}