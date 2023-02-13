package c_메서드;

import java.util.Arrays;

class Test04 {

	void type1() {
		System.out.println("type1 이야! ");
		System.out.println("==========");
	}

	void type2(int x) {
		System.out.println("type2 이야! ");
		System.out.println("x = " + x);
		System.out.println("==========");
	}

	String type3() {
		int result = 10 + 20;
		System.out.println("type3 이야! ");
		System.out.println("result = " + result);
		System.out.println("==========");
		return "test";
	}

	// 유산 O 외부 O
	// 1. 외부값 => int[] 값만 인자값으로 올 수 있다
	// 2. int[]만 return 값이 올 수 있다
	// 3. 받아주는 변수도 역시 int[] t.type4(arr)

	int[] type4(int[] arr) {
		System.out.println("type4 이야! ");
		System.out.println(Arrays.toString(arr));

		int[] newArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i] * 100;
			System.out.print(newArr[i] + " ");
		}

		System.out.println();
		System.out.println("==========");

		// 여러개의 return 값을 넘겨주고 싶으면 배열로 만들어서 주소값 리턴하면 된다
		return newArr;
	}

}

public class 메서드_이론04 {

	public static void main(String[] args) {
		Test04 t = new Test04();
		// String res = t.type3();

		int[] arr = { 10, 20, 30 };

		int[] newArr = t.type4(arr);

		System.out.println(Arrays.toString(newArr));

	}

}
