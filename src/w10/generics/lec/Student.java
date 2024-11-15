package w10.generics.lec;

import java.util.ArrayList;
import java.util.Scanner;

import w10.generics.mgr.Manageable;

public class Student implements Manageable, Comparable<Student> {

	@Override
	public int compareTo(Student o) {
		return o.name.compareTo(name);
	}

	int id;
	String name;
	String tel;
	int year;
	ArrayList<Lecture> registeredList = new ArrayList<>();

	public void read(Scanner scan) {
		id = scan.nextInt();
		name = scan.next();
		tel = scan.next();
		year = scan.nextInt();
		String code;

		while (true) {
			code = scan.next();
			if (code.equals("0")) {
				break;
			}
			Lecture lecture = Department.findLecture(code);
			registeredList.add(lecture);
		}

	}

	void printStudent() {
		System.out.printf("%d %s (%d학년)\n", id, name, year);
	}

	public void print() {
		printStudent();
		for (Lecture rl : registeredList) {
			System.out.print("\t");
			rl.print();
		}
	}

	public boolean matches(String kwd) {
		if (kwd.equals("" + id))
			return true;
		if (name.contains(kwd))
			return true;
		if (containsLecture(kwd))
			return true;
		return false;
	}

	boolean containsLecture(String kwd) {
		for (Lecture lec : registeredList) {
			if (lec.name.contains(kwd)) // 과목명 비교
				return true;
		}
		return false;
	}

	boolean matchDay(String kwd) {
		for (Lecture lec : registeredList) {
			if (lec.matchDay(kwd))
				return true;
		}
		return false;
	}
}
