package a_day25_26;

import java.util.Arrays;

public class t1_문자열8_문자데이터변환2 {

	public static void main(String[] args) {
		// 문제) 이름은 name배열에 성적은 score배열에 각각 저장 및 출력
		
			String str = "김철수/87,이만수/42,이영희/95";
			
			String[] name = new String[3]; // 김철수,이만수,이영희
			int[] score = new int[3];      // 87,42,95
			
			String[] temp=str.split(",");
			
			int idx=0;
			for(String t : temp) {
				String data[]=t.split("/");
				name[idx]=data[0];
				score[idx]=Integer.parseInt(data[1]);
				idx++;
			}
			
			System.out.println(Arrays.toString(name));
			System.out.println(Arrays.toString(score));
	}
}
