package S1_Member;

import java.util.ArrayList;

public class BoardDAO {

	private ArrayList<Board> boardList;

	public BoardDAO() {
		boardList = new ArrayList<Board>();
	}

	public void addBoardList(Board board) {
		boardList.add(board);
	}

	public int getBoardSize() {
		return boardList.size();
	}

	// 게시판 목록 출력
	public String printBoard(int idx) {
		String title = trimTitle(boardList.get(idx).getTitle());
		String id = boardList.get(idx).getMemberID();
		String data = String.format("%2d) %-12s [%s]", idx + 1, title, id);
		return data;
	}

	// 8자리이상 제목 말줄임
	private String trimTitle(String title) {
		String trim = "...";
		int length = 8;
		if (title.length() > length) {
			title = title.substring(0, length);
			title += trim;
		}
		return title;
	}

	// 회원 게시글 추가
	public void addBoard(String title, String contents, String id) {
		Board board = new Board(title, contents, id);
		boardList.add(board);
		System.out.println("[게시글 작성 완료]");
	}

	// 관리자 답글 추가
	public void addReply(int idx, String contents) {
		String title = "└[Re] " + boardList.get(idx).getTitle();
		Board board = new Board(title, contents, "admin");
		boardList.add(idx + 1, board);
		System.out.println("[답글 작성 완료]");
	}

	// 게시글 삭제
	public void delBoard(int idx, String id) {
		if (boardList.get(idx).getMemberID().equals(id)) {
			boardList.remove(idx);
			System.out.println("[글 삭제 완료]");
			return;
		}
		System.err.println("삭제 권한이 없습니다");
	}

	// 게시글 내용 보기
	public void showContents(int idx, String id) {
		if (id.equals("admin") || boardList.get(idx).getMemberID().equals(id)) {
			System.out.println("========================");
			System.out.println("제목 : " + boardList.get(idx).getTitle());
			System.out.println("작성자 : " + id);
			System.out.println("내용 : " + boardList.get(idx).getContents());
			System.out.println("========================");
			return;
		}
		System.err.println("읽기 권한이 없습니다");
	}
}
