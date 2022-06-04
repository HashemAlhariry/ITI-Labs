package gov.iti.jets.bean.annotation.autowire;

import org.springframework.beans.factory.annotation.Autowired;


public class ClassAutoWire1 {


    private ClassAutoWire2 classAutoWire2;

    @Autowired
    public ClassAutoWire1(ClassAutoWire2 classAutoWire2) {
        this.classAutoWire2 = classAutoWire2;
    }
    public ClassAutoWire1( ) {

    }
    public String getClassAutoWire2Message() {
        return classAutoWire2.getMessage();
    }

}
