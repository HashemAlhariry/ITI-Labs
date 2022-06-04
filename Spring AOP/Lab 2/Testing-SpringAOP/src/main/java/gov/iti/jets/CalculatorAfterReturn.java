package gov.iti.jets;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class CalculatorAfterReturn {

    @AfterReturning( pointcut ="execution(* gov.iti.jets.impl.CalculatorImpl.div(..))")
    public void calculatorAfterMethod(JoinPoint joinPoint){
        System.out.println("After Returning your service method name = "
                +joinPoint.getSignature().getName()+
                " , "+"The arguments: "+
                Arrays.toString(joinPoint.getArgs())
        );
    }
}
