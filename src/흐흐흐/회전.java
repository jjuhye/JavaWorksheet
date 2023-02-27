package test;

import java.util.Scanner;

public class 회전 {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);

		int block[][] = {
						{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16},
		};
		int temp[][] = new int[4][4];

		System.out.println("[1.left_turn] [2.right_turn] [3.End]");

		for (int i = 0; i < block.length; i++) {
			for (int k = 0; k < block.length; k++) {
				System.out.printf("[%2d] ", block[i][k]);
			}
			System.out.println();
		}
		while (true) {
			System.out.print("회전 방향 입력 >> ");
			int input = sc.nextInt();
			if (input < 1 || input > 3) {
				System.err.println("입력오류 : 1~3");
			}
			if (input == 1) {
				for (int i = 0; i < block.length; i++) {
					int idx = block.length - 1;
					for (int k = 0; k < block[i].length; k++) {
						temp[idx][i] = block[i][k];
						idx--;
					}
				}
			}
			if (input == 2) {
				int idx = block.length - 1;
				for (int i = 0; i < block.length; i++) {
					for (int k = 0; k < block[i].length; k++) {
						temp[k][idx] = block[i][k];
					}
					idx--;
				}
			}
			if (input == 3) {
				System.out.println("종료");
				break;
			}
			block = temp;
			temp = new int[4][4];
			for (int i = 0; i < block.length; i++) {
				for (int k = 0; k < block.length; k++) {
					System.out.printf("[%2d] ", block[i][k]);
				}
				System.out.println();
			}
		}
	}
}
