package w3.hw;

import java.util.Scanner;

public class Student {
    private int id;
    private String name;
    private int grade;
    private String telephone;
    private int score;

    public Student (){}

    public Student(int id) {
        this.id = id;
    }

    public void read(Scanner scanner) {
        name = scanner.next();
        grade = scanner.nextInt();
        telephone = scanner.next();
        score = scanner.nextInt();
    }

    public void print() {
        System.out.printf("%d %s (%d학년) %s - %d\n", id, name, grade, telephone, score);
    }

    public boolean isInRange(int min, int max) {
        return (min <= score) && (score < max);
    }

    public boolean matchesName(String name) {
        return this.name.equals(name);
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

    public boolean matches(String[] keywords) {
        for (String keyword : keywords) {
            if (keyword.startsWith("-")) {
                keyword = keyword.substring(1);
                if (matches(keyword)) {
                    return false;
                }
            }else{
                if (!matches(keyword)) {
                    return false;
                }
            }
        }
        return true;
    }

}
