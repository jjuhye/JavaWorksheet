package a_day25_26;

public class t2_문자열9_문자데이터변환3 {

	public static void main(String[] args) {
		// 문제) 이름과 성적을 아래와같이 하나의 문자열로 연결
				// 정답) "김철수/87,이만수/42,이영희/95"
				
				String[] name = { "김철수", "이만수", "이영희" };
				int[] score = { 87, 42, 95 };
				
				String str = "";

				for (int i = 0; i < score.length; i++) {
					str+=name[i]+"/";
					str+=score[i]+",";
				}
				str=str.substring(0,str.length()-1);
				System.out.println(str);
	}
}
