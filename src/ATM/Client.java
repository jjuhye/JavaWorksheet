package ATM;

public class Client {
	int clientNo;
	String id;
	String pw;
	String name;
	
	public Client(int clientNo, String id, String pw, String name) {
		super();
		this.clientNo = clientNo;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}

	@Override
	public String toString() {
		return ""+clientNo +"\t"+ id +"\t"+pw+"\t" +name;
	}
	
}
