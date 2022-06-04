package gov.iti.jets.trax.demo1;

import java.io.File;
import java.time.LocalDate;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class SaveDOMWithTrAX {

    public void savingDomWithTrax() throws Exception {
        Document document = createEmptyDocument();
        populateDocumentWithData(document);
        saveDomAsXmlFile(document);
    }

    private Document createEmptyDocument() throws ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = factory.newDocumentBuilder();

        return builder.newDocument();
    }

    private void populateDocumentWithData(Document document) {

        Element messages = document.createElement("messages");

        Element message1 = createMessage(document, "amin", "mazen", "XML is Awesome dude", "en");
        messages.appendChild(message1);

        Element message2 = createMessage(document, "amin", "mohsen", "I really adore XML APIs", "en");
        messages.appendChild(message2);

        document.appendChild(messages);
    }

    private Element createMessage(Document document, String from, String to, String body, String lang) {

        Element messageElement = document.createElement("message");
        messageElement.setAttribute("date", LocalDate.now().toString());

        Element fromElement = document.createElement("from");
        fromElement.setTextContent(from);
        messageElement.appendChild(fromElement);

        Element toElement = document.createElement("to");
        toElement.setTextContent(to);
        messageElement.appendChild(toElement);

        Element bodyElement = document.createElement("body");
        bodyElement.setAttribute("lang", lang);
        bodyElement.setTextContent(body);
        messageElement.appendChild(bodyElement);

        return messageElement;

        // Alternative to: setting attribute

        // Attr dateAttr = document.createAttribute("date");
        // dateAttr.setValue(LocalDate.now().toString());
        // messageElement.setAttributeNode(dateAttr);

    }

    private void saveDomAsXmlFile(Document document) throws TransformerException {
        // Source
        DOMSource domSource = new DOMSource(document);
        // Result
        File outputXmlFile = new File("messages.xml");
        StreamResult streamResult = new StreamResult(outputXmlFile);
        // Simple pass through transformer (i.e without transformation instructions)
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(domSource, streamResult);
    }

}

/*
 * the XML-Structure we want to build from scratch using DOM API
 * 
 * 
 * <messages>
 * 
 * <message date="2020-08-14">
 * <from>amin</from>
 * <to>mazen</to>
 * <body lang="en">XML is Awesome dude</body>
 * </message>
 * 
 * <message date="2020-08-14">
 * <from>amin</from>
 * <to>mohsen</to>
 * <body lang="en">I really adore XML APIs</body>
 * </message>
 * 
 * </messages>
 * 
 * 
 */
