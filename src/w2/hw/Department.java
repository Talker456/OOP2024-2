package w2.hw;

import java.util.Scanner;

public class Department {
    Scanner scanner = new Scanner(System.in);
    public void myMain() {
        System.out.print("학생 수: ");
        int nStudents = scanner.nextInt();
        Student[] students = new Student[nStudents];

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student();
            students[i].read(scanner);
        }

        for (Student student : students) {
            student.calculateGrade();
        }

        for (Student student : students) {
            student.print();
        }

        while (true) {
            System.out.print("계속하시겠습니까?(y/n) ");
            char continueFlag = scanner.next().charAt(0);
            if (continueFlag == 'n') {
                break;
            }
            System.out.print("과목선택 1)국어 2)영어 3)수학 ");
            int subjectNumber = scanner.nextInt();

            getRandomArray(students,nStudents,subjectNumber);
        }
    }

    private void getRandomArray(Student[] students, int nStudents, int subjectNumber) {
        System.out.println(students.length+"명 점수입력..");
        IntArray intArray = new IntArray(nStudents);
        intArray.generate(0, 100);
        for (int number : intArray.numbers) {
            System.out.print(number+" ");
        }
        System.out.println();
        checkApply(students, intArray,subjectNumber);
    }

    public void checkApply(Student[] students, IntArray intArray, int subjectNumber) {
        System.out.print("반영하시겠습니까? (y/n)");
        char menu = scanner.next().charAt(0);
        switch (menu) {
            case 'y':
                applyScore(students, intArray, subjectNumber);
                break;
            case 'n':
                notApplyScore(students, intArray, subjectNumber);
                break;
            default:
                System.out.println("wrong character");
                break;
        }
    }

    public void applyScore(Student[] students, IntArray intArray, int subjectNumber) {
        System.out.print("메뉴선택 1)점수 그대로 반영  2)큰 점수 반영 ");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                for (int i = 0; i < students.length; i++) {
                    students[i].setScore(subjectNumber - 1, intArray.numbers[i]);
                }
                for (Student student : students) {
                    student.calculateGrade();
                }
                for (Student student : students) {
                    student.print();
                }
                break;
            case 2:
                for (int i = 0; i < students.length; i++) {
                    students[i].setComparedScore(subjectNumber - 1, intArray.numbers[i]);
                }
                for (Student student : students) {
                    student.calculateGrade();
                }
                for (Student student : students) {
                    student.print();
                }
                break;
            default:
                System.out.println("잘못된 메뉴");
                break;
        }
    }

    public void notApplyScore(Student[] students, IntArray intArray, int subjectNumber) {
        System.out.print("메뉴선택 1)점수 조정  2)다시 생성     3)취소/종료");
        int menu = scanner.nextInt();
        switch (menu) {
            case 1:
                System.out.print("점수 최소값 , 최댓값 : ");
                int lower = scanner.nextInt();
                int upper = scanner.nextInt();
                intArray.adjust(lower, upper);
                intArray.print();
                checkApply(students, intArray, subjectNumber);
                break;
            case 2:
                getRandomArray(students,students.length,subjectNumber);
                break;
            case 3:
                System.out.println("점수 수정 취소");
                break;
            default:
                System.out.println("잘못된 메뉴");
                break;
        }
    }

    public static void main(String[] args) {
        Department department = new Department();
        department.myMain();
    }
}
