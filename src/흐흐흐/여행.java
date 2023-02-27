package test;

import java.util.Arrays;

public class 여행 {

	public static void main(String[] args) {
		// 10:05~13:20
		
		int map[][] = {
				{0,0,0,0,0,0,0},	
				{0,7,7,7,7,0,0},	
				{0,7,0,0,7,0,0},	
				{0,7,0,8,7,0,0},	
				{0,0,0,0,7,0,0},	
				{0,0,0,0,7,7,0},	
				{0,0,0,0,0,0,0}
		};		
		int dir = 0;
		int input[] = { 1, 1, 2, 1, 1, 2, 1, 1, 3, 1, 1 };
		int myX = -1;
		int myY = -1;

		for (int i = 0; i < map.length; i++) {
			for (int k = 0; k < map.length; k++) {
				if (map[i][k] == 8) {
					myY = i;
					myX = k;
				}
			}
		}
		System.out.println("처음위치 = [" + myY + ", " + myX + "] >> 방향 : "+dir);
		System.out.println("========================");

		for (int i = 0; i < input.length; i++) {
			if (input[i] == 1) {
				if (dir == 0) {
					if (myY == 0 || map[myY-1][myX] == 7) {
						System.out.println(input[i]+" >> !!길이 아닙니다!! >> 방향 : "+dir);
						System.out.println("========================");
						continue;
					}
					map[myY][myX] = 0;
					myY--;
					map[myY][myX] = 8;
				}
				if (dir == 1) {
					if (myX == 6 || map[myY][myX + 1] == 7) {
						System.out.println(input[i]+" >> !!길이 아닙니다!! >> 방향 : "+dir);
						System.out.println("========================");
						continue;
					}
					map[myY][myX] = 0;
					myX++;
					map[myY][myX] = 8;
				}
				if (dir == 2) {
					if (myY == 6 || map[myY + 1][myX] == 7) {
						System.out.println(input[i]+" >> !!길이 아닙니다!! >> 방향 : "+dir);
						System.out.println("========================");
						continue;
					}
					map[myY][myX] = 0;
					myY++;
					map[myY][myX] = 8;
				}
				if (dir == 3) {
					if (myX == 0 || map[myY][myX - 1] == 7) {
						System.out.println(input[i]+" >> !!길이 아닙니다!! >> 방향 : "+dir);
						System.out.println("========================");
						continue;
					}
					map[myY][myX] = 0;
					myX--;
					map[myY][myX] = 8;
				}
				for (int j = 0; j < map.length; j++) {
					for (int k = 0; k < map.length; k++) {
						if (map[j][k] == 0) {
							System.out.print("□ ");
						}
						if (map[j][k] == 7) {
							System.out.print("■ ");
						}
						if (map[j][k] == 8) {
							System.out.print("♣ ");
						}
						if (k == 6) {
							System.out.println();
						}
					}
				}
			}
			if (input[i] == 2) {
				dir -= 1;
				if (dir == -1) {
					dir = 3;
				}
			}
			if (input[i] == 3) {
				dir += 1;
				if (dir == 4) {
					dir = 0;
				}
			}
			System.out.println(input[i]+" >> 내위치 = [" + myY + ", " + myX + "] >> 방향 : "+dir);
			System.out.println("========================");
		}
	}
}
