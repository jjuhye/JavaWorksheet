package day06;

import java.util.Scanner;

public class ATM3 {

	public static void main(String[] args) {
		// 풀이시간 16:59~
		Scanner scan = new Scanner(System.in);

		int myAcc = 1111;
		int myMoney = 50000;

		int yourAcc = 2222;
		int yourMoney = 70000;

		int money = 0;

		boolean run = true;
		while (run) {

			System.out.println("===========");
			System.out.println("1.입금");
			System.out.println("2.출금");
			System.out.println("3.이체");
			System.out.println("4.조회");
			System.out.println("0.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel < 0 || sel > 4) {
				System.out.println("[입력오류] 0~4중에 선택");
				continue;
			}

			if (sel == 1) {
				while (true) {
					System.out.print("입금할 금액 : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0원 이상의 금액을 넣어주세요.");
						continue;
					}
					break;
				}
				System.out.println("***입금 완료***");
				myMoney += money;
			} else if (sel == 2) {
				while (true) {
					System.out.print("출금할 금액 : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0원 이상의 금액을 넣어주세요.");
						continue;
					}
					if (money > myMoney) {
						System.out.println("***잔액 부족***");
						continue;
					}
					break;
				}
				myMoney -= money;
				System.out.println("***출금 완료***");
			} else if (sel == 3) {
				while (true) {
					System.out.print("이체 계좌번호 입력 : ");
					int acc = scan.nextInt();
					if (acc != yourAcc) {
						System.out.println("***계좌번호 오류***");
						continue;
					}
					break;
				}
				while (true) {
						System.out.println("이체 금액 입력 : ");
						money = scan.nextInt();
						if (money > myMoney) {
							System.out.println("***잔액 부족***");
							continue;
						}
						myMoney -= money;
						yourMoney += money;
						System.out.println("***이체 완료***");
						break;
					}
			} else if (sel == 4) {
				System.out.println("1111계좌 잔액 : " + myMoney + "원");
				System.out.println("2222계좌 잔액 : " + yourMoney + "원");
			} else if (sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}
	}
}
