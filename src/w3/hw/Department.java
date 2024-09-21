package w3.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> students = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void testData() {
        //201611012 김성관 2 010-9148-2689 88
        //201711311 김재훈 2 010-5511-1034 78
        //201710140 김원철 3 010-7757-1256 90
        //201910532 김준철 3 010-3215-1337 76
        //201910533 박우현 3 010-4855-8560 68
        //201711312 김동현 2 010-4856-8565 92
        //201710302 박태주 3 010-4856-8570 84
        //201910569 박성연 2 010-9148-2519 77
        //201810343 서민우 2 010-9124-2689 69
        //201910586 윤현주 2 010-9111-2689 80
        //201411012 이가영 3 010-7722-1256 83
        //201711170 이기원 2 010-7733-1256 92
        //201840148 이상훈 2 010-7755-1256 94
        //201711018 이종철 3 010-7788-1256 89
        String[] test = {
                "201611012 김성관 2 010-9148-2689 88",
                "201711311 김재훈 2 010-5511-1034 78",
                "201710140 김원철 3 010-7757-1256 90",
                "201910532 김준철 3 010-3215-1337 76",
                "201910533 박우현 3 010-4855-8560 68",
                "201711312 김동현 2 010-4856-8565 92",
                "201710302 박태주 3 010-4856-8570 84",
                "201910569 박성연 2 010-9148-2519 77",
                "201810343 서민우 2 010-9124-2689 69",
                "201910586 윤현주 2 010-9111-2689 80",
                "201411012 이가영 3 010-7722-1256 83",
                "201711170 이기원 2 010-7733-1256 92",
                "201840148 이상훈 2 010-7755-1256 94",
                "201711018 이종철 3 010-7788-1256 89",
        };
        for (String string : test) {
            String[] split = string.split(" ");
            students.add(
                    new Student(
                            Integer.parseInt(split[0]),
                            split[1],
                            Integer.parseInt(split[2]),
                            split[3],
                            Integer.parseInt(split[4])
                    )
            );
        }
    }

    public void myMain() {
//        readAll();
        testData();
        printAll();

        boolean exitFlag = false;
        while (true) {
            if (exitFlag) {
                break;
            }
            System.out.println("(1) 전체출력 (2) 이름검색 (3) 통합검색 (4) 점수검색 (5) 종료...");
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
                    // multi-keyword search
                    break;
                case 6:
                    System.out.println("EXIT");
                    exitFlag = true;
                    break;
            }
        }
    }

    void searchByScore() {
        scanner.nextLine();
        System.out.println("score range : ");
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
        System.out.print("Keyword : ");
        String keyword = scanner.next();
        for (Student student : students) {
            if (student.matches(keyword)) {
                student.print();
            }
        }
    }

    void searchByName() {
        System.out.print("name : ");
        String name = scanner.next();
        Student student = findByName(name);
        if (student != null) {
            student.print();
        } else {
            System.out.println("Such that name Not Found");
        }
    }

    Student findByName(String name) {
        for (Student student : students) {
            if (student.nameMatches(name)) {
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
