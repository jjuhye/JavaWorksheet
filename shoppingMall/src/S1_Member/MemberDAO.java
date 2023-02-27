package S1_Member;

import java.util.ArrayList;

public class MemberDAO {

	private ArrayList<Member> mbList;
	private int memberNo;

	public MemberDAO() {
		memberNo = 1000;
		mbList = new ArrayList<Member>();
	}

	public int nextMemberNo() {
		memberNo++;
		return memberNo;
	}

	// 회원추가
	public void addMember(Member member) {
		mbList.add(member);
	}

	// 멤버리스트에서 아이디 존재 확인
	public boolean checkId(String id) {
		for (int i = 0; i < mbList.size(); i++) {
			if (id.equals(mbList.get(i).getMemberID())) {
				return true;
			}
		}
		return false;
	}

	// 로그인을 위한 ID & PW 검증
	public boolean checkIDPW(String id, String pw) {
		for (int i = 0; i < mbList.size(); i++) {
			if (id.equals(mbList.get(i).getMemberID()) && pw.equals(mbList.get(i).getMemberPW())) {
				return true;
			}
		}
		return false;
	}

	// 회원 목록 데이터
	public String memberData() {
		if (mbList.size() == 0) {
			return "[회원 데이터 없음]";
		}
		String data = "";
		for (Member m : mbList) {
			data += m.toString();
		}
		return data;
	}
}
