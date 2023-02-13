package p2_movie;

import java.util.Scanner;

public class UserDAO {
	Scanner scan= new Scanner(System.in);
	
	User[] userList; 
	int userCount;
	
	void init() {
		String userData = "qwer/1234,asdf/4321";
		String[] userTokens = userData.split(",");
		userCount = userTokens.length;
		userList = new User[userCount];
		for(int i = 0; i < userList.length; i++) {
			userList[i] = new User();
			String[] userTokens2 = userTokens[i].split("/");
			userList[i].setData(userTokens2[0], userTokens2[1]);
		}
		printUserList();
	}
	
	void printUserList() {
		for(int i = 0; i < userCount; i++) {
			System.out.println(userList[i].id + " " + userList[i].pw);
		}
	}
	
	String checkLog(String id , String pw) {
		for(int i = 0; i < userCount; i++) {
			if(userList[i].checkLog(id, pw)) {				
				return id;
			}
		}	
		return null;
	}	

	String loginCheck() {
		System.out.println("아이디 입력 : ");
		String id = scan.next();
		System.out.println("비밀번호 입력 : ");
		String pw = scan.next();
		
		String log = checkLog(id, pw);
		if(log == null) {
			System.out.println("[로그인 실패]");
			return null;
		}else {
			System.out.println(log + " 로그인 성공");
			return log;
		}		
	}
	
}
