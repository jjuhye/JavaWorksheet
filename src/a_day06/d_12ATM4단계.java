package day06;

import java.util.Scanner;

public class d_12ATM4�ܰ� {

	public static void main(String[] args) {
		// Ǯ�̽ð� 17:57~
		Scanner scan = new Scanner(System.in);

		int dbAcc1 = 1111;
		int dbPw1 = 1234;
		int dbMoney1 = 50000;

		int dbAcc2 = 2222;
		int dbPw2 = 2345;
		int dbMoney2 = 70000;

		int id = 0;
		int pw = 0;
		int money = 0;
		int log = -1; // -1(�α׾ƿ�), 1(dbAcc1�α���), 2(dbAcc2�α���)

		boolean run = true;
		while (run) {

			System.out.println("1.�α���");
			System.out.println("2.�α׾ƿ�");
			System.out.println("3.�Ա�");
			System.out.println("4.���");
			System.out.println("5.��ü");
			System.out.println("6.��ȸ");
			System.out.println("0.����");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if (sel == 1) {
				if (log != -1) {
					System.out.println("***�̹� �α��� ����***");
					continue;
				}
				System.out.print("id >> ");
				id = scan.nextInt();
				System.out.print("pw >> ");
				pw = scan.nextInt();

				if (id == dbAcc1 && pw == dbPw1) {
					System.out.println("***dbAcc1�� �α��� ����***");
					log = 1;
				} else if (id == dbAcc2 && pw == dbPw2) {
					System.out.println("***dbAcc2�� �α��� ����***");
					log = 2;
				} else {
					System.out.println("***�α��� ����***");
				}
			} else if (sel == 2) {
				if (log == -1) {
					System.out.println("***�̹� �α׾ƿ� ����***");
					continue;
				}
				System.out.println("***�α׾ƿ� �Ǿ����ϴ�***");
				log = -1;
			} else if (sel == 3) {
				if (log == -1) {
					System.out.println("***�α��� �� �̿밡��***");
					continue;
				}
				while (true) {
					System.out.print("�Ա��� �ݾ� : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("***0�� �̻��� �ݾ��� �Ա�***");
						continue;
					}
					break;
				}
				System.out.println("***�Ա� �Ϸ�***");
				if(log == 1) {
					dbMoney1 += money;
				}else {
					dbMoney2 += money;
				}
			} else if (sel == 4) {
				if (log == -1) {
					System.out.println("***�α��� �� �̿밡��***");
					continue;
				}
				while (true) {
					System.out.print("����� �ݾ� : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0�� �̻��� �ݾ��� �־��ּ���.");
						continue;
					}
					if (money > dbMoney1 || money > dbMoney2) {
						System.out.println("***�ܾ� ����***");
						continue;
					}
					break;
				}
				if(log == 1) {
					dbMoney1 -= money;
				}else {
					dbMoney2 -= money;
				}
				System.out.println("***��� �Ϸ�***");
			
			} else if (sel == 5) {
				if (log == -1) {
					System.out.println("***�α��� �� �̿밡��***");
					continue;
				}
				while (true) {
					System.out.print("��ü ���¹�ȣ �Է� : ");
					int acc = scan.nextInt();
					if (acc != dbAcc2 || acc != dbAcc1) {
						System.out.println("***���¹�ȣ ����***");
						continue;
					}
					break;
				}
				while (true) {
						System.out.println("��ü �ݾ� �Է� : ");
						money = scan.nextInt();
						if (money > dbMoney1 || money > dbMoney2) {
							System.out.println("***�ܾ� ����***");
							continue;
						}
						if(log == 1) {
							dbMoney1 -= money;
							dbMoney2 += money;
						}else {
							dbMoney2 -= money;
							dbMoney1 += money;
						}
						System.out.println("***��ü �Ϸ�***");
						break;
					}
			
			} else if (sel == 6) {
				if (log == -1) {
					System.out.println("***�α��� �� �̿밡��***");
					continue;
				}
				System.out.println("1111���� �ܾ� : " + dbMoney1 + "��");
				System.out.println("2222���� �ܾ� : " + dbMoney2 + "��");
			} else if (sel == 0) {
				run = false;
				System.out.println("���α׷� ����");
			}
		}

	}

}
