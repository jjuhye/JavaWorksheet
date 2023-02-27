package S1_Member;

import S2_Item.ItemController;
import S4_Cart.CartController;
import S_Util.Util;

public class MemberController {
	private MemberController() {
	}

	private static MemberController instance = new MemberController();

	public static MemberController getInstance() {
		return instance;
	}

	private MemberDAO memDAO;
	private BoardDAO bdDAO;
	private ItemController itemCtrl;
	private CartController cartCtrl;
	public boolean logout;

	public void init() {
		itemCtrl = ItemController.getInstance();
		cartCtrl = CartController.getInstance();
		memDAO = new MemberDAO();
		bdDAO = new BoardDAO();
	}

	// 관리자 멤버리스트 추가
	public void addAdmintoMember(Member m) {
		memDAO.addMember(m);
	}

	// 회원가입
	public void memberJoin() {
		String id = Util.getString("아이디 입력");
		if (memDAO.checkId(id)) {
			System.err.println("이미 존재하는 아이디");
			return;
		}
		String pw = Util.getString("비밀번호 입력");
		String name = Util.getString("이름 입력");

		Member member = new Member(memDAO.nextMemberNo(), id, pw, name);
		memDAO.addMember(member);
		System.out.println("[" + id + "님 회원가입 완료]");
	}

	// 아이디 존재여부 확인
	public boolean isMember(String id) {
		if (memDAO.checkId(id)) {
			return true;
		}
		return false;
	}

	// 로그인,비밀번호 검증후 아이디 리턴
	public String memberLogin() {
		String id = Util.getString("아이디 입력");
		String pw = Util.getString("비밀번호 입력");
		if (memDAO.checkIDPW(id, pw)) {
			return id;
		}
		return null;
	}

	// 로그아웃, 로그인 아이디 초기화
	public void memberLogout() {
		logout = true;
	}

	// 회원 목록 출력
	public void printMember() {
		System.out.println("===== 회원 목록 =====");
		System.out.print(memDAO.memberData());
	}

	// 회원 이용 페이지 목록
	public void memberMenu(String id) {
		while (true) {
			System.out.println("<<< 회원 페이지 >>>");
			System.out.println("[1]쇼핑하기 [2]장바구니 [3]게시판 [0]로그아웃");
			int sel = Util.getValue("선택", 0, 3);
			if (sel == 0) {
				memberLogout();
				System.out.println("[로그아웃 완료]");
				return;
			} else if (sel == 1) {
				shopMenu(id);
			} else if (sel == 2) {
				cartCtrl.cartMember(id);
			} else if (sel == 3) {
				boardMenu(id);
			}
		}
	}

	// [1]쇼핑 메뉴
	public void shopMenu(String id) {
		while (true) {
			System.out.println("<<< 쇼핑 하기 >>>");
			itemCtrl.showItem();
			System.out.println("[1]장바구니 담기 [2]장바구니 보기 [0]뒤로가기");
			int sel = Util.getValue("선택", 0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				itemCtrl.addCart(id);
			} else if (sel == 2) {
				cartCtrl.cartMember(id);
			}
		}
	}

	// [3]게시판
	public void boardMenu(String id) {
		int count = 0; // 전체 게시글 수
		int pageSize = 5; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호
		while (true) {
			count = bdDAO.getBoardSize(); // 전체 게시글 수
			pageCount = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;
			startRow = (curPageNum - 1) * pageSize + 1;
			endRow = curPageNum * pageSize > count ? count : curPageNum * pageSize;
			System.out.println("\n<<<<<< 게시판 >>>>>>");
			if (bdDAO.getBoardSize() == 0) {
				System.out.println("[게시글이 없습니다]");
			} else {
				System.out.println("========================");
				System.out.printf("전체 게시글 (%d개)\n", count);
				System.out.println("------------------------");
				for (int i = startRow; i <= endRow; i++) {
					System.out.println(bdDAO.printBoard(i - 1));
				}
				System.out.println("------------------------");
				if (count == 0) {
					System.out.println("인덱스 (0~0) 페이지(0/0)");
				} else {
					System.out.printf("인덱스 (%d~%d) 페이지(%d/%d)\n", startRow, endRow, curPageNum, pageCount);
				}
				System.out.println("========================");
			}

			System.out.println("[1]게시글 작성");
			if (bdDAO.getBoardSize() != 0) {
				System.out.println("[2]게시글 삭제\n[3]게시글 확인");
				System.out.print("[4]이전페이지 [5]다음페이지 ");
			}
			System.out.println("[0]뒤로 가기");
			int sel = Util.getValue("선택", 0, 5);
			if (bdDAO.getBoardSize() == 0 && sel > 1) {
				System.err.println("입력오류 [0~1]");
				continue;
			}
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				// 게시글 작성
				String title = Util.getString("제목 입력");
				String contents = Util.getString("내용 입력");
				bdDAO.addBoard(title, contents, id);
			} else if (sel == 2) {
				// 게시글 삭제
				int idx = Util.getInt("게시글 번호");
				bdDAO.delBoard(idx - 1, id);
			} else if (sel == 3) {
				// 게시글 확인
				int idx = Util.getInt("게시글 번호");
				bdDAO.showContents(idx - 1, id);
				// 관리자로 게시글 확인시 답글 작성 메뉴 노출
				if (id.equals("admin")) {
					System.out.println("[1]답글 작성 [0]뒤로가기");
					int sel2 = Util.getValue("선택", 0, 1);
					if (sel2 == 0) {
						return;
					} else if (sel2 == 1) {
						String contents = Util.getString("내용 입력");
						bdDAO.addReply(idx - 1, contents);
					}
				}
			} else if (sel == 4) {
				if (curPageNum <= 1) {
					System.err.println("첫번째 페이지입니다.");
					continue;
				}
				curPageNum--;
			} else if (sel == 5) {
				if (curPageNum >= pageCount) {
					System.err.println("마지막 페이지입니다.");
					continue;
				}
				curPageNum++;
			}
		}
	}
}
