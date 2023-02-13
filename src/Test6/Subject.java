package Test6;

public class Subject {
	int studentNum; // 학생 학번
	String subject; // 과목이름 
	int score; // 학생 점수 
	
	@Override
	public String toString() {
		return subject + "\t" + score+"\t";
	}
}
