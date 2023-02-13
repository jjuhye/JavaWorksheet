package a_클래스;

import java.util.Arrays;
import java.util.Scanner;

class Movie {
	String name = "MEGA MOVIE";
	int[] seat = new int[7];
	int money = 0;
}

//11:10~11:20
public class 클래스02_좌석예매 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Movie m = new Movie();

		while (true) {

			System.out.println("[" + m.name + "]");
			System.out.println("[1]좌석예매");
			System.out.println("[2]종료하기");

			System.out.print("메뉴 선택 : ");
			int sel = sc.nextInt();

			if (sel == 1) {
				System.out.println("seat = " + Arrays.toString(m.seat));
				System.out.print("좌석선택 0~6: ");
				int input = sc.nextInt();

				if (input < 0 || input > 6) {
					System.err.println("좌석번호가 틀립니다!");
					continue;
				} else if (m.seat[input] != 0) {
					System.err.println("이미 예매가 완료된 자리입니다!");
					continue;
				} else {
					m.seat[input] = 1;
					m.money += 12000;
					System.out.println("==============");
					System.out.println(input + "번좌석 예매완료");
				}
				System.out.println("==============");
				System.out.println("매출액 : " + m.money + "원");
				System.out.println("==============");
			} else if (sel == 2) {
				break;
			} else {
				System.err.println("입력오류 : 1~2");
			}
		}
		sc.close();
	}
}