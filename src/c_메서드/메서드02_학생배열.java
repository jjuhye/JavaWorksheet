package c_메서드;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class ScoreMng {

	Random rd = new Random();
	Scanner sc = new Scanner(System.in);
	int[] arr;
	int sum = 0;
	int cnt = 0;

	void answerQ1(int[] x) {
		for (int i = 0; i < x.length; i++) {
			x[i] = rd.nextInt(100) + 1;
			sum += x[i];
			if (x[i] >= 60) {
				cnt++;
			}
		}
		arr = x;
		System.out.println(Arrays.toString(arr));
	}

	void answerQ2() {
		System.out.printf("총점(%d) 평균(%.2f)\n", sum, (sum * 1.0) / arr.length);
	}

	void answerQ3() {
		System.out.printf("합격생 수 : %d명\n", cnt);
	}

	void answerQ4() {
		System.out.println("===============");
		System.out.print("인덱스 입력 : ");
		int idx = sc.nextInt();
		if (idx < 0 || idx >= arr.length) {
			System.err.println("[인덱스 범위 오류]");
		} else {
			System.out.println("성적 : " + arr[idx] + "점");
		}
	}

	void answerQ5() {
		System.out.println("===============");
		System.out.print("성적 입력 : ");
		int score = sc.nextInt();
		int idx = 0;
		boolean check = true;
		for (int a : arr) {
			if (score == a) {
				System.out.println("인덱스 : " + idx);
				check = false;
				break;
			}
			idx++;
		}
		if (check) {
			System.err.println("[성적 입력 오류]");
		}
	}

	void answerQ6(int[] x) {
		System.out.println("===============");
		System.out.print("학번 입력 : ");
		int hak = sc.nextInt();
		int idx = 0;
		boolean check = true;
		for (int i : x) {
			if (hak == i) {
				check = false;
				break;
			}
			idx++;
		}
		if (check) {
			System.err.println("[해당 학번은 존재하지 않습니다]");
		}else {
		System.out.println("점수 : " + arr[idx]);
		}
	}
//	void answerQ7() >> answerQ6에 포함

	void answerQ8(int[] x) {
		System.out.println("========================");
		int idx = 0;
		int max = 0;
		int maxIdx = -1;
		for (int a : arr) {
			if (max < a) {
				max = a;
				maxIdx = idx;
			}
			idx++;
		}
		System.out.printf("1등학생 : %d  점수 : %d점\n", x[maxIdx], max);
	}
}

public class 메서드02_학생배열 {
	public static void main(String[] args) {

		int[] hakbuns = { 1001, 1002, 1003, 1004, 1005 };
		int[] scores = new int[5];

		ScoreMng sm = new ScoreMng();

		// 문제1) scores배열에 1~100점 사이의 랜덤 정수를 5개 저장
		// 예 1) 87, 11, 92, 14, 47
		sm.answerQ1(scores);

		// 문제2) 전교생의 총점과 평균 출력
		// 예 2) 총점(251) 평균(50.2)
		sm.answerQ2();

		// 문제3) 성적이 60점 이상이면 합격. 합격생 수 출력
		// 예 3) 2명
		sm.answerQ3();

		// 문제4) 인덱스를 입력받아 성적 출력
		// 정답4) 인덱스 입력 : 1 성적 : 11점
		sm.answerQ4();

		// 문제5) 성적을 입력받아 인덱스 출력
		// 정답5) 성적 입력 : 11 인덱스 : 1
		sm.answerQ5();

		// 문제6) 학번을 입력받아 성적 출력
		sm.answerQ6(hakbuns);

		// 문제7) 학번을 입력받아 성적 출력
		// 단, 없는학번 입력 시 예외처리
		// 예 7)
		// 학번 입력 : 1002 성적 : 11점
		// 학번 입력 : 1000 해당학번은 존재하지 않습니다.
		// sm.answerQ7();

		// 문제8) 1등학생의 학번과 성적 출력
		sm.answerQ8(hakbuns);
	}
}
