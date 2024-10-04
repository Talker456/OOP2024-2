package w5.lecture.department;


import java.io.File;
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
		for (Lecture lec: lectureList) {
			lec.print();
		}
	}

	void readStudents() {
		Scanner fileIn = openFile("students.txt");
		Student st = null;
		while (fileIn.hasNext()) {
			st = new Student();
			st.read(fileIn);
			studentList.add(st);
		}
	}
	void readLectures() {
		Scanner fileIn = openFile("subjects.txt");
		Lecture lec = null;
		while (fileIn.hasNext()) {
			lec = new Lecture();
			lec.read(fileIn);
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

	Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.printf("파일 오픈 실패: %s\n",filename);
			throw new RuntimeException(e);
		}
		return filein;
	}
}