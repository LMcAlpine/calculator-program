package com.assignmentTwo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * Abstract class
 * Calculator class which serves as a template for the binary calculator, hex calculator, decimal calculator and big number claculator
 * performs basic arithmetic options
 */
abstract class Calculator {
    int num1;
    int num2;

    double decNum;
    double decNum2;

    BigInteger bigInt;
    BigInteger bigInt2;

    BigDecimal bigDec1;
    BigDecimal bigDec2;

    int newScale;


    /**
     * Constructor for the Calculator
     *
     * @param num1 user input to perform operations on. Works for binary, hex, and decimal calculators
     * @param num2 user input to perform operations on. Works for binary, hex, and decimal calculators
     */
    public Calculator(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    /**
     * Constructor for the Calculator
     * used for the decimal calculator if double values are entered
     *
     * @param num1 user input to perform operations on.
     * @param num2 user input to perform operations on.
     */
    public Calculator(double num1, double num2) {
        this.decNum = num1;
        this.decNum2 = num2;
    }

    /**
     * Constructor for Calculator
     * used for the BigInteger portion of BigNumber Calculator
     *
     * @param num1     user input to perform operations on
     * @param newScale precision the user wants
     * @param num2     user input to perform operations on.
     */
    public Calculator(BigInteger num1, int newScale, BigInteger num2) {
        this.bigInt = num1;
        this.bigInt2 = num2;
        this.newScale = newScale;
    }

    /**
     * Constructor for Calculator
     * used for the BigDecimal portion of BigNumber Calculator
     *
     * @param num1     user input  to perform operations on
     * @param newScale precision the user wants
     * @param num2     user input to perform operations on
     */
    public Calculator(BigDecimal num1, int newScale, BigDecimal num2) {
        this.bigDec1 = num1;
        this.bigDec2 = num2;
        this.newScale = newScale;
    }


    /**
     * Abstract method to add two values
     *
     * @return return a string
     */
    abstract String add();

    /**
     * Abstract method to subtract two values
     *
     * @return return a string
     */
    abstract String subtract();

    /**
     * Abstract method to divide two values
     *
     * @return return a string
     */
    abstract String divide();

    /**
     * Abstract method to multiply two values
     *
     * @return return a string
     */
    abstract String multiply();


}
