package day06;

import java.util.Scanner;

public class ATM2 {

	public static void main(String[] args) {
		// Ǯ�̽ð� 16:37~16:47
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;

		int id = 0;
		int pw = 0;

		int log = -1; // -1(�α׾ƿ�), 1(dbAcc1�α���), 2(dbAcc2�α���)

		boolean run = true;
		while (run) {

			System.out.println("1.�α���");
			System.out.println("2.�α׾ƿ�");
			System.out.println("0.����");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (log != -1) {
					System.out.println("�̹� �α��� ����");
					continue;
				}
				System.out.println("id >> ");
				id = scan.nextInt();
				System.out.println("pw >> ");
				pw = scan.nextInt();

				if (id == dbAcc1 && pw == dbPw1) {
					System.out.println("dbAcc1�� �α��� ���� ");
					log = 1;
				} else if (id == dbAcc2 && pw == dbPw2) {
					System.out.println("dbAcc2�� �α��� ���� ");
					log = 1;
				} else {
					System.out.println("[�α��� ����] ID/PW�� Ʋ���ϴ�.");
				}

			} else if (sel == 2) {

				if (log == -1) {
					System.out.println("�̹� �α׾ƿ� ����");
					continue;
				}
				System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
				log = -1;
			} else if (sel == 0) {
				run = false;
				System.out.println("==���α׷� ����==");
			}else {
				System.out.println("[�Է¿���] 0~2�߿��� �Է�");
			}
		}

	}

}
