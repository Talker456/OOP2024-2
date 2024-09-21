package w2.lecture.strings;

import java.util.Scanner;

public class StringTestSolution {
    String strArray[];
    Scanner scanner = new Scanner(System.in);

    public void run() {
        int size;
        System.out.println("size : ");
        size = scanner.nextInt();
        strArray = new String[size];
        for (int i = 0; i < size; i++) {
            strArray[i] = scanner.next();
        }
        String max = "";
        for (String string : strArray) {
            if (max.length() < string.length()) {
                max = string;
            }
        }
        for (String string : strArray) {
            System.out.println(string+", "+string.length());
        }
        System.out.println(max);
    }

    public static void main(String[] args) {
        StringTestSolution stringTestSolution = new StringTestSolution();
        stringTestSolution.run();
    }
}
