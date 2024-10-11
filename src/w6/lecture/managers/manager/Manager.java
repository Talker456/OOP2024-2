package w6.lecture.managers.manager;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager {
    ArrayList<Manageable> mlist = new ArrayList<>();

    public void readAll(String path,Factory factory) {
        Scanner filein = openFile("book4.txt");
        Manageable m = null;
        while (filein.hasNext()) {
            m = factory.create(filein);
            m.read(filein);
            mlist.add(m);
        }
    }

    public void printAll() {
        for (Manageable manageable : mlist) {
            manageable.print();
        }
    }

    public void search(Scanner scan) {
        String kwd;
        while (true) {
            System.out.print("검색 키워드: ");
            kwd = scan.next();
            if (kwd.equals("end")) break;
            for (Manageable b: mlist) {
                if (b.matches(kwd))
                    b.print();
            }
        }
    }

    private Scanner openFile(String filename) {
        Scanner filein = null;
        try {
            filein = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.printf("파일 오픈 실패: %s\n", filename);
            throw new RuntimeException(e);
        }
        return filein;
    }
}
