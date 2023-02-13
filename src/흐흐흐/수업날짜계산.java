package 흐흐흐;

public class 수업날짜계산 {

	public static void main(String[] args) {

		// [문제] 10월 28일부터 시작한 우리 수업 11월 30일 까지 총 수업 일수

		int months[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

		int startMonth = 10;
		int startDay = 28;
		int endMonth = 12;
		int endDay = 28;
		String weeks[] = { "월", "화", "수", "목", "금", "토", "일" };
		int week = 4; // 시작요일
		int dday = 1;
		int cnt = 0;

		for (int i = startMonth - 1; i < endMonth - 1; i++) {
			dday += months[i];
		}
		dday -= startDay;
		dday += endDay; // 디데이

		for (int i = 0; i < dday; i++) {
			if ((i + week) % 7 >= 0 && (i + week) % 7 < 5) {
				cnt++; // 평일 계산
			}
			if (i == dday - 1) {
				week = (i + week) % 7; // 마지막날 요일
			}
		}
		System.out.println("디데이 " + dday + "일");
		System.out.println(endMonth + "월 " + endDay + "일 " + weeks[week] + "요일");
		System.out.println("평일 " + cnt + "일");
	}
}
