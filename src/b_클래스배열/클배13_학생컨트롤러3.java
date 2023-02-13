package b_클래스배열;

class Subject {
	String name;
	String stuNo;
	int score;

	String getInfo() {
		return name + "\t" + score + "\t\n";
	}
}

class Student {
	String stuNo;
	Subject[] subjects;
	String name;

	String getData() {
		String data = name + " \n";
		for (Subject sub : subjects) {
			if (sub == null)
				return data;
			data += sub.getInfo();
		}
		return data;
	}

	void printInfo() {
		System.out.println(getData());
	}

}

class StudentDAO {
	Student[] list;

	void printAllStudent() {
		for (Student stu : list) {
			stu.printInfo();
		}
	}

	void init() {
		String stuData = "1001/이만수\n";
		stuData += "1002/김철만\n";
		stuData += "1003/오수정\n";
		String subData = "";
		subData += "1001/국어/10\n";
		subData += "1001/수학/32\n";
		subData += "1002/국어/23\n";
		subData += "1002/수학/35\n";
		subData += "1002/영어/46\n";
		subData += "1003/수학/60\n";
		subData += "1003/영어/100\n";
	}

	void run() {
		init();
		printAllStudent();
	}
}

public class 클배13_학생컨트롤러3 {

	public static void main(String[] args) {
		
		StudentDAO dao = new StudentDAO();
		dao.run();

	}

}
