package test;

import java.util.Arrays;
import java.util.Scanner;

public class 시험4 {

	public static void main(String[] args) {
		/*
		 * 9:50~ # 2차원 회원관리데이터 [1] 번호 [2] 아이디 [3] 비밀번호 [4] 이름 테스트를 위해 아래 기본데이터 4개를 넣고
		 * 시작한다.
		 */

		Scanner scan = new Scanner(System.in);
		// 번호 아이디 비번 이름
		String[] test1 = { "1001", "aaa", "aaa123", "김철수" };
		String[] test2 = { "1002", "bbb", "bbb123", "이민수" };
		String[] test3 = { "1003", "ccc", "ccc123", "박영희" };
		String[] test4 = { "1004", "ddd", "ddd123", "최민정" };
		int cnt = 4; // 현재 맴버 수
		String[][] mList = new String[100][4]; // 최대100명 데이타는4

		String menu = "[회원관리] \n [1] 추가 [2] 삭제 [3] 수정 [4] 검색 [5] 출력 [0] 종료 \n";

		String temp[][] = { test1, test2, test3, test4 };

		// 기존 데이터 번호순으로 미리 정렬처리
		for (int i = 0; i < cnt; i++) {
			for (int k = i; k < cnt; k++) {
				if (Integer.parseInt(temp[k][0]) < Integer.parseInt(temp[i][0])) {
					String[] tempArr = temp[i];
					temp[i] = temp[k];
					temp[k] = tempArr;
				}
				mList[i] = temp[i];
				mList[k] = temp[k];
			}
		}

		while (true) {
			System.out.println(menu);

			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 5) {
				// 번호와 이름 출력
				for (int i = 0; i < cnt; i++) {
					System.out.println("번호: " + mList[i][0] + "   이름: " + mList[i][3]);
				}
			}

			else if (sel == 1) {
				System.out.print("아이디 입력 : ");
				String id = scan.next();

				// 아이디 중복검사
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						check = true;
					}
				}
				if (check) {
					System.err.println("중복아이디가 있습니다.");
					continue;
				}

				// 비번은 숫자만 하면 에러 뜨게
				System.out.print("비밀번호 입력 : ");
				String pw = scan.next();
				int count = 0;

				for (int i = 0; i < pw.length(); i++) {
					if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
						count++;
					}
				}
				if (count == pw.length()) {
					System.err.println("비밀번호는 숫자만 입력 불가");
					continue;
				}

				// 이름은 숫자 있으면 에러뜨게
				System.out.print("이름 입력 : ");
				String name = scan.next();
				check = false;
				for (int i = 0; i < name.length(); i++) {
					if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
						System.err.println("이름에 숫자 입력 불가");
						check = true;
						break;
					}
				}
				if (check) {
					continue;
				}

				// 번호는 최대 큰 번호에서 +1 숫자 한 값
				mList[cnt][0] = Integer.parseInt(mList[cnt - 1][0]) + 1 + "";
				mList[cnt][1] = id;
				mList[cnt][2] = pw;
				mList[cnt][3] = name;
				System.out.println(name + "님 회원가입 완료");
				cnt++;

			} else if (sel == 2) {
				// 삭제할 번호 입력받아서 삭제 => 정렬 다시 해줘야함 =>
				System.out.print("번호 입력 : ");
				String num = scan.next();

				int idx = -1;
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (num.equals(mList[i][0])) {
						mList[i] = mList[i + 1];
						mList[i + 1] = new String[4];
						cnt--;
						check = true;
					}
				}
				if (check == false) {
					System.err.println("번호가 없습니다.");
					continue;
				}

			} else if (sel == 3) {
				// 수정 => id 와 비번 입력받고 맞으면 해당 id의 비번 혹은 이름만 수정 가능
				System.out.print("아이디 입력 : ");
				String id = scan.next();

				int idx = -1;
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						System.out.print("비밀번호 입력 : ");
						String pw = scan.next();
						if (pw.equals(mList[i][2])) {
							idx = i;
							check = true;
							continue;
						}
					}
				}
				if (check == false) {
					System.err.println("아이디, 비밀번호가 틀립니다.");
					continue;
				} else {
					System.out.println("[1] 이름 수정, [2] 비밀번호 수정");
					int input = scan.nextInt();
					if (input == 1) {
						System.out.print("새 이름 입력 : ");
						String name = scan.next();
						for (int i = 0; i < name.length(); i++) {
							if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
								System.err.println("이름에 숫자 입력 불가");
								continue;
							}
						}
						mList[idx][3] = name;
					} else if (input == 2) {
						System.out.print("새 비밀번호 입력 : ");
						String pw = scan.next();
						int count = 0;

						for (int i = 0; i < pw.length(); i++) {
							if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
								count++;
							}
						}
						if (count == pw.length()) {
							System.err.println("비밀번호는 숫자만 입력 불가");
							continue;
						}
						mList[idx][2] = pw;
					} else {
						System.err.println("입력오류 : 1~2");
						continue;
					}
				}

			} else if (sel == 4) {
				// 검색 => id 검색 입력 받아서 이름 출력
				System.out.print("아이디 입력 : ");
				String id = scan.next();

				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						System.out.println(id + " >> " + mList[i][3]);
						check = true;
					}
				}
				if (check == false) {
					System.err.println("아이디가 없습니다.");
					continue;
				}
			}
		}
		scan.close();
	}
}
