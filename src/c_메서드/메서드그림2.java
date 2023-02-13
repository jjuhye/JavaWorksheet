package c_메서드;
class Calculator{
	double result;
	
	// 더하기 메서드
	 void plus(double x, double y) {
		 result(x,y,"+",x+y);
	 }
	// 빼기 메서드
	 void minus(double x, double y) {
		 result(x,y,"-",x-y);
	 }
	// 나누기 메서드
	 void multiply(double x, double y) {
		 result(x,y,"/",x/y);
	 }
	// 곱하기 메서드
	 void divide(double x, double y) {
		 result(x,y,"*",x*y);
	 }
	
	// 결과 출력문 메서드 
	 void result(double x, double y,String op, double res) {
		 System.out.printf(" %.1f %s %.1f = %.1f \n", x ,op, y , res);
	 }
}
public class 메서드그림2 {

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		double x = 10;
		double y = 3;
		cal.plus(x, y);
		cal.minus(x, y);
		cal.multiply(x, y);
		cal.divide(x, y);

	}

}