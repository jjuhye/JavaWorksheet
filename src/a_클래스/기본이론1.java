package a_클래스;

import java.util.Random;

class Member{
	// 파란색[전역변수] => 클래스 영역 안 메서드 영역밖 => heap 메모리 안에서 존재 
	
	int no;// 자동초기화값을 가지고있다 => 숫자 =0 booelan => false 나머지는 null 
	String id="qwer";
	String pw="1111";
	String name="김철수";
	int age =30;
	
}

public class 기본이론1 {

	public static void main(String[] args) {
		//int no;
		//System.out.println(no);
		// 1. 변수 => 특정한 자료형 단 1개만 저장한다 
		// 2. 배열 => 특정한 자료형 여러개를 저장한다 // new int[5] => int 5개가 들어가는 메모리공간
		// 3. 클래스 => 여러개의 자료형을 여러개 저장하기 => 사용자 정의 자료형 
		                //0     1     2      3     4
		String[] data = {"1","qwer","1111","김철수","30"};
		
		System.out.println(data);
		
		System.out.println(data[2]); // 비밀번호 데이터가 2번째 방에 위치되어있다 : 가시적으로 확인 불가능
		
		// 클래스 사용 
		Random rd = new Random();
		int num = rd.nextInt(10)+1;
		
		// 우리가 만든 클래스도 공장을 만들어야지만 사용가능 
		
		Member m1 = new Member(); // 공장 => 객체 생성 
		// new 클래스이름(); ==> 클래스 객체를 생성 : 메모리 공간 생성 
		System.out.println(m1);
		System.out.println(m1.pw); // . 안에 있는 데이터 접근가능 
		
		System.out.println(m1.no);

	}

}
