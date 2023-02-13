package ATM;

public class Account {
	private int clientNo;
	private String accountNumber;
	private int money;
	
	public Account(int clientNo, String accountNumber, int money) {
		super();
		setClientNo(clientNo);
		setAccountNumber(accountNumber);
		setMoney(money);
	}

	@Override
	public String toString() {
		return clientNo+"\t"+accountNumber + "\t  " + money;
	}

	public int getClientNo() {
		return clientNo;
	}

	public void setClientNo(int clientNo) {
		this.clientNo = clientNo;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
