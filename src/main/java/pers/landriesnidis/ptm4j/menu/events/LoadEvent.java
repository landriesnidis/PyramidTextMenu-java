package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.BaseTextMenu;

public class LoadEvent extends Event{
	private String keyword;
	private ActionType actionType;
	private String [] args;
	private BaseTextMenu menuContext;
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public BaseTextMenu getMenuContext() {
		return menuContext;
	}
	public void setMenuContext(BaseTextMenu menuContext) {
		this.menuContext = menuContext;
	}
}
