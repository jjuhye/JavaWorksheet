package day06;

import java.util.Scanner;

public class d_12ATM4단계 {

	public static void main(String[] args) {
		// 풀이시간 17:57~
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;

		int id = 0;
		int pw = 0;
		int money = 0;
		int log = -1; // -1(로그아웃), 1(dbAcc1로그인), 2(dbAcc2로그인)

		boolean run = true;
		while (run) {

			System.out.println("1.로그인");
			System.out.println("2.로그아웃");
			System.out.println("3.입금");
			System.out.println("4.출금");
			System.out.println("5.이체");
			System.out.println("6.조회");
			System.out.println("0.종료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (log != -1) {
					System.out.println("***이미 로그인 상태***");
					continue;
				}
				System.out.print("id >> ");
				id = scan.nextInt();
				System.out.print("pw >> ");
				pw = scan.nextInt();

				if (id == dbAcc1 && pw == dbPw1) {
					System.out.println("***dbAcc1님 로그인 성공***");
					log = 1;
				} else if (id == dbAcc2 && pw == dbPw2) {
					System.out.println("***dbAcc2님 로그인 성공***");
					log = 2;
				} else {
					System.out.println("***로그인 실패***");
				}
			} else if (sel == 2) {
				if (log == -1) {
					System.out.println("***이미 로그아웃 상태***");
					continue;
				}
				System.out.println("***로그아웃 되었습니다***");
				log = -1;
			} else if (sel == 3) {
				if (log == -1) {
					System.out.println("***로그인 후 이용가능***");
					continue;
				}
				while (true) {
					System.out.print("입금할 금액 : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("***0원 이상의 금액을 입금***");
						continue;
					}
					break;
				}
				System.out.println("***입금 완료***");
				if(log == 1) {
					dbMoney1 += money;
				}else {
					dbMoney2 += money;
				}
			} else if (sel == 4) {
				if (log == -1) {
					System.out.println("***로그인 후 이용가능***");
					continue;
				}
				while (true) {
					System.out.print("출금할 금액 : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0원 이상의 금액을 넣어주세요.");
						continue;
					}
					if (money > dbMoney1 || money > dbMoney2) {
						System.out.println("***잔액 부족***");
						continue;
					}
					break;
				}
				if(log == 1) {
					dbMoney1 -= money;
				}else {
					dbMoney2 -= money;
				}
				System.out.println("***출금 완료***");
			
			} else if (sel == 5) {
				if (log == -1) {
					System.out.println("***로그인 후 이용가능***");
					continue;
				}
				while (true) {
					System.out.print("이체 계좌번호 입력 : ");
					int acc = scan.nextInt();
					if (acc != dbAcc2 || acc != dbAcc1) {
						System.out.println("***계좌번호 오류***");
						continue;
					}
					break;
				}
				while (true) {
						System.out.println("이체 금액 입력 : ");
						money = scan.nextInt();
						if (money > dbMoney1 || money > dbMoney2) {
							System.out.println("***잔액 부족***");
							continue;
						}
						if(log == 1) {
							dbMoney1 -= money;
							dbMoney2 += money;
						}else {
							dbMoney2 -= money;
							dbMoney1 += money;
						}
						System.out.println("***이체 완료***");
						break;
					}
			
			} else if (sel == 6) {
				if (log == -1) {
					System.out.println("***로그인 후 이용가능***");
					continue;
				}
				System.out.println("1111계좌 잔액 : " + dbMoney1 + "원");
				System.out.println("2222계좌 잔액 : " + dbMoney2 + "원");
			} else if (sel == 0) {
				run = false;
				System.out.println("프로그램 종료");
			}
		}

	}

}
