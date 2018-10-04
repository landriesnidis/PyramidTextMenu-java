package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.enums.ActionType;
import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

/**
 * 启动事件类型
 * @see BaseEvent
 * @see BaseEvent
 * @author Landriesnidis
 *
 */
public class StartEvent extends BaseEvent{
	
	private ActionType actionType;
	private String [] args;
	
	public StartEvent(ISceneContext sceneContext) {
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
