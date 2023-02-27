package 싱글톤_학생추가;

public class Subject {
	private int studentNum;
	private String subject;
	private int score;

	public int getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(int studentNum) {
		this.studentNum = studentNum;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void printSubject() {
		System.out.println("name : " + subject + " score : " + score);
	}
}
