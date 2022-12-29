package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class to add conversion panels
 */
public class ConversionPanel extends JPanel {
    //    JPanel conversionPanel;
    JPanel calculatePanel;
    JPanel calculatePanelTwo;
    JTextField firstTextBox;
    JTextField resultTextBox;

    JTextField thirdTextBox;
    JTextField secondResultTextBox;


    JButton calculateButton;
    JButton clearButton;
    JButton calculateButtonTwo;
    JButton clearButtonTwo;


    JPanel convertToDecimal;
    JPanel convertToValue;
    JLabel label;

    JLabel valueToDecLabel;


    BinaryCalculator binaryCalculator;
    HexCalculator hexCalculator;


    int operand1 = 0;
    int operand2 = 0;

    /**
     * @return get the clear button in the first conversion table
     */
    public JButton getClearButton() {
        return clearButton;
    }

    /**
     * @return get the second clear button in the second conversion table
     */
    public JButton getClearButtonTwo() {
        return clearButtonTwo;
    }


    /**
     * sets the result
     *
     * @param resultTextBox the result text
     */
    public void setResultTextBox(String resultTextBox) {
        this.resultTextBox.setText(resultTextBox);
    }

    /**
     * sets the result for the second box
     *
     * @param secondResultTextBox the result text
     */
    public void setSecondResultTextBox(String secondResultTextBox) {
        this.secondResultTextBox.setText(secondResultTextBox);
    }

    /**
     * @return returns the calculateButton
     */
    public JButton getCalculateButton() {
        return calculateButton;
    }

    /**
     * @return returns the calculateButtonTwo
     */
    public JButton getCalculateButtonTwo() {
        return calculateButtonTwo;
    }

    /**
     * @return return the textbox one contents
     */
    public String getTextBoxOneContents() {
        return firstTextBox.getText();
    }

    /**
     * sets the value of a text box
     */
    public void setFirstTextBox() {
        this.firstTextBox.setText(" ");
    }

    /**
     * sets the value of a text box
     */
    public void setThirdTextBox() {
        this.thirdTextBox.setText(" ");
    }

    /**
     * @return returns the text from the text box
     */
    public String getTextBoxThreeContents() {
        return thirdTextBox.getText();
    }


    /**
     * Constructor for the conversion panel
     *
     * @param label           label
     * @param valueToDecLabel value to decimal
     */
    public ConversionPanel(JLabel label, JLabel valueToDecLabel) {
        // conversionPanel = new JPanel();
        calculatePanel = new JPanel();
        calculatePanelTwo = new JPanel();
        firstTextBox = new JTextField(20);
//        secondTextBox = new JTextField(20);
        resultTextBox = new JTextField(20);

        thirdTextBox = new JTextField(20);
//        fourthTextBox = new JTextField(20);
        secondResultTextBox = new JTextField(20);

        calculateButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        calculateButtonTwo = new JButton("Calculate");
        clearButtonTwo = new JButton("Clear");

        convertToDecimal = new JPanel();
        convertToValue = new JPanel();


        binaryCalculator = new BinaryCalculator(operand1, operand2);
        hexCalculator = new HexCalculator(operand1, operand2);

        this.label = label;
        this.valueToDecLabel = valueToDecLabel;


        setup();


    }

    /**
     * setup method for the conversion panels
     */
    private void setup() {


        setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        setBorder(new LineBorder(Color.BLACK, 3));
        setBackground(Color.DARK_GRAY);

        calculatePanel.setLayout(new GridLayout(2, 3, 5, 5));
        calculatePanel.setBackground(Color.DARK_GRAY);
        calculatePanel.setBorder(new LineBorder(Color.BLACK, 3));

        calculatePanel.add(firstTextBox);


        calculateButton.setFocusable(false);
        calculateButtonTwo.setFocusable(false);
        clearButton.setFocusable(false);
        clearButtonTwo.setFocusable(false);

        calculatePanel.add(calculateButton);
        calculatePanel.add(resultTextBox);
        calculatePanel.add(clearButton);


        label.setForeground(Color.WHITE);
        convertToDecimal.add(label);
        convertToDecimal.setBackground(Color.GRAY);

        convertToDecimal.add(calculatePanel);


        valueToDecLabel.setForeground(Color.WHITE);
        convertToValue.add(valueToDecLabel);
        convertToValue.setBackground(Color.GRAY);

        calculatePanelTwo.setLayout(new GridLayout(2, 3, 5, 5));
        calculatePanelTwo.setBackground(Color.DARK_GRAY);
        calculatePanelTwo.setBorder(new LineBorder(Color.BLACK, 3));
        calculatePanelTwo.add(thirdTextBox);


        calculatePanelTwo.add(calculateButtonTwo);
        calculatePanelTwo.add(secondResultTextBox);
        calculatePanelTwo.add(clearButtonTwo);

        convertToValue.add(calculatePanelTwo);


        add(convertToDecimal);
        add(convertToValue);


        //add(calculatePanel);
    }


}
