package com.company;

import javax.swing.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SaveWindow extends JFrame {
    private JFileChooser fileChooser = new JFileChooser();

    SaveWindow() {

        fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooser.setMultiSelectionEnabled(false);
        fileChooser.showOpenDialog(this);

        try{
            FileOutputStream f = new FileOutputStream(fileChooser.getSelectedFile() + ".dat");
            ObjectOutputStream ser = new ObjectOutputStream(f);
            ser.writeObject(Main.tester);
            ser.close();
            SaveWindow.this.dispose();
            JOptionPane.showMessageDialog(null, "Сохранено", "", JOptionPane.PLAIN_MESSAGE);

        }

        catch (IOException exc){
            System.out.println(exc.getMessage());
            JOptionPane.showMessageDialog(null, "Ошибка", "", JOptionPane.PLAIN_MESSAGE);
        }

    }

}
