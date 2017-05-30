import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by micpi on 5/22/2017.
 */
public class DataReader {
    private int rowNum = 0;
    private NodeList nList;
    private XMLReader reader;

    public DataReader () throws Exception{
        reader = new XMLReader();
        refreshXML();
    }
    public String getNextRow () throws Exception {
       return (((Element) nList.item(rowNum++)).getAttribute("values"));

    }

    public boolean hasNextRow () {
        return (((Element) nList.item(rowNum)).getAttribute("values")) != null;
    }
    public int getRow () {
        return rowNum;
    }

    public void refreshXML () throws Exception {

        reader.ReadXMLFile();
        File fXmlFile = new File("floor.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(fXmlFile);
        doc.getDocumentElement().normalize();

        nList = doc.getElementsByTagName("Row");
    }
}
