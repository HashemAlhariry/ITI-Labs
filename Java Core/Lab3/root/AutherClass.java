package root;

@Author(str = "THIS IS CLASS", val = 1, dVal = 1.1)
public class AutherClass {
    
    @Author(str="Name",val = 2,dVal = 2.1)
    int autherName;

    @Author(str = "Constructor" , val = 0 , dVal = 0.0)
    AutherClass(){};

    @Author(str="Method",val = 3,dVal = 3.1)
    public int getAutherName(){
      System.out.println("HEY FROM METHOD");
      return autherName;
    }

}
