package com.company;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class ClassTextFile {
    private String path;

    ClassTextFile (String p){
        path = p;
    }

    public LinkedList<DisciplineAssessment> returnObject(){
        try {
            Scanner scanner = new Scanner(new File(path));
            LinkedList<DisciplineAssessment> list = new LinkedList<>();

            while (scanner.hasNextLine()) {
                int n = scanner.nextInt();
                scanner.nextLine(); //нужно пропускать остаток строки(\n)
                String ch = scanner.nextLine();
                String ds = scanner.nextLine();
                String dat = scanner.nextLine();
                int mark = scanner.nextInt();
                scanner.nextLine();
                String fam = scanner.nextLine();

                DisciplineAssessment d = new DisciplineAssessment(n, ch, ds, dat, mark, fam);
                list.add(d);
            }
            scanner.close();
            return list;
        }catch (IOException exc){
            System.out.println(exc.getMessage());
            return new LinkedList<>();
        }
    }

}
