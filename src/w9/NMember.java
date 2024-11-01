package w9;

import java.util.Scanner;

public class NMember extends Member {
	String nick;

	public void read(Scanner scan) {
		super.read(scan);
		nick = scan.next();
	}

	public void print() {
		super.print();
		System.out.printf(" [%s]", nick);
	}

	public boolean matches(String kwd) {
		if (super.matches(kwd))
			return true;
		if (nick.equals(kwd))
			return true;
		return false;
	}
}
