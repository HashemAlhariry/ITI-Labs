/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gov.iti.jets.beans;

/**
 *
 * @author hashemalhariry
 */

public class CreditCard {
    
    private float [] parts;
    public CreditCard(float p1,float p2,float p3,float p4){
        parts = new float[4];
        parts[0]=p1;
        parts[1]=p2;
        parts[2]=p3;
        parts[3]=p4;
    
    }
    public CreditCard(){
        
    }
    
    public float[] getParts(){
        return parts;
    }
    
    public void setParts(float[] parts){
        this.parts = parts;
    }
    
    
}
