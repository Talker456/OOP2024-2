package EXAM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    Scanner scanner = new Scanner(System.in);
    static ArrayList<Product> products = new ArrayList<>();
    static ArrayList<Order> orders = new ArrayList<>();

    void run() {
        readAllProducts("apparel.txt");
        readAllOrders("order.txt");
        printAllProducts();
        printAllOrders();
//        search();
        altSearch();
    }

    void  altSearch() {
        int menu = 0;
        while (true) {
            System.out.print("(1)상품 (2)주문 (3)상품선택검색 (4)주문추가 (5)종료... ");
            menu = scanner.nextInt();
            if (menu==5) {
                System.out.println("검색 종료");
                break;
            }
            if (menu == 1) {
                searchProductByKeyword();
            }
            if (menu == 2) {
                searchOrder();
            }
            if (menu == 3) {
                searchProductBySelection();
            }
            if (menu == 4) {
                addOrder();
            }
        }
    }

    void addOrder() {
        String flag = null;
        Product p = null;
        Order o =null;
        while (true) {
            System.out.print("추가 주문?(y/n) ");
            flag = scanner.next();
            if (flag.equals("n")) {
                break;
            }
            int number=0;
            System.out.print("번호 선택 ");
            number = scanner.nextInt();
            p = findProduct(number+"");
            if (p == null) {
                System.out.println("해당 상품 없음");
                continue;
            }
            p.print();
            String size = null;
            String color = null;
            int count = 0;
            p.printSizes();
            size = scanner.next();
            p.printColors();
            color = scanner.next();
            System.out.print("개수 입력: ");
            count = scanner.nextInt();
            o = new Order(p, color, size, count);
            orders.add(o);
            o.print();
            printAllOrders();
        }
    }

    void searchOrder() {
        String kwd = null;
        while (true) {
            System.out.print("검색키워드 :");
            kwd = scanner.next();
            if (kwd.equals("end")) {
                System.out.println("주문 검색 종료");
                System.out.println();
                break;
            }
            for (Order order : orders) {
                if (order.matches(kwd)) {
                    order.print();
                }
            }
        }
    }

    void searchProduct() {
        String flag = null;
        while (true) {
            System.out.print("선택 검색?(y/n) ");
            flag = scanner.next();
            if (flag.equals("y")) {
                searchProductBySelection();
                continue;
            }
            if (flag.equals("n")) {
                searchProductByKeyword();
                continue;
            }
            break;
        }
    }

    void searchProductBySelection() {
        String flag = null;
        while (true) {
            System.out.print("선택검색?(y/n) ");
            flag = scanner.next();
            if (flag.equals("n")) {
                System.out.println("선택검색종료");
                System.out.println();
                break;
            }
            String type1 =null;
            String type2 =null;
            ArrayList<Product> searchedList = new ArrayList<>();
            System.out.print("(1) 여성용  (2) 남성용  (3) 공용 ");
            int t = scanner.nextInt();
            switch (t) {
                case 1: type1="여성용"; break;
                case 2: type1="남성용"; break;
                case 3: type1="공용"; break;
            }
            System.out.print("(1) 상의  (2) 하의  (3) 세트  (4) 아우터 ");
            t = scanner.nextInt();
            switch (t) {
                case 1: type2="상의"; break;
                case 2: type2="하의"; break;
                case 3: type2="세트"; break;
                case 4: type2="아우터"; break;
            }
            for (Product product : products) {
                if (product.matches(type1) && product.matches(type2)) {
                    searchedList.add(product);
                }
            }
            if (searchedList.isEmpty()) {
                System.out.println("** 해당 상품 없음 **");
            } else {
                for (Product product : searchedList) {
                    product.print();
                }
            }
        }
    }

    void searchProductByKeyword() {
        String kwd = null;
        while (true) {
            System.out.print("검색키워드 :");
            kwd = scanner.next();
            if (kwd.equals("end")) {
                System.out.println("상품 검색 종료");
                System.out.println();
                break;
            }
            for (Product product : products) {
                if (product.matches(kwd)) {
                    product.print();
                }
            }
        }
    }

    Scanner openFile(String path) {
        Scanner s = null;
        try {
            s = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            System.out.println(path + " not found");
            throw new RuntimeException(e);
        }
        return s;
    }

    void readAllProducts(String path) {
        Scanner fileReader = openFile(path);
        Product p = null;
        while (fileReader.hasNext()) {
            p = new Product();
            p.read(fileReader);
            products.add(p);
        }
    }

    void readAllOrders(String path) {
        Scanner fileReader = openFile(path);
        Order o = null;
        while (fileReader.hasNext()) {
            o = new Order();
            o.read(fileReader);
            orders.add(o);
        }
    }

    void printAllOrders() {
        int sum=0;
        for (Order order : orders) {
            order.print();
            sum+= order.getPrice();
        }
        System.out.printf("주문 총계: %d원\n",sum);
        System.out.println();
    }

    void printAllProducts() {
        for (Product product : products) {
            product.print();
        }
        System.out.println();
    }

    static Product findProduct(String kwd) {
        for (Product product : products) {
            if (product.matches(kwd)) {
                return product;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Store s = new Store();
        s.run();

    }

    void search() {
        int menu = 0;
        while (true) {
            System.out.print("(1)상품 (2)주문 (3)종료 (4)주문추가... ");
            menu = scanner.nextInt();
            if (menu==3) {
                System.out.println("검색 종료");
                break;
            }
            if (menu == 1) {
                searchProduct();
            }
            if (menu == 2) {
                searchOrder();
            }
            if (menu == 4) {
                addOrder();
            }
        }
    }
}
