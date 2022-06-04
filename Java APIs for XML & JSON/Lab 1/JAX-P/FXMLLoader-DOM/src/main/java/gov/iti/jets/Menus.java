package gov.iti.jets;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Menus {

    public List<Menu> menus = new ArrayList<>();
    private MenuItem menuItem;
    private Menu menu;
    private StringBuilder currentText;
    List<Node> nodes = new ArrayList<>();

    public void readingDomDemo() throws Exception {
        File xmlFile = new File(getClass().getResource("/MenuItems.xml").toURI());
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
        //System.out.println("\nNode: " + parentNode.getNodeName() + ", Type: " + nodeType + ", value: " + parentNode.getNodeValue());
        // Check for attributes and print them
        NamedNodeMap nodeMap = parentNode.getAttributes();
        if (nodeMap != null) {
            for (int i = 0; i < nodeMap.getLength(); i++) {
                Node node = nodeMap.item(i);
                // nodes.add(node);
                //System.out.println("    Attribute: " + node.getNodeName() + ", value: " + node.getNodeValue());
            }
        }
        // If the node contains child nodes : perform recursion for each node
        NodeList childNodes = parentNode.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node node = childNodes.item(i);
            if(node.getNodeName().equals("Menu")){
                nodes.add(node);
            }
            traverseDOMTreeRecursively(node);
            /*
            if(parentNode.getNodeName().equals("Menu") && i==childNodes.getLength()-1){
                nodes.add(node.getParentNode());
            }
            */
        }

    }

    public void printAllNodes(){

        for (Node node:nodes) {

                menu = new Menu();
                NamedNodeMap nodeMap = node.getAttributes();

                String style="";
                String attrName="";
                String attrVal ="";

                if (nodeMap != null) {
                    for (int i = 0; i < nodeMap.getLength(); i++) {
                        Node tempNode = nodeMap.item(i);
                        if ("text".equals(tempNode.getNodeName())) {
                            menu.setText(tempNode.getNodeValue());
                        } else {
                            //System.out.println("Attribute: " + tempNode.getNodeName() + ", value: " + tempNode.getNodeValue());
                            attrName = "-";
                            attrName += tempNode.getNodeName();
                            attrVal = tempNode.getNodeValue();
                            style += attrName + ":" + attrVal + "; ";
                        }
                    }
                    menu.setStyle(style);
                }

                NodeList tempNode = node.getChildNodes();

            for (int i = 0; i <tempNode.getLength() ; i++) {
                if(tempNode.item(i).getNodeName().equals("Item")) {
                    MenuItem menuItem = new MenuItem();
                    menuItem.setText(tempNode.item(i).getChildNodes().item(0).getNodeValue());
                    menu.getItems().add(menuItem);
                }
            }
            menus.add(menu);
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
