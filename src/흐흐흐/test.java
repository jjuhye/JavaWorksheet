package 흐흐흐;

import java.util.ArrayList;

class TestDAO{
	private String name;
	private ArrayList<String> list;
	private TestDAO(String name){
		list=new ArrayList<String>();
		setName(name);
	}
	
	private static TestDAO instance=new TestDAO("dao");
	
	static TestDAO getInstance() {
		return instance;
	}
	
	private void setName(String name) {
		this.name=name;
	}
	
	String getName() {
		return name;
	}
	
	void printAll() {
		System.out.println(list);
	}
	
//	ArrayList<String> getList(){
//		return list;
//	}
	
	void addList(String name) {
		setName(name);
		list.add(getName());
	}
}

public class test {

	public static void main(String[] args) {
		
		TestDAO t = TestDAO.getInstance();
		t.addList("고양이");
		t.addList("강아지");
		t.printAll();
		
	}
}
