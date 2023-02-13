package p1_members;

import java.util.Scanner;

// MemberController.java (view : 메뉴 출력 , 키보드입력 받아오는 공간 )
public class MemberController {

	Scanner scan;
	MemberDAO mbDAO;

	void init() {
		scan = new Scanner(System.in);
		mbDAO = new MemberDAO();
		mbDAO.init(100);
	}

	void run() {
		while (true) {

			int sel = mbDAO.getValue("[1]추가 [2]삭제 [3]수정 [4]출력  [0]종료", 0, 4);
			if (sel == -1) {
				continue;
			} else if (sel == 1) {
				mbDAO.join();
			} else if (sel == 2) {
				mbDAO.delete();
			} else if (sel == 3) {
				mbDAO.update();
			} else if (sel == 4) {
				mbDAO.printAll();
			} else if (sel == 0) {
				System.out.println("[종료]");
				break;
			}
		}
	}

	public static void main(String[] args) {

		MemberController controller = new MemberController();
		controller.init();
		controller.run();
	}

}
