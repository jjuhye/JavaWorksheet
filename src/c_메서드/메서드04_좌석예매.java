package c_메서드;

//10:25~10:52
import java.util.Scanner;

class Theater {

	int[] seat = new int[10];
	Scanner scan = new Scanner(System.in);
	String name = ""; // 영화관 이름
	int cnt = 0; // 예매 수
	int money = 12000; // 매출액

	void showSeat() {
		System.out.println("==== [" + name + "] 좌석 현황 ====");
		for (int i = 0; i < seat.length; i++) {
			if (seat[i] == 1) {
				System.out.print("[" + i + "]■■");
			} else {
				System.out.print("[" + i + "]  ");
			}
			if (i % 5 == 4) {
				System.out.println();
			}
		}
	}

	void showMenu() {
		System.out.println("== [" + name + "] 메뉴 ==");
		System.out.println("[1] 예 매\n[2] 종 료");
	}

	void choiceSeat() {
		System.out.println("== [" + name + "] 예매 ==");
		System.out.print("좌석번호 선택 [0~9]: ");
		int sel = scan.nextInt();
		if (sel < 0 || sel > 9) {
			System.err.println("입력 오류 [0~9]");
		} else if (seat[sel] == 1) {
			System.err.println("이미 예매된 좌석");
		} else {
			seat[sel] = 1;
			System.out.println(sel + "번좌석 예매완료");
		}
	}

	void showSales() {
		System.out.println("=== 매출 현황 ===");
		for (int s : seat) {
			if (s == 1) {
				cnt++;
			}
		}
		System.out.println("총 예매수 : " + cnt);
		System.out.println("총 매출액 : " + cnt * money);
	}

}

public class 메서드04_좌석예매 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Theater megabox = new Theater();
		megabox.name = "메가박스";

		while (true) {
			megabox.showSeat();
			// 메뉴 출력
			megabox.showMenu();

			// 메뉴 선택하기
			System.out.print("메뉴 선택 : ");
			int choice = scan.nextInt();

			// 예매하기
			if (choice == 1) {
				megabox.choiceSeat();
			}
			// 종료하기
			else if (choice == 2) {
				// 매출 현황 출력하기
				megabox.showSales();
				System.out.println("[프로그램 종료]");
				break;
			} else {
				System.err.println("입력오류 [1~2]");
			}
		}
		scan.close();
	}
}
