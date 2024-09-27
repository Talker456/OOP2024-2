package w4.lecture.exercise2;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
    private int id;
    String name;
    private int year;
    private String telephone;
    ArrayList<Lecture> registeredList = new ArrayList<>();

    public Student (){}

    public Student(int id) {
        this.id = id;
    }


    public void read(Scanner scanner,Department department) {
        name = scanner.next();
        telephone = scanner.next();
        year = scanner.nextInt();

        String code = null;
        while (true) {
            code = scanner.next();
            if (code.equals("0")) {
                break;
            }
            Lecture lecture = department.findLecture(code);
            registeredList.add(lecture);
        }
    }

    public void print() {
        System.out.printf("%d %s %s (%d학년) \n", id, name, telephone, year);
        for (Lecture lecture : registeredList) {
            System.out.print("\t");
            lecture.print();
        }
        System.out.println();
    }

}
