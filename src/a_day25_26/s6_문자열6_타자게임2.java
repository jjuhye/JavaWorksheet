package a_day25_26;

import java.util.Random;
import java.util.Scanner;

public class s6_문자열6_타자게임2 {

	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] words = { "java", "mysql", "jsp", "spring" };

		for (int i = 0; i < words.length; i++) {
			int idx = rd.nextInt(words.length);
			String temp = words[0];
			words[0] = words[idx];
			words[idx] = temp;
		}

		boolean corr = true;
		int star = -1;
		for (int i = 0; i < words.length; i++) {
			if (corr) {
				star = rd.nextInt(words[i].length());
			}
			System.out.print("문제[" + (i + 1) + "] ");
			for (int j = 0; j < words[i].length(); j++) {
				if (star == j) {
					System.out.print("*");
				} else {
					System.out.print(words[i].charAt(j));
				}
			}
			System.out.println();
			System.out.print("입력 : ");
			String input = sc.next();

			if (!input.equals(words[i])) {
				System.err.println("오답 / 재시도");
				i--;
				corr = false;
				continue;
			}
			corr = true;
		}
		System.out.println("게임 종료");
	}
}
