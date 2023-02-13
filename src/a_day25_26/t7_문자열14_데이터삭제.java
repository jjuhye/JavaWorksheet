package a_day25_26;

public class t7_문자열14_데이터삭제 {

	public static void main(String[] args) {
		// 데이터에서 꼴등을 삭제후 다시 문자열로 변경
		// 1) 문자열을 잘라서 배열에 저장한다.
		// 2) 배열에서 꼴등을 삭제한다
		// 3) 삭제한배열을 다시 문자열로 만든다.

		// str = "김철수/87,

		String str = "김철수/87,이만수/42,이영희/92";

		String temp[] = str.split(",");
		int min = 100;
		String del = "";
		for (int i = 0; i < temp.length; i++) {
			int score = Integer.parseInt(temp[i].substring(4));
			if (score < min) {
				min = score;
				del = temp[i];
			}
		}
		str = str.replaceAll(del, "");
		str = str.replaceAll(",,", ",");
		if(str.charAt(str.length()-1)==',') {
			str = str.substring(0,str.length()-1);
		}

		System.out.println(str);
	}
}
