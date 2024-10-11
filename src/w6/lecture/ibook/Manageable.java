package w6.lecture.ibook;

import java.util.Scanner;

public interface Manageable {
    public void read(Scanner scanner);
    public void print();
    public boolean matches(String kwd);
}
