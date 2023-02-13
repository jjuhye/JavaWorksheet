package a_클래스;
//20+2:10~
	import java.util.Random;
	import java.util.Scanner;

	class Game1to50{
		final int SIZE = 25;	
		int[] front = new int[SIZE];
		int[] back  = new int[SIZE];	
	}
	
	public class 클래스06_1to50 {

		public static void main(String[] args) {
			Scanner scan = new Scanner(System.in);
			Random ran = new Random();
			
			Game1to50 e = new Game1to50();
			
			for(int i=0; i<e.SIZE; i++) {
				e.front[i] = i + 1;
				e.back[i] = e.SIZE + i+1;
			}
			
			for(int i=0; i<1000; i++) {
				int r = ran.nextInt(e.SIZE);
				int temp = e.front[0];
				e.front[0] = e.front[r];
				e.front[r] = temp;
				
				 r = ran.nextInt(e.SIZE);
				 temp = e.back[0];
				e.back[0] = e.back[r];
				e.back[r] = temp;
			}
			
			int gameNum = 1;
			int hint = 0;
			while(true) {
				
				for(int i=0; i<e.SIZE; i++) {
					if(e.front[i] == gameNum) {
						hint = i;
					}
					if(e.front[i] == 0) {
						System.out.print("[  ] ");
					}else {
						System.out.printf("[%2d] ",e.front[i]);
					}
					if(i % 5 == 4) { System.out.println("\n"); }
				}
				System.out.println();
				
				if(gameNum > e.SIZE*2) {
					System.out.println("게임 종료");
					break;
				}

				System.out.printf("%d (위치>>%d) 입력: " ,gameNum, hint);
				int idx =scan.nextInt();
				
				if(idx < 0 || idx >=e.SIZE) {
					System.err.println("입력오류");
					continue;
				}

				if(e.front[idx] == gameNum) {
					if(gameNum <= e.SIZE) {
						e.front[idx] = e.back[idx];
					}else if(e.SIZE < gameNum ) {
						e.front[idx] = 0;
					}
					gameNum += 1;
				}
			}
			scan.close();
		}
	}