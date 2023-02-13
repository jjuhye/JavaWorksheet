package c_메서드;

//9:40~
import java.util.Scanner;

class BankNoReturn {

	Scanner scan = new Scanner(System.in);

	String name = "";

	String[] arAcc = { "1111", "2222", "3333", "", "" };
	String[] arPw = { "1234", "2345", "3456", "", "" };
	int[] arMoney = { 87000, 34000, 17500, 0, 0 };

	int count = 3;
	int loginCheck = -1;

	// 리턴안쓰므로 해서 생긴변수
//	int checkDelete;
	int idx;
	String checkAccount;
	String checkPassword;

	void showMenu() {
		System.out.println("\n=== [" + name + " ATM] ===");
		if (loginCheck == -1) {
			System.out.println("[1] 회원가입\n[2] 로그인");
		} else {
			System.out.println("[3] 회원탈퇴\n[4] 로그아웃\n[5] 입금\n[6] 이체");
		}
	}

	void showMember() {
		System.out.println("== [" + name + "] 회원정보 ==");
		System.out.printf("%-6s%-6s%-6s\n", "계좌번호", "비밀번호", "잔액");
		System.out.println("--------------------");
		for (int i = 0; i < count; i++) {
			System.out.printf("%-7s%-7s%-7s\n", arAcc[i], arPw[i], arMoney[i]);
		}
	}

	void joinMember() {
		System.out.println("== [" + name + "] 회원가입 ==");
		System.out.print("아이디 : ");
		String input = scan.next();
		for (int i = 0; i < count; i++) {
			if (input.equals(arAcc[i])) {
				System.err.println("중복 아이디 사용불가");
				return;
			}
		}
		arAcc[count] = input;
		System.out.print("비밀번호 : ");
		input = scan.next();
		arPw[count] = input;
		System.out.println(arAcc[count] + "님 회원가입 완료");
		count++;
	}

	void login() {
		System.out.println("== [" + name + "] 로그인 ==");
		System.out.print("아이디 : ");
		String input = scan.next();
		for (int i = 0; i < count; i++) {
			if (input.equals(arAcc[i])) {
				System.out.print("비밀번호 : ");
				input = scan.next();
				if (input.equals(arPw[i])) {
					System.out.println(arAcc[i] + "님 로그인 완료");
					checkAccount = arAcc[i];
					checkPassword = arPw[i];
					idx=i;
					loginCheck = 1;
					return;
				} else {
					System.err.println("비밀번호가 정확하지 않습니다.");
					return;
				}
			}
		}
		System.err.println("아이디가 정확하지 않습니다.");
	}

	void delMember() {
		System.out.println("== [" + name + "] 회원탈퇴 ==");
		System.out.print("비밀번호 : ");
		String input = scan.next();
		if (checkPassword.equals(input)) {
			System.out.println(checkAccount + "님 회원탈퇴 완료");
			for (int i = 0; i < count; i++) {
				if (arAcc[i].equals(checkAccount)) {
					for (int k = i; k < count - 1; k++) {
						arAcc[i] = arAcc[i + 1];
						arPw[i] = arPw[i + 1];
						arMoney[i] = arMoney[i + 1];
					}
					arAcc[count - 1] = "";
					arPw[count - 1] = "";
					arMoney[count - 1] = 0;
				}
			}
			checkAccount = "";
			checkPassword = "";
			loginCheck = -1;
			idx=-1;
			count--;
			return;
		} else {
			System.err.println("비밀번호가 정확하지 않습니다.");
			return;
		}
	}

	void logOut() {
		checkAccount = "";
		checkPassword = "";
		loginCheck = -1;
		idx=-1;
		System.out.println("로그아웃 완료");
		return;
	}

	void income() {
		System.out.println("== [" + name + "] 입금 ==");
		System.out.print("입금액 : ");
		int inputMoney = scan.nextInt();
		arMoney[idx]+=inputMoney;
		System.out.println("[입금 완료] 잔액 : "+arMoney[idx]);
	}

	void trans() {
		System.out.println("== [" + name + "] 이체 ==");
		System.out.print("입금 계좌 : ");
		String input = scan.next();
		for(String ac : arAcc) {
			if(input.equals(ac)) {
				System.out.print("이체금액 : ");
				int inputMoney = scan.nextInt();
				if(inputMoney>arMoney[idx]) {
					System.err.println();
				}
				arMoney[idx]+=inputMoney;
				
				
				return;
			}
			System.err.println("입금 계좌번호가 틀립니다.");
		}
		
		System.out.println("[입금 완료] 잔액 : "+arMoney[idx]);
	}
}

public class 메서드04_ATM {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		BankNoReturn woori = new BankNoReturn();
		woori.name = "우리은행";

		while (true) {
			// 전체 회원정보 출력
			if (woori.loginCheck == -1) {
				woori.showMember();
			}
			// 메뉴 출력
			woori.showMenu();
			// 메뉴 선택
			System.out.print("메뉴를 선택해주세요 : ");
			int choice = scan.nextInt();
			// 회원가입
			if (choice == 1 && woori.loginCheck == -1) {
				woori.joinMember();
			}
			// 로그인
			else if (choice == 2 && woori.loginCheck == -1) {
				woori.login();
			}
			// 회원탈퇴
			else if (choice == 3 && woori.loginCheck == 1) {
				woori.delMember();
			}
			// 로그아웃
			else if (choice == 4 && woori.loginCheck == 1) {

				woori.logOut();
				woori.loginCheck = -1;
			}
			// 입금
			else if (choice == 5 && woori.loginCheck == 1) {
				woori.income();
			}
			// 이체
			else if (choice == 6 && woori.loginCheck == 1) {
				woori.trans();
			} else {
				System.err.println("[입력오류]");
			}
		}
//===========
	}
}
