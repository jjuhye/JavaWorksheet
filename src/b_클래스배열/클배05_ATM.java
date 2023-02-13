package b_클래스배열;

import java.util.Scanner;

//55분
class Members {
	int number;
	String id;
	String name;
}

class Account {
	String accountNumber;
	String password;
	int money;
	String memberId;
}

public class 클배05_ATM {

	public static void main(String[] args) {
		String[][] memberData = { { "1001", "qwer", "김철수" }, { "1002", "mmkk11", "이영희" },
				{ "1003", "javaking123", "최민수" } };
		String[][] accountData = { { "111111111", "1234", "100000", "qwer" },
				{ "222222222", "1234", "200000", "mmkk11" }, { "333333333", "1234", "300000", "mmkk11" },
				{ "444444444", "1234", "400000", "javaking123" }, { "555555555", "1234", "500000", "qwer" },
				{ "666666666", "1234", "600000", "qwer" }, };

		Members[] memberList = new Members[memberData.length];
		Account[] accountList = new Account[accountData.length];

		Scanner scan = new Scanner(System.in);

		while (true) {
			String menu = "";
			menu += "[0] 종료 \n";
			menu += "[1] 위data배열들의 값들을 클래스배열에 저장후 출력\n";
			menu += "[2] 회원아이디를 입력받고 계좌별 잔액출력\n";
			menu += "[3] 222222222 계좌에서 444444444 계좌로 5000원송금후 전체출력";
			System.out.println(menu);

			int sel = scan.nextInt();
			if (sel == 0) {
				System.out.println("[종료]");
				break;
			} else if (sel == 1) {
				System.out.println("=============================");
				System.out.printf("%-7s%-13s%-7s\n", "회원번호", "아이디", "이름");
				System.out.println("-----------------------------");
				for (int i = 0; i < memberData.length; i++) {
					Members m = new Members();
					m.number = Integer.parseInt(memberData[i][0]);
					m.id = memberData[i][1];
					m.name = memberData[i][2];
					memberList[i] = m;
				}
				for (Members mb : memberList) {
					System.out.printf("%-7d%-13s%-7s\n", mb.number, mb.id, mb.name);
				}
				System.out.println("==========================================");
				System.out.printf("%-13s%-10s%-10s%-10s\n", "계좌번호", "비밀번호", "잔액", "아이디");
				System.out.println("------------------------------------------");
				for (int i = 0; i < accountData.length; i++) {
					Account a = new Account();
					a.accountNumber = accountData[i][0];
					a.password = accountData[i][1];
					a.money = Integer.parseInt(accountData[i][2]);
					a.memberId = accountData[i][3];
					accountList[i] = a;
				}
				for (Account ac : accountList) {
					System.out.printf("%-13s%-10s%-10d%-10s\n", ac.accountNumber, ac.password, ac.money, ac.memberId);
				}
				System.out.println("==========================================");
			} else if (sel == 2) {
				System.out.print("아이디 입력 : ");
				String input = scan.next();
				boolean check = true;
				for (Account ac : accountList) {
					if (ac.memberId.equals(input)) {
						check = false;
					}
				}
				if (check) {
					System.err.println("아이디를 찾을 수 없습니다");
					continue;
				} else {
					System.out.println("======================");
					System.out.printf("%-13s%-10s\n", "계좌번호", "잔액");
					System.out.println("----------------------");
					for (Account ac : accountList) {
						if (ac.memberId.equals(input)) {
							System.out.printf("%-13s%-10s\n", ac.accountNumber, ac.money);
						}
					}
					System.out.println("======================");
				}

			} else if (sel == 3) {
				String sendAc = "222222222";
				String rcvdAc = "444444444";
				int sendMoney = 50000;
				boolean check = true;
				for (Account ac : accountList) {
					if (ac.accountNumber.equals(sendAc)) {
						if (ac.money < sendMoney) {
							System.err.println("[" + sendAc + " 계좌 잔액부족]");
							check = false;
							break;
						}
						ac.money -= sendMoney;
					}
					if (ac.accountNumber.equals(rcvdAc)) {
						ac.money += sendMoney;
					}
				}
				if (check) {
					System.out.println("[" + sendAc + "에서 " + rcvdAc + "로 " + sendMoney + "원 정상송금]");
				}
				System.out.println("==========================================");
				System.out.printf("%-13s%-10s%-10s%-10s\n", "계좌번호", "비밀번호", "잔액", "아이디");
				System.out.println("------------------------------------------");
				for (Account ac : accountList) {
					System.out.printf("%-13s%-10s%-10d%-10s\n", ac.accountNumber, ac.password, ac.money, ac.memberId);
				}
				System.out.println("==========================================");
			} else {
				System.err.println("입력오류 [0~3]");
				continue;
			}
		}
		scan.close();
	}
}
