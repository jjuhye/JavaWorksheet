package b_클래스배열;

//16:00~17:37
import java.util.Random;
import java.util.Scanner;

class Word {
	String word;
	int ranPos;

	void setRandomWordPos(String sample, int rIdx) {
		word = sample;
		ranPos = rIdx;
	}

	void printWord() {
		for (int i = 0; i < word.length(); i++) {
			if (i == ranPos) {
				System.out.print("*");
			} else {
				System.out.print(word.charAt(i));
			}
		}
		System.out.println();
	}
}

class WordSample {
	Random ran = new Random();
	long beforeTime;
	boolean[] checkList;
	int size;
	Word[] list;

	void init() {
		String[] wordList = { "java", "jsp", "python", "android", "spring" };
		size = wordList.length;
		list = new Word[size];
		checkList = new boolean[size];
		for (int i = 0; i < size; i++) {
			list[i] = new Word();
			list[i].setRandomWordPos(wordList[i], ran.nextInt(wordList[i].length()));
		}
	}

	String getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.print(msg + " >> ");
		String input = sc.next();
		return input;
	}

	Word getRanWord() {
		while (true) {
			int idx = ran.nextInt(size);
			if (checkList[idx] == true) {
				continue;
			}
			checkList[idx] = true;
			return list[idx];
		}
	}

	boolean getWord(Word word) {
		word.printWord();
		while (true) {
			String answer = getValue("입력");
			if (answer.equals(word.word)) {
				return true;
			}
			continue;
		}
	}

	void run() {
		beforeTime = System.currentTimeMillis();
		init();
		for (int i = 0; i < size; i++) {
			System.out.print((i + 1) + "번째 단어 : ");
			getWord(getRanWord());
		}
		long endTime = System.currentTimeMillis();
		System.out.println("[게임 종료]");
		System.out.printf("풀이시간 : %.2f초", (endTime - beforeTime) / 1000.0);
	}
}

public class 클배11_타자게임 {

	public static void main(String[] args) {

		WordSample wd = new WordSample();
		wd.run();

	}
}
