package gov.iti.jets.sax.demo1;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParsingSax {

    public void readingWithSax() throws Exception {
        // 1 
        MyCustomHandler myCustomHandler = new MyCustomHandler();
        File xmlFile = new File(getClass().getResource("/books.xml").toURI());
        // 2
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        // 3
        saxParser.parse(xmlFile, myCustomHandler);
    }

}
