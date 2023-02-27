package S3_Admin;

import S1_Member.Member;
import S1_Member.MemberController;
import S2_Item.ItemController;
import S4_Cart.CartController;
import S_Util.Util;

public class AdminController {
	private AdminController() {
	}

	private static AdminController instance = new AdminController();

	public static AdminController getInstance() {
		return instance;
	}

	MemberController memCtrl;
	CartController cartCtrl;
	ItemController itemCtrl;

	public void init() {
		memCtrl = MemberController.getInstance();
		cartCtrl = CartController.getInstance();
		itemCtrl = ItemController.getInstance();
		setAdmin();
	}

	// 관리자 설정
	private void setAdmin() {
		Member member = new Member(1, "admin", "admin", "관리자");
		memCtrl.addAdmintoMember(member);
	}

	// 관리자 메뉴
	public void adminMenu() {
		while (true) {
			System.out.println("<<< 관리자 페이지 >>>");
			System.out.println("[1]회원관리 [2]상품관리 [3]주문관리 [4]게시판관리 [0]로그아웃");
			int sel = Util.getValue("선택", 0, 4);
			if (sel == 0) {
				memCtrl.memberLogout();
				System.out.println("[로그아웃 완료]");
				return;
			} else if (sel == 1) {
				memberAdmin();
			} else if (sel == 2) {
				itemAdmin();
			} else if (sel == 3) {
				cartCtrl.cartAdmin();
			} else if (sel == 4) {
				memCtrl.boardMenu("admin");
			}
		}
	}

	// 관리자 회원관리 메뉴
	private void memberAdmin() {
		while (true) {
			System.out.println("<<< 회원 관리 >>>");
			System.out.println("[1]회원목록  [2]회원별 주문내역  [0]뒤로가기");
			int sel = Util.getValue("선택", 0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				memCtrl.printMember();
			} else if (sel == 2) {
				String id = Util.getString("회원ID");
				if (!memCtrl.isMember(id)) {
					System.err.println("존재하지 않는 아이디");
					continue;
				}
				cartCtrl.orderMember(id);
			}
		}
	}

	// 관리자 상품관리 메뉴
	private void itemAdmin() {
		while (true) {
			System.out.println("<<< 상품 관리 >>>");
			System.out.println("[1]상품전체출력 [2]아이템추가 [3]아이템삭제 [0]뒤로가기");
			int sel = Util.getValue("선택", 0, 3);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				itemCtrl.showItem();
			} else if (sel == 2) {
				itemCtrl.addItemList();
			} else if (sel == 3) {
				itemCtrl.delItemList();
			}
		}
	}
}
