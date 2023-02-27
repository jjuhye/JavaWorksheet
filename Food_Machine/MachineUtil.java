package Food_Machine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MachineUtil {

	private FileWriter fw;
	private FileReader fr;
	
	// 메뉴 선택 예외처리 메소드
	int getValue(String msg, int start, int end) {
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		System.out.printf("▶ %s[%d-%d] 입력: ", msg, start, end);
		try {
			sel = sc.nextInt();
			if (sel < start || sel > end) {
				throw new Exception(start + "~" + end + "값 입력해주세요");
			}
			return sel;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return -1;
	}

	// 숫자값 입력 예외처리 메소드
	int getValue(String msg) {
		Scanner sc = new Scanner(System.in);
		int sel = -1;
		System.out.print("▶ " + msg + " :");
		try {
			sel = sc.nextInt();
			return sel;
		} catch (InputMismatchException e) {
			System.err.println("숫자 값을 입력하세요");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return -1;
	}

	// 파일 저장 (문자열 데이터, 파일제목)
	void save(String data, String fileName) {
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
			System.out.println("[저장 완료]");
			System.out.println("----------------");
		} catch (IOException e) {
			System.out.println("[저장 실패]");
			System.out.println("----------------");
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

	// 파일 불러오기 (파일제목)
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
			System.out.println("[파일 불러오기 성공]");
			return data;
		} catch (FileNotFoundException e) {
			System.err.println("파일 찾을 수 없음");
			data = "----------------";
			return data;
		} catch (IOException e) {
			System.err.println("파일 불러오기 실패");
			data = "----------------";
			return data;
		}
	}
	
	// 파일 삭제 (열려있으면 삭제불가)
	void delete(String fileName) {
		File fl=new File(fileName);
		if(fl.exists()) {
			if(fl.delete()) {
				System.out.println("[파일 삭제 완료]");
			}else {
				System.err.println("파일 삭제 실패");
			}
		}else {
			System.err.println("파일이 존재하지 않습니다");
		}
	}
}
