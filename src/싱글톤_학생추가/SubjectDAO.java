package 싱글톤_학생추가;

import java.util.Scanner;
import java.util.ArrayList;

public class SubjectDAO {
	private SubjectDAO() {}	
	static private SubjectDAO instance = new SubjectDAO();
	static public SubjectDAO getInstance() {
		return instance;
	}
	
	
	private ArrayList<Subject> subjectList;
	private Scanner scan;
	
	public void init() {
		scan = new Scanner(System.in);
		subjectList = new ArrayList<Subject>();
	}

	
	public ArrayList<Subject> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(ArrayList<Subject> subjectList) {
		this.subjectList = subjectList;
	}

	
	public boolean checkSubject(int studentNum, String subject) {
		for(int i = 0; i< subjectList.size(); i++) {
			Subject  sub = subjectList.get(i);
			
			if(sub.getStudentNum() == studentNum && sub.getSubject().equals(subject)) {
				return true;
			}
		}
		
		
		return false;
	}

	public void addSubject(Subject subject) {
		subjectList.add(subject);
	}

	public ArrayList<Subject> getOneStudentSubjectList(int studentNum) {
		ArrayList<Subject> oneStudentSubjectList = new ArrayList<Subject>();
		
		for(int i = 0; i < subjectList.size(); i++) {
			if(subjectList.get(i).getStudentNum() == studentNum) {
				oneStudentSubjectList.add(subjectList.get(i));				
			}
		}
		
		return oneStudentSubjectList;
			
	}

	public void printSubjectList(Subject[] subjectList) {
		for (int i = 0; i < subjectList.length; i++) {
			subjectList[i].printSubject();
		}
	}
	
	public void insertSubject() {
		System.out.println("[과목추가] 학생 아이디 입력 : ");
		String id = scan.next();
		Student student = StudentDAO.getInstance().checkId(id);
		if (student == null) {
			System.out.println("찾는 학생이 없습니다. ");
		} else {
			System.out.println("[과목추가] 과목 이름 입력 : ");
			String subjectName = scan.next();
			boolean check = checkSubject(student.getStudentNum(), subjectName);
			if (check == true) {
				System.out.println("[메세지] 중복 과목입니다.");
			} else {						
				System.out.println("[점수추가] 점수 입력 : ");
				int score = scan.nextInt();
				Subject subject = new Subject();
				subject.setScore(score);
				subject.setStudentNum(student.getStudentNum());
				subject.setSubject(subjectName);
				addSubject(subject);
				System.out.println("과목추가 성공.");
			}
		}
	}
}
