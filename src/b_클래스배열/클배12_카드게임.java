package b_클래스배열;
//40분+10:06~12:05

import java.util.Random;
import java.util.Scanner;

class Player {
	String name;
	Card c1;
	Card c2;
	boolean win;

	Player(String name, Card c1, Card c2, boolean win) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
		this.win = win;
	}
}

class Card {
	String shape;
	int num;
}

class CardGame {
	Card deck[] = new Card[40];
	String shapes[] = { "◇", "♡", "♣", "♠" };

	void init() {
		for (int i = 0; i < deck.length; i++) {
			deck[i] = new Card();
			deck[i].num = i % 10 + 1;
			deck[i].shape = shapes[i / 10];
		}
	}

	void suffleCard() {
		Random rd = new Random();
		for (int i = 0; i < 100; i++) {
			int idx = rd.nextInt(deck.length - 1) + 1;
			Card temp = deck[idx];
			deck[idx] = deck[0];
			deck[0] = temp;
//			System.out.println(deck[0].shape+" : "+deck[0].num);
		}
	}

	Player pickCard(String name, int idx) {
		Card c1 = deck[idx];
		Card c2 = deck[idx + 1];
		Player person = new Player(name, c1, c2, false);
		person.name = name;
		return person;
	}

	int[] checkMax(Player pp) {
		int sum = 0;
		int max = 0;
		String shape = "";
		int maxIdx=-1;
		sum = pp.c1.num + pp.c2.num;
		if (pp.c1.num > pp.c2.num) {
			max = pp.c1.num;
			shape=pp.c1.shape;
		} else if (pp.c2.num > pp.c1.num) {
			max = pp.c2.num;
			shape=pp.c2.shape;
		}
		if(max==0) {
			int c1Idx=-1;
			int c2Idx=-1;
			for (int i = 0; i < shapes.length; i++) {
				if(max==0 && (pp.c1.shape.equals(shapes[i]) || pp.c2.shape.equals(shapes[i]))) {
					maxIdx = i;
				}else if (shape.equals(shapes[i])) {
					maxIdx = i;
				}
			}
		}
		int[] temp = { sum, max, maxIdx };

		return temp;
	}

	int checkWin(Player p1, Player p2) {
		int[] pp1 = checkMax(p1);
		int[] pp2 = checkMax(p2);
		if (pp1[0] == pp2[0]) {
			if (pp1[1] == pp2[1]) {
				if (pp1[2] > pp2[2]) {
					p1.win = true;
				} else {
					p2.win = true;
				}
			} else if (pp1[1] > pp2[1]) {
				p1.win = true;
			} else {
				p2.win = true;
			}
		} else if (pp1[0] > pp2[0]) {
			p1.win = true;
		} else {
			p2.win = true;
		}

		int win = 0;
		if (p1.win == true) {
			win = 1;
		} else {
			win = 2;
		}
		return win;
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		init();
		suffleCard();
		int idx = 0;
		while (idx < 37) {
			System.out.println("=================");
			System.out.println("[0]종료 [1]게임플레이");
			int sel = sc.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				Player p1 = pickCard("p1", idx);
				idx += 2;
				Player p2 = pickCard("p2", idx);
				int win = checkWin(p1, p2);
				System.out.printf("P1 [%s:%d] [%s:%d]\n", p1.c1.shape, p1.c1.num, p1.c2.shape, p1.c2.num);
				System.out.printf("P2 [%s:%d] [%s:%d]\n", p2.c1.shape, p2.c1.num, p2.c2.shape, p2.c2.num);
				System.out.println("플레이어 p" + win + "승리!!");
			} else {
				System.err.println("입력오류 [0~1]");
			}
		}
		System.out.println("[게임종료]");
	}
}

public class 클배12_카드게임 {

	public static void main(String[] args) {

		CardGame cg = new CardGame();
		cg.run();

	}
}
