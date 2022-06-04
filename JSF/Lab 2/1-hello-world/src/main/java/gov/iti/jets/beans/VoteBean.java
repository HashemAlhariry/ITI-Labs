 
package gov.iti.jets.beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.bean.ManagedBean;
import jakarta.faces.bean.ManagedProperty;
import java.io.Serializable;

 
@ManagedBean(name = "voteBean")
@SessionScoped
public class VoteBean implements Serializable{
 
    @ManagedProperty(value="#{listBean}")
    private ListBean listBean;
    private boolean voted;
    private String choosen;
   
    
    public String voteButtonBack(){
        System.out.print(choosen);
        if(choosen!=null){
            listBean.incrementCategory(choosen);
            setVoted(true);
            return "results";
        }
        return null;
    }
    
    public boolean getVoted(){
        return voted;   
    }
    
    public void setVoted(boolean voted){
        this.voted=voted;
    }
    
    public ListBean getListBean(){
        return listBean;   
    }
    
    public void setListBean(ListBean listBean){
        this.listBean=listBean;
    }
    
    public String getChoosen(){
       return choosen;   
    }
    
    public void setChoosen(String choosen){
        this.choosen=choosen;
    }
    
    public VoteBean(){
    }
    
    
}
