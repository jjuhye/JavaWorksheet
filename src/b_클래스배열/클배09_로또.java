package b_클래스배열;

import java.util.Arrays;
import java.util.Random;

//17:00~17:44
class Lotto {
	int[] data = new int[8]; // 00303033 꽝 00300333 당첨
	boolean win = false;

	void print() {
		for (int i = 0; i < 8; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}

class LottoDAO {
	Lotto[] set;
	int winner;
	// 로또 5개 생성 하되 딱 1개만 로또 당첨

	void init() {
		set = new Lotto[5];
		for (int i = 0; i < set.length; i++) {
			set[i] = new Lotto();
		}
	}

	void makeWinner() {
		Random rd = new Random();
		winner = rd.nextInt(set.length) + 1;
	}

	void printLotto() {
		System.out.println("1등 복권 : [" + winner + "]");
		System.out.println("==================");
		for (int i = 0; i < set.length; i++) {
			System.out.print("[" + (i + 1) + "] ");
			for (int k = 0; k < set[i].data.length; k++) {
				System.out.print(set[i].data[k]);
			}
			System.out.println(set[i].win == true ? "   당첨" : "   꽝");
			System.out.println("------------------");
		}
	}

	int[] makeLotto() {
		Random rd = new Random();
		int arr[] = new int[8];
		for (int k = 0; k < arr.length;) {
			arr[k] = rd.nextInt(arr.length);
			if (arr[k] != 0 && arr[k] != 3) {
				continue;
			}
			k++;
		}
		return arr;
	}

	void setLotto() {
		for (int i = 0; i < set.length;) {
			int[] arr = makeLotto();
			if (i + 1 == winner) {
				if (!checkLotto(arr)) {
					continue;
				}
				set[i].data = arr;
				set[i].win = true;
				i++;
			} else {
				if (checkLotto(arr)) {
					continue;
				}
				set[i].data = arr;
				i++;
			}
		}
	}

	boolean checkLotto(int[] arr) {
		int cnt = 0;
		for (int a : arr) {
			if (a == 3) {
				cnt++;
			} else {
				cnt = 0;
			}
			if (cnt >= 3) {
				return true;
			}
		}
		return false;
	}

	void run() {
		init();
		makeWinner();
		setLotto();
		printLotto();
	}
}

public class 클배09_로또 {

	public static void main(String[] args) {

		LottoDAO lt = new LottoDAO();
		lt.run();
	}
}
