package S2_Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeSet;

public class ItemDAO {

	private ArrayList<Item> itemList;
	private int itemNo;

	public ItemDAO() {
		itemList = new ArrayList<Item>();
		itemNo = 1000;
		setSampleData();
	}

	public void setSampleData() {
		String categoryData[] = { "과자", "음료수", "과자", "음료수" };
		String itemNameData[] = { "새우깡", "콜라", "감자깡", "사이다" };
		int priceData[] = { 1000, 2000, 1500, 2500 };
		for (int i = 0; i < categoryData.length; i++) {
			Item item = new Item(getNextItemNumber(), categoryData[i], itemNameData[i], priceData[i]);
			itemList.add(item);
		}
	}

	public int getNextItemNumber() {
		itemNo++;
		return itemNo;
	}

	public boolean checkItem(String item) {
		for (int i = 0; i < itemList.size(); i++) {
			if (item.equals(itemList.get(i).getItemName())) {
				return true;
			}
		}
		return false;
	}

	// 아이템 가격 찾기
	public int checkPrice(String item) {
		int price = itemMap().get(item);
		return price;
	}

	// 아이템리스트에 아이템 추가
	public void addItem(Item i) {
		itemList.add(i);
	}

	// 아이템리스트에서 아이템 삭제
	public void delItem(String item) {
		for (int i = 0; i < itemList.size(); i++) {
			if (item.equals(itemList.get(i).getItemName())) {
				itemList.remove(i);
				return;
			}
		}
	}

	// 아이템목록 출력
	public void printItem() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.println(itemList.get(i).toString());
		}
	}

	// 카테고리 목록 만들기
	public ArrayList<String> makeCategoryList() {
		TreeSet<String> categorySet = new TreeSet<>();
		for (int i = 0; i < itemList.size(); i++) {
			categorySet.add(itemList.get(i).getCategoryName());
		}
		ArrayList<String> categoryList = new ArrayList<>();
		Iterator<String> iter = categorySet.iterator();
		while (iter.hasNext()) {
			categoryList.add(iter.next());
		}
		return categoryList;
	}

	// 카테고리 목록 출력
	public void printCategoryList() {
		ArrayList<String> categoryList = makeCategoryList();
		if (categoryList.size() != 0) {
			System.out.println("<<카테고리>>");
			for (int i = 0; i < categoryList.size(); i++) {
				System.out.println(i + 1 + ") " + categoryList.get(i));
			}
		}
	}

	// 카테고리 존재 확인
	public boolean isCategory(String ctg) {
		for (Item i : itemList) {
			if (ctg.equals(i.getCategoryName())) {
				return true;
			}
		}
		return false;
	}

	// 아이템명+가격 맵 생성
	public Map<String, Integer> itemMap() {
		Map<String, Integer> hmap = new HashMap<>();
		for (Item i : itemList) {
			hmap.put(i.getItemName(), i.getPrice());
		}
		return hmap;
	}
}
