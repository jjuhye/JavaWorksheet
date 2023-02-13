package 프로젝트1;

import java.util.Arrays;

public class 플젝04_달팽이 {

	public static void main(String[] args) {
		/* 17:56~
			 * [달팽이]
			 * 아래와같이 출력하시오.
			 * 
			 * 1	2	3	4	5	
			 * 16	17	18	19	6	
			 * 15	24	25	20	7	
			 * 14	23	22	21	8	
			 * 13	12	11	10	9
			 */

		int[][] arr=new int[5][5];
		int idx=1;
		int y=0;
		int x=0;
		int dir=1;
		int cnt=5;
		for(int i=0; i<25; i++) {
			for (int k = 0; k <cnt ; k--) {
				arr[y][x] = idx;
				if (k == cnt - 1) {
					if (dir == 1) {
						x++;
					} else if (dir == 2) {
						y++;
					} else if (dir == 3) {
						x--;
					} else {
						y--;
					}
				}
				idx++;
				cnt--;
			}
			dir++;
			if(dir==4) {
				dir=1;
			}
		}
		
		for(int i=0; i<arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
//		System.out.printf("%3d",idx);
		
	}

}
