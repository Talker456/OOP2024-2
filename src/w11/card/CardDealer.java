package w11.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CardDealer {
    public void run() {
        Scanner scan = new Scanner(System.in);
        ;
        System.out.print("인원: ");
        int numHands = scan.nextInt();
        System.out.print("일인당카드수: ");
        int cardsPerHand = scan.nextInt();
        String[] suit = new String[] { "♤", "♡", "◇", "♧" };
        String[] rank = new String[] { "A", "2", "3", "4", "5",
                "6", "7", "8", "9", "10", "J", "Q", "K" };

        List<String> deck = new ArrayList<String>();
        for (int i = 0; i < suit.length; i++) {
            for (int j = 0; j < rank.length; j++) {
                deck.add(suit[i] + rank[j]);
            }
        }

        Collections.shuffle(deck);

        List<List<String>> handList = new ArrayList<>();

        for (int i = 0; i < numHands; i++) {
            handList.add(dealHand(deck, cardsPerHand));
        }

        for (List<String> strings : handList) {
            System.out.println(strings);
        }

    }

    public <E> List<E> dealHand(List<E> deck, int n) {
        int deckSize = deck.size(); // 끝에서 n개 서브리스트
        List<E> handView = deck.subList(Math.max(deckSize - n, 0), deckSize);
        List<E> hand = new ArrayList<E>(handView); // 복제 생성
        handView.clear(); // 서브리스트 삭제, 원래 리스트에서도 삭제됨
        return hand;
    }


    public static void main(String[] args) {
        CardDealer cd = new CardDealer();
        cd.run();
    }
}
