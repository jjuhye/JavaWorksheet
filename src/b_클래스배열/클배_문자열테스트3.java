package b_클래스배열;

class Member {
	int no;
	int point;
	String name;
	boolean best;
}

public class 클배_문자열테스트3 {
//11:02~11:33
	public static void main(String[] args) {

		String data1 = "1001/3,1002/1,1001/3,1003/5,1004/1,1002/2";
		String data2 = "1001/이만수,1002/김철수,1003/신민아,1004/박상아";

		// data1 은 사원번호와 판매실적이다.
		// data2 는 사원번호와 이름이다.
		// 판매실적이 4이상인사원은 best를 true로 저장하세요.

		// 문제1) 위데이터를 참고해서 Member 클래스 배열을 완성후 전체출력해보세요.

		String temp1[] = data1.split(",");
		String tempR1[][] = new String[temp1.length][2];
		for (int i = 0; i < temp1.length; i++) {
			tempR1[i] = temp1[i].split("/");
		}
		String temp2[] = data2.split(",");
		Member[] memberList = new Member[temp2.length];
		for (int i = 0; i < temp2.length; i++) {
			String tempR2[] = temp2[i].split("/");
			Member mb = new Member();
			mb.no = Integer.parseInt(tempR2[0]);
			mb.name = tempR2[1];
			int sum = 0;
			for (int k = 0; k < tempR1.length; k++) {
				if (tempR2[0].equals(tempR1[k][0])) {
					sum += Integer.parseInt(tempR1[k][1]);
				}
			}
			mb.point = sum;
			if (sum >= 4) {
				mb.best = true;
			}
			memberList[i] = mb;
		}

		System.out.println("사원번호	판매실적	이름	Best");
		System.out.println("------------------------------");
		for (Member m : memberList) {
			System.out.println(m.no + "\t" + m.point + "\t" + m.name + "\t" + m.best);
		}

		// 문제2) 판매실적이 best 인회원 이름출력
		System.out.println("===============");
		System.out.println("Best 사원");
		System.out.println("---------------");
		for (Member m : memberList) {
			if (m.best == true) {
				System.out.println(m.name);
			}
		}
	}
}
