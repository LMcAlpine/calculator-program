package com.assignmentTwo;

/**
 * DecimalCalculator class
 * inherits from the Calculator class
 */
public class DecimalCalculator extends Calculator {
    /**
     * Constructor for the DecimalCalculator
     *
     * @param num1 first number entered
     * @param num2 second number entered
     */
    public DecimalCalculator(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * Second constructor which supports double values
     *
     * @param decNum1 the first double value
     * @param decNum2 the second double value
     */
    public DecimalCalculator(double decNum1, double decNum2) {
        super(decNum1, decNum2);
    }


    /**
     * add two  numbers together
     *
     * @return return a string result
     */
    @Override
    String add() {
        return String.valueOf(num1 + num2);
    }

    /**
     * subtract two numbers
     *
     * @return return a string result
     */
    @Override
    String subtract() {
        return String.valueOf(num1 - num2);
    }

    /**
     * divide two  numbers
     *
     * @return return a string result
     */
    @Override
    String divide() {
        return String.valueOf(num1 / num2);
    }

    /**
     * multiply two numbers together
     *
     * @return a string result
     */
    @Override
    String multiply() {
        return String.valueOf(num1 * num2);
    }


    /**
     * add two double values
     *
     * @return return a string result
     */
    String decAdd() {
        return String.valueOf(decNum + decNum2);
    }

    /**
     * subtract two double values
     *
     * @return return a string result
     */
    String decSubtract() {
        return String.valueOf(decNum - decNum2);
    }

    /**
     * multiply two double values
     *
     * @return return a string result
     */
    String decMultiply() {
        return String.valueOf(decNum * decNum2);
    }

    /**
     * divide two double values
     *
     * @return return a string result
     */
    String decDivide() {
        return String.valueOf(decNum / decNum2);
    }
}
