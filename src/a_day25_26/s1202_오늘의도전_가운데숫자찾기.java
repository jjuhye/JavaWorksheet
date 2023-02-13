package a_day25_26;

import java.util.Arrays;
import java.util.Scanner;

public class s1202_오늘의도전_가운데숫자찾기 {

	public static void main(String[] args) {
		// 문제1) 1~백만 사이의 숫자를 입력받고 가운데 숫자 출력
		// (단 ! 짝수자리의 수는 짝수자리라고 출력)
		// 예) 123 ==> 2
		// 예) 1234 ==> 짝수의 자리이다
		// 예) 1 ==> 1
		// 예) 1234567 ==> 4

		Scanner sc = new Scanner(System.in);
		System.out.print("1~백만 사이의 숫자입력 : ");
		int num = sc.nextInt();
		if (num < 1 && num > 100) {
			System.err.println("입력오류 : 1~백만");
		}
		String num2 = num + "";
		if (num2.length() % 2 == 0) {
			System.out.println(num + " ==> 짝수의 자리이다");
		} else {
			System.out.println(num + " ==> " + num2.charAt(num2.length() / 2));
		}
	}
}
