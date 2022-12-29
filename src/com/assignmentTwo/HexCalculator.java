package com.assignmentTwo;

/**
 * HexCalculator class
 * inherits from the Calculator class and implements the HexConverter interface
 */
public class HexCalculator extends Calculator implements HexConverter {
    /**
     * Constructor for HexCalculator
     *
     * @param num1 first number the user inputs
     * @param num2 second number the user inputs
     */
    public HexCalculator(int num1, int num2) {
        super(num1, num2);
    }

    /**
     * add two numbers together and return a hex string
     *
     * @return returns a hex string
     */
    @Override
    String add() {
        return Integer.toHexString(num1 + num2);
    }

    /**
     * subtract two numbers and return a hex string
     *
     * @return returns a hex string
     */
    @Override
    String subtract() {
        return Integer.toHexString(num1 - num2);
    }

    /**
     * divide two numbers and return a hex string
     *
     * @return return a hex string
     */
    @Override
    String divide() {
        return Integer.toHexString(num1 / num2);
    }

    /**
     * multiply two numbers and return a hex string
     *
     * @return return a hex string
     */
    @Override
    String multiply() {
        return Integer.toHexString(num1 * num2);
    }


    /**
     * convert a hex string to a decimal value
     *
     * @param s the string to convert
     * @return the int to return
     */
    @Override
    public int hexToDecimal(String s) {
        return Integer.parseInt(s, 16);
    }

    /**
     * convert a decimal value to hex
     *
     * @param num the decimal to convert
     * @return the hex value to return
     */
    @Override
    public String decimalToHex(int num) {
        return Integer.toHexString(num);
    }
}
