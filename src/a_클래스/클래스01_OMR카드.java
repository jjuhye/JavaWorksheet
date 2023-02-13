package a_클래스;

import java.util.Arrays;
import java.util.Random;

class OMR {
	int[] answer = {1, 3, 4, 2, 5};		// 시험답안
	int[] hgd = new int[5];				// 홍길동 학생답안	
	int cnt = 0;						// 정답 맞춘 개수
	int score = 0;						// 성적
}

public class 클래스01_OMR카드 {

	public static void main(String[] args) {
		Random rd=new Random();
		OMR card = new OMR();
		
		int idx=0;
		for(int a : card.answer) {
			card.hgd[idx]=rd.nextInt(5)+1;
			if(a==card.hgd[idx]) {
				card.score+=20;
			}
			idx++;
		}
		System.out.println("answer = "+Arrays.toString(card.answer));
		System.out.println("hgd    = "+Arrays.toString(card.hgd));
		System.out.println("성적 "+card.score+"점");
	}
}