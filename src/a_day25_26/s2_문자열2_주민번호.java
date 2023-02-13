package a_day25_26;

public class s2_문자열2_주민번호 {

	public static void main(String[] args) {
		// 만나이
		// 문제1) 주민1 성별 출력 -> 여성
		// 문제2) 주민1 나이 출력 -> 33세(성인)
		// 문제3) 주민2 성별 출력 -> 남성
		// 문제4) 주민2 나이 출력 -> 18세(청소년)

		String jumin1 = "890101-2012932";
		String jumin2 = "040101-3012932";
		String result = ""; // 여성 33세(성인)
		int year = 2022;
		int date = 1201;
		String jumin = jumin1;

		int age = Integer.parseInt(jumin.substring(0, 2));
		int gd = Integer.parseInt(jumin.substring(7, 8));
		int dt = Integer.parseInt(jumin.substring(2, 6));
		if (gd == 3 || gd == 4) {
			age += 2000;
		} else {
			age += 1900;
		}
		age = year - age;
		if (dt - date > 0) {
			age++;
		}
		if (gd == 1 || gd == 3) {
			result += "남성 " + age + "세";
		} else {
			result += "여성 " + age + "세";
		}
		if (age > 18) {
			result += "(성인)";
		} else {
			result += "(청소년)";
		}
		System.out.println(result);
	}
}
