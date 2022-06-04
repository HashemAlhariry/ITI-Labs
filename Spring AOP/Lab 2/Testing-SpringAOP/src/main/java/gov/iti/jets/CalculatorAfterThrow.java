package gov.iti.jets;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.aop.ThrowsAdvice;

import java.util.Arrays;

@Aspect
public class CalculatorAfterThrow  {

    @AfterThrowing( pointcut ="execution(* gov.iti.jets.impl.CalculatorImpl.div(..))")
    public void calculatorAfterMethod(JoinPoint joinPoint){
        System.out.println("After Throwing your service method name = "
                +joinPoint.getSignature().getName()+
                " , "+"The arguments: "+
                Arrays.toString(joinPoint.getArgs())
        );

        System.out.println("Exception happened ...... ");
    }


}
