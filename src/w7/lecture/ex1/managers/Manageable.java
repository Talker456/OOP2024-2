package w7.lecture.ex1.managers;

import java.util.Scanner;

public interface Manageable {
	void read(Scanner scan);

	void print();

	boolean matches(String kwd);
}
