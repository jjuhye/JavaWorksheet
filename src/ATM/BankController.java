package ATM;

public class BankController {
	
	private AccountDAO aDAO;
	private ClientDAO cDAO;
	private Util u;
	private final String NAME="우리은행";
	
	BankController() {
		aDAO=new AccountDAO();
		cDAO=new ClientDAO();
		u=new Util();
		setSampleData();
	}
	
	private void setSampleData() {
		String clientData = "test01/1111/김철수\n";
		clientData += "test02/2222/이영희\n";
		clientData += "test03/3333/신민수\n";
		clientData += "test04/4444/최상민";
				
		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";		
		// 1) test01 김철수는 계좌를 3개 가지고있다.
		// 2) test02 이영희는 계좌를 2개 가지고있다.
		// 3) test03 신민수는 계좌를 2개 가지고있다.
		// 4) test04 최상민은 계좌를 1개 가지고있다. 
		
		cDAO.dataSetting(clientData);
		aDAO.dataSetting(accountdata);
	}

	void mainMenu() {
		while (true) {
			System.out.println("==["+NAME+" ATM]==");
			System.out.println("[1] 관리자");
			System.out.println("[2] 사용자");
			System.out.println("[0] 종료");
			int sel = u.getValue("", 0, 2);
			if (sel == 0) {
				System.err.println("["+NAME+" ATM 종료]");
				return;
			} else if (sel == 1) {
				adminMenu();
			} else if (sel == 2){
				userMenu();
			}
		}
	}
	
	private void adminMenu() {
		while (true) {
			System.out.println("==[" + NAME + " 관리자]==");
			System.out.println("[1] 회원목록");
			System.out.println("[2] 회원정보 수정");
			System.out.println("[3] 회원정보 삭제");
			System.out.println("[4] 회원정보 저장");
			System.out.println("[5] 회원정보 불러오기");
			System.out.println("[0] 뒤로가기");
			int sel = u.getValue("", 0, 5);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				System.out.println("[회원목록]");
				cDAO.showMember();
			} else if (sel == 2) {
				System.out.println("[회원정보 수정]");
				cDAO.modifyMember();
			} else if (sel == 3) {
				System.out.println("[회원정보 삭제]");
				cDAO.deleteMember();
			} else if (sel == 4) {
				System.out.println("[회원정보 저장]");
				cDAO.saveData();
			} else if (sel == 5) {
				System.out.println("[회원정보 불러오기]");
				cDAO.readData();
			}
		}
	}
	
	private void userMenu() {
		while(true) {
			System.out.println("==["+NAME+" 사용자]==");
			System.out.println("[1] 회원가입");
			System.out.println("[2] 로그인");
			System.out.println("[0] 뒤로가기");
			int sel=u.getValue("",0,2);
			if(sel==0) {
				return;
			}else if(sel==1) {
				System.out.println("[회원가입]");
				cDAO.join();
			}else if(sel==2) {
				System.out.println("[로그인]");
				if(cDAO.login()) {
					loginUserMenu();
				}
			}
		}
	}
	
	private void loginUserMenu() {
		while(true) {
			System.out.println("==["+NAME+" ATM]==");
			System.out.println("[1] 계좌 추가");
			System.out.println("[2] 계좌 삭제");
			System.out.println("[3] 입금");
			System.out.println("[4] 출금");
			System.out.println("[5] 이체");
			System.out.println("[6] 탈퇴 ");
			System.out.println("[7] 마이페이지");
			System.out.println("[0] 로그아웃");
			int sel=u.getValue("",0,7);
			if(sel==0) {
				cDAO.log=-1;
				return;
			}else if(sel==1) {
				aDAO.addAcount(cDAO.log);
			}else if(sel==2) {
				aDAO.deleteAcount(cDAO.log);
			}else if(sel==3) {
				aDAO.creditMoney(cDAO.log);
			}else if(sel==4) {
				aDAO.debitMoney(cDAO.log);
			}else if(sel==5) {
				aDAO.sendMoney(cDAO.log);
			}else if(sel==6) {
				cDAO.quitMember();
				return;
			}else if(sel==7) {
				cDAO.myPage();
			}
		}
	}
}
