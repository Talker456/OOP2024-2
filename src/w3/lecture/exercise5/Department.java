package w3.lecture.exercise5;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    Scanner scan = new Scanner(System.in);
    ArrayList<Student> stList = new ArrayList<>();
    public void run() {
        readAll();
        printAll();
    }

    void updateScores() {
        String name;
        while (true) {
            name = scan.next();
            if (name.equals("end")) {
                break;
            }
            Student st = findStudent(name);
            if (st != null) {
                st.updateScore(scan);
            }
        }
    }

    void search() {
        String name = null;
        while (true) {
            System.out.print("name : ");
            name = scan.next();
            if (name.equals("end")) {
                break;
            }
            Student student = findStudent(name);
            if (student != null) {
                student.print();
            } else {
                System.out.println("Not Found");
            }
        }
    }

    Student findStudent(String name) {
        for (Student student : stList) {
            if (student.matches(name)) {
                return student;
            }
        }
        return null;
    }

    void readAll() {
        int id;
        while (true) {
            id = scan.nextInt();
            if (id==0) {
                break;
            }
            Student st = new Student(id);
            st.readWithoutId(scan);
            stList.add(st);

        }
    }
    void printAll() {
        for (Student st : stList) {
            st.print();
        }
    }

    public static void main(String[] args) {
        Department department0 = new Department();
        department0.run();
    }
}
