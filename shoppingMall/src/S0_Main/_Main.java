package S0_Main;

import S1_Member.MemberController;
import S2_Item.ItemController;
import S3_Admin.AdminController;
import S4_Cart.CartController;

public class _Main {
	public static void main(String[] args) {

		MainController.getInstance().init();
		MemberController.getInstance().init();
		AdminController.getInstance().init();
		CartController.getInstance().init();
		ItemController.getInstance().init();
		MainController.getInstance().mainMenu();
	}
}
