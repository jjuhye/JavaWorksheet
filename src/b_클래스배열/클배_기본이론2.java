package b_클래스배열;

public class 클배_기본이론2 {

	public static void main(String[] args) {
		String studentList[][] = new String[3][];// {null, null ,null}

		String temp[] = {"1001","박철수"}; // new String[2];
		studentList[0] = temp;
		
		System.out.println(studentList[0][1]);
		
		
		// student 객체 3개가 들어가는 메모리방만 만든거지
		// student 객체 3개 만든것이 아니다!!! 
		
		Student[] stList = new Student[3]; // {null, null ,null}
		// stList에는 어떤 자료형만 들어갈 수 있나? ==> student 클래스 객체 주소값 

		stList[0] = new Student(); // 객체를 만든다 
		
		System.out.println(stList[0].name);
	}
}
