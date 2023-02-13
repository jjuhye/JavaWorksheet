package a_클래스;

// 사용자가 만든 자료형 
class Employee{
	int emNo; // 번호
	String name; // 이름 
	String position; // 직책
	int superNo; // 상사번호
	String regDate; // 입사일
	int salary; // 급여
	int commission; // 상여금
	int departNo; // 부서번호 
}

public class 기본이론4 {

	public static void main(String[] args) {
		String[][] eData = { 
				{ "7369", "SMITH", "CLERK", "7902", "17-12-1980", "800", "0", "20" },
				{ "7499", "ALLEN", "SALESMAN", "7698", "20-2-1981", "1600", "300", "30" }
		};
		
		Employee smith = new Employee();
		smith.emNo = Integer.parseInt(eData[0][0]);
		smith.name = eData[0][1];
		smith.position = eData[0][2];
		smith.superNo= Integer.parseInt(eData[0][3]);
		
		System.out.println(smith.emNo);
		
		int num = 10; 
		
		Employee allen = new Employee();
		System.out.println(allen.emNo);
		//allen.age
		
	}

}