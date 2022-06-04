package gov.iti.jets.bean.collection;

import java.util.List;

public class ChildCollection {
    private List<Object> objectList;

    public List<Object> getObjectList() {
        return objectList;
    }

    public void setObjectList(List<Object> objectList) {
        this.objectList = objectList;
    }

    public ChildCollection(List<Object> objectList) {
        this.objectList = objectList;
    }

    public ChildCollection() {
    }

    @Override
    public String toString() {
        return "ChildCollection{" +
                "objectList=" + objectList +
                '}';
    }
}
