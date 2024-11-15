package w10.generics.mgr;

import java.util.Scanner;

public interface Manageable {
    void read(Scanner scan);
    void print();
    boolean matches(String kwd);
}
