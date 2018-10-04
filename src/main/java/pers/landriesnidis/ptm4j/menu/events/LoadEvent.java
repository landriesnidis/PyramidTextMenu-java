package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * 加载事件类型
 * @see BaseEvent
 * @author Landriesnidis
 *
 */
public class LoadEvent extends BaseEvent{

	private ActionType actionType;
	
	public LoadEvent(ISceneContext sceneContext) {
		super(sceneContext);
	}
	
	/**
	 * 获取动作类型
	 * @return 动作类型
	 */
	public ActionType getActionType() {
		return actionType;
	}
	
	/**
	 * 设置动作类型
	 * @param type 动作类型
	 */
	public void setActionType(ActionType type) {
		this.actionType = type;
	}
}
