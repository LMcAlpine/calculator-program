package com.assignmentTwo;

/**
 * BinaryCalculator class
 * inherits from the Calculator class and implements the BinaryConverter interface
 */
public class BinaryCalculator extends Calculator implements BinaryConverter {
    /**
     * Constructor for BinaryCalculator
     *
     * @param num1 first number the user inputs
     * @param num2 second number the user inputs
     */
    public BinaryCalculator(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * adds two numbers together and returns a binary string
     *
     * @return returns a binary string
     */
    @Override
    String add() {
        return Integer.toBinaryString(num1 + num2);
    }

    /**
     * subtracts two numbers
     *
     * @return return a binary string
     */
    @Override
    String subtract() {
        return Integer.toBinaryString(num1 - num2);
    }


    /**
     * divide two numbers
     *
     * @return return a binary string
     */
    @Override
    String divide() {
        return Integer.toBinaryString(num1 / num2);
    }

    /**
     * multiply two numbers
     *
     * @return return a binary string
     */
    @Override
    String multiply() {
        return Integer.toBinaryString(num1 * num2);
    }

    /**
     * convert a binary string to a decimal value
     *
     * @param s the string to convert
     * @return the int to return
     */
    @Override
    public int binaryToDecimal(String s) {
        return Integer.parseInt(s, 2);
    }

    /**
     * convert a decimal value to a binary string
     *
     * @param num the decimal value to convert
     * @return the binary result to return
     */
    @Override
    public String decimalToBinary(int num) {
        return Integer.toBinaryString(num);

    }
}
