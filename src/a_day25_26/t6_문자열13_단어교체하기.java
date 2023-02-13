package a_day25_26;

import java.util.Scanner;

public class t6_문자열13_단어교체하기 {

	public static void main(String[] args) {
		/*
		 * # 단어 교체하기(replace) 1. text변수 문장 속에서 변경하고 싶은 단어를 입력받아, 2. 교체해주는 기능을 구현한다. 예)
		 * Life is too short. 변경하고 싶은 단어입력 : Life 바꿀 단어입력 : Time
		 * 
		 * Time is too short. // 해당 문자 출력 // Life 이미 Time 으로 바꿨기때문에 다시 life 입력하면 못찾아야함
		 */

		Scanner scan = new Scanner(System.in);

		String text = "Life is too short.";
		System.out.println(text);

		System.out.print("변경하고 싶은 단어를 입력하세요 : ");
		String word = scan.nextLine();

		text = text.substring(0, text.length() - 1);
		String[] data = text.split(" ");

		boolean err = true;
		for (String t : data) {
			if (word.equals(t)) {
				System.out.print("바꿀 단어 입력 : ");
				String word2 = scan.nextLine();
				if(word2.equals(t)) {
					System.err.println("동일 단어 변경 불가");
					err=false;
					break;
				}
				text = text.replaceAll(word, word2);
				System.out.println(text+".");
				err = false;
				break;
			}
		}
		if (err) {
			System.err.println("단어 입력 오류");
		}
	}
}
