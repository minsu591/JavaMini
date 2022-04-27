package co.mia.prj.board.connection;

import java.util.InputMismatchException;
import java.util.Scanner;

import co.mia.prj.board.log.LogInManager;
import co.mia.prj.board.log.LogInfo;
import co.mia.prj.board.post.PostArray;
import co.mia.prj.board.post.PostManagerBase;

public class Connect {
	private LogInManager lm;
	private LogInfo inPerson; // 로그인한 사람
	private PostManagerBase posts;
	private Scanner scn = new Scanner(System.in);

	public boolean LogInRun() {
		while (true) {
			lm = new LogInManager();
			inPerson = lm.login();
			if (inPerson != null) {
				return true;
			}
		}
	}

	public void PostRun(boolean flag) {
		posts = new PostArray();
		posts.LogInfoSet(inPerson);
		int menu = 0;
		while (true) {
			System.out.println("================================================");
			System.out.println("1. 추가 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 작성자 검색 | 6. 종료");
			System.out.print("선택 >>> ");
			
			try {
				menu = scn.nextInt();
			} catch (InputMismatchException e) {
				scn.nextLine();
			}

			if (menu == 1) {
				posts.add();
			} else if (menu == 2) {
				posts.modify();
			} else if (menu == 3) {
				posts.delete();
			} else if (menu == 4) {
				posts.viewlist();
			} else if (menu == 5) {
				posts.searchWriter();
			} else if (menu == 6) {
				System.out.println("시스템을 종료합니다.");
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}
		scn.close();

	}

}
