package Test6;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Controller {
	
	Scanner scan = new Scanner(System.in);
	StudentDAO studentDAO = new StudentDAO();
	SubjectDAO subjectDAO = new SubjectDAO();
	
	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		int num = 0;
		System.out.printf("%s[%d-%d] >> ", msg, start, end);
		try {
			num = sc.nextInt();
			if (num < start || num > end) {
				throw new Exception(start + "~" + end + "값 입력해주세요");
			}
			return num;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
			num=-1;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return num;
	}
	
	void run() {
		while (true) {
			System.out.println("1)학생추가");  // 아이디 중복금지 
			System.out.println("2)학생삭제"); // 학번으로 삭제 
			System.out.println("3)과목추가"); // 과목이름 중복 금지 
			System.out.println("4)과목삭제"); // 과목 이름
			System.out.println("5)전체출력"); //기본: 출력 , 심화: 평균이 높은 순으로 출력 
						                   // 심화: id 값 이름 오름차순으로 저장 
			System.out.println("6)파일저장"); // 각각 studentList.txt , subjectList.txt 로저장 
			System.out.println("7)파일로드"); //기본: 출력 , 
			System.out.println("0)종료");
			
			int sel = getValue("선택",0,7);
			
			if (sel == 0) {
				System.err.println("[종료]");
				break;
			} else if (sel == 1) {	
				studentDAO.join();
			} else if (sel == 2) {
				studentDAO.deleteStudent();
			} else if (sel == 3) {
				subjectDAO.insertSubject(studentDAO);
			} else if (sel == 4) {
				subjectDAO.deleteSubject(studentDAO);
			} else if (sel == 5) {
				studentDAO.printStudentList();
			} else if (sel == 6) {
				studentDAO.saveList();
			} else if (sel == 7) {
				studentDAO.loadStudentList();
			}
		}
	}
}