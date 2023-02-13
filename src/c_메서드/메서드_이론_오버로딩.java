package c_메서드;

class Test001{
	// 메서드 오버로딩
	// 같은 이름의 메서드를 
	//매개변수의 타입 변경, 매개변수의 갯수, 매개변수 순서 
	// 중복된 이름 메서드 사용가능 
	
	void print(int val ) {
		System.out.println("1");
	}
	void print(int val1, int val2 ) {
		System.out.println("6");
	}
	void print(int val1, String val2) {
		System.out.println("7");
	}
	void print( String val2, int val1) {
		System.out.println("8");
	}
//	int print(int value ) {
//		System.out.println("1");
//		return value;
//	}
	void print(double val) {
		System.out.println("2");
	}
	void print(String val) {
		System.out.println("3");
	}
	void print(boolean val ) {
		System.out.println("4");
	}
	void print(char val) {
		System.out.println("5");
	}
}

public class 메서드_이론_오버로딩 {

	public static void main(String[] args) {
		Test001 t = new Test001();
// 인자값을 통해 같은 이름의 메서드를 호출하더라도 어떤 메서드를 호출하는지 알 수 있다. 
		t.print(10);
		t.print(10.3);
		t.print("10");
		t.print(false);
		t.print('1');
		t.print(10,20);
		t.print("test",10);
		t.print(10,"test");
	}

}