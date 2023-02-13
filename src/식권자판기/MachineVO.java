package 식권자판기;

public class MachineVO {
	int money;
	int change;

	public MachineVO(int money, int change) {
		super();
		this.money = money;
		this.change = change;
	}

	@Override
	public String toString() {
		return "▶ " + money + "원권\t개수: " + change;
	}
}
