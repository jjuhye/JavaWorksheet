package p3_예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

class Ex001{
	int getValue(String msg ,int start, int end) {
		Scanner sc = new Scanner(System.in);
		int num=0;
		System.out.printf("%s[%d-%d] 입력: ",msg, start,end );
		try {
			num = sc.nextInt();
			if(num<start || num>end) {
				throw new Exception(start +"~"+end+"값 입력해주세요");
			}
			return num;
		}catch(InputMismatchException e) {
			// 숫자값 입력 : 숫자 아닌 값 에외처리 
			System.out.println("숫자만 입력해 주세요");

			// start end 범위 벗어난 숫자값 에외처리
		}catch(Exception e){
			num=0;
			System.out.println(e.getMessage());
		}
		return num;
	}
}

public class 문제1 {

	public static void main(String[] args) {
		
		Ex001 e1 = new Ex001();
		int num=e1.getValue("숫자값 입력 ", 1, 100);
		if(num!=0) {
			System.out.println("num =" + num);
		}
	}

}
