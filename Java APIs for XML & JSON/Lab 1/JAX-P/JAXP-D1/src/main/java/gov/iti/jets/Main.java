package gov.iti.jets;

import gov.iti.jets.dom.demo0.ParsingDom0;
import gov.iti.jets.dom.demo1.ParsingDom1;
import gov.iti.jets.dom.demo2.CreatingDom;

public class Main {
    
    public static void main(String[] args) throws Exception {

//        ParsingDom0 demo = new ParsingDom0();
//        demo.readingDomDemo();
//        demo.printingNodes();

//      ParsingDom1 demo1 = new ParsingDom1();
//      demo1.readingDomDemo();
//
      CreatingDom demo2 = new CreatingDom();
      demo2.writingDomDemo();

    }

}
