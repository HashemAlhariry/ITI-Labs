package gov.iti.jets.behaviors.impl;

import gov.iti.jets.behaviors.MinCalculator;

public class MinCalculatorImpl implements MinCalculator {
    @Override
    public double min(double firstOperand, double secondOperand) {
        return (firstOperand <=secondOperand) ? firstOperand:secondOperand;
    }
}
