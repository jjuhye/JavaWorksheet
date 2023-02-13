package 프로젝트1;

import java.util.Arrays;
import java.util.Scanner;

public class 플젝01_식권자판기 {

	public static void main(String[] args) {
		// 10:34~12:53

		Scanner scan = new Scanner(System.in);

		int[] money = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] charges = { 1, 1, 1, 1, 5, 10 };

		int tickets = 5; // 식권 개수
		int price = 3200; // 식권 가격
		int moneyTotal = 0;
		for (int i = 0; i < money.length; i++) {
			moneyTotal += money[i] * charges[i];
		}

		while (true) {

			System.out.println("[1]관리자");
			System.out.println("[2]사용자");

			System.out.print("▶메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				while (true) {
					System.out.println("1)식권충전");
					System.out.println("2)잔돈충전");
					System.out.println("0)뒤로가기");

					System.out.print("▶메뉴 선택 : ");
					int choice = scan.nextInt();
					if (choice < 0 && choice > 2) {
						System.err.println("입력오류 : 0~2");
					} else if (choice == 1) {
						System.out.print("▶충전 매수 >> ");
						tickets += scan.nextInt();
						System.out.println("[식권 : " + tickets + "매]");
					} else if (choice == 2) {
						System.out.println("[0]5만원, [1]만원, [2]5천원, [3]천원, [4]5백원, [5]백원");
						System.out.print("▶충전 단위 0~5 >> ");
						int won = scan.nextInt();
						System.out.print("▶충전 개수 >> ");
						charges[won] += scan.nextInt();
						for (int i = 0; i < money.length; i++) {
							moneyTotal += money[i] * charges[i];
						}
						System.out.println("[잔돈 현황 : 총 " + moneyTotal + "원]");
						System.out.println(Arrays.toString(money));
						System.out.println(Arrays.toString(charges));
					} else if (choice == 0) {
						break;
					}
				}

			} else if (sel == 2) {
				while (true) {
					System.out.println("1)구입");
					System.out.println("0)뒤로가기");
					System.out.print("▶메뉴 선택 : ");
					int choice = scan.nextInt();
					if (choice < 0 && choice > 1) {
						System.err.println("입력오류 : 0~1");
					} else if (choice == 1) {
						System.out.print("▶입금 금액 입력 : ");
						int input = scan.nextInt();
						System.out.print("▶구매 매수 입력 : ");
						int buy = scan.nextInt();
						int sum = buy * price;
						int balance = input - sum;
						System.out.println("==================");
						System.out.println("식권 가격 : " + sum + "원");
						System.out.println("식권 수량 : " + buy + "매");
						if (buy > tickets) {
							System.out.println("!!매진!! 현재 잔량 : " + tickets + "매");
							break;
						}
						if (sum > input) {
							System.out.println("!!금액부족!!");
							break;
						}
						if (balance > moneyTotal) {
							System.out.println("!!잔돈부족!!");
							break;
						} else {
							tickets -= buy;
							System.out.println("=== 구매완료 ===");
							System.out.println("잔돈 총 : " + balance + "원");
							int cnt = 0;
							for (int i = 0; i < money.length; i++) {
								int unit = money[i];
								if (balance / unit >= 0) {
									cnt = balance / unit;
									if (charges[i] < cnt) {
										cnt = charges[i];
									}
									balance -= cnt * unit;
									if (cnt > 0) {
										System.out.printf("[%d원\t: %d매]\n", unit, cnt);
									}
								}
							}
						}
					} else if (choice == 0) {
						break;
					}
				}
			} else {
				System.err.println("입력오류 : 1~2");
			}
		}
	}
}
