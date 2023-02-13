package c_메서드;

import java.util.Arrays;

class Return2 {

	int[] run(String[][] data) {
		
		int idx=0;
		int[] temp=new int[data.length];
		int[] result=null;
		for (int i=0; i<data.length; i++) {
			if (Integer.parseInt(data[i][1]) >= 60) {
				temp[idx]=Integer.parseInt(data[i][0]);
				idx++;
			}
			result=new int[idx];
			for(int k=0; k<result.length; k++) {
				result[k]=temp[k];
			}
		}
		
		return result;
//		int cnt = 0;
//		for (String[] d : data) {
//			if (Integer.parseInt(d[1]) >= 60) {
//				cnt++;
//			}
//		}
//		
//		int[] result = new int[cnt];
//		
//		cnt = 0;
//		for (String[] d : data) {
//			if (Integer.parseInt(d[1]) >= 60) {
//				result[cnt] = Integer.parseInt(d[0]);
//				cnt++;
//			}
//		}
//		return result;
	}
}

public class 메서드_리턴문제2 {

	public static void main(String[] args) {
		/*
		 * [문제] 아래 main() 메서드 안에 data배열은 학생의 번호와 점수를 문자열 타입으로 저장한 것이다. 번호는 1001부터 1004까지
		 * 있고 점수는 0~100점 사이이며, 60점 이상이면 합격이다. 오로지 합격생의 번호만 result배열에 담아서 리턴해주는 run 메서드를
		 * 구현하시오.
		 */
		Return2 re = new Return2();

		String data[][] = { { "1001", "34" }, { "1002", "46" }, { "1003", "81" }, { "1004", "100" }, };
		int result[] = re.run(data);

		System.out.println(Arrays.toString(result));

		// 완성된 result 출력 // [1003,1004]
	}
}
