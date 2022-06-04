package gov.iti.jets.behaviors.impl;

import gov.iti.jets.behaviors.MaxCalculator;

public class MaxCalculatorImpl implements MaxCalculator{
    @Override
    public double max(double firstOperand, double secondOperand) {
        return (firstOperand>=secondOperand) ? firstOperand:secondOperand;
    }
}
