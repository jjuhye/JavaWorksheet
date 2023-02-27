package Food_Machine;

public class MachineDAO {
	private int tickets; // 식권수량
	private int price; // 식권 가격
	private int moneyTotal; // 잔돈 총액
	private int size; // 배열 사이즈
	private String data; // 출력용 데이터
	private String fileName;// 출력용 파일이름

	private MachineVO moneyList[];
	MachineUtil mUtil;

	// MachineDAO를 불러올때 실행되는 기본생성자
	MachineDAO() {
		mUtil = new MachineUtil();

		int[] moneys = { 50000, 10000, 5000, 1000, 500, 100 };
		int[] changes = { 1, 1, 1, 1, 5, 10 };

		tickets = 5;
		price = 3200;
		size = moneys.length;
		fileName = "자판기 현황.txt";

		// 금액 단위별 개수 클래스배열 생성
		moneyList = new MachineVO[size];
		for (int i = 0; i < size; i++) {
			moneyList[i] = new MachineVO(moneys[i], changes[i]);
		}

		// 자판기 잔고 총 금액 계산
		for (MachineVO mv : moneyList) {
			moneyTotal += mv.money * mv.change;
		}
	}

	// 1-1 식권충전
	void addTicket() {
		int cnt = mUtil.getValue("충전 매수");
		if (cnt <1) {
			System.err.println("1매 이상 선택하세요");
			return;
		}
		tickets += cnt;
		System.out.println("[식권" + cnt + "매 충전완료]");
		System.out.println("[현재 식권 : " + tickets + "매]");
		System.out.println("----------------");
	}

	// 1-2 잔돈충전
	void addMoney() {
		while (true) {
			String msg = "[0]5만원  [1]만원   [2]5천원\n"
					   + "[3]천원   [4]5백원  [5]백원\n";
			int idx = mUtil.getValue("<<충전 단위>>\n" + msg, 0, 5);
			if (idx == -1) {
				return;
			} else {
				int cnt = mUtil.getValue("충전 개수");
				if (cnt <1) {
					System.err.println("1개 이상 선택하세요");
					return;
				}
				moneyList[idx].change += cnt;
				moneyTotal += moneyList[idx].money * cnt;
				System.out.println("[" + moneyList[idx].money + "원권 " + cnt + "개 충전완료]");
				System.out.println("----------------");
				return;
			}
		}
	}

	// 출력 데이터 생성
	private String makeData() {
		data = "";
		data += "======= 자판기 현황 =======\n";
		for (MachineVO mv : moneyList) {
			data += mv.toString() + "\n";
		}
		data += "[잔돈 총액 : " + moneyTotal + "원]\n";
		data += "[식권 개수 : " + tickets + "개]\n";
		data += "========================\n";

		return data;
	}

	// 1-3 현황 출력 (데이터 화면 출력)
	void showData() {
		System.out.print(makeData());
	}

	// 1-4 현황 파일 저장
	void saveStatement() {
		data = makeData();
		mUtil.save(data, fileName);
	}

	// 1-5 현황 파일 불러오기
	void openStatement() {
		data = mUtil.open(fileName);
		System.out.println(data); // 데이터 화면 출력
	}
	
	// 1-6 파일 삭제하기
	void deleteStatement() {
		mUtil.delete(fileName);
	}

	// 2-1 식권 구입
	void getTicket() {
		int input = mUtil.getValue("입금 금액 입력");
		int buy = mUtil.getValue("구매 매수 입력");
		int sum = buy * price;
		int balance = input - sum;
		System.out.println("==================");
		System.out.println("식권 가격 : " + sum + "원");
		System.out.println("식권 수량 : " + buy + "매");
		System.out.println("----------------");
		if (buy > tickets) {
			System.err.println("!!매진!! 현재 잔량 : " + tickets + "매");
			System.out.println("----------------");
			return;
		} else if (balance < 0) {
			System.err.println("!!금액부족!!");
			System.out.println("----------------");
			return;
		} else if (balance > moneyTotal) {
			System.err.println("!!잔돈부족!!");
			System.out.println("----------------");
			return;
		} else {
			if(!outChange(balance)) {
			return;	
			}
			tickets -= buy;
			moneyTotal -= balance;
		}
	}

	// 잔돈 출력
	private boolean outChange(int balance) {
		int tempList[]=new int[size];
		for(int i=0; i<moneyList.length; i++) {
			tempList[i]=moneyList[i].change;
		}
		String bal="=== 구매 완료 ===\n";
		bal+="잔돈 총 : " + balance + "원\n";
		for (int i = 0; i < size; i++) {
			int unit = moneyList[i].money;
			if (balance / unit >= 0) {
				int cnt = balance / unit;
				if (tempList[i]< cnt) {
					cnt = tempList[i];
				}
				if (cnt > 0) {
					tempList[i] -= cnt;
					bal+="["+unit+"원\t: "+cnt+"개]\n";
				}
				balance -= cnt * unit;
			}
		}
		bal+="----------------\n";
		if(balance!=0) {
			System.err.println("!!잔돈부족!!");
			return false;
		}else {
			for(int i=0; i<moneyList.length; i++) {
				moneyList[i].change=tempList[i];
			}
			System.out.println(bal);
			return true;
		}
	}
}
