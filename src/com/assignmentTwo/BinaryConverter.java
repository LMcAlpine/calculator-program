package com.assignmentTwo;

/**
 * An interface which is for binary conversions
 */
public interface BinaryConverter {
   // String s = null;

    /** binary to decimal conversion
     * @param s binary string to convert
     * @return int result to return
     */
    int binaryToDecimal(String s);

    /** decimal to binary string conversion
     * @param num decimal to convert
     * @return string result to return
     */
    String decimalToBinary(int num);
}
