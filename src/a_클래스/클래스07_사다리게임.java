package a_클래스;

import java.util.Scanner;

class GameLadder {
	int ladder[][] = {
			{ 0, 0, 0, 0, 0 },
			{ 1, 1, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 }, 
			{ 0, 0, 1, 1, 0 }, 
			{ 1, 1, 0, 1, 1 },
			{ 0, 1, 1, 0, 0 }, 
			{ 0, 0, 1, 1, 0 },
			{ 0, 0, 0, 1, 1 }, 
			{ 0, 0, 0, 0, 0 } };
	
	int x = 0;
	int y = 0;
	String[] menu = { "죠스떡볶이", "CU편의점라면", "마라탕", "김밥천국", "명인만두" };
}

public class 클래스07_사다리게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		GameLadder gl = new GameLadder();

		// System.out.print(" │ ");
		// System.out.print("─┤ ");
		// System.out.print(" ├─");

		System.out.println(" 1  2  3  4  5");
		for (int i = 0; i < gl.ladder.length; i++) {
			for (int k = 0; k < gl.ladder[i].length; k++) {
				if (gl.ladder[i][k] == 0) {
					System.out.print(" │ ");
				} else {
					if (k < gl.ladder[i].length - 1 && gl.ladder[i][k + 1] == 1) {
						System.out.print(" ├─");
					}
					if (k != 0 && gl.ladder[i][k - 1] == 1) {
						System.out.print("─┤ ");
					}
				}
			}
			System.out.println();
		}
		System.out.print("번호 선택[1~5] : ");
		int sel = sc.nextInt() - 1;

		for (int i = 0; i < gl.ladder.length; i++) {
			for (int k = 0; k < gl.ladder[i].length; k++) {
				if (k == sel && gl.ladder[i][k] == 0) {
					gl.ladder[i][k] = 2;
				} else if (k == sel && gl.ladder[i][k] == 1) {
					if (k < gl.ladder[i].length - 1 && gl.ladder[i][k + 1] == 1) {
						gl.ladder[i][k] = 2;
						gl.ladder[i][k + 1] = 2;
						sel++;
					} else if (k != 0 && gl.ladder[i][k - 1] == 1) {
						gl.ladder[i][k] = 2;
						gl.ladder[i][k - 1] = 2;
						sel--;
					}
				}
			}
		}

		for (int i = 0; i < gl.ladder.length; i++) {
			for (int k = 0; k < gl.ladder[i].length; k++) {
				if (gl.ladder[i][k] == 2) {
					System.out.print(" * ");
				} else {
					if (gl.ladder[i][k] == 0) {
						System.out.print(" │ ");
					} else {
						if (k < gl.ladder[i].length - 1 && gl.ladder[i][k + 1] == 1) {
							System.out.print(" ├─");
						}
						if (k != 0 && gl.ladder[i][k - 1] == 1) {
							System.out.print("─┤ ");
						}
					}
				}
			}
			System.out.println();
		}
		System.out.println("오늘은 "+gl.menu[sel]+" 가자~");
		sc.close();
	}
}
