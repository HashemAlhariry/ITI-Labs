/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.beans;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author hashemalhariry
 */
@FacesConverter("ccConverter")
public class CreditCardConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

       CreditCard c= null;
       String [] str =value.split("-");
       if(str.length==4){
           
           float []parts = new float[4];
           for(int i =0;i<4;i++){
               parts[i]=Float.parseFloat(str[i]);
           
           }
           c = new CreditCard(parts[0],parts[1],parts[2],parts[3]);  
       
       }else{
           
           FacesMessage message = new FacesMessage("Conversion error occurrred","Invalid card number.");
           
           message.setSeverity(FacesMessage.SEVERITY_ERROR);       
           throw new ConverterException(message);
       }
       
       return c;
    

    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        CreditCard c = (CreditCard) value;
        float [] parts= c.getParts();
        
        String s= parts[0]+"-"+parts[1]+"-"+parts[2]+"-"+parts[3];
        return s;
    }
    
}
