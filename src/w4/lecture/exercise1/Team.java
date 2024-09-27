package w4.lecture.exercise1;

import java.util.ArrayList;
import java.util.Scanner;

public class Team {
    String name;
    ArrayList<Student> members = new ArrayList<>();

    Team(String name) {
        this.name = name;
    }

    void read(Scanner scan,Department department) {
        int studentNumber;
        while (true) {
            studentNumber = scan.nextInt();
            if (studentNumber == 0)
                break;
            Student student = department.findStudent(studentNumber);
            members.add(student);
            student.setTeam(this);
        }
    }

    void print() {
        System.out.printf("%s :",name);
        for (Student student : members) {
            System.out.printf(" %s",student.name);
        }
        System.out.println();
    }
}
