package gov.iti.jets;


import gov.iti.jets.impl.CalculatorImpl;

public class Main {
    
    public static void main(String[] args) {

        Calculator calculator = CalculatorFactory.getCalculator();
        calculator.add(3,3);
        System.out.println("");
        calculator.multiply(3 , 6);
        System.out.println("");
        calculator.sub(50,10);



    }

}
