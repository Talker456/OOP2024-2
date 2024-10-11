package w5.hw;

import java.util.Scanner;

public class ExFood extends Food {
    String amount;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        amount = scan.nextLine().trim();
    }

    @Override
    void printNoLn() {
        super.printNoLn();
        System.out.printf(" %s", amount);
    }

    @Override
    int getKcal(int n, String u) {
        return cal * n / (Integer.parseInt(amount.split(" ")[0]));
    }

    @Override
    void printDetail(int n, String u) {
        System.out.printf("-> %dkcal*%d/%d=%dkcal",
                cal,n,Integer.parseInt(amount.split(" ")[0]),getKcal(n,unit));
    }
}
