package w4.lecture.exercise1;


import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Team> teamList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void myMain() {
        readAllStudents();
        readAllTeams();
        printAllStudents();
        printAllTeams();
    }

    void readAllTeams() {
        Team t;
        String name;
        while (true) {
            name = scanner.next();
            if (name.equals("0")) {
                break;
            }
            t = new Team(name);
            t.read(scanner,this);
            teamList.add(t);
        }
    }

    void printAllTeams() {
        for (Team team : teamList) {
            team.print();
        }
    }

    void searchCycle() {
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
                    printAllStudents();
                    break;
                case 2:
                    searchByName();
                    break;
                case 3:
                    searchByKeyword();
                    break;
                case 4:
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
        System.out.print("멀티키워드 : ");
        String keywords = scanner.nextLine();
        String[] keywordArray = keywords.split(" ");
        for (Student student : studentList) {
            if (student.matches(keywordArray)) {
                student.print();
            }
        }
    }

    void searchByKeyword() {
        scanner.nextLine();
        System.out.print("검색 키워드 : ");
        String keyword = scanner.next();
        for (Student student : studentList) {
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
        for (Student student : studentList) {
            if (student.matchesName(name)) {
                return student;
            }
        }
        return null;
    }

    void readAllStudents() {
        String line;
        while (true) {
            line = scanner.next();
            if (line.equals("0")) {
                break;
            }
            Student student = new Student(Integer.parseInt(line));
            student.read(scanner);
            studentList.add(student);
        }
    }

    void printAllStudents() {
        for (Student student : studentList) {
            student.print();
        }
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.myMain();
    }

    public Student findStudent(Integer member) {
        for (Student student : studentList) {
            if (student.matchesById(member)) {
                return student;
            }
        }
        return null;
    }
}
