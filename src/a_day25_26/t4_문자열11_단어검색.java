package a_day25_26;

import java.util.Scanner;

public class t4_문자열11_단어검색 {

	public static void main(String[] args) {
		/*
		 * # 단어 검색 1. 단어를 입력받아 text변수 문장 속에 해당 단어가 있는지 검색한다. 2. 단어가 존재하면 true 단어가 없으면
		 * false를 출력한다.
		 */

		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		String tempT = text.substring(0, text.length() - 1);
		System.out.println(text);

		System.out.print("검색할 단어를 입력하세요 : ");
		String word = scan.next();

		String[] temp = tempT.split(" ");
		
		boolean check=false;
		for (String t:temp) {
			if (word.equalsIgnoreCase(t)) {
				check=true;
				break;
			}
		}
		System.out.println(check);
	}
}
