package w10.generics.lec;

import w10.generics.mgr.Factory;
import w10.generics.mgr.Manager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Department {
	Scanner scan = new Scanner(System.in);
	Manager<Student> stMgr = new Manager<>();
	static Manager<Lecture> lecMgr = new Manager<>();

	void mymain() {
		lecMgr.readAll("./src/w10/generics/lecture.txt", new Factory<>() {
            @Override
            public Lecture create() {
                return new Lecture();
            }
        });
		lecMgr.printAll();
		stMgr.readAll("./src/w10/generics/student.txt", new Factory<>() {
			@Override
			public Student create() {
				return new Student();
			}
		});
		stMgr.printAll();
		// search();
		searchMenu();
		System.out.println("==========");

		ArrayList<Student> newList = new ArrayList<>(stMgr.mList);
		Collections.sort(newList);
		for (Student student : newList) {
			student.printStudent();
		}

		System.out.println("======== order by code ===========");
		lecMgr.printAllSortBy(new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.code.compareTo(o2.code);
			}
		});

		System.out.println("========order by name ==============");
		lecMgr.printAllSortBy(new Comparator<Lecture>() {
			@Override
			public int compare(Lecture o1, Lecture o2) {
				return o1.name.compareTo(o2.name);
			}
		});
	}

	void searchMenu() {
		while (true) {
			System.out.print("(1) 학생   (2) 과목  (3) 학생 요일 검색  (4) 종료");
			int menu = scan.nextInt();
			if (menu == 1)
				stMgr.search(scan);
			if (menu == 2)
				lecMgr.search(scan);
			if (menu == 3)
				searchByDay();
			break;
		}
	}

	void searchByDay() {
		System.out.print("요일:");
		String kwd = scan.next();
		for (Student m : stMgr.mList) {
			Student st = m;
			if (st.matchDay(kwd))
				st.printStudent();
		}
	}

	public static void main(String[] args) {
		Department dpt = new Department();
		dpt.mymain();
	}

	static public Lecture findLecture(String code) {
		return lecMgr.find(code);
	}
}
