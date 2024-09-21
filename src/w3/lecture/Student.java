package w3.lecture;

import java.util.Scanner;

public class Student {
	int id;
	String name;
	int year;
	int score[] = new int[3];

	public Student() {

	}

	public Student(int id) {
		this.id = id;
	}

	public void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		year = scan.nextInt();
		for (int i = 0; i < 3; i++)
			score[i] = scan.nextInt();
	}

	public void readWithoutId(Scanner scan) {
		name = scan.next();
		year = scan.nextInt();
		for (int i = 0; i < 3; i++)
			score[i] = scan.nextInt();
	}

	public void print() {
		 System.out.printf("%d %s %d학년 ", id, name, year);
		 for (int i = 0; i < 3; i++) 
			 System.out.printf("%d ", score[i]);
		 System.out.println();
	}

	public boolean matches(String name) {
		return this.name.equals(name);
	}

}
