package day06;

import java.util.Scanner;

public class f13_�迭����1 {

	public static void main(String[] args) {
		// 16:53~
		Scanner scan = new Scanner(System.in);
//		int a[] = { 10, 49, 51, 36, 17 };
//
//		System.out.printf("����Ʈ�� �Է� : ");
//		int input = scan.nextInt();
//		for (int i = 0; i < a.length; i++) {
//			if (input == a[i]) {
//				System.out.println("���� 1) " + a[i] + " ==> " + i);
//				break;
//			}
//		}
//		// ==========================================
//		int b[] = { 0, 0, 0, 0, 0 };
//		System.out.print("���� 2) b = [");
//		for (int i = 0; i < a.length; i++) {
//			if (a[i] % 2 == 1) {
//				b[i] = a[i];
//			}
//			System.out.print(b[i] + " ");
//		}
//		System.out.print("]");
//		// ==========================================
//		int k = 0;
//		int c[] = { 0, 0, 0, 0, 0 };
//		for (int i = 0; i < a.length; i++) {
//			if (a[i] % 2 == 1) {
//				c[k] = a[i];
//				k++;
//			}
//		}
//		System.out.print("���� 3) c = [");
//		for (int i = 0; i < c.length; i++) {
//			System.out.print(c[i] + " ");
//		}
//		System.out.print("]");
		// ==========================================
		int arr[] = { 1001, 20, 1002, 45, 1003, 54 };
//		int idx=-1;
		System.out.print("�й� �Է� : ");
		int hak = scan.nextInt();
		
		for (int i = 0; i < arr.length; i+=2) {
			if(arr[i]==hak) {
				idx=i+1;
				break;
			}
		}
		for (idx!=-1) {
			System.out.println(arr[i]+" ==> "+arr[i+1] );
			break;
			}else {
				System.out.println("���� �й�");
				break;
			}
		}
	}
}
