/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iqt.gexf2jung.transformers;

import java.awt.Polygon;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javafx.geometry.Point3D;
import org.apache.commons.collections15.Transformer;
import static org.iqt.gexf2jung.App.defaultShape;
import static org.iqt.gexf2jung.App.defaultSize;
import org.iqt.gexf2jung.Node;

/**
 *
 * @author Avery Cowan
 */
public class GexfNodeShapeTransformer implements Transformer<Node, Shape> {

    public Shape transform(Node n) {
        Shape shape = defaultShape();
        float size = n.getSize() * defaultSize;
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
        return shape;
    }
}