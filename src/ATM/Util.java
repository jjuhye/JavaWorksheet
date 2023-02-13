package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {

	// 메뉴 선택 예외처리 메소드
	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		System.out.printf("▶ %s[%d-%d] 입력: ", msg, start, end);
		try {
			sel = sc.nextInt();
			if (sel < start || sel > end) {
				throw new Exception(start + "~" + end + "값 입력해주세요");
			}
			return sel;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sel;
	}

	// 숫자값 입력 예외처리 메소드
	int getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		System.out.print("▶ " + msg + " :");
		try {
			sel = sc.nextInt();
			return sel;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sel;
	}
	
	// 숫자값 입력 예외처리 메소드
	String getString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print("▶ " + msg + " :");
			msg = sc.next();
			return msg;
	}
	
}
