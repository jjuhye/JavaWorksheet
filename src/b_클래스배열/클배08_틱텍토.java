package b_클래스배열;

import java.util.Scanner;

class Tic {
	int[] line = new int[3];

	void printLine() {
		for (int i = 0; i < 3; i++) {
			if (line[i] == 0) {
				System.out.print("[ ]");
			} else if (line[i] == 1) {
				System.out.print("[o]");
			} else if (line[i] == 2) {
				System.out.print("[x]");
			}
		}
		System.out.println();
	}
}

class Game {
	Tic[] tics;
	int p1 = 1; // "O"
	int p2 = 2; // "X"
	boolean win;
	int cnt = 0;

	void init() {
		tics = new Tic[3];
		for (int i = 0; i < tics.length; i++) {
			tics[i] = new Tic();
		}
	}

	void printGameBoard() {
		for (Tic t : tics) {
			t.printLine();
		}
	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " >> ");
		int sel = sc.nextInt();

		if (sel < start || sel > end) {
			System.err.println("입력오류 [" + start + "~" + end + "]");
			return -1;
		}
		return sel;
	}

	boolean placePlayer(int player) {
		int y = getValue("Y좌표", 0, 2);
		if (y == -1) {
			return false;
		}
		int x = getValue("X좌표", 0, 2);
		if (x == -1) {
			return false;
		}
		if (tics[y].line[x] != 0) {
			System.err.println("이미 선택된 위치");
			return false;
		}

		tics[y].line[x] = player;
		cnt++;
		return true;
	}

	void exitWidth(int player) {
		for (int i = 0; i < tics.length; i++) {
			if (tics[i].line[0] == player && tics[i].line[1] == player && tics[i].line[2] == player) {
				win = true;
				return;
			}
		}
	}

	void exitHeight(int player) {
		for (int i = 0; i < tics.length; i++) {
			if (tics[0].line[i] == player && tics[1].line[i] == player && tics[2].line[i] == player) {
				win = true;
			}
		}
	}

	void exitCross(int player) {
		if (tics[1].line[1] == player) {
			if (tics[0].line[0] == player && tics[2].line[2] == player) {
				win = true;
			}
			if (tics[0].line[2] == player && tics[2].line[0] == player) {
				win = true;
			}
		}
	}

	boolean checkWin(int player) {

		exitWidth(player);
		exitHeight(player);
		exitCross(player);

		if (win) {
			System.out.println("[Player" + player + " 승리!!]");
			return true;
		} else if (cnt == 9) {
			System.out.println("[!무승부!]");
			return true;
		}
		return false;
	}

	void run() {
		init();
		printGameBoard();
		int turn = p1;

		while (true) {

			System.out.println("[Player" + turn + " turn]");

			if (!placePlayer(turn)) {
				continue;
			}
			System.out.println("==============");
			printGameBoard();

			if (checkWin(turn)) {
				return;
			}

			turn = turn == p1 ? p2 : p1;
		}
	}
}

public class 클배08_틱텍토 {

	public static void main(String[] args) {

		Game g = new Game();

		g.run();

// ===============
	}
}
