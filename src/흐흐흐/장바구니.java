package test;

import java.util.Arrays;
import java.util.Scanner;

public class ��ٱ��� {

	public static void main(String[] args) {
		// 15:30~17:40
		Scanner scan = new Scanner(System.in);

		String[] idList = { "qwer", "javaking", "abcd" };
		String[] pwList = { "1111", "2222", "3333" };

		int MAX_SIZE = 100;
		String[][] cartList = new String[MAX_SIZE][2];

		String[] items = { "���", "�ٳ���", "����" };

		int log = -1;
		int count = 0;
		while (true) {
			System.out.println("[MEGA MART]");
			if (log == -1) {
				System.out.println("[1]�� �� ��");
			}
			if (log != -1) {
				System.out.println("[1]�α׾ƿ�");
				System.out.println("[2]��     ��");
				System.out.println("[3]��ٱ���");
			}
			System.out.println("[0]��     ��");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if (sel == 0) {
				System.err.println("[���α׷� ����]");
				break;
			}
			if (sel < 0 || sel > 3) {
				System.err.println("�Է¿���: 0~3");
				continue;
			}
			if (log == -1 && (sel >= 2 && sel <= 3)) {
				System.err.println("���� ���� �̿�Ұ�");
				continue;
			}
			if (sel == 1 && log != -1) {
				System.err.println("[�α׾ƿ� ����]");
				log = -1;
				continue;
			} else if (sel == 1 && log == -1) {
				System.out.print("���̵� �Է� : ");
				String id = scan.next();
				int check = 0;
				for (int i = 0; i < idList.length; i++) {
					if (id.equals(idList[i])) {
						check++;
						System.out.print("��й�ȣ �Է� : ");
						String pw = scan.next();
						for (int k = 0; k < pwList.length; k++) {
							if (pw.equals(pwList[k])) {
								check++;
								log = i;
								i = idList.length;
								break;
							}
						}
					}
				}
				if (check == 0) {
					System.err.println("���̵� Ʋ���ϴ�.");
					continue;
				} else if (check == 1) {
					System.err.println("��й�ȣ�� Ʋ���ϴ�.");
					continue;
				} else {
					System.err.println("[�α��� ����]");
					continue;
				}
			} else if (sel == 2) {
				System.out.println("[1]���  [2]�ٳ���  [3]���� [0]���� ����");
				while (true) {
					System.out.print("������ ���� : ");
					int input = scan.nextInt();
					if (input == 0) {
						break;
					}
					if (input < 0 || input > 3) {
						System.err.println("�Է¿��� : 0~3");
					}
					for (int i = 0; i < items.length + 1; i++) {
						if (input == i) {
							System.out.println(items[i - 1] + " 1�� ��ٱ��� ���");
							cartList[count][0] = idList[log];
							cartList[count][1] = items[i - 1];
							count++;
							break;
						}
					}
				}
			} else if (sel == 3) {
				int[] qty = new int[3];
				for (int i = 0; i < cartList.length; i++) {
					if (cartList[i][0] != idList[log]) {
						continue;
					}
					for (int k = 0; k < items.length; k++) {
						if (cartList[i][1] == items[k]) {
							qty[k]++;
						}
					}
				}
				System.out.println("=== " + idList[log] + "�� ��ٱ��� ===");
				for (int i = 0; i < qty.length; i++) {
					if (qty[i] != 0) {
						System.out.println(items[i] + " >> " + qty[i] + "��");
					}
				}
				System.out.println();
			} else if (sel == 4) {

				System.out.println(Arrays.toString(cartList[count]));
			}
		}
	}
}
