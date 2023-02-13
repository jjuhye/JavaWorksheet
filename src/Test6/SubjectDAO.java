package Test6;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectDAO {

	Scanner scan = new Scanner(System.in);
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();

	boolean checkSj(int num, String subject) {
		for (Subject sj : subjectList) {
			if (num == sj.studentNum && subject.equals(sj.subject)) {
				return true;
			}
		}
		return false;
	}

	// 3)과목추가
	void insertSubject(StudentDAO stDAO) {
		while (true) {
			int num = stDAO.getInt("학번");
			if (num == 0) {
				return;
			}
			int idx = stDAO.checkNum(num);
			if (idx == -1) {
				return;
			} else {
				String subject = stDAO.getString("과목");
				if (checkSj(num, subject)) {
					System.err.println("이미 등록된 과목입니다");
					return;
				} else {
					int score = stDAO.getInt("점수");
					Subject sj = new Subject();
					sj.studentNum = num;
					sj.subject = subject;
					sj.score = score;
					subjectList.add(sj);
					System.out.println("[" + num + "학번 " + subject + " 점수 추가 완료]");
					return;
				}
			}
		}
	}

	// 4)과목삭제
	void deleteSubject(StudentDAO stDAO) {
		while (true) {
			int num = stDAO.getInt("학번");
			if (num == 0) {
				return;
			}
			int idx = stDAO.checkNum(num);
			if (idx == -1) {
				return;
			} else {
				String subject = stDAO.getString("과목");
				if (!checkSj(num, subject)) {
					System.err.println("과목이 없습니다");
					return;
				} else {
					for (int i = 0; i < subjectList.size(); i++) {
						if (num == subjectList.get(i).studentNum && subject.equals(subjectList.get(i).subject)) {
							subjectList.remove(i);
							i--;
						}
					}
					System.out.println("[" + subject + " 과목 삭제 완료]");
					return;
				}
			}
		}
	}
}