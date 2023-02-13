package b_클래스배열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

//class Student{
//int number;
//String id;
//String pw;
//String name="무명이";
//int score;
//}
//11:54~13:00
public class 클배02_학생컨트롤러1 {

	public static void main(String[] args) {

		int max = 10;
		Student[] stList = new Student[max];
		int cnt = 0; // 현재 생성한 학생 숫자
		int hak = 1001; // 시작 학번

		Scanner sc = new Scanner(System.in);
		Random rd = new Random();

		while (true) {
			System.out.println("================================================");
			System.out.println("[1]학생추가 [2]학생삭제 [3]수정 [4]검색 [5] 전체출력 [0]종료");
			System.out.print("선택 >> ");
			int sel = sc.nextInt();

			if (sel == 0) {
				System.out.println("[종료]");
				break;
			} else if (sel == 1) {
				if (cnt == max) {
					System.err.println("최대 학생수 초과");
					continue;
				} else {
					Student s = new Student();
					// 추가 (1001부터 자동학번생성/이름/아이디-중복금지/비번/점수:30~100 랜덤으로 입력)
					System.out.print("이름 : ");
					s.name = sc.next();
					System.out.print("ID : ");
					s.id = sc.next();
					boolean check = false;
					for (int i = 0; i < cnt; i++) {
						if (s.id.equals(stList[i].id)) {
							System.err.println("이미 존재하는 아이디");
							check = true;
							break;
						}
					}
					if (check) {
						continue;
					}
					System.out.print("PW : ");
					s.pw = sc.next();
					s.score = rd.nextInt(71) + 30;
					s.number = hak;
					stList[cnt] = s;
					cnt++;
					hak++;
				}
			} else if (sel == 2) {
				// 삭제 (아이디 검색으로 삭제)
				System.out.print("ID : ");
				String temp = sc.next();
				boolean check = true;
				for (int i = 0; i < cnt; i++) {
					if (temp.equals(stList[i].id)) {
						System.out.println("[삭제 완료]");
						for (int k = i; k < cnt - 1; k++) {
							stList[k] = stList[k + 1];
						}
						stList[cnt - 1] = new Student();
						check = false;
						cnt--;
						break;
					}
				}
				if (check) {
					System.err.println("해당 아이디가 없습니다");
					continue;
				}
			} else if (sel == 3) {
				// 수정 (학번으로 검색 => 점수 수정)
				System.out.print("학번 : ");
				int temp = sc.nextInt();
				boolean check = true;
				for (int i = 0; i < cnt; i++) {
					if (temp == stList[i].number) {
						System.out.println("현재점수 : " + stList[i].score);
						System.out.print("수정할 점수 입력 : ");
						stList[i].score = sc.nextInt();
						System.out.println("[" + stList[i].number + "] 점수 : " + stList[i].score);
						check = false;
						break;
					}
				}
				if (check) {
					System.err.println("해당 학번이 없습니다");
					continue;
				}
			} else if (sel == 4) {
				// 검색 (이름으로 검색-동명이인 경우포함, 학번&점수 출력)
				System.out.print("이름 : ");
				String temp = sc.next();
				boolean check = true;
				for (int i = 0; i < cnt; i++) {
					if (temp.equals(stList[i].name)) {
						System.out.println(temp + "의 학번 " + stList[i].number + " ==> " + stList[i].score);
						check = false;
					}
				}
				if (check) {
					System.err.println("해당 이름이 없습니다");
					continue;
				}
			} else if (sel == 5) {
//				for (int i = 0; i < cnt; i++) {
//					System.out.print("[" + stList[i].number + "] ");
//					System.out.print(stList[i].name + " / ");
//					System.out.print("id(" + stList[i].id + ") / ");
//					System.out.print("pw(" + stList[i].pw + ") / ");
//					System.out.print("점수(" + stList[i].score + ")\n");
//				}
				if (cnt > 0) {
					System.out.printf("%-10s %-10s %-10s %-10s %-10s \n", "학번", "이름", "id", "pw", "점수");
					for (Student s : stList) {
						if (s == null) {
							break;
						}
						System.out.printf("%-10d %-10s %-10s %-13s %-10d \n", s.number, s.name, s.id, s.pw, s.score);
					}
				}

			} else {
				System.err.println("입력오류 [0~5]");
			}
		}
//=================
		sc.close();
	}
}
