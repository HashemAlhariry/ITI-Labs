package gov.iti.jets;

import gov.iti.jets.tree.JsonWriterDemo;
import gov.iti.jets.tree.JsonReaderDemo;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        JsonReaderDemo demo1 = new JsonReaderDemo();
        demo1.consumeJsonInStreamingFashion();

        JsonWriterDemo demo2 = new JsonWriterDemo();
        demo2.produceJsonInStreamingFashion();

    }

}
