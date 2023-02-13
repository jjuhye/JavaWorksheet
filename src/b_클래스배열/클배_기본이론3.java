package b_클래스배열;

public class 클배_기본이론3 {

	public static void main(String[] args) {

		String[][] dataList ={
				{"1001" , "qwer" , "1234", "김철수" , "10"},
				{"1002" , "asdf" , "2345", "이영희" , "30"},
				{"1003" , "aaaa" , "1111", "이만수" , "80"}
			};	
			
			int size = dataList.length;
			
			Student[] stList = new Student[size];
			
			for(int i =0; i < size;i++) {
				Student s = new Student();
				s.number = Integer.parseInt(dataList[i][0]);
				s.id = dataList[i][1];
				s.pw = dataList[i][2];
				s.name =  dataList[i][3];
				s.score = Integer.parseInt(dataList[i][4]);
				stList[i] = s;
			}
			
			System.out.println("=================");
			
			for(int i =0; i < size;i++) {
				
				System.out.println("학번 : " + stList[i].number);
				System.out.println("id : " + stList[i].id);
				System.out.println("pw : " + stList[i].pw);
				System.out.println("이름 : " + stList[i].name);
				System.out.println("점수 : " + stList[i].score);
				System.out.println("=================");
			}
		
			System.out.println("=================");
			
			for(Student s : stList) {
				System.out.println("학번 : " + s.number);
				System.out.println("id : " + s.id);
				System.out.println("pw : " + s.pw);
				System.out.println("이름 : " + s.name);
				System.out.println("점수 : " + s.score);
				System.out.println("=================");
			}

	}

}
