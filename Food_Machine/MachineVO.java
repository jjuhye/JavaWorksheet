package Food_Machine;

public class MachineVO {
	int money;
	int change;
	String Test;

	public MachineVO(int money, int change) {
		super();
		this.money = money;
		this.change = change;
	}

	@Override
	public String toString() {
		return "�뼳 " + money + "�썝沅�\t媛쒖닔: " + change;
	}
}
