package com.company;

import java.io.*;
import java.util.LinkedList;

public class FileManager {

    public boolean writeObjectsToFile(String fileName, LinkedList<DisciplineAssessment> disciplineAssessment){
        try{
            FileOutputStream f = new FileOutputStream(fileName);
            DataOutputStream write = new DataOutputStream(f);
            write.writeInt(disciplineAssessment.size());
            for (DisciplineAssessment assessment : disciplineAssessment) {
                write.writeInt(assessment.getGradebookNumber());
                write.writeUTF(assessment.getCipher());
                write.writeUTF(assessment.getDiscipline());
                write.writeUTF(assessment.getDate());
                write.writeInt(assessment.getAssessment());
                write.writeUTF(assessment.getTeacherSurname());
            }
            write.flush();
            write.close();
            return true;
        }

        catch (IOException exc){
            System.out.println(exc.getMessage());
            return false;
        }
    }

    public boolean readObjectsFromFile(String fileName, LinkedList<DisciplineAssessment> disciplineAssessment){
        try(DataInputStream read = new DataInputStream(new FileInputStream(fileName))){
            int len = read.readInt();
            disciplineAssessment.clear();
            for(int i = 0; i < len; i++){
                DisciplineAssessment d = new DisciplineAssessment(
                        read.readInt(),
                        read.readUTF(),
                        read.readUTF(),
                        read.readUTF(),
                        read.readInt(),
                        read.readUTF());
                disciplineAssessment.add(d);
            }
            return true;
        }
        catch (IOException exc){
            System.out.println(exc.getMessage());
            return false;
        }
    }

    public boolean randomAccess(LinkedList<DisciplineAssessment> assessments){
        try {
            RandomAccessFile rf = new RandomAccessFile("FileForRandomAccess.txt", "rw");
            int buf = assessments.size();
            for(DisciplineAssessment assessment: assessments){
                assessment.increaseLength();
                rf.writeInt(assessment.getGradebookNumber());
                rf.writeUTF(assessment.getCipher());
                rf.writeUTF(assessment.getDiscipline());
                rf.writeUTF(assessment.getDate());
                rf.writeInt(assessment.getAssessment());
                rf.writeUTF(assessment.getTeacherSurname());
            }

            assessments.clear();
            rf.seek(0);
            for(int i = 0; i < buf; i++){
                DisciplineAssessment d = new DisciplineAssessment(
                        rf.readInt(),
                        rf.readUTF(),
                        rf.readUTF(),
                        rf.readUTF(),
                        rf.readInt(),
                        rf.readUTF());
                assessments.add(d);
            }
            return true;
        }catch (IOException exc){
            System.out.println(exc.getMessage());
            return false;
        }
    }

    public boolean checkFile(String name){
        File f = new File(name);
        if(f.exists())
            return true;
        return false;
    }
}
