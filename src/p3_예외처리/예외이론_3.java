package p3_예외처리;

public class 예외이론_3 {
	public static void main(String[] args) {

		try {

// int a = 10/0;
// Exception e = new Exception("에러 그냥 발생했음");
// throw e; // throw 에러 객체 발생

			int a = 101;

			if (a < 0 || a > 100) {
				// 위에것 한줄로 처리
				throw new Exception("점수값은 0 - 100 사이값 입니다");
			}
			System.out.println("test");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("프로그램 종료");

	}
}
