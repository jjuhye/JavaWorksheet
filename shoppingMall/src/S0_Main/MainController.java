package S0_Main;

import S1_Member.MemberController;
import S3_Admin.AdminController;
import S_Util.Util;

public class MainController {
	private MainController() {
	}

	private static MainController instance = new MainController();

	public static MainController getInstance() {
		return instance;
	}

	private String loginMemberID;
	private MemberController memCtrl;
	private AdminController adCtrl;

	public void init() {
		memCtrl = MemberController.getInstance();
		adCtrl = AdminController.getInstance();
	}

	//메인 메뉴
	public void mainMenu() {
		while (true) {
			System.out.println("<<<< 쇼핑몰 >>>>");
			System.out.println("[1]로그인  [2]회원가입  [0]종료");
			int sel = Util.getValue("선택", 0, 2);
			if (sel == 0) {
				System.err.println("[종료]");
				return;
			} else if (sel == 1) {
				loginMemberID = memCtrl.memberLogin();
				if (loginMemberID == null) {
					System.err.println("로그인 실패");
					continue;
				} else if (loginMemberID.equals("admin")) {
					System.out.println("[관리자 로그인 완료]");
					adCtrl.adminMenu();
				} else {
					System.out.println("[" + loginMemberID + "님 로그인 완료]");
					memCtrl.memberMenu(loginMemberID);
				}
				if (memCtrl.logout) {
					loginMemberID = null;
				}
			} else if (sel == 2) {
				memCtrl.memberJoin();
			}
		}
	}
}
