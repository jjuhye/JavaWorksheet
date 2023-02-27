package S4_Cart;

import java.util.ArrayList;

import S2_Item.ItemController;
import S_Util.Util;

public class CartController {
	private CartController() {
	}

	private static CartController instance = new CartController();

	public static CartController getInstance() {
		return instance;
	}

	ItemController itemCtrl;
	CartDAO cartDAO;

	public void init() {
		cartDAO = new CartDAO();
		itemCtrl = ItemController.getInstance();
	}

	// 관리자 장바구니 메뉴
	public void cartAdmin() {
		while (true) {
			System.out.println("<<< 주문 관리 >>>");
			System.out.println("[1]장바구니 전체출력  [2]전체 주문내역 [0]뒤로가기");
			int sel = Util.getValue("선택", 0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				System.out.println(cartDAO.cartData());
			} else if (sel == 2) {
				if (cartDAO.orderData().equals("")) {
					System.out.println("[주문 데이터 없음]");
					continue;
				}
				System.out.println("===== 전체 주문내역 =====");
				System.out.println(cartDAO.orderData());
			}
		}
	}

	// 회원 주문내역
	public void orderMember(String id) {
		if (cartDAO.orderData(id).equals("")) {
			System.out.println("[주문 데이터 없음]");
			return;
		}
		System.out.println("===== " + id + " 주문내역 =====");
		System.out.println(cartDAO.orderData(id));
	}

	// 회원 장바구니
	public void cartMember(String id) {
		if (cartMemberData(id).equals("")) {
			System.out.println("[장바구니 비어있음]");
			return;
		}
		System.out.println(cartMemberData(id));
		// 주문하기, 장바구니 삭제
		while (true) {
			System.out.println("[1]주문하기 [2]장바구니 삭제 [0]뒤로가기");
			int sel = Util.getValue("선택", 0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				cartDAO.moveCartToOrder(id);
				System.out.println("[주문 완료]");
				return;
			} else if (sel == 2) {
				delItemInCart(id);
				if (cartMemberData(id).equals("")) {
					System.out.println("[장바구니 비어있음]");
					return; // 장바구니 비어있으면 뒤로가기
				}
				System.out.println(cartMemberData(id));
			}
		}
	}

	// 회원 장바구니 데이터
	public String cartMemberData(String id) {
		if (cartDAO.cartData(id).equals("")) {
			return "";
		}
		String data = "";
		data += "======= [" + id + "장바구니] =======\n";
		data += cartDAO.cartData(id);
		data += "--------------------------\n";
		data += "TOTAL : " + getTotalPrice(id) + "원\n";
		data += "==========================\n";
		return data;
	}

	// 회원 장바구니 전체 금액 출력
	public int getTotalPrice(String id) {
		int sum = 0;
		ArrayList<String> list = cartDAO.orderItem(id);
		for (String item : list) {
			sum += itemCtrl.getPrice(item);
		}
		return sum;
	}

	// 상품 장바구니 추가
	public void itemAddCartList(String id, String item, int price) {
		Cart cart = new Cart(cartDAO.getNextCartNo(), id, item, price);
		cartDAO.addCartList(cart);
		System.out.println("[" + item + " 장바구니 추가 완료]");
	}

	// 장바구니 상품 삭제
	public void delItemInCart(String id) {
		String item = Util.getString("삭제 상품명 입력");
		cartDAO.delCart(id, item);
	}

	// 아이템 장바구니 존재 여부 확인
	public boolean isItemInCart(String item) {
		if (cartDAO.isItem(item)) {
			return true;
		}
		return false;
	}
}
