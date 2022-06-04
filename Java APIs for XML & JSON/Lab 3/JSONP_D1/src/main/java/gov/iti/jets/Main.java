package gov.iti.jets;

import gov.iti.jets.stream.JsonGeneratorDemo;
import gov.iti.jets.stream.JsonParserDemo;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
        JsonParserDemo demo1 = new JsonParserDemo();
        demo1.consumeJsonInStreamingFashion();

        JsonGeneratorDemo demo2 = new JsonGeneratorDemo();
        demo2.produceJsonInStreamingFashion();

    }

}
