package test;

import java.util.Arrays;
import java.util.Iterator;

public class ��ٱ��ϰ˻� {

	public static void main(String[] args) {
		/* 17:40~
		[����1] 
			ȸ������ ������ ���Ÿ���� ����Ͻÿ�.
		[����1] 
			�̸���(���� 3�� ĭ�� 1��)
			��ö��(���� 1��)
			�̿���(���� 1�� ����� 2��)
		
		[����2]
			�����ۺ��� ������ ȸ���̸��� ����Ͻÿ�.
		[����2]
			����(�̸��� ��ö�� �̿���)
			�����(�̿���)
			ĭ��(�̸���)
	 */
		String itemData = "1001/����,1002/�����,1003/ĭ��";
		String userData = "3001/�̸���,3002/��ö��,3003/�̿���";
		
		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";
		
		
		System.out.println("====������ ���====");
		String temp[]=itemData.split(",");
		String item[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			item[i]=temp[i].split("/");
			System.out.println(Arrays.toString(item[i]));
		}
		
		System.out.println("=====���� ���=====");
		temp=userData.split(",");
		String user[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			user[i]=temp[i].split("/");
			System.out.println(Arrays.toString(user[i]));
		}
		
		System.out.println("====��ٱ��� ���====");
		temp=cartData.split("\n");
		String cart[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			cart[i]=temp[i].split("/");
			System.out.println(Arrays.toString(cart[i]));
		}
		
		//[����1] ȸ���� ������ ���Ÿ��
		
		for(String[] u : user) {
			System.out.print(u[1]+" ( ");
			
			int[] cnt=new int[item.length];
			int idx=0;
			for(String[] i : item) {
				for(String[] c : cart) {
				if(u[0].equals(c[0]) && i[0].equals(c[1])) {
					cnt[idx]++;
				}
				
					if(c[1].equals(i[0])) {
						System.out.print(i[1]+" ");
						break;
					}
				}
				System.out.println(cnt[idx]+"��");
				idx++;
			}
			
		}
		
		
//		for (int i = 0; i < user.length; i++) {
//			System.out.print(user[i][1]+"( ");
//			for (int k = 0; k < cart.length; k++) {
//				if(user[i][0].equals(cart[k][0])) {
//					for (int j = 0; j < item.length; j++) {
//						if(cart[k][1]==item[j][0]) {
//							System.out.print(item[j][1]+" ");
//							cnt[j]++;
//						}
//						System.out.println(Arrays.toString(cnt));
//						System.out.println(cnt[j]+"��");
//					}
//				}
//			}
//		}
		
	}
}
