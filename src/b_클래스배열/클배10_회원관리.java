package b_클래스배열;

import java.util.Scanner;

//13:18~15:18
class Users {
	String id;
	String pw;
	int money;

	void printInfo() {
		System.out.printf("%s \t %s \t %d \t \n", id, pw, money);
	}
}

class UserDAO {
	Users list[];
	int cnt;
	int log = -1;
	int idx = -1;

	void init() {
		cnt = 3;
		Users u1 = new Users();
		u1.id = "aaaa";
		u1.pw = "1111";
		u1.money = 1000;
		Users u2 = new Users();
		u2.id = "bbbb";
		u2.pw = "2222";
		u2.money = 2000;
		Users u3 = new Users();
		u3.id = "cccc";
		u3.pw = "3333";
		u3.money = 3000;
		Users temp[] = { u1, u2, u3 };
		list = temp;
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

	String getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " >> ");
		String input = sc.next();
		return input;
	}

	void showMenu() {
		System.out.println("======================");
		System.out.println("[0] 종료");
		if (log == -1) {
			System.out.println("[1] 회원가입");
			System.out.println("[2] 로그인");
			System.out.println("[3] 전체 회원 목록");
		} else {
			System.out.println("[1] 탈퇴(비번확인)");
			System.out.println("[2] 수정(금액수정)");
			System.out.println("[3] 로그아웃");
		}
	}

	boolean isCheckId(String id) {
		for (int i = 0; i < cnt; i++) {
			if (id.equals(list[i].id)) {
				idx = i;
				return true;
			}
		}
		return false;
	}

	void addUser() {
		System.out.println("=======[회원 가입]=======");
		Users u = new Users();
		u.id = getValue("아이디");
		if (isCheckId(u.id)) {
			System.err.println("이미 존재하는 아이디");
			return;
		}
		u.pw = getValue("비밀번호");
		while (true) {
			u.money = getValue("충전금액", 1000, 1000000);
			if (u.money == -1) {
				continue;
			}
			break;
		}

		if (list == null) {
			list = new Users[1];
		} else {
			Users temp[] = list;
			list = new Users[cnt + 1];
			for (int i = 0; i < cnt; i++) {
				list[i] = temp[i];
			}
		}
		list[cnt] = u;
		System.out.println("[" + list[cnt].id + "님 회원가입 완료]");
		cnt++;
	}

	void login() {
		System.out.println("========[로그인]========");
		String id = getValue("아이디");
		if (isCheckId(id)) {
			String pw = getValue("비밀번호");
			if (!list[idx].pw.equals(pw)) {
				System.err.println("비밀번호가 틀립니다");
				return;
			}
			System.out.println("[" + list[idx].id + "님 로그인 완료]");
			log = 1;
		} else {
			System.err.println("아이디가 존재하지 않습니다");
		}
	}

	void printMember() {
		System.out.println("=======[회원 목록]=======");
		System.out.printf("%s \t %s \t %s \t \n", "아이디", "비밀번호", "충전금액");
		System.out.println("----------------------");
		for (Users u : list) {
			u.printInfo();
		}
	}

	boolean delUser() {
		System.out.println("=======[회원 탈퇴]=======");
		String pw = getValue("비밀번호");
		if (pw.endsWith(list[idx].pw)) {
			Users[] temp = list;
			cnt--;
			list = new Users[cnt];
			for (int i = 0; i < cnt; i++) {
				if (i >= idx) {
					temp[i].id = temp[i + 1].id;
					temp[i].pw = temp[i + 1].pw;
					temp[i].money = temp[i + 1].money;
				}
				list[i] = temp[i];
			}
			idx = -1;
			log = -1;
			System.out.println("[회원 탈퇴 완료]");
			return true;
		} else {
			System.err.println("비밀번호가 틀립니다");
			return false;
		}
	}

	void mdfUser() {
		System.out.println("=======[금액 수정]=======");
		int money = getValue("수정 금액", 1000, 1000000);
		if (money == -1) {
			return;
		}
		System.out.println("[충전 금액 수정 완료]");
		System.out.println("[" + list[idx].money + "원 >> " + money + "원]");
		list[idx].money = money;
	}

	boolean logout() {
		System.out.println("[" + list[idx].id + "님 로그아웃 완료]");
		idx = -1;
		log = -1;
		return true;
	}

	void run() {
		init();

		while (true) {
			showMenu();
			int sel = getValue("메뉴 선택", 0, 3);
			if (sel == -1) {
				continue;
			}
			if (sel == 0) {
				System.err.println("[회원관리 종료]");
				return;
			}
			if (log == -1) {
				if (sel == 1) {
					addUser();
				} else if (sel == 2) {
					login();
				} else if (sel == 3) {
					printMember();
				}
			} else {
				if (sel == 1) {
					if (delUser()) {
						continue;
					}
				} else if (sel == 2) {
					mdfUser();
				} else if (sel == 3) {
					if (logout()) {
						continue;
					}
				}
			}
		}
	}
}

public class 클배10_회원관리 {

	public static void main(String[] args) {

		UserDAO ud = new UserDAO();
		ud.run();

	}
}
