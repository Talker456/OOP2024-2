package w3.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void myMain() {
        readAll();
        printAll();

        boolean exitFlag = false;
        while (true) {
            if (exitFlag) {
                break;
            }
            System.out.print("(1) 전체출력 (2) 이름검색 (3) 통합검색" +
                            " (4) 점수검색 (5) 멀티키워드검색 (6)종료...");
            int select = scanner.nextInt();
            switch (select) {
                case 1:
                    printAll();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByKeyword();
                    break;
                case 4:
                    searchByScore();
                    break;
                case 5:
                    searchByMultipleKeywords();
                    break;
                case 6:
                    System.out.println("종료");
                    exitFlag = true;
                    break;
            }
        }
    }

    void searchByMultipleKeywords() {
        scanner.nextLine();
        String keywords = scanner.nextLine();
        String[] keywordArray = keywords.split(" ");
        for (Student student : students) {
            if (student.matches(keywordArray)) {
                student.print();
            }
        }
    }

    void searchByScore() {
        scanner.nextLine();
        System.out.println("점수 범위 입력 : ");
        String range = scanner.nextLine();
        String[] scores = range.split(" ");
        int min = scores[0].equals("-") ? 0 : Integer.parseInt(scores[0]);
        int max = scores[1].equals("-") ? 101 : Integer.parseInt(scores[1]);

        for (Student student : students) {
            if (student.isInRange(min, max)) {
                student.print();
            }
        }
    }

    void searchByKeyword() {
        scanner.nextLine();
        System.out.print("검색 키워드 : ");
        String keyword = scanner.next();
        for (Student student : students) {
            if (student.matches(keyword)) {
                student.print();
            }
        }
    }

    void searchByName() {
        System.out.print("이름 : ");
        String name = scanner.next();
        Student student = findByName(name);
        if (student != null) {
            student.print();
        } else {
            System.out.println("없는 이름");
        }
    }

    Student findByName(String name) {
        for (Student student : students) {
            if (student.matches(name)) {
                return student;
            }
        }
        return null;
    }

    void readAll() {
        String line;
        while (true) {
            line = scanner.next();
            if (line.equals("0")) {
                break;
            }
            Student student = new Student(Integer.parseInt(line));
            student.read(scanner);
            students.add(student);
        }
    }

    void printAll() {
        for (Student student : students) {
            student.print();
        }
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.myMain();
    }
}
