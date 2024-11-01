package EXAM;

import java.util.Scanner;

public class Order {
    // ...
    // [4] [남성용/아우터] 후리스자켓 (다크블루/L) 2개 30000원
    //[5] [남성용/하의] 이지데님팬츠 (연청/M) 1개 15000원
    //[6] [공용/상의] 바람막이반집업 (카키/M) 2개 38000원
    //[7] [공용/세트] 곰상하세트 (네이비/S) 1개 25000원
    //주문 총계: 159900원
    static int count;
    int number;
    Product product;
    String color;
    String size;
    int orderCount;

    Order(){}

    Order(Product product, String color, String size, int orderCount) {
        number = ++count;
        this.product = product;
        this.color = color;
        this.size = size;
        this.orderCount = orderCount;
    }

    public void read(Scanner scanner) {
        number=++count;
        String productNumber = scanner.next();
        product = Store.findProduct(productNumber);
        color = scanner.next();
        size = scanner.next();
        orderCount = scanner.nextInt();
    }

    int getPrice() {
        return product.price * orderCount;
    }

    public void print() {
        System.out.printf("[%d] ", number);
        product.printPartial();
        System.out.printf("(%s/%s) %d개 %d\n",color,size,orderCount, getPrice());
    }

    boolean matches(String kwd) {
        if (("" + number).equals(kwd)) {
            return true;
        }
        if (product.name.contains(kwd)) {
            return true;
        }
        if (color.equals(kwd)) {
            return true;
        }
        if (size.equals(kwd)) {
            return true;
        }
        return false;
    }

}
