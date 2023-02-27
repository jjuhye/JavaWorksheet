package Food_Machine;

public class MachineController {

	private MachineDAO mDAO;

	MachineController() {
		mDAO = new MachineDAO();
	}

	// 메인메뉴
	void mainMenu() {
		while (true) {
			System.out.println("[1]관리자");
			System.out.println("[2]사용자");
			System.out.println("[0]종료");

			int sel = mDAO.mUtil.getValue("메뉴 ", 0, 2);
			if (sel == 0) {
				System.err.println("[종료]");
				return;
			} else if (sel == 1) {
				printAdmin();
			} else if (sel == 2) {
				printUser();
			}
		}
	}

	// 관리자 메뉴
	private void printAdmin() {
		while (true) {
			System.out.println("[1]식권충전");
			System.out.println("[2]잔돈충전");
			System.out.println("[3]현황 출력");
			System.out.println("[4]현황 파일 저장");
			System.out.println("[5]현황 파일 불러오기");
			System.out.println("[6]파일 삭제하기");
			System.out.println("[0]뒤로가기");
			int sel = mDAO.mUtil.getValue("메뉴 ", 0, 6);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				mDAO.addTicket();
			} else if (sel == 2) {
				mDAO.addMoney();
			} else if (sel == 3) {
				mDAO.showData();
			} else if (sel == 4) {
				mDAO.saveStatement();
			} else if (sel == 5) {
				mDAO.openStatement();
			} else if (sel == 6) {
				mDAO.deleteStatement();
			}
		}
	}

	// 사용자 메뉴
	private void printUser() {
		while (true) {
			System.out.println("[1]식권구입");
			System.out.println("[0]뒤로가기");
			int sel = mDAO.mUtil.getValue("메뉴", 0, 1);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				mDAO.getTicket();
			}
		}
	}
}
