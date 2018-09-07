package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.menu.TextMenu;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class LoadEvent extends Event{

	private ActionType actionType;
	private TextMenu previousMenu;
	
//	public LoadEvent() {}
//	public LoadEvent(ActionType actionType) {
//		this.actionType = actionType;
//	}
	
	public LoadEvent(ISceneContext context) {
		super(context);
	}
	
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
	public TextMenu getMenuContext() {
		return previousMenu;
	}
	public void setPreviousMenu(TextMenu previousMenu) {
		this.previousMenu = previousMenu;
	}
}
