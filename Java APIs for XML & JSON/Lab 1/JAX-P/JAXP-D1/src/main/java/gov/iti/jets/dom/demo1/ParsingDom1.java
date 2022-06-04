package gov.iti.jets.dom.demo1;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class ParsingDom1 {

    public void readingDomDemo() throws Exception {
        File xmlFile = new File(getClass().getResource("/notes.xml").toURI());
        Document document = createDocumentFromFile(xmlFile);
        printDocumentContents(document);
    }

    private Document createDocumentFromFile(File xmlFile) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        return builder.parse(xmlFile);
    }

    private void printDocumentContents(Document document) {
        System.out.println("> Traversing DOM Tree Recursively: ");
        Element rootElement = document.getDocumentElement();
        traverseDOMTreeRecursively(rootElement);
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
