package com.company;

import java.io.*;
import java.util.LinkedList;

public class SerializationManager {


    public boolean writeObjectToFile(String fileName, DisciplineAssessment d){
        try{
            FileOutputStream f = new FileOutputStream(fileName+".dat");
            ObjectOutputStream ser = new ObjectOutputStream(f);
            ser.writeObject(d);
            ser.close();
            return true;
        }

        catch (IOException exc){
            System.out.println(exc.getMessage());
            return false;
        }
    }

    public boolean writeObjectsToFile(String fileName, LinkedList<DisciplineAssessment> disciplineAssessments){
        try{
            FileOutputStream f = new FileOutputStream(fileName+".ser");
            ObjectOutputStream ser = new ObjectOutputStream(f);
            ser.writeObject(disciplineAssessments);
            ser.close();
            return true;
        }

        catch (IOException exc){
            System.out.println(exc.getMessage());
            return false;
        }
    }

    public DisciplineAssessment readObjectFromFile(String fileName) throws IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream(fileName+".dat");
        ObjectInputStream ser = new ObjectInputStream(f);
        DisciplineAssessment p = (DisciplineAssessment)ser.readObject();
        ser.close();
        return p;
    }

    public LinkedList<DisciplineAssessment> readObjectsFromFile(String fileName) throws IOException, ClassNotFoundException {
        ObjectInputStream ser = new ObjectInputStream(new FileInputStream(fileName+".ser"));
        LinkedList<DisciplineAssessment> l;
        l = (LinkedList<DisciplineAssessment>)ser.readObject();
        ser.close();
        return l;
    }

}
