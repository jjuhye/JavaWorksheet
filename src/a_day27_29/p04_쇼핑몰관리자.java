package a_day27_29;

import java.util.Arrays;
import java.util.Scanner;

public class p04_쇼핑몰관리자 {

	public static void main(String[] args) {
		/*
		 * 16:50~ # 쇼핑몰 [관리자] 1. 카테고리와 아이템을 입력받아 아래의 예시와 같이 저장한다. 2. 카테고리는 각 행의 첫번째 열에
		 * 저장한다. 3. 아이템은 각 행의 두번째 열에 저장한다. 단, 아이템은 여러개를 추가할 수 있도록 슬러시(/)를 구분자로 연결해준다. 예)
		 * { {"과일", "사과/포도/"}, {"과자", "홈런볼/쪼리퐁/"}, {"음료", "콜라/"}, {"육류", "소고기/"} ... }
		 */

		Scanner scan = new Scanner(System.in);

		String data = "과일,사과/포도\n";
		data += "과자,홈런볼/조리퐁\n";
		data += "음료,콜라/사이다/나랑드\n";
		data += "육류,소고기/돼지고기/오리고기/닭고기\n";

		String[] temp = data.split("\n");
		int count = temp.length;

		String[][] items = new String[100][2];
		for (int i = 0; i < items.length; i++) {
			if (i < count) {
				items[i] = temp[i].split(",");
				continue;
			}
			items[i][0] = "";
			items[i][1] = "";
		}
		while (true) {

			System.out.println("[관리자 모드]");
			System.out.println("[1]카테고리 관리"); // 카데고리 추가 삭제 구현
			System.out.println("[2]아 이 템  관리"); // 아이템 추가 삭제 구현
			System.out.println("[3]전체품목 출력");

			System.out.print(">> ");
			int sel = scan.nextInt();

			if (sel == 1) {
				System.out.println("[카테고리 관리]");
				for (int i = 0; i < count; i++) {
					System.out.println("[" + (i + 1) + "] " + items[i][0]);
				}
				System.out.println("(1)추가 (2)삭제 (3)뒤로");
				System.out.print(">> ");
				int input = scan.nextInt();

				if (input == 3) {
					continue;
				} else if (input < 1 || input > 3) {
					System.err.println("입력오류 : 1~3");
					continue;
				} else if (input == 1) {
					System.out.print("[추가] 카테고리 입력 >> ");
					String ctg = scan.next();
					boolean check = true;
					for (String[] item : items) {
						if (ctg.equals(item[0])) {
							System.err.println("중복 카테고리 입력불가");
							check = false;
							break;
						}
					}
					if (check) {
						items[count][0] = ctg;
						count++;
					}
				} else if (input == 2) {
					if (count == 0) {
						System.err.println("삭제할 카테고리가 없습니다.");
						continue;
					}
					System.out.print("[삭제] 카테고리 번호입력 : ");
					int ctg = scan.nextInt();
					for (int i = count - 1; i >= 0; i--) {
						if (ctg - 1 == i) {
							for (int k = i; k < count; k++) {
								items[k] = items[k + 1];
							}
							items[count - 1][0] = "";
							items[count - 1][1] = "";
							count--;
						}
					}
				}

			} else if (sel == 2) {
				while (true) {
					System.out.println("[아이템 관리]");
					System.out.println("(1)추가 (2)삭제 (3)뒤로");
					System.out.print(">> ");
					int input = scan.nextInt();
					if (input == 3) {
						break;
					} else if (input < 1 || input > 3) {
						System.err.println("입력오류 : 1~3");
						continue;
					} else if (input == 1) {
						for (int i = 0; i < count; i++) {
							System.out.println("[" + (i + 1) + "] " + items[i][0]);
						}
						System.out.print("카테고리 번호 선택 >> ");
						int inputCtg = scan.nextInt();
						if (input < 1 || input > count) {
							System.err.println("입력오류 : 1~" + count);
							continue;
						} else {
							if (items[inputCtg - 1][1].equals("") == false) {
								System.out.print("현재 아이템 : " + items[inputCtg - 1][1] + "\n");
							}
							System.out.print("[추가] 아이템 입력 >> ");
							String inputItem = scan.next();
							String[] tempItem = items[inputCtg - 1][1].split("/");
							boolean check = true;
							for (String item : tempItem) {
								if (inputItem.equals(item)) {
									System.err.println("중복 아이템 입력불가");
									check = false;
									break;
								}
							}
							if (check) {
								if (items[inputCtg - 1][1].equals("") == false) {
									items[inputCtg - 1][1] += "/";
								}
								items[inputCtg - 1][1] += inputItem;
								System.out.println("[" + inputItem + "] 추가되었습니다.");
								System.out.println(Arrays.toString(items[inputCtg - 1]));
								continue;
							} else {
								continue;
							}
						}
					} else if (input == 2) {
						for (int i = 0; i < count; i++) {
							System.out.println("[" + (i + 1) + "] " + items[i][0]);
						}
						System.out.print("카테고리 번호 선택 >> ");
						int inputCtg = scan.nextInt();
						if (input < 1 || input > count) {
							System.err.println("입력오류 : 1~" + count);
							continue;
						} else {
							System.out.print("현재 아이템 : " + items[inputCtg - 1][1] + "\n");
							System.out.print("[삭제] 아이템 입력 >> ");
							String inputItem = scan.next();
							String[] tempItem = items[inputCtg - 1][1].split("/");
							boolean check = false;
							for (String del : tempItem) {
								if (del.equals(inputItem)) {
									items[inputCtg - 1][1] = items[inputCtg - 1][1].replaceAll(inputItem + "/", "");
									items[inputCtg - 1][1] = items[inputCtg - 1][1].replaceAll("/" + inputItem, "");
									items[inputCtg - 1][1] = items[inputCtg - 1][1].replaceAll(inputItem, "");
									check = true;
									System.out.println(Arrays.toString(items[inputCtg - 1]));
									break;
								}
							}
							if (!check) {
								System.err.println("삭제할 아이템이 없습니다.");
								continue;
							} else {
								System.out.println("[" + inputItem + "] 삭제되었습니다.");
								System.out.print("현재 아이템 : " + items[inputCtg - 1][1] + "\n");
							}
						}
					}
				}

			} else if (sel == 3) {
				System.out.println("=== 전체 품목 ===");
				for (int i = 0; i < count; i++) {
					System.out.println(Arrays.toString(items[i]));
				}
			} else {
				System.err.println("입력오류 : 1~3");
				continue;
			}
			if (count == 100) {
				break;
			}
		}
		scan.close();
	}
}
