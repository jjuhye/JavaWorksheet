package day06;

import java.util.Random;
import java.util.Scanner;

public class ������ {

	public static void main(String[] args) {
		// 12:08~12:23
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);

		int x = rd.nextInt(10) + 1;
		int y = rd.nextInt(10) + 1;
		int op = rd.nextInt(4) + 1;
		int result = 0;

		if (op == 1) {
			result = x + y;
		}
		if (op == 2) {
			result = x - y;
		}
		if (op == 3) {
			result = x * y;
		}
		if (op == 4) {
			result = x % y;
		}

		System.out.printf("%d ? %d = %d\n", x, y, result);
		System.out.println("1.+ 2.- 3.* 4.%");
		System.out.print("���� >> ");
		int sel = sc.nextInt();

		if (sel < 1 || sel > 4) {
			System.out.println("�Է¿��� : 1~4");
		} else if ((x == y && result == 0) && (sel == 2 || sel == 4)) {
			System.out.println("�����Դϴ�.");
		} else if ((x == 2 && y == 2) && (sel == 1 || sel == 3)) {
			System.out.println("�����Դϴ�.");
		} else if (x == y + 1 && (sel == 2 || sel == 4)) {
			System.out.println("�����Դϴ�.");
		} else if (sel == op) {
			System.out.println("�����Դϴ�.");
		} else {
			System.out.println("���Դϴ�.");
		}

		// 2?2=4 + *
		// 2?2=0 - % 4?4 8?8
		// 8?7=1 6?5=1 - %
	}
}
