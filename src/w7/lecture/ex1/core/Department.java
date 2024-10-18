package w7.lecture.ex1.core;

import w7.lecture.ex1.managers.Factory;
import w7.lecture.ex1.managers.Manageable;
import w7.lecture.ex1.managers.Manager;

import java.util.Scanner;

public class Department extends Manager implements Factory {
	Scanner scan = new Scanner(System.in);
	static Manager lectureManager = new Manager();

	class LectureFactory implements Factory {
		@Override
		public Manageable create(Scanner scan) {
			return new Lecture();
		}
	}

	@Override
	public Manageable create(Scanner scan) {
		return new Student();
	}

	void run() {
		lectureManager.readAll("./src/w7/lecture/ex1/core/lecture.txt",new LectureFactory());
		lectureManager.printAll();
		readAll("./src/w7/lecture/ex1/core/student.txt", this);
		printAll();
		search(scan);
	}

	static public Lecture findLecture(String code) {
		Manageable manageable = lectureManager.find(code);
		return (Lecture)manageable;
	}

	public static void main(String[] args) {
		Department my = new Department();
		my.run();
	}
}