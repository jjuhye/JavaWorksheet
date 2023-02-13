package a_클래스;

import java.util.Arrays;
import java.util.Scanner;

/* 12:30~
 * # 숫자이동[3단계] : 클래스 + 변수
 * 1. 숫자2는 캐릭터이다.
 * 2. 숫자1을 입력하면, 캐릭터가 왼쪽으로
 * 	    숫자2를 입력하면, 캐릭터가 오른쪽으로 이동한다.
 * 3. 숫자 1은 벽이다. 벽을 만나면 이동할 수 없다.
 * 4. 단, 숫자3을 입력하면, 벽을 격파할 수 있다.
 * 5. 좌우 끝에 도달해도 계속 반대편으로 이동이 가능하다.
 * 예) 
 *  0 0 0 0 0 0 0 2 
 *  왼쪽(1) 오른쪽(2) : 2
 *  
 *  2 0 0 0 0 0 0 0 
 */

class MovingGame {
	int[] game = { 0, 0, 1, 0, 2, 0, 0, 1, 0 };
}

public class 클래스03_캐릭터이동 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		MovingGame mg = new MovingGame();
		int last = mg.game.length - 1;

		int idx = -1;
		for (int i = 0; i < mg.game.length; i++) {
			if (mg.game[i] == 2) {
				idx = i;
			}
		}

		while (true) {
			System.out.println(Arrays.toString(mg.game));
			System.out.println("왼쪽(1) 오른쪽(2) 종료(3)");
			System.out.print("입력 >> ");
			int sel = sc.nextInt();

			if (sel < 1 || sel > 3) {
				System.err.println("입력오류 : 1~3");
				continue;
			} else if (sel == 3) {
				System.err.println("[종료]");
				break;
			} else if (sel == 1) {
				while (true) {
					boolean wall = false;
					if (idx == 0) {
						if (mg.game[last] == 1) {
							wall = true;
						} else {
							mg.game[idx] = 0;
							idx = last;
							mg.game[idx] = 2;
							break;
						}
					} else {
						if (mg.game[idx - 1] == 1) {
							wall = true;
						} else {
							mg.game[idx] = 0;
							mg.game[idx - 1] = 2;
							idx--;
							break;
						}
					}
					if (wall) {
						System.err.println("벽입니다!");
						System.out.print("격파[1] 뒤로[0] >> ");
						int input = sc.nextInt();
						if (input == 0) {
							break;
						} else if (input == 1) {
							if (idx == 0) {
								mg.game[last] = 0;
							} else {
								mg.game[idx - 1] = 0;
							}
							continue;
						} else {
							System.err.println("입력오류 : 0~1");
						}
					}
				}
			} else if (sel == 2) {
				while (true) {
					boolean wall = false;
					if (idx == last) {
						if (mg.game[0] == 1) {
							wall = true;
						} else {
							mg.game[idx] = 0;
							idx = 0;
							mg.game[idx] = 2;
							break;
						}
					} else {
						if (mg.game[idx + 1] == 1) {
							wall = true;
						} else {
							mg.game[idx] = 0;
							mg.game[idx + 1] = 2;
							idx++;
							break;
						}
					}
					if (wall) {
						System.err.println("벽입니다!");
						System.out.print("격파[1] 뒤로[0] >> ");
						int input = sc.nextInt();
						if (input == 0) {
							break;
						} else if (input == 1) {
							if (idx == last) {
								mg.game[0] = 0;
							} else {
								mg.game[idx + 1] = 0;
							}
							continue;
						} else {
							System.err.println("입력오류 : 0~1");
						}
					}
				}

			}
		}
		sc.close();
	}

}