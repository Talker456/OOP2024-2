package w2.hw;

import java.util.Scanner;

public class DepartmentLegacy {
    public void myMain() {
        Scanner scanner = new Scanner(System.in);
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

            System.out.println("continue? ");
            String exitFlag = scanner.next();
            if (exitFlag.equals("n")) {
                System.out.println("Bye");
                break;
            }

            int subjectNumber = scanner.nextInt();
            System.out.println(nStudents + "명 점수입력");
            IntArray intArray = new IntArray(nStudents);
            intArray.generate(0, 100);
            for (int number : intArray.numbers) {
                System.out.print(number+" ");
            }

            System.out.println("Apply? ");
            String applyFlag = scanner.next();

            if (applyFlag.equals("y")) {
                System.out.println("(1) 점수 그대로 반영   (2) 높은 점수 반영");
                int selectedMenu = scanner.nextInt();
                switch (selectedMenu) {
                    case 1:
                        for (int i = 0; i < nStudents; i++) {
                            students[i].setScore(subjectNumber-1,intArray.numbers[i]);
                        }
                        break;
                    case 2:
                        for (int i = 0; i < nStudents; i++) {
                            students[i].setComparedScore(subjectNumber-1,intArray.numbers[i]);
                        }
                        break;
                    default:
                        break;
                }
            } else if (applyFlag.equals("n")) {
                System.out.print("메뉴 선택 (1)점수 조정    (2)다시 생성  (3)취소/종료");
                int selectedMenu = scanner.nextInt();
                switch (selectedMenu) {
                    case 1:

                        break;

                    case 2:

                        break;

                    case 3:
                        System.out.println("점수 수정 취소");
                        break;
                    default:
                        break;
                }
            } else {
                System.out.println("INPUT ONLY Y OR N");
            }

        }
    }

    public static void main(String[] args) {
        DepartmentLegacy department = new DepartmentLegacy();
        department.myMain();
    }
}
