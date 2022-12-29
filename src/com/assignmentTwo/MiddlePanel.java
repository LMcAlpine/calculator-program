package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * A middle panel which contains calculatorPanel and resultPanel
 * extends JPanel
 */
public class MiddlePanel extends JPanel {
    JPanel calculatorPanel;
    JPanel resultPanel;

    /** getting the resultPanel
     * @return  return resultPanel
     */
    public JPanel getResultPanel() {
        return resultPanel;
    }

    /** getting the calculatorPanel
     * @return return calculatorPanel
     */
    public JPanel getCalculatorPanel() {
        return calculatorPanel;
    }

    /** Constructor for MiddlePanel
     * @param calculatorPanel the panel where this specific calculator goes
     * @param resultPanel the panel for a result
     */
    public MiddlePanel(JPanel calculatorPanel, JPanel resultPanel) {
        this.calculatorPanel = calculatorPanel;
        this.resultPanel = resultPanel;
        setup();
        addPanel();
    }

    /**
     * set up the middle panel
     */
    private void setup() {
        setBorder(new LineBorder(Color.BLACK, 3));
        setLayout(new BorderLayout());
        setBackground(Color.BLUE);
    }

    /**
     * add the two panels to the middle panel
     */
    void addPanel() {


        add(calculatorPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
    }
}
