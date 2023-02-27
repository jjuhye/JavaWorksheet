package test;

import java.util.Arrays;
import java.util.Iterator;

public class 장바구니검색 {

	public static void main(String[] args) {
		/* 17:40~
		[문제1] 
			회원별로 아이템 구매목록을 출력하시오.
		[정답1] 
			이만수(고래밥 3개 칸쵸 1개)
			김철민(고래밥 1개)
			이영희(고래밥 1개 새우깡 2개)
		
		[문제2]
			아이템별로 구입한 회원이름을 출력하시오.
		[정답2]
			고래밥(이만수 김철민 이영희)
			새우깡(이영희)
			칸쵸(이만수)
	 */
		String itemData = "1001/고래밥,1002/새우깡,1003/칸쵸";
		String userData = "3001/이만수,3002/김철민,3003/이영희";
		
		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";
		
		
		System.out.println("====아이템 목록====");
		String temp[]=itemData.split(",");
		String item[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			item[i]=temp[i].split("/");
			System.out.println(Arrays.toString(item[i]));
		}
		
		System.out.println("=====유저 목록=====");
		temp=userData.split(",");
		String user[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			user[i]=temp[i].split("/");
			System.out.println(Arrays.toString(user[i]));
		}
		
		System.out.println("====장바구니 목록====");
		temp=cartData.split("\n");
		String cart[][]=new String[temp.length][2];
		for (int i = 0; i < temp.length; i++) {
			cart[i]=temp[i].split("/");
			System.out.println(Arrays.toString(cart[i]));
		}
		
		//[문제1] 회원별 아이템 구매목록
		
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
				System.out.println(cnt[idx]+"개");
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
//						System.out.println(cnt[j]+"개");
//					}
//				}
//			}
//		}
		
	}
}
