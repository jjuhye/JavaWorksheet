package a_클래스;

import java.util.Random; // java.util 패키지 안에있는 Random 
//현재 패키지와 다른 위치에 있으면 import 해와야함 

//이미 같은 패키지에 중복된 이름의 클래스 이름 member 가 존재하기떄문에 
//class Member{
//	// The type Member is already defined => 이름중복에러 
//}

public class 기본이론2 {

	public static void main(String[] args) {

		Random rd = new Random();
		
		// 같은 패키지에 있으면 import 없이 바로 객체 생성이 가능하다 
		
		Member m1 = new Member();
		Member m2 = new Member();
	
		System.out.println(m1);
		System.out.println(m2);
		
		m1.name="홍길동";

		System.out.println(m1.name);
		System.out.println(m2.name); // 기존 김철수가 있다 
	}

}