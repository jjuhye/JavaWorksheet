package a_day25_26;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class s5_문자열5_타자게임 {

	public static void main(String[] args) {
		// 16:32~
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		String[] words = { "java", "mysql", "jsp", "spring" };

		for (int i = 0; i < words.length; i++) {
			int temp = rd.nextInt(words.length);
			String temp1 = words[0];
			words[0] = words[temp];
			words[temp] = temp1;
		}
//		System.out.println(Arrays.toString(words));
		for (int i = 0; i < words.length; i++) {
			System.out.println("문제 : " + words[i]);
			System.out.print("입력 : ");
			String input = sc.next();
			if (input.equals(words[i])) {
				System.out.println(">> 정답");
			} else {
				System.out.println(">> 오답");
				i--;
			}
		}
		System.out.println("게임 종료");
	}
}
