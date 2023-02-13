package a_클래스;

//9:39~12:51
import java.util.Scanner;

class Tictactoe {
	String[][] game = new String[3][3];

	int turn = 1;
	int win = 0;
}

public class 클래스05_틱택토 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Tictactoe e = new Tictactoe();
		String dot = "●";
		int cnt = 0;

		int idx = 0;
		for (int i = 0; i < e.game.length; i++) {
			for (int j = 0; j < e.game[i].length; j++) {
				e.game[i][j] = idx + "";
				System.out.print("[" + e.game[i][j] + "]");
				idx++;
			}
			System.out.println();
		}

		while (true) {
			System.out.println("=============");
			System.out.println("[P" + e.turn + "] " + dot);
			System.out.print("선택 0~8 >> ");
			int sel = scan.nextInt();
			System.out.println("=============");

			if (sel < 0 || sel > 8) {
				System.err.println("입력오류 : 0~8");
				continue;
			} else {
				idx = 0;
				for (int i = 0; i < e.game.length; i++) {
					for (int j = 0; j < e.game[i].length; j++) {
						if (sel == idx) {
							if (e.game[i][j] == "●" || e.game[i][j] == "○") {
								System.err.println("이미 선택된 칸입니다.");
							} else {
								e.game[i][j] = dot;
								cnt++;
							}
							i = e.game.length;
							break;
						}
						idx++;
					}
				}
			}
			// 승리 조건
			for (int i = 0; i < e.game.length; i++) {
				for (int j = 0; j < e.game[i].length; j++) {
					if (e.game[0][j] == dot) {
						if (j == 0 && e.game[1][1] == dot && e.game[2][2] == dot) {
							e.win = e.turn;
						} else if (j == 2 && e.game[1][1] == dot && e.game[2][0] == dot) {
							e.win = e.turn;
						} else if (e.game[1][j] == dot && e.game[2][j] == dot) {
							e.win = e.turn;
						}
					} else if (e.game[i][0] == dot && e.game[i][1] == dot && e.game[i][2] == dot) {
						e.win = e.turn;
					}
				}
			}
			if (e.win != 0) {
				System.out.println("[게임종료] P" + e.win + "승리!!");
				break;
			} else if (cnt == 9 && e.win == 0) {
				System.out.println("[게임종료] 무승부");
				break;
			}
			idx = 0;
			for (int i = 0; i < e.game.length; i++) {
				for (int j = 0; j < e.game[i].length; j++) {
					if (e.game[i][j] != "●" && e.game[i][j] != "○") {
						e.game[i][j] = idx + "";
					}
					System.out.print("[" + e.game[i][j] + "]");
					idx++;
				}
				System.out.println();
			}

			if (e.turn == 1) {
				e.turn = 2;
				dot = "○";
			} else {
				e.turn = 1;
				dot = "●";
			}
		}
		scan.close();
	}
}
