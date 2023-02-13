package p2_movie;
public class User{
	String id;
	String pw;
	void setData(String id , String pw) {
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