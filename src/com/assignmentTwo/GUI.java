package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * GUI class that acts as a hybrid controller/view class
 * Processes user input and makes appropriate calls to other class methods through calculator objects
 */
public class GUI {

    int operand1 = 0;
    int operand2 = 0;

    double op1 = 0;
    double op2 = 0;
    boolean doubleEntered;

    String result = "____";
    String selectedOperation;

    Calculator calc = null;

    int newScale;

    // JLabel answerLabel;

    BinaryCalculator binCalc;
    HexCalculator hexCalc;

    JLabel empty = new JLabel(" ");


    /**
     * Constructor for GUI class
     * instantiates a binaryCalculator object and a hexCalculator object
     * Calls setup() method
     */
    public GUI() {
        binCalc = new BinaryCalculator(operand1, operand2);
        hexCalc = new HexCalculator(operand1, operand2);

        setup();
    }


    /**
     * Method to setup the frame
     * creates a menu bar, adds panels, makes the general appearance of the application better
     * creates the tabbed pane and has a tab for all four calculators
     * Various GUI components stored in a Container.
     * There are four method calls to setup each individual tab.
     */
    private void setup() {
        //frame
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width / 2, screenSize.height / 2);


        // menu bar
        JMenuBar menuBar = createMenuBar(frame);
        frame.setJMenuBar(menuBar);
        frame.setTitle("Calculator");


        // Panels
        JPanel binaryCalcPanel = new JPanel();
        JPanel hexCalcPanel = new JPanel();
        JPanel decCalcPanel = new JPanel();
        JPanel bigNumCalcPanel = new JPanel();


        //UI appearance improvements
        UI();

        JTabbedPane tp = new JTabbedPane();
        tp.setFocusable(false);


        tp.add("Binary Calculator", binaryCalcPanel);
        tp.add("Hex Calculator", hexCalcPanel);
        tp.add("Decimal Calculator", decCalcPanel);
        tp.add("BigNumber Calculator", bigNumCalcPanel);


        Container mainContainer = frame.getContentPane();
        mainContainer.setLayout(new BorderLayout(8, 4));
        mainContainer.setBackground(Color.DARK_GRAY);


        frame.getRootPane().setBorder(BorderFactory.createMatteBorder(4, 4, 4, 4, Color.BLACK));

        frame.add(tp);

        JLabel binLabel = new JLabel("Binary Value:");
        JLabel hexDecLabel = new JLabel("Hex Value:");


        JLabel binaryConversionLabel = new JLabel("Convert Binary Value to Decimal Value");
        JLabel hexConversionLabel = new JLabel("Convert Hex Value to Decimal Value");

        JLabel binaryConvLabel = new JLabel("Convert Decimal Value to Binary Value");
        JLabel hexConvLabel = new JLabel("Convert Decimal Value to Hex Value");

        JLabel binaryLabel = new JLabel("BINARY CALCULATOR");
        JLabel hexLabel = new JLabel("HEX CALCULATOR");
        JLabel decimalLabel = new JLabel("DECIMAL CALCULATOR");
        JLabel bigNumberLabel = new JLabel("BIGNUMBER CALCULATOR");


        setupBinaryTab(binaryCalcPanel, binaryLabel, binLabel, binaryConversionLabel, binaryConvLabel);
        setupHexTab(hexCalcPanel, hexLabel, hexDecLabel, hexConversionLabel, hexConvLabel);
        setupDecTab(decCalcPanel, empty, decimalLabel, empty, empty);
        setupBigTab(bigNumCalcPanel, bigNumberLabel);


        frame.setVisible(true);


    }


    /**
     * Called from the setup() method.
     * parameter of the frame
     * Creates a menu bar and add returns the menu bar.
     * calls a method to add actions to the menu items
     *
     * @param frame frame where all components are part of
     * @return returns the menu bar
     */
    private JMenuBar createMenuBar(JFrame frame) {
        JMenuBar menuBar = new JMenuBar();
        JMenuItem fileMenu = new JMenu("File");


        JMenuItem helpMenu = new JMenuItem("Help");


        JMenuItem exitMenu = new JMenuItem("Exit");

        menuBar.add(fileMenu);
        fileMenu.add(exitMenu);


        menuBar.add(helpMenu);

        // call to method which adds actions to the menu items
        menuActions(exitMenu, helpMenu, frame);

        return menuBar;
    }


    /**
     * Called from createMenuBar() method
     * Adds the ability to click the exit menu item and exit the program
     * A shortcut Ctrl-E is added to exit the program
     *
     * @param exitMenu exitMenu is a visual representation that once clicked exits the program
     * @param helpMenu helpMenu is a visual representation that once clicked opens a help dialog
     * @param frame    the frame where all components are a part of
     */
    private void menuActions(JMenuItem exitMenu, JMenuItem helpMenu, JFrame frame) {
        // action to close the program
        Action exitAction = new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        };


        // keyboard shortcut to close program. Ctrl-E
        // Shows the shortcut on the exit menu
        exitAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_DOWN_MASK));
        exitMenu.setAction(exitAction);


        helpMenu.addActionListener(e -> JOptionPane.showMessageDialog(frame, """
                There are four different calculators to use.\s
                Select any calculator through the respective tab.
                There is a Binary Calculator, Hex Calculator, Decimal Calculator, and a Big Number Calculator.
                 Enter the values in the respective textboxes and select the operation through the drop down menu.
                Binary and Hex calculators support conversions.
                Ctrl-E to exit the program."""));

    }

    /**
     * set a better look and feel based on the user's system
     * Works fine on Windows but remove/comment out method and where it is called if it has issues with another OS.
     */
    private void UI() {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        // removes inner default border and makes the application look better
        UIManager.put("TabbedPane.contentOpaque", false);
        UIManager.getDefaults().put("TabbedPane.contentBorderInsets", new Insets(0, 0, 0, 0));
        UIManager.getDefaults().put("TabbedPane.tabsOverlapBorder", false);
    }


    /**
     * sets up the components for the BigNumber tab.
     * Creates the functionality for various different types of calculations
     *
     * @param panel the panel where the BigNumber tab should be
     * @param label a label which states what type of Calculator the tab is
     */
    private void setupBigTab(JPanel panel, JLabel label) {


        panel.setLayout(new BorderLayout(8, 4));
        panel.setBackground(Color.GRAY);


        label.setForeground(Color.WHITE);

        //top panel
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new LineBorder(Color.BLACK, 3));
        topPanel.setBackground(Color.GRAY);
        topPanel.setLayout(new FlowLayout(5));

        topPanel.add(label);
        panel.add(topPanel, BorderLayout.NORTH);


        var textDisplay = new JTextField(20);
        var textDisplayTwo = new JTextField(20);
        var resultDisplay = new JTextField(20);


        JLabel valueLabel = new JLabel("X = ");

        valueLabel.setForeground(Color.WHITE);
        JLabel valueLabelTwo = new JLabel("Y = ");
        valueLabelTwo.setForeground(Color.WHITE);
        JLabel resultLabel = new JLabel("Result:");
        resultLabel.setForeground(Color.WHITE);

        JPanel middlePanel = new JPanel();
        middlePanel.setBorder(new LineBorder(Color.BLACK, 3));
        middlePanel.setLayout(new BorderLayout());
        middlePanel.setBackground(Color.GRAY);

        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 2, 5, 5));
        gridPanel.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanel.setBackground(Color.DARK_GRAY);


        JLabel precisionLabel = new JLabel("Precision");
        precisionLabel.setForeground(Color.WHITE);
        var precisionDisplay = new JTextField(10);

        gridPanel.add(valueLabel);
        gridPanel.add(textDisplay);


        gridPanel.add(valueLabelTwo);
        gridPanel.add(textDisplayTwo);


        gridPanel.add(precisionLabel);
        gridPanel.add(precisionDisplay);

        gridPanel.add(resultLabel);
        gridPanel.add(resultDisplay);

        JPanel gridPanelTwo = new JPanel();
        gridPanelTwo.setLayout(new FlowLayout());
        gridPanelTwo.setBorder(new LineBorder(Color.BLACK, 3));
        gridPanelTwo.setBackground(Color.DARK_GRAY);


        ButtonGroup group = new ButtonGroup();

        JRadioButton xPlusY = new JRadioButton("X + Y");
        JRadioButton xMinusY = new JRadioButton("X-  Y");
        JRadioButton xTimesY = new JRadioButton("X * Y");
        JRadioButton xDivideY = new JRadioButton("X / Y");
        // JRadioButton xSquareY = new JRadioButton("X ^ Y");
        JRadioButton xSqrt = new JRadioButton("√x");
        JRadioButton xSquared = new JRadioButton("X ^ 2");
        JRadioButton xFactorial = new JRadioButton("X!");
        JRadioButton mod = new JRadioButton("MOD");
        JRadioButton gcd = new JRadioButton("GCD");
        JRadioButton lcm = new JRadioButton("LCM");


        xPlusY.setSelected(false);

        xPlusY.setFocusable(false);
        xMinusY.setFocusable(false);
        xTimesY.setFocusable(false);
        xDivideY.setFocusable(false);
        // xSquareY.setFocusable(false);
        xSqrt.setFocusable(false);
        xSquared.setFocusable(false);
        xFactorial.setFocusable(false);
        mod.setFocusable(false);
        gcd.setFocusable(false);
        lcm.setFocusable(false);

        group.add(xPlusY);
        group.add(xMinusY);
        group.add(xTimesY);
        group.add(xDivideY);
        //  group.add(xSquareY);
        group.add(xSqrt);
        group.add(xSquared);
        group.add(xFactorial);
        group.add(mod);
        group.add(gcd);
        group.add(lcm);

        gridPanelTwo.add(xPlusY);
        gridPanelTwo.add(xMinusY);
        gridPanelTwo.add(xTimesY);
        gridPanelTwo.add(xDivideY);
        //  gridPanelTwo.add(xSquareY);
        gridPanelTwo.add(xSqrt);
        gridPanelTwo.add(xSquared);
        gridPanelTwo.add(xFactorial);
        gridPanelTwo.add(mod);
        gridPanelTwo.add(gcd);
        gridPanelTwo.add(lcm);


        middlePanel.add(gridPanel, BorderLayout.NORTH);
        middlePanel.add(gridPanelTwo, BorderLayout.CENTER);

        panel.add(middlePanel, BorderLayout.WEST);

        xPlusY.addActionListener(
                e -> {
                    try {
                        String s = textDisplay.getText();
                        String s2 = textDisplayTwo.getText();
                        String s3 = precisionDisplay.getText();

                        if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                            newScale = Integer.parseInt(s3);
                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);
                            String result = calc.bigAddDec();
                            System.out.println(result);
                            resultDisplay.setText(result);
                            System.out.println(bigDecimal);
                        } else {
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);
                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
                            String result = calc.add();
                            resultDisplay.setText(result);
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                    }


                });
        xMinusY.addActionListener(
                e -> {

                    try {
                        String s = textDisplay.getText();
                        String s2 = textDisplayTwo.getText();
                        String s3 = precisionDisplay.getText();

                        if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                            newScale = Integer.parseInt(s3);
                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);
                            String result = calc.bigSubtractDec();
                            System.out.println(result);
                            resultDisplay.setText(result);
                            System.out.println(bigDecimal);
                        } else {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);
                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
                            String result = calc.subtract();
                            resultDisplay.setText(result);
                        }
                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                    }


                });
        xTimesY.addActionListener(
                e -> {

                    String s = textDisplay.getText();
                    String s2 = textDisplayTwo.getText();
                    String s3 = precisionDisplay.getText();

                    if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);
                            String result = calc.bigMultiplyDec();
                            System.out.println(result);
                            resultDisplay.setText(result);
                            System.out.println(bigDecimal);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal number inputs");
                        }


                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);
                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
                            String result = calc.multiply();
                            resultDisplay.setText(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }

                });
        xDivideY.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s2 = textDisplayTwo.getText();
                    String s3 = precisionDisplay.getText();

                    int newScale;

                    if (s2.equals("0")) {
                        System.out.println("Divide by zero");
                        JOptionPane.showMessageDialog(panel, "Divide by zero");
                        return;
                    }

                    if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                        try {
                            newScale = Integer.parseInt(s3);

                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);
                            String result = calc.bigDivideDec();

                            System.out.println(result);
                            resultDisplay.setText(result);
                            System.out.println(bigDecimal);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }


                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);
                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
                            String result = calc.divide();
                            resultDisplay.setText(result);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }

                });
//        xSquareY.addActionListener(
//                new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//
//
//                    }
//                });
        xSqrt.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s3 = precisionDisplay.getText();


                    BigDecimal bigDecimal;

                    BigInteger bigInteger;


                    if (s.contains("E") || s.contains("e") || s.contains(".")) {
                        try {
                            newScale = Integer.parseInt(s3);
                            bigDecimal = new BigDecimal(s);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, null);
                            String result = calc.decSqrt();

                            resultDisplay.setText(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }


                    } else {
                        try {

                            bigInteger = new BigInteger(s);
                            //  bigInteger1 = new BigInteger(s2);


                            BigInteger result = bigInteger.sqrt();
                            resultDisplay.setText(String.valueOf(result));
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }


                });
        xSquared.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s3 = precisionDisplay.getText();
                    BigInteger bigInteger;

                    BigDecimal bigDecimal;


                    if (s.contains("E") || s.contains("e") || s.contains(".")) {

                        try {
                            newScale = Integer.parseInt(s3);
                            bigDecimal = new BigDecimal(s);
                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, null);
                            String result = calc.decSquare();

                            resultDisplay.setText(result);
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }

                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            bigInteger = new BigInteger(s);
                            //  bigInteger2 = new BigInteger(s2);
                            BigNumberCalculator calc = new BigNumberCalculator(bigInteger, newScale, null);
                            String result = calc.square();
                            resultDisplay.setText(result);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }


                    }


                });
        xFactorial.addActionListener(
                e -> {
                    String s = textDisplay.getText();

                    BigInteger bigInteger;

                    if (s.contains("-")) {
                        System.out.println("No negatives");
                        JOptionPane.showMessageDialog(panel, "No negative numbers");
                        return;
                    }

                    try {

                        bigInteger = new BigInteger(s);


                    } catch (NumberFormatException numberFormatException) {
                        JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        return;
                    }

                    BigNumberCalculator calc = new BigNumberCalculator(bigInteger, newScale, null);
                    resultDisplay.setText(String.valueOf(calc.factorial(bigInteger)));


                });
        mod.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s2 = textDisplayTwo.getText();
                    String s3 = precisionDisplay.getText();

                    int newScale;

                    if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                        try {

                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);


                            System.out.println(result);
                            resultDisplay.setText(String.valueOf(bigDecimal.remainder(bigDecimal2)));
                            System.out.println(bigDecimal);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }


                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);

                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
                            resultDisplay.setText(String.valueOf(bigInteger.mod(bigInteger1)));

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }

                });
        gcd.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s2 = textDisplayTwo.getText();
                    String s3 = precisionDisplay.getText();

                    int newScale;

                    if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                        try {
                            newScale = Integer.parseInt(s3);

                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);

                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);


                            System.out.println(result);
                            resultDisplay.setText(String.valueOf(calc.gcd(bigDecimal, bigDecimal2)));
                            System.out.println(bigDecimal);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }


                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);


                            calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
//                            String result = calc.divide();
                            resultDisplay.setText(String.valueOf(bigInteger.gcd(bigInteger1)));

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }

                });
        lcm.addActionListener(
                e -> {
                    String s = textDisplay.getText();
                    String s2 = textDisplayTwo.getText();
                    String s3 = precisionDisplay.getText();

                    int newScale;

                    if (s.contains("E") || s.contains("e") || s.contains(".") || s2.contains("E") || s2.contains("e") || s2.contains(".")) {
                        try {
                            newScale = Integer.parseInt(s3);

                            BigDecimal bigDecimal = new BigDecimal(s);
                            BigDecimal bigDecimal2 = new BigDecimal(s2);

                            BigNumberCalculator calc = new BigNumberCalculator(bigDecimal, newScale, bigDecimal2);

                            BigDecimal product = bigDecimal.multiply(bigDecimal2);
                            BigDecimal greatestCD = calc.gcd(bigDecimal, bigDecimal2);
                            BigDecimal resultBig = product.divide(greatestCD);


                            System.out.println(result);
                            resultDisplay.setText(String.valueOf(resultBig));
                            System.out.println(bigDecimal);

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid decimal inputs");
                        }


                    } else {
                        try {
                            newScale = Integer.parseInt(s3);
                            BigInteger bigInteger = new BigInteger(s);
                            BigInteger bigInteger1 = new BigInteger(s2);


                            BigNumberCalculator calc = new BigNumberCalculator(bigInteger, newScale, bigInteger1);
//                            String result = calc.divide();
                            resultDisplay.setText(String.valueOf(calc.lcm(bigInteger, bigInteger1)));

                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(panel, "Enter valid number inputs");
                        }

                    }

                });


    }


    /**
     * sets up the tab for the decimal calculator
     * Two action listeners. One for if Enter is pressed and one if the equals button on screen is clicked.
     * call to a decimalInputProcessing method.
     *
     * @param panel          the panel where the decimal calculator should be
     * @param label          the label which states what calculator this is
     * @param titleLabel     a label that also states the calculator but is in a different panel
     * @param empty          empty parameter as other setup methods for the other tabs need a parameter in that location. As all the setupTab methods call addComponents.
     * @param valueConvLabel Label to state what value this page should support conversions for
     */
    private void setupDecTab(JPanel panel, JLabel label, JLabel titleLabel, JLabel empty, JLabel valueConvLabel) {
        MiddlePanel middlePanel = addComponents(panel, label, titleLabel, empty, valueConvLabel);
        ResultPanel resultPanel = (ResultPanel) middlePanel.getResultPanel();


        CalculatorPanel decPanel = (CalculatorPanel) middlePanel.getCalculatorPanel();
        JButton equalsButton = decPanel.getEqualsButton();
        JComboBox<String> comboBox = decPanel.getComboBox();
        JTextField resultDisplay = decPanel.getResultDisplay();

        //So the equals button can be pressed through enter instead of clicking an equals button
        InputMap inMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inMap.put(KeyStroke.getKeyStroke("ENTER"), "Equals");
        ActionMap actMap = panel.getActionMap();
        actMap.put("Equals", new AbstractAction() {
            /** actionPerformed method for when Enter is pressed
             * @param e the event performed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                decimalInputProcessing(decPanel, comboBox, resultDisplay, resultPanel);


            }
        });


        equalsButton.addActionListener(
                e -> decimalInputProcessing(decPanel, comboBox, resultDisplay, resultPanel)
        );

    }


    /**
     * method to process the decimal input. Supports integer values and double values.
     * Calls an operations method to perform operations
     *
     * @param decPanel      panel where the decimal calculator goes
     * @param comboBox      combo box to determine what operation was selected
     * @param resultDisplay text field where the result goes
     * @param resultPanel   panel where the result goes
     */
    private void decimalInputProcessing(CalculatorPanel decPanel, JComboBox<String> comboBox, JTextField resultDisplay, ResultPanel resultPanel) {
        String s = decPanel.getTextDisplay();

        String s2 = decPanel.getTextDisplayTwo();


        if (s.contains(".") || s2.contains(".")) {

            doubleEntered = true;
        }


        try {
            if (doubleEntered) {
                op1 = Double.parseDouble(s);
                op2 = Double.parseDouble(s2);

            } else {
                operand1 = Integer.parseInt(s);
                operand2 = Integer.parseInt(s2);
            }


        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(decPanel, "Enter valid number inputs");
            return;
        }
        selectedOperation = String.valueOf(comboBox.getSelectedItem());


        if (selectedOperation.equals("/") && (operand2 == 0) && !doubleEntered) {
            System.out.println("Divide by zero");
            JOptionPane.showMessageDialog(decPanel, "Divide by zero");
            return;
        }
        if (selectedOperation.equals("/") && (op2 == 0) && doubleEntered) {
            System.out.println("Divide by zero");
            JOptionPane.showMessageDialog(decPanel, "Divide by zero");
            return;
        }
        if (doubleEntered) {
            DecimalCalculator decCalc = new DecimalCalculator(op1, op2);

            switch (selectedOperation) {
                case "+" -> result = decCalc.decAdd();
                case "-" -> result = decCalc.decSubtract();
                case "*" -> result = decCalc.decMultiply();
                case "/" -> result = decCalc.decDivide();
            }
            resultPanel.setAnswerLabel(result);
            resultDisplay.setText(result);


        } else {
            calc = new DecimalCalculator(operand1, operand2);
            operations(resultDisplay, resultPanel, false, false, false, false, true);
        }
    }


    /**
     * sets up the tab for the hex calculator
     * Two action listeners. One for if Enter is pressed and one if the equals button on screen is clicked.
     * call to a hexInputProcessing method.
     *
     * @param panel           panel where the hex calculator goes
     * @param label           label for hex calculator
     * @param titleLabel      another label for hex calculator created but is in a different panel
     * @param conversionLabel label to show what is getting converted to decimal
     * @param valueConvLabel  label to say what value a decimal is getting converted to. But in different panel.
     */
    private void setupHexTab(JPanel panel, JLabel label, JLabel titleLabel, JLabel conversionLabel, JLabel valueConvLabel) {
        MiddlePanel middlePanel = addComponents(panel, label, titleLabel, conversionLabel, valueConvLabel);

        ResultPanel resultPanel = (ResultPanel) middlePanel.getResultPanel();


        CalculatorPanel hexPanel = (CalculatorPanel) middlePanel.getCalculatorPanel();
        JButton equalsButton = hexPanel.getEqualsButton();
        JComboBox<String> comboBox = hexPanel.getComboBox();

        ConversionPanel conversionPanel = new ConversionPanel(conversionLabel, valueConvLabel);
        panel.add(conversionPanel);
        JButton calculateButton = conversionPanel.getCalculateButton();
        JButton calculateButtonTwo = conversionPanel.getCalculateButtonTwo();

        calculateButton.addActionListener(e -> {
            try {
                String s = conversionPanel.getTextBoxOneContents();
                HexCalculator hexCalculator = new HexCalculator(operand1, 0);
                operand1 = hexCalculator.hexToDecimal(s);
                conversionPanel.setResultTextBox(String.valueOf(operand1));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(hexPanel, "Enter valid inputs containing 0-9 and A-F only");

            }
        });

        calculateButtonTwo.addActionListener(e -> {
            try {
                String s = conversionPanel.getTextBoxThreeContents();
                operand1 = Integer.parseInt(s);
                HexCalculator hexCalculator = new HexCalculator(operand1, 0);
                String op1 = hexCalculator.decimalToHex(operand1);
                conversionPanel.setSecondResultTextBox(op1);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(hexPanel, "Enter valid decimal numbers");
            }

        });


        //So the equals button can be pressed through enter instead of clicking an equals button
        InputMap inMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inMap.put(KeyStroke.getKeyStroke("ENTER"), "Equals");
        ActionMap actMap = panel.getActionMap();
        actMap.put("Equals", new AbstractAction() {
            /** Support for Enter to be pressed and perform the calculation
             * @param e event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                hexInputProcessing(hexPanel, comboBox, resultPanel);
            }


        });


        equalsButton.addActionListener(
                e -> hexInputProcessing(hexPanel, comboBox, resultPanel)
        );


    }


    /**
     * method to process the hex input
     * Calls an operations method to perform operations
     *
     * @param hexPanel    panel where the hex calculator goes
     * @param comboBox    combo box to determine what operation was selected
     * @param resultPanel panel where the result goes
     */
    private void hexInputProcessing(CalculatorPanel hexPanel, JComboBox<String> comboBox, ResultPanel resultPanel) {
        String s = hexPanel.getTextDisplay();

        String s2 = hexPanel.getTextDisplayTwo();


        try {
            operand1 = hexCalc.hexToDecimal(s);
            operand2 = hexCalc.hexToDecimal(s2);


        } catch (NumberFormatException numberFormatException) {
            JOptionPane.showMessageDialog(hexPanel, "Enter valid inputs containing 0-9 and A-F only");

            return;
        }

        selectedOperation = String.valueOf(comboBox.getSelectedItem());
        if (selectedOperation.equals("/") && operand2 == 0) {
            System.out.println("Divide by zero");
            JOptionPane.showMessageDialog(hexPanel, "Divide by zero");
            return;
        }

        if (operand1 < operand2) {
            calc = new HexCalculator(operand1, operand2);
            JTextField resultDisplay = hexPanel.getResultDisplay();
            operations(resultDisplay, resultPanel, false, true, false, true, false);

        } else {
            calc = new HexCalculator(operand1, operand2);


            JTextField resultDisplay = hexPanel.getResultDisplay();

            operations(resultDisplay, resultPanel, false, false, false, true, false);
        }


    }


    /**
     * sets up the tab for the binary calculator
     * Two action listeners. One for if Enter is pressed and one if the equals button on screen is clicked
     * call to a binaryInputProcessing method.
     *
     * @param panel           panel where the binary calculator goes
     * @param label           label for the binary calculator
     * @param titleLabel      another label for binary calculator but is in a different panel
     * @param conversionLabel label to show what is getting converted to decimal
     * @param valueConvLabel  label to say what value a decimal is getting to. But in a different panel
     */
    private void setupBinaryTab(JPanel panel, JLabel label, JLabel titleLabel, JLabel conversionLabel, JLabel valueConvLabel) {

        MiddlePanel middle = addComponents(panel, label, titleLabel, conversionLabel, valueConvLabel);

        CalculatorPanel binaryPanel = (CalculatorPanel) middle.getCalculatorPanel();
        JButton equalsButton = binaryPanel.getEqualsButton();
        JComboBox<String> comboBox = binaryPanel.getComboBox();


        ResultPanel resultPanel = (ResultPanel) middle.getResultPanel();


        ConversionPanel conversionPanel = new ConversionPanel(conversionLabel, valueConvLabel);
        panel.add(conversionPanel);
        JButton calculateButton = conversionPanel.getCalculateButton();
        JButton calculateButtonTwo = conversionPanel.getCalculateButtonTwo();

        JButton clearButton = conversionPanel.getClearButton();
        JButton clearButtonTwo = conversionPanel.getClearButtonTwo();


        calculateButton.addActionListener(e -> {
            try {
                String s = conversionPanel.getTextBoxOneContents();
                BinaryCalculator binaryCalculator = new BinaryCalculator(operand1, 0);
                operand1 = binaryCalculator.binaryToDecimal(s);
                conversionPanel.setResultTextBox(String.valueOf(operand1));
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(panel, "Enter valid Binary Values");
            }


        });
        clearButton.addActionListener(e -> {
            conversionPanel.setFirstTextBox();
            conversionPanel.setResultTextBox(" ");
        });

        clearButtonTwo.addActionListener(e -> {
            conversionPanel.setThirdTextBox();
            conversionPanel.setSecondResultTextBox(" ");

        });


        calculateButtonTwo.addActionListener(e -> {

            try {
                String s = conversionPanel.getTextBoxThreeContents();
                operand1 = Integer.parseInt(s);
                BinaryCalculator binaryCalculator = new BinaryCalculator(operand1, 0);
                String op1 = binaryCalculator.decimalToBinary(operand1);
                conversionPanel.setSecondResultTextBox(op1);
            } catch (NumberFormatException numberFormatException) {
//                System.out.println("Num format exception");
                JOptionPane.showMessageDialog(panel, "Enter valid Decimal Numbers");
            }


        });


        //So the equals button can be pressed through enter instead of clicking an equals button
        InputMap inMap = panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        inMap.put(KeyStroke.getKeyStroke("ENTER"), "Equals");
        ActionMap actMap = panel.getActionMap();
        actMap.put("Equals", new AbstractAction() {
            /** Support so Enter can be pressed
             * @param e event
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                binaryInputProcessing(binaryPanel, comboBox, resultPanel);
            }
        });


        equalsButton.addActionListener(
                e -> binaryInputProcessing(binaryPanel, comboBox, resultPanel)
        );


    }


    /**
     * method to process the binary input
     * Calls an operations method to perform operations
     *
     * @param binaryPanel panel where the binary calculator goes
     * @param comboBox    combo box to determine what operation was selected
     * @param resultPanel panel where the result goes
     */
    private void binaryInputProcessing(CalculatorPanel binaryPanel, JComboBox<String> comboBox, ResultPanel resultPanel) {
        String s = binaryPanel.getTextDisplay();

        String s2 = binaryPanel.getTextDisplayTwo();


        try {
            operand1 = binCalc.binaryToDecimal(s);
            operand2 = binCalc.binaryToDecimal(s2);

//            if (operand1 < operand2) {
//                int temp = operand1;
//                operand1 = operand2;
//                operand2 = temp;
//
//            }


        } catch (NumberFormatException numberFormatException) {
            // numberFormatException.printStackTrace();
            System.out.println("Enter valid inputs containing 0 and 1 only");
            JOptionPane.showMessageDialog(binaryPanel, "Enter valid inputs containing 0 and 1 only");
            // break;
            return;
        }

        // JComboBox comboBox = calculatorPanel.getComboBox();

        selectedOperation = String.valueOf(comboBox.getSelectedItem());
        if (selectedOperation.equals("/") && operand2 == 0) {
            JOptionPane.showMessageDialog(binaryPanel, "Divide by zero");
            return;
        }
        if (operand1 < operand2) {
            calc = new BinaryCalculator(operand1, operand2);
            JTextField resultDisplay = binaryPanel.getResultDisplay();
            boolean isNegative = true;
            operations(resultDisplay, resultPanel, isNegative, false, true, false, false);


        } else {
            calc = new BinaryCalculator(operand1, operand2);
            JTextField resultDisplay = binaryPanel.getResultDisplay();
            operations(resultDisplay, resultPanel, false, false, true, false, false);
        }


    }


    /**
     * Adds the gui components for binary, hex, and decimal tabs
     * Different sections of a panel are broken up into other classes
     *
     * @param panel           panel for a specific calculator, binary, hex, or decimal
     * @param label           label for a specific calculator, binary, hex, or decimal
     * @param titleLabel      title label for a specific calculator, binary, hex, or decimal
     * @param conversionLabel conversion label for what value is getting converted to decimal
     * @param valueConvLabel  converting a decimal to a value
     * @return returning the middle panel
     */
    private MiddlePanel addComponents(JPanel panel, JLabel label, JLabel titleLabel, JLabel conversionLabel, JLabel valueConvLabel) {


        panel.setLayout(new BorderLayout(8, 4));
        panel.setBackground(Color.GRAY);


        label.setForeground(Color.WHITE);


        TopPanel topPanel = new TopPanel(label);

        panel.add(topPanel, BorderLayout.NORTH);


        CalculatorPanel calculatorPanel = new CalculatorPanel();


        ResultPanel resultPanel = new ResultPanel(titleLabel, calculatorPanel.getResultDisplayText());


        MiddlePanel middlePanel = new MiddlePanel(calculatorPanel, resultPanel);


        panel.add(middlePanel, BorderLayout.WEST);

//        System.out.println(calculatorPanel.getResultText());


        return middlePanel;
    }


    /**
     * The main operations for binary, hex, and decimal calculator is done in this method
     * a switch statement determines what operation was selected and then makes calls to methods in Calculator to perform the operation
     *
     * @param resultDisplay    the text box where the result will be displayed
     * @param resultPanel      where the result will be put as a label
     * @param isNegativeBinary to determine if the first binary input is less than the second input
     * @param isNegativeHex    to determine if the first hex input is less than the second input
     * @param isBinary         if a binary calculator is being used
     * @param isHex            if a hex calculator is being used
     * @param isDec            if a decimal calculator is being used
     */
    private void operations(JTextField resultDisplay, ResultPanel resultPanel, boolean isNegativeBinary, boolean isNegativeHex, boolean isBinary, boolean isHex, boolean isDec) {
        int num = calc.num1;
        int num2 = calc.num2;
        System.out.println(num);


        switch (selectedOperation) {
            case "+" -> result = calc.add();

            case "-" -> {

                if (isNegativeBinary) {
                    calc = new BinaryCalculator(num2, num);
                    result = "-" + calc.subtract();

                    resultPanel.setAnswerLabel(result);
                    resultDisplay.setText(result);
                } else if (isNegativeHex) {
                    calc = new HexCalculator(num2, num);
                    result = "-" + calc.subtract();
                    resultPanel.setAnswerLabel(result);
                    resultDisplay.setText(result);
                } else if (!isNegativeBinary && !isNegativeHex) {
                    result = calc.subtract();
                }
            }
            case "*" -> result = calc.multiply();
            case "/" -> {
                if (isBinary) {
                    result = calc.divide() + " Remainder : " + binCalc.decimalToBinary(operand1 % operand2);
//                    result = "Decimal Value :" + operand1 + " / " + operand2 + " = " + calc.divide() + " Remainder : " + operand1%operand2;
                }
                if (isHex) {
                    result = calc.divide() + " Remainder : " + hexCalc.decimalToHex(operand1 % operand2);
                }
                if (isDec) {
                    result = calc.divide() + " Remainder : " + operand1 % operand2;

                }


            }
        }
        resultPanel.setAnswerLabel(result);

        resultDisplay.setText(result);
    }


}
