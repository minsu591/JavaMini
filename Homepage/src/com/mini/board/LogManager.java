package com.mini.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LogManager {
	List<LogInfo> logmanager = new ArrayList<LogInfo>();
	Scanner scn = new Scanner(System.in);
	private LogInfo newLog;
	
	public void login() {
		System.out.print("로그인 할 아이디를 입력해주세요 >>> ");
		String id = scn.next();
		System.out.print("로그인 할 비밀번호를 입력해주세요 >>> ");
		String passwd = scn.next();
		newLog = new LogInfo(id, passwd);
		
		if(logmanager.contains(newLog)) {
			
		}
	}

}
