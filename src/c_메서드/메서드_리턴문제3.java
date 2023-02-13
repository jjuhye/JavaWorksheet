package c_메서드;

import java.util.Arrays;

class Return3 {

	String[][] run(String[][] data1, String[][] data2) {

		String[][] result = new String[data1.length][8];

		int idx = 0;
		for (String[] st : data1) {
			result[idx][0] = st[2];
			result[idx][1] = st[0];
			result[idx][2] = st[1];
			int cnt = 0;
			int sum = 0;
			for (int i = 0; i < data2.length; i++) {
				if (st[2].equals(data2[i][0])) {
					result[idx][cnt + 3] = data2[i][2];
					sum += Integer.parseInt(data2[i][2]);
					cnt++;
				}
			}
			result[idx][6] = sum + "";
			double avg = Math.round(sum / (cnt * 1.0) * 100) / 100.0;
			result[idx][7] = avg + "";
			idx++;
		}
		return result;
	}
}

public class 메서드_리턴문제3 {

	public static void main(String[] args) {

		Return3 re = new Return3();

		String[][] student = { { "김철만", "신촌", "1001" }, { "오상덕", "강남", "1002" }, { "민철이", "대치", "1003" },
				{ "유재석", "강동", "1004" } };
		String[][] score = { { "1001", "국어", "20" }, { "1002", "국어", "50" }, { "1003", "국어", "60" },
				{ "1004", "국어", "17" }, { "1001", "수학", "65" }, { "1002", "수학", "15" }, { "1003", "수학", "80" },
				{ "1004", "수학", "70" }, { "1001", "영어", "43" }, { "1002", "영어", "90" }, { "1003", "영어", "30" },
				{ "1004", "영어", "70" } };

		String[][] result = re.run(student, score);

		System.out.println("[학생번호| 이름 |지역 |국어|수학|영어| 총합 | 평균 ]");
		System.out.println("----------------------------------------");
		for (String[] r : result) {
			System.out.println(Arrays.toString(r));
		}
	}
}