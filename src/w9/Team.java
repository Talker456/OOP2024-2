package w9;

import java.util.ArrayList;
import java.util.Scanner;

public class Team implements Manageable {
	static int count;
	String teamName;
	ArrayList<Member> members = new ArrayList<>();

	Team() {
		teamName = "Team" + ++count;
	}

	@Override
	public void read(Scanner scan) {
		String kwd = scan.next();
		Member m = null;
		while (true) {
			if (kwd.equals("0"))
				break;
			m = TeamMgr.findMember(kwd);
			members.add(m);
			kwd = scan.next();
		}
	}

	@Override
	public void print() {
		System.out.printf("[%s] ", teamName);
		for (Member m : members)
			System.out.printf("%s ", m.name);
		System.out.println();
	}

	@Override
	public boolean matches(String kwd) {
		// TODO Auto-generated method stub
		if (teamName.equals(kwd))
			return true;
		for (Member m : members)
			if (m.matches(kwd))
				return true;
		return false;
	}
}