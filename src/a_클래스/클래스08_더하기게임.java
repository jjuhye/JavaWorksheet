package a_클래스;
/* 17:40~18:18
 * # 더하기 게임
 * 1. 1부터 10 사이의 랜덤한 값을 중복 없이 game 배열에 6개 저장한다.
 * 2. 6개의 배열의 인덱스를 0부터 5사이의 랜덤 값 3개를 중복 없이 선택해 
       그 인덱스의 값 의 합을 출력한다. 
 * 3. 사용자는 중복없이 3개의 인덱스를 골라 그 합을 맞추는 게임이다.
*  예)  4, 7, 5, 3, 2, 9  //   문제:  14   ==> 인덱스 3개를 골라서 합을 맞추면된다.  
    정답)  3,4,5 (여러가지 경우의 수가 나올수는있다)
 */

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class AddingGame {
	int[] game = new int[6];
	int[] idx = new int[3];
	int[] myIdx = new int[3];
	int total = 0;
}

public class 클래스08_더하기게임 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		AddingGame add = new AddingGame();

		for (int i = 0; i < add.game.length; i++) {
			add.game[i] = rd.nextInt(10) + 1;
			for (int k = 0; k < i; k++) {
				if (add.game[i] == add.game[k]) {
					i--;
					break;
				}
			}
		}
		System.out.println("랜덤 값 : " + Arrays.toString(add.game));
		for (int i = 0; i < add.idx.length; i++) {
			add.idx[i] = rd.nextInt(6);
			for (int k = 0; k < i; k++) {
				if (add.idx[i] == add.idx[k]) {
					i--;
					continue;
				}
			}
			add.myIdx[i] = add.game[add.idx[i]];
			add.total += add.myIdx[i];
		}
		System.out.println("3개 인덱스값의 합 >> " + add.total);
		System.out.println("=======================");

		int sum = 0;
		for (int i = 0; i < add.myIdx.length; i++) {
			System.out.print((i + 1) + "번째 인덱스 선택 [0~6] : ");
			int temp = sc.nextInt();
			if (temp < 0 || temp > 6) {
				System.err.println("인덱스 선택오류 [0~6]");
				i--;
				continue;
			}
			sum += add.game[temp];
		}
		System.out.println("=======================");
		if (add.total == sum) {
			System.out.println("정답입니다.");
		} else {
			System.out.println("틀렸습니다.");
		}
		System.out.println("=======================");
		sc.close();
	}
}
