package Test6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentDAO {

	Scanner scan = new Scanner(System.in);
	static ArrayList<Student> studentList = new ArrayList<Student>();
	int num = 1001;
	FileWriter fw;
	FileReader fr;

	int getInt(String msg) {
		int input = 0;
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " > ");
		try {
			input = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return input;
	}

	String getString(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " > ");
		return sc.next();
	}

	boolean checkId(String id) {
		for (Student st : studentList) {
			if (id.equals(st.studentId)) {
				return true;
			}
		}
		return false;
	}

	int checkNum(int num) {
		int idx = 0;
		for (Student st : studentList) {
			if (num == st.studentNum) {
				return idx;
			}
			idx++;
		}
		System.err.println("학번이 존재하지 않습니다");
		return -1;
	}

	// 1) 학생추가
	void join() {
		while (true) {
			String id = getString("아이디");
			if (checkId(id)) {
				System.err.println("이미 존재하는 아이디입니다");
				return;
			} else {
				Student st = new Student();
				st.studentNum = num;
				st.studentId = id;
				studentList.add(st);
				System.out.println("[" + id + "님 추가 완료]");
				num++;
				return;
			}
		}
	}

	// 2) 학생삭제
	void deleteStudent() {
		ArrayList<Subject> sublist = SubjectDAO.subjectList;
		System.out.println(sublist.size());
		while (true) {
			int num = getInt("학번");
			int idx = checkNum(num);
			if (idx == -1) {
				return;
			} else {
				for (int i = 0; i < sublist.size(); i++) {
					if (num == sublist.get(i).studentNum) {
						sublist.remove(i);
						i--;
					}
				}
				studentList.remove(idx);
				System.out.println("[학생 삭제 완료]");
				return;
			}
		}
	}

	// 5) 전체출력
	void printStudentList() {
		ArrayList<Subject> sublist = SubjectDAO.subjectList;
		if (studentList.size() == 0 && sublist.size() == 0) {
			System.err.println("데이터가 없습니다");
			return;
		} else {
			System.out.println("학번\t아이디\t과목\t점수");
			System.out.println("----------------------------");
			for (Student std : studentList) {
				int cnt = 0;
				for (Subject sub : sublist) {
					if (std.studentNum == sub.studentNum) {
						System.out.println(std.toString() + sub.toString());
						cnt++;
					}
				}
				if (cnt == 0) {
					System.out.println(std.toString());
				}
			}
		}
		System.out.println("----------------------------");
	}

	// 6) 파일저장
	void saveStudentList() {
		String data = "";
		try {
			fw = new FileWriter("studentList.txt");
			if (studentList.size() == 0) {
				data += "[학생 데이터 없음]\n";
			} else {
				data += "=======[학생 명단]=======\n";
				for (Student std : studentList) {
					data += "학번[" + std.studentNum + "]  ID[" + std.studentId + "]\n";
				}
				data += "======================\n";
			}
			fw.write(data);
			System.out.println("[학생명단 저장완료]");
		} catch (IOException e) {
			System.err.println("[학생명단 저장실패]");
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void saveSubjectList() {
		String data = "";
		ArrayList<Subject> sublist = SubjectDAO.subjectList;
		try {
			fw = new FileWriter("subjectList.txt");
			if (sublist.size() == 0) {
				data += "[과목별 점수 데이터 없음]\n";
			} else {
				data += "======[과목별 점수]======\n";
				for (Student std : studentList) {
					for (Subject sub : sublist) {
						if (std.studentNum == sub.studentNum) {
							data += std.studentNum + "[" + std.studentId + "]  ";
							data += sub.subject + "[" + sub.score + "점]\n";
						}
					}
				}
				data += "======================\n";
			}
			fw.write(data);
			System.out.println("[과목별 점수 저장완료]");
		} catch (IOException e) {
			System.err.println("[과목별 점수 저장실패]");
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	void saveList() {
		saveStudentList();
		saveSubjectList();
	}

	// 7) 파일로드
	void loadStudentList() {
		String data = "";
		try {
			fr = new FileReader("studentList.txt");
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			fr = new FileReader("subjectList.txt");
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			System.out.print(data);
		} catch (FileNotFoundException e) {
			System.err.println("파일 찾을 수 없음");
		} catch (IOException e) {
			System.err.println("파일 불러오기 실패");
		}
	}
}