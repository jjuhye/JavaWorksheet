package test;

import java.util.Iterator;

public class �����ǵ���_1130 {

	public static void main(String[] args) {
		//[����] 10�� 28�ϳ� ���� ������ �츮 ���� 11�� 30�� ���� �� ���� �ϼ��� ���Ͻÿ�
		
		int months[] =
	                { 31, 28, 31, 30,
	                  31, 30, 31, 31,
	                  30, 31, 30, 31 };

		int startMonth = 10;
		int startDay = 28;
		int endMonth = 11;
		int endDay = 30;
		String weeks[] = { "��", "ȭ", "��", "��", "��", "��", "��" };
		int week = 4; // ���ۿ���
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
//		System.out.println("���� "+dday+"��");
//		System.out.println(endMonth+"�� "+endDay+"�� "+weeks[week]+"����");
//		System.out.println("���� "+cnt+"��");
		
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

		System.out.println("���� " + cnt);
		System.out.println(endMonth + "�� " + endDay + "�� " + weeks[week] + "����");
		System.out.println("����" + weekDay);
		
	}
}
