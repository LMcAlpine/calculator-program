package com.assignmentTwo;

/**
 * an interface which is for hex conversions
 */
public interface HexConverter {
    /**
     * convert hex to decimal
     *
     * @param s the hex string to convert
     * @return the int result to return
     */
    int hexToDecimal(String s);

    /**
     * converts decimal to hex
     *
     * @param num the decimal to convert to hex
     * @return returns the conversion as a hex string
     */
    String decimalToHex(int num);

}
