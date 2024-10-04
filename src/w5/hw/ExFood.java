package w5.hw;

import java.util.Scanner;

public class ExFood extends Food {
    String criteria;

    @Override
    void read(Scanner scan) {
        super.read(scan);
        criteria = scan.nextLine().trim();
    }

    @Override
    void printNoLn() {
        super.printNoLn();
        System.out.printf(" %s",criteria);
    }

    @Override
    int getKcal(int n, String u) {
        return cal * n / (Integer.parseInt(criteria.split(" ")[0]));
    }

    @Override
    void printDetail(int n, String u) {
        //비스켓 20g(40kcal) - 40kcal/1조각(20g) -> 40kcal*20/20g=40kcal
        System.out.printf("-> %dkcal*%d/%d=%dkcal",
                cal,n,Integer.parseInt(criteria.split(" ")[0]),getKcal(n,unit));
    }
}
