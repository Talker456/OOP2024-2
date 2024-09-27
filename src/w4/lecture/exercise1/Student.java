package w4.lecture.exercise1;

import java.util.Scanner;

public class Student {
    private int id;
    String name;
    private int year;
    private String telephone;
    Team team;

    public Student (){}

    public Student(int id) {
        this.id = id;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public void read(Scanner scanner) {
        name = scanner.next();
        year = scanner.nextInt();
        telephone = scanner.next();
    }

    public void print() {
        System.out.printf("%d %s (%d학년) %s ", id, name, year, telephone);
        if (this.team != null) {
            System.out.printf("[%s]",team.name);
        }
        System.out.println();
    }


    public boolean matchesName(String name) {
        return this.name.equals(name);
    }

    public boolean matches(String keyword) {
        if (name.contains(keyword)) {
            return true;
        }
        if (keyword.length()>=4 && (id+"").contains(keyword)) {
            return true;
        }
        if (keyword.length() >= 4 && telephone.contains(keyword)) {
            return true;
        }
        return false;
    }

    public boolean matches(String[] keywords) {
        for (String keyword : keywords) {
            if (keyword.startsWith("-")) {
                keyword = keyword.substring(1);
                if (matches(keyword)) {
                    return false;
                }
            }else{
                if (!matches(keyword)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean matchesById(Integer member) {
        return id == member;
    }
}
