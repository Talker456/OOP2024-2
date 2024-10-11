package w6.lecture.ibook;

import java.util.Scanner;

public class Tissue implements Manageable{
    String name;
    int nSheets;
    int price;

    @Override
    public void read(Scanner scanner) {
        name = scanner.next();
        nSheets = scanner.nextInt();
        price = scanner.nextInt();
    }

    @Override
    public void print() {
        System.out.printf("[Tissue] %s (%d장) [%d원]\n", name, nSheets, price);
    }

    @Override
    public boolean matches(String kwd) {
        if(name.equals(kwd)) return true;
        if((""+nSheets).equals(kwd)) return true;
        if((""+price).equals(kwd)) return true;
        return false;
    }
}
