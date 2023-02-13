package p1_members;

import java.util.Scanner;
//MemberDAO.java
public class MemberDAO {
	Scanner scan;
	int max;
	int memberCount;
	Member1[] memberList;
	
	void init(int size) {
		memberList = new Member1[size];
	}

	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		System.out.print("▶ 선택 : ");
		int sel = sc.nextInt();
		if (sel < start || sel > end) {
			System.err.println("입력오류 [" + start + "~" + end + "]");
			return -1;
		}
		return sel;
	}

	String getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print("▶ " + msg + " :");
		String input = sc.next();
		return input;
	}

	void join() {
		Member1 mb = new Member1();
		mb.id = getValue("아이디");
		mb.pw = getValue("비밀번호");
		mb.name = getValue("이름");
		memberList[memberCount] = mb;
		memberCount++;
	}

	void delete() {
		String id = getValue("아이디");
		for (int i = 0; i < memberCount; i++) {
			if (memberList[i].id.equals(id)) {
				String pw = getValue("비밀번호");
				if (!memberList[i].pw.equals(pw)) {
					System.err.println("비밀번호가 틀립니다");
					return;
				} else {
					for (int k = i; k < memberCount - 1; k++) {
						memberList[k] = memberList[k + 1];
					}
					memberList[memberCount - 1] = new Member1();
					memberCount--;
					System.out.println("[계정삭제 완료]");
					return;
				}
			}
		}
		System.err.println("아이디를 찾을수 없습니다");
	}

	void update() {
		String id = getValue("아이디");
		for (int i = 0; i < memberCount; i++) {
			if (memberList[i].id.equals(id)) {
				String pw = getValue("비밀번호");
				if (!memberList[i].pw.equals(pw)) {
					System.err.println("비밀번호가 틀립니다");
					return;
				} else {
					int sel = getValue("[1]비밀번호 수정 [2]이름 수정", 1, 2);
					if (sel == -1) {
						continue;
					} else if (sel == 1) {
						String newPw = getValue("변경 비밀번호");
						memberList[i].pw = newPw;
						System.out.println("[비밀번호가 변경되었습니다]");
					} else if (sel == 2) {
						String newName = getValue("변경 이름");
						memberList[i].name = newName;
						System.out.println("[이름이 변경되었습니다]");
					}
					return;
				}
			}
		}
		System.err.println("아이디를 찾을수 없습니다");
	}

	void printAll() {
		int idx = 0;
		System.out.println("-------------------");
		System.out.printf("%-7s%-7s%-7s\n", "ID", "PW", "NAME");
		System.out.println("-------------------");
		for (Member1 mb : memberList) {
			System.out.printf("%-7s", mb.id);
			System.out.printf("%-7s", mb.pw);
			System.out.printf("%-7s\n", mb.name);
			idx++;
			if (idx == memberCount) {
				System.out.println("-------------------");
				return;
			}
		}
	}
}
