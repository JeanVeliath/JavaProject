import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class DOMParser {
    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: "+doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("food");
            System.out.println("----------------------------------");
            for(int i=0;i<nList.getLength();i++){
                Node node = nList.item(i);
                System.out.println("\nCurrent Element :" + node.getNodeName());
                if(node.getNodeType()==Node.ELEMENT_NODE){
                    Element e =(Element) node;
                    System.out.println("Name: "+e.getElementsByTagName("name").item(0).getTextContent());
                    System.out.println("Price: "+e.getElementsByTagName("price").item(0).getTextContent());
                    System.out.println("Description: "+e.getElementsByTagName("description").item(0).getTextContent());
                    System.out.println("Calories: "+e.getElementsByTagName("calories").item(0).getTextContent());
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}