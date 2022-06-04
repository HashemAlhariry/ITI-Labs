package gov.iti.jets.sax.demo1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class MyCustomHandler extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document Executed");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("-------------------------------------------");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("Start Element: " + qName);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters Start: " + start + ", Length: " + length + ", End: " + (start + length));
        System.out.println("Characters Contents: " + String.copyValueOf(ch, start, length));
    }


//    Error Handling

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("Oooops! some Warning");
        super.warning(e);
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("didn't see that one coming! some Error");
        super.error(e);
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("OMG! some Fatal Error");
        super.fatalError(e);
    }
}
