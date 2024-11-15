package w11.collection;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CollectionTestUtil {
	static Random rand = new Random();

	static Collection<Integer> fillNumbers(int n) {
		Collection<Integer> c = new ArrayList<>();
		for (int i = 0; i < n; i++)
			c.add(rand.nextInt(300));
		return c;
	}

	static void printLn(Collection<?> c, int n) {
		int k = 0;
		for (Object e : c) {
			System.out.printf(" %s", e);
			if (++k >= n) {
				System.out.println();
				k = 0;
			}
		}
		System.out.println();
	}

	static List<String> collectWords(String filename) {
		Scanner filein = openFile(filename);
		List<String> col = new ArrayList<>();
		while (filein.hasNext()) {
			String word = filein.next();
			col.add(word);
			// String delims = "\\W+"; // split any non word
			// String[] tokens = word.split(delims);
			// for (String w : tokens)
			// col.add(w);
		}
		return col;
	}

	static Scanner openFile(String filename) {
		Scanner filein = null;
		try {
			filein = new Scanner(new File(filename));
		} catch (IOException e) {
			System.out.println("파일 입력 오류");
			throw new RuntimeException(e);
		}
		return filein;
	}
}
