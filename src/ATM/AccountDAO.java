package ATM;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountDAO {

	private Util u = new Util();
	private Account ac;
	static ArrayList<Account> accountList = new ArrayList<Account>();

	void dataSetting(String data) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String temp[] = data.split("\n");
		for (String t : temp) {
			int num = 0;
			String temp2[] = t.split("/");
			for (Client c : clientList) {
				if (c.id.equals(temp2[0])) {
					num = c.clientNo;
					break;
				}
			}
			ac = new Account(num, temp2[1], Integer.parseInt(temp2[2]));
			accountList.add(ac);
		}
	}

	private Boolean isAcc(String acc) {
		String accPattern = "^\\d{4}-\\d{4}-\\d{4}$";
		Pattern p = Pattern.compile(accPattern);
		Matcher m = p.matcher(acc);
		boolean valid = m.matches();

		try {
			if (!valid) {
				throw new InvalidAccountNumberException("1111-1111-1111 이와같은 형태로 입력해주세요");
			}
		} catch (InvalidAccountNumberException e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	private boolean checkAcc(String acc) {
		for (int i = 0; i < accountList.size(); i++) {
			if (acc.equals(accountList.get(i).getAccountNumber())) {
				return true;
			}
		}
		return false;
	}

	// 로그인사용자[1] 계좌 추가
	void addAcount(int log) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String acc = u.getString("계좌번호");
		if (isAcc(acc)) {
			if (checkAcc(acc)) {
				System.err.println("이미 존재하는 계좌");
				return;
			}
			ac = new Account(clientList.get(log).clientNo, acc, 0);
			accountList.add(ac);
			System.out.println("[계좌추가 완료]");
		}
	}

	// 로그인사용자[2] 계좌 삭제
	void deleteAcount(int log) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String acc = u.getString("삭제할 계좌번호");
		if (isAcc(acc)) {
			for (int i = 0; i < accountList.size(); i++) {
				if (acc.equals(accountList.get(i).getAccountNumber())
						&& accountList.get(i).getClientNo() == clientList.get(log).clientNo) {
					accountList.remove(i);
					System.out.println("[계좌삭제 완료]");
					return;
				}
			}
			System.err.println("계좌번호를 확인하세요");
		}
	}

	// 로그인사용자[3] 입금
	void creditMoney(int log) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String acc = u.getString("입금 계좌번호");
		int money = 0;
		if (isAcc(acc)) {
			for (int i = 0; i < accountList.size(); i++) {
				if (acc.equals(accountList.get(i).getAccountNumber())
						&& accountList.get(i).getClientNo() == clientList.get(log).clientNo) {
					int balance = accountList.get(i).getMoney();
					money = u.getValue("입금 금액");
					if (money < 100) {
						System.err.println("100원 이상 입금해주세요");
						return;
					}
					accountList.get(i).setMoney(money + balance);
					System.out.println("[입금 완료]");
					return;
				}
			}
			System.err.println("계좌번호를 확인하세요");
		}
	}

	// 로그인사용자[4] 출금
	void debitMoney(int log) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String acc = u.getString("출금 계좌번호");
		int money = 0;
		if (isAcc(acc)) {
			for (int i = 0; i < accountList.size(); i++) {
				if (acc.equals(accountList.get(i).getAccountNumber())
						&& accountList.get(i).getClientNo() == clientList.get(log).clientNo) {
					int balance = accountList.get(i).getMoney();
					money = u.getValue("출금 금액");
					if (money < 100) {
						System.err.println("100원 이상 입금해주세요");
						return;
					}
					if (money > balance) {
						System.err.println("잔액이 부족합니다");
						return;
					}
					accountList.get(i).setMoney(balance - money);
					System.out.println("[출금 완료]");
					return;
				}
			}
			System.err.println("계좌번호를 확인하세요");
		}
	}

	// 로그인사용자[5] 이체
	void sendMoney(int log) {
		ArrayList<Client> clientList = ClientDAO.clientList;
		String acc = u.getString("출금 계좌번호");
		String rcvAcc = u.getString("입금 계좌번호");
		if (!isAcc(acc) || !isAcc(rcvAcc)) {
			return;
		}
		if (acc.equals(rcvAcc)) {
			System.err.println("동일한 계좌로 이체불가");
			return;
		}
		int money = 0;
		int balance = 0;
		for (int i = 0; i < accountList.size(); i++) {
			if (acc.equals(accountList.get(i).getAccountNumber())
					&& accountList.get(i).getClientNo() == clientList.get(log).clientNo) {
				balance = accountList.get(i).getMoney();

				for (int k = 0; k < accountList.size(); k++) {
					if (isAcc(rcvAcc) && rcvAcc.equals(accountList.get(k).getAccountNumber())) {
						int rcvBalance = accountList.get(k).getMoney();
						money = u.getValue("출금 금액");
						if (money < 100) {
							System.err.println("100원 이상 입금해주세요");
							return;
						}
						if (money > balance) {
							System.err.println("잔액이 부족합니다");
							return;
						}
						accountList.get(i).setMoney(balance - money);
						accountList.get(k).setMoney(rcvBalance + money);
						System.out.println("[이체 완료]");
						return;
					}
				}
				System.err.println("입금 계좌번호를 확인하세요");
				return;
			}
		}
		System.err.println("출금 계좌번호를 확인하세요");
	}
}
