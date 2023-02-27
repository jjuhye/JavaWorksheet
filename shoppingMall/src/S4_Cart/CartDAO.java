package S4_Cart;

import java.util.ArrayList;

public class CartDAO {

	private ArrayList<Cart> cartList;
	private ArrayList<Cart> orderList;
	private int cartNo;
	private int orderNo;

	public CartDAO() {
		cartList = new ArrayList<Cart>();
		orderList = new ArrayList<Cart>();
		cartNo = 0;
		orderNo = 1000;
	}

	public int getNextCartNo() {
		cartNo++;
		return cartNo;
	}

	public int getNextOrderNo() {
		orderNo++;
		return orderNo;
	}

	// 장바구니 > cartList에 추가
	public void addCartList(Cart c) {
		cartList.add(c);
	}

	// 회원별 주문완료 개수
	public int orderListCnt(String id) {
		int cnt = 0;
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getMemberID().equals(id)) {
				cnt++;
			}
		}
		return cnt;
	}

	// 장바구니 상품 삭제
	public void delCart(String id, String item) {
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMemberID().equals(id) && cartList.get(i).getItemName().equals(item)) {
				cartList.remove(i);
				System.out.println("[" + item + " 삭제 완료]");
				return;
			}
		}
		System.err.println("해당 상품이 존재하지 않습니다");
	}

	// 장바구니 상품 주문 시 orderList로 이동
	public void moveCartToOrder(String id) {
		for (int i = 0; i < cartList.size(); i++) {
			if (cartList.get(i).getMemberID().equals(id)) {
				Cart c = new Cart(getNextOrderNo(), cartList.get(i).getMemberID(), cartList.get(i).getItemName(),
						cartList.get(i).getItemPrice());
				addOrderList(c);
				cartList.remove(i);
				i--;
			}
		}
	}

	// 주문완료 상품 orderList에 추가
	public void addOrderList(Cart c) {
		orderList.add(c);
	}

	// 주문내역 전체 데이터
	public String orderData() {
		if (orderList.size() == 0) {
			return "";
		}
		System.out.println("===== 전체 주문내역 =====");
		String data = "";
		for (Cart c : orderList) {
			data += c.toStringAll();
		}
		return data;
	}

	// 회원별 주문내역
	public String orderData(String id) {
		String data = "";
		for (Cart c : orderList) {
			if (c.getMemberID().equals(id)) {
				data += c.toStringAll();
			}
		}
		return data;
	}

	// 장바구니 전체 데이터
	public String cartData() {
		if (cartList.size() == 0) {
			return "[장바구니 데이터 없음]";
		}
		System.out.println("===== 장바구니 전체 목록 =====");
		String data = "";
		for (Cart c : cartList) {
			data += c.toStringAll();
		}
		return data;
	}

	// 회원 장바구니 데이터
	public String cartData(String id) {
		if (cartList.size() == 0) {
			return "";
		}
		String data = "";
		int idx = 1;
		for (Cart c : cartList) {
			if (c.getMemberID().equals(id)) {
				data += idx + ") " + c.toString();
				idx++;
			}
		}
		return data;
	}

	// 회원 장바구니 아이템목록
	public ArrayList<String> orderItem(String id) {
		ArrayList<String> itemListInCart = new ArrayList<String>();
		for (Cart c : cartList) {
			if (c.getMemberID().equals(id)) {
				itemListInCart.add(c.getItemName());
			}
		}
		return itemListInCart;
	}

	// 아이템 장바구니 존재 여부 확인
	public boolean isItem(String item) {
		for (Cart c : cartList) {
			if (c.getItemName().equals(item)) {
				return true;
			}
		}
		return false;
	}
}
