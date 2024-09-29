package w4.hw;

import java.util.ArrayList;
import java.util.Scanner;

public class Store {
    ArrayList<Item> itemList = new ArrayList<>();
    ArrayList<User> userList = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public void run() {
        readAllItems();
        readAllUsers();
        setAllTable();

        boolean exitFlag = false;
        while (true) {
            if (exitFlag) {
                break;
            }
            System.out.println("\n(1) 상품출력 (2) 사용자출력  (3) 상품검색   (4) 사용자검색");
            System.out.print("(5) 상품으로사용자검색  (6) 상품별판매현황 (7) 같이판매된상품\n(0) 종료=> ");
            int menu = scanner.nextInt();
            switch (menu) {
                case 0:
                    exitFlag = true;
                    System.out.println("종료");
                    break;
                case 1:
                    printAllItems();
                    break;
                case 2:
                    printAllUsers();
                    break;
                case 3:
                    searchItem();
                    break;
                case 4:
                    searchUser();
                    break;
                case 5:
                    searchUserByItem();
                    break;
                case 6:
                    searchItemByCount();
                    break;
                case 7:
                    searchItemsSoldTogether();
                    break;
            }
        }
    }

    void readAllItems() {
        String code;
        while (true) {
            code = scanner.next();
            if (code.equals("0")) {
                break;
            }
            Item item = new Item(code);
            item.read(scanner);
            itemList.add(item);
        }
    }

    void readAllUsers() {
        String name;
        while (true) {
            name = scanner.next();
            if (name.equals("0")) {
                break;
            }
            User user = new User(name);
            user.read(scanner,this);
            userList.add(user);
        }
    }

    void printAllItems() {
        for (Item item : itemList) {
            item.print();
        }
    }

    void printAllUsers() {
        for (User user : userList) {
            user.print();
        }
    }

    void setAllTable() {
        for (Item item : itemList) {
            item.setTable(this);
        }
    }

    void searchItem() {
        System.out.print("상품검색 키워드 : ");
        String keyword = scanner.next();
        Item item = findItemByKeyword(keyword);
        if (item == null) {
            System.out.println("없는 상품");
        }else{
            item.print();
        }
    }

    void searchUser() {
        System.out.print("이름 입력 : ");
        String name = scanner.next();
        User user = findUserByName(name);
        if (user == null) {
            System.out.println("없는 사용자");
        } else {
            user.print();
        }
    }

    void searchUserByItem() {
        System.out.print("구매한 사용자 검색할 상품번호 또는 코드: ");
        String keyword = scanner.next();
        Item item = findItemByKeyword(keyword);
        if (item == null) {
            System.out.println("없는 상품");
            return;
        }
        item.print();
        for (User user : userList) {
            if (user.contains(item)) {
                user.print();
            }
        }
    }

    void searchItemByCount() {
        System.out.print("상품별 판매수, 몇개 이상: ");
        int count = scanner.nextInt();
        for (Item item : itemList) {
            if (item.soldMoreThan(count)) {
                item.printSaleInfo();
            }
        }
    }

    void searchItemsSoldTogether() {
        System.out.print("상품번호 또는 상품코드: ");
        String keyword = scanner.next();
        Item searchedItem = findItemByKeyword(keyword);
        if (searchedItem == null) {
            System.out.println("없는 상품");
            return;
        }
        System.out.printf("[%d] %s와 함께 팔린 상품:\n", searchedItem.num, searchedItem.name);
        searchedItem.printItemsSoldTogether(this);
    }

    Item findItemByKeyword(String keyword) {
        for (Item item : itemList) {
            if (item.matches(keyword)) {
                return item;
            }
        }
        return null;
    }

    Item findItemById(int id) {
        for (Item item : itemList) {
            if (item.matches(id+"")) {
                return item;
            }
        }
        return null;
    }

    User findUserByName(String name) {
        for (User user : userList) {
            if (user.matches(name)) {
                return user;
            }
        }
        return null;
    }

    int[] getItemTable(Item item) {
        int[] table = new int[itemList.size()];
        for (User user : userList) {
            if (user.contains(item)) {
                for (Item purchasedItem : user.purchasedItems) {
                    if (item.equals(purchasedItem)) {
                        continue;
                    }
                    table[purchasedItem.num]++;
                }
            }
        }
        return table;
    }

    public static void main(String[] args) {
        Store store = new Store();
        store.run();
    }
}
