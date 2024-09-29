package w4.hw;

import java.util.Scanner;

public class Item {
    int num;
    String code;
    String name;
    int price;
    int totalSold;
    static int count=1;
    int[] ItemsSoldTogether;

    Item(String code) {
        num=count++;
        this.code = code;
    }

    void read(Scanner scanner) {
        name = scanner.next();
        price = scanner.nextInt();
    }

    void setTable(Store store) {
        ItemsSoldTogether = store.getItemTable(this);
    }

    void print() {
        System.out.printf("[%d] %s %s (%d원)\n", num, code, name, price);
    }

    boolean matches(String keyword) {
        return code.equals(keyword) || keyword.equals("" + num);
    }

    void totalCountIncrement() {
        totalSold++;
    }

    boolean soldMoreThan(int count) {
        return totalSold >= count;
    }

    void printSaleInfo() {
        System.out.printf("%s-%d개 팔림, %d매출\n",name,totalSold,totalSold*price);
    }

    void printItemsSoldTogether(Store store) {
        for (int i = totalSold; i >= 1; i--) {
            System.out.printf("%d회 : ", i);
            for (int j = 0; j < ItemsSoldTogether.length; j++) {
                if (ItemsSoldTogether[j] == i) {
                    Item item = store.findItemById(j);
                    System.out.printf("%s ",item.name);
                }
            }
            System.out.println();
        }
    }
}
