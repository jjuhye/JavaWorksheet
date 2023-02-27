package day06;

import java.util.Scanner;

public class ATM2 {

	public static void main(String[] args) {
		// 풀이시간 16:37~16:47
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;

		int id = 0;
		int pw = 0;

		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)

		boolean run = true;
		while (run) {

			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("0.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (log != -1) {
					System.out.println("이미 로그인 상태");
					continue;
				}
				System.out.println("id >> ");
				id = scan.nextInt();
				System.out.println("pw >> ");
				pw = scan.nextInt();

				if (id == dbAcc1 && pw == dbPw1) {
					System.out.println("dbAcc1님 로그인 성공 ");
					log = 1;
				} else if (id == dbAcc2 && pw == dbPw2) {
					System.out.println("dbAcc2님 로그인 성공 ");
					log = 1;
				} else {
					System.out.println("[로그인 실패] ID/PW가 틀립니다.");
				}

			} else if (sel == 2) {

				if (log == -1) {
					System.out.println("이미 로그아웃 상태");
					continue;
				}
				System.out.println("로그아웃 되었습니다.");
				log = -1;
			} else if (sel == 0) {
				run = false;
				System.out.println("==프로그램 종료==");
			}else {
				System.out.println("[입력오류] 0~2중에서 입력");
			}
		}

	}

}
