package 흐흐흐;

import java.util.Arrays;
import java.util.Scanner;

class Money {
	int money;
	int change;
}

class VendingMachine {
	int tickets = 5;
	int price = 3200;
	int moneyTotal;

	Money list[] = new Money[6];

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.println("===============");
		System.out.println(msg);
		System.out.print("▶ 선택 : ");
		int sel = sc.nextInt();
		if (sel < start || sel > end) {
			System.err.println("입력오류 [" + start + "~" + end + "]");
			return -1;
		}
		return sel;
	}

	int getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print("▶ " + msg + " :");
		int sel = sc.nextInt();
		return sel;
	}

	void init() {
		int[] moneys = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] changes = { 1, 1, 1, 1, 5, 10 };

		// 금액 단위별 개수 클래스배열 생성
		for (int i = 0; i < list.length; i++) {
			list[i] = new Money();
			list[i].money = moneys[i];
			list[i].change = changes[i];
		}
	}

	void printBalance() {
		moneyTotal = 0;
		for (int i = 0; i < list.length; i++) {
			moneyTotal += list[i].money * list[i].change;
		}
		System.out.println("[잔액 : " + moneyTotal + "원]");
	}

	void addTicket() {
		int cnt = getValue("충전 매수");
		tickets += cnt;
		System.out.println("[식권" + cnt + "매 충전완료]");
		System.out.println("[현재 식권 : " + tickets + "매]");
	}

	void addMoney() {
		while (true) {
			String msg = "[0]5만원, [1]만원, [2]5천원, [3]천원, [4]5백원, [5]백원";
			int idx = getValue("<<충전 단위>>\n" + msg, 0, 5);
			if (idx == -1) {
				continue;
			} else {
				int cnt = getValue("충전 개수");
				list[idx].change += cnt;
				System.out.println("[" + list[idx].money + "원권 " + cnt + "개 충전완료]");
				printBalance();
				return;
			}
		}
	}

	void outChange(int balance) {
		System.out.println("=== 구매 완료 ===");
		System.out.println("잔돈 총 : " + balance + "원");
		for (int i = 0; i < list.length; i++) {
			int unit = list[i].money;
			if (balance / unit >= 0) {
				int cnt = balance / unit;
				if (list[i].change < cnt) {
					cnt = list[i].change;
				}
				if (cnt > 0) {
					list[i].change -= cnt;
					System.out.printf("[%d원\t: %d개]\n", unit, cnt);
				}
				balance -= cnt * unit;
			}
		}
	}

	void getTicket() {
		int input = getValue("입금 금액 입력");
		int buy = getValue("구매 매수 입력");
		int sum = buy * price;
		int balance = input - sum;
		System.out.println("==================");
		System.out.println("식권 가격 : " + sum + "원");
		System.out.println("식권 수량 : " + buy + "매");
		if (buy > tickets) {
			System.err.println("!!매진!! 현재 잔량 : " + tickets + "매");
			return;
		} else if (balance < 0) {
			System.err.println("!!금액부족!!");
			return;
		} else if (balance > moneyTotal) {
			System.err.println("!!잔돈부족!!");
			return;
		} else {
			outChange(balance);
			tickets -= buy;
		}
	}

	void printAdmin() {
		while (true) {
			int choice = getValue("[0]뒤로가기\n[1]식권충전\n[2]잔돈충전", 0, 2);
			if (choice == -1) {
				continue;
			} else if (choice == 0) {
				return;
			} else if (choice == 1) {
				addTicket();
			} else if (choice == 2) {
				addMoney();
			}
		}
	}

	void printUser() {
		while (true) {
			int sel = getValue("[0]뒤로가기\n[1]식권구입", 0, 1);
			if (sel == -1) {
				continue;
			} else if (sel == 0) {
				return;
			} else if (sel == 1) {
				getTicket();
			}
		}
	}

	void run() {
		init();
		while (true) {
			int sel = getValue("[0]종료\n[1]관리자\n[2]사용자", 0, 2);
			if (sel == -1) {
				continue;
			} else if (sel == 0) {
				System.err.println("[종료]");
				return;
			} else if (sel == 1) {
				printAdmin();
			} else if (sel == 2) {
				printUser();
			}
		}
	}
}

public class 식권자판기 {

	public static void main(String[] args) {

		VendingMachine vm = new VendingMachine();
		vm.run();

	}
}
