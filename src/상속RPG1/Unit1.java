package 상속RPG1;

public class Unit1 {
	int hp;
	int maxHp;
	int power;
	String name;
	
	public Unit1(int hp, int power, String name) {
		super();
		this.hp = hp;
		this.maxHp = hp;
		this.power = power;
		this.name = name;
	}
	
	void attack(Unit1 u) {
		u.hp -= power;
		System.out.printf("[%s]가 [%s]에게 [%d] 데미지 공격\n" , name , u.name, power);
		System.out.println(UnitInfo());
		System.out.println(u.UnitInfo());
	}
	
	boolean isDead() {
		if(hp <= 0) {
			System.out.printf("[%s]가 사망했습니다\n" , name);
			return true;
		}
		return false;
	}

	public String UnitInfo() {
		return name + "["+hp+"/"+maxHp+"]";
	}
	
	
	
	
}
