package com.company;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    private LinkedList<DisciplineAssessment> assessments = new LinkedList<>();
    private static Scanner in = new Scanner(System.in);
    private FileManager fileManager = new FileManager();
    private SerializationManager serializationManager = new SerializationManager();

    public static void main(String[] args) {

        var main = new Main();
        try {
            main.testFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        boolean flag;
        int switcher = 0;
        while (true){
            flag = true;
            System.out.println("\nЧто нужно сделать?");
            System.out.println("1. Добавить новую оценку по дисциплине.");
            System.out.println("2. Создать файл с информацией об оценках.");
            System.out.println("3. Считать файл с информацией об оценках.");
            System.out.println("4. Показать все оценки.");
            System.out.println("5. RandomAccess.");
            System.out.println("6. Считать данные из созданного Вами файла.");
            System.out.println("7. Сериализация 1 объекта");
            System.out.println("8. Десериализация 1 объекта");
            System.out.println("9. Сериализация списка объектов");
            System.out.println("10. Десериализация списка объектов");
            System.out.println("11. Закончить работу.");

            while (flag) {
                if (in.hasNextInt()) {
                    switcher = in.nextInt();
                    flag = false;
                } else {
                    System.out.println("Вы ввели не число");
                    in.nextLine(); //чищу input buffer
                }
            }
            in.nextLine();


            switch (switcher){
                case 1:
                    main.addNewDiscAssess();
                    break;

                case 2:
                    main.createFile();
                    break;
                case 3:
                    main.readFile();
                    break;
                case 4:
                    main.showInfo();
                    break;
                case 5:
                    main.randomAccess();
                    break;
                case 6:
                    main.classTextFile();
                    main.showInfo();
                    break;
                case 7:
                    main.serializeObject();
                    break;
                case 8:
                    main.deserializeObject();
                    break;
                case 9:
                    main.serializeObjectsList();
                    break;
                case 10:
                    main.deserializeObjectsList();
                    break;
                case 11:
                    return;
            }
        }

    }

    private void deserializeObjectsList(){
        try{
            System.out.println("Введите имя файла");
            String name = in.nextLine();
            File f = new File(name+".ser");
            if(!(f.exists())){
                System.out.println("Файла с таким именем не существует");
                return;
            }
            assessments = serializationManager.readObjectsFromFile(name);
            showInfo();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void serializeObjectsList(){
        System.out.print("\nВведите название файла: ");
        String name = in.nextLine();
        serializationManager.writeObjectsToFile(name, assessments);
    }

    private void deserializeObject(){
        try{
            System.out.println("Введите имя файла");
            String name = in.nextLine();
            File f = new File(name+".dat");
            if(!(f.exists())){
                System.out.println("Файла с таким именем не существует");
                return;
            }
            System.out.println(serializationManager.readObjectFromFile(name).getInfo());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void serializeObject(){
        DisciplineAssessment a = createNewDiscAssess();
        System.out.print("\nВведите название файла: ");
        String name = in.nextLine();

        serializationManager.writeObjectToFile(name, a);
    }

    private void classTextFile(){
        System.out.println("     --------------\nВведите имя созданного файла:");
        String name = in.nextLine();
        File f = new File(name);
        if(!(f.exists())){
            System.out.println("Файла с таким именем не существует");
            return;
        }
        ClassTextFile textFile = new ClassTextFile(name);
        assessments = textFile.returnObject();
    }


    private void randomAccess(){
        System.out.println("Данные до записи и считывания:");
        for (DisciplineAssessment assessment : assessments){
            System.out.println(assessment.getInfo());
            System.out.println("       _________       ");
        }
        System.out.println("       *********       ");
        fileManager.randomAccess(assessments);
        System.out.println("Данные после записи и считывания:");
        for (DisciplineAssessment assessment : assessments){
            System.out.println(assessment.getInfo());
            System.out.println("       _________       ");
        }

        System.out.println("\nВыполнить над новым файлом операцию задания 2 из дополнительного задания варианта:");

        if (assessments.size()>1){
            System.out.println(assessments.get(0).sameDD(assessments.get(1)));
        }
        for (DisciplineAssessment assessment : assessments) {
            if (assessment.getAssessmentBy(assessment.getGradebookNumber(),assessment.getDiscipline()) != -1)
                System.out.println("\nНомер зачетки: " + assessment.getGradebookNumber() + "   Дисциплина: " + assessment.getDiscipline());
                System.out.println((assessment.getInfo()));

        }

    }



    private void showInfo(){
        for (DisciplineAssessment assessment : assessments){
            System.out.println(assessment.getInfo());
            System.out.println("       _________       ");
        }
    }

    private DisciplineAssessment createNewDiscAssess(){
        boolean markFlag = true;
        boolean gradebookNumberFlag = true;
        System.out.print("\nВведите номер зачетной книжки: ");

        int gN = 0;
        String cip;
        String disc;
        String dat;
        int assess = 0;
        String tSurname;

        while (gradebookNumberFlag) {
            if (in.hasNextInt()) {
                gN = in.nextInt();
                gradebookNumberFlag = false;
            } else {
                System.out.println("Вы ввели не число");
                in.nextLine(); //чищу input buffer
            }
        }
        in.nextLine();

        System.out.print("\nВведите шифр группы: ");
        cip = in.nextLine();
        System.out.print("\nВведите название дисциплины: ");
        disc = in.nextLine();
        System.out.print("\nВведите дату получения оценки: ");
        dat = in.nextLine();
        System.out.print("\nВведите оценку: ");

        while (markFlag) {
            if (in.hasNextInt()) {
                assess = in.nextInt();
                markFlag = false;
            } else {
                System.out.println("Вы ввели не число");
                in.nextLine(); //чищу input buffer
            }
        }
        in.nextLine();

        System.out.print("\nВведите фамилию преподавателя: ");
        tSurname = in.nextLine();
        DisciplineAssessment a = new DisciplineAssessment(gN, cip, disc, dat, assess, tSurname);
        return a;
    }

    private void addNewDiscAssess(){
        DisciplineAssessment a = createNewDiscAssess();
        assessments.add(a);
        System.out.println(a.getInfo());
    }

    private void createFile(){
        System.out.print("\nВведите название файла: ");
        String name = in.nextLine();
        if (fileManager.checkFile(name)){
            System.out.println("Такой файл уже существует!");
            return;
        }

        if (fileManager.writeObjectsToFile(name, assessments))
            System.out.println("Файл успешно создан");
        else
            System.out.println("Ошибка создания");

    }


    private void readFile(){
        System.out.print("\nВведите название файла: ");
        String name = in.nextLine();
        if (!fileManager.checkFile(name)){
            System.out.println("Такого файла не существует!");
            return;
        }

        if (fileManager.readObjectsFromFile(name, assessments))
            System.out.println("Файл успешно считан");
        else
            System.out.println("Ошибка");

    }

////////////////////////////ex1///////////////////////////////////////////
    private void testFile()throws IOException {
        //создание файла в корневой папке
        File F1=new File("MyFile1.txt");
        F1.createNewFile();
        //создание файла на диске
        File F2=new File("C:\\labs\\MyFile2.txt");
        F2.createNewFile();
        File F3=new File("C:\\labs\\Первая\\Вторая\\Третья");
        F3.mkdirs();

    }
    ////////////////////////////ex3///////////////////////////////////////////
    public static void copy(String path1, String path2) {
        String data = "";
        try {
            FileInputStream fileInputStream = new FileInputStream(path1);
            int byteReader;
            while ((byteReader = fileInputStream.read()) != -1) {
                data += (char) byteReader;
            }
            FileOutputStream file = new FileOutputStream(path2);
            file.write(data.getBytes());
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void buffCopy(String path1, String path2){
        try{
            BufferedReader inBuffer = new BufferedReader(new FileReader(path1), 128);
            BufferedWriter outBuffer = new BufferedWriter(new FileWriter(path2), 128);
            char [] buf = new char[128];
            while (inBuffer.read(buf) != -1){
                outBuffer.write(buf);
            }
            inBuffer.close();
            outBuffer.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    public static void readUTFFile(String path){
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "Cp1251"));
            String str;
            System.out.println(Charset.defaultCharset().name());
            while ((str = in.readLine()) != null){
                System.out.println(str);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
