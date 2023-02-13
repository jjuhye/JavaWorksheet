package a_day25_26;

import java.util.Scanner;

public class s3_문자열3_동일 {

	public static void main(String[] args) {
		// 15:26~

		Scanner sc = new Scanner(System.in);
		String answer = "코끼리";

		System.out.print("코끼리 입력 : ");
		String input = sc.next();
		boolean check = true;

		for (int i = 0; i < answer.length(); i++) {
			if (answer.charAt(i) != input.charAt(i) || answer.length() != input.length()) {
				check = false;
				break;
			}
		}
		System.out.println(check);
	}
}
