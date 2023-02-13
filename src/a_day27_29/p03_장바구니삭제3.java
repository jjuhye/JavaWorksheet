package a_day27_29;

import java.util.Arrays;
import java.util.Scanner;

public class p03_장바구니삭제3 {

	public static void main(String[] args) {
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
				System.out.println("[2]쇼  핑");
				System.out.println("[3]장바구니");
				System.out.println("[4]전체주문목록");
			}
			System.out.println("[0]종  료");

			System.out.print("메뉴 선택 : ");
			int sel = scan.nextInt();

			if (sel == 0) {
				System.err.println("[프로그램 종료]");
				break;
			}
			if (sel < 0 || sel > 4) {
				System.err.println("입력오류: 0~4");
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
				} else if (check == 2) {
					System.err.println("[로그인 성공]");
					continue;
				}
			} else if (sel == 2) {
				System.out.println("[1]사과  [2]바나나  [3]딸기");
				while (true) {
					System.out.print("아이템 선택 (선택종료[0]) : ");
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
				while (true) {
					System.out.println("=== " + idList[log] + "님 장바구니 ===");

					boolean check = false;
					for (int i = 0; i < qty.length; i++) {
						if (qty[i] != 0) {
							System.out.println(items[i] + " >> " + qty[i] + "개");
							check = true;
						}
					}
					if (!check) {
						System.out.println("장바구니가 비어있습니다");
					}
					System.out.println("----------------");
					System.out.println("[0] 장바구니 닫기 [1]아이템 삭제 [2] 전체 삭체");
					System.out.print("메뉴 입력 : ");
					int input = scan.nextInt();
					if (input < 0 || input > 2) {
						System.err.println("입력오류 : 0~2");
						continue;
					}
					if (input == 0) {
						break;
					}
					if (input == 1) {
						System.out.print("[삭제] 아이템 입력 : ");
						String delItem = scan.next();
						for (int i = 0; i < count; i++) {
							if (idList[log].equals(cartList[i][0]) && delItem.equals(cartList[i][1])) {
								for (int k = 0; k < items.length; k++) {
									if (delItem.equals(items[k]) && qty[k] > 0) {
										for (int j = i; j < count - 1; j++) {
											cartList[j] = cartList[j + 1];
										}
										cartList[count - 1] = new String[2];
										qty[k]--;
										count--;
										i = count;
										break;
									} else if (qty[k] == 0) {
										System.err.println("삭제할 아이템이 없습니다.");
										break;
									}
								}
							}
						}
						String[][] tempCart = new String[count][2];
						for (int i = 0; i < tempCart.length; i++) {
							tempCart[i] = cartList[i];
						}
						System.out.println("======================");
						for (int i = 0; i < count; i++) {
							cartList[i] = tempCart[i];
						}
					}
					if (input == 2) {
						for (int i = count; i >= 0; i--) {
							if (idList[log].equals(cartList[i][0])) {
								for (int j = i; j < count - 1; j++) {
									cartList[j] = cartList[j + 1];
								}
								cartList[count - 1] = new String[2];
								count--;
							}
						}
						qty = new int[items.length];
						System.out.println("[전체 삭제 완료]");
						break;
					}
				}

			} else if (sel == 4) {
				System.out.println("=== 전체 주문 목록 ===");
				if (count == 0) {
					System.out.println("주문 목록이 없습니다.");
				} else {
					for (int i = 0; i < count; i++) {
						System.out.println(Arrays.toString(cartList[i]));
					}
				}
			}
			System.out.println();
		}
		scan.close();
	}
}
