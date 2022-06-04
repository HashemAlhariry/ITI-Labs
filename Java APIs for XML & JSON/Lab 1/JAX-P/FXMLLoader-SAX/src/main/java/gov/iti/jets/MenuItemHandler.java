package gov.iti.jets;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


import org.xml.sax.helpers.DefaultHandler;

public class MenuItemHandler extends DefaultHandler {


    public List<Menu> menus = new ArrayList<>();
    private MenuItem menuItem;
    private Menu menu;
    private StringBuilder currentText;

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start Document Executed");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End Document Executed");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        System.out.println("Start Element: " + qName);
        switch (qName) {
            case "Menu":
                menu = new Menu();
                int attributeLength = attributes.getLength();
                String style="";
                String attrName="";
                    for (int i = 0; i < attributeLength; i++) {
                        if("text".equals(attributes.getQName(i))){
                           menu.setText(attributes.getValue(i));
                        }else{
                            attrName="-";
                            attrName += attributes.getQName(i);

                            String attrVal = attributes.getValue(i);
                            style+=attrName + ":" + attrVal + "; ";
                        }
                    }
                menu.setStyle(style);
                break;
            case "Item":
                currentText = new StringBuilder();
                menuItem=new MenuItem();
                break;
            default:
                break;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("End Element: " + qName);
        switch (qName) {
            case "Menu":
                menus.add(menu);
                break;
            case "Item":
                menuItem.setText(currentText.toString());
                menu.getItems().add(menuItem);
                break;
            default:
                currentText = new StringBuilder();
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("Characters Start: " + start + ", Length: " + length + ", End: " + (start + length));
        System.out.println("Characters Contents: " + String.copyValueOf(ch, start, length));
        if(currentText!=null){
            currentText.append(ch,start,length);
        }
    }


}
