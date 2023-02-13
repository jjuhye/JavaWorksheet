package a_day25_26;

import java.util.Arrays;

public class s7_문자열7_문제데이터변환 {

	public static void main(String[] args) {

		// 문제1)
		String str = "11/100/89";
		int[] arr = new int[3];
		int sum = 0;

		for (int i = 0; i < arr.length; i++) {
			String[] temp = str.split("/");
			arr[i] = Integer.parseInt(temp[i]);
			sum += arr[i];
		}
		System.out.println(Arrays.toString(arr) + " 총점 : " + sum);

		// 문제2)
		int[] scores = { 11, 100, 89 };
		String text = "";

		for (int i = 0; i < scores.length; i++) {
			text += scores[i];
			if (i < scores.length - 1) {
				text += "/";
			}
		}
		System.out.println(text);

	}

}
