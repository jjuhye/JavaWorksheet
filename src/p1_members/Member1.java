package p1_members;
//Member.java (VO클래스는 보통 DB테이블 이름으로한다)

public class Member1 {
	String id;
	String pw;
	String name;

	void printMember() {
		System.out.println(id + " : " + pw + " : " + name);
	}
}
