package c_메서드;

import java.util.Scanner;

class NumberGame {
	// 심화는 격파까지 구현하시오
	Scanner scan = new Scanner(System.in);

	int[] move = { 0, 0, 1, 0, 2, 0, 0, 0, 1, 0 };
	int pidx = 4;

	void printPlay() {
		for (int m : move) {
			if (m == 2) {
				System.out.print("옷 ");
			} else if (m == 1) {
				System.out.print("▒ ");
			} else {
				System.out.print("□ ");
			}
		}
		System.out.println();
	}

	int getValue(String msg, int start, int end) {
		System.out.println(msg);
		System.out.print("선택 >> ");
		int sel = scan.nextInt();

		if (sel < start || sel > end) {
			System.err.println("입력오류 [" + start + "~" + end + "]");
			return -1;
		}
		return sel;
	}

	int showMenu() {
		int sel = getValue("[1]좌로 이동  [2]우로 이동  [3] 종료", 1, 3);
		return sel;
	}

	void breakOut(int next) {
		System.err.println("벽입니다!");
		int sel = getValue("[1]격파 [2]되돌아가기", 1, 2);
		if (sel == -1) {
			return;
		}
		if (sel == 1) {
			move[next] = 0;
			System.out.println("[벽을 격파했습니다]");
		}
	}

	boolean isRoad(int next) {
		if (move[next] == 1) {
			breakOut(next);
			return false;
		}
		return true;
	}

	void movePlayer(int sel) {
		int nextIdx = -1;

		if (sel == 1) {
			nextIdx = pidx - 1;
		} else {
			nextIdx = pidx + 1;
		}
		nextIdx = moveNext(nextIdx);
		if (isRoad(nextIdx)) {
			move[nextIdx] = 2;
			move[pidx] = 0;
			pidx = nextIdx;
		} else {
			return;
		}
	}

	int moveNext(int idx) {
		if (idx < 0) {
			return move.length - 1;
		}
		if (idx == move.length) {
			return 0;
		} else {
			return idx;
		}
	}

	void run() {
		while (true) {
			// 게임화면 출력
			printPlay();

			// 메뉴 출력
			int sel = getValue("[1]좌로 이동  [2]우로 이동  [3] 종료", 1, 3);
			// 메뉴 선택
			if (sel == -1) {
				continue;
			} else if (sel == 3) {
				System.out.println("[게임 종료]");
				return;
			}
			movePlayer(sel);
		}
	}
}

public class 메서드06_숫자이동 {

	public static void main(String[] args) {
		
		NumberGame g = new NumberGame();
		g.run();

	}

}
