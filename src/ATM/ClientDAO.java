package ATM;

import java.util.ArrayList;

public class ClientDAO {
	
	private Util u=new Util();
	private File fl=new File();
	private Client cl;
	private int num=1001;
	static ArrayList<Client> clientList=new ArrayList<Client>();
	int log=-1;
	
	void dataSetting(String data) {
		String temp[]=data.split("\n");
		for(String t : temp) {
			String temp2[]=t.split("/");
			cl=new Client(num, temp2[0], temp2[1], temp2[2]);
			clientList.add(cl);
			num++;
		}
	}

	private String checkId() {
		String id = u.getString("아이디");
		int idx = checkIdx(id);
		if (idx == -1) {
			System.err.println("존재하지 않는 아이디");
			return "";
		}
		return id;
	}
	
	private int checkIdx(String id) {
		int idx=0;
		for(Client c : clientList) {
			if(c.id.equals(id)) {
				return idx;
			}
			idx++;
		}
		return -1;
	}
	
	// 관리자[1] 회원목록
	void showMember() {
		System.out.println("=============================");
		System.out.println(" No\t  id\t pw\tname");
		System.out.println("-----------------------------");
		for(Client c : clientList) {
			System.out.println(c.toString());
		}
		System.out.println("=============================");
	}
	
	// 관리자[2] 회원정보 수정
	void modifyMember() {
		int idx=checkIdx(checkId());
		if(idx==-1) {
			return;
		}
		System.out.println("[1] 비밀번호 수정");
		System.out.println("[2] 이름 수정");
		int sel = u.getValue("", 1, 2);
		if (sel == 1) {
			modifyPw(idx);
		} else if (sel == 2) {
			modifyName(idx);
		}
	}
	
	private void modifyPw(int idx) {
		String pw=u.getString("변경할 비밀번호");
		clientList.get(idx).pw=pw;
		System.out.println("[비밀번호 변경완료]");
	}
	private void modifyName(int idx) {
		String name=u.getString("변경할 이름");
		clientList.get(idx).name=name;
		System.out.println("[이름 변경완료]");
	}
	
	// 관리자[3] 회원정보 삭제
	void deleteMember() {
		int idx=checkIdx(checkId());
		if(idx==-1) {
			return;
		}
		clientList.remove(idx);
		System.out.println("[회원정보 삭제완료]");
	}
	
	// 관리자[4] 회원정보 저장
	void saveData() {
		fl.save(clientData(),fl.clientFileName);
		fl.save(accountData(),fl.accountFileName);
	}
	
	private String clientData() {
		String data = "=============================\n";
		data += " 회원번호\t  ID\t PW\tname\n";
		data += "=============================\n";
		for (Client c : clientList) {
			data += c.toString()+"\n";
		}
		data += "=============================\n";
		return data;
	}
	
	private String accountData() {
		ArrayList<Account> accountList = AccountDAO.accountList;
		String data = "================================\n";
		data += "회원번호\t      계좌번호       잔액\n";
		data += "================================\n";
		for (Account a : accountList) {
			data += a.toString()+"\n";
		}
		data += "================================\n";
		return data;
	}
	
	// 관리자[5] 회원정보 불러오기
	void readData() {
		System.out.println(fl.open(fl.clientFileName));
		System.out.println(fl.open(fl.accountFileName));
	}
	
	// 사용자[1] 회원가입
	void join() {
		String id=u.getString("가입 아이디");
		if(checkIdx(id)!=-1) {
			System.err.println("이미 존재하는 아이디");
			return;
		}else {
			String pw=u.getString("비밀번호");
			String name=u.getString("이름");
			cl=new Client(num, id, pw, name);
			clientList.add(cl);
			System.out.println("["+name+"님 회원가입 완료]");
			num++;
		}
	}
	
	// 사용자[2] 로그인
	boolean login() {
		int idx=checkIdx(checkId());
		if(idx==-1) {
			return false;
		}
		String pw=u.getString("비밀번호");
		if(!pw.equals(clientList.get(idx).pw)){
			System.err.println("비밀번호가 틀립니다");
			return false;
		}
		System.out.println("["+clientList.get(idx).name+"님 로그인 성공]");
		log=idx;
		return true;
	}
	
	// 로그인사용자[6] 탈퇴  
	void quitMember() {
		String pw=u.getString("비밀번호");
		if(pw.equals(clientList.get(log).pw)){
			clientList.remove(log);
			log=-1;
			System.out.println("[회원탈퇴 완료]");
			return;
		}
		System.err.println("비밀번호가 틀립니다");
	}
	
	// 로그인사용자[7] 마이페이지  (전체 계좌, 금액 (회원정보: 비밀번호 수정))
	void myPage() {
		System.out.println("[마이페이지]");
		System.out.println("[1] 계좌내역 조회");
		System.out.println("[2] 비밀번호 수정");
		int sel = u.getValue("", 1, 2);
		if (sel == 1) {
			printAcc();
		} else if (sel == 2) {
			modifyPw(log);
		}
	}

	private void printAcc() {
		ArrayList<Account> accountList = AccountDAO.accountList;
		System.out.println("================================");
		System.out.println("회원번호\t      계좌번호       잔액");
		System.out.println("--------------------------------");
		for (Account a : accountList) {
			if (a.getClientNo()==clientList.get(log).clientNo) {
				System.out.println(a.toString());
			}
		}
		System.out.println("================================");
	}
}
