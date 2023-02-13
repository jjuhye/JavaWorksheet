package 상속RPG1;

public class Player1 extends Unit1{
	int level=1;
	int item;
	int position;
	
	public Player1(int hp, int power, String name) {
		super(hp, power, name);
	}

	@Override
	public String toString() {
		System.out.println(UnitInfo());
		return "[레벨:" +level+"]" + "[위치:"+ position +"]";
	}

	void movePlayer(int max) {
		if(position < max-1) {
			position++;
		}
	}

	void drinkPotion() {
		if (item == 0) {
			System.out.println("[체력 포션이 없습니다]");
			return;
		}
		item--;
		if (50 + hp >= maxHp) {
			hp = maxHp;
		} else {
			hp += 50;
		}
		System.out.println("[hp가 50+ 상승했습니다]");
		System.out.println(this);

	}
	void skill(Unit1 u) {
		u.hp-=power;
		u.hp-= (power/10*3);
		System.out.println("[깊게 찌르기] 공격력의 30%증가로"+ u.name+" 데미지 공격");
		System.out.println(u.UnitInfo());
	}
	
	void levelUp() {
		level++;
		power+=5;
		hp+=10;
		maxHp+=10;
		item+=1;
		System.out.printf("[레벨업! %d]\n" , level);
	}
	
}
