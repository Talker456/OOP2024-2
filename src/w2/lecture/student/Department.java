package w2.lecture.student;

import java.util.Scanner;

public class Department {
    Scanner scanner = new Scanner(System.in);
    Student[] studentList;

    public void run() {
        System.out.print("학생 수 :");
        int size = scanner.nextInt();
        studentList = new Student[size];

        for (int i = 0; i < size; i++) {
            studentList[i] = new Student();
            studentList[i].read(scanner);
        }

        for (Student student : studentList) {
            student.print();
        }
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.run();
    }
}
