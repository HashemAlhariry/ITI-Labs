package gov.iti.jets;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import java.util.Arrays;

@Aspect
public class CalculatorBefore   {

    @Before("execution(* gov.iti.jets.impl.CalculatorImpl.div(..))")
    public void calculatorBeforeMethod(JoinPoint joinPoint){
        System.out.println("Before your service method name = "+joinPoint.getSignature().getName()+" , "+"The arguments: "+Arrays.toString(joinPoint.getArgs()));
    }


}
