package w11.collection;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTest {
    void run() {
        Map<String, Integer> map = new HashMap<String, Integer>();
        List<String> words = CollectionTestUtil.collectWords("jobs.txt");
        map = genFreqMap(words);

        map.keySet().removeIf(x -> x.length() <= 1);
        map.values().removeIf(x -> x <= 1);

        CollectionTestUtil.printLn(map.entrySet(), 5);
    }

    // <Generic> <Type> ID ( param . . .) { . . . }
    public <K> Map<K, Integer> genFreqMap(List<K> list) {
        Map<K, Integer> m = new HashMap<>();
        for (K k : list) {
            Integer freq = m.get(k);
            m.put(k, (freq == null) ? 1 : freq + 1);
        }
        return m;
    }

    public Map<String, Integer> freqMap(List<String> list) {
        Map<String, Integer> m = new HashMap<>();
        for (String string : list) {
            m.put(string, (m.get(string) == null) ? 1 : m.get(string) + 1);
        }
        return m;
    }

    public static void main(String[] args) {
        MapTest m = new MapTest();
        m.run();
    }
}