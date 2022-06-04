package gov.iti.jets.xpath;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class SelectWithXpath {
    
    public void selectingWithXPath() throws Exception {

        File xmlFile = new File(getClass().getResource("/cd-catalog.xml").toURI());

        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document xmlDocument = documentBuilder.parse(xmlFile);

        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        // Select all the CD's titles with price more than 10$
        XPathExpression expression = xpath.compile("/catalog/cd[price>10]/title");
        NodeList nodeList = (NodeList) expression.evaluate(xmlDocument, XPathConstants.NODESET);

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            traverseDOMTreeRecursively(item);
        }
    }

    private void traverseDOMTreeRecursively(Node parentNode) {

        // Print Node's Name & Value
        String nodeType = getNodeType(parentNode.getNodeType());
        System.out.println("\nNode: " + parentNode.getNodeName() + ", Type: " + nodeType + ", value: "
                + parentNode.getNodeValue());

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
