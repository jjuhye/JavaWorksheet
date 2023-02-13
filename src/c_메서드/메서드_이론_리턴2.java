package c_메서드;

class Student {
	// 전역변수(멤버변수 )
	// 클래스 영역 안 메서드 밖에 존재 : new 방을 heap에서
	// 자동 초기값이 있는 상태로 방을 만든다 : 파란색

	int score;
	String name;

	void setScore(int score) {
		// 지역변수랑 전역변수의 이름이 같다면 지역변수를 먼저 인식한다
		// this 객체의 주소랑 같다
		this.score = score;
	}

	int getScore() {
		return score;
	}
}

public class 메서드_이론_리턴2 {
	// 지역변수 : 메서드 영역 안 생성 => stack 메모리방안에 존재
	// 반드시 초기값이 있어야지만 사용 가능하다 : 갈색 변수

	public static void main(String[] args) {

		Student s1 = new Student();
		System.out.println(s1.name);
		System.out.println(s1.score);
		s1.name = "아이유"; // 직접 접근 => .을 통해서 접근
		System.out.println(s1.name);

		s1.setScore(85); // 간접 접근 => 메서드를 통해서 접근
		System.out.println(s1.score); // 직접 접근
		System.out.println(s1.getScore());// 간접 접근
	}

}