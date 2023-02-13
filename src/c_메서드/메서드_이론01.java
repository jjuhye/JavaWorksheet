package c_메서드;

class Test01{
	int x;
	// type1 유산 x: void  외부값 x () : 비어있는 가로 
	
	void type1() {
		int x = 10; 
		System.out.println("test01 tpye1 실행");
		System.out.println("x= " + x);
	}
}
public class 메서드_이론01 {

	public static void main(String[] args) {
		
		int x = 100; 
		
		System.out.println("main x= " + x);
		Test01 t = new Test01(); // 클래스 객체 생성 
		System.out.println(t.x);
		t.type1(); // 메서드 호출 
		
		
		System.out.println("main x= " + x);

	}

}
