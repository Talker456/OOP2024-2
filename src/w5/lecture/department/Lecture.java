package w5.lecture.department;

import java.util.Scanner;

public class Lecture {
	String code;
	String name;
	int year;
	String day;
	String time;

	public Lecture(String code) {
		// TODO Auto-generated constructor stub
		this.code = code;
	}
	void read(Scanner scan) {
		name = scan.next();
		//System.out.println(name);
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}
	void print() {
		System.out.printf("(%s) %s (%d학년) %s%s\n", code, name, year, day, time);
	}
	public boolean matches(String code2) {
		// TODO Auto-generated method stub
		if (code.equals(code2))
			return true;
		return false;
	}
}
