package test;

import java.util.Arrays;
import java.util.Scanner;

public class ����4 {

	public static void main(String[] args) {
		/*
		 * 9:50~ # 2���� ȸ������������ [1] ��ȣ [2] ���̵� [3] ��й�ȣ [4] �̸� �׽�Ʈ�� ���� �Ʒ� �⺻������ 4���� �ְ�
		 * �����Ѵ�.
		 */

		Scanner scan = new Scanner(System.in);
		// ��ȣ ���̵� ��� �̸�
		String[] test1 = { "1001", "aaa", "aaa123", "��ö��" };
		String[] test2 = { "1002", "bbb", "bbb123", "�̹μ�" };
		String[] test3 = { "1003", "ccc", "ccc123", "�ڿ���" };
		String[] test4 = { "1004", "ddd", "ddd123", "�ֹ���" };
		int cnt = 4; // ���� �ɹ� ��
		String[][] mList = new String[100][4]; // �ִ�100�� ����Ÿ��4

		String menu = "[ȸ������] \n [1] �߰� [2] ���� [3] ���� [4] �˻� [5] ��� [0] ���� \n";

		String temp[][] = { test1, test2, test3, test4 };

		// ���� ������ ��ȣ������ �̸� ����ó��
		for (int i = 0; i < cnt; i++) {
			for (int k = i; k < cnt; k++) {
				if (Integer.parseInt(temp[k][0]) < Integer.parseInt(temp[i][0])) {
					String[] tempArr = temp[i];
					temp[i] = temp[k];
					temp[k] = tempArr;
				}
				mList[i] = temp[i];
				mList[k] = temp[k];
			}
		}

		while (true) {
			System.out.println(menu);

			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 5) {
				// ��ȣ�� �̸� ���
				for (int i = 0; i < cnt; i++) {
					System.out.println("��ȣ: " + mList[i][0] + "   �̸�: " + mList[i][3]);
				}
			}

			else if (sel == 1) {
				System.out.print("���̵� �Է� : ");
				String id = scan.next();

				// ���̵� �ߺ��˻�
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						check = true;
					}
				}
				if (check) {
					System.err.println("�ߺ����̵� �ֽ��ϴ�.");
					continue;
				}

				// ����� ���ڸ� �ϸ� ���� �߰�
				System.out.print("��й�ȣ �Է� : ");
				String pw = scan.next();
				int count = 0;

				for (int i = 0; i < pw.length(); i++) {
					if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
						count++;
					}
				}
				if (count == pw.length()) {
					System.err.println("��й�ȣ�� ���ڸ� �Է� �Ұ�");
					continue;
				}

				// �̸��� ���� ������ �����߰�
				System.out.print("�̸� �Է� : ");
				String name = scan.next();
				check = false;
				for (int i = 0; i < name.length(); i++) {
					if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
						System.err.println("�̸��� ���� �Է� �Ұ�");
						check = true;
						break;
					}
				}
				if (check) {
					continue;
				}

				// ��ȣ�� �ִ� ū ��ȣ���� +1 ���� �� ��
				mList[cnt][0] = Integer.parseInt(mList[cnt - 1][0]) + 1 + "";
				mList[cnt][1] = id;
				mList[cnt][2] = pw;
				mList[cnt][3] = name;
				System.out.println(name + "�� ȸ������ �Ϸ�");
				cnt++;

			} else if (sel == 2) {
				// ������ ��ȣ �Է¹޾Ƽ� ���� => ���� �ٽ� ������� =>
				System.out.print("��ȣ �Է� : ");
				String num = scan.next();

				int idx = -1;
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (num.equals(mList[i][0])) {
						mList[i] = mList[i + 1];
						mList[i + 1] = new String[4];
						cnt--;
						check = true;
					}
				}
				if (check == false) {
					System.err.println("��ȣ�� �����ϴ�.");
					continue;
				}

			} else if (sel == 3) {
				// ���� => id �� ��� �Է¹ް� ������ �ش� id�� ��� Ȥ�� �̸��� ���� ����
				System.out.print("���̵� �Է� : ");
				String id = scan.next();

				int idx = -1;
				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						System.out.print("��й�ȣ �Է� : ");
						String pw = scan.next();
						if (pw.equals(mList[i][2])) {
							idx = i;
							check = true;
							continue;
						}
					}
				}
				if (check == false) {
					System.err.println("���̵�, ��й�ȣ�� Ʋ���ϴ�.");
					continue;
				} else {
					System.out.println("[1] �̸� ����, [2] ��й�ȣ ����");
					int input = scan.nextInt();
					if (input == 1) {
						System.out.print("�� �̸� �Է� : ");
						String name = scan.next();
						for (int i = 0; i < name.length(); i++) {
							if (name.charAt(i) >= '0' && name.charAt(i) <= '9') {
								System.err.println("�̸��� ���� �Է� �Ұ�");
								continue;
							}
						}
						mList[idx][3] = name;
					} else if (input == 2) {
						System.out.print("�� ��й�ȣ �Է� : ");
						String pw = scan.next();
						int count = 0;

						for (int i = 0; i < pw.length(); i++) {
							if (pw.charAt(i) >= '0' && pw.charAt(i) <= '9') {
								count++;
							}
						}
						if (count == pw.length()) {
							System.err.println("��й�ȣ�� ���ڸ� �Է� �Ұ�");
							continue;
						}
						mList[idx][2] = pw;
					} else {
						System.err.println("�Է¿��� : 1~2");
						continue;
					}
				}

			} else if (sel == 4) {
				// �˻� => id �˻� �Է� �޾Ƽ� �̸� ���
				System.out.print("���̵� �Է� : ");
				String id = scan.next();

				boolean check = false;
				for (int i = 0; i < cnt; i++) {
					if (id.equals(mList[i][1])) {
						System.out.println(id + " >> " + mList[i][3]);
						check = true;
					}
				}
				if (check == false) {
					System.err.println("���̵� �����ϴ�.");
					continue;
				}
			}
		}
		scan.close();
	}
}
