package w2.lecture.strings;

import java.util.Scanner;

public class StringTest {
    String[] names;

    public void run() {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.next());
        names = new String[length];

        input(length, scanner);
        findLongest(length);
    }

    private void findLongest(int length) {
        String maxLengthString = names[0];
        for (int i = 1; i < length; i++) {
            if (maxLengthString.length() < names[i].length()) {
                maxLengthString = names[i];
            }
        }
        System.out.println("제일 긴 스트링 : "+maxLengthString);
    }

    private void input(int length, Scanner scanner) {
        for (int i = 0; i < length; i++) {
            String name = scanner.next();
            names[i] = name;
            System.out.printf("%s\t길이:%d\n", name, name.length());
        }
    }

    public static void main(String[] args) {
        StringTest test = new StringTest();
        test.run();
    }
}
