package pers.landriesnidis.ptm4j.menu.events;

import pers.landriesnidis.ptm4j.scene.base.ISceneContext;

public class Event {
	private ISceneContext sceneContext;
	private String keyword;
	
	public Event(ISceneContext sceneContext) {
		this.sceneContext = sceneContext;
	}
	
	public ISceneContext getContext() {
		return sceneContext;
	}
	
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
