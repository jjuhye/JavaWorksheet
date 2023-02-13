package p3_멤버저장;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MemberDAO {
	int num; // 학번 1001 시작
	Member[] memberList;
	int memberCount;
	Member mb;
	FileWriter fw;
	FileReader fr;
	String fileName;
	String data;

	MemberDAO() {
		num = 1001;
		fileName = "memberList.txt";
	}

	int getInt(String msg) {
		// 예외처리 적용해보세요
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
		// id 입력 받을 때 숫자값만 입력받으면 id 는 적어도 한개 문자값 포함이라는
		// 예외처리 적용해보세요
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " > ");
		return sc.next();
	}

	boolean checkId(String id) {
		for (Member m : memberList) {
			if (id.equals(m.id)) {
				return true;
			}
		}
		return false;
	}

	boolean checkNum(int num) {
		for (Member m : memberList) {
			if (num == m.num) {
				return true;
			}
		}
		return false;
	}

	void join() {
		String id = getString("아이디");
		if (memberCount == 0) {
			memberList = new Member[1];
		} else if (checkId(id)) {
			System.err.println("이미 존재하는 아이디입니다");
			return;
		} else {
			Member[] temp = memberList;
			memberList = new Member[memberCount + 1];
			for (int i = 0; i < memberCount; i++) {
				memberList[i] = temp[i];
			}
		}
		memberList[memberCount] = new Member(id, num);
		System.out.println("[" + id + "님 추가 완료]");
		memberCount++;
		num++;
	}

	void remove() {
		String id = getString("아이디");
		if (!checkId(id)) {
			System.err.println("아이디가 존재하지 않습니다");
			return;
		} else {
			Member[] temp = memberList;
			memberList = new Member[memberCount - 1];
			int idx = 0;
			for (int i = 0; i < temp.length; i++) {
				if (temp[i].id.equals(id)) {
					continue;
				}
				memberList[idx] = temp[i];
				idx++;
			}
			System.out.println("[삭제 완료]");
			memberCount--;
		}
	}

	void update() {
		int num = getInt("학번");
		if (!checkNum(num)) {
			System.err.println("학번이 존재하지 않습니다");
			return;
		} else {
			for (int i = 0; i < memberCount; i++) {
				if (memberList[i].num == num) {
					String id = getString("변경 아이디");
					if (checkId(id)) {
						System.err.println("이미 존재하는 아이디");
						return;
					} else {
						memberList[i].id = id;
						System.out.println("[아이디 변경완료]");
						return;
					}
				}
			}
		}
	}

	void printMember() {
		if (memberCount == 0) {
			System.err.println("멤버가 없습니다");
		} else {
			System.out.println("[전체출력]----------------");
			for (Member mb : memberList) {
				System.out.println(mb.toString());
			}
			System.out.println("-----------------------");
		}
	}

	void saveData() {
		// 저장패턴 memberList.text
		// 학번, 아이디\n 이렇게 한줄로 저장
		// 저장예시 >> 1001,test1\nl002,test2
		data = "";
		try {
			fw = new FileWriter(fileName);
			for (int i = 0; i < memberCount; i++) {
				data += memberList[i].num + "," + memberList[i].id + "\n";
			}
			fw.write(data);
			System.out.println("[저장 완료]");
		} catch (IOException e) {
			System.out.println("[저장 실패]");
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

	void loadData() {
		data = "";
		try {
			fr = new FileReader(fileName);
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			System.out.println("[파일 불러오기 성공]");
			System.out.print(data);
			System.out.println("--------------");
		} catch (FileNotFoundException e) {
			System.err.println("파일 찾을 수 없음");
		} catch (IOException e) {
			System.err.println("파일 불러오기 실패");
		}
	}
}