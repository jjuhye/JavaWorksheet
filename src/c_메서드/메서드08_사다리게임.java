package c_메서드;

import java.util.Scanner;

class LadderGame {

	Scanner scan = new Scanner(System.in);

	int[][] ladder = {
			{ 0, 0, 0, 0, 0 }, 
			{ 1, 2, 0, 1, 2 }, 
			{ 0, 1, 2, 0, 0 },
			{ 0, 0, 1, 2, 0 },
			{ 0, 1, 2, 0, 0 },
			{ 1, 2, 0, 0, 0 },
			{ 0, 0, 0, 1, 2 },
			{ 0, 0, 0, 0, 0 } };

	int xIdx = 0;
	int yIdx = 0;

	void showLadder() {
		System.out.println(" 1  2  3  4  5 ");
		for (int i = 0; i < ladder.length; i++) {
			for (int k = 0; k < ladder[i].length; k++) {
				if (ladder[i][k] == 1) {
					System.out.print(" ├─");
				} else if (ladder[i][k] == 2) {
					System.out.print("─┤ ");
				} else if (ladder[i][k] == 8) {
					System.out.print(" ● ");
				} else {
					System.out.print(" │ ");
				}
			}
			System.out.println();
		}
	}

	int getValue(String msg, int start, int end) {
		while (true) {
			System.out.print(msg + " [" + start + "~" + end + "] : ");
			int sel = scan.nextInt();
			if (sel < start || sel > end) {
				System.err.println("입력 오류 [" + start + "~" + end + "]");
				sel = -1;
				continue;
			}
			System.out.println("=================");
			return sel;
		}
	}

	int moveLadder(int sel) {
		for (int[] ld : ladder) {
			if (ld[sel] == 0) {
				ld[sel] = 8;
				continue;
			} else if (ld[sel] == 1) {
				ld[sel] = 8;
				sel++;
			} else if (ld[sel] == 2) {
				ld[sel] = 8;
				sel--;
			}
			ld[sel] = 8;
		}

		showLadder();

		return sel;
	}

	String setMenu() {
		String[] menu = { "김밥", "죽", "치킨", "빵", "피자" };
		for (String m : menu) {
			System.out.print(m + " ");
		}
		System.out.println("\n=================");
		return menu[xIdx];
	}

	void run() {

		showLadder();

		// 사다리 선택하기
		xIdx = getValue("번호 선택", 1, 5) - 1;

		// 사다리 이동하기
		xIdx = moveLadder(xIdx);

		String menu = setMenu(); // 메뉴설정하기 : 메뉴는 본인이 먹고싶은걸로 정하세요

		System.out.println("오늘의 점심 메뉴는 " + menu + " 입니다~!!!");

	}
}

public class 메서드08_사다리게임 {

	public static void main(String[] args) {
		
		LadderGame lg = new LadderGame();
		lg.run();

	}

}
