package w6.lecture.managers.book;

import w6.lecture.managers.manager.Manageable;

import java.util.Scanner;

public class Pen implements Manageable {
    String name;
    double thickness;
    int price;

    @Override
    public void read(Scanner scanner) {
        name = scanner.next();
        thickness = scanner.nextDouble();
        price = scanner.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[Pen] %s (%.2fmm) [%d원]\n", name, thickness, price);
    }

    @Override
    public boolean matches(String kwd) {
        if (name.equals(kwd)) return true;
        if((""+thickness).equals(kwd)) return true;
        if((""+price).equals(kwd)) return true;
        return false;
    }
}
