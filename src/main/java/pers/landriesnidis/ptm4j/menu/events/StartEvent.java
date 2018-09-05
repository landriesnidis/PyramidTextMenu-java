package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;

public class StartEvent extends Event{
	private ActionType actionType;
	private String [] args;
	
	public StartEvent() {}
	public StartEvent(ActionType actionType) {
		this.actionType = actionType;
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
}
