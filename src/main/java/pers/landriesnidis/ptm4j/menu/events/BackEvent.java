package pers.landriesnidis.ptm4j.menu.events;

import java.awt.event.ActionEvent;
import java.io.ObjectInputStream.GetField;

import pers.landriesnidis.ptm4j.enums.ActionType;

public class BackEvent extends Event{
	private String keyword;
	private String[] args;
	private ActionType type = ActionType.BACK;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public ActionType getType() {
		return type;
	}
	public void setType(ActionType type) {
		this.type = type;
	}
}
