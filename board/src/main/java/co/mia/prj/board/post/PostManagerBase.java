package co.mia.prj.board.post;

import co.mia.prj.board.log.LogInfo;

public interface PostManagerBase {
	public void logInfoSet(LogInfo newLog);
	public void add();
	public void modify();
	public void delete();
	public void viewlist();
	public void searchWriter();
}
