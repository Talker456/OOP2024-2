package w4.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    String name;
    String pwd;
    int total;
    int point;
    ArrayList<Item> purchasedItems = new ArrayList<>();

    User(String name) {
        this.name = name;
    }

    void read(Scanner scanner,Store store) {
        pwd = scanner.next();
        point = scanner.nextInt();
        int id=0;
        while (true) {
            id = scanner.nextInt();
            if (id == 0) {
                break;
            }
            Item item = store.findItemById(id);
            item.totalCountIncrement();
            total += item.price;
            point += item.price/100;
            purchasedItems.add(item);
        }
    }

    void print() {
        System.out.printf("[%s] 총구매 : %d건 %d원 (%d점)\n",
                            name,purchasedItems.size(),total,point);
        for (Item purchasedItem : purchasedItems) {
            System.out.printf(" %s", purchasedItem.name);
        }
        System.out.println();
    }

    boolean matches(String name) {
        return this.name.equals(name);
    }

    boolean contains(Item item) {
        for (Item purchasedItem : purchasedItems) {
            if (purchasedItem.equals(item)) {
                return true;
            }
        }
        return false;
    }
}
