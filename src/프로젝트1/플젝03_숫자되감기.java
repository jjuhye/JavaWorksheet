package 프로젝트1;

import java.util.Arrays;
import java.util.Scanner;

public class 플젝03_숫자되감기 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int game[][] = { { 1, 2, 3, 4 },
						 { 5, 6, 7, 8 },
						 { 9, 10, 11, 12 },
						 { 13, 14, 15, 0 } };
		int yx[][] = new int[10000][2];

		int idx = 0;
		yx[idx][0] = game.length - 1;
		yx[idx][1] = game[0].length - 1;

		int y = yx[idx][0];
		int x = yx[idx][1];

		while (true) {

			idx++;

			System.out.println("[1]left [2]right [3]up [4]down [5]되감기");
			System.out.print("번호 입력 >> ");
			int sel = sc.nextInt();

			if (sel == 1) {
				if (x == 0) {
					System.err.println("왼쪽으로 이동불가");
					idx--;
					continue;
				}
				game[y][x] = game[y][x - 1];
				game[y][x - 1] = 0;
				yx[idx][0] = y;
				yx[idx][1] = x - 1;
				x--;
			} else if (sel == 2) {
				if (x == game[0].length - 1) {
					System.err.println("오른쪽으로 이동불가");
					idx--;
					continue;
				}
				game[y][x] = game[y][x + 1];
				game[y][x + 1] = 0;
				yx[idx][0] = y;
				yx[idx][1] = x + 1;
				x++;
			} else if (sel == 3) {
				if (y == 0) {
					System.err.println("위로 이동불가");
					idx--;
					continue;
				}
				game[y][x] = game[y - 1][x];
				game[y - 1][x] = 0;
				yx[idx][0] = y - 1;
				yx[idx][1] = x;
				y--;
			} else if (sel == 4) {
				if (y == game.length - 1) {
					System.err.println("아래로 이동불가");
					idx--;
					continue;
				}
				game[y][x] = game[y + 1][x];
				game[y + 1][x] = 0;
				yx[idx][0] = y + 1;
				yx[idx][1] = x;
				y++;
			} else if (sel == 5) {
				idx--;
				if (idx == 0) {
					System.err.println("[시작 위치입니다]");
					continue;
				}
					game[y][x] = game[yx[idx - 1][0]][yx[idx - 1][1]];
					game[yx[idx - 1][0]][yx[idx - 1][1]] = 0;
					y = yx[idx - 1][0];
					x = yx[idx - 1][1];
					idx--;
			} else {
				System.err.println("입력오류 : 1~5");
				idx--;
				continue;
			}
			System.out.println("=================");
			for (int i = 0; i < game.length; i++) {
				System.out.println(Arrays.toString(game[i]));
			}
			System.out.println("=================");
			
			if(idx==100) {
				break;
			}
		}
		sc.close();
	}
}
