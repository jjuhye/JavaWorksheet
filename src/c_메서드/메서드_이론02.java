package c_메서드;
class Test02{
	
	// 1. 
	void type1() {
		int x = 10; // x = 10 메서드 내에서 초기값 선언 
		System.out.println("type1 이야! ");
	}
	// 2. 유산 x : void 외부값 o (외부 값)
	
	// 메서드 구조 
	// 리턴 키워드 메서드이름 (매개변수) {영역}
	
	// 매개변수 : main 과 type2 를 매개(연결)해주는 변수 
	
	       // 파리미터 : 매개변수(들) 선언 
	void type2(int x) {
		// int x; // 외부에서 오는 값으로 초기값을 가짐 
		System.out.println("type2 이야! ");
		System.out.println("x = " + x);
	}
	
}
public class 메서드_이론02 {

	public static void main(String[] args) {
		Test02 t = new Test02();
		int x = 100;
		t.type1(); // arguments : 인자값 : 외부값 넣어주는 것 
		t.type2(x);
		t.type2(50);
		
		for(int i =0; i < 10;i++) {
			System.out.println(i);
		}
		//System.out.println(i);
		
	}

}