package a_day25_26;

import java.util.Arrays;

public class t8_문자열15_Split구현하기 {

	public static void main(String[] args) {
		// split은 자동으로 문자열을 배열로 만들어준다.
		// split을 사용하지않고 직접 잘라서 배열어 넣어보자.

		// 문제) 구분자를 기준으로 str 의 내용을 잘라내서 temp2 배열에 저장

		String str = "aaa/bbbb/ccc";
		char splitD = '/'; // 구분자

		int cnt=0;
		for (int i=0; i<str.length(); i++) {
			if(str.charAt(i)==splitD) {
				cnt++;
			}
		}
		String[] temp = new String[cnt+1];

		int idx = 0;
		temp[idx]="";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != splitD) {
				temp[idx]+=str.charAt(i);
			}else {
				idx++;
				temp[idx]="";
			}
		}
		System.out.println("temp = " + Arrays.toString(temp));
		
//		String tempStr = "";
//		for (int i = 0; i < str.length(); i++) {
//			if (str.charAt(i) == splitD) {
//				temp[idx] = tempStr;
//				idx++;
//				tempStr = "";
//			} else {
//				tempStr += str.charAt(i);
//			}
//		}
//		temp[idx] = tempStr;
//		System.out.println("temp = " + Arrays.toString(temp));

	}

}
