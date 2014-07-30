package org.iqt.gexf2jung;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Calendar;
import javax.xml.parsers.ParserConfigurationException;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

/**
 * Unit test for simple App.
 */
public class AppTest
{

//    /**
//     * Rigourous Test :-)
//     */
//    @Test
//    public void testApp() throws ParserConfigurationException, SAXException, IOException, InterruptedException
//    {
//        App.run("data/celegans.gexf"  , 640, 640,    0,   0);
//        App.run("data/viz.gexf"       , 640, 640,  640,   0);
//        App.run("data/yeast.gexf"     , 640, 640, 1280,   0);
//        App.run("data/attrsample.gexf", 640, 640, 1920,   0);
//        App.run("data/celegans.gexf"  , 640, 640,    0, 700);
//        App.run("data/viz.gexf"       , 640, 640,  640, 700);
//        App.run("data/yeast.gexf"     , 640, 640, 1280, 700);
//        App.run("data/attrsample.gexf", 640, 640, 1920, 700);
//        
//        //long time = Calendar.getInstance().getTimeInMillis()+20000;
//        //while(Calendar.getInstance().getTimeInMillis()<time);
//    }

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
    public void nodesTagMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/nodes_tag_missing.gexf");
    }
    
    @Test
    public void edgesTagMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/edges_tag_missing.gexf");
    }
    
    @Test
    public void attributeClassMissing() throws ParserConfigurationException, SAXException, IOException{
        App.run("testdata/attclass_missing.gexf");
    }
    
}
