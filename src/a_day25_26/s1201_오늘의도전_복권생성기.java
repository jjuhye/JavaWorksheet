package a_day25_26;

import java.util.Arrays;
import java.util.Random;

public class s1201_오늘의도전_복권생성기 {

	public static void main(String[] args) {
		Random rd=new Random();
		/*
		 * # 당첨복권 1셋트
		 * 1. 3이 연속으로 3번 등장하면 당첨복권이다.
		 * 2. 랜덤으로 5개의 복권을 생성하되,
		 *    당첨복권은 한 개만 생성되도록 설정한다.

	    // 3030333 => 당첨 
	    // 0303030 => 꽝 
		 */

		int[][] lottoSet = new int[5][7];
		
		for (int i = 0; i < lottoSet.length; i++) {
			for (int k = 0; k < lottoSet[i].length; k++) {
				lottoSet[i][k]=rd.nextInt(4);
				if(lottoSet[i][k]!=0 && lottoSet[i][k]!=3){
					i--;
					break;
				}
			}
		}
		for (int j = 0; j < lottoSet.length; j++) {
			System.out.println(Arrays.toString(lottoSet[j]));
		}
	}
}
