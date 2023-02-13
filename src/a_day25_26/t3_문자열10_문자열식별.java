package a_day25_26;

import java.util.Scanner;

public class t3_문자열10_문자열식별 {

	public static void main(String[] args) {
		/*
		 * # 문자열 속 숫자검사 예) adklajsiod 문자만 있다. 예) 123123 숫자만 있다. 예) dasd12312asd 문자와 숫자가
		 * 섞여있다.
		 */

		Scanner scan = new Scanner(System.in);

		System.out.print("입력 : ");
		String text = scan.next();
		int cnt = 0;
		
		for (int i = 0; i < text.length(); i++) {
			char temp = text.charAt(i);
			if (temp>='0' && temp<='9') {
				cnt++;
			}
		}
		
		if(cnt==text.length()) {
			System.out.println("숫자만 있다");
		}else if(cnt==0) {
			System.out.println("문자만 있다");
		}else {
			System.out.println("문자와 숫자가 섞여있다");
		}
		
//		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
//		for (int i = 0; i < text.length(); i++) {
//			for (int k = 0; k < num.length; k++) {
//				char temp = text.charAt(i);
//				if (temp == num[k]) {
//					cnt++;
//					break;
//				}
//			}
//		}
//		if(cnt==text.length()) {
//			System.out.println("숫자만 있다");
//		}else if(cnt==0) {
//			System.out.println("문자만 있다");
//		}else {
//			System.out.println("문자와 숫자가 섞여있다");
//		}
	}
}
