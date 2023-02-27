package S1_Member;

public class Member {
	private int memberNumber;
	private String memberID;
	private String memberPW;
	private String memberName;

	public Member() {
	}

	public Member(int memberNumber, String memberID, String memberPW, String memberName) {
		setMemberNumber(memberNumber);
		setMemberID(memberID);
		setMemberPW(memberPW);
		setMemberName(memberName);
	}

	public int getMemberNumber() {
		return memberNumber;
	}

	public String getMemberID() {
		return memberID;
	}

	public String getMemberPW() {
		return memberPW;
	}

	public String getMemberName() {
		return memberName;
	}

	private void setMemberNumber(int memberNumber) {
		this.memberNumber = memberNumber;
	}

	private void setMemberID(String memberID) {
		this.memberID = memberID;
	}

	private void setMemberPW(String memberPW) {
		this.memberPW = memberPW;
	}

	private void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String toString() {
		String print = String.format("[%-6d] [%10s] [%10s] [%10s]\n", memberNumber, memberID, memberPW, memberName);
		return print;
	}

}