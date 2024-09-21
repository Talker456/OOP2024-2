package w1.hw;



public class IterationTemp {
    public static void main(String[] args) {
        int width=5;
        int height=3;
        int size =4;

        for (int i = 0; i < height; i++) {
            drawEmptySquares(width, size);
            System.out.print("\n");
        }
    }

    public static void drawEmptySquares(int width, int size) {
        // draw (width)s full line units
        for (int i = 0; i < width; i++) {
            drawFullLineUnit(size);
        }
        System.out.print("\n");

        // then draw (width)s empty line units (size-2) times

        for (int i = 1; i < size-1; i++) {
            for (int j = 0; j < width; j++) {
                drawEmptyLineUnit(size);
            }
            System.out.print("\n");
        }
//        System.out.print("\n");


        // finally draw (width)s full line units
        for (int i = 0; i < width; i++) {
            drawFullLineUnit(size);
        }
        System.out.print("\n");
    }

    public static void drawFullLineUnit(int size) {
        for (int i = 0; i < size; i++) {
            System.out.print("*");
        }
        System.out.print(" ");
    }

    public static void drawEmptyLineUnit(int size) {
        System.out.print("*");
        for (int i = 1; i < size - 1; i++) {
            System.out.print(" ");
        }
        System.out.print("*");
        System.out.print(" ");
    }
}
