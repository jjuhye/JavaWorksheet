package p3_예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class 파일읽기 {

	public static void main(String[] args) {

		String fileName = "src/p3_예외처리/file01.txt";
		FileReader fr = null;
		String data = "";
		try {
			fr = new FileReader(fileName);
			int read = 0;
			while (read != -1) {
				read = fr.read();
				data += (char) read;
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println(data);
	}
}
