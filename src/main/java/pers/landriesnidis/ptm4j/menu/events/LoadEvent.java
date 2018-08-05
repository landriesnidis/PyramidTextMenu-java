package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;

public class LoadEvent extends Event{
	private ActionType actionType;
	private String [] args;
	private TextMenu menuContext;
	
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
	public TextMenu getMenuContext() {
		return menuContext;
	}
	public void setMenuContext(TextMenu menuContext) {
		this.menuContext = menuContext;
	}
}
