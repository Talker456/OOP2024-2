package w3.lecture;

import java.util.ArrayList;
import java.util.Scanner;

public class Exercise1 {
    Scanner scanner = new Scanner(System.in);
    ArrayList<String> stringList = new ArrayList<>(); // list is "Field"

    public void run() {
        String line;
        while (true) {
            line = scanner.next();
            if (line.equals("0")) {
                break;
            }
            stringList.add(line);
        }

        System.out.println(stringList.size()+"s strings");
        for (String string : stringList) {
            System.out.println(string+"\tLength : "+string.length());
        }

        String max = null;
        for (String string : stringList) {
            if (max == null || max.length() < string.length()) {
                max = string;
            }
        }
        System.out.println("longest string : " + max);
    }


    public void listPrint(ArrayList<String> list) {
        for (String string : list) {
            // printf > println ??
            System.out.printf("%s\tlength : %d\n",string,string.length());
        }
    }

    public static void main(String[] args) {
        Exercise1 e = new Exercise1();
        e.run();
    }
}

