package com.mini.board;

import java.util.Scanner;

public class BoardManagerArray implements BoardManagerIf{
	Board[] boardArr = new Board[10];
	Scanner scn = new Scanner(System.in);
	private Board board;
	
	public Board changeBoard(String word) {
		System.out.println("[게시글 " + word+"]");
		System.out.print(word+"할 게시글의 제목을 입력해주세요 >>> ");
		String title = scn.next();
		System.out.print(word+"할 게시글의 내용을 입력해주세요 >>> ");
		String content = scn.next();
		board = new Board("writer","date",title,content);
		return board;
	}
	
	@Override
	public void add() {
		Board board = changeBoard("추가");
		
		for(int i = 0; i<boardArr.length;i++) {
			if(boardArr[i]==null) {
				boardArr[i]=board;
				System.out.println("게시글이 성공적으로 추가되었습니다!");
				return;
			}
		}
		System.out.println("잘못된 입력입니다.");
	}

	@Override
	public void modify() {
		this.searchWriter("writer");
		System.out.print("수정할 게시글 번호를 입력해주세요 >>> ");
		int no = scn.nextInt();
		if(boardArr[no]!= null) {
			Board board = changeBoard("수정");
			boardArr[no]=board;
			System.out.println("성공적으로 수정되었습니다.");
			return;
		}
		System.out.println("잘못된 입력입니다.");
		
	}

	@Override
	public void delete() {
		this.searchWriter("writer");
		System.out.println("삭제할 게시글 번호를 입력해주세요 >>> ");
		int no = scn.nextInt();
		if(boardArr[no]!=null) {
			System.out.println("정말 삭제하시겠어요? (Y/N)");
			String ans = scn.next();
			if(ans.equalsIgnoreCase("y")) {
				boardArr[no]=null;
				System.out.println("성공적으로 삭제되었습니다.");
			}else {
				System.out.println("삭제를 중지했습니다.");
				return;
			}
		}else {
			System.out.println("잘못된 입력입니다.");
		}
		
	}

	@Override
	public void viewlist() {
		for(int i =0;i<boardArr.length;i++) {
			if(boardArr[i]!=null) {
				System.out.println(boardArr[i].toString());
			}
		}
	}

	@Override
	public void searchWriter(String writer) {
		for(int i = 0; i<boardArr.length;i++) {
			if(boardArr[i]!=null && boardArr[i].getWriter().equals(writer)) {
				System.out.println(boardArr[i].toString());
			}
		}
	}

	@Override
	public void exit() {
		System.out.println("시스템을 종료합니다.");		
	}
	
	

}
