package com.company;

import javax.swing.*;
import java.awt.*;

public class ResultWindow extends JFrame {
    private JTextArea labelRes = new JTextArea ();
    ResultWindow() {
        super("Результаты тестирования");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-150, dim.height/2-150, 300, 400);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 1, 2, 2));

        labelRes.setText(Main.tester.getResult());
        labelRes.setEditable(false);

        container.add(labelRes);

    }
}
