package w5.lecture.books;

import java.util.Scanner;

public class EBook extends Book {
    String url;
    String format;

    @Override
    void read(Scanner scanner) {
        super.read(scanner);
        url = scanner.next();
        format = scanner.next();
    }

    @Override
    void print() {
        super.print();
        System.out.printf("\t%s [%s]\n", url, format);
    }

    @Override
    boolean matches(String keyword) {
        if (super.matches(keyword)) {
            return true;
        }
        if (url.contains(keyword)) {
            return true;
        }
        if (format.contains(keyword)) {
            return true;
        }
        return false;
    }
}
