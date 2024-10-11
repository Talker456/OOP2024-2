package w6.lecture.managers.book;

import w6.lecture.managers.manager.Factory;
import w6.lecture.managers.manager.Manageable;
import w6.lecture.managers.manager.Manager;

import java.util.Scanner;

public class Bookstore extends Manager implements Factory {
	Scanner scanner = new Scanner(System.in);

	void mymain() {
		readAll("book4.txt",this);
		printAll();
		search(scanner);
	}

	@Override
	public Manageable create(Scanner scanner){
		int type=0;
		type = scanner.nextInt();
		Manageable b = null;
		switch (type) {
			case 1: b = new Book(); break;
			case 2: b = new EBook(); break;
			case 3: b = new ABook(); break;
			case 4: b = new Pen() ; break;
			case 5: b = new Tissue() ; break;
		}
		return b;
	}

	public static void main(String[] args) {
		Bookstore store = new Bookstore();
		store.mymain();
	}
}
