package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UserWindow extends JFrame {
    private JButton buttonTest = new JButton("Начать тест");
    private JButton buttonShow = new JButton("Показать резутьтаты теста");

    UserWindow() {
        super("Меню пользователя");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-150, dim.height/2-260, 300, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));


        container.add(buttonTest);
        buttonTest.addActionListener(new UserWindow.ButtonTestEventListener());
        buttonShow.addActionListener(new ButtonShowEventListener());
        container.add(buttonShow);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt){
                AuthorizationWindow authorizationWindow = new AuthorizationWindow();
                authorizationWindow.setVisible(true);
                UserWindow.this.dispose();
            }
        });

    }


    class ButtonTestEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                TestWindow testWindow = new TestWindow(Main.tester.getCurrentQuest());
                testWindow.setVisible(true);
            }catch (IndexOutOfBoundsException ex)
            {
                JOptionPane.showMessageDialog(null, "Вопросов ещё нет!", "", JOptionPane.PLAIN_MESSAGE);
            }


        }
    }

    class ButtonShowEventListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ShowToUserWindow showToUserWindow = new ShowToUserWindow();
            showToUserWindow.setVisible(true);
        }
    }
}
