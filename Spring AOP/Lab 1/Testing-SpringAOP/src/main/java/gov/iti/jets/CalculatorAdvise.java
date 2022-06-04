package gov.iti.jets;

public class CalculatorAdvise {
    public void before(double firstOperand,String operator ,double secondOperand){
        System.out.println(firstOperand+ " " + operator + " " +secondOperand);
    }

    public void after(double result){
        System.out.println("return is: " + result);
    }

    public void afterThrowing(Exception exception){
        System.err.println(exception.getMessage());
    }

}
