package S2_Item;

public class Item {
	private int number;
	private String categoryName;
	private String itemName;
	private int price;
	
	public Item(int number, String categoryName, String itemName, int price) {
		super();
		setNumber(number);
		setCategoryName(categoryName);
		setItemName(itemName);
		setPrice(price);
	}

	public int getNumber() {
		return number;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public String getItemName() {
		return itemName;
	}
	public int getPrice() {
		return price;
	}

	private void setNumber(int number) {
		this.number = number;
	}
	private void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	private void setItemName(String itemName) {
		this.itemName = itemName;
	}
	private void setPrice(int price) {
		this.price = price;
	}

	public String toString() {
		String print = String.format("[%-4d] [%7s] [%7s] [%7d]", number , categoryName , itemName , price);
		return print;
	}
}
