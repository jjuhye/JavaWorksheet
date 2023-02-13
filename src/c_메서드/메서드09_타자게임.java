package c_메서드;

//9:44~10:57
import java.util.Random;
import java.util.Scanner;

class WordGame {
	Random ran = new Random();
	String[] wordList = { "java", "spring", "jsp", "android", "php" };
	boolean[] checkList = new boolean[wordList.length];
	int count;

	int[] idx = new int[wordList.length];

	void reset() {
		for (int i = 0; i < idx.length; i++) {
			idx[i] = ran.nextInt(5);
			for (int k = 0; k < i; k++) {
				if (idx[i] == idx[k]) {
					i--;
					continue;
				}
			}
		}
	}

	String getWord(int count) {
		String word = wordList[idx[count]];
		return word;
	}

	void checkWord(String a) {
		if (a.equals(getWord(count))) {
			checkList[count] = true;
		} else {
			checkList[count] = false;
		}
	}

	boolean getGameEnd() {
		if (count >= wordList.length - 1) {
			return true;
		}
		return false;
	}

	void printGameEnd() {
		System.out.println("-------------------------------------");
		for (int i = 0; i < idx.length; i++) {
			System.out.printf("%-8s", wordList[idx[i]]);
		}
		System.out.println();
		for (int i = 0; i < idx.length; i++) {
			System.out.printf("%-8s", checkList[i]);
		}
		System.out.println();
		System.out.println("-------------[Game Over]-------------");
	}

}

public class 메서드09_타자게임 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		WordGame wg = new WordGame();

		while (true) {
			System.out.println("<<타자연습게임>>");
			System.out.println("1)게임  0)종료");
			int sel = scan.nextInt();
			if (sel == 1) {
				wg.reset();
				while (true) {
					System.out.println(wg.count + 1 + ") 단어를 맞춰보세요.");
					System.out.print(wg.getWord(wg.count) + " >> ");
					wg.checkWord(scan.next());
					if (wg.getGameEnd()) {
						wg.printGameEnd();
						break;
					}
					wg.count++;
				}
			} else if (sel == 0) {
				System.out.println("[게임 종료]");
				break;
			}
		}
		scan.close();
	}
}
