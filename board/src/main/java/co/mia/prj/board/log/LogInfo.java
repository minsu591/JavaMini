package co.mia.prj.board.log;

public class LogInfo {
	private String id;
	private String password;

	public LogInfo(String id, String password) {
		super();
		this.id = id;
		this.password = password;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LogInfo [id=" + id + ", password=" + password + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof LogInfo) {
			LogInfo l = (LogInfo) obj;
			if (l.getId().equals(this.id) && l.getPassword().equals(this.password)) {
				return true;
			}
		}
		return false;
	}
}
