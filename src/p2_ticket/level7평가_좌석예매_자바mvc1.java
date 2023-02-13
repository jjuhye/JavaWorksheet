package p2_ticket;

import java.util.Scanner;

//14:00~17:20
class TicketController {

	User[] userList;
	int userCnt;
	int seatCnt;
	int log = -1;// 로그인 유저의 인덱스번호로 사용
	Seat[] seatList;

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

	void login() {
		String id = getValue("아이디 입력");
		String pw = getValue("비밀번호 입력");

		for (int i = 0; i < userCnt; i++) {
			if (userList[i].checkLog(id, pw)) {
				System.out.println("[로그인 되었습니다]");
				log = i;
				return;
			}
		}
		System.err.println("아이디/비밀번호를 확인하세요");
		return;
	}

	void logout() {
		log = -1;
		System.out.println("[로그아웃 되었습니다]");
	}

	void showSeat() {
		for (int i = 0; i < seatList.length; i++) {
			seatList[i].showNum(i + 1);
		}
		System.out.println();
		for (int i = 0; i < seatList.length; i++) {
			seatList[i].showData(seatList[i].check);
		}
		System.out.println();
		System.out.println("========================");
	}

	void getTicket() {
		showSeat();
		int sel = getValue("[예매] 번호 입력", 1, 8);
		if (sel == -1) {
			return;
		}
		seatList[sel - 1].check = true;
		seatList[sel - 1].userID = userList[log].id;
		System.out.println("[" + sel + "번좌석 예매완료]");
		seatCnt++;
		showSeat();
		return;
	}

	void cancelTicket() {
		int sel = getValue("[예매취소] 번호 입력", 1, 8);
		if (sel == -1) {
			return;
		}
		if (!seatList[sel - 1].check || !seatList[sel - 1].userID.equals(userList[log].id)) {
			System.err.println("예매한 좌석이 아닙니다");
			return;
		}
		seatList[sel - 1].check = false;
		seatList[sel - 1].userID = "";
		System.out.println("[예매 취소완료]");
		seatCnt--;
		showSeat();
		return;
	}

	void checkTicket() {
		System.out.println("-------------");
		int cnt = 0;
		for (Seat s : seatList) {
			if (userList[log].id.equals(s.userID)) {
				System.out.println(s.number + "번 좌석");
				cnt++;
			}
		}
		if (cnt == 0) {
			System.out.println("예매내역이 없습니다");
		}
		System.out.println("-------------");
	}

	int printMenu() {
		while (true) {
			if (log == -1) {
				while (true) {
					int sel = getValue("[1]로그인  [0]종료", 0, 1);
					if (sel == -1) {
						continue;
					}
					if (sel == 0) {
						System.err.println("[종료]");
						return -1;
					}
					login();
					break;
				}
			} else {
				while (true) {
					int sel = getValue("[1]영화예매 [2]예매취소 [3]예매확인 [0]로그아웃", 0, 3);
					if (sel == -1) {
						continue;
					}
					return sel;
				}
			}
		}
	}

	void init(int size) {
		seatList = new Seat[size];
		for (int i = 0; i < size; i++) {
			Seat s = new Seat("", i + 1, false);
			seatList[i] = s;
		}

		int idx = 0;
		String data[][] = { { "qwer", "1234" }, { "asdf", "4321" } };
		userList = new User[size];
		for (String[] info : data) {
			User u = new User(info[0], info[1]);
			userList[idx] = u;
			idx++;
			userCnt++;
		}
	}

	void run() {
		while (true) {
			int sel = printMenu();
			if (sel == -1) {
				return;
			}
			if (sel == 0) {
				logout();
				continue;
			}
			if (sel == 1) {
				getTicket();
			} else if (sel == 2) {
				cancelTicket();
			} else if (sel == 3) {
				checkTicket();
			}
		}
	}
}

public class level7평가_좌석예매_자바mvc1 {

	public static void main(String[] args) {

		TicketController controller = new TicketController();
		controller.init(8);
		controller.run();

	}
}
