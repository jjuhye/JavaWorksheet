package 싱글톤_학생추가;

import java.util.Scanner;
import java.util.ArrayList;

public class StudentDAO {
	private StudentDAO() {}	
	static private StudentDAO instance = new StudentDAO();
	static public StudentDAO getInstance() {
		return instance;
	}
	
	private Scanner scan;
	private int num;
	private ArrayList<Student> studentList;
	

	public void init() {
		scan = Controller.getInstance().getScan();
		num = 1000;
		studentList = new ArrayList<Student>();
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(ArrayList<Student> studentList) {
		this.studentList = studentList;
	}
	
	public Student checkId(String id) {
		for(int i = 0; i < studentList.size(); i++) {
			if(studentList.get(i).getStudentId().equals(id)) {
				return studentList.get(i);
			}
		}	
		return null;
	}
	public int getNextNum() {
		num += 1;
		return num;
	}

	public void addStudent(Student student) {		
		studentList.add(student);
		System.out.println("추가완료.");
	}
	public int getStudentListSize() {
		return studentList.size();
	}
	
	public void printStudentList() {
		int studentCount = getStudentListSize();
		if (studentCount == 0) {
			System.out.println("등록된 학생이 없습니다.");
			return;
		}		
		ArrayList<Student> studentList = getStudentList();				
		for (int i = 0; i < studentCount; i++) {					
			Student student = studentList.get(i);
			student.printStudent();
			ArrayList<Subject> subList = SubjectDAO.getInstance().getOneStudentSubjectList(student.getStudentNum());  
			for(int j = 0; j < subList.size(); j++) {
				subList.get(j).printSubject();
			}
		}
	}
	
	public void join() {
		System.out.println("[학생추가] 아이디 입력 : ");
		String id = scan.next();
		Student student = checkId(id);
		if (student == null) {
			student = new Student();
			student.setStudentNum(getNextNum());
			student.setStudentId(id);
			addStudent(student);
			printStudentList();
			System.out.println("회원가입 성공.");

		} else {
			System.out.println("중복아이디입니다. ");
		}
	}
}
