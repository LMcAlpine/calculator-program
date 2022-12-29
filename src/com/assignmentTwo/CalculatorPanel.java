package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.Arrays;

/**
 * The CalculatorPanel. The display for where the user will enter values and select operation
 */
public class CalculatorPanel extends JPanel {
    JLabel valueLabel;


    JTextField textDisplay;
    JTextField textDisplayTwo;
    JTextField resultDisplay;

    JComboBox<String> comboBox;
    JLabel valueLabelTwo;
    JLabel resultLabel;
    JButton equalsButton;
    JLabel empty;
    JLabel answerLabel;


    /**
     * get the text from the first text field
     *
     * @return returns the text from the text display
     */
    public String getTextDisplay() {

        return textDisplay.getText();
    }

    /**
     * get the text from the second text field
     *
     * @return returns the text from the text display
     */
    public String getTextDisplayTwo() {
        return textDisplayTwo.getText();
    }

    /**
     * get the text from the result display
     *
     * @return returns the text in the result display
     */
    public String getResultDisplayText() {
        return resultDisplay.getText();
    }

    /**
     * gets the resultDisplay
     *
     * @return returns the resultDisplay
     */
    public JTextField getResultDisplay() {
        return resultDisplay;
    }


    /** gets the combo box in the panel
     * @return returns the combo box
     */
    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    /** get the equals button so each tab can have their own logic
     * @return returns the equals button
     */
    public JButton getEqualsButton() {
        return equalsButton;
    }


    /**
     * Constructor for the CalculatorPanel
     */
    public CalculatorPanel() {
        valueLabel = new JLabel("Value 1:");
        valueLabel.setForeground(Color.WHITE);
        textDisplay = new JTextField(20);


        textDisplayTwo = new JTextField(20);
        resultDisplay = new JTextField(20);
        comboBox = new JComboBox<>();
        valueLabelTwo = new JLabel("Value 2");
        valueLabelTwo.setForeground(Color.WHITE);
        resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.WHITE);
        equalsButton = new JButton("=");
        equalsButton.setFocusable(false);
        answerLabel = new JLabel("");


        empty = new JLabel(" ");


        setup();

    }

    /**
     * method which provides the setup for the CalculatorPanel and adds all the components to the panel
     */
    private void setup() {

        for (String s : Arrays.asList("+", "-", "*", "/")) {
            comboBox.addItem(s);
        }

        setLayout(new GridLayout(5, 2, 5, 5));
        setBorder(new LineBorder(Color.BLACK, 3));
        setBackground(Color.DARK_GRAY);


        add(valueLabel);
        add(textDisplay);


        add(empty);
        add(comboBox);

        add(valueLabelTwo);
        add(textDisplayTwo);

//        add(answerLabel);

        add(resultLabel);
        add(resultDisplay);


        add(equalsButton);


    }


}
