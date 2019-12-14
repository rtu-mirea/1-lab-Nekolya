package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AdminWindow extends JFrame{
    private JButton buttonAdd = new JButton("Добавить вопрос");
    private JButton buttonShow = new JButton("Показать резутьтаты теста");
    private JButton buttonSave = new JButton("Сохранить");
    private JButton buttonLoad = new JButton("Загрузить");

    AdminWindow() {
        super("Меню администратора");
        Dimension dim = getToolkit().getScreenSize();
        this.setBounds(dim.width/2-150, dim.height/2-260, 300, 100);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 2, 2, 2));

        buttonAdd.addActionListener(new ButtonAddEventListener());
        buttonShow.addActionListener(new ButtonShowEventListener());
        buttonSave.addActionListener(new ButtonSaveEventListener());
        buttonLoad.addActionListener(new ButtonLoadEventListener());

        container.add(buttonAdd);
        container.add(buttonShow);
        container.add(buttonSave);
        container.add(buttonLoad);

        this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt){
                AuthorizationWindow authorizationWindow = new AuthorizationWindow();
                authorizationWindow.setVisible(true);
                AdminWindow.this.dispose();
            }
        });
    }
    class ButtonAddEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            AddWindow addWindow = new AddWindow();
            addWindow.setVisible(true);
        }
    }

    class ButtonShowEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            ResultWindow resultWindow = new ResultWindow();
            resultWindow.setVisible(true);
        }
    }

    class ButtonSaveEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            SaveWindow resultWindow = new SaveWindow();
            resultWindow.setVisible(true);
        }
    }

    class ButtonLoadEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            LoadWindow resultWindow = new LoadWindow();
            resultWindow.setVisible(true);
        }
    }


}
