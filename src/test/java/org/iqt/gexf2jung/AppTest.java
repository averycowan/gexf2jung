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


package org.iqt.gexf2jung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import javax.xml.parsers.ParserConfigurationException;
import org.iqt.gexf2jung.exception.*;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * JUnit test for app gexf2jung.
 */
public class AppTest
{

    @Test(expected= FileNotFoundException.class)
    public void badFileName() throws ParserConfigurationException, SAXException, IOException{
        App.run("");
    }
    
    @Test(expected= SAXParseException.class)
    public void emptyFile() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/empty.gexf");
    }
    
    @Test
    public void noUTFEncoding() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/no_encoding.gexf");
    }
    
    @Test
    public void noGraphTag() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/no_graph.gexf");
    }
    
    @Test
    public void noDefaultEdgeType() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/no_def_edge_type.gexf");
    }
    
    @Test
    public void badDefaultEdgeType() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/bad_def_edge_type.gexf");
    }
    
    @Test
    public void nodesTagMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/nodes_tag_missing.gexf");
    }
    
    @Test
    public void edgesTagMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/edges_tag_missing.gexf");
    }
    
    @Test(expected= MissingDataValueException.class)
    public void attributeClassMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/attclass_missing.gexf");
    }
    
    @Test(expected= MissingDataValueException.class)
    public void badAttributeFor() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/bad_att_for.gexf");
    }
    
    @Test(expected= InvalidDataValueException.class)
    public void NegativeEdgeWeight() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/negative_edge_weight.gexf");
    }
}
