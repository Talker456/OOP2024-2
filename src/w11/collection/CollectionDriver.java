package w11.collection;

import java.util.*;

public class CollectionDriver {
    void run() {
        Collection<Integer> c1 = CollectionTestUtil.fillNumbers(10);
        Collection<Integer> c2 = CollectionTestUtil.fillNumbers(10);

        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);

        Collection<Integer> sum = new ArrayList<>(c1);
        Collection<Integer> diff = new ArrayList<>(c1);

        sum.addAll(c2);
        diff.removeAll(c2);

        System.out.println("sum = " + sum);
        System.out.println("diff = " + diff);
    }


    void runSet1() {
        Random rand = new Random();
        Collection<Integer> c = new ArrayList<>();
        Set<Integer> randSet = new HashSet<>();
        int n = 0;
        for (int i = 0; i < 300; i++) {

            n = rand.nextInt(300);
            randSet.add(n);
            c.add(i);
        }
        System.out.println("난수집합: " + randSet);
        c.removeAll(randSet); // 벌크 연산
        System.out.println("중복제외집합 :" + c);
    }

    public void runSet2() {
        Collection<Integer> c = CollectionTestUtil.fillNumbers(10);
        Set<Integer> noDups = new HashSet<>(c);

        System.out.println("ArryList = " + c);
        System.out.println("HashSet = " + noDups);

        noDups = new TreeSet<>(c);
        System.out.println("TreeSet = " + noDups);

        noDups = new LinkedHashSet<>(c);
        System.out.println("LinkSet = " + noDups);

    }




    public static void main(String[] args) {
        CollectionDriver driver = new CollectionDriver();
        driver.runSet2();
    }
}
