package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationWindow extends JFrame {
    private JLabel labelName = new JLabel("Имя: ");
    private JLabel labelLogin = new JLabel("Логин: ");
    private JLabel labelPassword = new JLabel("Пароль: ");
    private JTextField inputName = new JTextField("");
    private JTextField inputLogin = new JTextField("");
    private JTextField inputPassword = new JTextField("");
    private JButton buttonRegistration = new JButton("Регистрация");

    RegistrationWindow() {
        super("Меню регистрации");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-150, dim.height/2-150, 300, 150);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 2, 5, 10));

        container.add(labelName);
        container.add(inputName);
        container.add(labelLogin);
        container.add(inputLogin);
        container.add(labelPassword);
        container.add(inputPassword);

        buttonRegistration.addActionListener(new ButtonRegisterEventListener());
        container.add(buttonRegistration);
    }

    class ButtonRegisterEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (inputName.getText().trim().length() > 0 && inputLogin.getText().trim().length() > 0 && inputPassword.getText().trim().length() > 0)
                if (Main.tester.findUser(inputLogin.getText(), inputPassword.getText()))
                    JOptionPane.showMessageDialog(null, "Пользователь уже зарегистрирован.", "Error", JOptionPane.PLAIN_MESSAGE);
                else{
                    JOptionPane.showMessageDialog(null, "Регистрация прошла успешно, " + inputName.getText() + "!", "", JOptionPane.PLAIN_MESSAGE);
                    Main.tester.addUser(inputName.getText(), inputLogin.getText(), inputPassword.getText());
                    RegistrationWindow.this.dispose();
                }

        }

    }
}