package gov.iti.jets;

import gov.iti.jets.sax.demo1.ParsingSax;
import gov.iti.jets.sax.demo2.RetrieveStudents;

public class Main {
    
    public static void main(String[] args) throws Exception {
        
//         ParsingSax demo1 = new ParsingSax();
//         demo1.readingWithSax();
//         System.out.println('\u0000');
//
        RetrieveStudents demo2 = new RetrieveStudents();
        demo2.readingWithSax();

    }

}
