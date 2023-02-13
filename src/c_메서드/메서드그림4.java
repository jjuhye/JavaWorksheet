package c_메서드;
class Ex005{
	int result;
}

class Ex006{
	void plus(Ex005 data, int x, int y) {
		data.result = x + y;
	}
	void minus(Ex005 data, int x, int y) {
		data.result = x - y;
	}
}

public class 메서드그림4 {

	public static void main(String[] args) {

		Ex005 data = new Ex005();
		
		Ex006 e = new Ex006();
		
		// data는 new Data()의 주소가 전달되었다.
		e.plus(data, 10, 3);
		System.out.println(data.result);
		
		e.minus(data, 10, 3);
		System.out.println(data.result);
		
	}

}
