package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class BackEvent extends Event{

	private String[] args;
	private ActionType actionType = ActionType.BACK;
	
	public BackEvent(ISceneContext sceneContext) {
		super(sceneContext);
	}
	
	public String[] getArgs() {
		return args;
	}
	public void setArgs(String[] args) {
		this.args = args;
	}
	public ActionType getType() {
		return actionType;
	}
	public void setType(ActionType type) {
		this.actionType = type;
	}
}
