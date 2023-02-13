package Test6;

public class Student {
	int studentNum; // 1씩 자동증가 1001~  
	String studentId; // 중복금지 
	
	@Override
	public String toString() {
		return ""+studentNum + "\t" + studentId + "\t" ;
	}
}
