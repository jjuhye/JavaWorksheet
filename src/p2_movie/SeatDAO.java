package p2_movie;
import java.util.Scanner;
import java.util.Scanner;
public class SeatDAO {
	Scanner scan;
	Seat[] seatList;
	int max;
	void init() {
		max = 8;
		scan = new Scanner(System.in);
		seatList = new Seat[max];
		for (int i = 0; i < seatList.length; i++) {
			seatList[i] = new Seat("",i+1 ,false);
		
		}
	}

	String getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.next();
	}
	
	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		int num = sc.nextInt();
		if(num < start || num >end) {
			System.out.printf("[%d ~ %d 사이 값 입력] \n" , start, end);
			return -1;
		}
		return num;
	}

	void printSeat() {
		for (Seat seat : seatList) {
			System.out.print(seat.number+" ");
		}
		System.out.println();

		for (Seat seat : seatList) {
			seat.showData();
		}
		System.out.println();
	}

	void orderTicket(String id) {
		printSeat();
		int sel = getValue("[예매] 번호를 입력 : ", 1 , max);
		if(sel == -1) {
			return;
		}
		sel -= 1;
		if(seatList[sel].check == false) {
			seatList[sel].userID = id;
			seatList[sel].check = true;
			System.out.println("[예매 완료]");
			printSeat();
		}else {
			System.out.println("[이미 예매 완료된 좌석]");
		}
		
	}
	
	void cancelTicket(String id) {
		int cnt = checkTicket(id);
		if(cnt == 0) {
			return;
		}
		int num =  getValue("[취소] 취소할 좌석 번호 : ", 1 , max);
		if(num == -1) {
			return;
		}
		num--;
		if(seatList[num].check&&seatList[num].userID.equals(id)) {
			seatList[num].check = false;
			seatList[num].userID="";
			System.out.println("[좌석 예매 취소 완료]");
		}else{
			System.out.println("[취소할 좌석 번호를 확인해주세요]");
		}

	}
	int checkTicket(String id) {
		System.out.println( id +"님의 예매 좌석 목록 ");
		int cnt =0;
		for(Seat seat : seatList) {
			if(seat.check&& seat.userID == id ) {
				System.out.println("좌석번호 "+ seat.number);
				cnt++;
			}
		}
		if(cnt == 0) {
			System.out.println("[ 예매하신 좌석이 없습니다 ]");
		}
		return cnt;
	}
	
	
	
	
	
}
