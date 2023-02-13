package c_메서드;

import java.util.Scanner;

class TicTacToe {

	Scanner scan = new Scanner(System.in);

	String[][] game = new String[3][3];

	int turn = 0;
	int win = 0; // 1[turn1승리] 2[turn2승리]

	void setGame() {
		for (int i = 0; i < game.length; i++) {
			for (int k = 0; k < game[i].length; k++) {
				game[i][k] = "[ ]";
			}
		}
	}

	void showGame() {
		for (int i = 0; i < game.length; i++) {
			for (int k = 0; k < game[i].length; k++) {
				System.out.print(game[i][k]);
			}
			System.out.println();
		}
		System.out.println("=================");
	}

	void choiceIdx() {
		System.out.println("[ turn" + (turn % 2 + 1) + " ]");
		System.out.print("번호 선택 >> ");
		int sel = scan.nextInt();
		if (sel < 0 || sel > 8) {
			System.err.println("[번호 입력오류 0~8]");
			turn--;
			return;
		}
		if (game[sel / 3][sel % 3].equals("[ ]")) {
			game[sel / 3][sel % 3] = putOX();
		} else {
			System.err.println("[이미 선택된 번호입니다]");
			turn--;
			return;
		}

	}

	String putOX() {
		if (turn % 2 == 0) {
			return "[O]";
		} else {
			return "[X]";
		}
	}

	int exitWidth(String ox) {
		for (int i = 0; i < game.length; i++) {
			if (game[i][0].equals(ox) && game[i][1].equals(ox) && game[i][2].equals(ox)) {
				win = turn % 2 + 1;
			}
		}
		return win;
	}

	int exitHeight(String ox) {
		for (int i = 0; i < game.length; i++) {
			if (game[0][i].equals(ox) && game[1][i].equals(ox) && game[2][i].equals(ox)) {
				win = turn % 2 + 1;
			}
		}
		return win;
	}

	int exitCross(String ox) {
		if (game[1][1].equals(ox)) {
			if (game[0][0].equals(ox) && game[2][2].equals(ox)) {
				win = turn % 2 + 1;
			}
			if (game[0][2].equals(ox) && game[2][0].equals(ox)) {
				win = turn % 2 + 1;
			}
		}
		return win;
	}

	void run() {

		// game배열을 공백 문자열(" ")로 초기화
		setGame();

		while (true) {

			showGame();

			// 게임 종료
			if (win == 1) {
				System.out.println("turn1 승리");
				break;
			} else if (win == 2) {
				System.out.println("tur2 승리");
				break;
			}
			if (turn == 9) {
				System.out.println("!무승부 입니다!");
				break;
			}

			choiceIdx();

			exitWidth(putOX());
			exitHeight(putOX());
			exitCross(putOX());
			turn++;
		}
	}
}

public class 메서드07_틱텍토 {

	public static void main(String[] args) {

		TicTacToe tic = new TicTacToe();
		tic.run();
		
	}

}
