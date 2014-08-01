gexf2jung
=========

gexf2jung is an api that allows importing of GEXF data into a JUNG graph object.


### To Use
1. Clone this repo
    * `https://github.com/ave4224/gexf2jung.git `
2. Write your own App
    * `import org.iqt.gexf2jung.GexfReader;`
    * `import org.iqt.gexf2jung.Node;`
    * `import org.iqt.gexf2jung.Edge;`
    * `import edu.uci.ics.jung.graph.Graph;`
3. Write a main that reads in a `Graph<Node, Edge>`
    * `Graph<Node, Edge> graph = GexfReader.read(String filename);`

### For Visualizations
1. Do all the steps above
    * * `import org.iqt.gexf2jung.transformers.*;`
2. Use a Layout
    * `Layout<Node, Edge> layout = new CircleLayout<Node, Edge>(graph);` (You can choose your own layout if you wish)
    * `layout.setSize(new Dimension(width, height));`
3. Use a Visualization Server
    * `BasicVisualizationServer<Node, Edge> vv = new BasicVisualizationServer<Node, Edge>(layout);`
    * `vv.setPreferredSize(new Dimension(width, height));`
4. Add the gexf2jung transformers to the Visualisation Server
    * `vv.getRenderContext().setVertexFillPaintTransformer(new GexfNodePaintTransformer());`
    * `vv.getRenderContext().setVertexShapeTransformer(new GexfNodeShapeTransformer());`
    * `vv.getRenderContext().setEdgeStrokeTransformer(new GexfEdgeStrokeTransformer());`
    * `vv.getRenderContext().setVertexLabelTransformer(new GexfNodeLabelTransformer());`
    * `vv.getRenderContext().setEdgeLabelTransformer(new GexfEdgeLabelTransformer());`
    * `vv.getRenderContext().setEdgeDrawPaintTransformer(new GexfEdgePaintTransformer());`
5. Set up the JFrame
    * `JFrame frame = new JFrame("Visualization");`
    * `frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);`
    * `frame.getContentPane().add(vv);`
    * `frame.pack();`
    * `frame.setVisible(true);`

#### Prerequisites:
* JDK 1.8 (or higher)
* Maven