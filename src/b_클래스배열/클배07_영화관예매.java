package b_클래스배열;

import java.util.Scanner;

//12:35~13:20

class SeatVO {
	int num;
	boolean check;
}

class SeatDAO {
	SeatVO[] seatList = new SeatVO[8];
	String name;
	int cnt;
	int money;

	void init() {
		name = "메가박스";
		int idx = 0;
		for (SeatVO s : seatList) {
			s = new SeatVO();
			seatList[idx] = s;
			idx++;
		}
	}

	void printMenu() {
		System.out.println("[1]예매하기");
		System.out.println("[2]종료");
	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " >> ");
		int sel = sc.nextInt();

		if (sel < start || sel > end) {
			System.err.println("입력오류 [" + start + "~" + end + "]");
			return -1;
		}
		return sel;
	}

	int getMenu() {
		int sel = getValue("메뉴 입력", 1, 2);
		if (sel == -1) {
			return -1;
		}
		return sel;
	}

	void printSeat() {
		System.out.println("================");
		System.out.println("1 2 3 4 5 6 7 8");
		for (SeatVO s : seatList) {
			if (s.check) {
				System.out.print("■ ");
			} else {
				System.out.print("□ ");
			}
		}
		System.out.println("\n================");
	}

	void getSeat() {
		while (true) {
			if (cnt == seatList.length) {
				System.err.println("[매진입니다]");
				return;
			}
			printSeat();
			int seat = getValue("좌석번호 선택", 1, seatList.length);
			if (seat == -1) {
				return;
			} else if (seatList[seat - 1].check == true) {
				System.err.println("이미 예매된 좌석");
				continue;
			} else {
				seatList[seat - 1].num = 1;
				seatList[seat - 1].check = true;
				cnt++;
				System.out.println("[" + seat + "번 좌석 예매완료]");
				printSeat();
				return;
			}
		}
	}

	void printMoney() {
		money = cnt * 12000;
		System.out.println("[총 매출액 : " + money + "원]");
	}

	void run() {
		init(); // 초기화
		while (true) {
			printMenu(); // 메뉴 출력
			int sel = getMenu(); // 메뉴 선택
			if (sel == -1) {
				continue;
			} else if (sel == 1) {
				getSeat(); // 예매하기
				continue;
			}
			// 종료 -> 매출액 출력
			else if (sel == 2) {
				System.err.println("[종료]============");
				printMoney();
				return;
			}
		}

	}
}

public class 클배07_영화관예매 {

	public static void main(String[] args) {

		SeatDAO dao = new SeatDAO();
		dao.run();

	}

}
