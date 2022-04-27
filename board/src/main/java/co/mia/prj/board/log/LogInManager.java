package co.mia.prj.board.log;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogInManager {
	// 후에 DB처리
	List<LogInfo> logmanager = new ArrayList<LogInfo>();

	private Scanner scn = new Scanner(System.in);
	private LogInfo newLog = null;
		
	public LogInfo login() {
		//test id
		logmanager.add(new LogInfo("hr", "hr"));

		System.out.print("로그인 할 아이디를 입력해주세요 >>> ");
		String id = scn.next();
		System.out.print("로그인 할 비밀번호를 입력해주세요 >>> ");
		String passwd = scn.next();
		newLog = new LogInfo(id, passwd);

		if (logmanager.contains(newLog)) {
			System.out.println("로그인에 성공하였습니다.");
			return newLog;
		}else {
			System.out.println("아이디 또는 비밀번호 입력이 잘못되었습니다.");
			return null;
		}
	}
	
}
