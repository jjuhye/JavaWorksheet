package p2_ticket;

public class Seat {
	String userID;
	int number;
	boolean check;
	
	public Seat(String userID, int number, boolean check) {
		super();
		this.userID = userID;
		this.number = number;
		this.check = check;
	}
	
	void showNum(int number) {
		System.out.print("["+number+"]");
	}

	void showData(boolean check) {
		
		if(check == true) {
			System.out.print(" ■ ");
		}
		else {
			System.out.print(" □ ");
		}
	}	
}
