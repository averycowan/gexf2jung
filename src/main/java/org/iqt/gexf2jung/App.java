package org.iqt.gexf2jung;


import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.iqt.gexf2jung.transformers.*;
import org.xml.sax.SAXException;

/**
 * Uses a GefxReader to load a GEFX file into a JUNG graph then display it.
 *
 * @author Avery Cowan
 */
public class App {
    private static int count = 0;
    //private final Transformer DEFAULT_SHAPE = new BasicVisualizationServer(new CircleLayout(new SparseMultigraph())).getRenderContext().getVertexShapeTransformer();
    public static final Shape defaultShape(){
        return new Ellipse2D.Float(-10, -10, 20, 20);//((float)-10.0, (float)-10.0, (float)20.0, (float)20.0);
    }
    public static final float defaultSize = 20;
    public static void main(String[] args) throws Exception {
        run("data/celegans.gexf");
    }
    public static void run(String filename) throws ParserConfigurationException, SAXException, IOException{
        run(filename, 2560, 1300, 0, 0);
    }
    public static void run(String filename, int width, int height, int x, int y) throws ParserConfigurationException, SAXException, IOException{
        Graph<Node, Edge> g = GexfReader.read(filename);
        //SimpleGraphView sgv = new SimpleGraphView(); //We create our graph in here
        // The Layout<V, E> is parameterized by the vertex and edge types
        Layout<Node, Edge> layout = new FRLayout2<Node, Edge>(g);
        layout.setSize(new Dimension(width, height)); // sets the initial size of the space
        // The BasicVisualizationServer<V,E> is parameterized by the edge types
        BasicVisualizationServer<Node, Edge> vv
                = new BasicVisualizationServer<Node, Edge>(layout);
        vv.setPreferredSize(new Dimension(width, height)); //Sets the viewing area size
        vv.getRenderContext().setVertexFillPaintTransformer(new GexfNodePaintTransformer());
        vv.getRenderContext().setVertexShapeTransformer(new GexfNodeShapeTransformer());
        vv.getRenderContext().setEdgeStrokeTransformer(new GexfEdgeStrokeTransformer());
        vv.getRenderContext().setVertexLabelTransformer(new GexfNodeLabelTransformer());
        vv.getRenderContext().setEdgeLabelTransformer(new GexfEdgeLabelTransformer());
        vv.getRenderer().getVertexLabelRenderer().setPosition(Position.AUTO);

        JFrame frame = new JFrame("Graph View");
        frame.setLocation(x, y);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(vv);
        frame.pack();
        frame.setVisible(true);
    }
}
