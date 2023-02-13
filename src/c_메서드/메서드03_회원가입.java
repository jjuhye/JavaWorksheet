package c_메서드;

import java.util.Arrays;
import java.util.Scanner;

//메서드 생성원칙 : 1. 영어로 동사로 시작 , 리턴값이 boolean 값이면 is 
//메서드는 기능 1개만 구현한다 

class MemberManager2 {
	// 추가 삭제 수정
	int maxSize = 10; // 총 10명만 추가 할 수 있음

	int initNum = 1001; // 맨 처음 추가 회원 번호
	int cnt; // 현재 추가된 회원 수

	String id = "";
	String pw = "";
	String name = "";

	// [0]번호 [1]아이디 [2]비밀번호 [3]이름
	String[][] memberList = new String[maxSize][4];

	// 회원 추가 => 중복아이디 값이 없어야한다
	// 회원 번호 자동으로 생성 : 자동으로 1 증가하게
	void addMember() {
		if (cnt == maxSize) {
			System.err.println("회원가입 인원초과");
			return;
		}
		id = getInputSt("아이디 : ");
		if (checkId(id)) {
			getInputSt("비밀번호 : ");
			name = getInputSt("이름 : ");
			memberList[cnt][0] = initNum + "";
			memberList[cnt][1] = id;
			memberList[cnt][2] = pw;
			memberList[cnt][3] = name;
			cnt++;
			initNum++;
			System.out.println("[" + id + " 가입 완료]");
		}
	}

	// 아이디 체크
	boolean checkId(String id) {
		for (String[] mb : memberList) {
			if (id.equals(mb[1])) {
				System.err.println("중복 아이디가 존재합니다.");
				return false;
			}
		}
		return true;
	}

	// 회원 번호 체크
	boolean checkNum(String num) {
		int idx = -1;
		for (int i = 0; i < cnt; i++) {
			if (num.equals(memberList[i][0])) {
				return true;
			}
		}
		System.err.println("회원번호가 존재하지 않습니다.");
		return false;
	}

	// 전체 회원 출력
	void printMember() {
		System.out.printf("%-7s%-10s%-10s%-10s\n", "회원번호", "아이디", "비밀번호", "이름");
		System.out.println("----------------------------------");
		for (int i = 0; i < cnt; i++) {
			System.out.printf("%-7s", memberList[i][0]);
			System.out.printf("%-10s", memberList[i][1]);
			System.out.printf("%-10s", memberList[i][2]);
			System.out.printf("%-10s", memberList[i][3]);
			System.out.println();
		}
	}

	// 회원 삭제 => 아이디 입력 받아서 아이디가 있으면 회원삭제
	void delMember() {
		String delId = getInputSt("삭제할 아이디 : ");

		for (int i = 0; i < cnt; i++) {
			if (delId.equals(memberList[i][1])) {
				for (int k = i; k < cnt - 1; k++) {
					memberList[k][0] = memberList[k + 1][0];
					memberList[k][1] = memberList[k + 1][1];
					memberList[k][2] = memberList[k + 1][2];
					memberList[k][3] = memberList[k + 1][3];
				}
				memberList[cnt - 1] = new String[4];
				cnt--;
				System.out.println("[회원 삭제 완료]");
				return;
			}
		}
		System.err.println("아이디가 존재하지 않습니다.");
	}

	// 회원 수정 => 회원 번호 입력 받아서 아이디 수정하기
	void amendMember() {
		String num = getInputSt("회원 번호 : ");
		if (checkNum(num)) {
			String newId = getInputSt("새 아이디 : ");
			if (checkId(newId)) {
				for (int i = 0; i < cnt; i++) {
					if (num.equals(memberList[i][0])) {
						memberList[i][1] = newId;
						System.out.println("[아이디 수정 완료]");
						return;
					}
				}
			}
		}
	}

	// 메뉴출력
	void printMenu() {
		String menu = "==== 메가 회원 === \n";
		menu += "[1] 회원 추가 \n";
		menu += "[2] 회원 출력 \n";
		menu += "[3] 회원 삭제 \n";
		menu += "[4] 회원 수정 \n";
		menu += "[0] 종   료 \n";
		System.out.println(menu);
	}

	// 사용자에게 입력 받아오는 기능 :정수
	int getInputInt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		System.out.print("입력 >> ");
		return sc.nextInt();
	}

	// 사용자에게 입력 받아오는 기능 :문자열
	String getInputSt(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg);
		return sc.next();
	}

	void run() {

		while (true) {
			printMenu();
			int sel = getInputInt("메뉴 선택하시오");

			if (sel == 0) {
				System.out.println("=== 프로그램 종료 ===");
				return;
			} else if (sel == 1) {
				System.out.println("=== 회원 추가 ===");
				addMember();
			} else if (sel == 2) {
				System.out.println("=== 회원 출력 ===");
				printMember();
			} else if (sel == 3) {
				System.out.println("=== 회원 삭제 ===");
				delMember();
			} else if (sel == 4) {
				System.out.println("=== 회원 수정 ===");
				amendMember();
			} else {
				System.err.println("번호 입력 오류 [0~4]");
			}
		}
	}
}

public class 메서드03_회원가입 {

	public static void main(String[] args) {

		MemberManager2 mg = new MemberManager2();
		mg.run();

	}
}
