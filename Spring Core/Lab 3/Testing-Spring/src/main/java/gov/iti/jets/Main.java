package gov.iti.jets;


import gov.iti.jets.bean.annotation.autowire.ClassAutoWire1;
import gov.iti.jets.bean.annotation.required.SimpleMovieLister;
import gov.iti.jets.bean.annotation.xml_inject.ClassA;
import gov.iti.jets.bean.collection.ChildCollection;
import gov.iti.jets.bean.inheritance.Child;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {
    
    public static void main(String[] args) {

        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        context.registerShutdownHook();

        /*** Bean definition inheritance ***/
        Child child = (Child) context.getBean("child") ;
        System.out.println("/*** Bean definition inheritance ***/");
        System.out.println("Child Bean  ... "+ child);
        System.out.println("---------------");

        /*** Bean definition inheritance with Collections ***/
        ChildCollection childCollection = (ChildCollection) context.getBean("child2") ;
        System.out.println("/*** Bean definition inheritance with Collections ***/");
        System.out.println("childCollection Bean  ... "+ childCollection);
        System.out.println("---------------");

        /*** difference between xml injection and @inject .... @inject injects before xml ***/
        ClassA classA = (ClassA)  context.getBean("classA");
        System.out.println("/*** difference between xml injection and @inject .... @inject injects before xml ***/");
        System.out.println( classA.getClassBString());
        System.out.println("---------------");


        /*** Required annotation***/
        SimpleMovieLister simpleMovieLister = (SimpleMovieLister) context.getBean("simpleMovieLister");
        System.out.println("/*** Required annotation***/");
        System.out.println( "SimpleMovieLister class required MovieFinder name ..." + simpleMovieLister.getMovieFinderName());
        System.out.println("---------------");


        /*** Autowired annotation ***/
        ClassAutoWire1 classAutoWire1 = (ClassAutoWire1) context.getBean("classAutowire1");
        System.out.println("/*** Autowired annotation ***/");
        System.out.println( "ClassAutoWire1 getting message from ClassAutoWire2 ..." + classAutoWire1.getClassAutoWire2Message());
        System.out.println("---------------");





        context.close();
    }



}
