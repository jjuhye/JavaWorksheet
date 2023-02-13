package p3_멤버저장;

public class Member {
	
	String id;
	int num;
	
	public Member(String id, int num) {
		super();
		this.id = id;
		this.num = num;
	}
	
	
	@Override
	public String toString() {
		return "num : " + num + ", id : " + id;
	}
	
}
