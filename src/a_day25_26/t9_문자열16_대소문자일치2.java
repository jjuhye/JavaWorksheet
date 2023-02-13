package a_day25_26;

import java.util.Iterator;
import java.util.Scanner;

public class t9_문자열16_대소문자일치2 {

	public static void main(String[] args) {
		/*
		 * [문제] 아이디와 비밀번호를 입력받고 로그인을 처리한다. 단, 아이디와 비밀번호는 (1) 대문자로 입력하던 (2) 소문자로 입력하던 (3)
		 * 대소문자를 섞어서 입력하던 전부 동일하게 인식되어야 한다.
		 */

		Scanner scan = new Scanner(System.in);

		String dbId = "q1w2e3r4";
		String dbPw = "r4e3w2q1";

		System.out.println(">>> 로그인 <<<");
		System.out.print("아이디를 입력하세요 : ");
		String myId = scan.next();
		String temp = "";
		for (int i = 0; i < myId.length(); i++) {
			if (myId.charAt(i) >= 65 && myId.charAt(i) <= 90) {
				temp += (char)(myId.charAt(i)+32)+"";
				continue;
			}
			temp += myId.charAt(i);
		}
		myId = temp;

		if (!(dbId.equals(myId))) {
			System.err.println("아이디가 일치하지 않습니다.");
			System.err.println("로그인 실패");
		} else {
			System.out.print("비밀번호를 입력하세요 : ");
			String myPw = scan.next();
			temp = "";
			for (int i = 0; i < myPw.length(); i++) {
				if (myPw.charAt(i) >= 65 && myPw.charAt(i) <= 90) {
					temp += (char)(myPw.charAt(i) + 32) +"";
					continue;
				}
				temp += myPw.charAt(i);
			}
			myPw = temp;

			if (!(dbPw.equals(myPw))) {
				System.err.println("로그인 실패");
			} else {
				System.out.println("로그인 성공");
			}
		}
	}
}
