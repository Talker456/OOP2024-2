package w1.hw;

import java.util.Scanner;

public class MyClass_1 {
    void myMain() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("크기를 입력하세요...");
            int size = scanner.nextInt();
            if (size == 0) {
                System.out.println("안녕히 가세요..");
                break;
            }

            drawFullSquare(size);
            drawEmptySquare(size);
            drawFullTriangle(size);
            drawEmptyTriangle(size);

            System.out.print("가로 세로 박스 수: ");
            int width = scanner.nextInt();
            int height = scanner.nextInt();
            for (int i = 0; i < height; i++) {
                repeatEmptySquare(width,size);
            }
        }
    }

    public void drawFullSquare(int size) {
        for (int i = 0; i < size; i++) {
            drawFullLine(size);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    public void drawEmptySquare(int size) {
        if (size==1){
            System.out.println("*");
            System.out.print("\n");
            return;
        }

        drawFullLine(size);
        System.out.print("\n");
        for (int i = 1; i < size - 1; i++) {
            drawEmptyLine(size);
            System.out.print("\n");
        }
        drawFullLine(size);
        System.out.print("\n");

        System.out.print("\n");
    }

    public void drawFullTriangle(int size) {
        for (int i = 0; i < size; i++) {
            drawFullTriangleLine(size-i-1, 1+2*i);
        }
        System.out.print("\n");
    }

    public void drawEmptyTriangle(int size) {
        if (size == 1) {
            System.out.println("*");
            System.out.print("\n");
            return;
        }

        drawFullTriangleLine(size - 1, 1);
        for (int i = 1; i < size - 1; i++) {
            drawEmptyTriangleLine(size - i - 1, 1 + 2 * i);
        }
        drawFullTriangleLine(0, size*2-1);
    }

    public void repeatEmptySquare(int width, int size) {
        if (size == 1) {
            for (int i = 0; i < width; i++) {
                System.out.print("* ");
            }
            System.out.print("\n");

            System.out.print("\n");
            return;
        }

        for (int i = 0; i < width; i++) {
            drawFullLine(size);
            System.out.print(" ");
        }
        System.out.print("\n");

        for (int i = 1; i < size-1; i++) {
            for (int j = 0; j < width; j++) {
                drawEmptyLine(size);
                System.out.print(" ");
            }
            System.out.print("\n");
        }

        for (int i = 0; i < width; i++) {
            drawFullLine(size);
            System.out.print(" ");
        }
        System.out.print("\n");

        System.out.print("\n");
    }

    public void drawFullLine(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
    }

    public void drawEmptyLine(int size) {
        System.out.print("*");
        for (int i = 1; i < size - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
    }

    public void drawFullTriangleLine(int indent,int stars) {
        indent(indent);
        for (int i = 0; i < stars; i++) {
            System.out.print("*");
        }
        indent(indent);
        System.out.print("\n");
    }

    public void drawEmptyTriangleLine(int indent, int stars) {
        indent(indent);
        System.out.print("*");
        indent(stars - 2);
        System.out.print("*");
        indent(indent);
        System.out.print("\n");
    }

    public void indent(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(" ");
        }
    }

    public static void main(String[] args) {
        MyClass_1 my = new MyClass_1();
        my.myMain();
    }
}