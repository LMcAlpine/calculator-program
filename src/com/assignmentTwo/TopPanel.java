package com.assignmentTwo;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Class for the TopPanel
 */
public class TopPanel extends JPanel {
    JLabel label;

    /** The constructor for the TopPanel
     * @param label label to set
     */
    public TopPanel(JLabel label) {
        this.label = label;
        setup();
    }

    /**
     * setup method
     */
    private void setup() {

        setBorder(new LineBorder(Color.BLACK, 3));
        setBackground(Color.GRAY);
        setLayout(new FlowLayout(5));

        add(label);
    }


}
