package b_클래스배열;

import java.util.Scanner;

/* 9:35~
class User{
	String id;
}

class Item{
	String name;
	int price;
}

class Cart{
	String userId;
	String itemName;
}
 */

public class 클배06_장바구니2 {

	public static void main(String[] args) {
		String[] userIdList = { "aaa", "bbb", "ccc" };

		String[] itemNameList = { "사과", "칸초", "귤", "감" };
		int[] itemPriceList = { 10000, 2000, 6500, 3300 };

		String[] cartUserIdList = { "aaa", "ccc", "aaa", "bbb", "aaa", "ccc" };
		String[] cartItemNameList = { "칸초", "귤", "칸초", "사과", "감", "사과" };

		User[] userList = new User[userIdList.length];
		for (int i = 0; i < userList.length; i++) {
			userList[i] = new User();
			userList[i].id = userIdList[i];
		}

		Item[] itemList = new Item[itemNameList.length];
		for (int i = 0; i < itemList.length; i++) {
			itemList[i] = new Item();
			itemList[i].name = itemNameList[i];
			itemList[i].price = itemPriceList[i];
		}

		Cart[] cartList = new Cart[cartUserIdList.length];
		for (int i = 0; i < cartList.length; i++) {
			cartList[i] = new Cart();
			cartList[i].userId = cartUserIdList[i];
			cartList[i].itemName = cartItemNameList[i];
		}

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println("[0] 종료\n"
					+ "[1] 전체출력\n"
					+ "[2] 회원 aaa가 주문한 각 아이템이름과 가격들을 출력 \n"
					+ "[3] 카트내용을 전부출력(회원 별 아이템 전체와 아이템 가격을 출력)\n"
					+ "[4] 주문한 아이템 갯수가 가장많은 회원출력\n"
					+ "[5] 주문한 아이템 총액이 가장큰 회원출력");
			int sel = scan.nextInt();
			if (sel == 0) {
				System.out.println("[종료]");
				break;
			} else if (sel == 1) {
				System.out.println("=========================");
				System.out.print("회원 아이디 [ ");
				for (User u : userList) {
					System.out.print(u.id + " ");
				}
				System.out.println("]\n=====================================");
				for (Item i : itemList) {
					System.out.printf("%s(%d) ", i.name, i.price);
				}
				System.out.println("\n=====================================");
				System.out.println("[장바구니 전체]");
				for (Cart c : cartList) {
					System.out.printf("%s --> %s\n", c.userId, c.itemName);
				}
				System.out.println("=====================================");

			} else if (sel == 2) {
				String user = "aaa";
				System.out.println("[" + user + " 주문목록]");
				for (Cart c : cartList) {
					if (user.equals(c.userId) == false) {
						continue;
					}
					System.out.printf("%s --> ", c.itemName);
					for (Item i : itemList) {
						if (c.itemName.equals(i.name)) {
							System.out.printf("%d원\n", i.price);
						}
					}
				}
				System.out.println("=====================================");
			} else if (sel == 3) {
				System.out.println("[장바구니 전체]");
				for (Cart c : cartList) {
					System.out.printf("%s --> %-3s(", c.userId, c.itemName);
					for (Item i : itemList) {
						if (c.itemName.equals(i.name)) {
							System.out.printf("%d원)\n", i.price);
						}
					}
				}
				System.out.println("=====================================");
			} else if (sel == 4) {
				System.out.print("[ 최다 개수 주문 회원 : ");
				int max = 0;
				String maxId = "";
				for (User u : userList) {
					int cnt = 0;
					for (Cart c : cartList) {
						if (u.id.equals(c.userId)) {
							cnt++;
						}
					}
					if (cnt > max) {
						max = cnt;
						maxId = u.id;
					}
				}
				System.out.println(maxId + " ]");
				System.out.println("=====================================");
			} else if (sel == 5) {
				System.out.print("[ 최대 금액 주문 회원 : ");
				int max = 0;
				String maxId = "";
				for (User u : userList) {
					int sum = 0;
					for (Cart c : cartList) {
						if (u.id.equals(c.userId)) {
							for (Item i : itemList) {
								if (c.itemName.equals(i.name)) {
									sum += i.price;
								}
							}
						}
					}
					if (sum > max) {
						max = sum;
						maxId = u.id;
					}
				}
				System.out.println(maxId + " ]");
				System.out.println("=====================================");
			} else {
				System.err.println("입력오류 [0~5]");
			}
		}
		scan.close();
	}
}