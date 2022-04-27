package com.mini.board;

import java.util.Scanner;

public class MainApp {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BoardManagerArray boards = new BoardManagerArray();
		
		while(true) {
			System.out.println("1. 추가 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 작성자 검색 | 6. 종료");
			int menu = scn.nextInt();
			if(menu == 1) {
				boards.add();
			}else if (menu == 2){
				boards.modify();
			}else if(menu==3) {
				boards.delete();
			}else if(menu==4) {
				boards.viewlist();
			}else if(menu==5) {
				boards.searchWriter("writer");
			}else if(menu==6) {
				boards.exit();
				break;
			}
		}
	}

}
