package p3_예외처리;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class 파일읽기쓰기_예제 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		String nameData = "김철수,이만수,이영희";
		String ageData = "20,30,40";
		String fileName = "src/p3_예외처리/file03.txt";
		String data = "";

		String[] nameList = null;
		int[] ageList = null;

		FileWriter fw = null;
		FileReader fr = null;

		while (true) {

			System.out.println("[0] 종료 [1] 저장 [2] 로드");
			int sel = scan.nextInt();
			if (sel == 0) {
				System.err.println("[종료]");
				break;
			} else if (sel == 1) {
//				[저장] 김철수/20\n이만수/30\n이영희/40 이렇게 데이터를 만들어 파일 생성후 저장하시오.
				data = "";
				String[] names = nameData.split(",");
				String[] ages = ageData.split(",");
				try {
					fw = new FileWriter(fileName);
					for (int i = 0; i < names.length; i++) {
						data += names[i] + "/" + ages[i] + "\n";
					}
					fw.write(data);
					System.out.println("[저장 완료]");
				} catch (IOException e) {
					System.out.println("[저장 실패]");
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
			} else if (sel == 2) {
//				[로드] 파일을 불러와서 nameList, ageList 배열에 저장하시오 
				data = "";
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
					System.out.println("파일 불러오기 성공");
					System.out.println(data);

					String temp[] = data.split("\n");
					nameList = new String[temp.length];
					ageList = new int[temp.length];
					for (int i = 0; i < temp.length; i++) {
						String temp2[] = temp[i].split("/");
						nameList[i] = temp2[0];
						ageList[i] = Integer.parseInt(temp2[1]);
					}
					System.out.println(Arrays.toString(nameList));
					System.out.println(Arrays.toString(ageList));

				} catch (FileNotFoundException e) {
					System.err.println("파일 찾을 수 없음");
				} catch (IOException e) {
					System.err.println("파일 불러오기 실패");
				}

			}
		}
		scan.close();
	}
}
