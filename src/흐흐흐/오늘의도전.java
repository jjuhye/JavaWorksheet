package test;

import java.util.Arrays;
import java.util.Random;

public class ¿À´ÃÀÇµµÀü {

	public static void main(String[] args) {

		Random rd = new Random();

		int[][] lottoSet = new int[5][7];
		boolean check = true;
		for (int i = 0; i < lottoSet.length; i++) {
			int cnt = 0;
			for (int k = 0; k < lottoSet[i].length; k++) {
				lottoSet[i][k] = rd.nextInt(4);
				if (lottoSet[i][k] != 0 && lottoSet[i][k] != 3) {
					k--;
					continue;
				}
				if (lottoSet[i][k] == 0) {
					cnt = 0;
					continue;
				}
				cnt++;
				if (cnt == 3 && check == true) {
					System.out.println((i + 1) + "¹øÂ° º¹±Ç ´çÃ·");
					check = false;
					cnt = 0;
				} else if (cnt == 3 && check == false) {
					lottoSet[i][k] = 0;
				}
			}
		}
		if (check == true) {
			System.out.println("²Î!!");
		}
		for (int j = 0; j < lottoSet.length; j++) {
			System.out.println(Arrays.toString(lottoSet[j]));
		}
	}
}
