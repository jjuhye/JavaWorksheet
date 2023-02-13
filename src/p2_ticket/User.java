package p2_ticket;

public class User{
	String id;
	String pw;
	
	
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	boolean checkLog(String id , String pw) {
		if(this.id.equals(id) && this.pw.equals(pw)) {
			return true;
		}
		return false;
	}
}
