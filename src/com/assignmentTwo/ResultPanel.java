package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class for the result panel
 */
public class ResultPanel extends JPanel {
    String result;
    JLabel answerLabel = new JLabel("");
    JLabel decimalAnsLabel = new JLabel("");
    JLabel titleLabel;

    /**
     * @param result the result so the answer label can be set
     */
    public void setAnswerLabel(String result) {
        this.answerLabel.setText(result);
    }

//    public void setDecimalAnsLabel(String result) {
//        this.decimalAnsLabel.setText(result);
//    }


    /**
     * Constructor for the ResultPanel
     *
     * @param titleLabel the label for a specific calculator
     * @param result     the result
     */
    public ResultPanel(JLabel titleLabel, String result) {

        this.titleLabel = titleLabel;
        this.result = result;
        setup();
    }

    /**
     * the setup method
     */
    private void setup() {

        setLayout(new GridLayout(5, 1, 5, 5));
        setBorder(new LineBorder(Color.BLACK, 3));
        setBackground(Color.DARK_GRAY);

//        answerLabel = new JLabel(result);
        System.out.println(answerLabel.getText());
        answerLabel.setForeground(Color.WHITE);


        titleLabel.setForeground(Color.WHITE);

        // JLabel decLabel = new JLabel("Decimal Value:");
        //  decLabel.setForeground(Color.WHITE);


        add(titleLabel);


        add(answerLabel);

        //  add(decLabel);

        // add(decimalAnsLabel);

    }
}
