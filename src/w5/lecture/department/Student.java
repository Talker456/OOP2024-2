package w5.lecture.department;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {
	String name;
	int id;
	String phone;
	int year;
	ArrayList<Lecture> registeredList = new ArrayList<>();

	void read(Scanner scan, int id) {
		this.id = id;
		name = scan.next();
		phone = scan.next();
		year = scan.nextInt();
		String code;
		Lecture lecture = null;
		while (true) {
			code = scan.next();
			if (code.equals("0"))
				break;
			lecture = Department.findLecture(code);
			if (lecture == null)
				System.out.println("null: "+code);
			registeredList.add(lecture);
		}
	}

	void print() { // Student
		System.out.format("%d %s %s (%d학년)\n", id, name, phone, year);
		for (Lecture mylec : registeredList) {
			System.out.print("\t");
			mylec.print();
		}
	}

	boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (name.contentEquals(kwd))
			return true;
		return ("" + id).contentEquals(kwd);
	}
}