package b_클래스배열;

//class Student{
//int number;
//String id;
//String pw;
//String name="무명이";
//int score;
//}

public class 클배01_기본예제1 {

	public static void main(String[] args) {

		String data = "";
		data += "1001,qwer,1234,김철민,10\n";
		data += "1002,asdf,2345,우중현,3\n";
		data += "1003,zxcv,3456,이만수,30";

		// stList 클래스배열에 데이터를 넣고 1등 출력
		
		String[] temp=data.split("\n");
		String[][] dataList=new String[temp.length][];
		
		for (int i = 0; i < dataList.length; i++) {
				dataList[i]=temp[i].split(",");
		}
		
		Student[] stList = new Student[dataList.length];
		
		int max=0;
		int idx=-1;
		
		for (int i = 0; i < dataList.length; i++) {
			Student s = new Student();
			s.number=Integer.parseInt(dataList[i][0]);
			s.id=dataList[i][1];
			s.pw=dataList[i][2];
			s.name=dataList[i][3];
			s.score=Integer.parseInt(dataList[i][4]);
			stList[i]=s;
			
			if(max<s.score) {
				max=s.score;
				idx=i;
			}
		}
		
		System.out.println("====== 1등 ======");
		System.out.println("학번 : "+stList[idx].number);
		System.out.println("id : "+stList[idx].id);
		System.out.println("pw : "+stList[idx].pw);
		System.out.println("이름 : "+stList[idx].name);
		System.out.println("점수 : "+stList[idx].score);
		System.out.println("================");

	}
}