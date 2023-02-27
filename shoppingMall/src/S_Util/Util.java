package S_Util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
//	private static Scanner scan = new Scanner(System.in);

	// 메뉴 선택 예외처리 메소드
	public static int getValue(String msg, int start, int end) {
		Scanner scan = new Scanner(System.in);
		int sel = -1;
		System.out.printf("▶ %s[%d-%d] 입력: ", msg, start, end);
		try {
			sel = scan.nextInt();
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

	// 정수 입력
	public static int getInt(String msg) {
		Scanner scan = new Scanner(System.in);
		int sel = 0;
		System.out.print("▶ " + msg + ": ");
		try {
			sel = scan.nextInt();
			if (sel <= 0) {
				throw new Exception("0이하 입력불가");
			}
			return sel;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return sel;
	}

	// 문자열 입력
	public static String getString(String msg) {
		Scanner scan = new Scanner(System.in);
		System.out.print("▶ " + msg + ": ");
		String input = scan.nextLine();
		return input;
	}
}
