package p3_예외처리;

class Test {

	void sample() {
		// 발생할 수 있는 에러를 내가 처리할께
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.toString());
			System.out.println("0으로 나눌 수 없습니다 ");
		}
	}

	void sample2() throws Exception {
		// 나를 호출한 곳에서 에러를 처리해줘
		// sample2 그냥 호출 불가 try{}catch(){} 로 호출 가능
		int a = 10 / 0;
		System.out.println("test");
	}

}

public class 예외이론_2 {
	public static void main(String[] args) {

		Test t = new Test();
		t.sample();

		try {
			t.sample2();
		} catch (Exception e) {
			System.out.println("0 으로 나눗셈 불가");
			e.printStackTrace();
		}

		System.out.println("try - catch 종료 후 ");

	}
}
