package 싱글톤_학생추가;

public class _SingletonMain {
	public static void main(String[] args) {
		Controller sc = Controller.getInstance();
		sc.init();
	}
}
