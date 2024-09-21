package w3.lecture;

import java.util.Random;
import java.util.Scanner;

public class Exercise3 {
    char[][] board;
    static Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        createBoard();
        printBoard();
    }

    private void createBoard() {
        int size;
        int n;
        size = scanner.nextInt();
        board = new char[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                n = random.nextInt(100);
                board[i][j] = (n < 10) ? 'O' : '.';
            }
        }
    }

    private void printBoard() {
        for (char[] chars : board) {
            System.out.println(chars);
        }
    }

    public static void main(String[] args) {
        Exercise3 e = new Exercise3();
        e.run();
    }
}
