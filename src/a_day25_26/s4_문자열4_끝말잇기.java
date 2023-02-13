package a_day25_26;

import java.util.Scanner;

public class s4_문자열4_끝말잇기 {

	public static void main(String[] args) {
		// 15:55~
		Scanner sc=new Scanner(System.in);
		
		String start="자전거";
		while(true) {
			System.out.print("제시어 : "+start);
			System.out.println();
			
			char last=start.charAt(start.length()-1);
			
			System.out.print("입력 : ");
			String input=sc.next();
			
			if(input.equals("끝")) {
				System.out.println("게임종료");
				break;
			}
			if(input.length()==1) {
				System.err.println("한글자 단어 불가");
				continue;
			}
			if(input.equals(start)) {
				System.err.println("제시어와 동일 단어 불가");
				continue;
			}
			if(input.charAt(0)!=last) {
				System.err.println("첫 글자 다름");
				continue;
			}
			if(input.charAt(0)==input.charAt(input.length()-1)) {
				System.err.println("맨앞/맨뒤 같은글자 불가");
				continue;
			}
			start=input;
		}
	}
}
