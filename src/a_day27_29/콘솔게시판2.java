package a_day27_29;

import java.util.Scanner;

public class 콘솔게시판2 {

	public static void main(String[] args) {
		// 9:40~11:30
		Scanner sc = new Scanner(System.in);

		int count = 0; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		String[][] contents = new String[100][2];

		while (true) {
			pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
			startRow = (curPageNum - 1) * pageSize + 1;
			endRow = curPageNum * pageSize > count ? count : curPageNum * pageSize;
			System.out.println("=====================");
			System.out.printf("전체 게시글 (%d개)\n", count);
			for (int i = startRow; i <= endRow; i++) {
				System.out.println("(" + (i) + ") " + contents[i - 1][0]);
			}
			if (count == 0) {
				System.out.println("인덱스 (0~0) 페이지(0/0)");
			} else {
				System.out.printf("인덱스 (%d~%d) 페이지(%d/%d)\n", startRow, endRow, curPageNum, pageCount);
			}
			System.out.println("=====================");
			if (curPageNum > 1) {
				System.out.println("[1]이전페이지");
			}
			if (curPageNum < pageCount) {
				System.out.println("[2]다음페이지");
			}
			System.out.println("[3]추가하기\n[4]삭제하기\n[5]내용확인\n[6]종료");
			System.out.print("선택 >> ");
			int sel = sc.nextInt();

			if (sel < 1 || sel > 6) {
				System.err.println("입력오류: 1~6");
			} else if (sel == 6) {
				System.err.println("[종료]");
				break;
			} else if (sel == 1) {
				if (curPageNum <= 1) {
					System.err.println("첫번째 페이지입니다.");
					continue;
				}
				curPageNum--;
			} else if (sel == 2) {
				if (curPageNum >= pageCount) {
					System.err.println("마지막 페이지입니다.");
					continue;
				}
				curPageNum++;
			} else if (sel == 3) {
				System.out.print("게시물 제목 입력 : ");
				contents[count][0] = sc.next();
				System.out.print("게시물 내용 입력 : ");
				contents[count][1] = sc.next();
				System.out.println("[추가 완료]");
				System.out.println(" 제목: " + contents[count][0]);
				System.out.println(" 내용: " + contents[count][1]);
				count++;
			} else if (sel == 4) {
				System.out.print("게시글 번호 : ");
				int no = sc.nextInt();
				if (no < startRow || no > endRow) {
					System.err.println("게시글 번호 오류");
					continue;
				} else {
					for (int i = no - 1; i < count - 1; i++) {
						contents[i][0] = contents[i + 1][0];
						contents[i][1] = contents[i + 1][1];
					}
					contents[count - 1][0] = "";
					contents[count - 1][1] = "";
					count--;
					System.out.println("[삭제 완료]");
				}
			} else if (sel == 5) {
				System.out.print("게시글 번호 : ");
				int no = sc.nextInt();
				System.out.println("[제목] " + contents[no - 1][0]);
				System.out.println(" 내용: " + contents[no - 1][1]);
				continue;
			}
		}
		sc.close();
	}
}
