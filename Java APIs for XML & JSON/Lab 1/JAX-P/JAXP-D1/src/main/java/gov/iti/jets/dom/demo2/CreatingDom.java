package gov.iti.jets.dom.demo2;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.time.LocalDate;

public class CreatingDom {

    public void writingDomDemo() throws Exception {
        Document document = createEmptyDocument();
        populateDocumentWithData(document);
        printDocumentContents(document);
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

        Attr dateAttr = document.createAttribute("date");
        dateAttr.setValue(LocalDate.now().toString());
        messageElement.setAttributeNode(dateAttr);

        return messageElement;

        // Alternative to: setting attribute

    }

    private void printDocumentContents(Document document) {
        System.out.println("> Traversing DOM Tree Recursively: ");
        traverseDOMTreeRecursively(document.getDocumentElement());
    }

    private void traverseDOMTreeRecursively(Node parentNode) {

        // Print Node's Name & Value
        String nodeType = getNodeType(parentNode.getNodeType());
        System.out.println("\nNode: " + parentNode.getNodeName() + ", Type: " + nodeType + ", value: " + parentNode.getNodeValue());

        // Check for attributes and print them
        NamedNodeMap nodeMap = parentNode.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                Node node = nodeMap.item(i);
                System.out.println("    Attribute: " + node.getNodeName() + ", value: " + node.getNodeValue());
            }
        }

        // If the node contains child nodes : perform recursion for each node
        NodeList childNodes = parentNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            traverseDOMTreeRecursively(node);
        }

    }

    private String getNodeType(short nodeType) {
        switch (nodeType) {
            case Node.ELEMENT_NODE:
                return "ELEMENT";
            case Node.ATTRIBUTE_NODE:
                return "ATTRIBUTE";
            case Node.TEXT_NODE:
                return "TEXT";
            case Node.CDATA_SECTION_NODE:
                return "CDATA_SECTION";
            case Node.ENTITY_REFERENCE_NODE:
                return "ENTITY_REFERENCE";
            case Node.ENTITY_NODE:
                return "ENTITY";
            case Node.PROCESSING_INSTRUCTION_NODE:
                return "PROCESSING_INSTRUCTION";
            case Node.COMMENT_NODE:
                return "COMMENT";
            case Node.DOCUMENT_NODE:
                return "DOCUMENT";
            case Node.DOCUMENT_TYPE_NODE:
                return "DOCUMENT_TYPE";
            case Node.DOCUMENT_FRAGMENT_NODE:
                return "DOCUMENT_FRAGMENT";
            default:
                return "UNKNOWN";
        }
    }

}

/*
 * the XML-Structure we want to build from scratch using DOM API
 * 
 * 
 * <messages>
 * 
 *      <message date="2020-01-01">
 *          <from> amin </from>
 *          <to> mazen </to>
 *          <body lang="en"> XML is Awesome dude </body>
 *      </message>
 *      
 *      <message>
 *          <from> amin </from>
 *          <to> mohsen </to>
 *          <body> I really adore XML APIs </body>
 *      </message>
 * 
 * </messages>
 * 
 * 
 */
