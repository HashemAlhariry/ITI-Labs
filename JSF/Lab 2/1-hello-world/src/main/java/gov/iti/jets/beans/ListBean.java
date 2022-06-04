package gov.iti.jets.beans;

import jakarta.annotation.PostConstruct;
import jakarta.faces.bean.ApplicationScoped;
 
import jakarta.faces.bean.ManagedBean;
import jakarta.inject.Inject;
import java.io.Serializable;

 

/**
 *
 * @author hashemalhariry
 */

@ManagedBean(name = "listBean")
@ApplicationScoped
public class ListBean implements Serializable {
    
 
    Category[] categories = new Category[5];
    public ListBean(){
         
//            categories[0] = new Category("Apple", "Macbook air", 0);
//            categories[1] = new Category("Apple", "iphone 11", 0);
//            categories[2] = new Category("Apple", "Watch series 6", 0);
//            categories[3] = new Category("Apple", "Airpods pro", 0);
//            categories[4] = new Category("Apple", "Mac mini", 0);
    }
    
    @PostConstruct
    public void init(){

           categories[0] = new Category("Apple", "Macbook air", 0);
           categories[1] = new Category("Apple", "iphone 11", 0);
           categories[2] = new Category("Apple", "Watch series 6", 0);
           categories[3] = new Category("Apple", "Airpods pro", 0);
           categories[4] = new Category("Apple", "Mac mini", 0);

    }

    public void incrementCategory(String name){
        
        for (int i = 0; i < categories.length; i++) {
            if (categories[i].getCategoryValue().equals(name)) {
                 categories[i].setCategoryVotes(categories[i].getCategoryVotes()+1);
            }
        }
    }
        
    public void setCategories(Category[] lecture) {
        this.categories = categories;
    }

    public Category[] getCategories() {
        return categories;
    }
 
}
