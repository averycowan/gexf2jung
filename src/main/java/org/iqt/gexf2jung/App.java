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

package org.iqt.gexf2jung;


import edu.uci.ics.jung.algorithms.layout.*;
import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.visualization.BasicVisualizationServer;
import edu.uci.ics.jung.visualization.renderers.Renderer.VertexLabel.Position;
import java.awt.Dimension;
import java.io.IOException;
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
    /**
     * This method calls the <code>run(String filename)</code> method on "data/celegans.gexf", a sample file.
     * @see run(java.lang.String)
     */
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException{
        run("data/viz.gexf");
    }
    /**
     * Easy access method for <code>run(String filename, int width, int height, int x, int y)</code>. Puts the window at 0,0 with size 2560,1300.
     * @param filename Passes this on
     * 
     */
    public static void run(String filename) throws ParserConfigurationException, SAXException, IOException{
        run(filename, 2560, 1300, 0, 0);
    }
    /**
     * This method runs the necessary calls to generate a JUNG visualizer with a GEXF file.
     * Uses a graph from <code>GexfReader(String filename)</code> and Transformers from <code>org.iqt.gexf2jung.transformers</code> to make a <code>BasicVisualizationServer</code>.
     * @param filename This must be acceptable by the constructor <code>File(filename)</code>
     * @param width The width of the window
     * @param height The height of the window
     * @param x the X coordinate of the window's position
     * @param y the Y coordinate of the window's position
     * @throws ParserConfigurationException see <code>GexfReader.read(String filename)</code>
     * @throws SAXException see <code>GexfReader.read(String filename)</code>
     * @throws IOException Called if the filename is not valid.
     * @see GexfReader
     */
    public static void run(String filename, int width, int height, int x, int y) throws ParserConfigurationException, SAXException, IOException{
        Graph<Node, Edge> g = GexfReader.read(filename);
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
