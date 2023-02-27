package S1_Member;

public class Board {
	private String title;
	private String contents;
	private String memberID;

	public Board() {
	}

	public Board(String title, String contents, String memberID) {
		super();
		setTitle(title);
		setContents(contents);
		setMemberID(memberID);
	}

	public String getTitle() {
		return title;
	}

	private void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	private void setContents(String contents) {
		this.contents = contents;
	}

	public String getMemberID() {
		return memberID;
	}

	private void setMemberID(String memberID) {
		this.memberID = memberID;
	}
}