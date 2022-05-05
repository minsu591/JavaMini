package co.mia.prj.minigame.ms;

import java.util.Scanner;

public class MagicSquare { //마방진
	//n이 홀수일 때 첫 행의 가운데 칸에 1을 넣음
	//대각선 방향으로 오른쪽 위에 다음 수를 채워넣는데
	//자리가 없으면 그 줄의 가장 아랫단이나 왼쪽으로
	//자리가 있으면 한칸 아래로 이동
	
	private int x;
	private int y;
	private int[][] magicArr;
	private Scanner scn = new Scanner(System.in);
	
	private void magicSquareLogic(int n) {
		//초기값
		x = n/2;
		y=0;
		magicArr = new int[n][n];
		//로직
		for(int i = 1; i<=n*n;i++) {
			if(x > n-1 && y<0) { // i%n==0일 때
				x--;
				y+=2;
			}else if(x> n-1){
				x=0;
			}else if(y<0) {
				y=n-1;
			}
			
			if(magicArr[y][x]==0) {
				magicArr[y][x] = i;
				x++;
				y--;
			}else { //차있으면
				y+=2;
				x--;
				i--;
			}
		}
		//마방진 프린트
		for(int[] ia : magicArr) {
			for(int i : ia) {
				System.out.printf("%3d",i);
			}
			System.out.println();
		}

	}
	
	public void msRun() {
		int n=0;
		System.out.print("마방진을 생성할 수를 입력해주세요 (홀수) >>> ");
		try {
			n= scn.nextInt();			
		}catch(Exception e) {
			System.out.println("다시 입력바랍니다.");
			scn.nextLine();
		}
		
		if(n%2==1 && n>1) {
			magicSquareLogic(n);
		}
	}
	

}
