
package gov.iti.jets.beans;


import java.io.Serializable;

/**
 *
 * @author hashemalhariry
 */


public class Category implements Serializable{
    
    public String categoryLabel;
    public String categoryValue;
    public int categoryVotes;
    
    public Category(String lab,String val,int votes) {
    
          this.categoryLabel=lab;
          this.categoryValue=val;
          this.categoryVotes=votes;
    }
    
    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getCategoryLabel() {
        return categoryLabel;
    }
    
    
    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCategoryValue() {
        return categoryValue;
    }
    
    public void setCategoryVotes(int categoryVotes) {
        this.categoryVotes = categoryVotes;
    }

    public int getCategoryVotes() {
        return categoryVotes;
    }

}
