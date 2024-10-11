package w6.lecture.managers.manager;

import java.util.Scanner;

public interface Manageable {
    public void read(Scanner scanner);
    public void print();
    public boolean matches(String kwd);
}
