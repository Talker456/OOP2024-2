package w4.lecture.exercise2;

import java.util.Scanner;

public class Lecture {

    String code;
    String name;
    int grade;
    String date;
    int time;

    Lecture(String code) {
        this.code = code;
    }

    public void read(Scanner scanner) {
        name = scanner.next();
        grade = scanner.nextInt();
        date = scanner.next();
        time = scanner.nextInt();
    }

    public void print() {
        System.out.printf("%s\t%s\t%d\t%s\t%d\n", code, name, grade, date, time);
    }
}
