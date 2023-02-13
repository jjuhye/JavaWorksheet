package p3_예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

public class 예외이론_1 {

	public static void main(String[] args) {
		/* try-catch
		try {
			예외가 발생할 수 있는 코드 부분
		} catch(처리할 예외 타입1 e1) {
		    try 블록 안에서 예외1가 발생했을 때 예외를 처리하는 부분
		} catch(처리할 예외 타입2 e2) {
			    try 블록 안에서 예외2가 발생했을 때 예외를 처리하는 부분
		} catch(Exception e) {
			    try 블록 안에서 예외가 발생했을 때 예외를 처리하는 부분
		}
		try 블록에는 예외가 발생할 가능성이 있는 코드를 작성한다. 만약 try 블록 안에서 예외가 발생하면 바로 catch 블록이 수행된다.catch 문의 괄호 안에 쓰는 예외 타입은 예외 상황에 따라 달라진다.
		하나의 try 블록 다음에는 여러 종류의 예외를 처리할 수 있도록 하나 이상의 catch 블록이 올 수 있으며, 이 중 발생한 예외의 종류와 일치하는 단 한 개의 catch 블록만 수행된다.
		모든 예외 클래스는 Exception 클래스의 하위 클래스이므로 catch 블록의 괄호 안에 Exception 클래스 타입의 참조 변수를 선언해 놓으면 어떤 종류의 예외가 발생하더라도 이 catch 블록에 의해서 처리된다.
		가장 최상위 클래스인 Exception 클래스는 가장 마지막 블록에 위치해야 한다.
		*/
		
//		int x = 10;
//		int y = 0;

//		
//		if (y != 0) {
//			System.out.println(x / y);
//		} else {
//			System.out.println("0으로 나눌 수 없습니다");
//		}

//		int arr[] = new int[4];
//		System.out.println(arr[4]);

		// 다른 방식
		Scanner sc = null;
		try {
			sc = new Scanner(System.in);

			int x = 10;
			System.out.println("y값 입력:");
			int y = sc.nextInt();
			System.out.println(x / y);

			System.out.println("예외처리 발생 후 코드블럭1");
 
//			String name = null;
//			System.out.println(name.length());
//			  System.out.println("예외처리 발생 후 코드블럭2");

		} catch (NullPointerException e) {
			System.out.println(" 빈 객체 메서드 호출 ");
			// e.printStackTrace(); // 호출한 메서드의 기록
		} catch (ArithmeticException e) {
			System.out.println(" 0 으로 나눌 수 없습니다");
		} finally {
			// 예외와 상관없이 반드시 마지막에 실행
			System.out.println(" 테스트 ");
			sc.close();
		}

		System.out.println("예외처리 완료 ");
		
//숫자 값 입력 안 받았을 때 예외처리 예시
//		Scanner sc = null;
		try {
			sc = new Scanner(System.in);
			System.out.println("숫자 입력>>");
			int num = sc.nextInt();
			System.out.println("num =" + num);
		}catch(InputMismatchException e) {
			System.out.println("숫자만 입력해 주세요");
			e.printStackTrace();
		}finally {
			sc.close();
		}
		
		System.out.println(" 프로그램 종료");
		
	}
}
