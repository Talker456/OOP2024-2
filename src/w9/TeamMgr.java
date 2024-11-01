package w9;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class TeamMgr {
	Scanner scan = new Scanner(System.in);
//	ArrayList<Team> teamList = new ArrayList<>();
	Manager teamManager = new Manager();
//	static ArrayList<Member> members = new ArrayList<>();

	static Manager memberManager = new Manager();

	//1. inner class approach
	private static class TeamFactory implements Factory{
		@Override
		public Manageable create(Scanner scan) {
			return new Team();
		}
	}

	// discriminate(member,nmember) required
	private static class MemberFactory implements Factory{
		@Override
		public Manageable create(Scanner scan) {
			int n = scan.nextInt();
			if (n==1) return new Member();
			if (n==2) return new NMember();
			return null;
		}
	}

	void mymain() {
//		memberManager.readAll("members.txt", new MemberFactory());
//		teamManager.readAll("teams.txt",new TeamFactory());
		memberManager.readAll("members.txt", new Factory() {
			@Override
			public Manageable create(Scanner scan) {
				int n = scan.nextInt();
				if (n==1) return new Member();
				if (n==2) return new NMember();
				return null;
			}
		});
		teamManager.readAll("teams.txt", new Factory() {
			@Override
			public Manageable create(Scanner scan) {
				return new Team();
			}
		});

		teamManager.printAll();
		askSameTeam();
	}

	void askSameTeam() {
		Outer: while (true) {
			System.out.print("\n같은팀 검사(두 개 이름): ");
			String name1 = scan.next();
			if (name1.equals("end"))
				break;
			String name2 = scan.next();
			for (Manageable m : memberManager.mList) {
				if (m.matches(name1) && m.matches(name2)) {
					System.out.println("같은 팀이 아님(동일인)");
					continue Outer;
				}
			}
			Team result = null;
			for (Manageable t : teamManager.mList) {
				if (t.matches(name1) && t.matches(name2)) {
					result = (Team)t; // downcast
					break;
				}
			}
			if (result != null)
				System.out.printf("%s팀에 속함", result.teamName);
			else
				System.out.printf("같은 팀이 아님");
		}
	}

//	void printAllTeams() {
//		for (Team t : teamList)
//			t.print();
//	}
//
//	void readAllTeams() {
//		Scanner filein = openFile("teams.txt");
//		Team t;
//		while (filein.hasNext()) {
//			t = new Team();
//			t.read(filein);
//			teamList.add(t);
//			// t.print();
//		}
//		filein.close();
//	}

//	void readAllMembers() {
//		Scanner filein = openFile("members.txt");
//		Member t;
//		int n;
//		while (filein.hasNext()) {
//			n = filein.nextInt();
//			t = switch (n) {
//			case 1 -> new Member();
//			case 2 -> new NMember();
//			default -> null;
//			};
//			t.read(filein);
//			members.add(t);
//			t.print();
//		}
//		filein.close();
//		System.out.println();
//	}

	static Member findMember(String kwd) {
		for (Manageable m : memberManager.mList)
			if (m.matches(kwd))
				return (Member) m;
		return null;
	}

	public static void main(String[] args) {
		TeamMgr m = new TeamMgr();
		m.mymain();
	}

}
