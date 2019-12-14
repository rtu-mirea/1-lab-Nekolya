package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWindow extends JFrame {
    private JLabel labelQuest = new JLabel("Вопрос: ");
    private JTextField inputQuest = new JTextField("");

    private JLabel labelAnsw1 = new JLabel("Ответ 1");
    private JLabel labelAnsw2 = new JLabel("Ответ 2");
    private JLabel labelAnsw3 = new JLabel("Ответ 3");
    private JLabel labelAnsw4 = new JLabel("Ответ 4");
    private JLabel labelRightAnsw = new JLabel("Номер правильного ответа");

    private JTextField inputAnsw1 = new JTextField("");
    private JTextField inputAnsw2 = new JTextField("");
    private JTextField inputAnsw3 = new JTextField("");
    private JTextField inputAnsw4 = new JTextField("");
    private JTextField inputRightAnsw = new JTextField("");

    private JButton buttonAdd = new JButton("Добавить вопрос");

    AddWindow() {
        super("Добавление вопроса");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-250, dim.height/2-150, 500, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(7, 2, 5, 10));

        container.add(labelQuest);
        container.add(inputQuest);

        container.add(labelAnsw1);
        container.add(inputAnsw1);
        container.add(labelAnsw2);
        container.add(inputAnsw2);
        container.add(labelAnsw3);
        container.add(inputAnsw3);
        container.add(labelAnsw4);
        container.add(inputAnsw4);

        container.add(labelRightAnsw);
        container.add(inputRightAnsw);


        buttonAdd.addActionListener(new AddWindow.ButtonAddEventListener());
        container.add(buttonAdd);
    }

    class ButtonAddEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputAnsw1.getText().trim().length() > 0 && inputAnsw2.getText().trim().length() > 0 && inputQuest.getText().trim().length() > 0) {
                try {
                    String[] answ = new String[]{inputAnsw1.getText(), inputAnsw2.getText(), inputAnsw3.getText(), inputAnsw4.getText()};
                    Main.tester.addQuestion(new Question(inputQuest.getText(), answ, Integer.parseInt(inputRightAnsw.getText())));
                    JOptionPane.showMessageDialog(null, "Вопрос добавлен!", "", JOptionPane.PLAIN_MESSAGE);
                    AddWindow.this.dispose();
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Номер правильного ответа должен быть цифрой", "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }
    }
}