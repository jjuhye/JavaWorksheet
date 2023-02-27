package day06;

import java.util.Scanner;

public class 배열응용1 {

	public static void main(String[] args) {
		System.out.println("[문제1]");
		Scanner scan = new Scanner(System.in);
		int a[] = { 10, 49, 51, 36, 17 };
		System.out.print("리스트 입력 : ");
		int list = scan.nextInt();
		for (int i = 0; i < a.length; i++) {
			if (list == a[i]) {
				System.out.println(list + " ==> " + i);
			}
		}

		System.out.println();
		System.out.println("[문제2]");
		int b[] = { 0, 0, 0, 0, 0 };
		System.out.print("b = [");
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 2 == 1) {
				b[i] = a[i];
			}
			System.out.print(b[i] + " ");
		}
		System.out.println("]");

		System.out.println();
		System.out.println("[문제3]");
		int c[] = { 0, 0, 0, 0, 0 };
		int j = 0;
		for (int i = 0; i < c.length; i++) {
			if (a[i] % 2 == 1) {
				c[j] = a[i];
				j++;
			}
		}
		System.out.print("c = [");
		for (int i = 0; i < c.length; i++) {
			if (i < c.length - 1) {
				System.out.print(c[i] + ", ");
			} else {
				System.out.print(c[i]);
			}
		}
		System.out.print("]");

		System.out.println();
		System.out.println("[문제4]");
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
		System.out.print("학번 입력: ");
		int hak = scan.nextInt();

		int idx = -1;
		for (int i = 0; i < arr.length; i += 2) {
			if (hak == arr[i]) {
				idx = i + 1;
				break;
			}
		}
		if (idx != -1) {
			System.out.println(hak + " ==> " + arr[idx]);
		} else {
			System.out.println("입력오류!!");
		}

		System.out.println();
		System.out.println("[문제5]"); 
		System.out.print("점수 입력: ");
		int score = scan.nextInt();

		idx = -1;
		for (int i = 0; i < arr.length; i++) {
			if (score == arr[i]) {
				idx = i - 1;
				break;
			}
		}
		if (idx != -1) {
			System.out.println(score + " ==> " + arr[idx]);
		} else {
			System.out.println("입력오류!!");
		}
	}
}
