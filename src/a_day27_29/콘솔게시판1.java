package a_day27_29;

import java.util.Scanner;

public class 콘솔게시판1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int count = 14; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 1; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호
		
		pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;

		while (true) {
			startRow = curPageNum * pageSize - (pageSize - 1);
			endRow = curPageNum * pageSize > count? count : curPageNum * pageSize;
			
			System.out.println("전체 게시글 : " + count);
			System.out.printf("(인덱스 %d~%d) 페이지(%d/%d)\n", startRow, endRow, curPageNum, pageCount);
			System.out.println("게시글 번호");
			for (int i = startRow; i <= endRow; i++) {
				System.out.println("(" + (i) + ") ");
			}
			if (curPageNum != 1) {
				System.out.println("[이전 1]");
			}
			if (curPageNum != pageCount) {
				System.out.println("[이후 2]");
			}
			System.out.print("선택 >> ");
			int sel = sc.nextInt();

			if (curPageNum == 1 && sel == 1 || curPageNum == pageCount && sel == 2 || sel < 1 || sel > 2) {
				System.err.println("입력오류");
			} else if (sel == 1) {
				curPageNum--;
			} else if (sel == 2) {
				curPageNum++;
			}
			break;
		}
		sc.close();
	}
}
