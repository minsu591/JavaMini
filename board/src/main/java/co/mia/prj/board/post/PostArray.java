package co.mia.prj.board.post;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import co.mia.prj.board.log.LogInfo;

public class PostArray implements PostManagerBase { // 게시글 관리를 Array로

	Post[] postArr = new Post[10];
	Scanner scn = new Scanner(System.in);
	private Post post;
	private LogInfo inPerson = new LogInfo(null, null); // 현재 로그인한 아이디
	List<String> contentArr = new ArrayList<String>(); //content를 저장할 리스트
	
	
	public void printPost(Post searchPost) { //게시글 출력 기능
		System.out.println("-------------------------");
		System.out.printf("%5s %-3d\n", "게시글 번호 : ", searchPost.getPostNo());
		System.out.printf("%-4s %-10s %-4s %-5s \n", "제목 : ", searchPost.getTitle(), "작성자 : ", searchPost.getWriter());
		System.out.printf("%4s", "내용 : ");
		for(int i = 0; i<contentArr.size()-1;i++) {
			System.out.println(contentArr.get(i));
		}

		System.out.printf("%5s %-10s", "작성시간 : ", searchPost.getWriteDate());
		System.out.println();

	}

	public Post changeBoard(String word) { //추가 및 수정 메소드에서 post를 postArr에 추가하는 기능
		//오늘 날짜 설정
		Timestamp ts = new Timestamp(System.currentTimeMillis());

		
		System.out.println("[게시글 " + word + "]");
		System.out.print(word + "할 게시글의 제목을 입력해주세요 >>> ");
		String title = scn.next();
		scn.nextLine();
		System.out.print(word + "할 게시글의 내용을 입력해주세요 (Enter를 치면 종료) >>> ");
		while(true) {
			String inputCon = scn.nextLine();
			contentArr.add(inputCon);
			if(inputCon.length()==0) {
				break;
			}
		}
		if (inPerson != null) {
			post = new Post(inPerson.getId(), ts, title, contentArr, -1);
			return post;
		}
		return null;

	}

	@Override
	public void logInfoSet(LogInfo newLog) { // 로그인 아이디를 클래스 내로 가져오기
		if (inPerson != null) {
			inPerson.setId(newLog.getId());
			inPerson.setPassword(newLog.getPassword());
		}
	}

	@Override
	public void add() { //추가
		Post post = changeBoard("추가");

		for (int i = 0; i < postArr.length; i++) {
			if (postArr[i] == null) {
				post.setPostNo(i); //changeBoard의 게시글 번호를 일괄로 -1처리 했기 때문에
				postArr[i] = post;
				System.out.println("게시글이 성공적으로 추가되었습니다!");
				return;
			}
		}
		System.out.println("[추가] 잘못된 입력입니다.");
	}

	@Override
	public void modify() { //수정
		
		System.out.print("수정할 게시글 번호를 입력해주세요 >>> ");
		int no = scn.nextInt();
		if (postArr[no] != null && postArr[no].getWriter().equals(inPerson.getId())) {
			Post post = changeBoard("수정");
			post.setPostNo(no);
			postArr[no] = post;
			System.out.println("성공적으로 수정되었습니다.");
			return;
		}
		System.out.println("사용자가 수정할 수 없는 게시글입니다.");

	}

	@Override
	public void delete() { //삭제
		System.out.println("삭제할 게시글 번호를 입력해주세요 >>> ");
		int no = scn.nextInt();
		if (postArr[no] != null && postArr[no].getWriter().equals(inPerson.getId())) {
			System.out.println("정말 삭제하시겠어요? (Y/N)");
			String ans = scn.next();
			if (ans.equalsIgnoreCase("y")) {
				postArr[no] = null;
				System.out.println("성공적으로 삭제되었습니다.");
			} else {
				System.out.println("삭제를 중지했습니다.");
				return;
			}
		} else {
			System.out.println("사용자가 삭제할 수 없는 게시글입니다.");
		}

	}

	@Override
	public void viewlist() { //목록 보기
		for (int i = 0; i < postArr.length; i++) {
			if (postArr[i] != null) {
				this.printPost(postArr[i]);
			}
		}
	}

	@Override
	public void searchWriter() { //작성자 검색
		System.out.print("검색할 작성자 이름 : ");
		String searchW = scn.next();
		for (int i = 0; i < postArr.length; i++) {
			if (postArr[i] != null && postArr[i].getWriter().equals(searchW)) {
				this.printPost(postArr[i]);
			}
		}
	}

}
