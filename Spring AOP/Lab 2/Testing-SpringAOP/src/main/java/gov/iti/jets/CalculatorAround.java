package gov.iti.jets;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.util.Arrays;

@Aspect
public class CalculatorAround   {

    @Around("execution(* gov.iti.jets.impl.CalculatorImpl2.div(..))")
    public Object around (ProceedingJoinPoint proceedingJoinPoint) throws  Throwable {
        System.out.println("Around Before your service method name = "+proceedingJoinPoint.getSignature().getName()+" , "+"The arguments: "+Arrays.toString(proceedingJoinPoint.getArgs()));
        Object result =null;

        try {
            result = proceedingJoinPoint.proceed();
            System.out.println("Around After your service method name = "+proceedingJoinPoint.getSignature().getName()+" , "+"The arguments: "+Arrays.toString(proceedingJoinPoint.getArgs()));

        }catch (IllegalArgumentException ex){
            ex.printStackTrace();
            throw ex;
        }
        return result;

    }


}
