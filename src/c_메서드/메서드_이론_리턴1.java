package c_메서드;

//설계도 
class TestReturn1{
	int x; // 필드 : 객체의 정보 


	void loop() {  // 메서드 (행동,기능)
		for(int i =0; i < 10; i++) {
			System.out.println(i);
			if(i == 5) {
				break; // 반복문 즉시 종료 
			}
		}
		System.out.println("메서드 종료 ");
		return;
	}
	void loop2() { 
		for(int i =0; i < 10; i++) {
			System.out.println(i);
			if(i == 5) {
				return; // 메서드 즉시 종료 
			}
		}
		System.out.println("메서드 종료 ");
		return;
	}
	// 메서드 오버로딩 
	// => 같은 클래스 내부에서 같은 이름으로
	// 메서드를 여러개 정의한다 
	// 파라미터 안에 매개변수의 순서, 갯수, 타입을 변경시켜서 
	// 같은 이름의 메서드 정의를 할 수 있다.
	
	void loop(int start, int end) { 
		for(int i =start; i <= end; i++) {
			System.out.println(i);
		}
		System.out.println("메서드 종료 ");
		return;
	}
	
	String returnName() {
		String name="아이유";
		return name;
	}
	
	String[] returnName2(String n1 , String n2, int size) {
		String[] names= new String[size];
		names[0] = n1;
		names[1] = n2; 
		
		return names;
	}
}

public class 메서드_이론_리턴1 {

	public static void main(String[] args) {

		TestReturn1 t = new TestReturn1();
		t.x = 100;
		t.loop();
		System.out.println("============");
		t.loop2();
		System.out.println("============");
		t.loop(1, 10);
		String name = t.returnName();
		System.out.println("name = " + name);
		String[] nameList = t.returnName2("홍길동", "무명이",2);
		
		for(String n : nameList) {
			System.out.println(n);
		}
		
	}

}
