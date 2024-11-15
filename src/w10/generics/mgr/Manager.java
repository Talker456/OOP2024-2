package w10.generics.mgr;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Manager<T extends Manageable> {
	public ArrayList<T> mList = new ArrayList<>();

	public T find(String kwd) {
		for (T m : mList)
			if (m.matches(kwd))
				return m;
		return null;
	}

	public void readAll(String filename, Factory<T> fac) {
		Scanner filein = openFile(filename);
		T m = null;
		while (filein.hasNext()) {
			m = fac.create();
			m.read(filein);
			mList.add(m);
		}
		filein.close();
	}

	public void printAll() {
		for (T m : mList) {
			m.print();
		}
	}

	public void search(Scanner keyScanner) {
		String kwd = null;
		while (true) {
			System.out.print(">> ");
			kwd = keyScanner.next();
			if (kwd.equals("end"))
				break;
			for (T m : mList) {
				if (m.matches(kwd))
					m.print();
			}
		}
	}

	public Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (Exception e) {
			System.out.println(filename + ": 파일 없음");
			System.exit(0);
		}
		return filein;
	}

	public void addElement(T e) {
		mList.add(e);
	}

	public void printAllSortBy(Comparator<T> comparator) {
		ArrayList<T> sorted = new ArrayList<>(mList);
		Collections.sort(sorted, comparator);
		for (T m : sorted) {
			m.print();
		}
	}
}
