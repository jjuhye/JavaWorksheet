package b_클래스배열;

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

public class 클배06_장바구니1 {

	public static void main(String[] args) {

		String data1 = "qwer/asdf/zxcv";
		String data2 = "새우깡,1200/감자깡,3200/고구마깡,2100";
		String data3 = "qwer,새우깡/qwer,고구마깡/asdf,감자깡/qwer,새우깡/zxcv,새우깡";

		// [문제] 문자열을 각각의 클래스배열에 저장하고, 회원별로 구매한 상품 총 금액을 출력하시오.
		// [정답] qwer(4500), asdf(3200), zxcv(1200)
		String[] temp = data1.split("/");
		User[] userList = new User[temp.length];
		int idx = 0;
		for (User u : userList) {
			u = new User();
			u.id = temp[idx];
			userList[idx] = u;
			idx++;
		}
		temp = data2.split("/");
		Item[] itemList = new Item[temp.length];
		idx = 0;
		for (Item i : itemList) {
			String[] tempS = temp[idx].split(",");
			i = new Item();
			i.name = tempS[0];
			i.price = Integer.parseInt(tempS[1]);
			itemList[idx] = i;
			idx++;
		}
		temp = data3.split("/");
		Cart[] cartList = new Cart[temp.length];
		idx = 0;
		for (Cart c : cartList) {
			String[] tempS = temp[idx].split(",");
			c = new Cart();
			c.userId = tempS[0];
			c.itemName = tempS[1];
			cartList[idx] = c;
			idx++;
		}

		idx = 0;
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
			System.out.printf("%s(%d원) ", u.id, sum);
		}
	}
}