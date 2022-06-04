package gov.iti.jets.bean.annotation.xml_inject;

import javax.inject.Inject;

public class ClassA {
    private ClassB classB;

    @Inject
    public ClassA(ClassB classB) {
        this.classB = classB;
    }

    public String getClassBString() {
        return classB.getMess();
    }


}
