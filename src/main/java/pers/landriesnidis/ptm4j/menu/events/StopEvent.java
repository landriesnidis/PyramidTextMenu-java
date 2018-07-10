package pers.landriesnidis.ptm4j.menu.events;

public class StopEvent extends Event{
	private String keyword;
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
