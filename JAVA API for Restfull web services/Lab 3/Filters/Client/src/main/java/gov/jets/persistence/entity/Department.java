package gov.jets.persistence.entity;

 
public class Department {

        private String depName;
        private int id;

        public Department(){

        }
        public Department(String depName, int id){
            this.depName=depName;
            this.id=id;
        }
        public void setId(int id){
            this.id=id;
        }
        public int getId(){
            return id;
        }

        public void setFirstName(String depName){
            this.depName=depName;
        }
    
        public String getFirstName(){
            return depName;
        }
            
}
