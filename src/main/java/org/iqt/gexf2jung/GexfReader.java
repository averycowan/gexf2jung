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

import edu.uci.ics.jung.graph.Graph;
import edu.uci.ics.jung.graph.SparseMultigraph;
import edu.uci.ics.jung.graph.util.EdgeType;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.geometry.Point3D;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.iqt.gexf2jung.exception.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Uses SAX to parse a GEXF file
 *
 * @author Avery Cowan
 */
public class GexfReader extends DefaultHandler {

    private EdgeType et = EdgeType.UNDIRECTED;
    private ArrayList<String> lines = new ArrayList<String>();
    private Graph<Node, Edge> g = new SparseMultigraph<Node, Edge>();
    private Node cnode = null;
    private Edge cedge = null;
    private HashMap<String, Node> nodes = new HashMap<String, Node>();
    private HashMap<String, AttDef> attdefsn = new HashMap<String, AttDef>();
    private HashMap<String, AttDef> attdefse = new HashMap<String, AttDef>();
    private AttClass attclass;

    /**
     * Uses SAX to parse a GEXF file
     *
     * @param filename Must be readable by convertToFileURL(String)
     * @throws ParserConfigurationException
     * @throws SAXException
     * @throws IOException
     * @return A filled JUNG SparseMultigraph from filename
     */
    public static Graph<Node, Edge> read(String filename) throws ParserConfigurationException, SAXException, IOException {
        if (!new File(filename).exists()) {
            throw new FileNotFoundException(filename + " does not exist");
        }
        //Do not touch the next 8 lines!
        SAXParserFactory spf = SAXParserFactory.newInstance();
        spf.setNamespaceAware(true);
        SAXParser saxParser = spf.newSAXParser();
        XMLReader xmlReader = saxParser.getXMLReader();
        GexfReader reader = new GexfReader();
        xmlReader.setContentHandler(reader);
        xmlReader.parse(convertToFileURL(filename));
        return reader.getGraph();
    }

    /**
     * Accessor method to retrieve the JUNG graph once
     * <code>read(String filename)</code> has been called.
     *
     * @return
     */
    private Graph<Node, Edge> getGraph() {
        return g;
    }

    @Override
    public void startElement(String namespaceURI,
            String localName,
            String qName,
            Attributes atts)
            throws SAXException {
        if (qName.equals("graph")) {
            if (atts.getValue("defaultedgetype") != null) {
                et = Edge.edgeType(atts.getValue("defaultedgetype").toUpperCase());
            }
        } else if (qName.equals("attributes")) {
            if (atts.getValue("class") == null) {
                throw new MissingDataValueException("<attributes> tag is missing a \"class=\" value.");
            } else if (atts.getValue("class").equals("node")) {
                attclass = AttClass.Node;
            } else if (atts.getValue("class").equals("edge")) {
                attclass = AttClass.Edge;
            } else {
                throw new InvalidDataValueException("<attributes> value for \"class=\" is " + atts.getValue("class") + ". Must be \"DIRECTED\" or \"UNDIRECTED\"");
            }
        } else if (qName.equals("attribute")) {
            if (attclass == null) {
                throw new NoAttributeClassException("Attribute Class has not been defined.");
            }
            if (atts.getValue("id") == null) {
                throw new MissingDataValueException("<attribute> tag is missing a \"id\" value");
            }
            if (attclass == AttClass.Node) {
                AttDef a = new AttDef(atts.getValue("id"), atts.getValue("title"), atts.getValue("type"));
                attdefsn.put(atts.getValue("id"), a);
            } else if (attclass == AttClass.Edge) {
                AttDef a = new AttDef(atts.getValue("id"), atts.getValue("title"), atts.getValue("type"));
                attdefse.put(atts.getValue("id"), a);
            }
        } else if (qName.equals("attvalue")) {
            if (attclass == null) {
                throw new NoAttributeClassException("Attribute Class has not been defined.");
            }
            if (atts.getValue("for") == null) {
                throw new MissingDataValueException("<attvalue> tag is missing a \"for\" value");
            }
            if (attclass == AttClass.Node) {
                Attribute a = new Attribute(atts.getValue("for"), atts.getValue("value"), attdefsn.get(atts.getValue("for")).title);
                cnode.getAttValues().put(atts.getValue("for"), a);
            } else if (attclass == AttClass.Edge) {
                Attribute a = new Attribute(atts.getValue("for"), atts.getValue("value"), attdefse.get(atts.getValue("for")).title);
                cedge.getAttValues().put(atts.getValue("for"), a);
            }
        } else if (qName.startsWith("viz:")) {
            if (attclass == AttClass.Node) {
                if (localName.equals("color")) {
                    int r = 0, g = 0, b = 0, a = 0;
                    if (atts.getValue("r") == null) {
                        throw new MissingDataValueException("The \"r\" value in viz:color is missing");
                    }
                    if (atts.getValue("g") == null) {
                        throw new MissingDataValueException("The \"g\" value in viz:color is missing");
                    }
                    if (atts.getValue("b") == null) {
                        throw new MissingDataValueException("The \"b\" value in viz:color is missing");
                    }
                    try {
                        r = Integer.parseInt(atts.getValue("r"));
                    } catch (NumberFormatException e) {
                        throw new InvalidDataValueException("The \"r\" value in viz:color is not an integer");
                    }
                    try {
                        g = Integer.parseInt(atts.getValue("g"));
                    } catch (NumberFormatException e) {
                        throw new InvalidDataValueException("The \"g\" value in viz:color is not an integer");
                    }
                    try {
                        b = Integer.parseInt(atts.getValue("b"));
                    } catch (NumberFormatException e) {
                        throw new InvalidDataValueException("The \"b\" value in viz:color is not an integer");
                    }
                    if (atts.getValue("a") == null) {
                        cnode.setColor(new Color(r, g, b));
                    } else {
                        try {
                            a = (int) (Float.parseFloat(atts.getValue("a")) * 255);
                            cnode.setColor(new Color(r, g, b, a));
                        } catch (NumberFormatException e) {
                            throw new InvalidDataValueException("The \"a\" value in viz:color is not a float");
                        }
                    }
                } else if (localName.equals("position")) {
                    cnode.setPosition(new Point3D(Double.parseDouble(atts.getValue("x")), Double.parseDouble(atts.getValue("y")), Double.parseDouble(atts.getValue("z"))));
                } else if (localName.equals("size")) {
                    cnode.setSize(Float.parseFloat(atts.getValue("value")));
                } else if (localName.equals("shape")) {
                    cnode.setShape(atts.getValue("value"));
                }
            } else if (attclass == AttClass.Edge) {

            }
        } else if (qName.equals("node")) {
            attclass = AttClass.Node;
            Node n = new Node(atts.getValue("id"));
            n.setLabel(atts.getValue("label"));
            g.addVertex(n);
            nodes.put(atts.getValue("id"), n);
            cnode = n;
        } else if (qName.equals("edge")) {
            attclass = AttClass.Edge;
            Edge e = new Edge(atts.getValue("id"));
            if (atts.getValue("weight") != null) {
                if (Float.parseFloat(atts.getValue("weight")) < 0) {
                    throw new InvalidDataValueException("Edge weight must be >= 0.Value was " + atts.getValue("weight") + ".");
                }
                e.setWeight(Float.parseFloat(atts.getValue("weight")));
            }
            g.addEdge(e, nodes.get(atts.getValue("source")), nodes.get(atts.getValue("target")), et);
            cedge = e;
        }
    }

    private static String convertToFileURL(String filename) {
        String path = new File(filename).getAbsolutePath();
        if (File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")) {
            path = "/" + path;
        }
        return "file:" + path;
    }
}

/**
 * A basic enum to store whether an attribute is for a node or an edge.
 *
 * @author Avery Cowan
 */
enum AttClass {

    Node, Edge
}
