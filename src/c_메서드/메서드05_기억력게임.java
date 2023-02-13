package c_메서드;

import java.util.Arrays;
//11:56
import java.util.Random;
import java.util.Scanner;

class MemoryGame {

	Scanner scan = new Scanner(System.in);
	Random ran = new Random();

	String[] front = { "☆", "☆", "○", "○", "△", "△", "□", "□", "♡", "♡" };
	String[] back = new String[10];

	void shuffle() {
		for (String f : front) {
			int idx = ran.nextInt(9) + 1;
			String temp = front[idx];
			front[idx] = front[0];
			front[0] = temp;
		}
//		System.out.println(Arrays.toString(front));
	}

	void printCard() {
		System.out.println("0 1 2 3 4 5 6 7 8 9");
		for (String b : back) {
			if (b == null) {
				System.out.print("■ ");
			} else {
				System.out.print(b + " ");
			}
		}
		System.out.println();
	}

	void choiceCard() {
		System.out.print("카드1 선택 : ");
		int card1 = scan.nextInt();
		System.out.print("카드2 선택 : ");
		int card2 = scan.nextInt();
		if(card1==card2) {
			System.err.println("같은 숫자 선택불가");
			return;
		}
		if (front[card1] == front[card2]) {
			back[card1] = front[card1];
			back[card2] = front[card2];
			cnt++;
			System.out.println("!정답!===============");
		} else {
			System.out.println("!땡!================");
		}
	}

	int cnt = 0; // 정답을 맞춘 횟수

	void run() {

		// 셔플(카드 섞기)
		shuffle();

		while (true) {
			// 카드 출력
			printCard();

			// 종료하기
			if (cnt == 5) {
				System.out.println("[게임 종료]===========");
				break;
			}

			// 카드 선택하기
			choiceCard();
		}
	}
}

public class 메서드05_기억력게임 {

	public static void main(String[] args) {
		MemoryGame mg = new MemoryGame();
		mg.run();
	}
}
