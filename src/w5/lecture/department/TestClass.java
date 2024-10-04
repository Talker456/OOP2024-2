package w5.lecture.department;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestClass {
    public static void main(String[] args) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File("students.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("fail");
            throw  new RuntimeException(e);
        }

        while (scanner.hasNext()) {
            String line = scanner.nextLine();

            System.out.println(line);
        }
    }
}
