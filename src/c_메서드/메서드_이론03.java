package c_메서드;

class Test03 {

	// 유산이 없을 경우 1 2
	void type1() {
		int x = 10;
		System.out.println("type1 이야! ");
		System.out.println("==========");
		return;
	}

	void type2(int x, double y) {
		// int x= 외부값1;
		// int y= 외부값2;
		double result = x + y;
		System.out.println("type2 이야! ");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		System.out.println("result = " + result);
		System.out.println("==========");

		// return; 우리가 붙여주지 않아도 자동으로 void 메서드 마지막에 붙어있음
	}

	// 유산이 있을때 // 1.유산의 형태 2.유산의 값 3.유산을 받는 변수

	// type3 : 유산 o 외부값 x
	// 유산 = return : 무조건 값 1개만 가능하다

	// 1.유산의 형태
	int type3() {
		int result = 10 + 20;
		System.out.println("type3 이야! ");
		System.out.println("result = " + result);
		System.out.println("==========");
		// 2.유산의 값
		return result;
	}
}

public class 메서드_이론03 {

	public static void main(String[] args) {
		Test03 t = new Test03();
		t.type2(10, 20);
		// 묵시적 형변환 : 암묵적으로 자동으로 형변환
		// int -> double

		t.type2(10, 200); // t.type2(10, 200.0);
		int x = 10;
		double y = 20.4;

		// 인자값은 매개변수의 자료형과 갯수와 순서가 일치해야한다!

		t.type2(x, y);
		// t.type2(10.2,10);
		// 명시적 형변환 : 사용자가 강제로 형변환

		// double -> int 자동으로 변경되않지 않음
		// 데이터 손실 위험 0.2
		t.type2((int) 10.2, 10);

		// 3.유산을 받는 변수
		int result = t.type3();

		System.out.println("main result = " + result);

	}

}
