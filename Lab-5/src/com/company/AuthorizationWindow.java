package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AuthorizationWindow extends JFrame{

    private JLabel labelLogin = new JLabel("Логин: ");
    private JLabel labelPassword = new JLabel("Пароль: ");
    private JTextField inputLogin = new JTextField("");
    private JTextField inputPassword = new JTextField("");
    private JButton buttonEnter = new JButton("Вход");
    private JButton buttonRegistration = new JButton("Регистрация");

    AuthorizationWindow() {
        super("Меню авторизации");
        Dimension dim = getToolkit().getScreenSize();


        this.setBounds(dim.width/2-150, dim.height/2-150, 300, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 5, 10));

        container.add(labelLogin);
        container.add(inputLogin);
        container.add(labelPassword);
        container.add(inputPassword);

        buttonRegistration.addActionListener(new ButtonRegisterEventListener());
        buttonEnter.addActionListener(new ButtonEnterEventListener());
        container.add(buttonRegistration);
        container.add(buttonEnter);
    }

    class ButtonRegisterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            RegistrationWindow regWindow = new RegistrationWindow();
            regWindow.setVisible(true);
        }
    }

    class ButtonEnterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputLogin.getText().trim().length() > 0 && inputPassword.getText().trim().length() > 0) {
                try {
                    String login = inputLogin.getText().trim();
                    String password = inputPassword.getText().trim();

                    if (Main.tester.findUser(login, password)) {

                        if (Main.tester.getCurrentUser() instanceof Admin) {
                            AdminWindow adminWindow = new AdminWindow();
                            AuthorizationWindow.this.dispose();
                            adminWindow.setVisible(true);
                            return;
                        } else {
                            AuthorizationWindow.this.dispose();
                            UserWindow userWindow = new UserWindow();
                            userWindow.setVisible(true);
                            return;
                        }

                    }
                    JOptionPane.showMessageDialog(null, "Проверьте введённые данные.", "Error", JOptionPane.PLAIN_MESSAGE);
                } catch (Exception e1) {
                    JOptionPane.showMessageDialog(null, "Проверьте введённые данные.", "Error", JOptionPane.PLAIN_MESSAGE);
                }
            }

        }
    }
}
