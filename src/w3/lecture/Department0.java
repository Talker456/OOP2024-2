package w3.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Department0 {
    Scanner scan = new Scanner(System.in);
    ArrayList<Student> stList = new ArrayList<>();
    public void run() {
        readAll();
        printAll();
        search();
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
        Department0 department0 = new Department0();
        department0.run();
    }
}
