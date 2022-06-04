package gov.iti.jets.behaviors;

import gov.iti.jets.behaviors.impl.MaxCalculatorImpl;
import gov.iti.jets.behaviors.impl.MinCalculatorImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class CalculatorAspect {

    @DeclareParents(defaultImpl = MaxCalculatorImpl.class, value = "gov.iti.jets.behaviors.impl.CalcImpl")
    public MaxCalculator maxCalculator;

    @DeclareParents(defaultImpl = MinCalculatorImpl.class, value = "gov.iti.jets.behaviors.impl.CalcImpl")
    public MinCalculator minCalculator;

}
