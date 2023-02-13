package 상속RPG1;

public class Monster1 extends Unit1 {
	boolean boss;
	String[] names = { "늑대", "박쥐", "좀비" };
	String[] attack = { "[할퀴기]", "[음파공격]", "[물어뜯기]" };
	static int idx;

	private Monster1(int hp, int power, String name) {
		super(hp, power, name);
	}
	
	private static Monster1 monster = new Monster1(0,0,null);
	
	static Monster1 getMonster() {
		return monster;
	}
	
	void beABoss() {
		name+="[보스] "+name;
		hp+=50;
		maxHp = hp;
		power+=30;
		System.out.println(UnitInfo());
	}
	Monster1 init(int idx) {
		Monster1 m = null;
		this.idx = idx;
		if (idx == 0) {
			return new Monster1(35, 5, names[idx]);
		} else if (idx == 1) {
			return new Monster1(49, 7, names[idx]);
		} else {
			return new Monster1(63, 9, names[idx]);
		}

	}
	
	void attack(Player1 player) {
		if(idx == 0) {
			player.hp -= 3;
			player.hp -= power;
			System.out.println( attack[idx]);
			System.out.println("플레이어의 현재 체력이 10% 감소하고 늑대 체력이 +5 증가한다.");
		}else if(idx == 1) {
			int damage = player.hp / 10;
			player.hp -= damage;
			hp += 5;
			if(hp >= maxHp) {
				hp = maxHp;
			}
			System.out.println( attack[idx]);	
			System.out.println("플레이어는 음파공격으로 기본공격력 -3, 체력 -3 감소한다.");
			
		}else if(idx == 2) {
			int addPower = power /10 * 3;
			power += addPower;
			System.out.println( attack[idx]);
			System.out.println("좀비의 공격력이 30% 증가한다.");
		}
	}
	
}
