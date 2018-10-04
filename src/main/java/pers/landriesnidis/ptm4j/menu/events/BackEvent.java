package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * 返回事件类型
 * @see BaseEvent
 * @author Landriesnidis
 */
public class BackEvent extends BaseEvent{

	private String[] args;
	private ActionType actionType = ActionType.BACK;
	
	public BackEvent(ISceneContext sceneContext) {
		super(sceneContext);
	}
	
	/**
	 * 获取参数数组
	 * @return 参数数组
	 */
	public String[] getArgs() {
		return args;
	}
	
	/**
	 * 设置参数数组
	 * @param args 参数数组
	 */
	public void setArgs(String[] args) {
		this.args = args;
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
