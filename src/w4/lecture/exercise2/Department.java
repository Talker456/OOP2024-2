package w4.lecture.exercise2;


import java.util.ArrayList;
import java.util.Scanner;

public class Department {
    ArrayList<Student> studentList = new ArrayList<>();
    ArrayList<Lecture> lectureList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void myMain() {
        readAllLectures();
        readAllStudents();
        printAllStudents();
    }

    void readAllLectures() {
        String code = null;
        while (true) {
            code = scanner.next();
            if (code.equals("end")) {
                break;
            }
            Lecture lecture = new Lecture(code);
            lecture.read(scanner);
            lectureList.add(lecture);
        }
    }

    void readAllStudents() {
        String line;
        while (true) {
            line = scanner.next();
            if (line.equals("0")) {
                break;
            }
            Student student = new Student(Integer.parseInt(line));
            student.read(scanner,this);
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


    public Lecture findLecture(String code) {
        for (Lecture lecture : lectureList) {
            if (lecture.code.equals(code)) {
                return lecture;
            }
        }
        return null;
    }

}
