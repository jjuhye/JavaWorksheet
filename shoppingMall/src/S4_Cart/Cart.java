package S4_Cart;

public class Cart {
	private int number;
	private String memberID;
	private String itemName;
	private int itemPrice;
	
	public Cart(int number, String memberID, String itemName , int itemPrice) {
		super();
		setNumber(number);
		setMemberID(memberID);
		setItemName(itemName);
		setItemPrice(itemPrice);
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	
	public String toStringAll() {
		String print = String.format("[%-4d] [%7s] [%7s] [%8d]\n", 
				number , memberID , itemName , itemPrice);
		return print;
	}
	
	public String toString() {
		String print = String.format("%-5s [%6d원]\n", itemName , itemPrice);
		return print;
	}
}
