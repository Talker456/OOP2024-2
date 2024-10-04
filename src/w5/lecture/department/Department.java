package w5.lecture.department;


import java.util.ArrayList;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	ArrayList<Student> studentList = new ArrayList<>();
	static ArrayList<Lecture> lectureList = new ArrayList<>();

	void run() {
		readLectures();
		printLectures();
		readStudents();
		printStudents();
		search();
	}

	private void printLectures() {
		// TODO Auto-generated method stub
		for (Lecture lec: lectureList) {
			lec.print();
		}
	}

	void readStudents() {
		Student st = null;
		int id;
		while (true) {
			id = scan.nextInt();
			if (id == 0)
				break;
			st = new Student();
			st.read(scan, id);
			studentList.add(st);
		}
	}
	void readLectures() {
		Lecture lec = null;
		String code;
		while (true) {
			code = scan.next();
			if (code.equals("end"))
				break;
			lec = new Lecture(code);
			lec.read(scan);
			lectureList.add(lec);
		}		
	}

	void printStudents() {
		for (Student st : studentList) {
			st.print();
		}
	}

	void search() {
		String name = null;
		while (true) {
			System.out.print("키워드:");
			name = scan.next();
			if (name.equals("end"))
				break;
			for (Student st : studentList) {
				if (st.matches(name))
					st.print();
			}
		}
	}

	public static void main(String args[]) {
		Department my = new Department();
		my.run();
	}

	public static Lecture findLecture(String code) {
		for (Lecture lec: lectureList) {
			if (lec.matches(code))
				return lec;
		}
		return null;
	}
}