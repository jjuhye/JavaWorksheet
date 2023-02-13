package 상속RPG1;

import java.util.Random;
import java.util.Scanner;

public class Game1 {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	final int BOSS = 9;
	final int MONSTER =8;
	final int SIZE = 10;
	
	int map[];
	Player1 player;
	boolean win;
	void init() {
		map = new int[SIZE];
		win = true;
		player= new Player1(100, 10, "전사");
		map[3] = MONSTER;
		map[5] = MONSTER;
		map[7] = MONSTER;
		map[SIZE-1] = BOSS;
	}
	
	void printGameMap() {
		for(int i =0;i<map.length;i++) {
			if(i == player.position) {
				System.out.print("[옷]");
			}else if(map[i] == MONSTER) {
				System.out.print("[M]");
			}else if(map[i] == BOSS){
				System.out.print("[B]");
			}else {
				System.out.print("[ ]");
			}
		}
		System.out.println();
	}
	

	int mainMenu() {
		System.out.println("[0]종료[1]한칸이동[2]체력회복");
		int num = sc.nextInt();
		if(num <= 0 || num >2) {
			return 0;
		}else {
			return num;
		}
	}
	
	Monster1 createMonster() {
		int index = rd.nextInt(3);
		return Monster1.getMonster().init(index);
	}
	
	void battleMonster(Monster1 monster) {
		
		System.out.println("========= [ 전투 ]==========");
		boolean turn = true;
		while(true) {
			if(turn) {
				System.out.println("[플레이어 차례]");
				System.out.println("[1]공격 [2]스킬");
				int sel = sc.nextInt();
				if(sel == 1) {
					player.attack(monster);
				} else if(sel == 2) {
					player.skill(monster);
				}else {
					System.out.println("입력오류");
					continue;
				}
				if(monster.isDead()) {
					if(monster.boss) player.levelUp();
					player.item++;
					System.out.println("[체력 회복 아이템 1개 획득]");
					break;
				}
				
			}else {
				System.out.println("[몬스터 차례]");
				monster.attack(player);
				if(player.isDead()) {
					System.out.println("[게임 패배]");
					win = false;
					break;
				}
			}
			turn = !turn;
		}
	}
	
	void battleBoss(Monster1 m) {
		System.out.println("========= [ 보스 등장 ]==========");
		m.boss = true;
		m.beABoss();
	}
	
	void run() {
		init();
		System.out.println("[ 게임 시작 ]");
		//player.position =8;
		while(true) {
			printGameMap();
			int sel = mainMenu();
			if(sel ==0) {
				System.out.println("[ 게임 종료 ] ");
				return;
			}
			if(sel == 1) {
				player.movePlayer(SIZE);
			}else {
				player.drinkPotion();
				continue;
			}
			
			if(map[player.position] == MONSTER) {
				Monster1 m = createMonster();
				battleMonster(m);
			} else if(map[player.position] == BOSS) {
				Monster1 m = createMonster();
				battleBoss(m); 
				battleMonster(m);
			}
			
			if(win == false) {
				System.out.println("[ 게임 오버 ]");
				return;
			}else {
				map[player.position] =0;
			}
			if(player.position == SIZE-1) {
				System.out.println("[ 게임 클리어 ]");
				return;
			}
		}
		
	}
	
	
}
