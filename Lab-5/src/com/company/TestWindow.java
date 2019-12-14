package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TestWindow extends JFrame {
    private JLabel labelQuest = new JLabel(" ");
    private JLabel labelTestQuest = new JLabel("");


    private JLabel labelAnsw1 = new JLabel("1. ");
    private JLabel labelAnsw2 = new JLabel("2. ");
    private JLabel labelAnsw3 = new JLabel("3. ");
    private JLabel labelAnsw4 = new JLabel("4. ");
    private JLabel labelRightAnsw = new JLabel("Номер правильного ответа");
    private JTextField inputRightAnsw = new JTextField("");

    private Question q;

    private JButton buttonAdd = new JButton("Ответить");

    TestWindow(Question question) {
        super("Тест");
        q = question;
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-400, dim.height/2-150, 800, 300);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(5, 2, 5, 20));

        labelTestQuest.setText(q.getText());

        //for(int i = 0; i<questions.size(); i++){
        String[] answers = q.getAnswers();
        labelAnsw1.setText( "1. " + answers[0]);
        labelAnsw2.setText( "2. " + answers[1]);
        labelAnsw3.setText( "3. " + answers[2]);
        labelAnsw4.setText( "4. " + answers[3]);


        container.add(labelTestQuest);
        container.add(labelQuest);

        container.add(labelAnsw1);
        container.add(labelAnsw2);
        container.add(labelAnsw3);
        container.add(labelAnsw4);

        container.add(labelRightAnsw);
        container.add(inputRightAnsw);

        buttonAdd.addActionListener(new TestWindow.ButtonAnswEventListener());
        container.add(buttonAdd);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

    }

    class ButtonAnswEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            try {
                TestedUser currentUser = (TestedUser)Main.tester.getCurrentUser();
                int rAnsw = Integer.parseInt(inputRightAnsw.getText());
                if (q.isCorrect(rAnsw)) {
                    currentUser.right();
                }
                currentUser.answ();
                Main.tester.setCurrentQuest();
                if(Main.tester.testEnd()){
                    JOptionPane.showMessageDialog(null, "Тест окончен!", "", JOptionPane.PLAIN_MESSAGE);
                    TestWindow.this.dispose();
                    return;
                }

                TestWindow testWindow = new TestWindow(Main.tester.getCurrentQuest());
                testWindow.setVisible(true);

                TestWindow.this.dispose();

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Номер правильного ответа должен быть цифрой", "Error", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

}
