package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class LoadWindow extends JFrame {
    private JFileChooser fileChooser = new JFileChooser();

    LoadWindow() {
        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogType(JFileChooser.OPEN_DIALOG);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.showOpenDialog(this);

        try {
            FileInputStream inp = new FileInputStream(fileChooser.getSelectedFile());
            ObjectInputStream ser = new ObjectInputStream(inp);
            Main.tester = (Tester) ser.readObject();
            ser.close();
            LoadWindow.this.dispose();
            JOptionPane.showMessageDialog(null, "Загружено", "", JOptionPane.PLAIN_MESSAGE);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
        }
    }
/*
    class ButtonLoadEventListener implements ActionListener {
        public void actionPerformed (ActionEvent e) {
            if (input.getText().trim().length() > 0) {
                try{
                    File f = new File(input.getText()+".dat");
                    if(!(f.exists())){
                        JOptionPane.showMessageDialog(null, "Файла с таким именем не существует", "", JOptionPane.PLAIN_MESSAGE);
                        return;
                    }
                    FileInputStream inp = new FileInputStream(input.getText() + ".dat");
                    ObjectInputStream ser = new ObjectInputStream(inp);
                    Main.tester = (Tester)ser.readObject();
                    ser.close();
                    JOptionPane.showMessageDialog(null, "Загружено", "", JOptionPane.PLAIN_MESSAGE);
                }

                catch (IOException exc){
                    System.out.println(exc.getMessage());
                    JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
                }

            }
        }*/
}