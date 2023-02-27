package test;

import java.util.Iterator;

public class 오늘의도전_1130 {

	public static void main(String[] args) {
		//[문제] 10월 28일날 부터 시작한 우리 수업 11월 30일 까지 총 수업 일수를 구하시오
		
		int months[] =
	                { 31, 28, 31, 30,
	                  31, 30, 31, 31,
	                  30, 31, 30, 31 };

		int startMonth = 10;
		int startDay = 28;
		int endMonth = 11;
		int endDay = 30;
		String weeks[] = { "월", "화", "수", "목", "금", "토", "일" };
		int week = 4; // 시작요일
		int dday = 1;
		int cnt = 0;
//
//		for (int i = startMonth-1; i < endMonth - 1; i++) {
//				dday+= months[i];
//		}
//		dday -= startDay;
//		dday += endDay;
//		
//		for (int i = 0; i < dday; i++) {
//				if((i+week)%7>=0 && (i+week)%7<5) {
//					cnt++;
//				}
//				if(i==dday-1) {
//					week=(i+week)%7;
//				}
//		}
//		System.out.println("디데이 "+dday+"일");
//		System.out.println(endMonth+"월 "+endDay+"일 "+weeks[week]+"요일");
//		System.out.println("평일 "+cnt+"일");
		
		int weekDay = 0;

		for (int i = startMonth - 1; i < endMonth; i++) {
			for (int k = startDay; k <= months[i]; k++) {
				cnt++;
				if (!(week == 5 || week == 6)) {
					weekDay++;
				}

				week++;
				if (week == 7) {
					week = 0;
				}
				if (endMonth - 1 == i && endDay == k) {
					break;
				}
			}
			startDay = 1;
		}

		System.out.println("디데이 " + cnt);
		System.out.println(endMonth + "월 " + endDay + "일 " + weeks[week] + "요일");
		System.out.println("평일" + weekDay);
		
	}
}
