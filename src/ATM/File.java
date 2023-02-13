package ATM;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class File {
	
	FileWriter fw;
	FileReader fr;
	
	String clientFileName = "clientData.txt";
	String accountFileName = "accountData.txt";
	
	void save(String data, String fileName) {
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			System.out.println("["+fileName+" 저장 완료]");
		} catch (IOException e) {
			System.out.println("["+fileName+" 저장 실패]");
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	String open(String fileName) {
		String data = "";
		try {
			fr = new FileReader(fileName);
			while (true) {
				int read = fr.read();
				if (read != -1) {
					data += (char) read;
				} else {
					break;
				}
			}
			System.out.println("["+fileName+" 파일 불러오기 성공]");
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("["+fileName+" 파일 찾을 수 없음");
			data = "----------------";
			return data;
		} catch (IOException e) {
			System.err.println("["+fileName+" 파일 불러오기 실패");
			data = "----------------";
			return data;
		}
	}
}
