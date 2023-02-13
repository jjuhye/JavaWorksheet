package b_클래스배열;

import java.util.Random;

class RanNum {
	int num;
	boolean check;
}

class RanNumManager {
	RanNum[] arr = new RanNum[5];

	void init() {
		int idx = 0;
		for (RanNum a : arr) {
			a = new RanNum();
			arr[idx] = a;
			idx++;
		}
		for (RanNum a : arr) {
			a.num = creatNum();
		}
	}

	// 랜덤 숫자 생성
	int creatNum() {
		while (true) {
			Random rd = new Random();
			int no = rd.nextInt(arr.length);
			if (isSame(no)) {
				continue;
			} else {
				arr[no].check = true;
				return no;
			}
		}
	}

	// 중복체크
	boolean isSame(int n) {
		if (arr[n].check == true) {
			return true;
		}
		return false;
	}

	// 랜덤 숫자 출력
	void printNum() {
		for (RanNum r : arr)
			System.out.print(r.num + " ");
	}

	void run() {
		init();
		printNum();
	}
}

public class 클배06_중복숫자 {

	public static void main(String[] args) {

		RanNumManager rg = new RanNumManager();
		rg.run();

	}

}
