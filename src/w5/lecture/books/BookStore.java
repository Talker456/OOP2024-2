package w5.lecture.books;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookStore {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Book> books = new ArrayList<>();

    public void run() {
        readAllBooks("book2.txt");
        printAllBooks();
        System.out.println();

        books.getFirst().print();
    }

    void readAllBooks(String fileName) {
        Scanner fileIn = openFile(fileName);
        Book book=null;
        while (fileIn.hasNext()) {
            int n = fileIn.nextInt();
            switch (n) {
                case 1: book = new Book(); break;
                case 2: book = new EBook(); break;
                default: break;
            }
            book.read(fileIn);
            books.add(book);
        }
        fileIn.close();
    }

    void printAllBooks() {
        for (Book book : books) {
            book.print();
        }
    }

    Scanner openFile(String fileName) {
        Scanner scan;
        try {
            scan = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            throw new RuntimeException(e);
        }
        return scan;
    }

    public static void main(String[] args) {
        BookStore bookStore = new BookStore();
        bookStore.run();
    }
}
