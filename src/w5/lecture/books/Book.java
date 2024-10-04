package w5.lecture.books;

import java.util.ArrayList;
import java.util.Scanner;

public class Book {
    String title;
    String pub;
    String isbn;
    int year;
    int price;
    ArrayList<String> authors = new ArrayList<>();

    void read(Scanner scanner) {
        title = scanner.next();
        pub = scanner.next();
        isbn = scanner.next();
        year = scanner.nextInt();
//        scanner.nextLine(); // consume newline

        String author;
        while (true) {
            author = scanner.next();
            if (author.equals("0")) {
                break;
            }
            authors.add(author);
        }
        price = scanner.nextInt();
    }

    void print() {
        System.out.printf("%s(%s %s %d년)[%d원] 저자 ",title,pub,isbn,year,price);
        for (String author : authors) {
            System.out.printf("%s ",author);
        }
        System.out.println();
    }

    boolean matches(String keyword) {
        if (title.contains(keyword)) {
            return true;
        }
        if (pub.contains(keyword)) {
            return true;
        }
        if (isbn.contains(keyword)) {
            return true;
        }
        if ((year + "").equals(keyword)) {
            return true;
        }
        if ((price + "").equals(keyword)) {
            return true;
        }
        return false;

    }
}
