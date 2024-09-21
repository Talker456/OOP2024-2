package w2.hw;

import java.util.Scanner;

public class Student {
    int id;
    String name;
    int year;
    int[] score = new int[3];
    char[] grade = new char[3];
    static int[] Steps = {90, 80, 70, 60, 50};
    static char[] Grade = {'A', 'B', 'C', 'D', 'E'};

    public void read(Scanner scanner) {
        id = scanner.nextInt();
        name = scanner.next();
        year = scanner.nextInt();
        for (int i = 0; i < score.length; i++) {
            score[i] = scanner.nextInt();
        }
    }

    public void print() {
        System.out.printf("%d\t%s(%d학년)\t", id, name, year);
        for (int i = 0; i < score.length; i++) {
            System.out.printf("%d(%c) ", score[i], grade[i]);
        }
        System.out.println();
    }

    public void calculateGrade() {
        for (int i = 0; i < 3; i++) {
            int current = score[i];
            for (int j = 0; j < Steps.length; j++) {
                if (current >= Steps[j]) {
                    grade[i] = Grade[j];
                    break;
                }
                grade[i] = 'F';
            }
        }
    }

    public void setScore(int subject,int score) {
        this.score[subject] = score;
    }

    public void setComparedScore(int subject, int compared) {
        this.score[subject] = Integer.max(this.score[subject], compared);
    }

}
