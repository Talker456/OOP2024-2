package EXAM;

import java.util.ArrayList;
import java.util.Scanner;

public class Product {
    //W 상의 큰무늬반팔티셔츠 5500 레드 블루 블랙 화이트 0 XL L M S XS 0
    static int count;
    int number;
    String gender;
    String type;
    String name;
    int price;
    ArrayList<String> colors = new ArrayList<>();
    ArrayList<String> sizes = new ArrayList<>();

    public void read(Scanner scanner) {
        number=++count;
        String temp = scanner.next();
        switch (temp) {
            case "M" : gender = "남성용"; break;
            case "W" : gender = "여성용"; break;
            case "C" : gender = "공용"; break;
        }
        type = scanner.next();
        name = scanner.next();
        price = scanner.nextInt();
        String color = null;
        while (true) {
            color = scanner.next();
            if (color.equals("0")) {
                break;
            }
            colors.add(color);
        }
        String size = null;
        while (true) {
            size = scanner.next();
            if (size.equals("0")) {
                break;
            }
            sizes.add(size);
        }
    }

    // [공용/세트] 곰상하세트
    public void printPartial() {
        System.out.printf("[%s/%s] %s ",gender,type,name);
    }

    //[여성용/하의] 슬림데님팬츠 (12000원) 색상:연청 중청 차콜  사이즈:L M S
    public void print() {
        System.out.printf("%d) ",number);
        printPartial();
        System.out.printf("(%d원) 색상:",price);
        for (String color : colors) {
            System.out.printf("%s ",color);
        }
        System.out.print("사이즈 :");
        for (String size : sizes) {
            System.out.printf("%s ",size);
        }
        System.out.println();
    }

    void printSizes() {
        int cnt = 0;
        for (String size : sizes) {
            System.out.printf("%d) %s ",++cnt,size);
        }
    }

    void printColors() {
        int cnt=0;
        for (String color : colors) {
            System.out.printf("%d) %s ",++cnt,color);
        }
    }

    boolean matches(String kwd) {
        if ((number + "").equals(kwd)) {
            return true;
        }
        if (gender.equals(kwd)) {
            return true;
        }
        if (type.equals(kwd)) {
            return true;
        }
        if (name.contains(kwd)) {
            return true;
        }
        if (colors.contains(kwd)) {
            return true;
        }
        if (sizes.contains(kwd)) {
            return true;
        }
        return false;
    }



}
