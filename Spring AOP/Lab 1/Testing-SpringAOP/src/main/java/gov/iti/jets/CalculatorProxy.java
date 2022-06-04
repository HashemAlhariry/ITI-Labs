package gov.iti.jets;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CalculatorProxy implements InvocationHandler {
    Calculator target;
    CalculatorAdvise advise;

    CalculatorProxy(Calculator target,CalculatorAdvise advise){
        this.target=target;
        this.advise=advise;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        double result=0.0;
        double firstOperand = (double) args[0];
        double secondOperand= (double) args[1];
        switch (method.getName()){
            case "add":
                try {
                    advise.before(firstOperand,"+",secondOperand);
                    result =target.add(firstOperand,secondOperand);
                    advise.after(result);
                }catch (Exception e){
                    advise.afterThrowing(e);
                }
                break;
            case "sub":
                try {
                    advise.before(firstOperand,"-",secondOperand);
                    result =target.sub(firstOperand,secondOperand);
                    advise.after(result);
                }catch (Exception e){
                    advise.afterThrowing(e);
                }
                break;
            case "multiply":
                try {
                    advise.before(firstOperand,"*",secondOperand);
                    result =target.multiply(firstOperand,secondOperand);
                    advise.after(result);
                }catch (Exception e){
                    advise.afterThrowing(e);
                }
                break;
            case "div":
                try {
                    advise.before(firstOperand,"/",secondOperand);
                    result =target.div(firstOperand,secondOperand);
                    advise.after(result);
                }catch (Exception e){
                    advise.afterThrowing(e);
                }
                break;
        }

        return result;
    }
}
