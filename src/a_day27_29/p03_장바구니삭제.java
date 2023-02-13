package a_day27_29;

import java.util.Arrays;

public class p03_장바구니삭제 {

	public static void main(String[] args) {
		/*
		 * 10:02~11:01 [문제] cart데이터는 현재 장바구니 상황이다.
		 * 
		 * input데이터는 삭제를 요청한 데이터이다. qwer은 아이디이고, 3은 삭제할 위치이다. qwer 입장에서는 본인 아이템은 3개 밖에
		 * 없으니 칸쵸를 지우기 위해 3을 선택했지만 전체 데이터에서는 5번째 아이템이다.
		 * 
		 * 마찬가지로 abcd는 콜라와 사이다를 구입했고, 콜라를 지우기 위해 1번을 선택했지만 실제로는 3번 아이템이 삭제되어야 한다.
		 * 
		 * 삭제 후 cart배열의 정보를 출력하시오. [정답] qwer/고래밥 qwer/새우깡 java/칸쵸 java/고래밥 abcd/사이다
		 */

		String item = "칸초/새우깡/고래밥/콜라/사이다";
		String id = "qwer/abcd/java";

		String cart = "";
		cart += "qwer/고래밥\n";
		cart += "qwer/새우깡\n";
		cart += "abcd/콜라\n"; // 삭제 2
		cart += "java/칸쵸\n";
		cart += "qwer/칸쵸\n"; // 삭제 1
		cart += "java/고래밥\n";
		cart += "abcd/사이다";

		String[][] input = { { "qwer", "3" }, { "abcd", "1" } };

		String[] itemArr = item.split("/");
		String[] idArr = id.split("/");
		String[] temp = cart.split("\n");
		String[][] cartArr = new String[temp.length][2];

		for (int i = 0; i < temp.length; i++) {
			cartArr[i] = temp[i].split("/");
			System.out.println(Arrays.toString(cartArr[i]));
		}
		int arrIdx = cartArr.length;
		for (String[] del : input) {
			int idx = 0;
			int cnt = 0;
			for (String[] c : cartArr) {
				if (del[0].equals(c[0])) {
					cnt++;
					if (cnt == Integer.parseInt(del[1])) {
						for (int i = idx; i < cartArr.length - 1; i++) {
							cartArr[i] = cartArr[i + 1];
						}
						cartArr[cartArr.length - 1] = new String[2];
						arrIdx--;
					}
				}
				idx++;
			}
		}
		System.out.println("======================");
		String[][] tempCart = new String[arrIdx][2];
		for (int i = 0; i < tempCart.length; i++) {
			tempCart[i] = cartArr[i];
			System.out.println(Arrays.toString(tempCart[i]));
		}
	}
}
