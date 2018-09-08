package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class LoadEvent extends BaseEvent{

	private ActionType actionType;
	
	public LoadEvent(ISceneContext sceneContext) {
		super(sceneContext);
	}
	
	public ActionType getActionType() {
		return actionType;
	}
	public void setActionType(ActionType actionType) {
		this.actionType = actionType;
	}
}
