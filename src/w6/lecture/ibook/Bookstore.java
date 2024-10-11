package w6.lecture.ibook;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Bookstore {
	Scanner scan = new Scanner(System.in);
	ArrayList<Manageable> sellList = new ArrayList<>();
	void mymain() {
		// TODO Auto-generated method stub
		readAllBooks();
		printAllBooks();
		search();
	}

	private void search() {
		// TODO Auto-generated method stub
		String kwd;
		while (true) {
			System.out.print("검색 키워드: ");
			kwd = scan.next();
			if (kwd.equals("end")) break;
			for (Manageable b: sellList) {
				if (b.matches(kwd))
					b.print();
			}
		}
	}

	private void printAllBooks() {
		// TODO Auto-generated method stub
		for (Manageable b: sellList)
			b.print();
	}

	private void readAllBooks() {
		// TODO Auto-generated method stub
		Scanner filein = openFile("book4.txt");
		Manageable b = null;
		int type = 0;
		while (filein.hasNext()) {
			type = filein.nextInt();
			switch (type) {
			case 1: b = new Book(); break;
			case 2: b = new EBook(); break;
			case 3: b = new ABook(); break;
			case 4: b = new Pen() ; break;
			case 5: b = new Tissue() ; break;
			}
			b.read(filein);
			sellList.add(b);
		}
	}
	
	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n", filename);
			throw new RuntimeException(e);
		}
		return filein;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bookstore store = new Bookstore();
		store.mymain();
	}
}
