package 객체지향_이해;

public class Account {
	private int balance;
	private Account parent;

	/** Initialize an account with the given balance. */
	public Account(int balance) {
		this.balance = balance;
	}

	public Account(int balance, Account who) {
		this.balance = balance;
		this.parent = who;
	}

	/** Returns the balance for the current account. */
	public int getBalance() {
		return balance;
	}

	/** Deposits amount into the current account. */
	public void deposit(int amount) {
		balance += amount;
	}

	/**
	 * Subtract amount from the account if possible. If subtracting amount would
	 * leave a negative balance, print an error message and leave the balance
	 * unchanged.
	 */
	public boolean withdraw(int amount) {
		if (balance < amount) {
			System.err.println("잔액부족");
			int money = amount - balance;
			if (parent != null && parent.getBalance() >= money) {
				parent.withdraw(money);
				withdraw(getBalance());
//				balance = 0;
				System.out.println("부모계좌에서 " + money + "원 빌림");
				return true;
			}
			return false;
		}
		balance -= amount;
		getBalance();
		return true;
	}

	/**
	 * Merge account other into this account by removing all money from other and
	 * depositing it into this account.
	 */
	public void merge(Account other) {
		deposit(other.getBalance());
		other.balance = 0;
	}
}
