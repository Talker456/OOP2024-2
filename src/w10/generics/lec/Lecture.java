package w10.generics.lec;

import java.util.Scanner;

import w10.generics.mgr.Manageable;

public class Lecture implements Manageable {
	String code;
	String name;
	int year;
	String day;
	String time;

	public void read(Scanner scan) {
		code = scan.next();
		name = scan.next();
		year = scan.nextInt();
		day = scan.next();
		time = scan.next();
	}

	public void print() {
		System.out.printf("(%s) %s (%d학년) %s%s\n", code, name, year, day, time);
	}

	public boolean matches(String kwd) {
		if (code.equals(kwd))
			return true;
		if (name.contains(kwd))
			return true;
		return false;
	}

	boolean matchDay(String kwd) {
		return (day.equals(kwd));
	}
}
