package LAB_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

class Card {
    String bac;
    String chat_bai;

    Card(String x, String y) {
        bac = x;
        chat_bai = y;
    }
}

class Deck {
    public ArrayList<Card> cards;

    public Deck() {
        cards = new ArrayList<Card>();
        String[] bac_bai = { "At", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Boi", "Dam", "Gia" };
        String[] chat_bai = { "Bich", "Chuon", "Ro", "Co" };
        for (String bac : bac_bai) {
            for (String chat : chat_bai) {
                Card card = new Card(bac, chat);
                cards.add(card);
            }
        }
    }

    void suffle() {
        Collections.shuffle(cards);
    }
}

public class cau_4 {
    public static void main(String[] args) {
        Deck a = new Deck();
        a.suffle();
        for (Card i : a.cards) {
            System.out.print(i.bac + "_" + i.chat_bai + "\n");
        }
    }
}