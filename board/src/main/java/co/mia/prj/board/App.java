package co.mia.prj.board;

import co.mia.prj.board.connection.Connect;

public class App {
	public static void main(String[] args) {
		Connect cn = new Connect();
		cn.Run();
		//재로그인하면 목록 자체가 리셋되는거 수정
		
	}
}
