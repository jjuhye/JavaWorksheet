package a_클래스;

import java.util.Random;
import java.util.Scanner;

class MemoryGame {
	String[] front = { "♥", "♥", "★", "★", "▲", "▲", "☎", "☎", "♠", "♠" };
	String[] back = new String[10];

	int cnt = 0; // 정답을 맞춘 횟수
}

public class 클래스04_기억력게임 {

	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		MemoryGame mg = new MemoryGame();
		for (int i = 0; i < mg.front.length; i++) {
			int idx = rd.nextInt(10);
			String temp = mg.front[0];
			mg.front[0] = mg.front[idx];
			mg.front[idx] = temp;
			mg.back[mg.cnt] = "0";
			mg.cnt++;
		}
		mg.cnt = 0;
		while (true) {
			System.out.print("[ ");
			for (int i = 0; i < mg.back.length; i++) {
				if (mg.back[i] == "0") {
					System.out.print("■ ");
				} else {
					System.out.print(mg.front[i] + " ");
				}
			}
			System.out.print("]\n");
			System.out.println("==========================");
			if (mg.cnt == mg.back.length / 2) {
				System.out.println("[게임 종료]");
				System.out.println("==========================");
				break;
			}
			System.out.print("첫번째 카드 0~9 >> ");
			int sel1 = sc.nextInt();
			System.out.print("두번쨰 카드 0~9 >> ");
			int sel2 = sc.nextInt();

			if (sel1 == sel2) {
				System.err.println("동일한 카드 선택 불가");
				System.out.println("==========================");
				continue;
			} else if (sel1 < 0 || sel1 > 9 || sel2 < 0 || sel2 > 9) {
				System.err.println("카드번호 선택 오류");
				System.out.println("==========================");
				continue;
			} else {
				if (mg.front[sel1].equals(mg.front[sel2])) {
					mg.back[sel1] = sel1 + "";
					mg.back[sel2] = sel2 + "";
					mg.cnt++;
				} else {
					System.out.println("땡!!");
					System.out.println("==========================");
					continue;
				}
			}
		}
		sc.close();
	}
}
