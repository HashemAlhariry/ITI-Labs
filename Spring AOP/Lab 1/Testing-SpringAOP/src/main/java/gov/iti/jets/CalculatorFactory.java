package gov.iti.jets;

import gov.iti.jets.impl.CalculatorImpl;

import java.lang.reflect.Proxy;

public class CalculatorFactory {
    public static CalculatorFactory calculatorFactory = new CalculatorFactory();
    private final Calculator target;
    private final Calculator targetWithAdvice;

    private CalculatorFactory(){
        target = new CalculatorImpl();
        CalculatorAdvise advise = new CalculatorAdvise();
        CalculatorProxy calculatorProxy = new CalculatorProxy(target,advise);
        Class [] interfaces = new Class[]{Calculator.class};
        targetWithAdvice=(Calculator) Proxy.newProxyInstance(new ClassLoader() {},interfaces,calculatorProxy);
    }
    public static Calculator getCalculator(){
        return calculatorFactory.targetWithAdvice;
    }

}
