package S2_Item;

import S4_Cart.CartController;
import S_Util.Util;

public class ItemController {
	private ItemController() {
	}

	private static ItemController instance = new ItemController();

	public static ItemController getInstance() {
		return instance;
	}

	private CartController cartCtrl;
	private ItemDAO itemDAO;

	public void init() {
		cartCtrl = CartController.getInstance();
		itemDAO = new ItemDAO();
	}

	// 아이템 목록 출력
	public void showItem() {
		System.out.println("---------------------------------------");
		System.out.printf("  %-4s %7s %7s %7s\n", "품번", "카테고리", "상품명", "가격");
		System.out.println("---------------------------------------");
		itemDAO.printItem();
		System.out.println("---------------------------------------");
	}

	// 아이템 리스트에 추가
	public void addItemList() {
		int no = itemDAO.getNextItemNumber();
		itemDAO.printCategoryList();
		String category = Util.getString("카테고리 입력");
		if (!itemDAO.isCategory(category)) {
			System.out.println("[새 카테고리 생성]");
		}
		String itemName = Util.getString("상품명 입력");
		if (itemDAO.checkItem(itemName)) {
			System.err.println("이미 존재하는 상품");
			return;
		}
		int price = Util.getInt("가격 입력");
		if (price < 0) {
			return;
		}
		Item item = new Item(no, category, itemName, price);
		itemDAO.addItem(item);
		System.out.println("[" + itemName + " 추가 완료]");
	}

	// 아이템 리스트에서 삭제
	public void delItemList() {
		String item = Util.getString("삭제 상품명 입력");
		if (itemDAO.checkItem(item)) {
			// 장바구니에 담긴 상품이 있으면 삭제불가
			if (cartCtrl.isItemInCart(item)) {
				System.err.println("장바구니에 담긴 상품 삭제불가");
				return;
			}
			itemDAO.delItem(item);
			System.out.println("[" + item + " 삭제 완료]");
			return;
		}
		System.err.println("상품이 존재하지 않습니다!");
	}

	// 아이템 장바구니에 추가
	public void addCart(String id) {
		String item = Util.getString("주문 상품명 입력");
		if (itemDAO.checkItem(item)) {
			int price = itemDAO.checkPrice(item);
			cartCtrl.itemAddCartList(id, item, price);
			return;
		}
		System.err.println("입력하신 상품이 없습니다");
	}

	// 아이템 가격 확인
	public int getPrice(String item) {
		int price = itemDAO.checkPrice(item);
		return price;
	}
}
