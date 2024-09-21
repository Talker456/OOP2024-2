package w3.hw;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int grade;
    private String telephone;
    private int score;

    // Just For testing, deprecate before submitting
    public Student(int id, String name, int grade, String phone, int score) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.telephone = phone;
        this.score = score;
    }

    public Student (){}

    public Student(int id) {
        this.id = id;
    }

    public void read(Scanner scanner) {
//        id = scanner.nextInt();
        name = scanner.next();
        grade = scanner.nextInt();
        telephone = scanner.next();
        score = scanner.nextInt();
    }

    public void print() {
        System.out.printf("%d %s (%d학년) %s - %d\n", id, name, grade, telephone, score);
    }

    public boolean nameMatches(String keyword) {
        return name.equals(keyword);
    }

    public boolean isInRange(int min, int max) {
        return (min <= score) && (score < max);
    }

    public boolean matches(String keyword) {
        if (name.contains(keyword)) {
            return true;
        }
        if (keyword.length()>=4 && (id+"").contains(keyword)) {
            return true;
        }
        if (keyword.length() >= 4 && telephone.contains(keyword)) {
            return true;
        }
        if (keyword.length() < 4 && (grade + "").contains(keyword)) {
            return true;
        }
        return false;
    }
}
