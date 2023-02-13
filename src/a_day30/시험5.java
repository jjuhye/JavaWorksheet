package a_day30;

import java.util.Arrays;
import java.util.Scanner;

//9:42~

class User {
	String id;
}

class Seat {
	int y;
	int x;
	String userId;
	boolean check;
	int price;
}

public class 시험5 {

	public static void main(String[] args) {
		int seatPrice = 12000;

		String[] userIdList = { "aaa", "bbb", "ccc" };
		String[][] seatUserIdList = { { null, "aaa", "aaa", null }, { null, null, "bbb", null },
				{ "ccc", "bbb", null, "bbb" } };
		User[] userList = new User[userIdList.length];
		int seatSize = 12;
		Seat[] seatList = new Seat[seatSize];

		Scanner scan = new Scanner(System.in);

		for (int i = 0; i < userList.length; i++) {
			userList[i] = new User();
			userList[i].id = userIdList[i];
		}
		int idx = 0;
		for (int i = 0; i < seatUserIdList.length; i++) {
			for (int k = 0; k < seatUserIdList[i].length; k++) {
				seatList[idx] = new Seat();
				if (seatUserIdList[i][k] == null) {
					seatList[idx].check = false;
					seatList[idx].userId = "";
				} else {
					seatList[idx].check = true;
					seatList[idx].userId = seatUserIdList[i][k];
				}
				idx++;
			}
		}

		while (true) {
			System.out.println("\n[0] 종료\n" + "[1] 전체출력\n" + "[2] 회원 aaa가 예약한 자리와 요금출력\n" + "[3] 예약가능한자리 위치출력 \n"
					+ "[4] 예약을 가장많이한 회원출력");
			int sel = scan.nextInt();
			if (sel == 0) {
				System.err.println("[종료]");
				break;
			} else if (sel == 1) {
				System.out.println("===[좌석예매]===");
				for (int i = 0; i < seatSize; i++) {
					if (seatList[i].check) {
						System.out.printf("[%5s]", seatList[i].userId);
					} else {
						System.out.printf("[%5s]", "");
					}
					if (i % 4 == 3) {
						System.out.println();
					}
				}
			} else if (sel == 2) {
				String user = "aaa";
				System.out.println("===[좌석예매(" + user + ")]===");
				idx = 0;
				int cnt = 0;
				for (Seat s : seatList) {
					if (s.userId.equals("")) {
						System.out.printf("[%5s]", "");
					} else if (s.userId.equals(user)) {
						System.out.printf("[%5s]", s.userId);
						cnt++;
					} else {
						System.out.printf("[%5s]", "X");
					}
					if (idx % 4 == 3) {
						System.out.println();
					}
					idx++;
					if (idx == seatList.length) {
						System.out.println("총 금액은 " + cnt * seatPrice + "원 입니다.");
					}
				}
			} else if (sel == 3) {
				idx = 0;
				int cnt = 0;
				int[] blank = new int[seatSize];
				System.out.println("===[좌석예매]===");
				for (Seat s : seatList) {
					if (s.userId.equals("")) {
						System.out.printf("[%5s]", "O");
						blank[cnt] = idx;
						cnt++;
					} else {
						System.out.printf("[%5s]", "X");
					}
					if (idx % 4 == 3) {
						System.out.println();
					}
					idx++;
				}
				System.out.print("예매가능한 좌석 번호 : ");
				for (int i = 0; i < cnt; i++) {
					System.out.print(blank[i] + 1 + " ");
				}
			} else if (sel == 4) {
				int max = 0;
				int maxIdx = -1;
				for (int i = 0; i < userList.length; i++) {
					int cnt = 0;
					for (Seat s : seatList) {
						if (userList[i].id.equals(s.userId)) {
							cnt++;
						}
					}
					if (cnt > max) {
						max = cnt;
						maxIdx = i;
					}
				}
				System.out.println("예약을 가장 많이 한 회원 : " + userList[maxIdx].id);
			} else {
				System.err.println("입력오류 [0~4]");
			}
		}
		scan.close();
	}
}
