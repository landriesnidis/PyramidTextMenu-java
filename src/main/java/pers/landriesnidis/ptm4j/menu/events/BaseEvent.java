package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class BaseEvent {
	private ISceneContext sceneContext;
	private String keyword;
	
	public BaseEvent(ISceneContext sceneContext) {
		this.sceneContext = sceneContext;
	}
	
	public ISceneContext getSceneContext() {
		return sceneContext;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
