package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class BaseEvent {
	private ISceneContext sceneContext;
	private String keyword;
	
	public BaseEvent(ISceneContext sceneContext) {
		this.sceneContext = sceneContext;
	}
	
	/**
	 * 获取Scene会话环境
	 * @return Scene会话环境
	 */
	public ISceneContext getSceneContext() {
		return sceneContext;
	}
	
	/**
	 * 获取上一次跳转时选择的Option的关键字
	 * 若上一次的跳转为强制跳转或TextMenu为RootMenu，返回的关键字为null
	 * @return 跳转时选择的Option的关键字
	 */
	public String getKeyword() {
		return keyword;
	}
	
	/**
	 * 设置跳转时选择的Option的关键字
	 * @param keyword 跳转时选择的Option的关键字
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
