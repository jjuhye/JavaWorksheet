package day06;

import java.util.Scanner;

public class f14_�迭����2 {

	public static void main(String[] args) {
		// 18:02~
		Scanner scan=new Scanner(System.in);

//		int idx=-1;
//		===========================
		int a[] = { 10,20,30,40,50 };
		
//		if(ind>=0 && ind<=4) {
//			idx=i;
//			break;
//		}
		
		
		System.out.print("���� 1) �ε��� >> ");
		int ind=scan.nextInt();
		System.out.println("�� : "+a[ind]);
		
//		===========================
		int b[] = { 12,54,23,87,1 };
		int max=b[0];
		for(int i=0; i<b.length; i++) {
			if(max<b[i]) {
				max=b[i];
				break;
			}
		}
		System.out.println();
		System.out.println("���� 2) ����ū�� : "+max);
		
//		===========================
		int c[] = { 12,54,23,87,1 };
		int cnt=0;
		for(int i=0; i<c.length; i++) {
			if(c[i]%2==1) {
				cnt++;
			}
		}
		System.out.println();
		System.out.println("���� 3) Ȧ�� ���� : "+cnt);
		
//		===========================
		int d[] = { 1,2,3,4,5 };
		int e[] = { 0,0,0,0,0 };
		int k=4;
		for(int i=0; i<d.length; i++) {
			e[k]=d[i];
			k--;
		}
		System.out.println();
		System.out.print("���� 4) e = {");
		for(int i=0; i<e.length; i++) {
			System.out.print(e[i]+" ");
		}
		System.out.print("}");
	}
}