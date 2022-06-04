package gov.iti.jets;

import gov.iti.jets.behaviors.Calc;
import gov.iti.jets.behaviors.MaxCalculator;
import gov.iti.jets.behaviors.MinCalculator;
import gov.iti.jets.behaviors.impl.CalcImpl;
import gov.iti.jets.strings.Parent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        Calculator calculator = (Calculator) context.getBean("calculatorImpl");
        Calculator calculator2= (Calculator) context.getBean("calculatorImpl2");

        System.out.println(calculator.div(3,4));
        System.out.println("");
        System.out.println(calculator.div(1,1));
        System.out.println("");

        /***  ----------------------------  ***/

        System.out.println("");
        System.out.println(calculator2.div(1,3));
        System.out.println("");
        System.out.println(calculator2.div(3,1));

        /***  ----------------------------  ***/


        Calc calculator3 =  context.getBean("calculatorImpl3", Calc.class);
        MaxCalculator maxCalculator =(MaxCalculator) calculator3;
        System.out.println(maxCalculator.max(12,4));
        MinCalculator minCalculator =(MinCalculator) calculator3;
        System.out.println(minCalculator.min(12,4));





    }

}
