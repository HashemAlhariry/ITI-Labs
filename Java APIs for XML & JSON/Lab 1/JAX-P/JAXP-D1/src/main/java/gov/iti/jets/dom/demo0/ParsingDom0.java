package gov.iti.jets.dom.demo0;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ParsingDom0 {

    private Queue<Node> queue = new LinkedList<>();

    // for future use
    public List<Node> elementList = new ArrayList<>();

    public void readingDomDemo() throws Exception {
        File xmlFile = new File(getClass().getResource("/notes.xml").toURI());
        Document document = createDocumentFromFile(xmlFile);
        printDocumentContents(document);
    }

    private Document createDocumentFromFile(File xml) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder parser = factory.newDocumentBuilder();
        Document document =parser.parse(xml);
        return  document;
    }

    private void printDocumentContents(Document document) {
        System.out.println("> Traversing DOM Tree Breadth first: ");
        Element rootElement = document.getDocumentElement();
        BreadthFirst(rootElement);

    }

    private void BreadthFirst(Node node){

        if(node.getChildNodes()!=null){
            for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                queue.add(node.getChildNodes().item(i));
            }
            elementList.add(queue.peek());
            if(queue.size()!=0){
                BreadthFirst(queue.remove());}
        }

    }

    public void printingNodes(){

        for (Node element: elementList) {
            if (element != null) {
                String nodeType = getNodeType(element.getNodeType());
                System.out.println("\nNode: " + element.getNodeName() + ", Type: " + nodeType + ", value: "+ element.getNodeValue());

                NamedNodeMap nodeMap =  element.getAttributes();
                if (nodeMap != null) {
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node node = nodeMap.item(i);
                        System.out.println("    Attribute: " + node.getNodeName() + ", value: " + node.getNodeValue());
                    }
              }
            }

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
