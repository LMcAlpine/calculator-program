package com.assignmentTwo;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * BigNumber Calculator class
 * Inherits from Calculator class
 */
public class BigNumberCalculator extends Calculator {
    /**
     * Constructor for BigNumberCalculator for BigIntegers
     * @param num1 first number the user inputs
     * @param newScale the precision the user wants
     * @param num2 the second number the user inputs
     */
    public BigNumberCalculator(BigInteger num1, int newScale, BigInteger num2) {
        super(num1, newScale, num2);
    }

    /** Constructor for BigNumberCalculator for BigDecimals
     * @param num1 first decimal the user inputs
     * @param newScale the precision the user wants
     * @param num2 second decimal the user wants
     */
    public BigNumberCalculator(BigDecimal num1, int newScale, BigDecimal num2) {
        super(num1, newScale, num2);
    }

    /** Addition method for BigIntegers
     * @return returns a string of the sum of two BigIntegers
     */
    @Override
    String add() {
        return String.valueOf(bigInt.add(bigInt2));
    }

    /** Subtraction method for BigIntegers
     * @return returns a string of the subtraction of two BigIntegers
     */
    @Override
    String subtract() {
        return String.valueOf(bigInt.subtract(bigInt2));
    }

    /** Division method for two BigIntegers
     * @return returns a string of the quotient of two BigIntegers
     */
    @Override
    String divide() {
        return String.valueOf(bigInt.divide(bigInt2));
    }

    /** Multiplication method for two BigIntegers
     * @return returns a string of the product of two BigIntegers
     */
    @Override
    String multiply() {
        return String.valueOf(bigInt.multiply(bigInt2));
    }


    /** Squares a BigInteger to the power of 2
     * @return returns a string of the square of a BigInteger
     */
    String square() {
        return String.valueOf(bigInt.pow(2));
    }

    /** squares a BigDecimal to the power of 2
     * @return returns a string of the square of a BigDecimal
     */
    String decSquare() {
        return String.valueOf(bigDec1.pow(2));
    }

//    String sqrt() {
//        return String.valueOf(bigInt.sqrt());
//    }

    /** square root of a BigDecimal
     * @return returns a string of the square root of a BigDecimal
     */
    String decSqrt() {
        return String.valueOf(bigDec1.sqrt(new MathContext(10)));
    }

    /** Addition method for BigDecimal
     * @return returns a string of the sum of two BigDecimals
     */
    String bigAddDec() {

        return String.valueOf(bigDec1.add(bigDec2));
    }

    /** Subtraction method for BigDecimal
     * @return returns a string of the subtraction of two BigDecimals
     */
    String bigSubtractDec() {
        return String.valueOf(bigDec1.subtract(bigDec2));

    }

    /** Multiplication method for BigDecimal
     * @return returns a string of the product of two BigDecimals
     */
    String bigMultiplyDec() {
        return String.valueOf(bigDec1.multiply(bigDec2));

    }

    /** Division method for two BigDecimals
     * @return returns a string of the quotient of two BigDecimals
     */
    String bigDivideDec() {
        return String.valueOf(bigDec1.divide(bigDec2, newScale, RoundingMode.HALF_DOWN));
    }

    /** finds the greatest common denominator of two BigDecimals
     * @param num the first BigDecimal entered
     * @param num2 the second BigDecimal entered
     * @return the greatest common denominator.
     */
    BigDecimal gcd(BigDecimal num, BigDecimal num2) {
        if (num2.signum() != 0) {
            return gcd(num2, num.remainder(num2));
        } else {
            return num;
        }
    }

    /**
     * least common multiple of two BigIntegers
     * @param number1 the first BigInteger entered
     * @param number2 the second BigInteger entered
     * @return returns the least common multiple
     */
    BigInteger lcm(BigInteger number1, BigInteger number2) {
        BigInteger gcd = number1.gcd(number2);
        BigInteger absProduct = number1.multiply(number2).abs();
        return absProduct.divide(gcd);
    }

    /** the factorial of a BigInteger
     * @param num the entered input which is a BigInteger
     * @return returns the factorial
     */
    BigInteger factorial(BigInteger num) {


        if (num.equals(BigInteger.ZERO) || num.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        return num.multiply(factorial(num.subtract(BigInteger.ONE)));

    }


}
