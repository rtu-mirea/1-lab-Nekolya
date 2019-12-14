package com.company;

import javax.swing.*;
import java.awt.*;

public class ShowToUserWindow extends JFrame {
    private JLabel labelRes = new JLabel(" ");

    ShowToUserWindow() {
        super("Результаты теста");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width / 2 - 150, dim.height / 2 - 150, 350, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(1, 2, 2, 2));

        labelRes.setText(Main.tester.getCurrentUserResult());
        container.add(labelRes);
    }
}
