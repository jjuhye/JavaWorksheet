package day06;

import java.util.Scanner;

public class ATM3 {

	public static void main(String[] args) {
		// Ǯ�̽ð� 16:59~
		Scanner scan = new Scanner(System.in);

		int myAcc = 1111;
		int myMoney = 50000;

		int yourAcc = 2222;
		int yourMoney = 70000;

		int money = 0;

		boolean run = true;
		while (run) {

			System.out.println("===========");
			System.out.println("1.�Ա�");
			System.out.println("2.���");
			System.out.println("3.��ü");
			System.out.println("4.��ȸ");
			System.out.println("0.����");

			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();

			if (sel < 0 || sel > 4) {
				System.out.println("[�Է¿���] 0~4�߿� ����");
				continue;
			}

			if (sel == 1) {
				while (true) {
					System.out.print("�Ա��� �ݾ� : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0�� �̻��� �ݾ��� �־��ּ���.");
						continue;
					}
					break;
				}
				System.out.println("***�Ա� �Ϸ�***");
				myMoney += money;
			} else if (sel == 2) {
				while (true) {
					System.out.print("����� �ݾ� : ");
					money = scan.nextInt();
					if (money <= 0) {
						System.out.println("0�� �̻��� �ݾ��� �־��ּ���.");
						continue;
					}
					if (money > myMoney) {
						System.out.println("***�ܾ� ����***");
						continue;
					}
					break;
				}
				myMoney -= money;
				System.out.println("***��� �Ϸ�***");
			} else if (sel == 3) {
				while (true) {
					System.out.print("��ü ���¹�ȣ �Է� : ");
					int acc = scan.nextInt();
					if (acc != yourAcc) {
						System.out.println("***���¹�ȣ ����***");
						continue;
					}
					break;
				}
				while (true) {
						System.out.println("��ü �ݾ� �Է� : ");
						money = scan.nextInt();
						if (money > myMoney) {
							System.out.println("***�ܾ� ����***");
							continue;
						}
						myMoney -= money;
						yourMoney += money;
						System.out.println("***��ü �Ϸ�***");
						break;
					}
			} else if (sel == 4) {
				System.out.println("1111���� �ܾ� : " + myMoney + "��");
				System.out.println("2222���� �ܾ� : " + yourMoney + "��");
			} else if (sel == 0) {
				run = false;
				System.out.println("���α׷� ����");
			}
		}
	}
}
