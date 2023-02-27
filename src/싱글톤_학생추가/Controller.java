package 싱글톤_학생추가;

import java.util.Scanner;
import java.util.ArrayList;

public class Controller {	
	private Controller() {}
	static private Controller instance = new Controller();
	static public Controller getInstance() {
		return instance;
	}	
	private Scanner scan;
	private StudentDAO studentDAO;
	private SubjectDAO subjectDAO;
	public void init() {
		scan = new Scanner(System.in);		
		studentDAO = StudentDAO.getInstance();
		subjectDAO = SubjectDAO.getInstance();
		studentDAO.init();
		subjectDAO.init();
		play();
	}
	 public Scanner getScan() {
		return scan;
	}
	public void play() {
		while (true) {
			System.out.println("1)학생추가");
			System.out.println("2)학생삭제"); 
			System.out.println("3)과목추가");
			System.out.println("4)과목삭제");
			System.out.println("5)전체출력");
			System.out.println("8)저장");
			System.out.println("9)로드");
			System.out.println("0)종료");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				
				studentDAO.join();
				
			} else if (sel == 3) {
				subjectDAO.insertSubject();

			} else if (sel == 5) {
				studentDAO.printStudentList();
			}
		}
	}
}
