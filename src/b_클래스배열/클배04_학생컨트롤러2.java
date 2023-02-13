package b_클래스배열;

import java.util.Arrays;
import java.util.Scanner;

public class 클배04_학생컨트롤러2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String studentSample = "1001/이만수\n";
		studentSample += "1002/김철만\n";
		studentSample += "1003/오수정\n";

		String subjectSample = "";
		subjectSample += "1001/국어/10/0\n";
		subjectSample += "1001/수학/32/0\n";
		subjectSample += "1002/국어/23/0\n";
		subjectSample += "1002/수학/35/0\n";
		subjectSample += "1002/영어/46/0\n";
		subjectSample += "1003/수학/60/0\n";
		subjectSample += "1003/영어/100/0";

		String[] temp = studentSample.split("\n");
		Student[] stList = new Student[temp.length];

		int idx = 0;
		for (Student s : stList) {
			String[] data = temp[idx].split("/");
			s = new Student();
			s.number = Integer.parseInt(data[0]);
			s.name = data[1];
			stList[idx] = s;
			idx++;
		}

		temp = subjectSample.split("\n");
		Subject[] sjList = new Subject[temp.length];

		idx = 0;
		for (Subject sj : sjList) {
			String[] data = temp[idx].split("/");
			sj = new Subject();
			sj.stuNum = Integer.parseInt(data[0]);
			sj.name = data[1];
			sj.score = Integer.parseInt(data[2]);
			sj.rank = Integer.parseInt(data[3]);
			sjList[idx] = sj;
			idx++;
		}

		String sumList[][]=new String[stList.length][4];

		while (true) {
			System.out.println("[0] 종료 ");
			System.out.println("[1] 학생 정보 출력 ");
			System.out.println("[2] 과목 정보 출력 ");
			System.out.println("[3] 과목별 랭킹 저장 ");
			System.out.println("[4] 과목별 랭킹 + 이름 출력");
			System.out.println("[5] 과목별 랭킹 1등의 이름 과목 점수 출력 ");
			System.out.println("[6] 학생별 점수 순으로 학생 재정렬 (평균 출력) ");

			int sel = sc.nextInt();
			if (sel == 0) {
				System.out.println("[종료]");
				break;
			} else if (sel == 1) {
				System.out.printf("%-10s %-10s %-10s\n", "학번", "이름", "총점");
				System.out.println("------------------------------------");
				idx=0;
				for (Student s : stList) {
					int cnt=0;
					int sum = 0;
					for (Subject sj : sjList) {
						if (s.number == sj.stuNum) {
							sum += sj.score;
							cnt++;
						}
					}
					double avg=sum/(cnt*1.0);
					System.out.printf("%-10d %-10s %-10d\n", s.number, s.name, sum);
					sumList[idx][0]=s.number+"";
					sumList[idx][1]=s.name;
					sumList[idx][2]=sum+"";
					sumList[idx][3]=avg+"";
					idx++;
				}
				System.out.println("------------------------------------");
			} else if (sel == 2) {
				System.out.printf("%-10s%-10s%-10s%-10s\n", "학번", "과목", "점수", "랭킹");
				System.out.println("------------------------------------");
				for (Subject sj : sjList) {
					System.out.printf("%-10d %-10s %-10d %-10d\n", sj.stuNum, sj.name, sj.score, sj.rank);
				}
				System.out.println("------------------------------------");
			} else if (sel == 3) {
				for (int i = 0; i < sjList.length; i++) {
					for (int k = i; k < sjList.length; k++) {
						if(sjList[i].name.equals(sjList[k].name)) {
							if(sjList[i].score<sjList[k].score) {
								sjList[i].rank++;
								continue;
							}
							sjList[i].rank=1;
						}
					}
				}
				System.out.println("[랭킹 등록 완료]--------------------");
			} else if (sel == 4) {
				System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "학번", "과목", "점수", "랭킹", "이름");
				System.out.println("------------------------------------------------");
				for (Subject sj : sjList) {
					System.out.printf("%-10d %-10s %-10d %-10d", sj.stuNum, sj.name, sj.score, sj.rank);
					for (Student st : stList) {
						if (st.number == sj.stuNum) {
							System.out.printf("%-10s\n", st.name);
						}
					}
				}
				System.out.println("------------------------------------------------");
			} else if (sel == 5) {
				System.out.printf("%-10s%-10s%-10s%-10s%-10s\n", "학번", "과목", "점수", "랭킹", "이름");
				System.out.println("------------------------------------------------");
				for (Subject sj : sjList) {
					if (sj.rank == 1) {
						System.out.printf("%-10d %-10s %-10d %-10d", sj.stuNum, sj.name, sj.score, sj.rank);
						for (Student st : stList) {
							if (st.number == sj.stuNum) {
								System.out.printf("%-10s\n", st.name);
							}
						}
					}
				}
				System.out.println("------------------------------------------------");
			} else if (sel == 6) {
				System.out.printf("%-10s %-10s %-10s %-10s\n", "학번", "이름", "총점", "평균");
				System.out.println("---------------------------------------");

				int[][] tempS = new int[stList.length][3];
				for (int i = 0; i < stList.length; i++) {
					int sum = 0;
					int cnt = 0;
					tempS[i][0] = i;
					for (Subject sj : sjList) {
						if (stList[i].number == sj.stuNum) {
							sum += sj.score;
							cnt++;
						}
					}
					tempS[i][1] = sum;
					tempS[i][2] = cnt;
				}
				for (int i = 0; i < tempS.length; i++) {
					for (int k = i + 1; k < tempS.length; k++) {
						if (tempS[k][1] > tempS[i][1]) {
							int maxIdx = tempS[k][0];
							int max = tempS[k][1];
							int cnt = tempS[k][2];
							tempS[k][0] = tempS[i][0];
							tempS[k][1] = tempS[i][1];
							tempS[k][2] = tempS[i][2];
							tempS[i][0] = maxIdx;
							tempS[i][1] = max;
							tempS[i][2] = cnt;
						}
					}
				}
				Student[] tempSt = new Student[stList.length];
				for (int i = 0; i < tempSt.length; i++) {
					tempSt[i] = new Student();
					tempSt[i].number = stList[tempS[i][0]].number;
					tempSt[i].name = stList[tempS[i][0]].name;
				}
				for (int i = 0; i < tempSt.length; i++) {
					stList[i].number = tempSt[i].number;
					stList[i].name = tempSt[i].name;
				}
				for (int i = 0; i < stList.length; i++) {
					System.out.printf("%-10d %-10s ", stList[i].number, stList[i].name);
					System.out.printf("%-10d%.2f\n", tempS[i][1], tempS[i][1] / (tempS[i][2] * 1.0));
				}
//				System.out.printf("%-10d %-10s %-10d %.2f\n", s.number, s.name, sum, avg);
				System.out.println("---------------------------------------");

			} else {
				System.err.println("입력오류 [0~6]");
			}

		}
		sc.close();
	}
}
