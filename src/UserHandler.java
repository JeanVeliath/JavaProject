import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;

public class UserHandler extends DefaultHandler {
    boolean name = false;
    boolean price = false;
    boolean description = false;
    boolean calories = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equalsIgnoreCase("food")){
            String label = attributes.getValue("label");
            System.out.println("label: "+label);
        }
        else if(qName.equalsIgnoreCase("name")){
            name=true;
        }
        else if(qName.equalsIgnoreCase("price")){
            price=true;
        }
        else if(qName.equalsIgnoreCase("description")){
            description=true;
        }
        else if(qName.equalsIgnoreCase("calories")){
            calories=true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(qName.equalsIgnoreCase("food")){
            System.out.println("End Element: "+qName);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(name){
            System.out.println("name: "+ new String(ch,start,length));
            name = false;
        }
        else if(price){
            System.out.println("price: "+ new String(ch,start,length));
            price = false;
        }
        else if(description){
            System.out.println("description: "+ new String(ch,start,length));
            description = false;
        }
        else if(calories){
            System.out.println("calories: "+ new String(ch,start,length));
            calories = false;
        }
    }

    public static void main(String[] args) {
        try {
            File inputFile = new File("input.txt");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxp = factory.newSAXParser();
            UserHandler uh = new UserHandler();
            saxp.parse(inputFile,uh);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}