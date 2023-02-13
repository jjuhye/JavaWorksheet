package p3_멤버저장;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberController {
	MemberDAO memberDAO;

	MemberController() {
		memberDAO = new MemberDAO();
	}

	int getValue(String msg, int start, int end) {
		// 예외처리 적용해보세요
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.printf("%s[%d-%d] 입력: ", msg, start, end);
		try {
			num = sc.nextInt();
			if (num < start || num > end) {
				throw new Exception(start + "~" + end + "값 입력해주세요");
			}
			return num;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
			num=-1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return num;
	}

	void mainMenu() {
		
		while (true) {
			System.out.println("[1]추가");
			System.out.println("[2]수정");
			System.out.println("[3]삭제");
			System.out.println("[4]전체출력");
			System.out.println("[5]파일저장");
			System.out.println("[6]파일로드");
			System.out.println("[0]종료");

			int sel = getValue("메뉴 ", 0, 6);
			if (sel == 0) {
				System.err.println("[종료]");
				return;
			} else if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.update();
			} else if (sel == 3) {
				memberDAO.remove();
			} else if (sel == 4) {
				memberDAO.printMember();
			} else if (sel == 5) {
				memberDAO.saveData();
			} else if (sel == 6) {
				memberDAO.loadData();
			}
		}
	}
}

