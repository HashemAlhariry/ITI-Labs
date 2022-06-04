package gov.iti.jets.behaviors.impl;

import gov.iti.jets.behaviors.Calc;

public class CalcImpl implements Calc {

    @Override
    public double add(double firstOperand, double secondOperand) {
        return firstOperand+secondOperand;
    }
    @Override
    public double sub(double firstOperand, double secondOperand) {
        return firstOperand-secondOperand;
    }

    @Override
    public double multiply(double firstOperand, double secondOperand) {
        return firstOperand*secondOperand;
    }

    @Override
    public double div(double firstOperand, double secondOperand) {
        if(secondOperand == 0)
            throw  new IllegalArgumentException();
        return firstOperand/secondOperand;
    }
}
