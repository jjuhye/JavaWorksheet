package p2_movie;


public class Seat {
	String userID;
	int number;
	boolean check;
	
	void showNum() {
		System.out.print(number + " ");
	}
	void showData() {
		
		if(check == true) {
			System.out.print("■ ");
		}
		else {
			System.out.print("□ ");
		}
	}
	public Seat(String userID, int number, boolean check) {
		super();
		this.userID = userID;
		this.number = number;
		this.check = check;
	}	
}
