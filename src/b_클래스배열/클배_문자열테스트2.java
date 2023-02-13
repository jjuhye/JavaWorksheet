package b_클래스배열;

import java.util.Arrays;

class Test {
	int num;
	int size;
	char[] data;

}

public class 클배_문자열테스트2 {
//10:23~10:57
	public static void main(String[] args) {

		String data = "";
		// num/size/data[]
		// num = 0, size =2; data = {a,b}
		data += "0/2/a/b\n";
		data += "1/3/a/b/c\n";
		data += "2/5/a/b/c/d/e\n";
		data += "3/4/a/b/c/d\n";
		data += "4/3/a/b/c\n";
		data += "5/1/a";
//		System.out.println(data);

		// data의 정보를 클래스배열에 저장.
		String temp[] = data.split("\n");
		Test[] t = new Test[temp.length];
		for (int i = 0; i < temp.length; i++) {
			String temp2[] = temp[i].split("/");
			Test dataT = new Test();
			dataT.num = Integer.parseInt(temp2[0]);
			dataT.size = Integer.parseInt(temp2[1]);
			dataT.data = new char[dataT.size];
			for (int k = 0; k < dataT.size; k++) {
				dataT.data[k] = temp2[k + 2].charAt(0);
			}
			t[i] = dataT;
		}
		System.out.printf("%s\t%s\t%-10s\n", "num", "size", "data");
		System.out.println("--------------------------------");
		int idx = 0;
		for (Test td : t) {
			System.out.printf("%d\t%d\t", td.num, td.size);
			System.out.println(Arrays.toString(t[idx].data));
			idx++;
		}
	}
}
