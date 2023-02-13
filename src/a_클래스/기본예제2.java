package a_클래스;

import java.util.Scanner;

// 기본메모리그림3 에 있는 sample03 클래스를 이용하세요 
//class Sample03 {
//	int[] hakbun = {1001, 1002, 1003, 1004, 1005};
//	int[] score  = {  92,   38,   87,  100,   11};
//}

public class 기본예제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Sample03 sample = new Sample03();
		
		// 문제2) 전교생의 총점과 평균 출력

		int sum=0;
		for(int s : sample.score) {
			sum+=s;
		}
		double avg=(sum*1.0)/sample.score.length;
		System.out.printf("총점(%d) 평균(%.2f)\n", sum,avg);
		
		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		int cnt=0;
		for(int s : sample.score) {
			if(s>=60) {
				System.out.println(s);
				cnt++;
			}
		}
		System.out.println("합격생 : "+cnt+"명");

		// 문제4) 인덱스를 입력받아 성적 출력
		System.out.print("인덱스 입력 : ");
		int idx=sc.nextInt();
		for(int i=0; i<sample.score.length; i++) {
			if(idx==i) {
				System.out.println("성적 : "+sample.score[i]+"점");
			}
		}
		
		// 문제5) 성적을 입력받아 인덱스 출력
		System.out.print("성적 입력 : ");
		int score=sc.nextInt();
		for(int i=0; i<sample.score.length; i++) {
			if(sample.score[i]==score) {
				System.out.println("인덱스 : "+i);
			}
		}
		
		// 문제6) 학번을 입력받아 성적 출력
		System.out.print("학번 입력 : ");
		int hak=sc.nextInt();
		for(int i=0; i<sample.hakbun.length; i++) {
			if(sample.hakbun[i]==hak) {
				System.out.println("성적 : "+sample.score[i]+"점");
			}
		}
		
		// 문제7) 학번을 입력받아 성적 출력
		System.out.print("학번 입력 : ");
		hak=sc.nextInt();
		boolean check=true;
		for(int i=0; i<sample.hakbun.length; i++) {
			if(sample.hakbun[i]==hak) {
				check=false;
				System.out.println("성적 : "+sample.score[i]+"점");
			}
		}
		if(check) {
			System.err.println("해당 학번은 존재하지 않습니다.");
		}
		
		// 문제8) 1등학생의 학번과 성적 출력
		int max=sample.score[0];
		idx=0;
		for(int i=0; i<sample.score.length; i++) {
			if(sample.score[i]>max) {
				max=sample.score[i];
				idx=i;
			}
		}
		System.out.println("1등학생 : "+sample.hakbun[idx]+"번("+max+"점)");
		
	}
}