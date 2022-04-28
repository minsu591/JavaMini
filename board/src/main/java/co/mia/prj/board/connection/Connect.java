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
	private PostManagerBase posts = new PostArray();
	private Scanner scn = new Scanner(System.in);
	private boolean runCheck = true;

	public void Run() {
		while (runCheck) {
			logInRun(); // 이걸 거쳤다는건 로그인을 했다는거
			postRun();
		}

	}

	public void logInRun() {
		// 로그인 안하면 못 빠져나감
		while (true) {
			if (inPerson != null) { //로그아웃했다가 재로그인 하는 경우를 위해 다른 코드보다 위에 배치
				break;
			}
			lm = new LogInManager();
			inPerson = lm.login();
		}
	}

	public void postRun() {
		posts.logInfoSet(inPerson); // 로그인 정보 삽입
		int menu = 0;
		while (true) {
			System.out.println("================================================");
			System.out.println("1. 추가 | 2. 수정 | 3. 삭제 | 4. 목록 | 5. 작성자 검색 | 6. 로그아웃 | 7. 종료");
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
				System.out.println("로그아웃 하시겠습니까? (Y/N)");
				String ans = scn.next();
				if(ans.equalsIgnoreCase("y")) {
					inPerson = null;
					break;
				}

			} else if (menu == 7) {
				System.out.println("시스템을 종료합니다.");
				runCheck = false;
				break;
			} else {
				System.out.println("잘못된 입력입니다. 다시 시도해주세요.");
			}
		}

	}

}
