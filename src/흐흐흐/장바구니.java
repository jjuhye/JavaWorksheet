package test;

import java.util.Arrays;
import java.util.Scanner;

public class 장바구니 {

	public static void main(String[] args) {
		// 15:30~17:40
		Scanner scan = new Scanner(System.in);

		String[] idList = { "qwer", "javaking", "abcd" };
		String[] pwList = { "1111", "2222", "3333" };

		int MAX_SIZE = 100;
		String[][] cartList = new String[MAX_SIZE][2];

		String[] items = { "사과", "바나나", "딸기" };

		int log = -1;
		int count = 0;
		while (true) {
			System.out.println("[MEGA MART]");
			if (log == -1) {
				System.out.println("[1]로 그 인");
			}
			if (log != -1) {
				System.out.println("[1]로그아웃");
				System.out.println("[2]쇼     핑");
				System.out.println("[3]장바구니");
			}
			System.out.println("[0]종     료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 0) {
				System.err.println("[프로그램 종료]");
				break;
			}
			if (sel < 0 || sel > 3) {
				System.err.println("입력오류: 0~3");
				continue;
			}
			if (log == -1 && (sel >= 2 && sel <= 3)) {
				System.err.println("현재 서비스 이용불가");
				continue;
			}
			if (sel == 1 && log != -1) {
				System.err.println("[로그아웃 성공]");
				log = -1;
				continue;
			} else if (sel == 1 && log == -1) {
				System.out.print("아이디 입력 : ");
				String id = scan.next();
				int check = 0;
				for (int i = 0; i < idList.length; i++) {
					if (id.equals(idList[i])) {
						check++;
						System.out.print("비밀번호 입력 : ");
						String pw = scan.next();
						for (int k = 0; k < pwList.length; k++) {
							if (pw.equals(pwList[k])) {
								check++;
								log = i;
								i = idList.length;
								break;
							}
						}
					}
				}
				if (check == 0) {
					System.err.println("아이디가 틀립니다.");
					continue;
				} else if (check == 1) {
					System.err.println("비밀번호가 틀립니다.");
					continue;
				} else {
					System.err.println("[로그인 성공]");
					continue;
				}
			} else if (sel == 2) {
				System.out.println("[1]사과  [2]바나나  [3]딸기 [0]쇼핑 종료");
				while (true) {
					System.out.print("아이템 선택 : ");
					int input = scan.nextInt();
					if (input == 0) {
						break;
					}
					if (input < 0 || input > 3) {
						System.err.println("입력오류 : 0~3");
					}
					for (int i = 0; i < items.length + 1; i++) {
						if (input == i) {
							System.out.println(items[i - 1] + " 1개 장바구니 등록");
							cartList[count][0] = idList[log];
							cartList[count][1] = items[i - 1];
							count++;
							break;
						}
					}
				}
			} else if (sel == 3) {
				int[] qty = new int[3];
				for (int i = 0; i < cartList.length; i++) {
					if (cartList[i][0] != idList[log]) {
						continue;
					}
					for (int k = 0; k < items.length; k++) {
						if (cartList[i][1] == items[k]) {
							qty[k]++;
						}
					}
				}
				System.out.println("=== " + idList[log] + "님 장바구니 ===");
				for (int i = 0; i < qty.length; i++) {
					if (qty[i] != 0) {
						System.out.println(items[i] + " >> " + qty[i] + "개");
					}
				}
				System.out.println();
			} else if (sel == 4) {

				System.out.println(Arrays.toString(cartList[count]));
			}
		}
	}
}
