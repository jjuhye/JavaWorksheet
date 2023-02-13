package b_클래스배열;

class Student{
	int number;
	String id;
	String pw;
	String name="무명이";
	int score;
}

public class 클배_기본이론1 {

	public static void main(String[] args) {
		
		String data1 = "1001/1234/qwer/김철수/10";	
		String[] temp = data1.split("/");
		String[] dataList1 = {"1002", "1234", "abcd", "박영희", "90"};		
//		System.out.println(dataList1[0]);
//		System.out.println(dataList1[1]);
//		System.out.println(dataList1[2]);
//		System.out.println(dataList1[3]);
//		System.out.println(dataList1[4]);
		
		Student s1 = new Student(); // 객체(=인스턴스)를 만든다 =>
		// 클래스에서 정의한 메모리값을 heap 생성하고 그 주소값을 main 안에
		// 인스턴스변수 s1이 그 메모리방의 주소값 1개를 가지고 있다 
		
		System.out.println(s1.number);
		System.out.println(s1.id);
		System.out.println(s1.pw);
		System.out.println(s1.name);
		System.out.println(s1.score);
		System.out.println(s1);
		
		s1.number = Integer.parseInt(dataList1[0]);
		s1.id = dataList1[1];
		s1.pw = dataList1[2];
		s1.name = dataList1[3];
		s1.score = Integer.parseInt(dataList1[4]);
		
		System.out.println("===========");
		
		Student s2 = new Student(); // 객체를 만든다 
		s2.number = 1003;
		s2.id="aaaa";
		s2.pw="1234";
		s2.name="홍길동";
		s2.score=78;
		
		System.out.println(s2.number);
		System.out.println(s2.id);
		System.out.println(s2.pw);
		System.out.println(s2.name);
		System.out.println(s2.score);
		System.out.println(s2);
		
		System.out.println("===========");
	
		System.out.println(s1.number);
		System.out.println(s1.id);
		System.out.println(s1.pw);
		System.out.println(s1.name);
		System.out.println(s1.score);
		System.out.println(s1);
		
		System.out.println("===========");	
		

		String studentList[][] = new String[3][5];
		// studentList의 첫번째 메모리방은 String 배열의 주소값만 들어간다 
		studentList[0] = temp;
		studentList[1] = dataList1;
//		
//		System.out.println(studentList[0][3]);
//		System.out.println(studentList[1][3]);
		
		
		Student[] stList = new Student[3]; // {null, null ,null}
		// stList에는 어떤 자료형만 들어갈 수 있나? ==> student 클래스 객체 주소값 
		
		stList[0] = s1;
		stList[1] = s2;
		System.out.println(stList[0].name);
		System.out.println(stList[1].name);
	   // nullpoint 에러가 뜨면 객체를 생성 했는지 안했는지 체크 
		// System.out.println(stList[2].name); // java.lang.NullPointerException:
		
		System.out.println("===============");
		
		stList[2] = new Student();
		stList[2].name ="아이유";
		
		System.out.println(s1.name);
		System.out.println(s2.name);
		System.out.println(stList[2].name);
		
		
	}

}