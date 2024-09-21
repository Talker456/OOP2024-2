package w2.lecture.student;

import java.util.Scanner;

public class Student {
    String name;
    int year;
    int score;

    public void read(Scanner scanner) {
        name = scanner.next();
        year = scanner.nextInt();
        score = scanner.nextInt();
    }

    public void print() {
        System.out.printf("%s %d학년 %d점\n", name, year, score);
    }
}
